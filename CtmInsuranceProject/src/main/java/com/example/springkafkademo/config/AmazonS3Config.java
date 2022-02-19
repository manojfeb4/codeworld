package com.example.springkafkademo.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3Config {

    @Value("${aws.accessKey}")
    String awsAccessKey;

    @Value("${aws.secretKey}")
    String awsSecretKey;

    @Value("${aws.region}")
    String awsRegion;

    @Bean
    public AmazonS3 s3() {

        AWSCredentials awsCredentials =
                new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(awsRegion)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }
}