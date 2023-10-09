package com.tramhuong.product.entity.mapper;

import com.tramhuong.product.entity.Product;
import com.tramhuong.product.model.ProductResponseDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductResponseMapper extends EntityMapper<ProductResponseDTO, Product> {
}
