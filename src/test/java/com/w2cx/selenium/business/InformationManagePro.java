package com.w2cx.selenium.business;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.handle.InformationManageHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InformationManagePro {

    InformationManageHandle informationManageHandle;
    DriverBase driver;
   public InformationManagePro(DriverBase driver){
       this.driver = driver;
       informationManageHandle = new InformationManageHandle(driver);
   }


   public void gotoInformationManage(){
       driver.get("http://172.16.10.68:5050/#/information/classification");
   }

   //点击“资讯管理”菜单
    public void clickInformationManage(){
       informationManageHandle.clickInformationManage();
    }


    //点击“资讯分类”菜单
    public void clickInformationCategory(){
        informationManageHandle.clickInformationCategory();
    }

   //输入要搜索的分类名称
    public void inputCategory(String categoryName){

        informationManageHandle.sendCategorySearchInput(categoryName);
    }

    //点击“搜索”按钮
    public void SearchBtnClick(){
        informationManageHandle.clickSearchBtn();
    }


   //获取查询分类结果
    public List<WebElement> getSearchResult(){
        List<WebElement> list = driver.findElements(By.className("left"));
        return list;
    }

    //点击“添加”按钮
    public void AddCategory(){
        informationManageHandle.clickAddBtn();
    }

    //输入要添加的分类名称
    public void categoryAddInput(String categoryName){

        informationManageHandle.sendCategoryName(categoryName);
    }

    //点击保存
    public void saveCategory(){
        informationManageHandle.clickSaveBtn();
    }


    //刷新列表
    public void refreshCategoryList(){
        driver.refresh();
    }


    //判断是否添加成功
    public boolean addSuccess(String alreadyAddCategoryName){
        List<WebElement> list = informationManageHandle.getCategoryLists();
        for (WebElement element:list){
            //System.out.println("已添加分类："+element.getText());
            String name = element.getText();
            if(name.equals(alreadyAddCategoryName)){
                return true;
            }
        }
        return false;
    }


    //点击删除按钮
    public void delBtnClick(String categoryName){
        informationManageHandle.clickDelBtn(categoryName);
    }

    //判断是否删除成功
    public boolean delSuccess(String alreadyAddCategoryName){
        List<WebElement> list = informationManageHandle.getCategoryLists();
        for (WebElement element:list){
            //System.out.println("已添加分类："+element.getText());
            String name = element.getText();
            if(!name.contains(alreadyAddCategoryName)){
                return true;
            }
        }
        return false;
    }






}
