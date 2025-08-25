package test;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Loginpage;
import utlis.ConfigManager;
import utlis.ExcelUtils;
import utlis.ExtentReportManager;

import java.io.IOException;
import java.time.LocalDateTime;

public class LoginTests extends BaseTest {

        @DataProvider(name="LoginData")
        public Object [][] getLoginData() throws IOException {
        String filePath = System.getProperty("user.dir")+"/testdata/testdata.xlsx";
        ExcelUtils.loadExcel(filePath,"Sheet1");
        int rowCount = ExcelUtils.getRowCount();

        Object [] [] data = new Object[rowCount-1][2];

        for(int i=1 ;i<rowCount;i++)
        {
            data[i-1][0] = ExcelUtils.getCellData(i,0);
            data[i-1][1] = ExcelUtils.getCellData(i,1);
        }
        ExcelUtils.closeExcel();

        return data;
         }

    @Test
    public void testValidLogin() throws IOException {

        test = ExtentReportManager.createTest("Login Test");

        ConfigManager.loadProperties();
        String username = ConfigManager.getProperty("username");
        String password = ConfigManager.getProperty("password");


        test.info("Navigating URL");
        Loginpage loginPage = new Loginpage(driver);
        test.info("Enter Username");
        loginPage.enterEmail(username);
        test.info("Enter Password");
        loginPage.enterPassword(password);
        test.info("click on login button");

        loginPage.clickOnLoginButton();

        ConfigManager.setProperty("the output of the test ", String.valueOf(LocalDateTime.now()));
        test.pass("Test done successfully");
    }

}
