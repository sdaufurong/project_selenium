package com.w2cx.selenium.testCase;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.business.InformationContentPro;
import com.w2cx.selenium.business.LoginPro;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testInformationContent extends CaseBase{

    @Parameters({"searchInformationTitle"})
    @Test
    public void testInformationContentSearch(String searchInformationTitle){
        icp.informationManageClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        icp.informationContentClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        icp.informationTitleInput(searchInformationTitle);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        icp.searchClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //判断是否搜索成功
        Assert.assertTrue(icp.searchResult().size() > 0,"搜索结果有误！");
        System.out.println("搜索资讯内容成功！");
    }


    @Parameters({"informationTitle"})
    @Test(dependsOnMethods = "testInformationContentSearch")
    public void testInformationContentAdd(String informationTitle){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击“添加”按钮
        icp.categoryContentAddBtnClick();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //输入资讯标题
        icp.informationTitleSend(informationTitle);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //点击资讯分类
        icp.informationCategoryClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //选择资讯分类
        icp.informationCategorySelect();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //点击“保存草稿”
        icp.saveDraftBtnClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        //判断是否添加成功
        Assert.assertTrue(icp.firstInformationTitleGet().equals(informationTitle),"资讯内容添加失败!");
        System.out.println("添加资讯内容成功！");
    }

    @Test(dependsOnMethods = "testInformationContentAdd")
    @Parameters({"informationTitleReview"})
    public void testInformationContentReview(String informationTitleReview){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击“添加”按钮
        icp.categoryContentAddBtnClick();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //输入资讯标题
        icp.informationTitleSend(informationTitleReview);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //点击资讯分类
        icp.informationCategoryClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //选择资讯分类
        icp.informationCategorySelect();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //点击“提交审核”按钮
        icp.submitReviewBtnClick();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //点击“去审核”
        icp.goReviewBtnClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //点击“审核”按钮
        icp.reviewBtnClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      ;
        Assert.assertTrue(icp.firstContentBtn().getText().equals("下架"),"审核资讯内容失败！");
        System.out.println("审核资讯内容成功！");


    }



}
