package com.w2cx.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {

    //创建一个浏览器实例
    public WebDriver generateDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            return  driver;
        } else {
            System.setProperty("webdriver.firefox.marionette", "D:/java/geckodriver/geckodriver-v0.14.0-win64/geckodriver.exe");
           WebDriver fireFoxDriver = new FirefoxDriver();
           return fireFoxDriver;
        }
    }

}
