package by.htp.belavia.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

import by.htp.belavia.entity.Flight;

public class InfoTest extends BaseTest {

	private static final Calendar DEPARTURE_DATA = new GregorianCalendar(2018, 8, 30, 0, 0, 0);
	private static final Calendar DEPARTURE_DATA_FINISH = new GregorianCalendar(2018, 9, 15, 0, 0, 0);
//	private static Set<Flight> listOfFlights = new TreeSet<>(new FlightComparator()); //By Date
	private static Set<Flight> listOfFlights = new TreeSet<>(); // By Price

	@Test
	public void OneWayInfoTest() {
		steps.oneWayRequest(DEPARTURE_DATA, listOfFlights);
		steps.oneWayRequestNewDate(DEPARTURE_DATA, DEPARTURE_DATA_FINISH, listOfFlights);
		steps.printListOfFlights(listOfFlights);
	}

}
