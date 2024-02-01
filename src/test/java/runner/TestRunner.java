package runner;





import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,//Skip execution of glue code.
        features = "src/test/java/features",
        glue="step_definitions"   ,
        plugin = {
                "json:src/test/resources/jsonReports/cucumber.json"
        },
        tags = {"@Regression"}
)


public class TestRunner{
@After
        public void takeScreenshot(){

}
}
