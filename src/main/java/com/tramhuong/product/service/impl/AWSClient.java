//package com.tramhuong.product.service.impl;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.PutObjectRequest;
////import lombok.Value;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.model.S3ObjectInputStream;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.PostConstruct;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Calendar;
//import java.util.Date;
//
//@Service
//public class AWSClient {
//
////7133106143@st.apd.edu.vn
//    private AmazonS3 s3client;
//
//    @Value("${amazonProperties.endpointUrl}")
//    private String endpointUrl;
//    @Value("${amazonProperties.bucketName}")
//    private String bucketName;
//    @Value("${amazonProperties.accessKey}")
//    private String accessKey;
//    @Value("${amazonProperties.secretKey}")
//    private String secretKey;
//
//
//    @PostConstruct
//    private void initializeAmazon() {
//        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
//        this.s3client = new AmazonS3Client(credentials);
//    }
//
//    private void uploadFileTos3bucket(String fileName, File file) {
//        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
//                .withCannedAcl(CannedAccessControlList.PublicRead));
//    }
//
//    public String uploadFile(MultipartFile multipartFile) {
//
//        String fileUrl = "";
//        try {
//            File file = convertMultiPartToFile(multipartFile);
//            String fileName = "image/" + generateFileName(multipartFile);
//            fileUrl = endpointUrl + "/" + bucketName + fileName;
//            uploadFileTos3bucket(fileName, file);
//            file.delete();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fileUrl;
//    }
//
//    private File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
//        File convFile = new File(multipartFile.getOriginalFilename());
//        FileOutputStream fos = new FileOutputStream(convFile);
////        FileInputStream fileInputStream = new FileInputStream(multipartFile.getOriginalFilename());
//        fos.write(multipartFile.getBytes());
//        fos.close();
//        return convFile;
//    }
//
//    private String generateFileName(MultipartFile multipartFile) {
//        return new Date().getTime() + "-" + multipartFile.getOriginalFilename().replace(" ", "_");
//    }
//
//    public byte[] downloadFileFromS3(String path) throws IOException {
//        try {
//            S3Object s3Object = s3client.getObject(bucketName, path);
//            S3ObjectInputStream inputStream = s3Object.getObjectContent();
//
//
//            long timeMillis = Calendar.getInstance().getTimeInMillis();
//            String localPath = System.getProperty("java.io.tmpdir") + File.separator + Thread.currentThread().getId() + File.separator + timeMillis;
//            File localPathFile = new File(localPath);
//            localPathFile.getParentFile().mkdirs();
//
//            FileOutputStream outputStream = new FileOutputStream(localPath);
//            IOUtils.copy(inputStream, outputStream);
//
//            byte[] byteArray = FileCopyUtils.copyToByteArray(localPathFile);
////            Files.delete(localPathFile.toPath());
//            return byteArray;
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Xử lý lỗi tại đây nếu cần
//            throw new IOException("ddd");
//        }
//    }
//}
