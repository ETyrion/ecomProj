package E2ESampleProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseProperties implements ITestListener {
    private static Logger log1 = LogManager.getLogger(Listeners.class.getName());

    public void onTestStart(ITestResult iTestResult) {
        log1.info("Test is started " + iTestResult.getName());

    }


    public void onTestSuccess(ITestResult iTestResult) {
        log1.info("Test is Passed " + iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log1.info("Test is Failed " + iTestResult.getName() + " : Capturing screen shot");
        //WebDriver driver = null;
        String testname = iTestResult.getMethod().getMethodName();
       try {
            driver = (WebDriver) iTestResult.getTestClass().getRealClass().getDeclaredField("driver").get(iTestResult.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            getScreenShot(testname, driver);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        log1.info("Test is Finished ");

    }
}
