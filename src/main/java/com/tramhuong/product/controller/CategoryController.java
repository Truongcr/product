package com.tramhuong.product.controller;


import com.tramhuong.product.model.requestDTO.CategoryRequestDTO;
import com.tramhuong.product.model.responseDTO.CategoryResponseDTO;
import com.tramhuong.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product/category/")
@AllArgsConstructor
@CrossOrigin
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("get-all")
    public ResponseEntity<List<CategoryResponseDTO>> findAllCategory() {
        return new ResponseEntity<>(categoryService.findAllCategory(), HttpStatus.OK);
    }

    @PostMapping("create-category")
    public ResponseEntity<List<CategoryResponseDTO>> createCategoryNew(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return new ResponseEntity<>(categoryService.createCategoryNew(categoryRequestDTO), HttpStatus.OK);
    }
}
