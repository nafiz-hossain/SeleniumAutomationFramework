package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PurchasePhoneTest {
    private WebDriver driver;
    private String baseURL = "https://www.demoblaze.com/index.html";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testLogin() {
        driver.get(baseURL);
        WebElement loginLink = driver.findElement(By.id("login2"));
        loginLink.click();
        WebElement username = driver.findElement(By.id("loginusername"));
        WebElement password = driver.findElement(By.id("loginpassword"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        username.sendKeys("your_username");
        password.sendKeys("your_password");
        loginButton.click();
    }

    @Test(priority = 2)
    public void testPurchasePhone() throws InterruptedException {
        driver.get(baseURL);
        WebElement phoneCategory = driver.findElement(By.xpath("//a[contains(text(),'Phones')]"));
        phoneCategory.click();
        WebElement phone = driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s6')]"));
        phone.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]"));
        addToCartButton.click();
        Thread.sleep(2000);
        WebElement cartLink = driver.findElement(By.xpath("//a[@id='cartur']"));
        cartLink.click();
        WebElement placeOrderButton = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
        placeOrderButton.click();
        WebElement purchaseButton = driver.findElement(By.xpath("//button[contains(text(),'Purchase')]"));
        purchaseButton.click();
        WebElement purchaseStatus = driver.findElement(By.xpath("//p[contains(text(),'Thank you for your purchase!')]"));
        assert purchaseStatus.getText().equals("Thank you for your purchase!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
