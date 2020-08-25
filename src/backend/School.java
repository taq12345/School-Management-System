/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.sql.Date;

import dal.*;

import java.sql.*;

/**
 * @author Ehtisham
 *
 */
public class School {

	private String id;
	private String name;
	private ArrayList<FacultyMember> faculty = null;
	private ArrayList<Student> students = null;
	private ArrayList<Course> courses = null;

	public School(String id, String name, ArrayList<FacultyMember> faculty, ArrayList<Student> students,
			ArrayList<Course> courses) {
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.students = students;
		this.courses = courses;
	}

	public School(String sid, String n) {
		this.id = sid;
		this.name = n;
		this.faculty = new ArrayList<FacultyMember>();
		this.students = new ArrayList<Student>();
		this.courses = new ArrayList<Course>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<FacultyMember> getFaculty() {
		return faculty;
	}

	public void setFaculty(ArrayList<FacultyMember> faculty) {
		this.faculty = faculty;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	// hamza
	public boolean validateStudent(String CNIC) {

		for (Student st : students) {
			if (st.getCNIC().equals(CNIC))
				return false;
		}

		return true;
	}

	// hamza
	public boolean validateUpdateStudent(String CNIC, Student obj) {

		for (Student st : students) {
			if (st.getCNIC().equals(CNIC) && st != obj)
				return false;
		}

		return true;
	}

	// hamza
	public boolean ifCourseExists(String code) {

		for (Course c : this.courses) {
			if (c.getCourseCode().equals(code))
				return true;
		}
		return false;
	}

	// hamza
	public boolean findFaculty(String empID) {

		for (FacultyMember FM : faculty) {
			if (FM.getEmpID().equals(empID))
				return true;
		}

		return false;
	}

	// hamza
	public boolean addCourse(Course c) {

		// Adding in database
		if (!DAL.addCourse(c, this))
			return false;

		// Adding in ArrayList
		this.courses.add(c);
		return true;
	}

	// hamza
	public boolean addStudent(Student std) {

		if (!DAL.addStudent(std, this))
			return false;

		students.add(std);
		return true;
	}

	// hamza
	public boolean removeCourse(Course c) {

		if (!DAL.removeCourse(c))
			return false;

		for (CourseSection cSec : c.getSections()) {
			if (cSec.getSemester().getSession().equals(Session.getSem().getSession())) {
				removeCourseSectionObject(cSec);
				c.getSections().remove(cSec);
			}
				
		}

		c.setIsOffered(false);

		return true;
	}
	
	public void removeCourseSectionObject(CourseSection cSec) {
		
		for(Student std:students) {
			std.getCourses().remove(cSec);
		}
	}

	// hamza
	public boolean removeFaculty(String empID, String repEmpID) {

		FacultyMember facM = null;

		for (FacultyMember fac : faculty) {
			if (fac.getEmpID() == empID)
				facM = fac;
		}

		if (!DAL.removeFaculty(empID, repEmpID))
			return false;

		// Removing User
		for (User u : Session.getInst().getUsers()) {
			if (u.getCNIC().equals(facM.getCNIC())) {
				Session.getInst().getUsers().remove(u);
			}
		}

		// Removing Pay
		for (Pay pay : Session.getAccountsDept().getAllPays()) {
			if (pay.getStaffMember().getCNIC().equals(facM.getCNIC()))
				Session.getAccountsDept().getAllPays().remove(pay);
		}

		// Removing From School
		for (FacultyMember fac : faculty) {
			if (fac.getEmpID().equals(empID))
				faculty.remove(fac);
		}

		FacultyMember replacement = null;

		for (FacultyMember fac : faculty) {
			if (fac.getEmpID().equals( repEmpID))
				replacement = fac;
		}

		for (Course crs : courses) {
			for (CourseSection crsSec : crs.getSections()) {
				if (crsSec.getTeacher().getEmpID().equals(empID)) {
					if (crsSec.getSemester().getSession().equals(Session.getSem().getSession()))
						crsSec.setTeacher(replacement);
					else
						crsSec.setTeacher(null);
				}

			}
		}

		return true;
	}

	// hamza
	public boolean removeStudent(Student std) {

		if (!DAL.removeStudent(std))
			return false;

		// Removing User
		for (User u : Session.getInst().getUsers()) {
			if (u.getCNIC().equals(std.getCNIC())) {
				Session.getInst().getUsers().remove(u);
				break;
			}
		}
		
		ArrayList<Attendance> toRemove;

		// Removing Attendance
		for (CourseSection crs : std.getStudiedCourses()) {
			toRemove = new ArrayList<>();
			
			for (Attendance att : crs.getStudentAttendance()) {
				if (att.getStudent().getRollNo().equals(std.getRollNo()))
					toRemove.add(att);
			}
			
			crs.getStudentAttendance().remove(toRemove);
		}


		ArrayList<Fee> feeRemove = new ArrayList<>();
		
		for (Fee fee : Session.getAccountsDept().getAllFees()) {
			if (fee.getStudent().getRollNo().equals(std.getRollNo()))
				feeRemove.add(fee);
		}
		
		Session.getAccountsDept().getAllFees().remove(feeRemove);

		students.remove(std);
		return true;
	}

	public boolean ifStudentExists(String rollNum) {
		for (Student s : students) {
			if (s.getRollNo().equals(rollNum))
				return true;
		}
		return false;
	}

	public boolean ifFacultyExists(String empID) {
		for (FacultyMember f : faculty) {
			if (f.getEmpID().equals(empID))
				return true;
		}
		return false;
	}

	public ArrayList<Course> getCoursesFromCode(ArrayList<String> code) {

		ArrayList<Course> ret = new ArrayList<Course>();

		for (Course crs : courses) {
			ret.add(crs);
		}

		return ret;
	}

	public Student getStudent(String rollNo) {
		for (Student s : students) {
			if (s.getRollNo().equals(rollNo))
				return s;
		}

		return null;
	}

	public Course getCourse(String courseCode) {
		for (Course c : courses) {
			if (c.getCourseCode().equals(courseCode))
				return c;
		}

		return null;
	}

	public CourseSection getCourseSection(Course c, char secID, Semester sem) {
		return c.getCourseSection(secID, sem);
	}

	public boolean registerStudentInCourse(Student s, Course c, CourseSection cs, Semester sem) {

		if (s.checkSemesterRegistrations(sem).size() < 5) {
			ArrayList<Course> prereq = c.getPrerequisites();

			boolean passed = s.checkCoursesPassed(prereq);
			boolean seatAvailibility = cs.checkSeatAvailibility();

			if (passed && seatAvailibility) {
				int sectionKey = DAL.getSectionKey(cs.getSectionID(), c.getCourseCode(), sem.getSession());

				cs.incrementCurrSeats();
				DAL.incrementCurrSeats(sectionKey);

				s.addStudentCourseRegistration(cs);
				DAL.addStudentCourseRegistration(s.getRollNo(), sectionKey);

				s.addGradeToTranscript(cs, LGrade.I);
				DAL.addGradeToTranscript(LGrade.I.toString(), sectionKey, s.getRollNo(), sem.getSession());

				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean updateStudentCourseRegistration(Student s, CourseSection oldCs, CourseSection newCs, Semester sem) {

		if (newCs.checkSeatAvailibility()) {
			int oldSectionKey = DAL.getSectionKey(oldCs.getSectionID(), oldCs.getCourse().getCourseCode(),
					sem.getSession());
			int newSectionKey = DAL.getSectionKey(newCs.getSectionID(), newCs.getCourse().getCourseCode(),
					sem.getSession());

			newCs.incrementCurrSeats();
			DAL.incrementCurrSeats(newSectionKey);
			oldCs.decrementCurrSeats();
			DAL.decrementCurrSeats(oldSectionKey);

			s.addStudentCourseRegistration(newCs);
			DAL.addStudentCourseRegistration(s.getRollNo(), newSectionKey);
			s.removeStudentCourseRegistration(oldCs);
			DAL.removeStudentCourseRegistration(s.getRollNo(), oldSectionKey);
			oldCs.removeStudentAttendance(s);
			s.updateGradeSection(oldCs, newCs);
			DAL.updateGradeSection(LGrade.I.toString(), oldSectionKey, newSectionKey, s.getRollNo(), sem.getSession());

			return true;
		} else
			return false;
	}

	// helper for mark attendance
	// public Student getStudent(String s)
	// {
	// for(int i=0 ; i< this.students.size();i++)
	// {
	// if(this.students.get(i).getRollNo().equals(s))
	// {
	// return this.students.get(i);
	// }
	//
	// }
	// return null;
	// }

	////////////////////// ADD FACULTY
	////////////////////// HELPER/////////////////////////////////////////////////

	public int ifFacultyExistsByIndex(String empID) // returning index instead of boolean bcoz coz it later is required
													// for update
	{
		int found = 0;
		for (FacultyMember fm : this.faculty) {
			if (empID.equals(fm.getEmpID())) {
				found = faculty.indexOf(fm);
				break;
			}

			else
				found = -1;
		}

		return found;

	}

	public FacultyMember getFacultyfromList(String empID) {
		for (FacultyMember fm : this.faculty) {
			if (empID.equals(fm.getEmpID())) {
				return fm;
			}
		}
		return null;
	}

	//////////////////////////////// ADD FACULTY
	//////////////////////////////// ////////////////////////////////////////////////////

	protected boolean addFacultyMember(FacultyMember fm) {
		return faculty.add(fm);
	}

	//////////////// SECTION//////////////////////////////////////////////////////////////////////////
	public int courseExistsByIndex(String code) {
		int found = 0;
		for (Course c : this.courses) {
			if (code.equals(c.getCourseCode())) {
				found = courses.indexOf(c);
				break;
			}

			else
				found = -1;
		}

		return found;
	}

	protected Course getCourseFromCourses(int i) {
		return courses.get(i);
	}

	protected void updateCourseToCourses(int i, Course c) {
		courses.set(i, c);
	}

	////////////////////////////////// remove section helper///////////////////////
	public ArrayList<Student> getStudentFromStudents(char SectionID, String courseCode, String semester) {
		ArrayList<Student> sectionStudent = new ArrayList<Student>();
		for (Student s : this.students) {
			if (s.ifSectionExists(SectionID, courseCode, semester) == true) {
				sectionStudent.add(s);
			}
		}
		return sectionStudent;
	}

	protected boolean facultyExists(FacultyMember f) {
		boolean found = false;
		for (FacultyMember fm : this.faculty) {
			if (f.getEmpID().equals(fm.getEmpID())) {
				found = true;
				break;
			}

		}
		return found;
	}

	public boolean removeStudentCourseRegistration(Student s, CourseSection cs, Semester sem) {

		int sectionKey = DAL.getSectionKey(cs.getSectionID(), cs.getCourse().getCourseCode(), sem.getSession());

		if (s.removeGradeFromTranscript(cs, LGrade.I) && s.removeStudentCourseRegistration(cs)) {
			DAL.removeGradeFromTranscript(LGrade.I.toString(), sectionKey, s.getRollNo(), sem.getSession());
			DAL.removeStudentCourseRegistration(s.getRollNo(), sectionKey);
			cs.removeStudentAttendance(s);
			DAL.removeStudentAttendance(s.getRollNo(), sectionKey);
			cs.decrementCurrSeats();
			DAL.decrementCurrSeats(sectionKey);
			return true;
		} else
			return false;
	}

	public ArrayList<Course> getOfferedCourses() {
		ArrayList<Course> offeredCourses = new ArrayList<>();

		for (Course c : courses) {
			if (c.getIsOffered())
				offeredCourses.add(c);
		}

		if (offeredCourses.size() == 0)
			return null;
		else
			return offeredCourses;
	}

	public FacultyMember getFacultyMember(String empID) {
		for (FacultyMember fac : faculty) {
			if (fac.getEmpID().equals(empID))
				return fac;
		}

		return null;
	}

	// helper for mark attendance
	// public Course getCourse(String s)
	// {
	// for(int i=0 ; i< this.courses.size();i++)
	// {
	// if(this.courses.get(i).getCourseCode().equals(s))
	// {
	// return this.courses.get(i);
	// }
	//
	// }
	// return null;
	// }
	//


	public  ArrayList<CourseSection> getFacultyCourseSections(String id)   //class School just a minor change in implementation, returing null incase the arraylist is empty
	   {
		   ArrayList<CourseSection> sec= new ArrayList<CourseSection>();
		   Semester current=Session.getSem();
		   boolean check=false;
		    
		   for(int i=0; i<this.courses.size();i++)   
		   {
			   for(int j=0;j<courses.get(i).getSections().size();j++)
			   {
				   if(courses.get(i).getSections().get(j).getSectionTeacher().empID.equals(id)  &&  courses.get(i).getSections().get(j).getSemester().getSession().equals(current.getSession()))
				   {
					   sec.add(courses.get(i).getSections().get(j));
					   check=true;
				   }
				   
			   }
		   }
		if(!check)
	  	   {
	  	     return null;
	  	   }
		   return sec;
		   
	   }
	   //additional told by SID
	   public ArrayList<Course> getCurrentSemCourses()		//in class School
	   {
		   boolean check=false;
		   Semester s= Session.getSem();
		   ArrayList<Course> abc= new ArrayList<Course>();
		   for(int i=0; i<this.courses.size();i++)
		   {
			   for(int j=0; j< this.courses.get(i).getSections().size();j++)
			   {
				   if(this.courses.get(i).getSections().get(j).getSemester().getSession().equals(s.getSession()))
					   check=true;
			   
			   }
			   if(check)
			   {
				   abc.add(courses.get(i));
				   check=false;
			   }
		   }
		   
		   if(abc.size()==0)
		   {
			   return null;
		   }
		   return abc;
	   }

}
