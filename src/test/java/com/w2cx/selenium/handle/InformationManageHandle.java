package com.w2cx.selenium.handle;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.page.InformationManagePage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InformationManageHandle {

    InformationManagePage informationManagePage;
    DriverBase driver;
    public InformationManageHandle(DriverBase driver){
        this.driver = driver;
        informationManagePage = new InformationManagePage(driver);
    }

    //点击“资讯管理”菜单
    public void clickInformationManage(){
        informationManagePage.click(informationManagePage.getInformationManageElement());
    }

    //点击“资讯分类”菜单
    public void clickInformationCategory(){
        informationManagePage.click(informationManagePage.getInformationCategoryElement());
    }

    //分类名称搜索框输入搜索内容
    public void sendCategorySearchInput(String inputText){
        informationManagePage.sendKeys(informationManagePage.getSearchInputElement(),inputText);
    }

    //点击“搜索”按钮
    public void clickSearchBtn(){
        informationManagePage.click(informationManagePage.getSearchBtnElement());
    }

    //点击“添加”按钮
    public void clickAddBtn(){
        informationManagePage.click(informationManagePage.getAddBtnElement());
    }

    //输入分类名称
    public void sendCategoryName(String inputText){

        informationManagePage.sendKeys(informationManagePage.getCategoryInput(),inputText);
    }

    //点击“保存”按钮
    public void clickSaveBtn(){
        informationManagePage.click(informationManagePage.getSaveBtn());
    }


    //判断是否添加成功
    public List<WebElement> getCategoryLists(){
        List<WebElement> list = informationManagePage.getCategoryList();
        return list;
    }

    //点击要删除元素对应的删除按钮
    public void clickDelBtn(String categoryName){
        //获取level0级别的分类列表
        ArrayList<WebElement> list = (ArrayList<WebElement>) informationManagePage.getLevel0CategoryList();
        for (int i=0;i<list.size();i++){
            WebElement element = list.get(i);
            if(element.getText().contains(categoryName)){
                //System.out.println("已添加分类："+element.getText());
                //点击元素对应的删除按钮
                informationManagePage.click(informationManagePage.getDelBtn(element));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //点击删除对话框中的“确定”按钮
                informationManagePage.click(informationManagePage.getOkBtn());
                break;
            }
        }


    }




}
