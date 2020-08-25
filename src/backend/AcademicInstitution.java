package backend;

import java.util.*;
import dal.DAL;

/**
 * @author Ehtisham
 *
 */

public class AcademicInstitution {
	private String name;
	private String location;
	private ArrayList<School> schools = null;
	private ArrayList<User> users = null;
	private ArrayList<Department> depts = null;
	private ArrayList<Semester> semesters;

	public AcademicInstitution(String name, String location, ArrayList<School> schools, ArrayList<User> users,
			ArrayList<Department> depts, ArrayList<Semester> sems) {
		this.name = name;
		this.location = location;
		this.schools = schools;
		this.users = users;
		this.depts = depts;
		this.semesters = sems;
	}

	public ArrayList<School> getSchools() {
		return schools;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Department> getDepts() {
		return depts;
	}

	public void setDepts(ArrayList<Department> depts) {
		this.depts = depts;
	}

	public Staff getStaff(String empID) {
		for (User u : users) {
			if ((u instanceof Staff) && ((Staff) u).getEmpID().equals(empID))
				return (Staff) u;
		}
		return null;
	}

	public boolean studentLogin(String rollNum, String pass) {
		User u = getStudent(rollNum);
		if (u != null && u.matchPassword(pass)) {
			Session.setUser(u);
			Session.setType(UType.Student);
			return true;
		} else
			return false;
	}

	public boolean staffLogin(String empID, String pass) {
		User u = getStaff(empID);
		if (u != null && u.matchPassword(pass)) {
			Session.setUser(u);
			if (u instanceof HRManager)
				Session.setType(UType.HRManager);
			else if (u instanceof AcademicManager)
				Session.setType(UType.AcademicManager);
			else if (u instanceof FinanceManager)
				Session.setType(UType.FinanceManager);
			else if (u instanceof FacultyMember) {
				Session.setType(UType.FacultyMember);
				Session.setSchl(this.getFacultySchool(((FacultyMember) u).getEmpID()));
			}
			return true;
		} else
			return false;
	}

	public boolean logout() {
		if (Session.getUser() != null) {
			Session.setUser(null);
			Session.setType(UType.LoggedOut);
			return true;
		} else
			return false;
	}

	public School getSchool(String sID) {
		for (School s : schools) {
			if (s.getId().equals(sID))
				return s;
		}
		return null;
	}

	// hamza
	public Semester getSemester(String session) {

		for (Semester sem : semesters) {
			if (sem.getSession().equals(session))
				return sem;
		}

		return null;
	}

	public ArrayList<Semester> getSemesters() {
		return semesters;
	}

	// hamza
	public FacultyMember getFacultyMember(String empID) {
		for (School sch : schools) {
			for (FacultyMember FM : sch.getFaculty()) {
				if (FM.getEmpID().equals(empID))
					return FM;
			}
		}
		return null;
	}

	// public Staff getStaff(String empID) {
	//
	// for (School sch : schools) {
	// Staff temp = sch.getFacultyMember(empID);
	// if (temp != null)
	// return temp;
	// }
	//
	// for (Department dep : depts) {
	// Staff temp = dep.getStaffMember(empID);
	// if (temp != null)
	// return temp;
	// }
	//
	// return null;
	// }

	public void setSchools(ArrayList<School> schools) {
		this.schools = schools;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	// helper function to return the school from the id

	public boolean updateSchool(String id, String n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < (this.schools.size()); i++) {
			if (this.schools.get(i).getId().equals(id)) {
				schools.get(i).setName(n);
				return true;
			}
		}
		return false;
	}

	public boolean Validate(String id, String n) {
		boolean check = true;
		for (int i = 0; i < (this.schools.size()); i++) {
			if (this.schools.get(i).getId().equals(id) || this.schools.get(i).getName().equals(n)) {
				return false;
			}
		}
		check = DAL.addSchoolDB(id, n);
		if (check) {
			School temp = new School(id, n);
			schools.add(temp);

		}
		return check;
	}

	public School getSchoolByName(String name) {
		for (int i = 0; i < this.schools.size(); i++) {
			if (schools.get(i).getName().equals(name))
				return schools.get(i);
		}
		return null;
	}

	public School getStudentSchool(String rollNum) {
		for (School s : schools) {
			if (s.ifStudentExists(rollNum))
				return s;
		}
		return null;
	}

	public School getFacultySchool(String empID) {
		for (School s : schools) {
			if (s.ifFacultyExists(empID))
				return s;
		}
		return null;
	}

	// public Student getStudent(String rollNo) {
	//
	// for (School sch : schools) {
	// Student temp = sch.getStudent(rollNo);
	// if (temp != null)
	// return temp;
	// }
	// return null;
	// }

	public Student getStudent(String rollNum) {
		for (User u : users) {
			if ((u instanceof Student) && ((Student) u).getRollNo().equals(rollNum))
				return (Student) u;
		}
		return null;
	}

	public Course getCourse(String code) {

		for (School sch : schools) {
			return sch.getCourse(code);
		}
		return null;
	}

	public School getCourseSchool(String code) {
		for (School sch : schools) {
			if (sch.getCourse(code) != null)
				return sch;
		}

		return null;
	}

	public void loadFaculty(ArrayList<FacultyMember> arr) {
		for (FacultyMember f : arr) {
			users.add(f);
		}
	}
	   //yes! i used for each loop :v 	
		// in class academic Institutions
		public ArrayList<Staff> getFacultyMemberList() {
			ArrayList<Staff> abc = new ArrayList<Staff>();
			for (User u : users) {
				if ((u instanceof FacultyMember))
					abc.add((Staff) u);
			}
			if (abc.size() == 0) {
				return null;
			}
			return abc;
		}
		
		public ArrayList<Staff> getManagerList() {
			ArrayList<Staff> abc = new ArrayList<Staff>();
			for (User u : users) {
				if ((u instanceof AcademicManager || u instanceof HRManager|| u instanceof FinanceManager))
					abc.add((Staff) u);
			}
			if (abc.size() == 0) {
				return null;
			}
			return abc;
		}		
		
	
		//academicInstitution helper
		public void addSem(Semester newSem) {
			this.semesters.add(newSem);
		}

		boolean validateStaffCnic(String CNIC)
		{
			boolean check=false;
			ArrayList<Staff> arr=this.getFacultyMemberList();
			if(arr!=null)
			{
				for(int i=0;i<arr.size();i++)
				{
					if(arr.get(i).getCNIC().equals(CNIC))
						check=true;
				}
			}
			return check;
		}

		public boolean removeStaff(String empID) {
			for (User u : users) {
				if (      (u instanceof Staff  && ((Staff) u).getEmpID().equals(empID) ))
				{
					users.remove(u);
					return true;
				}
			}
			
			return false;
		}
}
