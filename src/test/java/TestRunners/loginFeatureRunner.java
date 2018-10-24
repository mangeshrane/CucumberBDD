package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/login.feature" }, glue = { "classpath:stepDefinations" }, 
				  plugin = {"pretty", "json:target/login.json" },
				  format = {"html: target/login.json"})
public class loginFeatureRunner {
}