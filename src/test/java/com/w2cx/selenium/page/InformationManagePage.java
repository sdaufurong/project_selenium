package com.w2cx.selenium.page;

import com.w2cx.selenium.base.DriverBase;
import com.w2cx.selenium.util.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InformationManagePage extends BasePage{
    DriverBase driver;
   // List<WebElement> btnList;
    public InformationManagePage(DriverBase driver){
        super(driver);
    }

    //获取“资讯管理”菜单
    public WebElement getInformationManageElement(){
        List<WebElement> list = elements(GetByLocator.getByLocator("informationManage"));
        WebElement element = list.get(0);
        System.out.println("找到元素:"+element.getText());
        return element;
    }

    //获取“资讯分类”菜单
    public WebElement getInformationCategoryElement(){
        List<WebElement> list = elements(GetByLocator.getByLocator("information"));
        WebElement element = list.get(0);
        System.out.println("找到元素:"+element.getText());
        return element;
    }

    //获取“分类名称”搜索框
    public WebElement getSearchInputElement(){
        WebElement element = element(GetByLocator.getByLocator("categorySearchInput"));
        return element;
    }

    //获取“搜索”按钮
    public WebElement getSearchBtnElement(){
        //btnList = driver.findElements(GetByLocator.getByLocator("categorySearchBtn"));
        //WebElement element = driver.findElement(GetByLocator.getByLocator("categorySearchBtn"));
        WebElement element = element(GetByLocator.getByLocator("categorySearchBtn"));
        return element;
    }

    //获取“添加”按钮
    public WebElement getAddBtnElement(){
      /*  List<WebElement> btn_list1 = driver.findElements(GetByLocator.getByLocator("categorySearchBtn"));
        System.out.println("共找到元素："+btn_list1.size()+"个");
        for(WebElement element:btn_list1){
            System.out.println(element.getText());
        }*/
        //WebElement element = btn_list1.get(0);
        //WebElement element = btnList.get(0);
        //System.out.println("按钮名称："+element.getText());
       // WebElement element =driver.findElement(GetByLocator.getByLocator("categoryAddBtn"));
        WebElement element = element(GetByLocator.getByLocator("categoryAddBtn"));
        return  element;
    }

    //获取“分类名称”输入框
    public WebElement getCategoryInput(){
        List<WebElement> input_list = elements(GetByLocator.getByLocator("categoryAddName"));
        WebElement element =  input_list.get(1);
        return element;
    }

    //获取“保存”按钮
    public WebElement getSaveBtn(){
        WebElement element = element(GetByLocator.getByLocator("categorySaveBtn"));
        return element;
    }


    //获取已添加分类列表
    public List<WebElement> getCategoryList(){
        List<WebElement> category_list = elements(GetByLocator.getByLocator("categoryList"));
        System.out.println("已添加资讯分类个数:"+category_list.size());
       /* for (WebElement element:category_list){
            if(element.getText())
        }*/
        return category_list;

    }


    //获取已添加的level0级别的分类列表
    public List<WebElement> getLevel0CategoryList(){
        List<WebElement> level0_category_list = elements(GetByLocator.getByLocator("categoryLevel0List"));
        return level0_category_list;
    }

    //获取要删除元素对应的“删除”按钮
    public WebElement getDelBtn(WebElement Element){
        WebElement element =Element.findElement(GetByLocator.getByLocator("categoryDelBtn"));
        return element;
    }

    //获取对话框中的“确定”按钮
    public WebElement getOkBtn(){
        WebElement element = element(GetByLocator.getByLocator("okBtn"));
        return element;
    }


}
