package by.htp.belavia.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import by.htp.belavia.entity.Flight2;
import by.htp.belavia.entity.Flight2Comparator;

public class MainApp {

	public static void main(String[] args) {
		String number = "\n  890.00  ";
		double d = new Double(number);
		System.out.println("d: "+d);
		
//		Set<Flight2> set = new TreeSet<>(new Flight2Comparator());
		Set<Flight2> set = new TreeSet<>();
		Calendar cal_1 = new GregorianCalendar(2017, 0, 12, 13, 45, 0);
		Calendar cal_2 = new GregorianCalendar(2018, 3, 15, 16, 45, 0);
		Calendar cal_3 = new GregorianCalendar(2018, 3, 14, 12, 45, 0);
		Calendar cal_4 = new GregorianCalendar(2018, 4, 15, 13, 45, 0);
		Calendar cal_5 = new GregorianCalendar(2018, 4, 15, 13, 45, 0);
		
		Flight2 f_1 = new Flight2(cal_1, "Economy", 456.00);
		Flight2 f_2 = new Flight2(cal_2, "Economy", 45.00);
		Flight2 f_3 = new Flight2(cal_3, "Economy", 546.00);
		Flight2 f_4 = new Flight2(cal_4, "Economy", 45.00);
		Flight2 f_5 = new Flight2(cal_5, "Economy", 45.00);
        set.add(f_1);
        set.add(f_2);
        set.add(f_3);
        set.add(f_4);
        set.add(f_5);
        
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Flight2 flight2 = (Flight2) iterator.next();
			System.out.println(flight2);
		}
        
        System.out.println(cal_1.get(2)-cal_2.get(2));
	}
	
	

}
