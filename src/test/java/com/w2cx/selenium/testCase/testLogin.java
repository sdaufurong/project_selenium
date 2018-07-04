package com.w2cx.selenium.testCase;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.business.InformationManagePro;
import com.w2cx.selenium.business.LoginPro;
import com.w2cx.selenium.util.CookieHandle;
import okhttp3.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.util.Set;


public class testLogin extends CaseBase {
    public DriverBase driver;
    public LoginPro loginPro;
    public InformationManagePro informationManagePro;
    public CookieHandle cookieHandle;

    //log
    static Logger logger = Logger.getLogger(testLogin.class);


  /*  @BeforeClass
    public void beforeClass(){
        this.driver = initDriver("chrome");
        loginPro = new LoginPro(driver);
        informationManagePro = new InformationManagePro(driver);
        cookieHandle = new CookieHandle(driver);
    }
*/
    @Test
    @Parameters({"username","password","code"})
    public void testLogin(String username,String password,String code){

        loginPro.openHomePage("http://172.16.10.68:5050/#/login");
        loginPro.login(username,password,code);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(loginPro.isLoginSuccess(),"登录失败");
        logger.info("登录成功！");
        //获取cookie并将cookie写入配置文件中
        cookieHandle.getAndWriteCookie();


    }



}
