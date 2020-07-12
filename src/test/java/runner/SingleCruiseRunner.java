package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.Test;

@CucumberOptions(
        features="src/test/resources/features/SingleCruiseTest.feature",
        glue="steps"
)
public class SingleCruiseRunner {
    @Test
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
}
