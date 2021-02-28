package E2ESampleProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseProperties implements ITestListener {
    private static Logger log1 = LogManager.getLogger(Listeners.class.getName());
    ExtentReports extent = ExtentReportsConfig.getReportsObject();
    ExtentTest test;

    public void onTestStart(ITestResult iTestResult) {
        log1.info("Test is started " + iTestResult.getName());
        String testName = iTestResult.getTestName();
        test = extent.createTest(iTestResult.getMethod().getMethodName());
    }


    public void onTestSuccess(ITestResult iTestResult) {
        log1.info("Test is Passed " + iTestResult.getName());
        test.log(Status.PASS,"Test is Passed");

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
            test.log(Status.FAIL, "Test is Failed");
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
        extent.flush();

    }
}
