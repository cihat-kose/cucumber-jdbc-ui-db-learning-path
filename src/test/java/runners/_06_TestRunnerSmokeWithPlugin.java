//package runners;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions
//        (
//                tags = "@SmokeTest",
//                features = {"src/test/java/featureFiles"},
//                glue = {"stepDefinitions"},
//                plugin = {"html:target/site/cucumber-pretty.html"},
//                dryRun = false
//        )
//public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
//}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class _06_TestRunnerSmokeWithPlugin {

    public static void main(String[] args) {
        // Dynamically merge plugin setting with Cucumber Options
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String reportFile = "target/site/cucumber-pretty-" + timestamp + ".html";
        System.setProperty("cucumber.plugin", "html:" + reportFile);

        // Initialize the TestNG class
        org.testng.TestNG testNG = new org.testng.TestNG();
        testNG.setTestClasses(new Class[]{TestRunner.class});
        testNG.run();
    }

    @CucumberOptions(
            tags = "@SmokeTest",
            features = {"src/test/java/featureFiles"},
            glue = {"stepDefinitions"},
            plugin = {"pretty"},
            dryRun = false
    )
    public static class TestRunner extends AbstractTestNGCucumberTests {

        @BeforeClass(alwaysRun = true)
        public void setUp() {
            // Create a unique file name using a timestamp
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String reportFile = "target/site/cucumber-pretty-" + timestamp + ".html";

            // Dynamically change plugin setting
            System.setProperty("cucumber.plugin", "html:" + reportFile);
        }

        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }
}