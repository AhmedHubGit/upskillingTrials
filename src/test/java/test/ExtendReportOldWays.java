package test;


import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;

public class ExtendReportOldWays {

    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    @BeforeSuite
    public void setUp()
    {
        htmlReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void test()
    {
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
    }

    @Test
    public void test2()
    {
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
    }

    @AfterSuite
    public void tearDown()
    {
        extent.flush();

    }
}
