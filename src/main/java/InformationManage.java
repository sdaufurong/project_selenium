import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InformationManage {

    WebDriver driver;
    int num;
    public void  initDriver(){
        System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        //窗口最大化
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        driver = new ChromeDriver();
    }


    public  void logIn(){
        //打开登录页
        driver.get("http://172.16.10.68:5050/#/login");
        //检查各元素是否正常显示
        WebElement userName = driver.findElement(By.id("loginName"));
        System.out.println("用户名输入框是否显示："+userName.isDisplayed());

        WebElement passWord = driver.findElement(By.id("pwd"));
        System.out.println("密码输入框是否显示："+passWord.isDisplayed());

        WebElement code = driver.findElement(By.id("code"));
        System.out.println("验证码是否显示："+code.isDisplayed());

        WebElement loginBtn = driver.findElement(By.className("ant-btn"));
        System.out.println("登录按钮是否显示："+loginBtn.isDisplayed());

        //登录
        userName.sendKeys("15110039071");
        passWord.sendKeys("039071");
        code.sendKeys("1111");
        loginBtn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //窗口最大化
        driver.manage().window().maximize();
        //判断是否登录成功
        driver.findElement(By.className("user-avatar")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<WebElement> list = driver.findElements(By.className("ant-row"));
       /* System.out.println(list.size());

        for(WebElement element:list){
            System.out.println(element.getText());
        }*/


        String name = list.get(1).getText();
        System.out.println(name);
        if(name.toString().contains("苑书荣")){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }



    }


    public void informationManage(){

        List<WebElement> menu_list = driver.findElements(By.className("ant-menu-submenu-inline"));
        System.out.println(menu_list.size());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击“资讯管理”
        menu_list.get(0).click();

        List<WebElement> information_list = driver.findElements(By.className("ant-menu-item"));
        System.out.println(information_list.size());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击“资讯分类”
        /*information_list.get(0).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //搜索框输入“美食”
        driver.findElement(By.id("name")).sendKeys("美食");*/

        //点击“搜索”按钮

        //driver.findElement(By.className("ant-btn-lg")).click();
        //driver.findElement(By.xpath("//button[contains(@class,'ant-btn-lg')]")).click();


       /* List<WebElement> btn_list = driver.findElements(By.className("ant-btn"));
        System.out.println(btn_list.size());
        for(WebElement element:btn_list){
            System.out.println(element.getText());
        }

        btn_list.get(1).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //搜索结果列表
        //List<WebElement> childNode_list = driver.findElements(By.className("left"));

        //System.out.println(childNode_list.get(1).getText());

      /*  if(childNode_list.get(1).getText().contains("美食")){
            System.out.println("搜索正确！");
        }else {
            System.out.println("搜索错误！");
        }*/


      //点击“资讯内容”
        information_list.get(1).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //点击“添加”
       // driver.findElement(By.xpath(".//button[contains(@class,'crumb-btn')]")).click();


        //点击“添加”按钮
       /* List<WebElement> btn_list = driver.findElements(By.className("ant-btn"));
        btn_list.get(0).click();
        //"添加"对话框
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        //输入“分类名称”

        //切换到模态对话框
        //定位“分类名称”输入框
    /*    driver.switchTo().activeElement();
        List<WebElement> input_list = driver.findElements(By.xpath(".//*[@id='name']"));
        for(WebElement element:input_list){
            System.out.println(element.getText());
        }
        //输入分类名称
        input_list.get(1).sendKeys("nnn");

        //点击“保存”按钮
        driver.findElement(By.xpath("html/body//form//div/div/div/div/button")).click();
*/
        //强制刷新页面
      /*  Actions ctrl = new Actions(driver);
        ctrl.keyDown(Keys.CONTROL).perform();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F5);
            ctrl.keyUp(Keys.CONTROL).perform();
        } catch (AWTException e) {
            e.printStackTrace();
        }*/
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //获取mmm元素的下标
       /*ArrayList<WebElement> categoryList = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id='content']//div[@class='ant-table-body']//tr[contains(@class,'ant-table-row-level-0')]"));
        System.out.println("已添加分类："+categoryList.size());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = "mmm";

       for (int i=0;i<categoryList.size();i++){
           System.out.println("进入循环");
           WebElement element = categoryList.get(i);
           System.out.println("分类名称："+element.getText());
           if(element.getText().contains(s)){
               System.out.println("进入判断");
               num = i;
               System.out.println("num:"+num);
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               element.findElement(By.xpath(".//a[3]")).click();
               break;
           }
       }*/

        //点击“添加”按钮
        //driver.findElement(By.xpath(".//button[contains(@class,'crumb-btn')]")).click();
      /*  try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        //输入资讯标题
        driver.findElement(By.id("title")).sendKeys("旅游资讯");

        //点击资讯分类
        driver.findElement(By.xpath("//div[@id='content']//div[@class='ant-select-selection__rendered']")).click();

        //选择资讯分类
        List<WebElement> select_list = driver.findElements(By.xpath("//li[@class='ant-select-dropdown-menu-item']"));
        System.out.println("资讯分类选项共有："+select_list.size());
        for (WebElement element:select_list){
            System.out.println(element.getText());
        }
        select_list.get(0).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> list = driver.findElements(By.className("ant-btn-lg"));
        for (WebElement element:list){
            System.out.println(element.getText());
        }

        list.get(1).click();*/


        //点击第一条内容对应的“去审核”按钮
        driver.findElement(By.xpath(".//div[@class='ant-table-body']//tr[contains(@class,'ant-table-row-level-0')][1]//a")).click();







    }

    public static void main(String[] args) {
       /* Login login = new Login();
        login.initDriver();*/
       /* System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://172.16.10.68:5050/#/login");*/

     /*   System.out.println("hello");
        System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");*/

        InformationManage login = new InformationManage();
        login.initDriver();
        login.logIn();
        login.informationManage();

    }









}
