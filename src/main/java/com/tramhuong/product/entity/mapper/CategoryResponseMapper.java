package com.tramhuong.product.entity.mapper;

import com.tramhuong.product.entity.Category;
import com.tramhuong.product.model.responseDTO.CategoryResponseDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryResponseMapper extends EntityMapper<CategoryResponseDTO, Category> {

}
