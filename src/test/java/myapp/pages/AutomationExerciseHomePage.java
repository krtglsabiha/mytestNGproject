package myapp.pages;
import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AutomationExerciseHomePage {

    public AutomationExerciseHomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.=' Home']")
    public WebElement homePageLink;

    @FindBy(xpath = "//a[.=' Signup / Login']")
    public WebElement signupLoginButton;


}