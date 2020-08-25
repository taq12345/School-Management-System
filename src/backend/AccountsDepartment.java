/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Date;

import dal.DAL;
import dal.DBAccess;

import java.util.ArrayList;

/**
 *
 * @author hamza
 */

public class AccountsDepartment extends Department {

	private ArrayList<Pay> pays = null;
	private ArrayList<Fee> fees = null;

	public AccountsDepartment(ArrayList<Pay> pays, ArrayList<Fee> fees, String name, ArrayList<Staff> staff) {
		super(name, staff);
		this.pays = pays;
		this.fees = fees;
	}

	public Fee getStudentFee(String rollNo, String session) {
		for (Fee f : fees) {
			if (f.getStudent().getRollNo().equals(rollNo) && f.getSemester().getSession().equals(session))
				return f;
		}

		return null;
	}

	public void addFee(Fee f) {
		this.fees.add(f);
	}

	public boolean updateFee(Fee fee) {
		for (Fee f : fees) {
			if (f.getStudent().getRollNo().equals(fee.getStudent().getRollNo())
					&& f.getSemester().getSession().equals(fee.getSemester().getSession())) {
				f = fee;
				return true;
			}
		}

		return false;
	}

	public boolean removeFee(Fee fee) {
		for (Fee f : fees) {
			if (f.getStudent().getRollNo().equals(fee.getStudent().getRollNo())
					&& f.getSemester().getSession().equals(fee.getSemester().getSession())) {
				this.fees.remove(f);
				return true;
			}
		}

		return false;
	}

	public ArrayList<Pay> getAllPays() {
		return pays;
	}

	public void setPays(ArrayList<Pay> pays) {
		this.pays = pays;
	}

	public ArrayList<Fee> getAllFees() {
		return fees;
	}

	public void setFees(ArrayList<Fee> fees) {
		this.fees = fees;
	}

	public boolean checkPay(String empID, Date payDate) {
		for (Pay p : pays) {
			if (p.getStaffMember().getEmpID().equals(empID) && p.getDatePaid().equals(payDate))
				return true;
		}
		return false;
	}

	public boolean addPay(Pay p) {
		boolean check = Session.getDal().addPay(p);
		if (check)
			pays.add(p);
		return check;
	}

	public Fee getFee(String rollNum, String semester) {
		for (Fee f : fees) {
			if (f.getStudent().getRollNo().equals(rollNum) && f.getSemester().getSession().equals(semester))
				return f;
		}
		return null;
	}

	public ArrayList<Pay> getPays(String empID) {
		ArrayList<Pay> arr = new ArrayList<Pay>();
		for (Pay p : pays) {
			if (p.getStaffMember().getEmpID().equals(empID))
				arr.add(p);
		}
		if (arr.size() == 0)
			return null;
		else
			return arr;
	}

	public ArrayList<Fee> getFees(String rollNum) {
		ArrayList<Fee> arr = new ArrayList<Fee>();
		for (Fee f : fees) {
			if (f.getStudent().getRollNo().equals(rollNum))
				arr.add(f);
		}
		if (arr.size() == 0)
			return null;
		else
			return arr;
	}

}
