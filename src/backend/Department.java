/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author hamza
 */
public class Department {

	protected String name;
	protected ArrayList<Staff> staff = null;

	public Department(String name, ArrayList<Staff> staff) {
		this.name = name;
		this.staff = staff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Staff> getStaff() {
		return staff;
	}

	public void setStaff(ArrayList<Staff> staff) {
		this.staff = staff;
	}

	// hamza
	public Staff getStaffMember(String empID) {
		for (Staff st : staff) {
			if (st.getEmpID().equals(empID))
				return st;
		}
		return null;
	}

	/////////////////////////////////////////////////// ADD STAFF
	/////////////////////////////////////////////////// HELPER//////////////////////////////////////////////////
	protected int ifStaffExistsByIndex(String id) {
		int found = 0;
		for (Staff s : this.staff) {
			if (id.equals(s.getEmpID())) {
				found = staff.indexOf(s);
				break;
			}

			else
				found = -1;
		}

		return found;
	}

	protected boolean addStaff(Staff f) {
		return staff.add(f);
	}

	////////////////////////////////////////// REMOVE
	////////////////////////////////////////// STAFF/////////////////////////////////////////////////////////
	protected boolean removestaff(String empID) {
		for (Staff s : staff) {
			if (empID.equals(s.getEmpID())) {
				this.staff.remove(s);
				return true;
			}

			else
				break;
		}

		return false;
	}

	///////////////////////////////////////////// UPDATE STAFF
	///////////////////////////////////////////// ///////////////////////////////////////////////////////////////

	protected Staff getStaffMember(int i) {
		return this.staff.get(i);
	}

	protected void updateStaffMemberToStaff(int i, Staff s) {
		staff.set(i, s);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Staff getEmp(String id) {
		for (int i = 0; i < staff.size(); i++) {
			if (staff.get(i).getEmpID().equals(id)) {
				return staff.get(i);
			}
		}
		return null;
	}
/////////////DEPARTMENT.java//////////////
	protected boolean checkStaffByCNIC(String cnic, String empID)
	{
		for(Staff s : this.staff)
		{
			  if(cnic.equals(s.getCNIC())||s.getEmpID().equals(empID))
			  {
			      return true;
			  }		  
		}
		return false;
	}
}
