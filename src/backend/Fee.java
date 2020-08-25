/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Date;

/**
 *
 * @author HumnaGul
 */
public class Fee {

	private double amount;
	private Date datePaid = null;
	private Date dueDate = null;
	private Student student = null;
	private Semester semester = null;

	public Fee(double amount, Date datePaid, Date dueDate, Student st, Semester sem) {
		this.amount = amount;
		this.datePaid = datePaid;
		this.dueDate = dueDate;
		this.student = st;
		this.semester = sem;
	}

	public double getAmount() {
		return amount;
	}

	public boolean setAmount(double amount) {
		boolean set = false;
		if (amount > -1) {
			this.amount = amount;
			set = true;
		}
		return set;
	}

	public Date getDatePaid() {
		return datePaid;
	}

	public boolean setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
		return true;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public boolean setDueDate(Date dueDate) {
		this.dueDate = dueDate;
		return true;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public void addAmount(double amount) {
		this.amount += amount;
	}

	public void deductAmount(double amount) {
		this.amount -= amount;
	}

}
