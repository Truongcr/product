package com.tramhuong.product.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {

    private UUID productId;
    private String productName;
    private String productTitle;
    private String image;
    private BigDecimal price;
    private UUID categoryId;
    private String categoryName;
}
