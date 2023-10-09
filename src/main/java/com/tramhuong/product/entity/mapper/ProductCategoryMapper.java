package com.tramhuong.product.entity.mapper;

import com.tramhuong.product.entity.ProductCategory;
import com.tramhuong.product.model.ProductCategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends EntityMapper<ProductCategoryDTO, ProductCategory>{
}
