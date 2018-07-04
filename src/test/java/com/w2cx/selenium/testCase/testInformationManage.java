package com.w2cx.selenium.testCase;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.business.InformationManagePro;
import com.w2cx.selenium.business.LoginPro;
import com.w2cx.selenium.util.CookieHandle;
import org.testng.Assert;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testInformationManage extends CaseBase{
    //LoginPro loginPro;
    //InformationManagePro informationManagePro;
    CookieHandle cookieHandle;
    DriverBase driver;
    static Logger logger = Logger.getLogger(testInformationManage.class);

   /*@BeforeClass
   @Parameters({"username","password","code","driverName"})
    public void beforeClass(String username,String password,String code,String driverName){
        this.driver = initDriver(driverName);



        //登录
        loginPro = new LoginPro(driver);
       loginPro.openHomePage("http://172.16.10.68:5050/#/login");
        loginPro.login(username,password,code);
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

        informationManagePro = new InformationManagePro(driver);
        cookieHandle = new CookieHandle(driver);
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
       }
       informationManagePro.gotoInformationManage();
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

    }*/

    @Test
    @Parameters({"searchCategoryName"})
   public void testInformationCategorySearch(String searchCategoryName){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        informationManagePro.gotoInformationManage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       //点击“资讯管理”
       informationManagePro.clickInformationManage();
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       //点击“资讯分类”
       informationManagePro.clickInformationCategory();
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       //输入分类名称
       informationManagePro.inputCategory(searchCategoryName);
       try {
           Thread.sleep(4000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       //点击“搜索”按钮
       informationManagePro.SearchBtnClick();

       try {
           Thread.sleep(4000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       //获取搜索结果
       informationManagePro.getSearchResult();
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       Assert.assertTrue(informationManagePro.getSearchResult().size() != 0,"搜索资讯分类失败！");
       logger.info("搜索资讯分类成功！");
   }

    @Test(dependsOnMethods = "testInformationCategorySearch")
    @Parameters({"addCategoryName"})
    public void testInformationCategoryAdd(String addCategoryName){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //点击“添加”按钮
        informationManagePro.AddCategory();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输入“分类名称”
        informationManagePro.categoryAddInput(addCategoryName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击“保存”
        informationManagePro.saveCategory();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //刷新列表
        informationManagePro.refreshCategoryList();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //判断是否增加成功
        Assert.assertTrue( informationManagePro.addSuccess(addCategoryName),"资讯分类添加失败");
        System.out.println("资讯分类添加成功！");



    }


    @Test(dependsOnMethods = "testInformationCategoryAdd")
    @Parameters({"addCategoryName"})
    public void testInformationCategoryDel(String addCategoryName){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //删除新增的分类
        informationManagePro.delBtnClick(addCategoryName);
        Assert.assertTrue(informationManagePro.delSuccess(addCategoryName),"资讯分类删除失败");
        System.out.println("资讯分类删除成功！");


    }




}
