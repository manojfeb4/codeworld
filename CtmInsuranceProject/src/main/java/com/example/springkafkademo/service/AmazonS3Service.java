package com.example.springkafkademo.service;

import com.amazonaws.services.s3.AmazonS3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




@Service
public class AmazonS3Service {

    private static Logger log = LoggerFactory.getLogger(AmazonS3Service.class);
    @Autowired
    static AmazonS3 s3 ;




    @Value("${insurance.config.userDetailsFile}")
    static String userDetailsFile;

    @Value("${insurance.config.addressDetailsFile}")
    static String addressDetailsFile;

    @Value("${insurance.config.userPoliciesFile}")
    static String userPoliciesFile;

    public static void s3Upload(){
        var currentDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        log.debug("currentDate : {}", currentDate);
        String bucket = "insurance-details";
        s3.putObject(bucket, "userDetails/" + currentDate + "/userDetails.csv", userDetailsFile );
        s3.putObject(bucket, "addressDetails/" + currentDate + "/addressDetails.csv", addressDetailsFile );
        s3.putObject(bucket, "userPolicies/" + currentDate + "/userPolicies.csv", userPoliciesFile );

    }
}
