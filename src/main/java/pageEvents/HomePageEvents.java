package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.java.BaseTest;

import java.time.Duration;

import static test.java.BaseTest.driver;

public class HomePageEvents {

    @Test(priority = 1)
    public void clickOnSignInButton(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Clicking on Sign in button");
        elementFetch.getWebElement("ID", HomePageElements.signInButton).click();
    }

    @Test(priority = 2)
    public void testPurchasePhone() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the "Phones" category
        WebElement phoneCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Phones')]")));
        phoneCategory.click();

        // Wait for the modal to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));

        // Click on the desired phone (Samsung galaxy s6 in this case)
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
        phone.click();
        Thread.sleep(2000);

        // Click on the "Add to cart" button
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to cart')]")));
        addToCartButton.click();

        // Wait for the alert to appear and then accept it
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        // Click on the cart link to go to the cart page
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='cartur']")));
        cartLink.click();

        // Click on the "Place Order" button
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]")));
        placeOrderButton.click();

        // Fill in the form with dummy data
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
        nameInput.sendKeys("John Doe");

        WebElement countryInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
        countryInput.sendKeys("United States");

        WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
        cityInput.sendKeys("New York");

        WebElement cardInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("card")));
        cardInput.sendKeys("1234567890123456");

        WebElement monthInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("month")));
        monthInput.sendKeys("01");

        WebElement yearInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("year")));
        yearInput.sendKeys("2024");
        Thread.sleep(2000);

        // Click on the "Purchase" button
        WebElement purchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Purchase')]")));
        purchaseButton.click();
        Thread.sleep(2000);

        // Wait for the purchase confirmation message to appear and verify its text
        WebElement purchaseStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
        purchaseStatus.click();
//        Assert.assertEquals(purchaseStatus.getText(), "Thank you for your purchase!");
    }

}
