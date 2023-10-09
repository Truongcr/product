package com.tramhuong.product.service;

import com.tramhuong.product.model.requestDTO.CategoryRequestDTO;
import com.tramhuong.product.model.responseDTO.CategoryResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryResponseDTO> createCategoryNew(CategoryRequestDTO categoryRequestDTO);

    List<CategoryResponseDTO> getCategoryById(UUID categoryId);

    List<CategoryResponseDTO> findAllCategory();
}
