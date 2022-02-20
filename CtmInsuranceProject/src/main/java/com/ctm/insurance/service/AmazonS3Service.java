package com.ctm.insurance.service;

import com.amazonaws.services.s3.AmazonS3;
import com.ctm.insurance.config.AmazonS3Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;


@Service

public class AmazonS3Service {

    private static Logger log = LoggerFactory.getLogger(AmazonS3Service.class);








    public void s3Upload(AmazonS3 s3, Properties prop){
        var dirPath = prop.getProperty("dirPath");

        var currentDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE).replaceAll("-","");
        log.debug("currentDate : {}", currentDate);
        var insuranceFiles = new File(dirPath).listFiles( (dir, name) -> name.endsWith(".csv"));

        log.debug("dirPath : {}", dirPath);
        String bucket = "insurance-details";
        for(File fileName : insuranceFiles){
            var filePart = fileName.getName().replaceAll(".csv","");
            log.debug("fileName : {} " + filePart);
            s3.putObject( bucket, filePart + "/" + currentDate + "/" + fileName.getName(), fileName.getAbsoluteFile() );
        }

    }
}
