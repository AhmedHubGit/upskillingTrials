package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import utlis.ConfigManager;
import utlis.ExtentReportManager;

import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setupReport()
    {
        extent = ExtentReportManager.getReportInstance();
    }

    @AfterSuite
    public void tearDownReport()
    {
        extent.flush();
    }


    @BeforeMethod
    public void setUp() throws IOException {
        ConfigManager.loadProperties();
        String url = ConfigManager.getProperty("url");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("loaded the URL correctly: "+ url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown()
    {
            driver.close();
    }

}

