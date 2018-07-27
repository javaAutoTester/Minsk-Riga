package by.htp.belavia.pages;

import java.util.Calendar;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageReturnQuery extends AbstractPage {

	private static final String HOME_PAGE_URL = "https://en.belavia.by/";

	private static final By FROM = By.xpath("//*[@id=\"OriginLocation_Combobox\"]");
	private static final By FROM_FIRST_DROPDOWN_ELEMENT = By.xpath("/html/body/ul[1]/li[1]");

	private static final By TO = By.xpath("//*[@id=\"DestinationLocation_Combobox\"]");
	private static final By TO_FIRST_DROPDOWN_ELEMENT = By.xpath("/html/body/ul[2]/li[1]");

	private static final By CALENDAR = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/div");

	private static final By CALENDAR_NEXT_LINK = By
			.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/div/div[2]/div/a/i");

	private static final By REQUEST_FORM = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form");

	public HomePageReturnQuery(WebDriver driver) {
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

	public void pickDate(Calendar dep_date, Calendar ret_date) {
		System.out.println("Departure date: " + dep_date.getTime());
		String dep_month = dep_date.getDisplayName(2, 2, new Locale("English", "US"));
		int dep_year = dep_date.get(1);
		int dep_month_number = dep_date.get(2);
		int dep_day = dep_date.get(5);

		System.out.println("Return date: " + ret_date.getTime());
		String ret_month = ret_date.getDisplayName(2, 2, new Locale("English", "US"));
		int ret_year = ret_date.get(1);
		int ret_month_number = ret_date.get(2);
		int ret_day = ret_date.get(5);

		WebElement calendar = driver.findElement(CALENDAR);

		while (!calendar.getText().contains(dep_month + " " + dep_year)) {
			driver.findElement(CALENDAR_NEXT_LINK).click();
		}
		String dataXpathDep = "/html/body/div[4]/div[1]/div/div/div[2]/div/div/div/table/tbody/tr/td[@data-month='"
				+ dep_month_number + "']/a[contains(text(),'" + dep_day + "')]";
		WebElement dataDep = driver.findElement(By.xpath(dataXpathDep));
		dataDep.click();

		while (!calendar.getText().contains(ret_month + " " + ret_year)) {
			driver.findElement(CALENDAR_NEXT_LINK).click();
		}
		String dataXpathRet = "/html/body/div[4]/div[1]/div/div/div[2]/div/div/div/table/tbody/tr/td[@data-month='"
				+ ret_month_number + "']/a[contains(text(),'" + ret_day + "')]";
		WebElement dataRet = driver.findElement(By.xpath(dataXpathRet));
		dataRet.click();

	}

	public void submitRequestForm() {
		driver.findElement(REQUEST_FORM).submit();
		captchaHandler();
	}

}
