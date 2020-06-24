package runner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"json:target/RunCuke/cucumber.json", 
													  "pretty", 
													  "html:target/positive/cucumber.html",
													  "com.cucumber.listener.ExtentCucumberFormatter" }, 
									features = "src/test/resources/features", 
									glue = "steps",
									monochrome = true,
									tags = {"@Search-Cruises" })
public class RunCuke extends AbstractTestNGCucumberTests {
	
	@BeforeClass
	public static void setup() {
		// Initiates the extent report and generates the output
		String fileName = "target/Extent_Reports/extent.html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile, false);

		// Loads the extent config xml to customize the report.
		ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "83.0.4103.106");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.141.59");

		// Also you can add system information using a hash map
		Map<String, String> systemInfo = new HashMap<>();
		systemInfo.put("Cucumber version", "v1.2.5");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);
	}
}
