package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.xpath("//input[@id='customer.username']"),"Krishna");
         //finding element of Password
       sendTextToElement(By.xpath("//input[@name='customer.password']"),"Testing123");
        //finding element of confirm password
       sendTextToElement(By.xpath("//input[@name='repeatedPassword']"),"Testing123");//sending password to confirm password field
        //finding element of REGISTER button
     clickOnElement(By.xpath("//input[@type='submit' and @class='button' and @value='Register']"));
         String actualTextMessage = getTextFromElement(By.xpath("//h1[@class='title']"));
        String expectedTextMessage = "Accounts Overview";
        Assert.assertEquals("Login Failed!", actualTextMessage, expectedTextMessage);
    }
    @Test
    public void verifyTheErrorMessage() {
       sendTextToElement(By.xpath("//input[@id='customer.username']"),"Krishna001");
       sendTextToElement(By.xpath("//input[@name='customer.password']"),"Test456");
       clickOnElement(By.xpath("//input[@type='submit' and @class='button' and @value='Register']"));
        String actualTaxtMessage = getTextFromElement(By.xpath("//p[text()='The username and password could not be verified.']"));
        String expectedTaxtMessage = "The username and password could not be verified.";
        Assert.assertEquals("Test Failed", expectedTaxtMessage, actualTaxtMessage);
    }
    @Test

    public void userShouldLogOutSuccessfully() {

        sendTextToElement(By.xpath("//input[@id='customer.username']"),"Krishna");
        sendTextToElement(By.xpath("//input[@name='customer.password']"),"Testing123");
        clickOnElement(By.xpath("//input[@type='submit' and @class='button' and @value='Register']"));
        clickOnElement(By.xpath("//a[text()='Log Out']"));
        String actualTextMessage = getTextFromElement(By.xpath("//h2[text()='Customer Login']"));
        String expectedTextMessage = "Customer Login";
        Assert.assertEquals("Failed to Logout!", expectedTextMessage, actualTextMessage);

    }
    @After
    public void teardown(){
        closeBrowser();
    }

}


