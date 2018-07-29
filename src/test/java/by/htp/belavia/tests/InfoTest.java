package by.htp.belavia.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.htp.belavia.entity.Flight;
import by.htp.belavia.entity.FlightComparator;
import by.htp.belavia.entity.ReturnFlightComparatorDep;
import by.htp.belavia.entity.ReturnFlightComparatorRet;
import by.htp.belavia.entity.ReturnFlight;

public class InfoTest extends BaseTest {

	private static final Calendar DEPARTURE_DATE = new GregorianCalendar(2018, 7, 1, 0, 0, 0);
	private static final Calendar RETURN_DATE = new GregorianCalendar(2018, 8, 1, 0, 0, 0);
	private static final Calendar DEPARTURE_DATE_FINISH = new GregorianCalendar(2018, 7, 5, 0, 0, 0);

	@Parameters({ "howToSortResult" })
	@Test
	public void OneWayInfoTest(@Optional("0") int howToSortResult) {
		System.out.println("FROM MINSK TO RIGA");
		System.out.println("DEPARTURE PERIOD: " + DEPARTURE_DATE.getTime() + " - " + DEPARTURE_DATE_FINISH.getTime());
		Set<Flight> listOfFlights = new TreeSet<>();
		if (howToSortResult == 0) {
			System.out.println("RESULT SORTED BY PRICE");
			listOfFlights = new TreeSet<>(); // ByPrice
		}
		if (howToSortResult == 1) {
			System.out.println("RESULT SORTED BY DEPARTURE DATE");
			listOfFlights = new TreeSet<>(new FlightComparator()); // ByDepartureDate
		}

		steps.oneWayRequest(DEPARTURE_DATE, listOfFlights);
		steps.oneWayRequestNewDate(DEPARTURE_DATE, DEPARTURE_DATE_FINISH, listOfFlights);
		steps.printListOfFlights(listOfFlights);
	}

	@Parameters({ "howToSortResult" })
	@Test
	public void ReturnInfoTest(@Optional("0") int howToSortResult) {
		System.out.println("FROM MINSK TO RIGA  RETURN");
		System.out.println("PERIOD: " + DEPARTURE_DATE.getTime() + " - " + RETURN_DATE.getTime());
		Set<ReturnFlight> listOfReturnFlights = new TreeSet<>();
		if (howToSortResult == 0) {
			System.out.println("RESULT SORTED BY PRICE");
			listOfReturnFlights = new TreeSet<>(); // //ByPrice
		}
		if (howToSortResult == 1) {
			System.out.println("RESULT SORTED BY DEPARTURE DATE");
			listOfReturnFlights = new TreeSet<>(new ReturnFlightComparatorDep()); // ByDepartureDate
		}
		if (howToSortResult == 2) {
			System.out.println("RESULT SORTED BY RETURN DATE");
			listOfReturnFlights = new TreeSet<>(new ReturnFlightComparatorRet()); // ByReturnDate
		}

		steps.ReturnRequest(DEPARTURE_DATE, RETURN_DATE, listOfReturnFlights);
		steps.printListOfReturnFlights(DEPARTURE_DATE, RETURN_DATE, listOfReturnFlights);
	}

}
