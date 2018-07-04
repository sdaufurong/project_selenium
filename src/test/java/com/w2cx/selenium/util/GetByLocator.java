package com.w2cx.selenium.util;

import org.openqa.selenium.By;

public class GetByLocator {

    public static By getByLocator(String key){

        PropertiesHandle propertiesHandle = new PropertiesHandle("element.properties");
        String locationKey = propertiesHandle.getKey(key);
        String locatorType = locationKey.split(">")[0];
        String locatorValue = locationKey.split(">")[1];

        if(locatorType.equals("id")){
            return By.id(locatorValue);
        }else if (locatorType.equals("name")){
            return By.name(locatorValue);
        }else if(locatorType.equals("className")){
            return By.className(locatorValue);
        }else if(locatorType.equals("xpath")){
            //System.out.println("xpath:"+locatorValue);
            return By.xpath(locatorValue);
        }else if(locatorType.equals("linkText")){
            return  By.linkText(locatorValue);
        }else {
            System.out.println("未定位到元素！");
            return  null;

        }
    }

}
