package backend;

public enum LGrade {

	A_PLUS(4.0, true),
	A(4.0, true),
	A_MINUS(3.67, true),
	B_PLUS(3.33, true),
	B(3.0, true),
	B_MINUS(2.67, true),
	C_PLUS(2.33,true),
	C(2.0, true),
	C_MINUS(1.67, true),
	D(1.00, true),
	D_PLUS(1.33, true),
	F(0.0, false),
	I(0.0, false);

	final private double gpa;
	final private boolean passed;

	private LGrade(double gpa, boolean passed) {
		this.gpa = gpa;
		this.passed = passed;
	}

	public boolean isPassing() {
		return this.passed;
	}

	public double getGpa() {
		return gpa;
	}
	
}
