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

public class AcademicDepartment extends Department {

	private ArrayList<Timetable> timetables = null;

	public AcademicDepartment(ArrayList<Timetable> timetables, String name, ArrayList<Staff> staff) {
		super(name, staff);
		this.timetables = timetables;
	}

	public ArrayList<Timetable> getTimetables() {
		return timetables;
	}

	public void setTimeTables(ArrayList<Timetable> timetables) {
		this.timetables = timetables;
	}

	public void addTimeTable(Timetable tbl) {
		this.timetables.add(tbl);
	}

	public Timetable getTimetable(String schoolID, String semID) {
		for (Timetable t : timetables) {
			if (t.getSchool().getId().equals(schoolID) && t.getSemester().getSession().equals(semID))
				return t;
		}
		return null;
	}

}
