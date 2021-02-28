package E2ESampleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageRepository.CasualDressPage;
import pageRepository.WomenPage;

import java.io.IOException;
import java.util.List;

public class CasualDressPageTest extends BaseProperties {
    //public static Logger log = (Logger) LogManager.getLogger(CasualDressPageTest.class.getName());
    CasualDressPage cdp;
    WomenPage wpage;
    Actions ax;

    public CasualDressPageTest() {
        super();
    }

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        launchURL();
        //log.info("browser is opened");
        cdp = new CasualDressPage();
        wpage = new WomenPage();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void validatePageTitle() throws InterruptedException {
        //WebElement womenTag= w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]")));
        //Assert.assertTrue(wpage.findwomenTag().isDisplayed());
        driver.navigate().refresh();
        WebDriverWait w1 = new WebDriverWait(driver, 10);
        WebElement womenTag= w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]")));
        ax = new Actions(driver);
        ax.moveToElement(wpage.findwomenTag()).perform();
        //log.info("Women Tag clicked");
        //wp.findwomenTag().click();
        Thread.sleep(2000);
        ax.moveToElement(wpage.findCasualDress()).click().perform();
        //log.info("Casual dress is selected");
        Thread.sleep(2000);
        Assert.assertEquals(cdp.getCasualPageTitle(), "Casual Dresses -My Store");
    }

    @Test(enabled = false,priority = 7)
    public void selectSize() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> availableSizes = cdp.selectSize();

        int size = availableSizes.size();
        for (int i = 0; i < size; i++) {
            availableSizes.get(i).click();
            Thread.sleep(2000);
        }
    }

    @Test(priority = 8)
    public void selectDress() throws InterruptedException {
        Actions axn = new Actions(driver);
        List<WebElement> dresses = cdp.getDressList();
        List<WebElement> cartbtns = cdp.addToCartbtn();
        for (int i = 0; i < dresses.size(); i++) {
            axn.moveToElement(dresses.get(i)).perform();
            Thread.sleep(1000);
            axn.moveToElement(cartbtns.get(i)).click().perform();
            Thread.sleep(4000);
        }
    }

    @Test(priority = 9)
    public void validateCartMessage() {
        String msg = cdp.cartMessage();
        System.out.println(msg);
        Assert.assertEquals(msg, prop.getProperty("productAddedMessage"));
    }

    @Test(priority = 10)
    public void validateTotalCost() {
        float productCost = cdp.totalProductCost();
        //System.out.println(productCost);
        float shippingCost = cdp.totalShippingCost();
        System.out.println(shippingCost);
        float toalCalculatedCost = productCost + shippingCost;
        Assert.assertEquals(toalCalculatedCost, cdp.totalCalcCost());
        Assert.assertTrue(cdp.checkoutbtn().isDisplayed());
        cdp.checkoutbtn().click();
    }

  @Test(dependsOnMethods = "validateTotalCost")
    public void checkoutbtn()
    {
        Assert.assertTrue(cdp.checkoutbtn().isDisplayed());
        cdp.checkoutbtn().click();
    }

}
