package assignment05;
import java.time.LocalDate;

public class Meal implements TravelExpenses {
	
	private MealType mealType;
	
	private double ammountPaid;
	private LocalDate mealDate;
	
	public Meal(MealType mt, double ap, LocalDate md) {
		mealType = mt;
		ammountPaid = ap;
		mealDate = md;
	}
	@Override
	public String getDescription() {
		String retVal = mealType +  " on " + mealDate;
		return retVal;
	}
	@Override
	public double amountToReimburse() {
		// TODO Auto-generated method stub
		return Math.max(ammountPaid, mealType.getMax());
	}
	@Override
	public LocalDate getStartDate() {
		return mealDate;
	}
	@Override
	public LocalDate getEndDate() {
		return mealDate;
	}
	public MealType getMealType() {
		return mealType;
	}
	

}
