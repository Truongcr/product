package com.tramhuong.product.model;

import com.tramhuong.product.entity.Category;
import com.tramhuong.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO {

    private UUID productId;
    private Product product;
    private Category category;
}
