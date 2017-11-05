package assignment05;
import java.time.LocalDate;
import java.util.*;

public interface TravelExpenses {
	double mileage = 0.53; // cents per mile driven in a private car
	double BREAKFAST_MAX = 8.0;
	double LUNCH_MAX = 10.0;
	double DINNER_MAX = 40.0;

	double amountToReimburse();

	default String getDescription() {
		throw new UnsupportedOperationException("Must be implemented by class");
	}

	static void printReport(ArrayList<TravelExpenses> list) {
		Collections.sort(list, Comparator.comparing(TravelExpenses::getStartDate).thenComparing(new ExpensesOrder()));
		double total=0;
		for(TravelExpenses te: list) {
			System.out.print(te.getStartDate());
			if(!te.getStartDate().equals(te.getEndDate())) {
				System.out.print(" - " + te.getEndDate() + "\n");
			}
			System.out.println();
			String s = String.format("$%.2f", te.amountToReimburse()); // where te is a TravelExpense in list
			System.out.println( te.getDescription() + "\n");
			total += te.amountToReimburse();
			System.out.println("~~~~~~~~");
		}
		System.out.print("Total Expenses: $" );
		System.out.printf("%.2f",total);
		
	}
	default LocalDate getStartDate() {
		return LocalDate.now();
	}
	default LocalDate getEndDate() {
		return LocalDate.now();
	}
	default int sequenceNo() {
		return Integer.MAX_VALUE;
	}
}
