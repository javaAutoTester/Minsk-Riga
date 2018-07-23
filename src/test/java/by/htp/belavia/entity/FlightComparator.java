package by.htp.belavia.entity;

import java.util.Comparator;

public class FlightComparator implements Comparator<Flight> {

	public int compare(Flight fl_1, Flight fl_2) {
		if (fl_1.getDate().equals(fl_2.getDate()))
			return -1;
		return fl_1.getDate().compareTo(fl_2.getDate());
	}

}
