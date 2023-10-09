package com.tramhuong.product.service.impl;

import com.tramhuong.product.entity.Category;
import com.tramhuong.product.entity.mapper.CategoryRequestMapper;
import com.tramhuong.product.entity.mapper.CategoryResponseMapper;
import com.tramhuong.product.model.requestDTO.CategoryRequestDTO;
import com.tramhuong.product.model.responseDTO.CategoryResponseDTO;
import com.tramhuong.product.repository.CategoryRepository;
import com.tramhuong.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;
    @Override
    public List<CategoryResponseDTO> createCategoryNew(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryRequestMapper.toEntity(categoryRequestDTO);
        categoryRepository.save(category);
        return categoryResponseMapper.toDtoList(categoryRepository.findAll());
    }

    @Override
    public List<CategoryResponseDTO> getCategoryById(UUID categoryId) {
        return null;
    }

    @Override
    public List<CategoryResponseDTO> findAllCategory() {
        return categoryResponseMapper.toDtoList(categoryRepository.findAll());
    }
}
