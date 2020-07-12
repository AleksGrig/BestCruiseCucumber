package steps;

import com.aventstack.extentreports.Status;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentTestManager;
import utilities.SeleniumDriver;

public class BeforeActions {

	@Before
	public static synchronized void setUp(Scenario scenario) {
		WebDriverManager.chromedriver().setup();
		ExtentTestManager.startTest(scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenario.getName());
	}
}
