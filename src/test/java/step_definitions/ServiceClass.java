package step_definitions;

import io.cucumber.java.Scenario;
import pages.BaseClass;
import pages.DriverFactory;

public class ServiceClass extends BaseClass {
    Scenario scenario = null;

    @io.cucumber.java.Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
    }
    @io.cucumber.java.Before
    public void initiateBrowser() throws Exception {
        //initializeBrowser();
        DriverFactory.initialiseBrowser();
    }
    @io.cucumber.java.After
    public void after() throws Exception {
        closeBrowser(scenario);
    }
}
