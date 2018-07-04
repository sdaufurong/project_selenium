package com.w2cx.selenium.handle;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.page.LoginPage;
import org.openqa.selenium.WebElement;

public class LoginPageHandle {
    public DriverBase driver;
    LoginPage loginPage;
    public LoginPageHandle(DriverBase driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }
    //跳转到登录页
    public void toLoginPage(String url){
        loginPage.to(url);
    }

    //对用户名进行输入操作
    public void sendUserName(String username){
        loginPage.sendKeys(loginPage.getUserNameElement(),username);
    }

    //输入密码
    public void sendPassWord(String password){
        loginPage.sendKeys(loginPage.getPassWordElement(),password);
    }

    //输入验证码
    public void sendCode(String code){
        loginPage.sendKeys(loginPage.getCodeElement(),code);
    }

    //点击登录按钮
    public  void clickLoginBtn(){
        loginPage.click(loginPage.getLoginBtnElement());
    }

    //窗口最大化
    public void maxWindowSize(){
        loginPage.windowMaxSize();
    }


    //判断登录页中元素是否正常显示
    public boolean assertLoginPage(){
       return loginPage.elementIsExists(loginPage.getUserNameElement());
    }




}
