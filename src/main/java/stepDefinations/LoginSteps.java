package stepDefinations;

import Base.BaseClass;
import Config.Configuration;
import Utils.Logging;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginSteps extends BaseClass {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    Logger log = Logging.getLogger(LoginSteps.class);

    @Given("user is on home page")
    public void user_is_on_home_page() {
        setDriver(Configuration.getConfig("webdriver.browser"));
        log.info("Setting driver to:" + Configuration.getConfig("webdriver.browser"));
        driver = getDriver();
        driver.get("https://github.com");
        homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals("The world’s leading software development platform · GitHub", driver.getTitle());
    }

    @Given("login link is displayed")
    public void login_link_is_displayed() {
        Assert.assertTrue(homePage.signInLink.isDisplayed());
    }

    @When("user clicks on login link")
    public void user_clicks_on_login_link() {
        loginPage = homePage.signIn();
    }

    @Then("user should be on login page")
    public void login_page_should_be_displayed() {
        Assert.assertTrue(loginPage.isLoaded());
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Assert.assertTrue(loginPage.isLoaded());
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" as login details$")
    public void userEntersAndAsLoginDetails(String arg0, String arg1) throws Throwable {
    	log.info("Entering login details as " + arg0 + " " + arg1);
        loginPage.login(arg0, arg1);
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        log.info("Click on login button");
    }

    @Then("user should not able to login succesfully")
    public void user_should_not_able_to_login_succesfully() {
        Assert.assertNotEquals("GitHub", driver.getTitle());
    }

    @Then("Incorrect username or password error message should be displayed")
    public void incorrect_username_or_password_error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }
    
    @After
    public void quit() {
    	driver.quit();
    }

}
