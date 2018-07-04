package com.w2cx.selenium.util;

import java.io.*;
import java.util.Properties;

public class PropertiesHandle {

    String filePath;
    Properties properties;

    //构造方法
    public PropertiesHandle(String filePath){

        this.filePath = filePath;
        this.properties = getProperties();

    }

    //获取已经读取了配置文件的properties
    public Properties getProperties(){
        Properties properties = new Properties();

        try {
            InputStream inputStream = new FileInputStream(filePath);
            BufferedInputStream in = new BufferedInputStream(inputStream);
            properties.load(in);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  properties;
    }

    //在配置文件中根据key获取value
    public String getKey(String key){

        return properties.getProperty(key);
    }


    //写配置文件
    public void writeProperties(String key,String value){
        Properties pro = new Properties();
        try {
            FileOutputStream file = new FileOutputStream(filePath);
            //写入key和value
            pro.setProperty(key,value);
            pro.store(file,key);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    /*public static void main(String[] args) {

        PropertiesHandle propertiesHandle = new PropertiesHandle("element.properties");
        System.out.println(propertiesHandle.getKey("userName"));

    }*/


}
