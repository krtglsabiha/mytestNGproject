package myapp.tests.practices;
import com.github.javafaker.Faker;
import myapp.pages.AutomationExerciseHomePage;
import myapp.pages.AutomationExerciseLoginPage;
import myapp.pages.AutomationExerciseSignUpPage;
import myapp.utilities.Driver;

import myapp.utilities.ExtentReportUtils;
import myapp.utilities.LoggerUtils;
import myapp.utilities.MediaUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static myapp.utilities.JSUtils.flashElement;
import static org.testng.AssertJUnit.assertTrue;

public class CreateAndDeleteAccount {
   /*
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Verify that home page is visible successfully
       4. Click on 'Signup / Login' button
       5. Verify 'New User Signup!' is visible
       6. Enter name and email address
       7. Click 'Signup' button
       8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       9. Fill details: Title, Name, Email, Password, Date of birth
       10. Select checkbox 'Sign up for our newsletter!'
       11. Select checkbox 'Receive special offers from our partners!'
       12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       13. Click 'Create Account button'
       14. Verify that 'ACCOUNT CREATED!' is visible
       15. Click 'Continue' button
       16. Verify that 'Logged in as username' is visible
       17. Click 'Delete Account' button
       18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    Faker faker = new Faker();

    @Test
    public void accountCreateDeleteTest() throws IOException, IOException {

        LoggerUtils.info("Test case begins .. ");
        ExtentReportUtils.createTestReport("Smoke Test Report", "Admin Login Test");
        ExtentReportUtils.pass("Starting the admin login test...");

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        AutomationExerciseHomePage automationExerciseHomePage = new AutomationExerciseHomePage();
        flashElement(automationExerciseHomePage.homePageLink);
        assertTrue(automationExerciseHomePage.homePageLink.isDisplayed());

        MediaUtils.takeScreenshotOfThisElement(automationExerciseHomePage.homePageLink);


//        4. Click on 'Signup / Login' button
        flashElement(automationExerciseHomePage.signupLoginButton);
        automationExerciseHomePage.signupLoginButton.click();

//        5. Verify 'New User Signup!' is visible
        AutomationExerciseLoginPage automationExerciseLoginPage = new AutomationExerciseLoginPage();
        flashElement(automationExerciseLoginPage.newUserSignup);
        assertTrue(automationExerciseLoginPage.newUserSignup.isDisplayed());

//        6. Enter name and email address
        flashElement(automationExerciseLoginPage.nameInput);
        automationExerciseLoginPage.nameInput.sendKeys(faker.name().name());
        String name = automationExerciseLoginPage.nameInput.getText();
        flashElement(automationExerciseLoginPage.emailInput);
        automationExerciseLoginPage.emailInput.sendKeys(faker.internet().emailAddress());

        MediaUtils.takeScreenshotOfTheEntirePage();

//        7. Click 'Signup' button
        flashElement(automationExerciseLoginPage.signUpButton);
        automationExerciseLoginPage.signUpButton.click();
        //REST IS HOMEWORK

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        AutomationExerciseSignUpPage automationExerciseSignUpPage = new AutomationExerciseSignUpPage();
        flashElement(automationExerciseSignUpPage.verifyAccountInfo);
        assertTrue(automationExerciseSignUpPage.verifyAccountInfo.getText().contains("ENTER ACCOUNT INFORMATION"));

//        9. Fill details: Title, Name, Email, Password, Date of birth
        flashElement(automationExerciseSignUpPage.genderFemale);
        automationExerciseSignUpPage.genderFemale.click();
        flashElement(automationExerciseSignUpPage.password);
        automationExerciseSignUpPage.password.sendKeys(faker.internet().password());

        flashElement(automationExerciseSignUpPage.day);
        Select selectDay = new Select(automationExerciseSignUpPage.day);
        selectDay.selectByValue("7");

        flashElement(automationExerciseSignUpPage.month);
        Select selectMonth = new Select(automationExerciseSignUpPage.month);
        selectMonth.selectByVisibleText("july");

        flashElement(automationExerciseSignUpPage.year);
        Select selectYear = new Select(automationExerciseSignUpPage.year);
        selectYear.selectByIndex(2);

        MediaUtils.takeScreenshotOfTheEntirePage();

//        10. Select checkbox 'Sign up for our newsletter!'
        flashElement(automationExerciseSignUpPage.genderFemale);
        automationExerciseSignUpPage.newsletter.click();
//        11. Select checkbox 'Receive special offers from our partners!'
        flashElement(automationExerciseSignUpPage.option);
        automationExerciseSignUpPage.option.click();
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        flashElement(automationExerciseSignUpPage.firstName);
        automationExerciseSignUpPage.firstName.sendKeys(faker.name().firstName());

        flashElement(automationExerciseSignUpPage.lastName);
        automationExerciseSignUpPage.lastName.sendKeys(faker.name().lastName());

        flashElement(automationExerciseSignUpPage.company);
        automationExerciseSignUpPage.company.sendKeys(faker.company().name());

        flashElement(automationExerciseSignUpPage.address1);
        automationExerciseSignUpPage.address1.sendKeys(faker.address().fullAddress());

        flashElement(automationExerciseSignUpPage.address2);
        automationExerciseSignUpPage.address2.sendKeys(faker.address().streetAddress());

        flashElement(automationExerciseSignUpPage.country);
        Select select = new Select(automationExerciseSignUpPage.country);
        select.selectByValue("Canada");

        flashElement(automationExerciseSignUpPage.state);
        automationExerciseSignUpPage.state.sendKeys(faker.address().state());

        flashElement(automationExerciseSignUpPage.city);
        automationExerciseSignUpPage.city.sendKeys(faker.address().city());

        flashElement(automationExerciseSignUpPage.zipcode);
        automationExerciseSignUpPage.zipcode.sendKeys(faker.address().zipCode());

        flashElement(automationExerciseSignUpPage.mobile_number);
        automationExerciseSignUpPage.mobile_number.sendKeys(faker.phoneNumber().cellPhone());

        MediaUtils.takeScreenshotOfTheEntirePage();

//        13. Click 'Create Account button'

        flashElement(automationExerciseSignUpPage.createAccount);
        automationExerciseSignUpPage.createAccount.click();

//        14. Verify that 'ACCOUNT CREATED!' is visible
        flashElement(automationExerciseSignUpPage.accountCreated);
        assertTrue(automationExerciseSignUpPage.accountCreated.isDisplayed());

//        15. Click 'Continue' button
        automationExerciseSignUpPage.continueSignUp.click();
        Driver.getDriver().navigate().refresh();
        //WaitUtils.waitFor(5);
        flashElement(automationExerciseSignUpPage.continueSignUp);
        automationExerciseSignUpPage.continueSignUp.click();

//        16. Verify that 'Logged in as username' is visible
        flashElement(automationExerciseSignUpPage.verifyLoggedInAsName);
        String verifiedName = automationExerciseSignUpPage.verifyLoggedInAsName.getText();
        System.out.println(verifiedName);
        Assert.assertTrue(automationExerciseSignUpPage.verifyLoggedInAsName.getText().contains(verifiedName));

//        17. Click 'Delete Account' button
        flashElement(automationExerciseSignUpPage.deleteButton);
        automationExerciseSignUpPage.deleteButton.click();

//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        flashElement(automationExerciseSignUpPage.accountDeleted);
        Assert.assertTrue(automationExerciseSignUpPage.accountDeleted.isDisplayed());

        MediaUtils.takeScreenshotOfTheEntirePage();


        Driver.getDriver().close();

        ExtentReportUtils.pass("Driver is closed.... Test is completed successfully...");
        ExtentReportUtils.flush();
        LoggerUtils.info("Test completed...");

    }

}