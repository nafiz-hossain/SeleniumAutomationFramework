package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;

public class LoginPageEvents {
    public void verifyLoginPageOpenOrNot(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getListWebElement("XPATH", LoginPageElements.loginText).size()>0, "Login page did not open");
    }
    public void enterEmailId(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID", LoginPageElements.emailAdress).sendKeys("nhremon8181@gmail.com");
    }


}
