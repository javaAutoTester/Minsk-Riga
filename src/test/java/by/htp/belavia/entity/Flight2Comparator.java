package by.htp.belavia.entity;

import java.util.Comparator;

public class Flight2Comparator implements Comparator<Flight2>{

	public int compare(Flight2 fl_1, Flight2 fl_2 ){	
		return fl_1.getDate().compareTo(fl_2.getDate());
	}
}
