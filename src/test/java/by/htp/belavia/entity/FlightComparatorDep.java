package by.htp.belavia.entity;

import java.util.Comparator;

public class FlightComparatorDep implements Comparator<ReturnFlight> {

	@Override
	public int compare(ReturnFlight fl_1, ReturnFlight fl_2) {
		if (fl_1.getDep_date().equals(fl_2.getDep_date()))
			return -1;
		return fl_1.getDep_date().compareTo(fl_2.getDep_date());
	}

}
