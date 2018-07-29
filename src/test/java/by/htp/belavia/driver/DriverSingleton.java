package by.htp.belavia.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private static WebDriver driver;

	static {
		System.out.println("DRIVER LOADING from static block...");
		driver = new FirefoxDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	private DriverSingleton() {
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
