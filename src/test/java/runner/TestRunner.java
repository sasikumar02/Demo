package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = "src/test/java/features",
        glue="step_definitions"   ,
        plugin = {
                "com.epam.reportportal.cucumber.ScenarioReporter",
               // "com.epam.reportportal.cucumber.StepReporter",
                "json:src/test/resources/jsonReports/cucumber.json"
        },
        tags = "@Regression"
)

public class TestRunner{
}
