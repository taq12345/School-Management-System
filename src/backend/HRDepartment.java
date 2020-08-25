/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dal.DBAccess;

/**
 *
 * @author hamza
 */

public class HRDepartment extends Department {

	private ArrayList<Office> offices = null;
	private ArrayList<Allotment> allotments = null;

	public HRDepartment(ArrayList<Office> offices, ArrayList<Allotment> allotments, String name,
			ArrayList<Staff> staff) {
		super(name, staff);
		this.offices = offices;
		this.allotments = allotments;
	}

	public ArrayList<Office> getOffices() {
		return offices;
	}

	public void setOffices(ArrayList<Office> offices) {
		this.offices = offices;
	}

	public ArrayList<Allotment> getAllotments() {
		return allotments;
	}

	public void setAllotments(ArrayList<Allotment> allotments) {
		this.allotments = allotments;
	}

	public Office getOffice(String officeID) {
		for (Office off : offices) {
			if (off.getID().equals(officeID))
				return off;
		}
		return null;
	}

	// Helper function for add allotment
	// public Office getOffice(String Oid) {
	// for (int i = 0; i < (this.offices.size()); i++) {
	// if (this.offices.get(i).getID().equals(Oid)) {
	// return offices.get(i);
	// }
	// }
	// return null;
	// }

	// Helper function to for Add Allotment
	public boolean addAllotment(Allotment a) {
		this.allotments.add(a);
		return true;
	}

	// helper for Update Allotment
	public Allotment getAllotment(Staff s) {

		for (int i = 0; i < this.allotments.size(); i++) {
			if (this.allotments.get(i).getAllotedTo().equals(s)) {
				return this.allotments.get(i);
			}

		}
		return null;
	}

	public boolean ifOfficeExists(String officeID) {
		for (Office o : offices) {
			if (o.getID().equals(officeID))
				return true;
		}
		return false;
	}

	public boolean addOffice(Office o) {
		boolean check = Session.getDal().addOffice(o);
		if (check)
			offices.add(o);
		return check;
	}

	// Helper for remove Allotment (MUAZ)
	public boolean removeAllotment(Staff s) {
		for (int i = 0; i < this.allotments.size(); i++) {
			if (this.allotments.get(i).getAllotedTo().equals(s)) {
				this.allotments.remove(i);
				return true;
			}
		}
		return false;
	}

	// Helper for Update Allotment
	public boolean setAllotedOffice(Office a, Allotment b) {
		for (int i = 0; i < this.allotments.size(); i++) {
			if (this.allotments.get(i).equals(b)) {
				this.allotments.get(i).setAllotedOffice(a);
				return true;
			}

		}
		return false;
	}

}
