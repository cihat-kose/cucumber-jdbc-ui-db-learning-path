package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/featureFiles/_01_Login.feature"},
        glue = {"stepDefinitions"},
        plugin = {
                "pretty", // Beautifully readable console output
                "json:target/cucumber.json"
        }
)
public class _01_TestRunner extends AbstractTestNGCucumberTests {
}
