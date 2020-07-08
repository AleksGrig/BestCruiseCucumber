package steps;

import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.SeleniumDriver;

public class BeforeActions {

	@Before
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
//		SeleniumDriver.setupDriver();
	}
}
