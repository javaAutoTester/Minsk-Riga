package by.htp.belavia.steps;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

import by.htp.belavia.entity.Flight;
import by.htp.belavia.pages.HomePage;
import by.htp.belavia.pages.HomePageNewRequest;
import by.htp.belavia.pages.OneWayFlightInfoPage;

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

	public void printListOfFlights(Set<Flight> listOfFlights) {
		for (Iterator iterator = listOfFlights.iterator(); iterator.hasNext();) {
			Flight flight = (Flight) iterator.next();
			System.out.println(flight.toString());
		}
	}

}
