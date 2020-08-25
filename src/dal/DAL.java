package dal;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;

import backend.*;

/**
 * @author hamza
 *
 */

public class DAL {

	public static boolean addCourse(Course c, School sch) {
		// Adding in Database
		try {
			Connection conn = DBAccess.getConnection();

			String query = "Insert Into course Values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());
			pst.setString(2, c.getCourseName());
			pst.setInt(3, c.getCreditHours());
			pst.setString(4, c.getDescription());
			pst.setString(5, sch.getId());
			pst.setBoolean(6, true);
			pst.execute();

			query = "Insert into CoursePrerequisites Values(?, ?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());

			for (Course pReq : c.getPrerequisites()) {

				pst.setString(2, pReq.getCourseCode());
				pst.execute();
			}

			conn.commit();

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

		return true;
	}

	public static boolean addStudent(Student std, School sch) {

		try {
			Connection conn = DBAccess.getConnection();

			String query = "Insert into User(Name, Password,DateOfBirth, PhoneNo, CNIC, email, gender, emergencyContact, Address) Values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, std.getName());
			pst.setString(2, "123456");
			pst.setDate(3, (java.sql.Date) std.getDOB());
			pst.setString(4, std.getPhoneNo());
			pst.setString(5, std.getCNIC());
			pst.setString(6, std.getEmail());
			pst.setString(7, Character.toString(std.getGender()));
			pst.setString(8, std.getEmergencyContact());
			pst.setString(9, std.getAddress());
			pst.execute();

			query = "Select UserID From User Where CNIC=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, std.getCNIC());
			ResultSet rs = pst.executeQuery();
			rs.next();
			String userID = rs.getString(1);

			query = "Insert into Student(UserID, RollNo, FatherName, FatherCNIC, CGPA, CreditsEarned, CreditsAttempted, SchoolID) Values(?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, userID);
			pst.setString(2, std.getRollNo());
			pst.setString(3, std.getFatherName());
			pst.setString(4, std.getFatherCNIC());
			pst.setDouble(5, std.getCGPA());
			pst.setInt(6, std.getCreditsEarned());
			pst.setInt(7, std.getCreditsAttempted());
			pst.setString(8, sch.getId());
			pst.execute();

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

		return true;
	}

	public static boolean removeCourse(Course c) {

		// Updating course status in database
		try {
			Connection conn = DBAccess.getConnection();

			String query = "Update course Set IsOffered=? where CourseCode=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setBoolean(1, false);
			pst.setString(2, c.getCourseCode());
			pst.executeUpdate();

			query = "Delete from coursesection Where CourseCode = (Select CourseCode From (Select * From coursesection) As A join semester s on A.session=s.session where s.IsActive=true and A.CourseCode=?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());
			pst.execute();

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

		return true;
	}

	public static boolean removeFaculty(String empID, String repEmpID) {

		String userID;

		try {
			Connection conn = DBAccess.getConnection();

			String query = "Select UserID From User Where UserID = (Select S.UserID From (Select * From User) As U join Staff S Where U.UserID=S.UserID and S.EmpID=?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, empID);
			ResultSet rs = pst.executeQuery();
			rs.next();
			userID = rs.getString(1);

			if (repEmpID != null) {
				query = "Update CourseSection Set TeacherID=? Where TeacherID=? and session=(select session from Semester where IsActive=1)";
				pst = conn.prepareStatement(query);
				pst.setString(1, repEmpID);
				pst.setString(2, empID);
				pst.executeUpdate();
			}

			query = "Delete from FacultyMember Where EmpID=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, empID);
			pst.execute();

			query = "Delete from Staff Where EmpID=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, empID);
			pst.execute();

			query = "Delete from User Where UserID=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, userID);
			pst.execute();

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

		return true;
	}

	public static boolean updateCourseDetails(String courseName, int creditHours, String description,
			ArrayList<Course> prerequisites, Course crs) {

		try {
			Connection conn = DBAccess.getConnection();

			String query = "Update Course Set CourseName=?, CreditHours=?, Description=? Where CourseCode=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, courseName);
			pst.setInt(2, creditHours);
			pst.setString(3, description);
			pst.setString(4, crs.getCourseCode());
			pst.executeUpdate();

			query = "Delete From CoursePrerequisites Where CourseCode=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, crs.getCourseCode());
			pst.execute();

			query = "Insert into CoursePrerequisites Values(?, ?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, crs.getCourseCode());

			for (Course pReq : prerequisites) {

				pst.setString(2, pReq.getCourseCode());
				pst.execute();
			}

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

		return true;
	}

	public static boolean updateStudentDetails(String name, Date DOB, String phone, String email, String CNIC,
			char gender, String eCont, String address, String fCNIC, String fName, Student stu) {

		try {
			Connection conn = DBAccess.getConnection();

			String query = "Update User Set Name=?, DateOfBirth=?, PhoneNo=?, CNIC=?, email=?, gender=?, emergencyContact=?, Address=? Where CNIC=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setDate(2, (java.sql.Date) DOB);
			pst.setString(3, phone);
			pst.setString(4, CNIC);
			pst.setString(5, email);
			pst.setString(6, Character.toString(gender));
			pst.setString(7, eCont);
			pst.setString(8, address);
			pst.setString(9, stu.getCNIC());
			pst.execute();

			query = "Update Student Set FatherName=?, FatherCNIC=? Where RollNo=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, fName);
			pst.setString(2, fCNIC);
			pst.setString(3, stu.getRollNo());
			pst.execute();

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

		return true;
	}

	// TODO: Check remove student functionalities
	public static boolean removeStudent(Student std) {

		String userID;

		try {
			Connection conn = DBAccess.getConnection();

			String query = "Select UserID From User Where UserID = (Select S.UserID From (Select * From User) As U join Student S Where U.UserID=S.UserID and S.RollNo=?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, std.getRollNo());
			ResultSet rs = pst.executeQuery();
			rs.next();
			userID = rs.getString(1);

			query = "Delete from Student Where RollNo=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, std.getRollNo());
			pst.execute();

			query = "Delete from User Where UserID=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, userID);
			pst.execute();

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

		return true;
	}

	public static ArrayList<Fee> getFees(Student std) {

		ArrayList<Fee> fees = new ArrayList<Fee>();

		try {
			Connection conn = DBAccess.getConnection();

			String query = "Select * From Fee Where RollNo=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, std.getRollNo());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				fees.add(new Fee(rs.getDouble(1), rs.getDate(2), rs.getDate(3), std,
						Session.getInst().getSemester(rs.getString(4))));
			}

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}

		return fees;
	}

	public static ArrayList<Pay> getPays(Staff staff) {

		ArrayList<Pay> pays = new ArrayList<Pay>();

		try {
			Connection conn = DBAccess.getConnection();

			String query = "Select * From pay Where EmpID=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, staff.getEmpID());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				pays.add(new Pay(rs.getDouble(1), rs.getDate(2), staff));
			}

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}

		return pays;
	}

	public static int getSectionKey(char sectionID, String courseCode, String session) {
		int sectionKey = -1;

		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			ResultSet rs = stmt.executeQuery("select * from coursesection where SectionID='" + sectionID
					+ "' and courseCode='" + courseCode + "' and Session='" + session + "';");

			while (rs.next())
				sectionKey = rs.getInt(1);

			con.commit();

			return sectionKey;
		} catch (Exception e) {
			System.out.println(e);
			return sectionKey;
		}
	}

	public static boolean incrementCurrSeats(int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate(
					"Update coursesection Set CurrSeats = CurrSeats+1 Where SectionKey =" + sectionKey + ";");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean decrementCurrSeats(int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate(
					"Update coursesection Set CurrSeats = CurrSeats-1 Where SectionKey =" + sectionKey + ";");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean addStudentCourseRegistration(String rollNo, int sectionKey) {
		try {
			DBAccess.createConnection();
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("insert into studentcoursesection (RollNo,SectionKey) values ('" + rollNo + "',"
					+ sectionKey + ");");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean removeStudentCourseRegistration(String rollNo, int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("delete from studentcoursesection where RollNo='" + rollNo + "' and SectionKey="
					+ sectionKey + ";");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean addGradeToTranscript(String grade, int sectionKey, String rollNo, String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("insert into grade (Grade,SectionKey,RollNo,Session) values ('" + grade + "',"
					+ sectionKey + ",'" + rollNo + "','" + session + "');");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean removeGradeFromTranscript(String grade, int sectionKey, String rollNo, String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("delete from grade where Grade ='" + grade + "' and sectionKey = " + sectionKey
					+ " and RollNo='" + rollNo + "' and Session='" + session + "';");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean updateGradeSection(String grade, int oldSectionKey, int newSectionKey, String rollNo,
			String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate(
					"update grade set SectionKey =" + newSectionKey + " where Grade = '" + grade + "' and SectionKey = "
							+ oldSectionKey + " and RollNo='" + rollNo + "' and Session='" + session + "';");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean removeStudentAttendance(String rollNo, int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate(
					"delete from attendance where RollNo ='" + rollNo + "' and SectionKey = " + sectionKey + ";");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static int getUserIDFacultyMember(String empID) {
		int userID = -1;
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			ResultSet rs = stmt.executeQuery("select * from staff where EmpID='" + empID + "';");

			while (rs.next())
				userID = rs.getInt(1);

			con.commit();

			return userID;
		} catch (Exception e) {
			System.out.println(e);
			return userID;
		}
	}

 public static boolean updateFacultyDetails(String empID, String name, Date DOB, String phoneNo, String email,
			String CNIC, char gender, String emergencyContact, String address, Date n_dateHired, ArrayList<String> degrees,
			String position) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			int userID = 0;
			userID=getUserIDFacultyMember(empID);
			if(userID!=0) {
			stmt.executeUpdate("update user set name ='" + name + "',DateOfBirth = '" + DOB + "',PhoneNo='" + phoneNo
					+ "', email='" + email + "',CNIC='" + CNIC + "',Gender='" + gender + "',EmergencyContact='"
					+ emergencyContact + "',Address='" + address + "' where UserID=" + userID + ";");
			stmt = DBAccess.getStatement();
			stmt.executeUpdate("UPDATE staff SET DateHired='" + n_dateHired + "'  WHERE EmpID='" + empID + "';");
			stmt = DBAccess.getStatement();
			stmt.executeUpdate("delete from facultymemberdegrees where EmpID='" + empID + "';");

			for (String d : degrees) {
				stmt = DBAccess.getStatement();
				stmt.executeUpdate("insert into facultymemberdegrees values ('" + empID + "','" + d + "');");
			}

			stmt = DBAccess.getStatement();
			stmt.executeUpdate("update facultymember set position='" + position + "' where EmpID='" + empID + "';");

			con.commit();

			return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

 	public static boolean addFee(Fee f) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("insert into fee (Amount,DueDate,RollNo,Session) values (" + f.getAmount()
					+ ",'" + f.getDueDate() + "','" + f.getStudent().getRollNo() + "','"
					+ f.getSemester().getSession() + "');");

			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateFeeAmount(Fee f) {

		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("update fee set Amount = " + f.getAmount() + " where RollNo = '"
					+ f.getStudent().getRollNo() + "' and Session = '" + f.getSemester().getSession() + "';");

			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean removeFee(Fee f) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("delete from fee where RollNo = '" + f.getStudent().getRollNo() + "' and Session = '"
					+ f.getSemester().getSession() + "';");

			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean addFaculty(School s, String name, String password, Date DOB, String phoneNo, String email,
			String CNIC, char gender, String emergencyContact, String address, String empID, Date dateHired,
			ArrayList<String> degrees, String position) {
		try {
			Statement stmt = DBAccess.getStatement();
			int userid = 0;

			ResultSet rs = stmt.executeQuery("select* from User where CNIC='" + CNIC + "'");
			while (rs.next())
				userid = rs.getInt(1);

			if (userid == 0) {
				stmt.executeUpdate(
						"INSERT INTO USER (NAME,PASSWORD,DateOfBirth,PhoneNo,Email,CNIC,Gender,EmergencyContact,Address) "
								+ "VALUES('" + name + "','" + password + "','" + DOB + "','" + phoneNo + "','" + email
								+ "','" + CNIC + "','" + gender + "','" + emergencyContact + "','" + address + "');");
				ResultSet rs1 = stmt.executeQuery("select* from User where CNIC='" + CNIC + "'");
				while (rs1.next())
					userid = rs1.getInt(1);

				stmt.executeUpdate("INSERT INTO staff (UserID,EmpID,DateHired) VALUES ('" + userid + "','" + empID
						+ "','" + dateHired + "');");
				stmt.executeUpdate("INSERT INTO facultymember (EmpID,POSITION,SchoolID) VALUES ('" + empID + "','"
						+ position + "','" + s.getId() + "');");
				for (String d : degrees) {
					stmt.executeUpdate(
							"INSERT INTO facultymemberdegrees (EmpID,Degree) VALUES ('" + empID + "','" + d + "');");
				}
				DBAccess.getConnection().commit();
				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static boolean addStaff(String name, String password, Date DOB, String phoneNo, String email, String CNIC,
			char gender, String emergencyContact, String address, String empID, Date dateHired) {
		try {
			Statement stmt = DBAccess.getStatement();

			int userid = 0;

			ResultSet rs = stmt.executeQuery("select* from User where CNIC='" + CNIC + "'");
			while (rs.next())
				userid = rs.getInt(1);

			if (userid == 0) {
				stmt.executeUpdate(
						"INSERT INTO USER (NAME,PASSWORD,DateOfBirth,PhoneNo,Email,CNIC,Gender,EmergencyContact,Address) "
								+ "VALUES('" + name + "','" + password + "','" + DOB + "','" + phoneNo + "','" + email
								+ "','" + CNIC + "','" + gender + "','" + emergencyContact + "','" + address + "');");
				ResultSet rs1 = stmt.executeQuery("select* from User where CNIC='" + CNIC + "'");
				while (rs1.next())
					userid = rs1.getInt(1);

				stmt.executeUpdate("INSERT INTO staff (UserID,EmpID,DateHired) VALUES ('" + userid + "','" + empID
						+ "','" + dateHired + "');");
				DBAccess.getConnection().commit();
				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	public static boolean updateStaff(String n_name, /* String n_password, */ Date n_DOB, String n_phoneNo,
			String n_email, String n_CNIC, char n_gender, String n_emergencyContact, String n_address, String empID,
			Date n_dateHired) {
		try {
			int userid = 0;
			Statement stmt = DBAccess.getStatement();
			ResultSet rs = stmt.executeQuery("select UserID from staff where EmpID='" + empID + "'");
			while (rs.next())
				userid = rs.getInt(1);

			if (userid != 0) {
				stmt.executeUpdate("UPDATE USER 	\r\n" + "SET NAME='" + n_name + "',DateOfBirth='" + n_DOB
						+ "',PhoneNo='" + n_phoneNo + "',Email='" + n_email + "',CNIC='" + n_CNIC + "',Gender='"
						+ n_gender + "',EmergencyContact='" + n_emergencyContact + "',Address='" + n_address
						+ "' WHERE UserID=+" + userid + ";");

				stmt.executeUpdate("UPDATE staff SET DateHired='" + n_dateHired + "'  WHERE EmpID='" + empID + "';");
				DBAccess.getConnection().commit();
				return true;

				// ,PASSWORD='"+n_password+"'
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	

	public static boolean addSection(char sectionID, int maxSeats, int currSeats, FacultyMember sectionTeacher,
			Semester semester, Course course) {
		try {
			Statement stmt = DBAccess.getStatement();
			int secid = 0;
			String code = "";
			int check_sem = 0;
			ResultSet rs = stmt.executeQuery("select CourseCode from course where CourseCode='" + course.getCourseCode()
					+ "' AND IsOffered = 1");
			while (rs.next())
				code = rs.getString(1);

			rs = stmt.executeQuery(
					"select IsActive from semester where Session='" + semester.getSession() + "' AND IsActive=1");
			while (rs.next())
				check_sem = rs.getInt(1);

			if (code != "" && check_sem == 1) {
				code = "";

				rs = stmt.executeQuery("select* from coursesection where SectionID='" + sectionID + "'AND CourseCode='"
						+ course.getCourseCode() + "'");
				while (rs.next())
					secid = rs.getInt(1);

				if (secid == 0) {
					stmt.executeUpdate(
							"INSERT INTO coursesection(`SectionID`,`CurrSeats`,`TeacherID`,`CourseCode`,`Session`) "
									+ "VALUES('" + sectionID + "','" + currSeats + "','" + sectionTeacher.getEmpID()
									+ "','" + course.getCourseCode() + "','" + semester.getSession() + "');");
					DBAccess.getConnection().commit();
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	public static boolean updateSection(String c_code, char secID, FacultyMember nf, int maxs, Semester s) {
		try {
			Statement stmt = DBAccess.getStatement();
			int secid = 0;
			String empid = "";
			int check_sem = 0;
			ResultSet rs = stmt.executeQuery("select* from coursesection where SectionID='" + secID
					+ "'AND CourseCode='" + c_code + "'AND Session='" + s.getSession() + "';");
			while (rs.next())
				secid = rs.getInt(1);

			rs = stmt.executeQuery(
					"select IsActive from semester where Session='" + s.getSession() + "' AND IsActive = 1");
			while (rs.next())
				check_sem = rs.getInt(1);

			if (secid != 0 && check_sem == 1) {
				rs = stmt.executeQuery("select EmpID from facultymember where EmpID='" + nf.getEmpID() + "'");
				while (rs.next())
					empid = rs.getString(1);
				if (empid != "") {
					stmt.executeUpdate("UPDATE coursesection SET MaxSeats = '" + maxs + "' WHERE SectionID='" + secID
							+ "'AND CourseCode='" + c_code + "'");
					stmt.executeUpdate("UPDATE coursesection SET TeacherID = '" + nf.getEmpID() + "' WHERE SectionID='"
							+ secID + "'AND CourseCode='" + c_code + "'");
					DBAccess.getConnection().commit();
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static boolean removeSection(String c_code, char sID, Semester semester) {
		try {
			Statement stmt = DBAccess.getStatement();
			String code = "";
			int secid = 0;
			int check_sem = 0;

			ResultSet rs = stmt
					.executeQuery("select CourseCode from course where CourseCode='" + c_code + "' AND IsOffered = 1");
			while (rs.next())
				code = rs.getString(1);

			rs = stmt.executeQuery(
					"select IsActive from semester where Session='" + semester.getSession() + "' AND IsActive = 1");
			while (rs.next())
				check_sem = rs.getInt(1);

			if (code != "" && check_sem == 1) {
				code = "";
				rs = stmt.executeQuery("select CourseCode from coursesection where CourseCode='" + c_code + "'");
				while (rs.next())
					code = rs.getString(1);

				if (code != "") {

					rs = stmt.executeQuery("select* from coursesection where SectionID='" + sID + "'");
					while (rs.next())
						secid = rs.getInt(1);
					System.out.println(secid);
					if (secid != 0) {
						stmt.executeUpdate("Delete from coursesection where SectionID='" + sID + "'AND CourseCode='"
								+ c_code + "'AND Session='" + semester.getSession() + "'");
						DBAccess.getConnection().commit();
						return true;
					}
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	public static void getSectionAttendance(CourseSection cs, ArrayList<Student> std) {
		try {
			Statement stmt = DBAccess.getStatement();
			ResultSet rs = stmt.executeQuery("select * from attendance where SectionKey='" + cs.getSectionID() + "'");
			String roll = "";

			ArrayList<Attendance> att = cs.getStudentAttendance();

			while (rs.next()) {
				roll = rs.getString(1);
				rs.getDate(1); // date
				for (Student s : std) {
					if (roll.equals(s.getRollNo())) {
						Student s1 = s;
						Attendance temp = new Attendance(LAttendance.valueOf(rs.getString(1)), rs.getDate(1), s1);
						att.add(temp);
					}
				}
			}

			DBAccess.getConnection().commit();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

     public static boolean addAllotmentDB(String oid, String Empid) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			stmt.executeUpdate("INSERT INTO Allotment (OfficeID,EmpID)" + "VALUES('" + oid + "','" + Empid + "');");
			con.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static boolean deleteAllotmentDB(String empid) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("delete from Allotment where EmpID='" + empid + "'");
			con.commit();
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	public static boolean updateAllotmentDB(String oid, String eid) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("UPDATE Allotment SET OfficeID='" + oid + "' where EmpID='" + eid + "'");
			con.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	public static boolean addSchoolDB(String sid, String name) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

				stmt.executeUpdate("INSERT INTO School (SchoolID,Name)" + "VALUES('" + sid + "','" + name + "');");
				con.commit();
				return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	public static boolean updateSchoolDB(String sid, String name) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
		
				stmt.executeUpdate("UPDATE School SET Name = '" + name + "' WHERE SchoolID='" + sid + "'");

				con.commit();
				return true;
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static boolean markAttendanceDB( String rollno, Date d, LAttendance a) {
		try {

			Statement stmt = DBAccess.getStatement();
			Connection conn = DBAccess.getConnection();

		
			stmt.executeUpdate("UPDATE Attendance SET Status = '" + a.toString() + "' WHERE RollNo = '" + rollno + "'  AND Day = '" +d + "'");
			conn.commit();
			return true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	public static boolean addAttendanceDB(LAttendance atd, String rollno, int key, Date d) {
		try {
			Connection conn = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("INSERT INTO Attendance (RollNo,Day,SectionKey,Status)" + "VALUES('" + rollno + "','" + d
					+ "','" + key + "','" + atd + "');");

			DBAccess.getStatement();
			conn.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static ArrayList<String> returnCourse(String code) {
		ArrayList<String> codes = new ArrayList<String>();
		try {
			Connection conn = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			ResultSet rs = stmt.executeQuery("select * from CoursePrerequisites where CourseCode='" + code + "';");

			while (rs.next()) {
				codes.add(rs.getString(2));
			}
			conn.commit();
			return codes;
		} catch (Exception e) {
			System.out.println(e);
			return codes;
		}

	}

	 public boolean addPay(Pay p) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("INSERT INTO Pay VALUES (" + p.getAmount() + ", " + "'" + p.getDatePaid() + "', '"
					+ p.getStaffMember().getEmpID() + "')");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	 public boolean updateFeeDate(Fee f) {
			boolean check = true;
			Statement stmnt = DBAccess.getStatement();
			try {
				if(f.getDatePaid()!=null) {
					stmnt.executeUpdate("UPDATE Fee SET DatePaid = '" + f.getDatePaid() + "' WHERE RollNo = '"
							+ f.getStudent().getRollNo() + "' AND Session = '" + f.getSemester().getSession() + "'");
				}
				else {
					stmnt.executeUpdate("UPDATE Fee SET DatePaid = null WHERE RollNo = '"
							+ f.getStudent().getRollNo() + "' AND Session = '" + f.getSemester().getSession() + "'");
				}
				DBAccess.getConnection().commit();
			} catch (SQLException e) {
				e.printStackTrace();
				check = false;
			}
			return check;
		}

	public boolean addOffice(Office o) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("INSERT INTO Office VALUES ('" + o.getID() + "')");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	public boolean changePassword(String newPass, String CNIC) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("UPDATE User SET Password = '" + newPass + "' WHERE CNIC = '" + CNIC + "'");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	public boolean updateGrade(Grade g, String rollNum) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			ResultSet rs = stmnt.executeQuery(
					"SELECT SectionKey FROM CourseSection WHERE SectionID = '" + g.getCourseSection().getSectionID()
							+ "' AND CourseCode = '" + g.getCourseSection().getCourse().getCourseCode()
							+ "' AND Session = '" + g.getCourseSection().getSemester().getSession() + "'");
			rs.next();
			String sectionKey = rs.getString(1);
			stmnt.executeUpdate("UPDATE Grade SET Grade = '" + g.getGrade().toString() + "' WHERE SectionKey = '"
					+ sectionKey + "' AND RollNo = '" + rollNum + "'");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	///////////////////// Dal function
	public static boolean addNewSemester(String session, double fee, Date feeDueDate) {
		boolean check;

		Statement stmnt = DBAccess.getStatement();
		try {

			stmnt.executeUpdate("UPDATE Semester SET IsActive = " + 0 + " WHERE IsActive = " + 1 + "");
			stmnt.executeUpdate("INSERT INTO Semester (Session,IsActive,PerCreditHourFee,FeeDueDate) VALUES ('"
					+ session + "'," + 1 + "," + fee + ",'" + feeDueDate + "');");
			check = true;
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	//DAL.java
	public static boolean addManager(String empID,String ManagerType,String Dname)
		{
			try {
				Statement stmt = DBAccess.getStatement();
			
				String empid="";
				
				ResultSet rs=stmt.executeQuery("select* from manager where EmpID='"+empID+"'"); 
				while(rs.next()) 
			        empid=rs.getString(1); 
			
				if(empid=="")
				{
					ResultSet rs1=stmt.executeQuery("select* from facultymember where EmpID='"+empID+"'"); 
					while(rs1.next()) 
				       empid=rs1.getString(1);
					if(empid=="") {
					stmt.executeUpdate("INSERT INTO manager (EmpID,ManagerType,DName) VALUES ('"+empID+"','"+ManagerType+"','"+Dname+"');");
					DBAccess.getConnection().commit();
					return true;
					}
				}

				}catch(Exception e){ System.out.println(e);}  
			
			return false;
		}
	public static boolean removeManager(String empID)
	{
		try {
			Statement stmt = DBAccess.getStatement();
		
			String empid="";
			
			ResultSet rs=stmt.executeQuery("select* from manager where EmpID='"+empID+"'"); 
			while(rs.next()) 
		        empid=rs.getString(1); 
		
			if(empid!="")
			{
				stmt.executeUpdate("Delete from manager where EmpID='"+empID+"'");
				DBAccess.getConnection().commit();
				return true;
				
			}

			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}

	public static boolean removeStaff(String empID)
	{
		try { 
			int userid=0; String eid="";
			Statement stmt = DBAccess.getStatement();
			ResultSet rs=stmt.executeQuery("select* from facultymember where EmpID='"+empID+"'"); 
			while(rs.next()) 
		        eid=rs.getString(1); 
		
			if(eid!="")
			{
				stmt.executeUpdate("Delete from facultymemberdegrees where EmpID='"+empID+"'");		
				stmt.executeUpdate("UPDATE coursesection SET TeacherID = NULL WHERE TeacherID='"+empID+"'");
				stmt.executeUpdate("Delete from facultymember where EmpID='"+empID+"'");
				rs=stmt.executeQuery("select UserID from staff where EmpID='"+empID+"'"); 
				while(rs.next()) 
			        userid=rs.getInt(1); 
				
				stmt.executeUpdate("Delete from staff where EmpID='"+empID+"'");
				stmt.executeUpdate("Delete from user where UserID='"+userid+"'");
				DBAccess.getConnection().commit();
				return true;
				
			}
			
			else if(eid=="")
			{
				
				ResultSet rs1=stmt.executeQuery("select UserID from staff where EmpID='"+empID+"'"); 
				while(rs1.next()) 
			        userid=rs1.getInt(1); 
				
				if(userid>0) {
					stmt.executeUpdate("Delete from staff where EmpID='"+empID+"'");
					stmt.executeUpdate("Delete from user where UserID='"+userid+"'");
					DBAccess.getConnection().commit();
					return true;
				}

			
			}	
	

			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}

	 public static boolean ifEIDexists(String EID) {
		boolean exists = false;;

		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			ResultSet rs = stmt.executeQuery("select * from staff where EmpID='" + EID +"';");

			while (rs.next())
				exists = true;

			con.commit();

			return exists;
		} catch (Exception e) {
			System.out.println(e);
			return exists;
		}
	}

	  public static boolean ifRollNoExists(String RollNo) {
			boolean exists = false;;

			try {
				Connection con = DBAccess.getConnection();
				Statement stmt = DBAccess.getStatement();

				ResultSet rs = stmt.executeQuery("select * from student where RollNo='" + RollNo +"';");

				while (rs.next())
					exists = true;

				con.commit();

				return exists;
			} catch (Exception e) {
				System.out.println(e);
				return exists;
			}
		}
}
