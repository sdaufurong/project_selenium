package com.w2cx.selenium.testCase;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.business.InformationContentPro;
import com.w2cx.selenium.business.InformationManagePro;
import com.w2cx.selenium.business.LoginPro;
import org.testng.annotations.*;


public class CaseBase {

    //page定义
    public static DriverBase driver = null;
    LoginPro loginPro;
    InformationManagePro informationManagePro;
    InformationContentPro icp;

    @BeforeSuite

    @BeforeClass
    @Parameters({"username","password","code","driverName"})
    public void setUp(String username,String password,String code,String driverName){

        //生成浏览器driver
        driver = new DriverBase(driverName);

        //初始化页面
        loginPro = new LoginPro(driver);
        informationManagePro = new InformationManagePro(driver);
        icp = new InformationContentPro(driver);


        //登录
        loginPro.openHomePage("http://172.16.10.68:5050/#/login");
        loginPro.login(username,password,code);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /*cookieHandle = new CookieHandle(driver);
        informationManagePro.gotoInformationManage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //设置cookie
        cookieHandle.setCookie();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       /* informationManagePro.gotoInformationManage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }


    @AfterClass
    public void tearDown(){
        driver.stopDriver();
    }


   /* @AfterSuite
    public void afterSuite(){
        SendEmail1.sendToEmail();
    }*/


}
