package com.ctm.insurance;


import com.amazonaws.services.s3.AmazonS3;
import com.ctm.insurance.config.AmazonS3Config;
import com.ctm.insurance.service.AmazonS3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class S3UploadProcess {
    private static Logger log = LoggerFactory.getLogger(S3UploadProcess.class);


      public static void main(String [] args) throws IOException {
          //System.setProperty("propFile", "src/main/resources/aws.properties");
          Properties prop = new Properties();
          prop.load(new FileInputStream(System.getProperty("propFile")));
          log.debug("dirPath : {}", prop.getProperty("dirPath"));
          ApplicationContext context = new AnnotationConfigApplicationContext(AmazonS3Config.class);
          AmazonS3 s3 = (AmazonS3) context.getBean(AmazonS3.class);
          new AmazonS3Service().s3Upload(s3, prop);
          SpringApplication.exit(context, () -> 0);


    }
}
