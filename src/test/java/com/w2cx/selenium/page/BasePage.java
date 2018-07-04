package com.w2cx.selenium.page;

import com.w2cx.selenium.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

//封装页面通用的获取元素及元素操作的方法
public class BasePage {
    DriverBase driver;
    BasePage(DriverBase driver){
        this.driver = driver;
    }

    //在页面封装页面跳转方法
    public void to(String url){
        driver.get(url);
    }


    //在页面封装获取单个element方法
    public WebElement element(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    //在页面封装获取元素列表方法
    public List<WebElement> elements(By by){
        List<WebElement> list = driver.findElements(by);
        return  list;
    }


    //在页面封装点击方法
    public  void click(WebElement element){
        if(element != null){
            element.click();
        }else {
            System.out.println("元素："+element+"不存在！");
        }
    }


    //在页面封装输入方法
    public void sendKeys(WebElement element,String inputText){
        if(element != null){
            element.sendKeys(inputText);
        }else {
            System.out.println("元素:"+element+"不存在！");
        }
    }


    //在页面封装判断某元素是否存在方法
    public boolean elementIsExists(WebElement element){
       return element.isDisplayed();
    }


    //在页面封装窗口最大化方法
    public void windowMaxSize(){
        driver.manage();
    }


    //隐式等待
    public void waitSecond(int second){
        driver.wait(second);
    }



}
