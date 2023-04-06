package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import test.java.BaseTest;

public class HomePageEvents {
    public void clickOnSignInButton(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Clicking on Sign in button");
        elementFetch.getWebElement("ID", HomePageElements.signInButton).click();
    }
}
