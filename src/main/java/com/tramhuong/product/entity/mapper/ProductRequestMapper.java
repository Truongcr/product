package com.tramhuong.product.entity.mapper;

import com.tramhuong.product.entity.Product;
import com.tramhuong.product.model.ProductRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper extends EntityMapper<ProductRequestDTO, Product> {
}
