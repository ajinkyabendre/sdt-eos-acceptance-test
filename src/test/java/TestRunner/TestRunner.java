package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDefs","com.appiancorp.ps.cucumber"},
		plugin = {"pretty","html:target/cucumber","json:target/cucumber.json"})
public class TestRunner {

}