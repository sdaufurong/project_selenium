package com.w2cx.selenium.base;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverBase{
   public static WebDriver driver;
    public DriverBase(String browserName){
        SelectDriver selectDriver = new SelectDriver();
        driver = selectDriver.generateDriver(browserName);
    }



    /***
     * 封装driver关闭方法
     * */
    public  void stopDriver(){
        driver.close();
    }

    /**
     *
     * 封装driver获取单元素方法
     * **/

    public WebElement findElement(By by){
        WebElement element = driver.findElement(by);
        return element;
    }


    //封装driver获取元素列表的方法
    public List<WebElement> findElements(By by){
        List<WebElement> list = driver.findElements(by);
        return  list;
    }


    //封装driver截图方法
/*
    public void takeScreenShot(){
     */
/*   //获取当前路径
        String currentPath = System.getProperty("user.dir");
        //设定时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间并按指定格式展示
        String date = simpleDateFormat.format(new Date());
        //根据“工程目录+时间戳+png”格式拼接截图路径
        String imgPath = currentPath+"_"+date+".png";
        System.out.println("截图为："+imgPath);

        //调用截图方法
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //保存截图
        try {
            FileUtils.copyFile(srcFile,new File(imgPath));
        } catch (IOException e) {
            System.out.println("截图保存异常！");
            e.printStackTrace();
        }
*//*

        long date = System.currentTimeMillis();
        String dat = String.valueOf(date);
        String currentPath = System.getProperty("user.dir");
        String path = currentPath+"/"+dat+".png";
         File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
*/


    //封装driver的点击方法
    public void click(WebElement element){
        element.click();
    }

    //封装driver的get方法
    public  void  get(String url){
        driver.get(url);
    }

    //封装driver的窗口最大化方法
    public void manage(){
        driver.manage().window().maximize();
    }


    //获取cookie方法
    public  Set<Cookie>  getCookie(){
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }


    //设置cookie方法
    public void setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }



    //强制刷新方法
    public void refresh(){
        Actions ctrl = new Actions(driver);
        ctrl.keyDown(Keys.CONTROL).perform();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F5);
            ctrl.keyUp(Keys.CONTROL).perform();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }



    //全局隐式等待
    public void wait(int second){
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }


  /*  public static void main(String[] args) {
        DriverBase driverBase = new DriverBase("chrome");
        driverBase.takeScreenShot();
    }*/


}
