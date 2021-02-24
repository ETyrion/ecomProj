package pageRepository;

import E2ESampleProject.BaseProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseProperties {

    @FindBy(xpath = "//*[@id='search_query_top']")
    WebElement srchbx;

    @FindBy(xpath = "//*[@class='ac_results']")
    WebElement srcrslt;

    //Initializing page objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void searchItem(String item) throws InterruptedException {
        srchbx.sendKeys(item);
        Thread.sleep(2000);
    }

    public void searchResults() throws InterruptedException {
        List<WebElement> dresses = driver.findElements(By.xpath("//*[@class='ac_results']//li"));
        String fetchedDress;
        for(int i=0; i<dresses.size(); i++)
        {
            fetchedDress = dresses.get(i).getText();
            Thread.sleep(2000);
            System.out.println(fetchedDress);
               if(fetchedDress.equalsIgnoreCase("Blouses > Blouse"))
               {
                   dresses.get(i).click();
                   break;
               }
        }
        driver.navigate().refresh();
    }
}
