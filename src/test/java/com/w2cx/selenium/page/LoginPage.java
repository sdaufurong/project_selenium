package com.w2cx.selenium.page;

import com.w2cx.selenium.base.DriverBase;
import org.openqa.selenium.WebElement;
import com.w2cx.selenium.util.GetByLocator;

public class LoginPage extends BasePage{

    public LoginPage(DriverBase driver){
        super(driver);
    }

    //打开登录页
    public void goToLoginPage(String url){
        to(url);
    }

    //获取用户名输入框
    public WebElement getUserNameElement(){
        WebElement element = element(GetByLocator.getByLocator("userName"));
        return  element;

    }

    //获取密码输入框
    public WebElement getPassWordElement(){
        WebElement element = element(GetByLocator.getByLocator("passWord"));
        return element;
    }

    //获取验证码输入框
    public WebElement getCodeElement(){
        WebElement element = element(GetByLocator.getByLocator("code"));
        return element;
    }

    //获取登录按钮
    public WebElement getLoginBtnElement(){
        WebElement element = element(GetByLocator.getByLocator("loginBtn"));
        return element;
    }

    //获取登录后首页显示的用户名
    public WebElement displayUsepagrName(){
        WebElement element = element(GetByLocator.getByLocator("userNameIsExist"));
        return element;
    }


    //窗口最大化
    public void windowMaxSize(){
        driver.manage();
    }

}
