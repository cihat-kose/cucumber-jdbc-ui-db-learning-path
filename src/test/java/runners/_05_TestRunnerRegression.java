package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest or @Regression",
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"},
        plugin = {
                "pretty", // Log output readable to console
                "json:target/cucumber/cucumber.json", // JSON report (for Jenkins)
                "html:target/site/cucumber-mixed-report" // HTML report (to view from a local browser)
        }
)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
