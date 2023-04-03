package br.edu.infnet.al.receitafacil.model.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class AmazonS3Service {
    @Value("${aws.access.key}")
    private String accessKey;
 
    @Value("${aws.secret.key}")
    private String secretKey;
 
    @Value("${aws.region}")
    private String region; 

    public String uploadImage(String bucketName, String keyName, File file) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3 = AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
        try {
            s3.putObject(bucketName, "usuarios/" + keyName, file);
            return "https://receitafacil.s3.us-east-2.amazonaws.com/usuarios/" + keyName;
        } catch(Exception e) {
            System.out.println(e);
            return "https://receitafacil.s3.us-east-2.amazonaws.com/usuarios/usuario_0.png";
        }
    }

    public String uploadImage(String bucketName, String keyName, MultipartFile file, ObjectMetadata meta) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3 = AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        try {
            InputStream stream = new BufferedInputStream(file.getInputStream());
            s3.putObject(bucketName, "usuarios/" + keyName, stream, meta);
            return "https://receitafacil.s3.us-east-2.amazonaws.com/usuarios/" + keyName;
        } catch(Exception e) {
            System.out.println(e);
            return "https://receitafacil.s3.us-east-2.amazonaws.com/usuarios/usuario_0.png";
        }
    }
}