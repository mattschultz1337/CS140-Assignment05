package assignment05;
import java.time.*;

public class TravelByOwnCar implements TravelExpenses {

	private double milesDriven;
	private LocalDate startDate;
	private LocalDate endDate;

	public TravelByOwnCar(LocalDate sd, LocalDate ed) {
		startDate = sd;
		endDate = ed;
	}
	public void addMiles(double m) {
		milesDriven += m;
	}
	@Override
	public String getDescription() {
		return "Own car used, miles driven: " + milesDriven;
	}
	@Override
	public double amountToReimburse() {
		// TODO Auto-generated method stub
		return mileage * milesDriven;
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
		return 5;
	}

}
