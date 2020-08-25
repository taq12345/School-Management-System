package backend;

import java.util.ArrayList;

public class Transcript {

	private ArrayList<Grade> grades = null;

	public Transcript() {
		this.grades = new ArrayList<>();
	}

	public Transcript(ArrayList<Grade> grades) {
		this.grades = grades;
	}

	public ArrayList<Grade> getGrades() {
		return grades;
	}

	public boolean checkCoursesPassed(ArrayList<Course> cList) {
		boolean passed;

		if (cList != null) {
			for (Course c : cList) {
				passed = false;

				for (Grade g : grades) {
					if (g.getCourseSection().getCourse().getCourseCode().equals(c.getCourseCode())
							&& !g.getGrade().equals(LGrade.F) && !g.getGrade().equals(LGrade.I)) {
						passed = true;
					}
				}

				if (!passed)
					return false;
			}

			return true;
		} else
			return true;
	}

	public boolean checkCoursePassed(Course course) {

		for (Grade g : grades) {
			if (g.getCourseSection().getCourse().getCourseCode().equals(course.getCourseCode())
					&& !g.getGrade().equals(LGrade.F) && !g.getGrade().equals(LGrade.I)) {
				return true;
			}
		}

		return false;
	}

	public void addGrade(Grade g) {
		this.grades.add(g);
	}

	public boolean updateGradeSection(CourseSection oldCs, CourseSection newCs) {
		for (Grade g : grades) {
			if (g.getCourseSection().getCourse().getCourseCode().equals(oldCs.getCourse().getCourseCode())
					&& g.getCourseSection().getSectionID() == oldCs.getSectionID() && g.getGrade().equals(LGrade.I)) {
				g.setCourseSection(newCs);
				return true;
			}
		}

		return false;
	}

	public boolean removeGrade(Grade g) {
		for (Grade grade : grades) {
			if (grade.getCourseSection().getCourse().getCourseCode()
					.equals(g.getCourseSection().getCourse().getCourseCode())
					&& grade.getCourseSection().getSectionID() == g.getCourseSection().getSectionID()
					&& grade.getGrade().equals(g.getGrade())) {
				this.grades.remove(grade);
				return true;
			}
		}

		return false;
	}

	public Grade getGrade(String courseCode) {
		for (Grade g : grades) {
			if (g.getCourseSection().getCourse().getCourseCode().equals(courseCode))
				return g;
		}
		return null;
	}
	public ArrayList<Grade> getSemesterGrades(String session){
		ArrayList<Grade> grades = new ArrayList<>();
		
		for(Grade g : this.grades) {
			if(g.getCourseSection().getSemester().getSession().equals(session))
				grades.add(g);
		}
		
		if(grades.size()==0)
			return null;
		else
			return grades;
	}

	// public boolean updateGradeSection(CourseSection oldCs, CourseSection newCs) {
	// for(Grade g: grades) {
	// if(g.getCourseSection()==oldCs && g.getGrade().equals(LGrade.I)) {
	// g.setCourseSection(newCs);
	// return true;
	// }
	// }
	// return false;
	// }

	// public boolean removeGrade(Grade g) {
	// if(this.grades.contains(g)) {
	// this.grades.remove(g);
	// return true;
	// }
	// else
	// return false;
	// }

}