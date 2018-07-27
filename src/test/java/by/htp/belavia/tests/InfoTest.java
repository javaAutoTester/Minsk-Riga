package by.htp.belavia.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

import by.htp.belavia.entity.Flight;
import by.htp.belavia.entity.FlightComparatorDep;
import by.htp.belavia.entity.FlightComparatorRet;
import by.htp.belavia.entity.ReturnFlight;

public class InfoTest extends BaseTest {

	private static final Calendar DEPARTURE_DATE = new GregorianCalendar(2018, 8, 30, 0, 0, 0);
	private static final Calendar RETURN_DATE = new GregorianCalendar(2018, 9, 6, 0, 0, 0);
	private static final Calendar DEPARTURE_DATE_FINISH = new GregorianCalendar(2018, 9, 6, 0, 0, 0);
	// private static Set<Flight> listOfFlights = new TreeSet<>(new FlightComparator()); //By Date
	private static Set<Flight> listOfFlights = new TreeSet<>(); // ByPrice
	// private static Set<ReturnFlight> listOfReturnFlights = new TreeSet<>(); //ByPrice
	private static Set<ReturnFlight> listOfReturnFlights = new TreeSet<>(new FlightComparatorDep()); // ByDepartureDate
	// private static Set<ReturnFlight> listOfReturnFlights = new TreeSet<>(new FlightComparatorRet()); // ByReturnDate

	@Test
	public void OneWayInfoTest() {
		steps.oneWayRequest(DEPARTURE_DATE, listOfFlights);
		steps.oneWayRequestNewDate(DEPARTURE_DATE, DEPARTURE_DATE_FINISH, listOfFlights);
		steps.printListOfFlights(listOfFlights);
	}

	@Test
	public void ReturnInfoTest() {
		steps.ReturnRequest(DEPARTURE_DATE, RETURN_DATE, listOfReturnFlights);
		steps.printListOfReturnFlights(listOfReturnFlights);
		System.out.println("NUMBER OF FLIGHTS" + listOfReturnFlights.size());
	}

}
