package pages.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import enums.Country;
import enums.Port;
import enums.Region;
import pages.locators.HomePageLocators;
import utilities.SeleniumDriver;

public class HomePage {

	private final HomePageLocators homePageLocators = new HomePageLocators();

	public HomePage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(SeleniumDriver.getDriver(), 15), homePageLocators);
	}

	public void chooseRegion(Region region) {
		homePageLocators.regionLink.click();
		region.choose(homePageLocators);
	}

	public void chooseCountry(Country country) {
		homePageLocators.countryLink.click();
		country.choose(homePageLocators);
	}
	
	public void chooseDeparturePort(Port departurePort) {
		homePageLocators.depaturePortLink.click();
		departurePort.choose(homePageLocators);
	}
	
	public void chooseMinLength(int minCruiseLength) {
		homePageLocators.numberOfDaysLink.click();
		homePageLocators.daySlider.click();
		Actions action = new Actions(SeleniumDriver.getDriver());
		for (int i = 0; i < minCruiseLength; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).perform();
		}
		homePageLocators.numberOfDaysLink.click();
	}
	
	public void chooseBeforeDate(String beforeDate) {
		String[] dayAndMonth = beforeDate.split(" ");
		homePageLocators.calendarLink.click();
		chooseMonth(dayAndMonth[1]);
		chooseDay(dayAndMonth[0]);
		homePageLocators.applyCalendar.click();
	}
	
	private void chooseDay(String date) {
		List<WebElement> dates = homePageLocators.dateBlock.findElements(By.tagName("td"));		
		dates.stream()
			.filter(e -> e.getText().equals(date))
			.filter(e -> e.getAttribute("class").contains("available"))
			.findFirst()
			.ifPresent(WebElement::click);
	}

	private void chooseMonth(String month) {
		while (!homePageLocators.currentMonth.getText().contains(month)) {
			homePageLocators.next.click();
		}
	}
	
	public void submitCruiseOptions() {
		homePageLocators.submitCruiseOptionsButton.click();
	}
}
