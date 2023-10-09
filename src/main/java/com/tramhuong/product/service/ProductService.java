package com.tramhuong.product.service;

import com.tramhuong.product.model.ProductRequestDTO;
import com.tramhuong.product.model.ProductResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductResponseDTO> createProductNew(ProductRequestDTO productRequestDTO) throws IOException;
    List<ProductResponseDTO> getAll();

    List<ProductResponseDTO> findByCategoryId(UUID categoryId);
}
