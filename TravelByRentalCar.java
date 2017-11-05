package assignment05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TravelByRentalCar implements TravelExpenses {

	private double totalRentalCost;
	private double fuelCost;
	private double fuelUsed;
	private int numberOfDaysRented;
	private String rentalCompany;	
	private LocalDate startDate;
	private LocalDate endDate;

	public TravelByRentalCar(double trc, String rc, LocalDate sd, LocalDate ed) {
		totalRentalCost = trc;
		rentalCompany = rc;
		startDate = sd;
		endDate = ed;
		numberOfDaysRented = (int)ChronoUnit.DAYS.between(startDate, endDate);

	}

	public void addFuel(double numGallons, double cost) {
		fuelUsed += numGallons;
		fuelCost += cost;
	}
	@Override
	public String getDescription() {
		String retVal =( "Rental car from " + rentalCompany + "for " + numberOfDaysRented + " days\nfrom " + startDate + " to " + endDate + ", " + Math.round(fuelUsed) + " gallons of fuel used");
		return retVal;
	}
	@Override
	public double amountToReimburse() {
		return totalRentalCost + fuelCost;
	}
	@Override
	public LocalDate getStartDate() {
		return startDate;
	}
	@Override
	public LocalDate getEndDate() {
		return endDate;
	}
	@Override
	public int sequenceNo() {
		return 4;
	}


}
