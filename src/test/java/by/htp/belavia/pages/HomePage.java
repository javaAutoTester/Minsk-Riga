package by.htp.belavia.pages;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

	private static final String HOME_PAGE_URL = "https://en.belavia.by/";

	private static final By FROM = By.xpath("//*[@id=\"OriginLocation_Combobox\"]");
	private static final By FROM_FIRST_DROPDOWN_ELEMENT = By.xpath("/html/body/ul[1]/li[1]");

	private static final By TO = By.xpath("//*[@id=\"DestinationLocation_Combobox\"]");
	private static final By TO_FIRST_DROPDOWN_ELEMENT = By.xpath("/html/body/ul[2]/li[1]");

	private static final By CALENDAR = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/div");
	private static final By DEPARTURE_DATE_PICKER = By
			.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[2]/div[2]/div[1]/div/a/i");

	private static final By CALENDAR_NEXT_LINK = By
			.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/div/div[2]/div/a/i");

	private static final By WAY_PICKER_RADIO_BUTTON_LIST = By
			.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[2]/div[1]/div/label");

	private static final By REQUEST_FORM = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void goToPage() {
		driver.get(HOME_PAGE_URL);
	}

	public void fillFrom() {
		WebElement elem = driver.findElement(FROM);
		elem.sendKeys("M");
		elem.sendKeys("i");
		elem.sendKeys("n");
		elem.sendKeys("s");
		elem.sendKeys("k");
		elem.sendKeys(" ");
		elem.sendKeys("(m");
		elem.sendKeys("s");
		elem.sendKeys("q)");
		try {
			driver.findElement(FROM_FIRST_DROPDOWN_ELEMENT).click();
		} catch (Exception e) {
			driver.findElement(FROM_FIRST_DROPDOWN_ELEMENT).click();
		}

	}

	public void fillTo() {
		WebElement elem = driver.findElement(TO);
		elem.sendKeys("r");
		elem.sendKeys("i");
		elem.sendKeys("g");
		elem.sendKeys("a");
		elem.sendKeys(" ");
		elem.sendKeys("(r");
		elem.sendKeys("i");
		elem.sendKeys("x)");
		try {
			driver.findElement(TO_FIRST_DROPDOWN_ELEMENT).click();
		} catch (Exception e) {
			driver.findElement(TO_FIRST_DROPDOWN_ELEMENT).click();
		}

	}

	public void pickOneWayTrip() {
		List<WebElement> radioButtoList = driver.findElements(WAY_PICKER_RADIO_BUTTON_LIST);
		radioButtoList.get(0).click();
	}

	public void pickDate(Calendar date) {
		System.out.println("Departure date: " + date.getTime());
		String month = date.getDisplayName(2, 2, new Locale("English", "US"));
		int year = date.get(1);
		int month_number = date.get(2);
		int day = date.get(5);
		WebElement datePicker = driver.findElement(DEPARTURE_DATE_PICKER);
		datePicker.click();
		WebElement calendar = driver.findElement(CALENDAR);

		while (!calendar.getText().contains(month + " " + year)) {
			// System.out.println("I'M GOING TO CLICK");
			driver.findElement(CALENDAR_NEXT_LINK).click();
		}

		// System.out.println("HERE IS THE DATE");
		String dataXpath = "/html/body/div[4]/div[1]/div/div/div[2]/div/div/div/table/tbody/tr/td[@data-month='"
				+ month_number + "']/a[contains(text(),'" + day + "')]";
		WebElement data = driver.findElement(By.xpath(dataXpath));
		data.click();
	}

	public void submitRequestForm() {
		driver.findElement(REQUEST_FORM).submit();
		while (driver.findElements(CAPTCHA).size() > 0) {
			AbstractPage.captchaHandler();
		}
	}

}
