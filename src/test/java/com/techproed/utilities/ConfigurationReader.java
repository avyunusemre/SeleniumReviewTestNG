package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;
    static {

        String path = "C:\\Users\\deuav\\IdeaProjects\\SeleniumReviewTestNG\\configuration.properties";

        try{
            //okumak istediğiniz dosyanın, dosya yolunu göndermemiz gerekiyor.
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {

        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);
        return value;
    }
}
