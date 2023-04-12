package test.java;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{
    @Test
    public void sampleMethodForEmailEntering() throws InterruptedException {
        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents.clickOnSignInButton();

        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.verifyLoginPageOpenOrNot();
        loginPageEvents.enterEmailId();
        loginPageEvents.enterPassword();
        loginPageEvents.loginButtonClick();

        homePageEvents.testPurchasePhone();
   //     homePageEvents.testPurchasePhone();
//      homePageEvents.itemsToBuy();
//      homePageEvents.addToCartItem();
    }
}
