package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/java/featureFiles/_01_Login.feature",
                "src/test/java/featureFiles/_02_Country.feature"
        },
        glue = {"stepDefinitions"},
        plugin = {"pretty"}
)
public class _02_TestRunnerSpesificFeatures extends AbstractTestNGCucumberTests {

}
