package com.tramhuong.product.controller;


import com.tramhuong.product.model.ProductRequestDTO;
import com.tramhuong.product.model.ProductResponseDTO;
import com.tramhuong.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/product/")
@AllArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;


    @PostMapping("create-product")
    public ResponseEntity<List<ProductResponseDTO>> createProductNew(@RequestBody ProductRequestDTO productRequestDTO) throws IOException {
        return new ResponseEntity<>(productService.createProductNew(productRequestDTO), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<ProductResponseDTO>> createProductNew() throws IOException {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping("create-product1")
    public ResponseEntity<byte[]> createProductNew1(@RequestBody ProductRequestDTO productRequestDTO) throws IOException {
        Path path = Paths.get(productRequestDTO.getPathFile());

        byte[] data = Files.readAllBytes(path);
//        File convFile = new File(productRequestDTO.getPathFile());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @GetMapping("find-by-category-id")
    public ResponseEntity<List<ProductResponseDTO>> findByCategoryId(@RequestParam UUID categoryId) throws IOException {
        return new ResponseEntity<>(productService.findByCategoryId(categoryId), HttpStatus.OK);
    }
}
