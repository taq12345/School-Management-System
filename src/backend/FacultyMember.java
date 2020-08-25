
package backend;

import dal.DAL;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Ehtisham
 *
 */

public class FacultyMember extends Staff {

	private ArrayList<String> degrees = null;
	private String position;

	public FacultyMember(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired, ArrayList<String> degrees,
			String position) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
		this.degrees = degrees;
		this.position = position;
	}

	public ArrayList<String> getDegrees() {
		return degrees;
	}

	public void setDegrees(ArrayList<String> degrees) {
		this.degrees = degrees;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}



	public Student getStudentAttendance(String rollNo) {
		return Session.getInst().getStudent(rollNo);
	}

	// mark attendance functionality
	public boolean markAttendance(String rollno, LAttendance atd, Date day, CourseSection cs) {
		boolean check=false;
		ArrayList<Attendance> atn=cs.getAttendance(day);
		if(atn!=null)
		{
			for(int i=0;i<cs.getAttendance(day).size();i++)
			{
				if(atn.get(i).getStudent().getRollNo().equals(rollno))
				{
					atn.get(i).setStatus(atd);
				}
				
			}
		
			check = DAL.markAttendanceDB( rollno, day, atd);
		
		}
		return check;
	}

	public ArrayList<CourseSection> getCurrentSemesterCourseSections() {
		ArrayList<CourseSection> sec;
		School sch = Session.getSchl();
		sec = sch.getFacultyCourseSections(this.empID);
		return sec;
	}

	public boolean updateGrade(String rollNum, String grade, CourseSection cs) {
	    Student stu = Session.getInst().getStudent(rollNum);
	    Grade g = stu.getCourseGrade(cs);
	    LGrade oldVal = g.getGrade();
	    g.setGrade(LGrade.valueOf(grade));
	    boolean check = Session.getDal().updateGrade(g, stu.getRollNo());
	    if (!check)
	      g.setGrade(oldVal);
	    return check;

	  }

	public boolean addAttendance(CourseSection b, Date d) {

		String CID = b.getCourse().getCourseCode();
		int key = DAL.getSectionKey(b.getSectionID(), CID, b.getSemester().getSession());
		School sc = Session.getSchl();

		for (int i = 0; i < sc.getStudents().size(); i++) {
			for (int j = 0; j < sc.getStudents().get(i).getStudiedCourses().size(); j++) {

				if (sc.getStudents().get(i).getStudiedCourses().get(j).equals(b)) {
					Attendance a = new Attendance(LAttendance.P, d, sc.getStudents().get(i));
					b.addAtd(a);
					DAL.addAttendanceDB(LAttendance.P, sc.getStudents().get(i).getRollNo(), key, d);
				}
			}

		}

		return true;
	}

	public ArrayList<Date> extractDate(CourseSection a) {
		ArrayList<Date> abc = new ArrayList<Date>();

		for (int i = 0; i < a.getStudentAttendance().size(); i++) {
			if (abc.contains(a.getStudentAttendance().get(i).getDay())) {

			} else {
				abc.add(a.getStudentAttendance().get(i).getDay());
			}

		}

		if (abc.size() == 0) {
			return null;
		} else
			return abc;
	}

	public ArrayList<Attendance> getAttendanceByDate(CourseSection a, Date d) {
		ArrayList<Attendance> abc = new ArrayList<Attendance>();

		for (int i = 0; i < a.getStudentAttendance().size(); i++) {
			if (a.getStudentAttendance().get(i).getDay().equals(d)) {
				abc.add(a.getStudentAttendance().get(i));
			}
		}
		if (abc.size() == 0) {
			return null;
		} else
			return abc;
	}

	public void addDegree(String degree) {
		this.degrees.add(degree);
	}
	protected void updateFaculty(String n_name, Date n_DOB, String n_phoneNo, String n_email, String n_CNIC, char n_gender,
			String n_emergencyContact, String n_address, String n_empID, Date n_dateHired, ArrayList<String> n_degrees,
			String n_position)
	{
		this.name = n_name;
		this.DOB = n_DOB;
		this.phoneNo = n_phoneNo;
		this.email = n_email;
		this.CNIC = n_CNIC;
		this.gender = n_gender;
		this.emergencyContact = n_emergencyContact;
		this.address = n_address;
		this.degrees = n_degrees;
		this.position = n_position;

	}
		

}
