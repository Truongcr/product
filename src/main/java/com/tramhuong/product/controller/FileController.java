package com.tramhuong.product.controller;


import com.tramhuong.product.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/product/")
@AllArgsConstructor
@CrossOrigin
public class FileController {

    private final FileService fileService;

    @PostMapping("upload-file-to-local")
    public String uploadFileToLocal(@RequestPart(value = "file") MultipartFile multipartFile) {
        return fileService.saveFile(multipartFile);
    }

    @PostMapping("upload-file-to-s3")
    public String uploadFileToS3(@RequestPart(value = "file") MultipartFile file) {
        return fileService.uploadFileToS3(file);
    }

    @GetMapping("upload-file-to-s3")
    public String uploadFileToS3(@RequestParam String pathFile) {
        return fileService.uploadFileToS3(pathFile);
    }
}
