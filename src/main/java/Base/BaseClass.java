package Base;

import Config.Configuration;
import Utils.Logging;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Mangesh Rane
 */

public class BaseClass {
	public Logger log = Logging.getLogger(BaseClass.class);
	private WebDriver driver;

	ThreadLocal<WebDriver> driverHolder = new ThreadLocal<WebDriver>();

	enum Browsers {
		CHROME, FIREFOX, IE, SAFARI
	}

	public void setDriver(String browserName) {
		Browsers browser = Browsers.CHROME;
		browser = browserName != null || browserName != "" ? Browsers.valueOf(browserName)
				: Browsers.valueOf(Configuration.getConfig("webdriver.browser"));
		if (Configuration.getConfig("webdriver.type").equalsIgnoreCase("GRID")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new RemoteWebDriver(capabilities);
		} else {
			log.info("Initializing webdriver for " + browser.toString());
			switch (browser) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				log.info("Setting up chromeDriver");
				ChromeOptions option = new ChromeOptions();
				option.addArguments("start-maximized");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setJavascriptEnabled(true);
				capabilities.setCapability(ChromeOptions.CAPABILITY, option);
				log.info("Setting up driver with capabilities");
				driver = new ChromeDriver(capabilities);
				log.info("Chrome Browser Started");
				break;

			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				log.info("Setting up firefox driver");
				driver = new FirefoxDriver();
				log.info("Firefox Browser Started");
				break;

			case IE:
				WebDriverManager.iedriver().setup();
				log.info("Setting up IE Driver");
				driver = new InternetExplorerDriver();
				log.info("IE Browser Started");
				break;

			case SAFARI:
				driver = new SafariDriver();
				log.info("SAFARI Browser Started");

			default:
				WebDriverManager.chromedriver().setup();
				log.info("Setting up chromedriver");
				driver = new ChromeDriver();
				log.info("using deafult Chrome Browser Started");
				break;
			}
		}
		log.info("IMPLICIT WAIT: " + Configuration.getConfig("webdriver.implicit.wait"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(Configuration.getConfig("webdriver.implicit.wait")),
				TimeUnit.SECONDS);
		log.info("Set implicit wait to driver: " + Configuration.getConfig("webdriver.implicit.wait"));
		driverHolder.set(driver);
	}

	public WebDriver getDriver() {
		return driverHolder.get();
	}

}
