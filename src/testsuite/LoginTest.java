package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //Inheriting the BaseTest class
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }
        @Test
        public void userShouldNavigateToLoginPageSuccessfully() {
            WebElement signInLink = driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]"));
            signInLink.click();
            WebElement welcomeText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
            Assert.assertEquals(welcomeText.getText(), "Welcome Back!");
    }
        @Test
        public void verifyTheErrorMessage() {
            WebElement signInLink = driver.findElement(By.linkText("Sign In"));
            signInLink.click();
            WebElement emailField = driver.findElement(By.id("user[email]"));
            emailField.sendKeys("mvthakur2011@gmail.com");
            WebElement passwordField = driver.findElement(By.id("user[password]"));
            passwordField.sendKeys("Mv12345");
            WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
            signInButton.click();
            WebElement errorMessage = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
            Assert.assertEquals(errorMessage.getText(), "Invalid email or password.");
        }
        @After
        public void tearDown() {
        //closing the browser
          driver.close();
    }
}
