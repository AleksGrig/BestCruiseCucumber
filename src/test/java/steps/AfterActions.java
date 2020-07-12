package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import utilities.ExtentManager;
import utilities.ExtentTestManager;
import utilities.SeleniumDriver;

public class AfterActions {

	@After
	public static void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			ExtentTestManager.logFail("Scenario Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		} else {
			ExtentTestManager.scenarioPass();
		}
		ExtentManager.getReporter().flush();
		SeleniumDriver.tearDown();
	}
}
