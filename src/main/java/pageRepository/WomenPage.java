package pageRepository;

import E2ESampleProject.BaseProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage extends BaseProperties {

    @FindBy(xpath = "//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]")
    WebElement womenTag;

    @FindBy(xpath = "//*[@title='Casual Dresses']")
    WebElement casualDress;

    public WomenPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle()
    {
        return driver.getTitle();
    }

    public WebElement findwomenTag()
    {
        return womenTag;
    }

    public WebElement findCasualDress()
    {
        return casualDress;
    }
}
