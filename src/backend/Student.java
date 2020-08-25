package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class Student extends User {

	private String rollNo;
	private String fatherCNIC;
	private String fatherName;
	private float CGPA;
	private int creditsEarned;
	private int creditsAttempted;
	private ArrayList<CourseSection> courses = null;
	private Transcript transcript = null;

	public Student(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String rollNo, String fatherCNIC, String fatherName, float cGPA,
			int creditsEarned, int creditsAttempted, ArrayList<CourseSection> courses, Transcript transcript) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address);
		this.rollNo = rollNo;
		this.fatherCNIC = fatherCNIC;
		this.fatherName = fatherName;
		this.CGPA = cGPA;
		this.creditsEarned = creditsEarned;
		this.creditsAttempted = creditsAttempted;
		this.courses = courses;
		this.transcript = transcript;
	}

	public ArrayList<CourseSection> getStudiedCourses() {
		return courses;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getFatherCNIC() {
		return fatherCNIC;
	}

	public void setFatherCNIC(String fatherCNIC) {
		this.fatherCNIC = fatherCNIC;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public float getCGPA() {
		return CGPA;
	}

	public void setCGPA(float CGPA) {
		this.CGPA = CGPA;
	}

	public int getCreditsEarned() {
		return creditsEarned;
	}

	public void setCreditsEarned(int creditsEarned) {
		this.creditsEarned = creditsEarned;
	}

	public int getCreditsAttempted() {
		return creditsAttempted;
	}

	public void setCreditsAttempted(int creditsAttempted) {
		this.creditsAttempted = creditsAttempted;
	}

	public Grade getCourseGrade(String courseCode) {
		return transcript.getGrade(courseCode);
	}

	public ArrayList<CourseSection> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<CourseSection> courses) {
		this.courses = courses;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public ArrayList<CourseSection> checkSemesterRegistrations(Semester sem) {
		ArrayList<CourseSection> csList = new ArrayList<>();

		for (CourseSection cs : courses) {
			if (cs.getSemester().getSession().equals(sem.getSession()))
				csList.add(cs);
		}

		return csList;
	}

	// hamza
	public boolean updateDetails(String name, Date DOB, String phone, String email, String CNIC, char gender,
			String eCont, String address, String fCNIC, String fName) {

		this.name = name;
		this.DOB = DOB;
		this.phoneNo = phone;
		this.email = email;
		this.CNIC = CNIC;
		this.gender = gender;
		this.emergencyContact = eCont;
		this.address = address;
		this.fatherCNIC = fCNIC;
		this.fatherName = fName;

		return true;
	}

	// hamza
	public double computeGPA(ArrayList<Grade> grades) {

		double ret = 0;
		int credits = 0;

		for (Grade g : grades) {
			if(!g.getGrade().equals(LGrade.I)) {
				int grCreds = g.getCourseSection().getCourse().getCreditHours();
				credits += grCreds;
				ret += g.getGrade().getGpa() * grCreds;
			}
		}

		if (credits != 0)
			return ret / credits;
		else
			return 0;
	}

	// hamza
	public double computeCGPA() {
		int credits = 0;
		double ret = 0;
		for (Grade gr : transcript.getGrades()) {
			if(!gr.getGrade().equals(LGrade.I)) {
				credits += gr.getCourseSection().getCourse().getCreditHours();
				ret += gr.getCourseSection().getCourse().getCreditHours() * gr.getGrade().getGpa();
			}
		}
		if (credits != 0)
			return ret / credits;
		else
			return 0;
	}

	public boolean checkCoursesPassed(ArrayList<Course> cList) {
		return transcript.checkCoursesPassed(cList);
	}

	public void addStudentCourseRegistration(CourseSection cs) {
		this.courses.add(cs);
	}

	public boolean removeStudentCourseRegistration(CourseSection cs) {

		for (CourseSection sCS : courses) {
			if (sCS.getCourse().getCourseCode().equals(cs.getCourse().getCourseCode())
					&& sCS.getSectionID() == cs.getSectionID()
					&& sCS.getSemester().getSession().equals(cs.getSemester().getSession())) {
				this.courses.remove(sCS);
				return true;
			}
		}

		return false;
	}

	public void addGradeToTranscript(CourseSection cs, LGrade L) {
		Grade g = new Grade(L, cs);
		this.transcript.addGrade(g);
	}

	public boolean removeGradeFromTranscript(CourseSection cs, LGrade L) {
		Grade g = new Grade(L, cs);
		return this.transcript.removeGrade(g);
	}

	public void updateGradeSection(CourseSection oldCs, CourseSection newCs) {
		this.transcript.updateGradeSection(oldCs, newCs);
	}

	public boolean isRegistered(Course c, Semester sem) {

		for (CourseSection cs : this.checkSemesterRegistrations(sem)) {
			if (cs.getCourse().getCourseCode().equals(c.getCourseCode()))
				return true;
		}

		return false;
	}


	public boolean isPassed(Course c, Semester sem) {
		if (this.transcript.checkCoursePassed(c) && !this.isRegistered(c, sem))
			return true;
		else
			return false;
	}
	public CourseSection getRegisteredCourseSection(Course course, Semester sem) {

		for (CourseSection cs : courses) {
			if (cs.getCourse().getCourseCode().equals(course.getCourseCode())
					&& cs.getSemester().getSession().equals(sem.getSession())) {
				return cs;
			}
		}

		return null;
	}

	////////////////////////// REMOVE SECTION
	////////////////////////// HELPER/////////////////////////////////
	 public boolean ifSectionExists(char SectionID,String courseCode, String semester) {

		for (CourseSection cs : this.courses) {
			if (cs.getSectionID() == SectionID && cs.getCourse().getCourseCode().equals(courseCode) && cs.getSemester().getSession().equals(semester)) {
				return true;
			}
		}

		return false;
	}

	 public Grade getCourseGrade(CourseSection cs) {
		    for (Grade g : transcript.getGrades()) {
		      if (g.getCourseSection().getCourse().getCourseCode().equals(cs.getCourse().getCourseCode()) && g.getCourseSection().getSectionID() == cs.getSectionID() 
		          && g.getCourseSection().getSemester().getSession().equals(cs.getSemester().getSession()))
		        return g;
		    }
		    return null;
		  }
	/////////////////////// NOUMAN//////////////

	// public boolean removeStudentCourseRegistration(CourseSection cs) {
	// if(this.courses.contains(cs)) {
	// this.courses.remove(cs);
	// return true;
	// }
	// else
	// return false;
	// }

	/*
	 * public void viewDetails() { super.viewDetails();
	 * System.out.println("RollNo : \t" + rollNo);
	 * System.out.println("FatherCNIC : \t" + fatherCNIC);
	 * System.out.println("FatherName : \t" + fatherName);
	 * System.out.println("CGPA : \t" + CGPA);
	 * System.out.println("Credits Earned : \t" + creditsEarned);
	 * System.out.println("Credits Attempted : \t" + creditsAttempted);
	 * 
	 * 
	 * 
	 * }
	 */

}
