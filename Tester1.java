package assignment05;

import java.time.*;
import java.util.ArrayList;

public class Tester1 {

	public static void main(String[] args) {
		ArrayList<TravelExpenses> testList = new ArrayList<TravelExpenses>();
		TravelExpenses plane = new TravelByAir(LocalDate.of(2017,7,4),LocalDate.of(2017,7,6),"JetBlue", 300.0);
		System.out.println(plane.getDescription());
		TravelExpenses ownCar = new TravelByOwnCar(LocalDate.of(2017,1,1),LocalDate.of(2017, 1, 4));
		((TravelByOwnCar) ownCar).addMiles(200.0);
		System.out.println(ownCar.getDescription());
		TravelExpenses rail = new TravelByRail(LocalDate.of(2017, 3, 5),LocalDate.of(2017,4,8),"Amtrak",100.0);
		System.out.println(rail.getDescription());
		TravelExpenses mealplan = new Meal(MealType.LUNCH,5.0,LocalDate.of(2017,10,25));
		System.out.println(mealplan.getDescription());
		TravelExpenses rentCar = new TravelByRentalCar(80.0,"ZipCar",LocalDate.of(2017,11,8),LocalDate.of(2017,11,9));
		((TravelByRentalCar) rentCar).addFuel(20.0,50.50);
		System.out.println(rentCar.getDescription() + "\n~~~~~~~~~~~~~");
		testList.add(plane);
		testList.add(ownCar);
		testList.add(rail);
		testList.add(mealplan);
		testList.add(rentCar);
		TravelExpenses.printReport(testList);
		
		

	}

}
