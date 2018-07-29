package by.htp.belavia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReturnFlightInfoPage extends AbstractPage {
	private static final By FARE_CALENDAR = By.xpath("/html/body/div[4]/div/form/div[1]/div[1]/div[1]/div/div[2]/a");

	public ReturnFlightInfoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void goToFareCalendar() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(FARE_CALENDAR));
		WebElement fareCalendar = driver.findElement(FARE_CALENDAR);
		fareCalendar.click();
	}

}
