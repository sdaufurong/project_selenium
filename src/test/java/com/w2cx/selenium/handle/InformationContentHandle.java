package com.w2cx.selenium.handle;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.page.InformationContentPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InformationContentHandle {
    DriverBase driver;
    InformationContentPage icp;
    public InformationContentHandle(DriverBase driver){
        this.driver = driver;
        icp = new InformationContentPage(driver);
    }

    //点击“资讯管理”菜单
    public void clickInformationManage(){
        icp.click(icp.getInformationManageElement());
    }

    //点击“资讯内容”菜单
    public void clickInformationContent(){
        icp.click(icp.getInformationContentElement());
    }

    //输入资讯标题
    public void sendInformationTitle(String title){
        icp.sendKeys(icp.getCategoryTitleInput(),title);
    }

    //点击“搜索”按钮
    public void clickSearchBtn(){
        icp.click(icp.getCategoryContentSearchBtn());
    }


    //获取搜索结果
    public List<WebElement> getContentSearchResultList(){
        List<WebElement> list = icp.getCategoryContentSearchResult();
        return list;
    }

    //点击“添加”按钮
    public void clickAddBtn(){
        icp.click(icp.getCategoryContentAddBtn());
    }

    //输入资讯标题
    public void inputInformationTitle(String title){
        icp.sendKeys(icp.getInformationTitleInput(),title);
    }

    //点击资讯分类
    public void clickInformationCategory(){
        icp.click(icp.getInformationCategory());
    }

    //选择资讯分类选项
    public void selectInformationCategory(){
        icp.click(icp.getInformationCategorySelect());
    }



    //点击"保存草稿"按钮
    public void clickSaveBtn(){
        icp.click(icp.getSaveDraftBtn());
    }


    //点击“提交审核”按钮
    public void clickSubmitReviewBtn(){
        icp.click(icp.getSubmitReviewBtn());
    }


    //获取列表中第一条资讯标题
    public String getFirstInformationTitle(){
        WebElement element = icp.getListInformationTitle();
        return element.getText();
    }


    //点击“去审核”
    public void clickGoReviewBtn(){
        icp.click(icp.getGoReviewBtn());
    }

    //点击“审核”
    public void clickReviewBtn(){
        icp.click(icp.getReviewBtn());
    }

    //获取第一条内容对应按钮
    public WebElement getFirstContentBtns(){
       return icp.getFirstContentBtn();

    }


}
