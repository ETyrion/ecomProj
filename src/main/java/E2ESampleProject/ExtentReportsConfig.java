package E2ESampleProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsConfig {
    public static ExtentReports extent;

    public static ExtentReports getReportsObject()
    {
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Test_Results");
        reporter.config().setDocumentTitle("Test Launch Results ");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;

    }
}
