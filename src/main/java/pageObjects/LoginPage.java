package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.Logging;

public class LoginPage {
	
	Logger log = Logging.getLogger(LoginPage.class);

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id="login_field")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(name="commit")
    WebElement signInBtn;

    @FindBy(linkText = "Create an account")
    WebElement createAccountLink;

    @FindBy(linkText = "Forgot password?")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[@class='container']")
    public WebElement errorMsg;

    public void login(String user, String pass){
//    	username = driver.findElement(By.id("login_field"));
        username.sendKeys(user);
        log.info("Entered username " + user);
        password.sendKeys(pass);
        log.info("Entered password " + pass);
        signInBtn.click();
    }

    public boolean isLoaded(){
        return driver.findElement(By.xpath("//h1[contains(text(), 'Sign in to GitHub')]")).isDisplayed();
    }

}

