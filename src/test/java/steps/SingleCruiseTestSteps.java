package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.actions.SingleCruisePage;
import utilities.SeleniumDriver;

public class SingleCruiseTestSteps {

    @Given("^user navigates to \"([^\"]*)\" page$")
    public void user_navigates_to_page(String url) {
        SeleniumDriver.getDriver().get(url);
    }

    @Then("^user compares \"([^\"]*)\" price with \"([^\"]*)\"$")
    public void user_compares_price_with(String cruiseName, String priceLimit) {
        SingleCruisePage cruisePage = new SingleCruisePage();
        cruisePage.isCheaperThan(priceLimit);
    }
}
