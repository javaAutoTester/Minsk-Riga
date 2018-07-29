package by.htp.belavia.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import by.htp.belavia.steps.Steps;
import by.htp.belavia.driver.DriverSingleton;

public class BaseTest {
	protected static WebDriver driver;
	protected Steps steps;

	@BeforeTest
	public void initDriver() {
		driver = DriverSingleton.getDriver();
		steps = new Steps(driver);
	}

	@AfterTest
	public void stopDriver() {
		System.out.println("DRIVER QUITTING...");
		driver.quit();
		driver = null;
	}

}
