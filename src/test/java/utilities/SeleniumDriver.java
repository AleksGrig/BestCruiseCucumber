package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {

	private final static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
	private final static int TIMEOUT = 15;
	private final static int PAGE_LOAD_TIMEOUT = 30;
	
	public static WebDriver getDriver() {
		WebDriver driver = threadLocal.get();
		if(driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			threadLocal.set(driver);
		}
		return driver;
	}
	
	public static void tearDown() {
		if(threadLocal.get() != null) {
			threadLocal.get().quit();
		}
		threadLocal.set(null);
	}
}
