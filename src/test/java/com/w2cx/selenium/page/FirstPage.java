package com.w2cx.selenium.page;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.util.GetByLocator;
import org.openqa.selenium.WebElement;

public class FirstPage extends BasePage{
    DriverBase driver;
    public FirstPage(DriverBase driver){
        super(driver);
    }

    //获取登录的用户名元素
    public WebElement getLoginUserNameElement(){
        WebElement element = element(GetByLocator.getByLocator("userNameIsExist"));
        return element;
    }




}
