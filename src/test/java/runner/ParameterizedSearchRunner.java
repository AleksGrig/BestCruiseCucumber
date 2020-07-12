package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.Test;

@CucumberOptions(
        features="src/test/resources/features/ParameterizedSearchTest.feature",
        glue="steps"
)
public class ParameterizedSearchRunner {
    @Test
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
}
