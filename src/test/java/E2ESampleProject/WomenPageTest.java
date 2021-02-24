package E2ESampleProject;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageRepository.WomenPage;

import java.io.IOException;

public class WomenPageTest extends BaseProperties{
    WomenPage wp;
    Actions axn;
    String pageTitle;

    public WomenPageTest()
    {
        super();
    }

    @BeforeTest
    public void launchbrowser() throws IOException, InterruptedException {
        launchURL();
        Thread.sleep(2000);
        wp = new WomenPage();
    }

    @Test(priority = 1)
    public void validateHomePageTitle()
    {
       pageTitle = prop.getProperty("homeTitle");
       Assert.assertEquals(pageTitle, wp.getHomePageTitle());
    }

    @Test(priority = 2)
    public void clickWomenTab() throws InterruptedException {

        Assert.assertTrue(wp.findwomenTag().isDisplayed());
        axn = new Actions(driver);
        axn.moveToElement(wp.findwomenTag()).perform();
        //wp.findwomenTag().click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void selectCasualDress() throws InterruptedException {

        Thread.sleep(2000);
        axn = new Actions(driver);
        axn.moveToElement(wp.findCasualDress()).click().perform();
    }

   /* @AfterTest
    public void tearDown()
    {
        driver.close();
    }*/
}
