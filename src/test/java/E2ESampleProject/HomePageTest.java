package E2ESampleProject;

import Pkg2.LogClassTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageRepository.HomePage;

import java.io.IOException;

public class HomePageTest extends BaseProperties{

    private static Logger log1 = LogManager.getLogger(HomePageTest.class.getName());HomePage obj;

    public HomePageTest()
    {
        super();
    }

    @BeforeTest
    public void launchTest() throws IOException {
        launchURL();
        obj = new HomePage();
        log1.info("Test started");
    }

    @Test(priority = 1)
    public void searchTest() throws InterruptedException {
        log1.info("Searching the dress now");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log1.error("Can't find in given time frame");
        }
        try {
            obj.searchItem("Dress");
        } catch (InterruptedException e) {
            log1.fatal("Can't find the element");
        }
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
