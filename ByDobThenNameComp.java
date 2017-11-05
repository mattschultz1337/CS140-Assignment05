package assignment05;

import java.util.Comparator;

public class ByDobThenNameComp implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		if(person1.getDateOfBirth().compareTo(person2.getDateOfBirth()) ==0) {
			return person1.compare(person1,person2);
		}
		return person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
	}

}
