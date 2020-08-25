package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.table.TableModel;

import backend.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class StudentFrame extends JFrame {

	private StudentFrame frame;
	private JPanel contentPane;
	private ArrayList<Container> containers;
	private JPanel home;
	private JPanel timetable;
	private JScrollPane attendence;
	private JPanel panel;
	private JScrollPane transcript;
	private JPanel panel_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UIManager.put("TableHeader.background", Color.black);
		UIManager.put("TableHeader.foreground", Color.white);
		UIManager.put("TableHeader.font", new Font("Century Gothic", Font.PLAIN, 15) );

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showPanel(String a)
	{
		for (int i = 0; i < containers.size();i++)
		{
			containers.get(i).setVisible(false);
		}
		
		if (a.equals("Home"))
		{
			containers.get(0).setVisible(true);
		}
		if (a.equals("Attendance"))
		{
			containers.get(1).setVisible(true);
		}
		if (a.equals("Timetable"))
		{
			containers.get(2).setVisible(true);
		}
		if (a.equals("Transcript"))
		{
			containers.get(3).setVisible(true);
		}
	}

	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		containers = new ArrayList<Container>();
						
						transcript = new JScrollPane();
						transcript.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						transcript.setBounds(249, 152, 704, 443);
						contentPane.add(transcript);
						
						panel_1 = new JPanel();
						panel_1.setLayout(null);
						panel_1.setPreferredSize(new Dimension(704, 2000));
						
						panel_1.setBackground(Color.BLACK);
						transcript.setViewportView(panel_1);
						
						JSeparator separator_4 = new JSeparator();
						separator_4.setBounds(264, 41, 121, 2);
						panel_1.add(separator_4);
						
						JLabel label_8 = new JLabel("Transcript");
						label_8.setForeground(Color.WHITE);
						label_8.setFont(new Font("Century Gothic", Font.PLAIN, 25));
						label_8.setBounds(264, 13, 147, 27);
						panel_1.add(label_8);
				
						timetable = new JPanel();
						timetable.setBackground(Color.BLACK);
						timetable.setBounds(249, 152, 704, 442);
						contentPane.add(timetable);
						timetable.setLayout(null);
						
						JLabel lblProfile = new JLabel("Timetable\r\n\r\n");
						lblProfile.setFont(new Font("Century Gothic", Font.PLAIN, 25));
						lblProfile.setForeground(Color.WHITE);
						lblProfile.setBounds(85, 23, 123, 27);
						timetable.add(lblProfile);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(85, 51, 123, 2);
						timetable.add(separator);
						
						JLabel lblEhtishamulhaq = new JLabel("Choose timetable:");
						lblEhtishamulhaq.setForeground(Color.WHITE);
						lblEhtishamulhaq.setFont(new Font("Century Gothic", Font.PLAIN, 15));
						lblEhtishamulhaq.setBounds(70, 127, 144, 33);
						timetable.add(lblEhtishamulhaq);
						
						JSeparator separator_1 = new JSeparator();
						separator_1.setBounds(70, 152, 144, 8);
						timetable.add(separator_1);
						
						comboBox = new JComboBox();
						comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 13));
						comboBox.setBounds(237, 127, 221, 33);
						timetable.add(comboBox);
						
						JButton btnOpen = new JButton("Open");
						btnOpen.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								//change null to session.academicInstitution
								//viewTimeTable();
							}
						});
						btnOpen.setBounds(497, 127, 97, 32);
						timetable.add(btnOpen);
						
						timetable.setVisible(false);
		
		
		
		attendence = new JScrollPane();
		attendence.setBounds(249, 152, 704, 443);
		contentPane.add(attendence);
		attendence.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		attendence.setBackground(Color.BLACK);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(704, 2000));
		panel.setBackground(Color.BLACK);
		attendence.setViewportView(panel);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(264, 41, 147, 2);
		panel.add(separator_3);
		
		JLabel label_7 = new JLabel("Attendance");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		label_7.setBounds(264, 13, 147, 27);
		panel.add(label_7);
		
		
		
								
		home = new JPanel();
		home.setBackground(Color.BLACK);
		home.setBounds(249, 152, 704, 442);
		contentPane.add(home);
		home.setLayout(null);
		
		JLabel label = new JLabel("UserImage");
		label.setIcon(new ImageIcon(StudentFrame.class.getResource("/images/user2.png")));
		label.setBounds(54, 71, 99, 152);
		home.add(label);
		
		JLabel label_2 = new JLabel("Profile");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBounds(69, 25, 93, 16);
		home.add(label_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(70, 50, 61, 2);
		home.add(separator_2);
		
		Student std = (Student) Session.getUser();
		viewDetails(std);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36,47,65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		
		
		JLabel lblManageStudents = new JLabel("Transcript");
		lblManageStudents.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
				Student std = (Student) Session.getUser();
				viewTranscript(std);
			}
		});
		lblManageStudents.setForeground(Color.WHITE);
		lblManageStudents.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageStudents.setBounds(57, 142, 182, 27);
		sidePanel.add(lblManageStudents);
		
		JLabel lblManageCourses = new JLabel("Attendance");
		lblManageCourses.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageCourses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
				Student std = (Student) Session.getUser();
				viewAttendance(std);
			}
		});
		lblManageCourses.setForeground(Color.WHITE);
		lblManageCourses.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageCourses.setBounds(57, 199, 182, 27);
		sidePanel.add(lblManageCourses);
		
		JLabel lblManageRegistrations = new JLabel("Timetable");
		lblManageRegistrations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageRegistrations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
				
				//fillTimeTables();
				
			}
		});
		lblManageRegistrations.setForeground(Color.WHITE);
		lblManageRegistrations.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageRegistrations.setBounds(57, 87, 182, 27);
		sidePanel.add(lblManageRegistrations);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HRFrame.class.getResource("/images/student.png")));
		label_1.setBounds(12, 142, 33, 32);
		sidePanel.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(HRFrame.class.getResource("/images/course2.png")));
		label_3.setBounds(12, 199, 40, 32);
		sidePanel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(HRFrame.class.getResource("/images/registration.png")));
		label_4.setBounds(12, 87, 40, 30);
		sidePanel.add(label_4);
		
		JLabel lblLogout = new JLabel("");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Session.getInst().logout();
				frame.setVisible(false);
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
			}
		});
		lblLogout.setBounds(93, 363, 56, 54);
		sidePanel.add(lblLogout);
		lblLogout.setIcon(new ImageIcon(HRFrame.class.getResource("/images/logout.png")));
		
		JLabel lblAcademicManager = new JLabel("Student");
		lblAcademicManager.setForeground(Color.WHITE);
		lblAcademicManager.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAcademicManager.setBounds(27, 26, 211, 32);
		sidePanel.add(lblAcademicManager);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 953, 152);
		topPanel.setBackground(new Color(30, 144, 255));
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblHome.setIcon(new ImageIcon(HRFrame.class.getResource("/images/home.png")));
		lblHome.setBounds(12, 15, 56, 57);
		topPanel.add(lblHome);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(HRFrame.class.getResource("/images/settings2.png")));
		label_5.setBounds(12, 85, 56, 59);
		topPanel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(HRFrame.class.getResource("/images/school.png")));
		label_6.setBounds(362, 0, 221, 152);
		topPanel.add(label_6);
		
		addContainers();
		
		for (int i = 1; i < containers.size();i++)
		{
			containers.get(i).setVisible(false);
		}
		
	}
	
	public void addContainers()
	{
		containers.add(home);
		containers.add(attendence);
		containers.add(timetable);
		containers.add(transcript);
	}
	
	public void viewDetails(Student user)
	{
		JLabel lblEhtishamulhaq = new JLabel(user.getName());
		lblEhtishamulhaq.setForeground(Color.WHITE);
		lblEhtishamulhaq.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEhtishamulhaq.setBounds(70, 252, 175, 27);
		home.add(lblEhtishamulhaq);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(71, 283, 61, 2);
		home.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(71, 323, 61, 2);
		home.add(separator_2);
		
		JLabel label_7 = new JLabel(user.getPhoneNo());
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_7.setBounds(70, 292, 175, 27);
		home.add(label_7);
		
		JLabel lblPrincessshamsgmailcom = new JLabel(user.getEmail());
		lblPrincessshamsgmailcom.setForeground(Color.WHITE);
		lblPrincessshamsgmailcom.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPrincessshamsgmailcom.setBounds(70, 334, 205, 27);
		home.add(lblPrincessshamsgmailcom);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(71, 365, 61, 2);
		home.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(71, 405, 61, 2);
		home.add(separator_4);
		
		JLabel lblHStreet = new JLabel(user.getAddress());
		lblHStreet.setForeground(Color.WHITE);
		lblHStreet.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblHStreet.setBounds(70, 374, 239, 27);
		home.add(lblHStreet);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(418, 405, 61, 2);
		home.add(separator_5);
		
		JLabel lblGenderM = new JLabel("Gender: "+ user.getGender());
		lblGenderM.setForeground(Color.WHITE);
		lblGenderM.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblGenderM.setBounds(417, 374, 175, 27);
		home.add(lblGenderM);
		
		JLabel lblDob = new JLabel("DOB: " + user.getDOB());
		lblDob.setForeground(Color.WHITE);
		lblDob.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDob.setBounds(417, 334, 250, 27);
		home.add(lblDob);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(418, 365, 61, 2);
		home.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(418, 323, 61, 2);
		home.add(separator_7);
		
		JLabel lblCnic = new JLabel("CNIC: " + user.getCNIC());
		lblCnic.setForeground(Color.WHITE);
		lblCnic.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCnic.setBounds(417, 292, 175, 27);
		home.add(lblCnic);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(418, 283, 61, 2);
		home.add(separator_8);
		
		JLabel lblEmergency = new JLabel("Emergency: " + user.getEmergencyContact());
		lblEmergency.setForeground(Color.WHITE);
		lblEmergency.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmergency.setBounds(417, 252, 192, 27);
		home.add(lblEmergency);
		home.setVisible(true);
		
		//student info
		
		JLabel lblRollNo = new JLabel("Roll No: " + user.getRollNo());
		lblRollNo.setForeground(Color.WHITE);
		lblRollNo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblRollNo.setBounds(400, 40, 250, 27);
		home.add(lblRollNo);
	
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(400, 70, 61, 2);
		home.add(separator_10);
		
		JLabel lblSchool = new JLabel(Session.getInst().getStudentSchool(user.getRollNo()).getName());
		lblSchool.setForeground(Color.WHITE);
		lblSchool.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSchool.setBounds(400, 75, 250, 27);
		home.add(lblSchool);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(400, 110, 61, 2);
		home.add(separator_11);
		
		JLabel lblFatherName = new JLabel("Father Name: " + user.getFatherName());
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblFatherName.setBounds(400, 120, 250, 27);
		home.add(lblFatherName);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(400, 157, 61, 2);
		home.add(separator_12);
		
		JLabel lblFatherCNIC = new JLabel("Father CNIC: " + user.getFatherCNIC());
		lblFatherCNIC.setForeground(Color.WHITE);
		lblFatherCNIC.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblFatherCNIC.setBounds(400, 170, 250, 27);
		home.add(lblFatherCNIC);
		
	}
	
	public void viewAttendance(Student student)
	{
		ArrayList<CourseSection> sections = student.checkSemesterRegistrations(Session.getSem());
		ArrayList<Attendance> attendances;
		String name;
		char secID;
		String[] columnNames = {"Date",
                "Lecture #",
                "Status"};
		
		int x = 210;
		int y = 110;
		for (int i = 0; i < sections.size(); i++)
		{
			name = sections.get(i).getCourse().getCourseName();
			secID = sections.get(i).getSectionID();
			attendances = sections.get(i).getStudentAttendance();
			JLabel l1 = new JLabel(name + " - " + secID);
			l1.setForeground(Color.WHITE);
			l1.setFont(new Font("Century Gothic", Font.BOLD, 20));
			l1.setBounds(x, y, 208, 41);
			panel.add(l1);
			
			JTable table2 = new JTable();
			DefaultTableModel dtm = new DefaultTableModel(0, 0);
			dtm.setColumnIdentifiers(columnNames);
			table2.setModel(dtm);

			JScrollPane scrollPane_3 = new JScrollPane(table2);
			scrollPane_3.setForeground(Color.WHITE);
			scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
			scrollPane_3.setBackground(Color.WHITE);
			scrollPane_3.setAlignmentX(0.0f);
			scrollPane_3.setBounds(197, y+=50, 279, 98);
			panel.add(scrollPane_3);
			
			for (int j = 0; j < attendances.size(); j++) 
			{
		        dtm.addRow(new Object[] { attendances.get(j).getDay(), j+1, attendances.get(j).getStatus() });
			}
			
			y+=150;
		}
		
	}
	
	public void viewTranscript(Student std)
	{
		ArrayList<Grade> grades = std.getTranscript().getGrades();
		String[] columnNames = {"Code",
                "Course Name",
                "Crd Hrs", "Grade"};
		
		int yTable = 150;
		int ySession = 101;
		int yDetails = 118;
		
		DefaultTableModel dtm = null;
		String session;
		
		ArrayList<String> sessions = new ArrayList<String>();
		///////////////////
		// loop for every semester //
		
		JLabel label_11 = new JLabel("CGPA: "+Double.toString(std.computeCGPA()));
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_11.setBounds(20, 60, 98, 27);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("Credits Earned: "+Integer.toString(std.getCreditsEarned()));
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_12.setBounds(200, 60, 150, 27);
		panel_1.add(label_12);
		
		JLabel label13 = new JLabel("Credits Attempted: "+Integer.toString(std.getCreditsAttempted()));
		label13.setForeground(Color.WHITE);
		label13.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label13.setBounds(400, 60, 200, 27);
		panel_1.add(label13);
		
		for (int i = 0; i < grades.size(); i++)
		{
			
			session = grades.get(i).getCourseSection().getSemester().getSession();
			
			if (!sessions.contains(session))
			{
				sessions.add(session);
				
				JTable table2 = new JTable();
				dtm = new DefaultTableModel(0, 0);
				dtm.setColumnIdentifiers(columnNames);
				table2.setModel(dtm);
				
				JScrollPane scrollPane_3 = new JScrollPane(table2);
				scrollPane_3.setForeground(Color.WHITE);
				scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
				scrollPane_3.setBackground(Color.WHITE);
				scrollPane_3.setAlignmentX(0.0f);
				scrollPane_3.setBounds(22, yTable, 629, 98);
				panel_1.add(scrollPane_3);
				
				JLabel label_9 = new JLabel(session);
				label_9.setForeground(Color.WHITE);
				label_9.setFont(new Font("Century Gothic", Font.BOLD, 20));
				label_9.setBounds(12, ySession, 103, 41);
				panel_1.add(label_9);
				
				JLabel label_10 = new JLabel("GPA: "+Double.toString((std.computeGPA(std.getTranscript().getSemesterGrades(session)))));
				label_10.setForeground(Color.WHITE);
				label_10.setFont(new Font("Century Gothic", Font.PLAIN, 15));
				label_10.setBounds(161, yDetails, 84, 27);
				panel_1.add(label_10);
				
				yTable+= 170;
				ySession += 170;
				yDetails += 170;
			}
		
		//////////////////////////
		//////////////////////////
		
			String code = grades.get(i).getCourseSection().getCourse().getCourseCode();
			String name = grades.get(i).getCourseSection().getCourse().getCourseName();
			int cHrs = grades.get(i).getCourseSection().getCourse().getCreditHours();
			LGrade l = grades.get(i).getGrade();
			//grades.get(i).getPoints();
			
			
			
		    dtm.addRow(new Object[] { code, name, cHrs, l});	
		}
	}
	
//	public void fillTimeTables()
//	{
//		Timetable timetable = Session.getAcademicDept().getTimeTable(Session.getSchool().getId, Session.getSemester().getSession()); //CURRENT SEMESTER TIMETABLES
//		comboBox.addItem(timetable.getFileName());
//	}
//	
//	public void viewTimeTable()
//	{
//		Timetable timetable = Session.getAcademicDept().getTimeTable(Session.getSchool().getId, Session.getSemester().getSession()); //CURRENT SEMESTER TIMETABLES
//
//		try {
//			Desktop.getDesktop().open(new File(timetable.getTimeTableFilePath(name)));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
