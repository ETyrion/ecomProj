package E2ESampleProject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseProperties {
    public static WebDriver driver= null;
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

    public void getScreenShot(String failedTestName, WebDriver driver) throws IOException {
        TakesScreenshot ss = (TakesScreenshot)  driver;
        File source = ss.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+failedTestName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }


}
