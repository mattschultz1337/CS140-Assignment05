package assignment05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Lodging implements TravelExpenses {
	
	private LocalDate startDate;
	private LocalDate endDate;
	private String lodgingName;
	private int numberOfNights;
	private double costOfStay;
	
	public Lodging(LocalDate sd, LocalDate ed, String ln, double cs) {
		startDate = sd;
		endDate = ed;
		lodgingName = ln;
		numberOfNights =  (int)ChronoUnit.DAYS.between(startDate, endDate);
		costOfStay = cs;
	}
	
	@Override
	public String getDescription(){
		String retVal = "Lodging in " + lodgingName + "for " + numberOfNights + " from\n" + startDate + " - " + endDate;
		return retVal;
	}
	@Override
	public double amountToReimburse() {
		// TODO Auto-generated method stub
		return costOfStay;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	@Override
	public int sequenceNo() {
		return 6;
	}


}
