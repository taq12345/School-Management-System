/**
 * 
 */
package backend;

import java.util.ArrayList;

import dal.*;
import java.sql.Date;
import java.util.Calendar;

/**
 * @author Ehtisham
 *
 */
public class Main {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); java.util.Date
		 * yourDate = sdf.parse("04/08/1996");
		 */

		/// DAL con1= new DAL();
		// mysqlCon con1= new mysqlCon();

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1996);
		c.set(Calendar.MONTH, 8);
		c.set(Calendar.DATE, 04);
		Date d = new Date(c.getTimeInMillis());

		User u = new User("HumnaGul", "123", d, "03008264529", "huny@gmail.com", "35202-98732-83734", 'F',
				"03884629231", "56D2");
		// u.viewDetails();

		String degree1 = "BSCS";
		String degree2 = "MATRIC";
		String degree3 = "FSC";
		ArrayList<String> deg = new ArrayList<String>();
		deg.add(degree1);
		deg.add(degree2);
		deg.add(degree3);

		Course pr = null;
		ArrayList<Course> preq = new ArrayList<Course>();
		preq.add(new Course("CS204", "CP", 23, "rkjgiuighught", null, false));
		preq.add(new Course("CS205", "CP2", 23, "rkjgiuighught", null, false));
		preq.add(new Course("CS206", "CP3", 23, "rkjgiuighught", null, null, false));

		Course c1 = new Course("CS201", "ITC", 23, "rkjgiuighught", preq, false);
		Course c2 = new Course("CS202", "ITC2", 23, "rkjgiuighught", preq, false);
		Course c3 = new Course("CS203", "ITC3", 23, "rkjgiuighught", preq, null, false);
		ArrayList<Course> lc = new ArrayList<Course>();
		lc.add(c1);
		lc.add(c2);
		lc.add(c3);

		ArrayList<Attendance> sa = null;

		FacultyMember f = new FacultyMember("Sara", "123", d, "03008264529", "huny@gmail.com", "35202-98732-83734", 'F',
				"03884629231", "56D2", "L123", d, deg, "Visisting");
		ArrayList<FacultyMember> fm = new ArrayList<FacultyMember>();
		fm.add(f);

		Semester s = new Semester("Fall2017", true, 0, d);

		CourseSection cs1 = new CourseSection('A', 50, 50, f, s, c1, sa);
		CourseSection cs2 = new CourseSection('B', 50, 50, f, s, c2, sa);
		ArrayList<CourseSection> cs = new ArrayList<CourseSection>();
		cs.add(cs1);

		// course section

		Student std = new Student("Maheen", "72863", d, "02020202021", "jun@hotmail.com", "35202-74547", 'F',
				"03884629231", "56D2", "L154164", "35202-98732-83734", "Khan", 3.76f, 56, 34, cs, null);
		ArrayList<Student> std1 = new ArrayList<Student>();
		std1.add(std);

		ArrayList<Staff> staff = new ArrayList<Staff>();
		Department d1 = new Department("BSHS", staff);

		School sch = new School("BSCS", "compsc", fm, std1, lc);

		// mysqlCon con1= new mysqlCon();
		// mysqlCon con= new mysqlCon();
		// con.addFaculty(sch,"ALi", "ehfheriu", d,"020202021", "jun@hotmail.com",
		// "35202-745", 'F',
		// "03884629231","56D2","L009", d, deg,"senior proff");

		// con.removeStaff("L810");

		// con.addSection('B', 50, 50, f, s, c2);

		// con.removeSection("CS202",'B',s);
		// con.updateSection("CS202", 'B', f,100,s);
		DAL.updateStaff("Hunyboo", d, "3456789876", "tjhbgfh", "kjh", 'M', "37462", "kmfkr", "L987", d);

		// on.addSchoolDB("1", "BSCS");
		// con.markAttendanceDB("1", "l154164", d, LAttendance.P);
		// con.deleteAllotmentDB("L12"); //updateAllotmentDB("1", "L123");
		// con.updateAllotmentDB("2","L123");
		// con.addAllotmentDB("1","L567");
		// con.addAllotmentDB("2","L810");

	}

}
