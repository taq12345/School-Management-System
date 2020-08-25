
package backend;

import java.sql.Date;

/**
 * @author Ehtisham
 *
 */

public class Staff extends User {

	protected String empID;
	protected Date dateHired = null;

	public Staff(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address);
		this.empID = empID;
		this.dateHired = dateHired;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	///////////////////////////////// UPDATE STAFF
	///////////////////////////////// DETAILS///////////////////////////////////////////////////////
	protected void updateDetails(String name, /* String password, */ Date DOB, String phoneNo, String email,
			String CNIC, char gender, String emergencyContact, String address, String empID, Date dateHired) {
		super.updateDetails(name, /* password, */ DOB, phoneNo, email, CNIC, gender, emergencyContact, address);
		this.empID = empID;
		this.dateHired = dateHired;

	}
}
