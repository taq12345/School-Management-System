package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Nouman
 */
public class Course {

	private String courseCode;
	private String courseName;
	private int creditHours;
	private String description;
	private boolean isOffered;
	private ArrayList<Course> prerequisites = null;
	private ArrayList<CourseSection> sections = null;

	public Course(String courseCode, String courseName, int creditHours, String description,
			ArrayList<Course> prerequisites, boolean isOffered) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.description = description;
		this.prerequisites = prerequisites;
		this.sections = new ArrayList<>();
		this.isOffered = isOffered;
	}

	public Course(String courseCode, String courseName, int creditHours, String description,
			ArrayList<Course> prerequisites, ArrayList<CourseSection> sections, boolean isOffered) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.description = description;
		this.prerequisites = prerequisites;
		this.sections = sections;
		this.isOffered = isOffered;
	}

	public boolean getIsOffered() {
		return isOffered;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}

	public ArrayList<CourseSection> getSections() {
		return sections;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public void setIsOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}

	public boolean updateDetails(String courseName, int creditHours, String description,
			ArrayList<Course> prerequisites) {
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.description = description;
		this.prerequisites = prerequisites;
		return true;
	}

	public boolean addCourseSection(CourseSection section) {
		this.sections.add(section);
		return true;
	}

	public boolean ifSectionExists(char secID) {
		for (CourseSection s : this.sections) {
			if (s.getSectionID() == secID)
				return true;
		}

		return false;
	}

	public CourseSection getCourseSection(char secID, Semester sem) {
		for (CourseSection cs : sections) {
			if (cs.getSectionID() == secID && cs.getSemester().getSession().equals(sem.getSession()))
				return cs;
		}

		return null;
	}

	public CourseSection getCourseSection(String session, char secID) {
		for (CourseSection cSec : sections) {
			if (cSec.getSemester().getSession().equals(session) && cSec.getSectionID() == secID)
				return cSec;
		}

		return null;
	}

	// public CourseSection getCourseSection(Semester s, char SecId) {
	// for (int i = 0; i < this.sections.size(); i++) {
	// if ((this.sections.get(i).getSemester().equals(s)) &&
	// (this.sections.get(i).getSectionID() == SecId)) {
	// return this.sections.get(i);
	// }
	// }
	// return null;
	// }

	public boolean removeCourseSection(char secID) {
		for (CourseSection s : this.sections) {
			if (s.getSectionID() == secID && s.getSemester().equals(Session.getSem())) {
				this.sections.remove(s);
				return true;
			}
		}
		return false;
	}

	public boolean updateCourseSection(char secID, FacultyMember f, int max_seats) {
		for (CourseSection s : this.sections) {
			if (s.getSectionID() == secID && s.getSemester().equals(Session.getSem())) {
				s.setMaxSeats(max_seats);
				s.setFaculty(f);
				return true;
			}
		}
		return false;
	}
    public ArrayList<CourseSection> getCurrentSemCourseSecitons() // class: course section will return the course sections of current semster of that course
 {
    boolean check=false;
	   Semester s= Session.getSem();
	   ArrayList<CourseSection> abc= new ArrayList<CourseSection>();
	   for(int i=0; i<this.sections.size();i++)
	   {
		   if(this.sections.get(i).getSemester().getSession().equals(s.getSession()))
		   {
			   abc.add(this.sections.get(i));
		   		check=true;
		   }
	   }
	   if(!check)
	   {
		   return null;
	   }
	   return abc;
 }

}
