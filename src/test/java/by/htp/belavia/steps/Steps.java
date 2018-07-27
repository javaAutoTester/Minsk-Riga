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
	private static final String HOME_PAGE_URL = "https://en.belavia.by/";

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
			OneWayFlightInfoPage infoPage = new OneWayFlightInfoPage(driver);
			infoPage.flightInfo(departureDataNext, listOfFlights);
			departureDataNext.add(Calendar.DAY_OF_MONTH, 1);
		}
		System.out.println("FINISH DATE");
	}

	public void ReturnRequest(Calendar departure_date, Calendar return_date, Set<ReturnFlight> listOFreturnFlights) {
		Calendar dep = (Calendar) departure_date.clone();
		dep.add(Calendar.DAY_OF_MONTH, -3);
		while (dep.compareTo(return_date) < 0) {
			Calendar ret = (Calendar) return_date.clone();
			ret.add(Calendar.DAY_OF_MONTH, 3);
			while (ret.compareTo(departure_date) > 0) {
				HomePageReturnQuery homePageReturn = new HomePageReturnQuery(driver);
				homePageReturn.goToPage();
				homePageReturn.fillFrom();
				homePageReturn.fillTo();
				homePageReturn.pickDate(dep, ret);
				homePageReturn.submitRequestForm();
				ReturnFlightInfoPage infoPage = new ReturnFlightInfoPage(driver);
				infoPage.goToFareCalendar();
				FareCalendarPage fareCalendar = new FareCalendarPage(driver);
				fareCalendar.returnFlightInfo(listOFreturnFlights);
				driver.get(HOME_PAGE_URL);
				ret.add(Calendar.DAY_OF_MONTH, -7);
			}
			dep.add(Calendar.DAY_OF_MONTH, 7);
		}
	}

	public void printListOfFlights(Set<Flight> listOfFlights) {
		for (Iterator iterator = listOfFlights.iterator(); iterator.hasNext();) {
			Flight flight = (Flight) iterator.next();
			System.out.println(flight.toString());
		}
	}

	public void printListOfReturnFlights(Set<ReturnFlight> listOfReturnFlights) {
		for (Iterator iterator = listOfReturnFlights.iterator(); iterator.hasNext();) {
			ReturnFlight flight = (ReturnFlight) iterator.next();
			System.out.println(flight.toString());
		}
	}

}
