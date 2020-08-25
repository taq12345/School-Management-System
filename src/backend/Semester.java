/**
 * 
 */
package backend;

import java.sql.Date;

/**
 * @author Ehtisham
 *
 */
public class Semester {
	private String session;
	private boolean active;
	private double perCreditHrFee;
	private Date feeDueDate = null;

	public Semester(String session, boolean active, double perCreditHrFee, Date feeDueDate) {
		this.session = session;
		this.active = active;
		this.perCreditHrFee = perCreditHrFee;
		this.feeDueDate = feeDueDate;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getPerCreditHrFee() {
		return perCreditHrFee;
	}

	public void setPerCreditHrFee(double perCreditHrFee) {
		this.perCreditHrFee = perCreditHrFee;
	}

	public Date getFeeDueDate() {
		return feeDueDate;
	}

	public void setFeeDueDate(Date feeDueDate) {
		this.feeDueDate = feeDueDate;
	}

}
