package test;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Loginpage;
import utlis.ExcelUtils;
import utlis.ExtentReportManager;

import java.io.IOException;

public class select_Item extends BaseTest {

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
    @Parameters({"username","password"})
    public void testValidLogin(String username,String password) throws InterruptedException {

        test = ExtentReportManager.createTest("Login Test");

        test.info("Navigating URL");
        Loginpage loginPage = new Loginpage(driver);

        test.info("Enter Username");
        loginPage.enterEmail(username);
        test.info("Enter Password");
        loginPage.enterPassword(password);
        Thread.sleep(5000);
        test.info("click on login button");
        loginPage.clickOnLoginButton();
        test.pass("Test done successfully");
    }

}
