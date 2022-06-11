package com.demoqa.qa.utils;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
// This class reads properties file
public class ConfigReader {
    Properties prop;

    public ConfigReader() {
        File src = new File(System.getProperty("user.dir")+ "/src/main/java/com/demoqa/qa/config/config.properties");
        try(FileInputStream fis = new FileInputStream(src)){
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getUrl(){
        return prop.getProperty("url");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }
}