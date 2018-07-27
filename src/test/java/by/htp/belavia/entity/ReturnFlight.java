package by.htp.belavia.entity;

import java.util.Calendar;

public class ReturnFlight implements Comparable<ReturnFlight> {
	private Calendar dep_date;
	private Calendar ret_date;
	private Double price;

	public ReturnFlight(Calendar dep_date, Calendar ret_date, Double price) {
		super();
		this.dep_date = dep_date;
		this.ret_date = ret_date;
		this.price = price;
	}

	public ReturnFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calendar getDep_date() {
		return dep_date;
	}

	public void setDep_date(Calendar dep_date) {
		this.dep_date = dep_date;
	}

	public Calendar getRet_date() {
		return ret_date;
	}

	public void setRet_date(Calendar ret_date) {
		this.ret_date = ret_date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dep_date == null) ? 0 : dep_date.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((ret_date == null) ? 0 : ret_date.hashCode());
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
		ReturnFlight other = (ReturnFlight) obj;
		if (dep_date == null) {
			if (other.dep_date != null)
				return false;
		} else if (!dep_date.equals(other.dep_date))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (ret_date == null) {
			if (other.ret_date != null)
				return false;
		} else if (!ret_date.equals(other.ret_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReturnFlight [dep_date=" + dep_date.getTime() + ", ret_date=" + ret_date.getTime() + ", price=" + price
				+ "]";
	}

	@Override
	public int compareTo(ReturnFlight fl) {
		if (this.price.equals(fl.price))
			return -1;
		return (int) (this.price.compareTo(fl.price));
	}

}
