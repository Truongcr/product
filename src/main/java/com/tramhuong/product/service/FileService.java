package com.tramhuong.product.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String saveFile(MultipartFile multipartFile);

    String uploadFileToS3(MultipartFile multipartFile);
    String uploadFileToS3(String pathFile);
}
