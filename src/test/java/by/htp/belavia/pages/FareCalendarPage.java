package by.htp.belavia.pages;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.belavia.entity.ReturnFlight;

public class FareCalendarPage extends AbstractPage {

	private static final By TICKETS_AVALIABLE_PRICE = By
			.xpath("/html/body/div[4]/div/form/div[1]/div/div/div/div/label[contains(text(),'BYN')]");
	private static final By TICKETS_AVALIABLE_DATE = By
			.xpath("/html/body/div[4]/div/form/div[1]/div/div/div/div/input");

	public FareCalendarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void returnFlightInfo(Set<ReturnFlight> listOFreturnFlights) {

		List<WebElement> ticketsAvaliableDate = driver.findElements(TICKETS_AVALIABLE_DATE);
		List<WebElement> ticketsAvaliablePrice = driver.findElements(TICKETS_AVALIABLE_PRICE);

		for (int i = 0; i < ticketsAvaliableDate.size(); i++) {
			ReturnFlight returnFlight = new ReturnFlight();
			String[] dep_ret = ticketsAvaliableDate.get(i).getAttribute("value").trim().split(":");
			String[] dep = dep_ret[0].split("-");
			String[] ret = dep_ret[1].split("-");
			returnFlight.setDep_date(
					new GregorianCalendar(new Integer("20" + dep[0]), new Integer(dep[1]) - 1, new Integer(dep[2])));
			returnFlight.setRet_date(
					new GregorianCalendar(new Integer("20" + ret[0]), new Integer(ret[1]) - 1, new Integer(ret[2])));
			String stringPrice = (ticketsAvaliablePrice.get(i).getText().trim().split(" "))[0];
			stringPrice = stringPrice.replaceAll(",", "");
			Double price = new Double(stringPrice);
			returnFlight.setPrice(price);
			listOFreturnFlights.add(returnFlight);
		}

	}

}
