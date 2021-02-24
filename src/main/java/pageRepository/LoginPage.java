package pageRepository;

import E2ESampleProject.BaseProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseProperties {

    @FindBy(xpath ="//*[@id='txtUsername']")
    WebElement username;

    @FindBy(xpath = "//*[@id='txtPassword']")
    WebElement pass;

    //Initializing Page Objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setUsername() {
        username.sendKeys("opensourcecms");
    }

    public void setPassword() {
        pass.sendKeys("opensourcecms");
    }

}
