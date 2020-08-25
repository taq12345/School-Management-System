/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import dal.DBAccess;

/**
 *
 * @author hamza
 */
public class User {

	protected String name;
	protected String password;
	protected Date DOB = null;
	protected String phoneNo;
	protected String email;
	protected String CNIC;
	protected char gender;
	protected String emergencyContact;
	protected String address;

	public User(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address) {
		this.name = name;
		this.password = password;
		this.DOB = DOB;
		this.phoneNo = phoneNo;
		this.email = email;
		this.CNIC = CNIC;
		this.gender = gender;
		this.emergencyContact = emergencyContact;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean matchPassword(String pass) {
		if (pass.equals(password))
			return true;
		return false;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCNIC() {
		return CNIC;
	}

	public void setCNIC(String CNIC) {
		this.CNIC = CNIC;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	////////////////////////////////////// USER UPDATE
	////////////////////////////////////// DETAILS//////////////////////////////////////

	protected void updateDetails(String name, /* String password, */ Date DOB, String phoneNo, String email,
			String CNIC, char gender, String emergencyContact, String address) {
		this.name = name;
		// this.password = password;
		this.DOB = DOB;
		this.phoneNo = phoneNo;
		this.email = email;
		this.CNIC = CNIC;
		this.gender = gender;
		this.emergencyContact = emergencyContact;
		this.address = address;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	public void viewDetails() // NO NEED AS HAVE TO UPDATE WITH GUI
	{
		System.out.println("***** User Information *****");
		System.out.println("Name : \t" + name);
		System.out.println("DOB : \t" + DOB);
		System.out.println("Phone # : \t" + phoneNo);
		System.out.println("Email : \t" + email);
		System.out.println("CNIC : \t" + CNIC);
		System.out.println("Gender : \t" + gender);
		System.out.println("Emergency Contact : \t" + emergencyContact);
		System.out.println("Address : \t" + address);

	}

	public boolean changePassword(String old, String newPass) {
		if (matchPassword(old)) {
			boolean check = Session.getDal().changePassword(newPass, CNIC);
			if (check)
				password = new String(newPass);
			return check;
		} else
			return false;
	}

}
