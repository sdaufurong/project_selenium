package com.w2cx.selenium.util;

import com.w2cx.selenium.base.DriverBase;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class CookieHandle {

    PropertiesHandle propertiesHandle;
    DriverBase driver;
    public CookieHandle(DriverBase driver){
        this.driver = driver;
        propertiesHandle = new PropertiesHandle("cookie.properties");
    }


    //获取cookie并将cookie写入配置文件
    public void getAndWriteCookie(){
        Set<Cookie> cookies = driver.getCookie();
        for(Cookie cookie:cookies){
           /* if(cookie.getName().equals("JSESSIONID")){
                propertiesHandle.writeProperties(cookie.getName(),cookie.getValue());
            }*/
            System.out.println(cookie.getName());
        }
    }


    //设置cookie
    public void setCookie(){
        String key = "JSESSIONID";
       String value = propertiesHandle.getKey(key);
       //新建一个cookie
       Cookie cookie = new Cookie(key,value,"172.16.10.68","/",null);
       driver.setCookie(cookie);

    }


}
