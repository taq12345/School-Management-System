package backend;

public class Grade {

	private LGrade grade = null;
	private CourseSection course = null;
	
	public Grade(LGrade grade, CourseSection course) {
		this.grade = grade;
		this.course = course;
	}

	public LGrade getGrade() {
		return grade;
	}

	public void setGrade(LGrade grade) {
		this.grade = grade;
	}

	public CourseSection getCourseSection() {
		return course;
	}

	public void setCourseSection(CourseSection course) {
		this.course = course;
	}

}