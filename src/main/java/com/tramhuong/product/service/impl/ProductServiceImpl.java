package com.tramhuong.product.service.impl;

import com.tramhuong.common.utils.bases3.FileCommonUtils;
import com.tramhuong.product.entity.Category;
import com.tramhuong.product.entity.Product;
import com.tramhuong.product.entity.ProductCategory;
import com.tramhuong.product.entity.mapper.CategoryRequestMapper;
import com.tramhuong.product.entity.mapper.CategoryResponseMapper;
import com.tramhuong.product.entity.mapper.ProductRequestMapper;
import com.tramhuong.product.entity.mapper.ProductResponseMapper;
import com.tramhuong.product.model.ProductRequestDTO;
import com.tramhuong.product.model.ProductResponseDTO;
import com.tramhuong.product.repository.CategoryRepository;
import com.tramhuong.product.repository.ProductCategoryRepository;
import com.tramhuong.product.repository.ProductRepository;
import com.tramhuong.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private final ProductRequestMapper productRequestMapper;

    private final ProductResponseMapper productResponseMapper;

    private final CategoryRepository categoryRepository;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;
    private final ProductCategoryRepository productCategoryRepository;


    private final FileCommonUtils fileCommonUtils;

    @Override
    public List<ProductResponseDTO> createProductNew(ProductRequestDTO productRequestDTO) throws IOException {

        Optional<Category> categoryOptional = categoryRepository.findById(productRequestDTO.getCategoryId().get(0));
        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Category is not ....");
        }
        Category category = categoryOptional.get();
        Product product = productRequestMapper.toEntity(productRequestDTO);

        File file = convertMultiPartToFile(productRequestDTO.getPathFile());

        String localFileName = file.getName();
        String fileName = fileCommonUtils.generateFileName(localFileName);
        String fileUrl = fileCommonUtils.generateUrl(fileName);
        fileCommonUtils.uploadFileToS3(fileName, file);

        product.setImage(fileUrl);
        productRepository.save(product);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setProduct(product);
        productCategory.setCategory(category);
        productCategoryRepository.save(productCategory);
        return productResponseMapper.toDtoList(productRepository.findAll());
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        return productResponseMapper.toDtoList(productRepository.findAll());
    }

    @Override
    public List<ProductResponseDTO> findByCategoryId(UUID categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return productResponseMapper.toDtoList(products);
    }

    public File convertMultiPartToFile(String path) throws IOException {
        File convFile = new File(path);
        Path paths = Paths.get(path);
        byte[] data = Files.readAllBytes(paths);
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(data);
        fos.close();
        return convFile;
    }
}
