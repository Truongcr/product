//package com.tramhuong.product.controller;
//
////import com.tramhuong.product.entity.Product;
//
//import com.tramhuong.product.model.ProductResponseDTO;
//import com.tramhuong.product.service.ProductService;
//import com.tramhuong.product.service.impl.AWSClient;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.apache.tomcat.util.file.ConfigurationSource;
//import org.springframework.beans.factory.annotation.Value;
////import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping(("/api/product/"))
//@AllArgsConstructor
//public class DemoController {
//
//    private final ProductService productService;
//    private final AWSClient amazonClient;
//
//    @PostMapping("/uploadFile")
//    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
//        return amazonClient.uploadFile(file);
//    }
//
//    @GetMapping("/dowload-file")
//    public byte[] dowloadFile(@RequestParam String path) throws IOException {
//        return amazonClient.downloadFileFromS3(path);
//    }
//
//}
