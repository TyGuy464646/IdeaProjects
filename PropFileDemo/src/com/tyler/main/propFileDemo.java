package com.tyler.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class propFileDemo {

    public static void main(String[] args) throws Exception{
        makePropFile("v3","622");
        String value = readPropFile("someOtherProper");
        System.out.println(value);
        String value2 = readPropFile("v3");
        System.out.println(value2);
    }

    static void makePropFile(String key, String value) throws Exception{

        File file = new File("./settings.properties");
        FileOutputStream fos = new FileOutputStream(file);
        Properties prop = new Properties();
        prop.setProperty("someColor", value);
        prop.store(fos, null);

    }

    static String readPropFile(String key) throws Exception{
        File file = new File("./settings.properties");
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty("someColor");
        return value;

    }

}
