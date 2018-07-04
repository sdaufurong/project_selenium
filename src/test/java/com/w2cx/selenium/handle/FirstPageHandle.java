package com.w2cx.selenium.handle;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.page.FirstPage;
import org.openqa.selenium.WebElement;

public class FirstPageHandle {
    DriverBase driver;
    FirstPage firstPage;
   public FirstPageHandle(DriverBase driver){
        this.driver = driver;
        firstPage = new FirstPage(driver);
    }

    //获取登录用户名
    public boolean userNameSuccess(){
       WebElement element = firstPage.getLoginUserNameElement();
       return firstPage.elementIsExists(element);
    }





}
