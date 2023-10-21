package myapp.tests.smoketest;
import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Day15_US100201_Admin_Login {
    @Test(groups = "minor_regression_group")
    public void US100201_Admin_Login(){
//        As admin, I should be able to log in the application
//        https://www.bluerentalcars.com/
        //        Given user is on the application home page
        Driver.getDriver().get("https://www.bluerentalcars.com/");
//        Admin email: jack1@gmail.com
//        Admin password: 12345
//        Then clicks on login link
        RentalHomePage rentalHomePage = new RentalHomePage();
        rentalHomePage.loginLink.click();
        WaitUtils.waitFor(2);
//        Then enters admin email, password
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        rentalLoginPage.username.sendKeys("jack1@gmail.com");
        WaitUtils.waitFor(2);
        rentalLoginPage.password.sendKeys("12345");
        WaitUtils.waitFor(2);
//        Then click on login button
        rentalLoginPage.loginButton.click();
        WaitUtils.waitFor(2);
//        Then verify the login is successful
        Assert.assertTrue(rentalHomePage.userID.isDisplayed());
//        close the browser
        Driver.closeDriver();
    }
    /*
    NOTE: above test case is already good. But we can make it more dynamic using reusable methods
     */
    @Test
    public void withReusableMethods(){
        //        As admin, I should be able to log in the application
//        https://www.bluerentalcars.com/
        //        Given user is on the application home page
//        Driver.getDriver().get("https://www.bluerentalcars.com/");
//        ALTERNATIVELY get the url from config property
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        Admin email: jack1@gmail.com
//        Admin password: 12345
//        Then clicks on login link
        RentalHomePage rentalHomePage = new RentalHomePage();
//        rentalHomePage.loginLink.click();
//        WaitUtils.waitFor(2)
//        ALTERNATIVELY - use reusable method to click with timeout dynamically
        BrowserUtils.clickWithTimeOut(rentalHomePage.loginLink,5);
//        Then enters admin email, password
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
//        rentalLoginPage.username.sendKeys("jack1@gmail.com");
//        WaitUtils.waitFor(2);
//        rentalLoginPage.password.sendKeys("12345");
//        WaitUtils.waitFor(2);
//        ALTERNATIVELY - use reusable method to type with timeout dynamically
        BrowserUtils.sendKeysWithTimeout(rentalLoginPage.username,ConfigReader.getProperty("admin_username"),5);
        BrowserUtils.sendKeysWithTimeout(rentalLoginPage.password,ConfigReader.getProperty("admin_password"),5);
//        Then click on login button
//        rentalLoginPage.loginButton.click();
//        WaitUtils.waitFor(2);
//        ALTERNATIVELY - use reusable method to click with timeout dynamically
        BrowserUtils.clickWithTimeOut(rentalLoginPage.loginButton,5);
//        Then verify the login is successful
//        Assert.assertTrue(rentalHomePage.userID.isDisplayed());
//        ALTERNATIVELY - use reusable method to verify with timeout dynamically
        BrowserUtils.verifyElementDisplayed(rentalHomePage.userID);
//        close the browser
        Driver.closeDriver();
    }
}