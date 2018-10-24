package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(linkText = "Sign in")
    public WebElement signInLink;

    public LoginPage signIn(){
        signInLink.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

}
