/**
 * 
 */
package backend;

import java.util.ArrayList;

import dal.DBAccess;
import dal.Load;
import dal.DAL;

/**
 * @author Ehtisham
 *
 */
public class Session {
	private static User user = null;
	private static UType type = UType.LoggedOut;
	private static AcademicInstitution inst = null;
	private static School schl = null;
	private static AcademicDepartment acdDept = null;
	private static AccountsDepartment accountsDept = null;
	private static HRDepartment hrDept = null;
	private static Semester sem = null;
	private static DAL dal = null;

	public static void initialize() {

		inst = new AcademicInstitution("FAST", "LAHORE", new ArrayList<School>(), new ArrayList<User>(),
				new ArrayList<Department>(), new ArrayList<Semester>());
		Load load = new Load();
		load.loadSemesters();
		load.loadSchools();
		load.loadFaculty();
		load.loadCourses();
		load.loadStudents();
		load.loadAttendance();
		load.loadAccountsDepartment();
		load.loadAcademicDepartment();
		load.loadHRDepartment();
		load.loadAllotments();
		load.loadPays();
		load.loadFees();
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Session.user = user;
	}

	public static UType getType() {
		return type;
	}

	public static void setType(UType type) {
		Session.type = type;
	}

	public static AcademicInstitution getInst() {
		return inst;
	}

	public static void setInst(AcademicInstitution inst) {
		Session.inst = inst;
	}

	public static School getSchl() {
		return schl;
	}

	public static void setSchl(School schl) {
		Session.schl = schl;
	}

	public static AcademicDepartment getAcademicDept() {
		return acdDept;
	}

	public static void setAcdDept(AcademicDepartment acdDept) {
		Session.acdDept = acdDept;
	}

	public static AccountsDepartment getAccountsDept() {
		return accountsDept;
	}

	public static void setAccountsDept(AccountsDepartment accountDept) {
		Session.accountsDept = accountDept;
	}

	public static HRDepartment getHrDept() {
		return hrDept;
	}

	public static void setHrDept(HRDepartment hrDept) {
		Session.hrDept = hrDept;
	}

	public static Semester getSem() {
		return sem;
	}

	public static void setSem(Semester sem) {
		Session.sem = sem;
	}

	public static void main(String[] args) {
		DBAccess.createConnection();
		initialize();

		// for(School sch:Session.getInst().getCourse("1")) {

		for (School sch : Session.getInst().getSchools()) {
			for (Student std : sch.getStudents()) {
				System.out.println(std.getName()+": "+std.computeCGPA());
			}

		}

	}

	public static DAL getDal() {
		return dal;
	}

	public static void setDal(DAL dal) {
		Session.dal = dal;
	}

}
