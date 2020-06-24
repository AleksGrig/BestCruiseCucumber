package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import enums.By;
import pages.locators.SearchPageLocators;
import utilities.SeleniumDriver;

public class SearchPage {

	private final SearchPageLocators searchPageLocators = new SearchPageLocators();

	public SearchPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(SeleniumDriver.getDriver(), 15), searchPageLocators);
	}

	public void sort(By by) {
		searchPageLocators.sortDrop.click();
		by.choose(searchPageLocators);
	}
	
	public void loadFirst() {
		searchPageLocators.firstCruiseLink.click();
	}
}
