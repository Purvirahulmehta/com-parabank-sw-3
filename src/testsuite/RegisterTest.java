package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void teardown() {
        closeBrowser();
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //finding the element for register tab
        clickOnElement(By.linkText("Register"));
         String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String expectedMessage = "Signing up is easy!";
        Assert.assertEquals("Message is not match", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //finding the element for register tab
       clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // finding first name element
    sendTextToElement(By.xpath("//input[@id='customer.firstName']"),"Kaan");
         //finding element of lastname field
        sendTextToElement(By.xpath("//input[@name='customer.lastName']"),"Shah");
         //finding element of Addrees text box
       sendTextToElement(By.xpath("//input[@id='customer.address.street']"),"Laxmi Nivas");
         //finding element of city
       sendTextToElement(By.xpath("//input[@name='customer.address.city']"),"Ahmedabad");
        //finding element of state tab
      sendTextToElement(By.xpath("//input[@id='customer.address.state']"),"Gujarat");
         //finding element of zip code
       sendTextToElement(By.xpath("//input[@name='customer.address.zipCode']"),"380009");
         //finding element of phone number
       sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"),"9824031235");
        //finding element of ssn
      sendTextToElement(By.xpath("//input[@id='customer.ssn']"),"1234567890");
         //finding element of user name
     sendTextToElement(By.xpath("//input[@id='customer.username']"),"Krishna");
         //finding element of Password
       sendTextToElement(By.xpath("//input[@name='customer.password']"),"Testing123");
         //finding element of confirm password
        sendTextToElement(By.xpath("//input[@name='repeatedPassword']"),"Testing123");
        //finding element of REGISTER button
       clickOnElement(By.xpath("//input[@type='submit' and @class='button' and @value='Register']"));
       String actualTextMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String expectedTextMessage = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals("Message is not match", expectedTextMessage, actualTextMessage);

    }
}

