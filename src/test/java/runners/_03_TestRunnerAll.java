package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/site/cucumber-html-report",
                "json:target/cucumber.json"
        }
)
public class _03_TestRunnerAll extends AbstractTestNGCucumberTests {
}
