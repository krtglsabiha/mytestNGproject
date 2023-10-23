package myapp.tests.practices;
import myapp.pages.AutomationExerciseHomePage;
import myapp.pages.AutomationExerciseLoginPage;
import myapp.utilities.Driver;
import org.testng.annotations.Test;
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

    @Test
    public void accountCreateDeleteTest() {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        AutomationExerciseHomePage automationExerciseHomePage = new AutomationExerciseHomePage();

        flashElement(automationExerciseHomePage.homePageLink);

        assertTrue(automationExerciseHomePage.homePageLink.isDisplayed());

//        4. Click on 'Signup / Login' button
        flashElement(automationExerciseHomePage.signupLoginButton);
        automationExerciseHomePage.signupLoginButton.click();

//        5. Verify 'New User Signup!' is visible
        AutomationExerciseLoginPage automationExerciseLoginPage = new AutomationExerciseLoginPage();
        flashElement(automationExerciseLoginPage.newUserSignup);
        assertTrue(automationExerciseLoginPage.newUserSignup.isDisplayed());

//        6. Enter name and email address
        flashElement(automationExerciseLoginPage.nameInput);
        automationExerciseLoginPage.nameInput.sendKeys("John");
        flashElement(automationExerciseLoginPage.emailInput);
        automationExerciseLoginPage.emailInput.sendKeys("johndoe785@gmail.com");

//        7. Click 'Signup' button
        flashElement(automationExerciseLoginPage.signUpButton);
        automationExerciseLoginPage.signUpButton.click();

        //REST IS HOMEWORK

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//        9. Fill details: Title, Name, Email, Password, Date of birth
//        10. Select checkbox 'Sign up for our newsletter!'
//        11. Select checkbox 'Receive special offers from our partners!'
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        13. Click 'Create Account button'
//        14. Verify that 'ACCOUNT CREATED!' is visible
//        15. Click 'Continue' button
//        16. Verify that 'Logged in as username' is visible
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    }


}