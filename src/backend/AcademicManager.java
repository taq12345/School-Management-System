/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.sql.Date;
import dal.*;

/**
 *
 * @author Advisor
 */
public class AcademicManager extends Staff {

	public AcademicManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC,
			char gender, String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}
	
	protected boolean updateFacultyDetails(String School_id,String empID, String name, Date DOB, String phoneNo, String email,
			String CNIC, char gender, String emergencyContact, String address, Date n_dateHired, ArrayList<String> degrees,
			String position)
	{
		
		Staff s=Session.getHrDept().getStaffMember(empID);
		if(s!=null) {
			FacultyMember fm = Session.getInst().getSchool(School_id).getFacultyfromList(empID);
			if(fm!=null){
				fm.updateFaculty(name,DOB,phoneNo,email,CNIC,gender,emergencyContact, address, empID,dateHired,degrees, position);
				DAL.updateFacultyDetails(empID, name, DOB, phoneNo, email, CNIC, gender, emergencyContact, address,n_dateHired,
						degrees, position);
				return true;
			}
		}
		return false;

		}

	// hamza
	public boolean addCourse(String schoolID, String code, String name, int creditHours, String desc,
			ArrayList<String> preReqs) {

		for (String pCrs : preReqs) {
			if (pCrs.equals(code))
				preReqs.remove(pCrs);
		}

		School s = null;
		for (School sch : Session.getInst().getSchools()) {
			if (sch.getId().equals(schoolID))
				s = sch;
		}

		// Checks if course code is already taken
		if (s.ifCourseExists(code))
			return false;

		ArrayList<Course> crsPreReqs = s.getCoursesFromCode(preReqs);

		// Creating new course object
		Course crs = new Course(code, name, creditHours, desc, crsPreReqs, true);

		// Adds course in school
		return s.addCourse(crs);
	}

	// hamza
	public boolean updateCourse(String code, String name, int creditHours, String desc, ArrayList<String> preReqs) {

		for (String pCrs : preReqs) {
			if (pCrs.equals(code))
				preReqs.remove(pCrs);
		}

		School s = Session.getInst().getCourseSchool(code);

		// retrieving course object from school
		Course crs = s.getCourse(code);

		// Returns if invalid course id provided
		if (crs == null)
			return false;

		ArrayList<Course> crsPreReqs = s.getCoursesFromCode(preReqs);

		if (!DAL.updateCourseDetails(name, creditHours, desc, crsPreReqs, crs))
			return false;

		// Updating in ArrayList
		crs.updateDetails(name, creditHours, desc, crsPreReqs);
		return true;
	}

	// hamza
	public boolean removeCourse(String code) {

		School s = Session.getInst().getCourseSchool(code);

		// retrieving course object from school
		Course crs = s.getCourse(code);

		// Returns if invalid course id provided
		if (crs == null)
			return false;

		return s.removeCourse(crs);

	}

	// hamza
	public boolean removeFaculty(String empID, String repEmpID) {

		School sch = Session.getInst().getFacultySchool(empID);

		if (!sch.findFaculty(empID))
			return false;

		// replacement not found in school
		if (repEmpID != null && !sch.findFaculty(repEmpID))
			return false;

		return sch.removeFaculty(empID, repEmpID);

	}

	// hamza
	public boolean registerStudent(String schoolID, String name, Date DOB, String phone, String email, String CNIC,
			char gender, String eCont, String address, String rollNo, String fCNIC, String fName) {
		School sch = null;
		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}
		if (!sch.validateStudent(fCNIC))
			return false;

		Student std = new Student(name, new String("123456"), DOB, phone, email, CNIC, gender, eCont, address, rollNo,
				fCNIC, fName, 0, 0, 0, new ArrayList<CourseSection>(), new Transcript());

		return sch.addStudent(std);

	}	

	public boolean registerStudentInCourse(String schoolID, String rollNo, String courseCode, char secID) {
		School sch = null;

		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);
		Course c = sch.getCourse(courseCode);

		if (std != null && c != null) {
			Semester sem = Session.getSem();
			CourseSection cs = sch.getCourseSection(c, secID, sem);

			if (cs != null) {
				if (sch.registerStudentInCourse(std, c, cs, sem)) {
					Fee f = Session.getAccountsDept().getStudentFee(rollNo, sem.getSession());

					if (f == null) {
						f = new Fee(0, null, sem.getFeeDueDate(), std, sem);
						f.addAmount(sem.getPerCreditHrFee() * c.getCreditHours());
						Session.getAccountsDept().addFee(f);
						DAL.addFee(f);
					} else {
						f.addAmount(sem.getPerCreditHrFee() * c.getCreditHours());
						Session.getAccountsDept().updateFee(f);
						DAL.updateFeeAmount(f);
					}

					return true;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public boolean updateStudentCourseRegistration(String schoolID, String rollNo, String courseCode, char newID) {
		School sch = null;

		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);
		Course c = sch.getCourse(courseCode);

		if (std != null && c != null) {
			Semester sem = Session.getSem();
			CourseSection oldCs = std.getRegisteredCourseSection(c, sem);
			CourseSection newCs = sch.getCourseSection(c, newID, sem);

			if (oldCs != null && newCs != null && oldCs.getSectionID()!=newCs.getSectionID())
				return sch.updateStudentCourseRegistration(std, oldCs, newCs, sem);
			else
				return false;
		} else
			return false;
	}

	public boolean removeStudentCourseRegistration(String schoolID, String rollNo, String courseCode) {
		School sch = null;

		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);
		Course c = sch.getCourse(courseCode);

		if (std != null && c != null) {
			Semester sem = Session.getSem();

			CourseSection cs = std.getRegisteredCourseSection(c, sem);

			if (cs != null) {
				if (sch.removeStudentCourseRegistration(std, cs, sem)) {
					Fee f = Session.getAccountsDept().getStudentFee(rollNo, sem.getSession());

					if (f != null) {
						f.deductAmount(sem.getPerCreditHrFee() * c.getCreditHours());

						if (f.getAmount() == 0) {
							Session.getAccountsDept().removeFee(f);
							DAL.removeFee(f);
						} else {
							Session.getAccountsDept().updateFee(f);
							DAL.updateFeeAmount(f);
						}
					}

					return true;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public FacultyMember getFacultyMember(String empID) {
		return Session.getInst().getFacultyMember(empID);
	}

	public void addTimeTable(String fileName, String filePath, String schoolID, String session) {
		School sch = null;
		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}
		Semester sem = null;
		for (Semester s : Session.getInst().getSemesters()) {
			if (s.getSession().equals(session))
				sem = s;
		}

		Timetable tbl = new Timetable(fileName, filePath, sch, sem);
		Session.getAcademicDept().addTimeTable(tbl);
	}

	// hamza
	public boolean updateStudent(String rollNo, String name, Date DOB, String phone, String email, String CNIC,
			char gender, String eCont, String address, String fCNIC, String fName) {

		School sch = Session.getInst().getStudentSchool(rollNo);

		Student std = sch.getStudent(rollNo);

		if (std == null)
			return false;

		if (!sch.validateUpdateStudent(CNIC, std))
			return false;

		if (!DAL.updateStudentDetails(name, DOB, phone, email, CNIC, gender, eCont, address, fCNIC, fName, std))
			return false;

		std.updateDetails(name, DOB, phone, email, CNIC, gender, eCont, address, fCNIC, fName);
		return true;
	}

	// hamza
	public boolean removeStudent(String rollNo) {

		School sch = Session.getInst().getStudentSchool(rollNo);

		Student std = sch.getStudent(rollNo);

		if (std == null)
			return false;

		return sch.removeStudent(std);
	}

	public boolean isTeacherTeachingInCurrSem(String empID) {

		for (Course crs : Session.getInst().getFacultySchool(empID).getCourses()) {
			for (CourseSection crsSec : crs.getSections()) {
				if (crsSec.getTeacher().getEmpID().equals(empID) && crsSec.getSemester() == Session.getSem())
					return true;
			}
		}

		return false;
	}



	//////////////////////////////// ADD
	//////////////////////////////// SECTION////////////////////////////////////////////////////////////
	public boolean addSection(String schoolid, String c_code, String EmpID, char sID) {
		int index = 0;
		boolean secIndex = false;
		boolean add = false;
		ArrayList<Attendance> attendances = new ArrayList<Attendance>();
		index = Session.getInst().getSchool(schoolid).courseExistsByIndex(c_code);
		School sch = Session.getInst().getSchool(schoolid);

		FacultyMember f = sch.getFacultyfromList(EmpID);

		if (index != -1) {
			Course tempcourse = sch.getCourseFromCourses(index);
			secIndex = tempcourse.ifSectionExists(sID);
			if (secIndex == false) {
				if (sch.facultyExists(f) == true) {

					CourseSection cs = new CourseSection(sID, 50, 0, f, Session.getSem(), tempcourse, attendances);
					tempcourse.addCourseSection(cs);

					//// SQL CONN/////////////////
					DAL.addSection(sID, 50, 0, f, Session.getSem(), tempcourse);

					sch.updateCourseToCourses(index, tempcourse);
					add = true;
				}
			} else {
				// System.out.println("Section Already Exists");
				add = false;
			}

		}

		return add;

	}

	////////////////////////////////////// REMOVE
	////////////////////////////////////// SECTION/////////////////////////////////////////////////////////
	  public boolean removeSection(String schoolid, String c_code, char sID) {
		    int index = 0;
		    boolean secIndex = false;
		    boolean remove = false;
		    index = Session.getInst().getSchool(schoolid).courseExistsByIndex(c_code);
		    if (index != -1) {
		      Course tempcourse = Session.getSchl().getCourseFromCourses(index);
		      secIndex = tempcourse.ifSectionExists(sID);
		      if (secIndex == true) {
		        // SQL CON/////
		        if (DAL.removeSection(c_code, sID, Session.getSem()) == true) {
		          tempcourse.removeCourseSection(sID);
		          Session.getSchl().updateCourseToCourses(index, tempcourse);

		          ArrayList<Student> sectionStudents = Session.getInst().getSchool(schoolid)
		              .getStudentFromStudents(sID,c_code,Session.getSem().getSession());
		          ;
		          if (sectionStudents != null) {
		            for (Student s : sectionStudents) {
		              removeStudentCourseRegistration(schoolid, s.getRollNo(), c_code, sID); // Noumans
		                                                  // functionality
		            }
		          }

		          remove = true;
		        }
		      } else {
		        // System.out.println("Section Doesnot Exist");
		        remove = false;
		      }
		    }

		    /*
		     * else { System.out.println("Course Doesnot Exist"); }
		     */

		    return remove;
		  }

	//////////////////////////////////// UPDATE
	//////////////////////////////////// SECTION///////////////////////////////////////
	public boolean updateSection(String schoolid, String c_code, char secID, String EmpID, int maxs) {

		int index = 0;
		boolean secIndex = false;
		boolean update = false;

		FacultyMember nf = Session.getInst().getSchool(schoolid).getFacultyfromList(EmpID);
		index = Session.getSchl().courseExistsByIndex(c_code);
		if (index != -1) {
			Course tempcourse = Session.getSchl().getCourseFromCourses(index);
			secIndex = tempcourse.ifSectionExists(secID);
			if (secIndex == true) {
				if (Session.getSchl().facultyExists(nf) == true) {
					tempcourse.updateCourseSection(secID, nf, maxs);
					Session.getSchl().updateCourseToCourses(index, tempcourse);

					//// SQL CONN/////////////////

					DAL.updateSection(c_code, secID, nf, maxs, Session.getSem());

					update = true;
				} else
					update = false;
			} else {
				// System.out.println("Section Doesnot Exist");
				update = false;
			}
		}

		/*
		 * else { System.out.println("Course Doesnot Exist"); }
		 */

		return update;
	}

	/////////////////////////////////////////// NOUMAN/////////////////////////////////////////////
	public boolean removeStudentCourseRegistration(String schoolID, String rollNo, String courseCode, char secID) {
		School sch = null;

		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);
		Course c = sch.getCourse(courseCode);

		if (std != null && c != null) {
			Semester sem = Session.getSem();
			CourseSection cs = sch.getCourseSection(c, secID, sem);

			if (cs != null)
				return sch.removeStudentCourseRegistration(std, cs, sem);
			else
				return false;
		} else
			return false;
	}

	// function for updating school name
    // function for updating school name
    //in class academic manager change 	
	public boolean updateSchool(String id , String updatedName)
	{
		AcademicInstitution a= Session.getInst();
		boolean check= false;
		check=a.updateSchool(id,updatedName);
			
			if(check)
			{
				 DAL.updateSchoolDB(id,updatedName);
				return true;
			}
		return check;
	}
	// function for adding another school in the institution

	public boolean addSchool(String id, String name) {
		AcademicInstitution a= Session.getInst();
		return a.Validate(id, name);
	}

	public boolean addFacultyDegree(String empID, String degree) {
		FacultyMember f = this.getFacultyMember(empID);

		if (f != null) {
			f.addDegree(degree);
			return true;
		} else
			return false;
	}
	//main function in class Academic ManagerFactoryParameters	
	public boolean startNewSemester(String session, double fee, Date feeDueDate) {
		boolean check = false;
		AcademicInstitution a = Session.getInst();
		Semester curr = Session.getSem();
		// verification if session already exists
		for (int i = 0; i < a.getSemesters().size(); i++) {
			if (a.getSemesters().get(i).getSession().equals(session))
				return false;
		}
		Semester newSem = new Semester(session, true, fee, feeDueDate);
		a.addSem(newSem);// adding the new semester to the array list of semesters in academic institution
		check = dal.DAL.addNewSemester(session, fee, feeDueDate); // database insertion call
		if (check) {
			curr.setActive(false);// setting the status of the previous semester to !isActive
			Session.setSem(newSem);// setting the new semester in session class
		}
		return check;
	}
////////////////////////////////ADD FACULTY/////////////////////////////////////////////////////////
 public	boolean RegisterFaculty(String schoolid, String name, String password, Date DOB, String phoneNo, String email,
			String CNIC, char gender, String emergencyContact, String address, Date dateHired,
			ArrayList<String> degrees, String position, String EmpID) {

		int HRindex = Session.getHrDept().ifStaffExistsByIndex(EmpID);
		int Acdindex = Session.getAcademicDept().ifStaffExistsByIndex(EmpID);
		int Accindex = Session.getAccountsDept().ifStaffExistsByIndex(EmpID);
		int index = 0;
		boolean found = false;
		if (HRindex == -1 && Acdindex == -1 && Accindex == -1) {
			ArrayList<Staff> fmlist = new ArrayList<Staff>();
			fmlist = Session.getInst().getFacultyMemberList();

			for (Staff fm : fmlist) {
				if (CNIC.equals(fm.getCNIC())) {
					found = true;
					break;
				}

			}

			if (found == false) {
				index = Session.getInst().getSchool(schoolid).ifFacultyExistsByIndex(EmpID);
				if (index == -1) {
					Staff stf = new Staff(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address,
							EmpID, dateHired);
					FacultyMember temp = new FacultyMember(name, password, DOB, phoneNo, email, CNIC, gender,
							emergencyContact, address, EmpID, dateHired, degrees, position);
					//// SQL CONN/////////////////
					DAL.addFaculty(Session.getInst().getSchool(schoolid), name, password, DOB, phoneNo, email, CNIC, gender,
							emergencyContact, address, EmpID, dateHired, degrees, position);

					Session.getInst().getSchool(schoolid).addFacultyMember(temp);
					Session.getHrDept().addStaff(stf);
					return true;
				}

			}
		}
		return found;

	}
}
