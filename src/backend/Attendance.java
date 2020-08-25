/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Date;

/**
 *
 * @author Advisor
 */

public class Attendance {

	private LAttendance status;
	private Date Day;
	private Student student = null;

	public Attendance(LAttendance status, Date Day, Student student) {
		this.status = status;
		this.Day = Day;
		this.student = student;
	}

	public Attendance() {

	}

	public LAttendance getStatus() {
		return status;
	}

	public void setStatus(LAttendance status) {
		this.status = status;
	}

	public Date getDay() {
		return Day;
	}

	public void setDay(Date Day) {
		this.Day = Day;
	}

	// public CourseSection getSection() {
	// return section;
	// }
	//
	// public void setSection(CourseSection section) {
	// this.section = section;
	// }

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
