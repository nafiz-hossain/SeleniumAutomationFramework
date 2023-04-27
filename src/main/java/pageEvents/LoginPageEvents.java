package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.java.BaseTest;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

public class LoginPageEvents {
    public void verifyLoginPageOpenOrNot(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Verifying the login page opened or not");
        Assert.assertTrue(elementFetch.getListWebElement("ID", LoginPageElements.loginText).size()>0, "Login page did not open");
    }
    public void enterValidEmailId(){
        ElementFetch elementFetch = new ElementFetch();

        BaseTest.logger.info("Entering the valid email id");
        elementFetch.getWebElement("ID", LoginPageElements.emailAddressInput).sendKeys("nhremon");


    }

    public void enterInvalidEmailId(){
        ElementFetch elementFetch = new ElementFetch();


        byte[] array = new byte[6];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        System.out.println(generatedString);

        BaseTest.logger.info("Entering the invalid email id");
        elementFetch.getWebElement("ID", LoginPageElements.emailAddressInput).sendKeys(generatedString);


    }

    public void enterValidPassword(){
        ElementFetch elementFetch = new ElementFetch();

        BaseTest.logger.info("Entering the valid password");
        elementFetch.getWebElement("ID", LoginPageElements.loginPasswordInput).sendKeys("123456");
    }

    public void enterInvalidPassword(){
        ElementFetch elementFetch = new ElementFetch();

        byte[] array = new byte[6]; //
        new Random().nextBytes(array);
        String generatedPass = new String(array, Charset.forName("UTF-8"));

        BaseTest.logger.info("Entering the invalid password");
        elementFetch.getWebElement("ID", LoginPageElements.loginPasswordInput).sendKeys(generatedPass);
    }
    public void loginButtonClick(){
        ElementFetch elementFetch = new ElementFetch();

        BaseTest.logger.info("Clicking the login button");
        List<WebElement> loginButtons = elementFetch.getListWebElement("XPATH", LoginPageElements.loginButtonC);
        Assert.assertTrue(loginButtons.size() > 0, "Login page didn't open");
        loginButtons.get(0).click(); // Click on the first login button found


    }
}
