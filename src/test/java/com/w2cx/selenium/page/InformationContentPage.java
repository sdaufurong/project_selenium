package com.w2cx.selenium.page;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.util.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InformationContentPage extends BasePage{
    DriverBase driver;
    public InformationContentPage(DriverBase driver){
        super(driver);
    }

    //获取“资讯管理”菜单
    public WebElement getInformationManageElement(){
        List<WebElement> list = elements(GetByLocator.getByLocator("informationManage"));
        WebElement element = list.get(0);
        return element;
    }


    //获取“资讯内容”菜单
    public WebElement getInformationContentElement(){
        List<WebElement> list = elements(GetByLocator.getByLocator("information"));
        WebElement element = list.get(1);
        return element;
    }


    //获取“资讯标题”输入框
    public WebElement getCategoryTitleInput(){
        WebElement element = element(GetByLocator.getByLocator("categoryTitleInput"));
        return element;
    }


    //获取“搜索”按钮
    public WebElement getCategoryContentSearchBtn(){
        WebElement element = element(GetByLocator.getByLocator("contentSearchBtn"));
        return element;
    }

    //搜索结果
    public List<WebElement> getCategoryContentSearchResult(){
        List<WebElement> list = elements(GetByLocator.getByLocator("contentSearchResult"));
        return list;
    }



    //获取“添加”按钮
    public WebElement getCategoryContentAddBtn(){
        WebElement element = element(GetByLocator.getByLocator("categoryContentAddBtn"));
        return element;
    }


    //获取“资讯标题”输入框
    public WebElement getInformationTitleInput(){
        WebElement element = element(GetByLocator.getByLocator("informationTitleInput"));
        return element;
    }

    //获取“资讯分类”下拉框
    public WebElement getInformationCategory(){
        WebElement element = element(GetByLocator.getByLocator("informationCategory"));
        return element;
    }

    //获取“资讯分类”选项
    public WebElement getInformationCategorySelect(){
        WebElement element = element(GetByLocator.getByLocator("informationCategorySelect"));
        return element;
    }



    //获取“保存草稿”按钮
    public WebElement getSaveDraftBtn(){
        List<WebElement> list = elements(GetByLocator.getByLocator("submitReviewBtn"));
        /*for (WebElement element:list){
            System.out.println(element.getText());
        }*/
        WebElement element = list.get(0);
        return element;
    }


    //获取“提交审核”按钮
    public WebElement getSubmitReviewBtn(){
        List<WebElement> list = elements(GetByLocator.getByLocator("submitReviewBtn"));
       /* for (WebElement element:list){
            System.out.println(element.getText());
        }*/
        WebElement element = list.get(1);
        return element;
    }



    //获取列表中第一条资讯标题
    public WebElement getListInformationTitle(){
        WebElement element = element(GetByLocator.getByLocator("listInformationTitle"));
        return element;
    }


    //获取第一条资讯的“去审核”按钮
    public WebElement getGoReviewBtn(){
        WebElement element = element(GetByLocator.getByLocator("goReviewBtn"));
        return element;
    }


    //获取“审核”按钮
    public WebElement getReviewBtn(){
        WebElement element = element(GetByLocator.getByLocator("reviewBtn"));
        return element;
    }

    //获取第一条内容对应的按钮
    public WebElement getFirstContentBtn(){
        WebElement element = element(GetByLocator.getByLocator("firstContentBtn"));
        return  element;
    }

}
