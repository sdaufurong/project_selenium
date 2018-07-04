import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Login {

    WebDriver driver;


    public void  initDriver(){
        System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        //窗口最大化
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        driver = new ChromeDriver();
    }


    public  void logIn(String phone,String passWord){
        this.initDriver();
        String url = "http://172.16.10.68:5050/#/login";

        //打开登录页
        driver.get(url);
        //检查各元素是否正常显示
        //WebElement userName = byStr("userName");
        WebElement userName_input = this.element(byStr("userName"));
        System.out.println("用户名输入框是否显示："+userName_input.isDisplayed());


        //WebElement passWord = byStr("passWord");
        WebElement passWord_input = this.element(byStr("passWord"));
        System.out.println("密码输入框是否显示："+passWord_input.isDisplayed());

        //WebElement code = byStr("code");
        WebElement code_input = this.element(byStr("code"));
        System.out.println("验证码是否显示："+code_input.isDisplayed());

        //WebElement loginBtn = byStr("loginBtn");
        WebElement loginBtn = element(byStr("loginBtn"));
        System.out.println("登录按钮是否显示："+loginBtn.isDisplayed());


        //输入用户名
        //userName_input.sendKeys(phone);
        userName_input.sendKeys("15110039071");
        //输入密码
        //passWord_input.sendKeys(passWord);
        passWord_input.sendKeys("039071");
        //输入验证码
        code_input.sendKeys("1234");
        //点击登录按钮
        loginBtn.click();

        //智能等待 右上角是否出现用户名
        WebDriverWait wait = new WebDriverWait(driver,10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("user-avatar")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byStr("userNameIsExist")));

        //窗口最大化
        driver.manage().window().maximize();
        //判断是否登录成功
       // WebElement login_name = byStr(by_className,user_isLogin_by_value);
       // WebElement login_name = byStr("userNameIsExist");
        WebElement login_name = element(byStr("userNameIsExist"));
        login_name.click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait1 = new WebDriverWait(driver,10);
        //wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-row")));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(byStr("userInfo")));

        //List<WebElement> list = driver.findElements(By.className("ant-row"));
        List<WebElement> list = driver.findElements(byStr("userInfo"));
        String name = list.get(1).getText();
        System.out.println(name);
        if(name.toString() != null){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

        driver.close();

    }


    public void informationManage(){

        List<WebElement> menu_list = driver.findElements(By.className("ant-menu-submenu-inline"));
        System.out.println(menu_list.size());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击“资讯管理”
        menu_list.get(0).click();

        List<WebElement> information_list = driver.findElements(By.className("ant-menu-item"));
        System.out.println(information_list.size());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击“资讯分类”
        information_list.get(0).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("name")).sendKeys("美食");
        List<WebElement> btn_list = driver.findElements(By.className("ant-btn"));
        System.out.println(btn_list.size());
        for(WebElement element:btn_list){
            System.out.println(element.getText());
        }
        //点击“搜索”按钮
        btn_list.get(1).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //搜索结果列表
        List<WebElement> childNode_list = driver.findElements(By.className("left"));

        System.out.println(childNode_list.get(1).getText());

        if(childNode_list.get(1).getText().contains("美食")){
            System.out.println("搜索正确！");
        }else {
            System.out.println("搜索错误！");
        }
    }


    /***
     * 封装By方法
     */
    public By byStr(String username){
        ReadConfig readConfig = new ReadConfig("element.properties");
        String locationKey = readConfig.getKey(username);
        String locatorType = locationKey.split(">")[0];
        String locatorValue = locationKey.split(">")[1];

        if(locatorType.equals("id")){
            return By.id(locatorValue);
        }else if (locatorType.equals("name")){
            return By.name(locatorValue);
        }else if(locatorType.equals("className")){
           return By.className(locatorValue);
        }else if(locatorType.equals("xpath")){
           return By.xpath(locatorValue);
        }else {
            System.out.println("未定位到元素！");
            return  null;

        }

    }

    /**
     * 封装findElement方法
     * */
    public WebElement element(By by){
        WebElement element = driver.findElement(by);
        return element;
    }


    /**
     * 封装截图方法
     * */



    public static void main(String[] args) {
        Login login = new Login();
        //login.logIn("15110039071","039071");
        //login.informationManage();
        //参数化用户
        HashMap<String ,String> userMap = new HashMap<String, String>();
        userMap.put("15110039071","039071");
        userMap.put("18611582686","582686");
        Iterator user = userMap.entrySet().iterator();
        while (user.hasNext()){
            Map.Entry entry = (Map.Entry) user.next();
            String userName = entry.getKey().toString();
            String passWord = entry.getValue().toString();
            login.logIn(userName,passWord);
        }


    }



}
