package step_definitions;

import io.cucumber.java.Scenario;
import pages.BaseClass;

public class ServiceClass extends BaseClass {
    Scenario scenario = null;

    @io.cucumber.java.Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
    }
    @io.cucumber.java.Before
    public void initiateBrowser() {
        initializeBrowser();
    }
    @io.cucumber.java.After
    public void after() throws Exception {
        closeBrowser(scenario);
    }
}
