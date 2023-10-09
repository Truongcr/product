package com.tramhuong.product.entity.mapper;

import com.tramhuong.product.entity.Category;
import com.tramhuong.product.model.requestDTO.CategoryRequestDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryRequestMapper extends EntityMapper<CategoryRequestDTO, Category> {
}
