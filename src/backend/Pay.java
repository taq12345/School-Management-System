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
public class Pay {

	private double amount;
	private Date datePaid = null;
	private Staff staffMember = null;

	public Pay(double amount, Date datePaid, Staff st) {
		this.amount = amount;
		this.datePaid = datePaid;
		this.staffMember = st;
	}

	public Double getAmount() {
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

	public Staff getStaffMember() {
		return staffMember;
	}

	public void setStaffMember(Staff staffMember) {
		this.staffMember = staffMember;
	}

}
