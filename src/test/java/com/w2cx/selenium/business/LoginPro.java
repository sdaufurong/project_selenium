package com.w2cx.selenium.business;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.handle.FirstPageHandle;
import com.w2cx.selenium.handle.LoginPageHandle;

public class LoginPro {
    DriverBase driver;
    LoginPageHandle loginPageHandle;
    FirstPageHandle firstPageHandle;


   public LoginPro(DriverBase driver){
       this.driver = driver;
       loginPageHandle = new LoginPageHandle(driver);
       firstPageHandle = new FirstPageHandle(driver);

   }

   public void openHomePage(String url){
       loginPageHandle.toLoginPage(url);
   }

   public  void login(String username,String password,String code){

       if(loginPageHandle.assertLoginPage()){
           loginPageHandle.sendUserName(username);
           loginPageHandle.sendPassWord(password);
           loginPageHandle.sendCode(code);
           loginPageHandle.clickLoginBtn();
           loginPageHandle.maxWindowSize();

       }else {
           System.out.println("登录页未打开或元素不存在！");
       }

   }

   public boolean isLoginSuccess(){
       return firstPageHandle.userNameSuccess();
   }



  /*  public static void main(String[] args) {
       DriverBase driverBase = new DriverBase("chrome");
        LoginPro loginPro = new LoginPro(driverBase);
        loginPro.openHomePage("http://172.16.10.68:5050/#/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPro.login("15110039071","039071","1111");
    }*/


}
