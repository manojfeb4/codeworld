package com.ctm.insurance.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.ctm.insurance.service.AmazonS3Service;
import com.ctm.insurance.util.YamlPropertySourceFactory;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class AmazonS3Config {
    private static Logger log = LoggerFactory.getLogger(AmazonS3Config.class);



    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Bean
    public AmazonS3 s3() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(System.getProperty("propFile")));
        String awsAccessKey = prop.getProperty("accessKey");
        String awsSecretKey = prop.getProperty("secretKey");
        String region = prop.getProperty("region");
        AWSCredentials awsCredentials =
                new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }
}