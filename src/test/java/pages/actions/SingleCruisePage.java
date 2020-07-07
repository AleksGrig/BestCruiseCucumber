package pages.actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import org.testng.SkipException;
import pages.locators.SingleCruisePageLocators;
import utilities.SeleniumDriver;

public class SingleCruisePage {

    private final SingleCruisePageLocators singleCruiseLocators = new SingleCruisePageLocators();

    public SingleCruisePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(SeleniumDriver.getDriver(), 15), singleCruiseLocators);
    }

    public void isCheaperThan(String priceLimit) {
        try {
            double price = Double.parseDouble(singleCruiseLocators.cruisePrice.getText().split(" ")[0]);
            if (price <= Double.parseDouble(priceLimit)) Assert.fail("Cruise found");
        } catch (NoSuchElementException e) {
            throw new SkipException("No such cruise found");
        }
    }
}
