package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.java.BaseTest;

import java.util.List;

public class LoginPageEvents {
    public void verifyLoginPageOpenOrNot(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Verifying the login page opened or not");
        Assert.assertTrue(elementFetch.getListWebElement("ID", LoginPageElements.loginText).size()>0, "Login page did not open");
    }
    public void enterEmailId(){
        ElementFetch elementFetch = new ElementFetch();

        BaseTest.logger.info("Entering the email id");
        elementFetch.getWebElement("ID", LoginPageElements.emailAddressInput).sendKeys("nhremon");


    }

    public void enterPassword(){
        ElementFetch elementFetch = new ElementFetch();

        BaseTest.logger.info("Entering the password");
        elementFetch.getWebElement("ID", LoginPageElements.loginPasswordInput).sendKeys("123456");
    }

    public void loginButtonClick(){
        ElementFetch elementFetch = new ElementFetch();

        BaseTest.logger.info("Clicking the login button");
        List<WebElement> loginButtons = elementFetch.getListWebElement("XPATH", LoginPageElements.loginButtonC);
        Assert.assertTrue(loginButtons.size() > 0, "Login page didn't open");
        loginButtons.get(0).click(); // Click on the first login button found

        // wait for the next page to load
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("dashboard"));


    }



}
