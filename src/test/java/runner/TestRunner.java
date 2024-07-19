package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/clasFeatures",
					glue = {"stepDefinitions","hooks"},
					publish = true,
					plugin = {"pretty","html:target/CucumberReports/report.html"})
public class TestRunner {

}