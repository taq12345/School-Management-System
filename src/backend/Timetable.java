package backend;

public class Timetable {

	private String fileName;
	private String filePath;
	private School school = null;
	private Semester semester = null;

	public Timetable(String fileName, String filePath, School school, Semester semester) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.school = school;
		this.semester = semester;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

}
