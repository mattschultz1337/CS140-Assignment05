package assignment05;

public class Student {
	private Person self;
	private Course course;
	private int[] progress;
	private boolean[] completed;

	public Student(Person s) {
		self = s;
	}
	public void setCourse(Course crs) {
		course = crs;
		progress = new int[course.getNumReadings()];
		completed = new boolean[course.getNumReadings()];
	}
	public void read(int reading) {
		if(progress[reading]<course.getTotalPages(reading)) {
			progress[reading] += 1;
		}
		if(progress[reading]==course.getTotalPages(reading)) {
			completed[reading] = true;
		}
	}
	public int percentRead() {
		int totalPagesRead = 0;
		int totalPagesOfReadingRequired = 0;
		for(int i=0;i<progress.length;i++) {
			totalPagesRead += progress[i];
			totalPagesOfReadingRequired += course.getTotalPages(i);
		}
		return (int)Math.round(((double)totalPagesRead/(double)totalPagesOfReadingRequired)*100);
	}
	public int percentCompleted() {
		int required = completed.length;
		int done = 0;
		for(int i=0;i<completed.length;i++) {
			if(completed[i]) {
				done++;
			}
		}
		return (int)Math.round(((double)done/(double)required)*100);
	}
	public Course getCourse() {
		return course;
	}
	public Person getSelf() {
		return self;
	}
}
