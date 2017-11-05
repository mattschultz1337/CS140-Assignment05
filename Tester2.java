package assignment05;
import java.time.*;

public class Tester2 {
	public static void main(String[] args) {
		Person p1 = new Person("Dixon","Clifton",LocalDate.of(1992,4,10));
		Person p2 = new Person("Wu","Selena",LocalDate.of(1979,8,13));

		Student s1 = new Student(p1);
		Student s2 = new Student(p2);
		ByCourseProgress b1 = new ByCourseProgress();
		int bothNull = b1.compare(s1, s2);
		System.out.println("bothNull");
		System.out.println("Expected Selena Wu");
		printCompare(bothNull,s1,s2);
		Course c1 = new Course("Calc");
		c1.setNumReadings(2);
		c1.setPages(0, 5);
		c1.setPages(1, 5);
		Course c2 = new Course("Cs140");
		c2.setNumReadings(5);
		c2.setPages(0, 10);
		c2.setPages(1, 2);
		c2.setPages(2, 3);
		c2.setPages(3, 3);
		c2.setPages(4, 2);

		s1.setCourse(c1);
		System.out.println("One Null");
		int oneNull = b1.compare(s1,s2);
		System.out.println("Expected Clifton Dixon");
		printCompare(oneNull,s1,s2);

		int otheroneNull = b1.compare(s2,s1);
		System.out.println("other one Null...switcehd order");
		System.out.println("Expected Clifton Dixon");
		printCompare(otheroneNull,s2,s1);
		int i;
		s2.setCourse(c2);
		for(i=0;i<10;i++) {
			s2.read(0);
		}
		for(i=0;i<5;i++) {
			s1.read(1);
		}
		int bothSamePercentRead = b1.compare(s1,s2);
		System.out.println("both same percent read..Clifton higher percent complete");
		System.out.println("Expected Clifton Dixon");
		printCompare(bothSamePercentRead,s1,s2);
		s2.read(1);
		s2.read(1);
		int differentPercentRead = b1.compare(s1,s2);
		System.out.println("selena Higher percent read");
		System.out.println("Expected Selena");
		printCompare(differentPercentRead,s1,s2);
		
		

	}
	public static void printCompare(int x,Student s1,Student s2) {
		if(x < 0) {
			System.out.println(s2.getSelf() + " ranks higher\n");
		}
		else if(x > 0) {
			System.out.println(s1.getSelf() + " ranks higher\n");
		}
		else {
			System.out.println("They are the same\n");
		}
	}
}
