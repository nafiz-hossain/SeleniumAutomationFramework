package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.BaseTest;

public class LoginPageEvents {
    public void verifyLoginPageOpenOrNot(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Verifying the login page opened or not");
        Assert.assertTrue(elementFetch.getListWebElement("ID", LoginPageElements.loginText).size()>0, "Login page did not open");
    }
    public void enterEmailId(){
        ElementFetch elementFetch = new ElementFetch();

        BaseTest.logger.info("Entering the email id");
        elementFetch.getWebElement("ID", LoginPageElements.emailAdress).sendKeys("nhremon8181@gmail.com");
    }


}
