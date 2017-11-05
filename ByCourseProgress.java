package assignment05;

import java.util.Comparator;

public class ByCourseProgress implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getCourse() ==null && o2.getCourse()!=null) {
			return -1;
		}
		else if(o2.getCourse()==null && o1.getCourse()!=null) {
			return 1;
		}
		else if(o1.getCourse()==null&&o2.getCourse()==null) {
			return o1.getSelf().compare(o1.getSelf(),o2.getSelf());
		}
		else if(o1.getCourse()!=null && o2.getCourse()!=null) {
			int retVal =  o1.percentRead()-o2.percentRead();
			if(retVal==0) {
				if(o1.percentCompleted()-o2.percentCompleted()==0) {
					return o1.getSelf().compare(o1.getSelf(),o2.getSelf());
				}
				else {
					return o1.percentCompleted()-o2.percentCompleted();
				}
			}
			else {
				return retVal;
			}
		}

		return 0;
	}

}
