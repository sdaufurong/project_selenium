package com.w2cx.selenium.business;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.handle.InformationContentHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InformationContentPro {

    DriverBase driver;
    InformationContentHandle ich;
    public InformationContentPro(DriverBase driver){
        this.driver = driver;
        ich = new InformationContentHandle(driver);
    }


    //点击资讯管理
    public void informationManageClick(){
        ich.clickInformationManage();
    }

    //点击资讯内容
    public void informationContentClick(){
        ich.clickInformationContent();
    }

    //输入资讯标题
    public void informationTitleInput(String title){
        ich.sendInformationTitle(title);
    }


    //点击搜索
    public void searchClick(){
        ich.clickSearchBtn();
    }

    //搜索结果
    public List<WebElement> searchResult(){

        List<WebElement> list = ich.getContentSearchResultList();
        return list;
    }


    //点击“添加”按钮
    public void categoryContentAddBtnClick(){
        ich.clickAddBtn();
    }


    //输入标题
    public void informationTitleSend(String title){
        ich.inputInformationTitle(title);
    }


    //点击资讯分类
    public void informationCategoryClick(){
        ich.clickInformationCategory();
    }


    //选择资讯分类选项
    public void informationCategorySelect(){
        ich.selectInformationCategory();
    }


    //点击“保存草稿”按钮
    public void saveDraftBtnClick(){
        ich.clickSaveBtn();
    }



    //点击“提交审核”按钮
    public void submitReviewBtnClick(){
        ich.clickSubmitReviewBtn();
    }


    //获取第一条资讯标题
    public String firstInformationTitleGet(){
        return ich.getFirstInformationTitle();
    }

    //点击去审核
    public void goReviewBtnClick(){
        ich.clickGoReviewBtn();
    }


    //点击“审核”
    public void reviewBtnClick(){
        ich.clickReviewBtn();
    }

    //获取第一条内容对应按钮
    public WebElement firstContentBtn(){
        return ich.getFirstContentBtns();
    }
}
