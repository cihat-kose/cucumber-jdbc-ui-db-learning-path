package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "json:target/cucumber/cucumber.json", // JSON report (for CI/CD tools)
                "html:target/site/cucumber-smoke-report" // HTML report (for human eye tracking)
        }
)
public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
