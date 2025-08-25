package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.locators.RelativeLocator;

public class Loginpage extends BaseTest {


    private WebDriver driver;

    public Loginpage(WebDriver driver)
    {
        this.driver = driver;
    }


    private By emailTextBox = By.id("Email");
    private By passwordTextBox = By.id("Password");
    private By loginButton = By.xpath("//button[text()='Log in']");

    private By passwordTrial = RelativeLocator.with(By.tagName("input")).below(By.id("Email"));

    public void enterEmail(String email)
    {
     driver.findElement(emailTextBox).clear();
     driver.findElement(emailTextBox).sendKeys(email);
    }

    public void enterPassword(String password)
    {
        driver.findElement(passwordTrial).clear();
        driver.findElement(passwordTrial).sendKeys(password);
    }

    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
    }

}
