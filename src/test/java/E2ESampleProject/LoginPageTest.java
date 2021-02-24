package E2ESampleProject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageRepository.LoginPage;

import java.io.IOException;

public class LoginPageTest extends BaseProperties{
    LoginPage login;

    public LoginPageTest()
    {
        super();
    }

    @BeforeMethod
    public void launchBrowser() throws IOException, InterruptedException {

        launchURL();
        login = new LoginPage();
        Thread.sleep(3000);
    }

    @Test
    public void LoginTest() throws InterruptedException {
        Thread.sleep(3000);
        login.setUsername();
        Thread.sleep(3000);
        login.setPassword();
    }
}
