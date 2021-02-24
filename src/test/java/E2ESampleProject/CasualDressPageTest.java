package E2ESampleProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageRepository.CasualDressPage;

import java.io.IOException;
import java.util.List;

public class CasualDressPageTest extends WomenPageTest {
    CasualDressPage cdp;


    public CasualDressPageTest() {
        super();
    }

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        launchbrowser();
        cdp = new CasualDressPage();
        Thread.sleep(3000);

    }

    @Test(priority = 4)
    public void validatePageTitle() throws InterruptedException {
        /*Actions axn = new Actions(driver);
        axn.moveToElement(wp.findwomenTag()).perform();
        Thread.sleep(1000);
        axn.moveToElement(wp.findCasualDress()).click().perform();
        Thread.sleep(2000);*/
        clickWomenTab();
        Thread.sleep(2000);
        selectCasualDress();
        Thread.sleep(1000);
        Assert.assertEquals(cdp.getCasualPageTitle(), "Casual Dresses - My Store");
    }

    @Test(priority = 5)
    public void selectSize() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> availableSizes = cdp.selectSize();

        int size = availableSizes.size();
        for (int i = 0; i < size; i++) {
            availableSizes.get(i).click();
            Thread.sleep(1000);
        }
    }

    @Test(priority = 6)
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

    @Test(priority = 7)
    public void validateCartMessage()
    {
        String msg = cdp.cartMessage();
        System.out.println(msg);
       Assert.assertEquals(msg, prop.getProperty("productAddedMessage"));
    }

    @Test(priority = 8)
    public void validateTotalCost()
    {
        float productCost = cdp.totalProductCost();
        //System.out.println(productCost);
        float shippingCost = cdp.totalShippingCost();
        System.out.println(shippingCost);
        float toalCalculatedCost = productCost+shippingCost;
        Assert.assertEquals(toalCalculatedCost, cdp.totalCalcCost());
    }
}
