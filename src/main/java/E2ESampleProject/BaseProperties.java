package E2ESampleProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseProperties {
    public static WebDriver driver;
    public static Properties prop;

    public void launchURL() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:/Users/ab374mi/IdeaProjects/End2EndSampleProject/src/main/java/config/config.properties");
        prop.load(fis);
        String url = prop.getProperty("ecomURL");

        System.setProperty("webdriver.chrome.driver","C://Software//chromedriver_win32//chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
}
