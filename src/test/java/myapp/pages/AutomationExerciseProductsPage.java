package myapp.pages;

import com.google.j2objc.annotations.Weak;
import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationExerciseProductsPage {
    public AutomationExerciseProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//h2[.='Women - Dress Products']")
    public WebElement womenProductTitle;

    @FindBy(xpath = "//a[@href='#Men']")
    public WebElement menCategory;

    @FindBy(xpath = "//a[@href='/category_products/6']")
    public WebElement menSubCategory;

    @FindBy(xpath = "//h2[.='Men - Jeans Products'] ")
    public WebElement menProductTitle;
}