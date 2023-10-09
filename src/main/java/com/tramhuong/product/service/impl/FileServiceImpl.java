package com.tramhuong.product.service.impl;

import com.tramhuong.common.utils.bases3.FileCommonUtils;
import com.tramhuong.product.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileCommonUtils fileCommonUtils;

    @Override
    public String saveFile(MultipartFile multipartFile) {
        return  fileCommonUtils.saveFileToLocal(multipartFile);
    }

    @Override
    public String uploadFileToS3(MultipartFile multipartFile) {
        return fileCommonUtils.uploadFileToS3(multipartFile);
    }

    @Override
    public String uploadFileToS3(String pathFile) {
        return FileCommonUtils.uploadFileToS3(pathFile);
    }
}
