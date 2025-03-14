package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest or @Regression",
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"},
        plugin = {
                "pretty", // For more legible logs on the console
                "json:target/cucumber/cucumber.json"} // JSON report for Jenkins
)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
