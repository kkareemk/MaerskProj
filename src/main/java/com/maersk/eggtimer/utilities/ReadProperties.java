package com.maersk.eggtimer.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public static String readProperties(String propertyName) throws FileNotFoundException {
        Properties prop= new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")+ File.separator+"src/test/properties/common.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }
}
