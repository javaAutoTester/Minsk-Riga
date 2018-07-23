package by.htp.belavia.entity;

import java.util.Calendar;

public class Flight2 implements Comparable<Flight2>{
	private Calendar date;
	private String ticketType;
	private double price;
	
	public Flight2(Calendar date, String ticketType, double price) {
		super();
		this.date = date;
		this.ticketType = ticketType;
		this.price = price;
	}
	
	public Flight2() {
		super();
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ticketType == null) ? 0 : ticketType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight2 other = (Flight2) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (ticketType == null) {
			if (other.ticketType != null)
				return false;
		} else if (!ticketType.equals(other.ticketType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [date=" + date.getTime() + ", ticketType=" + ticketType + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Flight2 fl) {
		if(this.price == fl.price) return -1;
		return (int) (this.price - fl.price);
	}
	
}
