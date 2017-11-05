package assignment05;

import java.util.Comparator;
import java.time.*;
public class Person implements Comparator<Person> {

	private String lastName;
	private String firstNames;
	private LocalDate dateOfBirth;

	public Person(String l, String f, LocalDate dob) {
		lastName = l;
		firstNames= f;
		dateOfBirth = dob;
	}
	@Override
	public int compare(Person o1, Person other) {
		// TODO Auto-generated method stub
		return (o1.lastName + o1.firstNames).compareToIgnoreCase(other.lastName + other.firstNames);
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	@Override
	public String toString() {
		return firstNames + " " + lastName + " " + dateOfBirth;
	}

}
