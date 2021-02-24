package E2ESampleProject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageRepository.HomePage;

import java.io.IOException;

public class HomePageTest extends BaseProperties{
    HomePage obj;

    public HomePageTest()
    {
        super();
    }

    @BeforeTest
    public void launchTest() throws IOException {
        launchURL();
        obj = new HomePage();
    }

    @Test(priority = 1)
    public void searchTest() throws InterruptedException {
        System.out.println("Searching the dress now");
        obj.searchItem("Dress");
        Thread.sleep(1000);
        //obj.searchResults();
        //Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void selectDress() throws InterruptedException {
        obj.searchResults();
    }

    @DataProvider
    public Object[] searchItems()
    {
        Object[] items = new Object[3];
        items[0]="Dress";
        items[1]="TeeShirt";
        items[2]="Jeans";
        return items;
    }
}
