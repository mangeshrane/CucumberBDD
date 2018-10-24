package TestRunners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:features/login.feature" }, glue = {
		"classpath:stepDefination"}, plugin = { "pretty",
		"json:target/login.json" })
public class loginFeatureRunner extends AbstractTestNGCucumberTests {
}