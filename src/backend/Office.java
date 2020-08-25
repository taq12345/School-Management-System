/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author HumnaGul
 */
public class Office {

	private String ID;

	public Office(String ID) {
		this.ID = ID;
	}

	public String getID() {
		return ID;
	}

	public boolean setID(String ID) {
		boolean set = false;
		if (!ID.isEmpty()) {
			this.ID = ID;
			set = true;
		}
		return set;
	}

}
