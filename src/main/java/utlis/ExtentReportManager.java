package utlis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extents;
    private static ExtentTest test;

    public static ExtentReports getReportInstance()
    {
        if(extents ==null)
        {
            String timeStamp = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
            String reportPath ="reports/ExtentReport_" + timeStamp + ".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("ReportTitleInChromo");
            reporter.config().setReportName("ReportName");


            extents = new ExtentReports();
            extents.attachReporter(reporter);
        }
        return extents;
    }
    public static ExtentTest createTest(String testName)
    {
        test = getReportInstance().createTest(testName);
        return test;
    }

}
