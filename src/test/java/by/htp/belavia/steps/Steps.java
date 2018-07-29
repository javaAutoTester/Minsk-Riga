package by.htp.belavia.steps;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

import by.htp.belavia.entity.Flight;
import by.htp.belavia.entity.ReturnFlight;
import by.htp.belavia.pages.FareCalendarPage;
import by.htp.belavia.pages.HomePage;
import by.htp.belavia.pages.HomePageNewRequest;
import by.htp.belavia.pages.HomePageReturnQuery;
import by.htp.belavia.pages.OneWayFlightInfoPage;
import by.htp.belavia.pages.ReturnFlightInfoPage;

public class Steps {

	private WebDriver driver;

	public Steps(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void oneWayRequest(Calendar departureData, Set<Flight> listOfFlights) {
		HomePage homePage = new HomePage(driver);
		homePage.goToPage();
		homePage.fillFrom();
		homePage.fillTo();
		homePage.pickOneWayTrip();
		homePage.pickDate(departureData);
		homePage.submitRequestForm();
		homePage.captchaHandler();
		OneWayFlightInfoPage infoPage = new OneWayFlightInfoPage(driver);
		infoPage.flightInfo(departureData, listOfFlights);
	}

	public void oneWayRequestNewDate(Calendar departureData, Calendar departureDataFinish, Set<Flight> listOfFlights) {
		Calendar departureDataNext = (Calendar) departureData.clone();
		Calendar departureDataFinishNext = (Calendar) departureDataFinish.clone();
		departureDataNext.add(Calendar.DAY_OF_MONTH, 1);
		departureDataFinishNext.add(Calendar.DAY_OF_MONTH, 1);
		while (!departureDataNext.equals(departureDataFinishNext)) {
			HomePageNewRequest homePage = new HomePageNewRequest(driver);
			homePage.pickDate(departureDataNext);
			homePage.submitRequestForm();
			homePage.captchaHandler();
			OneWayFlightInfoPage infoPage = new OneWayFlightInfoPage(driver);
			infoPage.flightInfo(departureDataNext, listOfFlights);
			infoPage.captchaHandler();
			departureDataNext.add(Calendar.DAY_OF_MONTH, 1);
		}
	}

	public void ReturnRequest(Calendar departure_date, Calendar return_date, Set<ReturnFlight> listOFreturnFlights) {
		Calendar dep = (Calendar) departure_date.clone();
		while (dep.compareTo(return_date) < 0) {
			Calendar ret = (Calendar) return_date.clone();
			while (ret.compareTo(dep) > 0) {
				HomePageReturnQuery homePageReturn = new HomePageReturnQuery(driver);
				homePageReturn.goToPage();
				homePageReturn.fillFrom();
				homePageReturn.fillTo();
				homePageReturn.pickDate(dep, ret);
				homePageReturn.submitRequestForm();
				homePageReturn.captchaHandler();
				ReturnFlightInfoPage infoPage = new ReturnFlightInfoPage(driver);
				infoPage.goToFareCalendar();
				infoPage.captchaHandler();
				FareCalendarPage fareCalendar = new FareCalendarPage(driver);
				fareCalendar.returnFlightInfo(listOFreturnFlights);
				ret.add(Calendar.DAY_OF_MONTH, -7);
				if (ret.compareTo(dep) <= 0) {
					ret.add(Calendar.DAY_OF_MONTH, 4);
				}
			}
			dep.add(Calendar.DAY_OF_MONTH, 7);
			if (dep.compareTo(return_date) >= 0) {
				dep.add(Calendar.DAY_OF_MONTH, -4);
			}
		}
	}

	public void printListOfFlights(Set<Flight> listOfFlights) {
		int count = 1;
		for (Iterator<Flight> iterator = listOfFlights.iterator(); iterator.hasNext();) {
			Flight flight = (Flight) iterator.next();
			System.out.println(count+"  "+flight.toString());
			count++;
		}
	}

	public void printListOfReturnFlights(Calendar departure_date, Calendar return_date,
			Set<ReturnFlight> listOfReturnFlights) {
		int count = 1;
		for (Iterator<ReturnFlight> iterator = listOfReturnFlights.iterator(); iterator.hasNext();) {
			ReturnFlight returnFlight = (ReturnFlight) iterator.next();
			Calendar dep = returnFlight.getDep_date();
			Calendar ret = returnFlight.getRet_date();
			if (dep.compareTo(departure_date) >= 0 && ret.compareTo(return_date) <= 0) {
				System.out.println(count +"  " + returnFlight.toString());
				count++;
			}
		}
	}

}
