import java.io.*;
import java.util.Properties;

public class ReadConfig {

    String filePath;
    Properties properties;

    //构造方法
    public ReadConfig(String filePath){

        this.filePath = filePath;
        this.properties = getProperties();

    }

    //获取已经读取了配置文件的properties
    public Properties getProperties(){
        Properties properties = new Properties();

        try {
            InputStream inputStream = new FileInputStream(filePath);
            BufferedInputStream in = new BufferedInputStream(inputStream);
            properties.load(in);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  properties;
    }

    //在配置文件中根据key获取value
    public String getKey(String key){
       return properties.getProperty(key);
    }



    public static void main(String[] args) {

        ReadConfig readConfig = new ReadConfig("element.properties");
        System.out.println(readConfig.getKey("userName"));



    }


}
