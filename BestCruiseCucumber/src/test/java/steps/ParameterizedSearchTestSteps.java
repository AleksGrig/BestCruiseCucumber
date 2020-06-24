package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.By;
import enums.Country;
import enums.Port;
import enums.Region;
import pages.actions.HomePage;
import pages.actions.SearchPage;

public class ParameterizedSearchTestSteps {
	
	private final HomePage home = new HomePage();
	private final SearchPage search  = new SearchPage();

	@Then("^user chooses destination \"([^\"]*)\"$")
	public void user_chooses_destination(String region) {
		home.chooseRegion(Region.valueOf(region));
	}

	@And("^chooses destination \"([^\"]*)\"$")
	public void chooses_destination(String country) {
		home.chooseCountry(Country.valueOf(country));
	}

	@And("^chooses departure \"([^\"]*)\"$")
	public void chooses_departure(String port) {
		home.chooseDeparturePort(Port.valueOf(port));
	}

	@And("^chooses minimum cruise \"([^\"]*)\"$")
	public void chooses_minimum_cruise(String minCruiseLength) {
		home.chooseMinLength(Integer.parseInt(minCruiseLength));
	}

	@And("^chooses before \"([^\"]*)\"$")
	public void chooses_before(String beforeDate) {
		home.chooseBeforeDate(beforeDate);
	}

	@And("^clicks submit button$")
	public void clicks_submit_button() {
		home.submitCruiseOptions();
	}

	@Then("^sorts cruises$")
	public void sorts_cruises() {
		search.sort(By.Price);
	}

	@And("^loads first cruise$")
	public void loads_first_cruise() {
		search.loadFirst();
	}

}
