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

import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;

import javax.swing.table.TableModel;

import backend.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacFrame extends JFrame {
	FacFrame frame;
	private JPanel contentPane;
	private ArrayList<Container> containers;
	private JPanel home;
	private JPanel manageAttendance;
	private JPanel addAttendance;
	private JPanel updateGrade;
	private JScrollPane updateAttendance;
	private JPanel changePassword;
	private ArrayList<CourseSection> cs;
	private CourseSection c;
	private ArrayList<CourseSection> facultyCurrSemCrsSecs = null;
	private JComboBox comboBox_2 = new JComboBox();
	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_3 = new JComboBox();
	private JComboBox comboBox_5 = new JComboBox();
	private JComboBox comboBox_4 = new JComboBox();
	private JComboBox comboBox_6 = new JComboBox();
	private JLabel lblNewPassword;
	private JLabel lblOldPassword ;
	
	private ArrayList<Date> attendancesDate = null;
	private ArrayList<JComboBox> attenCombos = null;
	private ArrayList<Attendance> attendances = new ArrayList<Attendance>();
	private JButton updateBtn = null;
	private ArrayList<JLabel> attenLbls = null;
	private JTextField addDatefield = null;
	
	private ArrayList<Student> sectionStudents = null;
	private JTextField newPassField;
	private JTextField oldPassField;
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
					FacFrame frame = new FacFrame();
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
		if (a.equals("Manage Attendance"))
		{
			containers.get(1).setVisible(true);
		}
		if (a.equals("Update Attendance"))
		{
			containers.get(2).setVisible(true);
		}
		if (a.equals("Add Attendance"))
		{
			containers.get(3).setVisible(true);
		}
		if (a.equals("Update Grades"))
		{
			containers.get(4).setVisible(true);
		}
		if (a.equals("Change Password")) {
			containers.get(5).setVisible(true);
		}
	}

	/**
	 * Create the frame.
	 */
	public FacFrame() {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		containers = new ArrayList<Container>();
		
		changePassword = new JPanel();
		changePassword.setLayout(null);
		changePassword.setPreferredSize(new Dimension(704, 430));
		changePassword.setForeground(Color.WHITE);
		changePassword.setBackground(Color.BLACK);
		changePassword.setBounds(249, 152, 704, 442);
		contentPane.add(changePassword);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel.setBounds(272, 20, 170, 45);
		changePassword.add(lblNewLabel);
		
		lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewPassword.setBounds(69, 214, 132, 45);
		changePassword.add(lblNewPassword);
		
		newPassField = new JTextField();
		newPassField.setBounds(234, 221, 270, 34);
		changePassword.add(newPassField);
		newPassField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = Session.getUser().changePassword(oldPassField.getText(), newPassField.getText());
				if (check)
					JOptionPane.showMessageDialog(frame,"Successfully Updated!");
				else
					JOptionPane.showMessageDialog(frame,"Cannot Update the password! Make sure your old password is correct!","Alert",JOptionPane.WARNING_MESSAGE);
					
			}
		});
		btnNewButton_1.setBounds(312, 299, 117, 29);
		changePassword.add(btnNewButton_1);
		
		lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setForeground(Color.WHITE);
		lblOldPassword.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblOldPassword.setBounds(69, 143, 132, 45);
		changePassword.add(lblOldPassword);
		
		oldPassField = new JTextField();
		oldPassField.setColumns(10);
		oldPassField.setBounds(234, 154, 270, 34);
		changePassword.add(oldPassField);
		
		updateGrade = new JPanel();
		updateGrade.setLayout(null);
		updateGrade.setPreferredSize(new Dimension(704, 430));
		updateGrade.setForeground(Color.WHITE);
		updateGrade.setBackground(Color.BLACK);
		updateGrade.setBounds(249, 152, 704, 442);
		contentPane.add(updateGrade);
		
		JLabel label_16 = new JLabel("Select Section");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_16.setBounds(133, 84, 156, 35);
		updateGrade.add(label_16);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(133, 118, 139, 2);
		updateGrade.add(separator_15);
		comboBox_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_4.getSelectedIndex() != -1) {
					CourseSection crsSec = facultyCurrSemCrsSecs.get(comboBox_4.getSelectedIndex());
					sectionStudents = Session.getSchl().getStudentFromStudents(crsSec.getSectionID(),crsSec.getCourse().getCourseCode(),Session.getSem().getSession());
					comboBox_5.removeAllItems();
					comboBox_6.removeAllItems();
					if (sectionStudents != null && sectionStudents.size() > 0) {
						for (Student s : sectionStudents) {
							comboBox_5.addItem(s.getRollNo() + " " + s.getName());
						}
					}
				}
			}
		});
		
		
		comboBox_4.setBounds(305, 93, 156, 26);
		updateGrade.add(comboBox_4);
		
		JLabel lblUpdateGrade = new JLabel("Update Grade");
		lblUpdateGrade.setForeground(Color.WHITE);
		lblUpdateGrade.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateGrade.setBounds(22, 13, 201, 35);
		updateGrade.add(lblUpdateGrade);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setBounds(22, 46, 149, 2);
		updateGrade.add(separator_17);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_4.getSelectedIndex() != -1 && comboBox_5.getSelectedIndex() != -1 && comboBox_6.getSelectedIndex() != -1) {
					CourseSection crsSec = facultyCurrSemCrsSecs.get(comboBox_4.getSelectedIndex());
					boolean check = ((FacultyMember)Session.getUser()).updateGrade(sectionStudents.get(comboBox_5.getSelectedIndex()).getRollNo(), comboBox_6.getSelectedItem().toString(), crsSec);
					if (check) {
						JOptionPane.showMessageDialog(frame,"Successfuly updated!");
					}
				}
			}
		});
		button.setBounds(267, 332, 97, 25);
		updateGrade.add(button);
		
		JLabel lblSelectStudent = new JLabel("Select Student");
		lblSelectStudent.setForeground(Color.WHITE);
		lblSelectStudent.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblSelectStudent.setBounds(133, 166, 182, 35);
		updateGrade.add(lblSelectStudent);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(133, 200, 139, 2);
		updateGrade.add(separator_3);
		comboBox_5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox_6.removeAllItems();
				LGrade[] grade_types = LGrade.values();
				for (LGrade gr : grade_types)
					comboBox_6.addItem(gr.toString());
				if(comboBox_5.getSelectedIndex() != -1 && comboBox_4.getSelectedIndex() != -1) {
					Grade g = sectionStudents.get(comboBox_5.getSelectedIndex()).getCourseGrade(facultyCurrSemCrsSecs.get(comboBox_4.getSelectedIndex()));
					if (g != null) {
						comboBox_6.setSelectedItem(g.getGrade().toString());
					}
				}
			}
		});
		
		
		comboBox_5.setBounds(305, 175, 156, 26);
		updateGrade.add(comboBox_5);
		
		JLabel lblSelectStudent_1 = new JLabel("Select Grade");
		lblSelectStudent_1.setForeground(Color.WHITE);
		lblSelectStudent_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblSelectStudent_1.setBounds(133, 250, 182, 35);
		updateGrade.add(lblSelectStudent_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(133, 284, 139, 2);
		updateGrade.add(separator_4);
		
		
		comboBox_6.setBounds(305, 259, 156, 26);
		updateGrade.add(comboBox_6);
		
								
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
		JLabel lblUserName = new JLabel(Session.getUser().getName());
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblUserName.setBounds(70, 252, 331, 27);
		home.add(lblUserName);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(71, 283, 61, 2);
		home.add(separator_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(71, 323, 61, 2);
		home.add(separator_2_1);
		
		JLabel label_7_1 = new JLabel(Session.getUser().getPhoneNo());
		label_7_1.setForeground(Color.WHITE);
		label_7_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_7_1.setBounds(70, 292, 331, 27);
		home.add(label_7_1);
		
		JLabel lblEmail = new JLabel(Session.getUser().getEmail());
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmail.setBounds(70, 334, 331, 27);
		home.add(lblEmail);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(71, 365, 61, 2);
		home.add(separator_3_1);
		
		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(71, 405, 61, 2);
		home.add(separator_4_1);
		
		JLabel lblHStreet = new JLabel("Address: " + Session.getUser().getAddress());
		lblHStreet.setForeground(Color.WHITE);
		lblHStreet.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblHStreet.setBounds(70, 374, 331, 27);
		home.add(lblHStreet);
		
		JSeparator separator_5_1 = new JSeparator();
		separator_5_1.setBounds(418, 405, 61, 2);
		home.add(separator_5_1);
		
		JLabel lblGenderM = new JLabel("Gender: "+ Session.getUser().getGender());
		lblGenderM.setForeground(Color.WHITE);
		lblGenderM.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblGenderM.setBounds(417, 374, 175, 27);
		home.add(lblGenderM);
		
		JLabel lblDob = new JLabel("DOB: " + Session.getUser().getDOB());
		lblDob.setForeground(Color.WHITE);
		lblDob.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDob.setBounds(417, 334, 281, 27);
		home.add(lblDob);
		
		JSeparator separator_6_1 = new JSeparator();
		separator_6_1.setBounds(418, 365, 61, 2);
		home.add(separator_6_1);
		
		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setBounds(418, 323, 61, 2);
		home.add(separator_7_1);
		
		JLabel lblCnic = new JLabel("CNIC: " + Session.getUser().getCNIC());
		lblCnic.setForeground(Color.WHITE);
		lblCnic.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCnic.setBounds(417, 292, 281, 27);
		home.add(lblCnic);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(418, 283, 61, 2);
		home.add(separator_8);
		
		JLabel lblEmergency = new JLabel("Emergency Num: " + Session.getUser().getEmergencyContact());
		lblEmergency.setForeground(Color.WHITE);
		lblEmergency.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmergency.setBounds(417, 252, 281, 27);
		home.add(lblEmergency);
		
		JLabel lblDateHired = new JLabel("Date Hired: " + ((FacultyMember)Session.getUser()).getDateHired().toString());
		lblDateHired.setForeground(Color.WHITE);
		lblDateHired.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDateHired.setBounds(70, 405, 331, 27);
		home.add(lblDateHired);
		
		JLabel lblPosition = new JLabel("Position: " + ((FacultyMember)Session.getUser()).getPosition());
		lblPosition.setForeground(Color.WHITE);
		lblPosition.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPosition.setBounds(417, 405, 281, 27);
		home.add(lblPosition);
		
		addAttendance = new JPanel();
		addAttendance.setLayout(null);
		addAttendance.setPreferredSize(new Dimension(704, 430));
		addAttendance.setForeground(Color.WHITE);
		addAttendance.setBackground(Color.BLACK);
		addAttendance.setBounds(249, 152, 704, 442);
		contentPane.add(addAttendance);
		
		JLabel lblSelectSection = new JLabel("Select Section");
		lblSelectSection.setForeground(Color.WHITE);
		lblSelectSection.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblSelectSection.setBounds(133, 127, 182, 35);
		addAttendance.add(lblSelectSection);
		
		JLabel lblSelectDate = new JLabel("Select Date");
		lblSelectDate.setForeground(Color.WHITE);
		lblSelectDate.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblSelectDate.setBounds(133, 219, 217, 35);
		addAttendance.add(lblSelectDate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(133, 161, 139, 2);
		addAttendance.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(133, 252, 139, 2);
		addAttendance.add(separator_1);
		
		
		comboBox.setBounds(305, 136, 156, 26);
		addAttendance.add(comboBox);
		
//		JComboBox comboBox_1 = new JComboBox();
//		comboBox_1.setBounds(305, 228, 156, 26);
//		addAttendance.add(comboBox_1);
		addDatefield = new JTextField("");
		addDatefield.setBounds(305, 228, 156, 26);
		addAttendance.add(addDatefield);
		
		JLabel lblAddAttendance_1 = new JLabel("Add Attendance");
		lblAddAttendance_1.setForeground(Color.WHITE);
		lblAddAttendance_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddAttendance_1.setBounds(22, 13, 170, 35);
		addAttendance.add(lblAddAttendance_1);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(22, 46, 170, 2);
		addAttendance.add(separator_11);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1 && !addDatefield.getText().equals("")) {
					try {
						((FacultyMember)Session.getUser()).addAttendance(facultyCurrSemCrsSecs.get(comboBox.getSelectedIndex()), Date.valueOf(addDatefield.getText()));
						showPanel("Manage Attendance");
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(frame,"Invalid input! Make sure the date is in '2017-04-09' format!","Alert",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(268, 306, 97, 25);
		addAttendance.add(btnNewButton);
		
		updateAttendance = new JScrollPane();
		updateAttendance.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		updateAttendance.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		updateAttendance.setBounds(249, 152, 704, 442);
		contentPane.add(updateAttendance);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(704, 4030));
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		updateAttendance.setViewportView(panel);
		
		JLabel label_3 = new JLabel("Select Section");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_3.setBounds(133, 84, 156, 35);
		panel.add(label_3);
		
		JLabel label_7 = new JLabel("Select Date");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_7.setBounds(133, 176, 149, 35);
		panel.add(label_7);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(133, 118, 139, 2);
		panel.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(133, 209, 139, 2);
		panel.add(separator_6);
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (updateBtn != null) {
					panel.remove(updateBtn);
					updateBtn = null;
				}
				if (attenCombos != null) {
					for (JComboBox jb : attenCombos)
						panel.remove(jb);
					attenCombos = null;
				}
				if (attenLbls != null) {
					for (JLabel lb : attenLbls)
						panel.remove(lb);
					attenLbls = null;
				}
				panel.repaint();
				panel.setVisible(false);
				panel.setVisible(true);
				
				attendancesDate = null;
				if (comboBox_2.getSelectedIndex() != -1)
					attendancesDate = ((FacultyMember)Session.getUser()).extractDate(facultyCurrSemCrsSecs.get(comboBox_2.getSelectedIndex()));
				comboBox_3.removeAllItems();
				if (attendancesDate != null) {
					for (Date d : attendancesDate) {
						comboBox_3.addItem(d.toString());
					}
				}
			}
		});
		
		
		comboBox_2.setBounds(305, 93, 156, 26);
		panel.add(comboBox_2);
		
		comboBox_3.setBounds(305, 185, 156, 26);
		panel.add(comboBox_3);
		
		JLabel label_8 = new JLabel("Update Attendance");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_8.setBounds(22, 13, 201, 35);
		panel.add(label_8);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(22, 46, 201, 2);
		panel.add(separator_7);
		
		JButton button_1 = new JButton("Show");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (updateBtn != null) {
					panel.remove(updateBtn);
					updateBtn = null;
				}
				if (attenCombos != null) {
					for (JComboBox jb : attenCombos)
						panel.remove(jb);
					attenCombos = null;
				}
				if (attenLbls != null) {
					for (JLabel lb : attenLbls)
						panel.remove(lb);
					attenLbls = null;
				}
				panel.repaint();
				panel.setVisible(false);
				panel.setVisible(true);
				attendances = null;
				if (comboBox_2.getSelectedIndex() != -1 && comboBox_3.getSelectedIndex() != -1)
					attendances = ((FacultyMember)Session.getUser()).getAttendanceByDate(facultyCurrSemCrsSecs.get(comboBox_2.getSelectedIndex()), attendancesDate.get(comboBox_3.getSelectedIndex()));
				if (attendances != null) {
					attenCombos = new ArrayList<JComboBox>();
					attenLbls = new ArrayList<JLabel>();
					updateBtn = new JButton("Update");
					updateBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (int i = 0; i < attenCombos.size(); i++) {
								Attendance atd = attendances.get(i);
								((FacultyMember) Session.getUser()).markAttendance(atd.getStudent().getRollNo(),
										LAttendance.valueOf(attenCombos.get(i).getSelectedItem().toString()),
										attendancesDate.get(comboBox_3.getSelectedIndex()),
										facultyCurrSemCrsSecs.get(comboBox_2.getSelectedIndex()));
								showPanel("Manage Attendance");
							}
						}
					});
					panel.add(updateBtn);
					int y = 300;
					updateBtn.setBounds(305, 250, 97, 25);
					for (Attendance a : attendances) {
						JLabel rollNumLbl = new JLabel(a.getStudent().getRollNo());
						rollNumLbl.setBounds(50, y, 201, 35);
						rollNumLbl.setForeground(Color.WHITE);
						panel.add(rollNumLbl);
						attenLbls.add(rollNumLbl);
						JLabel stuLbl = new JLabel(a.getStudent().getName());
						stuLbl.setBounds(180, y, 201, 35);
						stuLbl.setForeground(Color.WHITE);
						panel.add(stuLbl);
						attenLbls.add(stuLbl);
						JComboBox jbox = new JComboBox();
						jbox.setBounds(500, y, 100, 26);
						jbox.addItem("P");
						jbox.addItem("A");
						jbox.addItem("L");
						jbox.setSelectedItem(a.getStatus().toString());
						jbox.setVisible(true);
						panel.add(jbox);
						attenCombos.add(jbox);
						y += 50;
					}
					panel.repaint();
					panel.setVisible(false);
					panel.setVisible(true);
				}
			}
		});
		button_1.setBounds(504, 184, 97, 25);
		panel.add(button_1);
		
				
		
		manageAttendance = new JPanel();
		manageAttendance.setLayout(null);
		manageAttendance.setPreferredSize(new Dimension(704, 430));
		manageAttendance.setForeground(Color.WHITE);
		manageAttendance.setBackground(Color.BLACK);
		manageAttendance.setBounds(249, 152, 704, 442);
		contentPane.add(manageAttendance);
		
		JLabel lblAddAttendance = new JLabel("Add Attendance");
		lblAddAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

				addDatefield.setText("");
				facultyCurrSemCrsSecs = null;
				facultyCurrSemCrsSecs = ((FacultyMember) Session.getUser()).getCurrentSemesterCourseSections();
				comboBox.removeAllItems();
				if (facultyCurrSemCrsSecs != null) {
					for (CourseSection c : facultyCurrSemCrsSecs) {
						comboBox.addItem(c.getCourse().getCourseCode() + " " + c.getSectionID() + " " + c.getCourse().getCourseName());
					}
				}
			}
		});
		lblAddAttendance.setForeground(Color.WHITE);
		lblAddAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddAttendance.setBounds(133, 90, 182, 35);
		manageAttendance.add(lblAddAttendance);
		
		
		
		JLabel lblUpdateAttendance = new JLabel("Update Attendance");
		lblUpdateAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
//				ArrayList<CourseSection> Session.getUser().getCourseSections();
				if (updateBtn != null) {
					panel.remove(updateBtn);
					updateBtn = null;
				}
				if (attenCombos != null) {
					for (JComboBox jb : attenCombos)
						panel.remove(jb);
					attenCombos = null;
				}
				if (attenLbls != null) {
					for (JLabel lb : attenLbls)
						panel.remove(lb);
					attenLbls = null;
				}
				showPanel(evlbl.getText());
				
				facultyCurrSemCrsSecs = null;
				facultyCurrSemCrsSecs = ((FacultyMember) Session.getUser()).getCurrentSemesterCourseSections();
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				if (facultyCurrSemCrsSecs != null) {
					for (CourseSection c : facultyCurrSemCrsSecs) {
						comboBox_2.addItem(c.getCourse().getCourseCode() + " " + c.getSectionID() + " " + c.getCourse().getCourseName());
					}
				}
				
			}
		});
		lblUpdateAttendance.setForeground(Color.WHITE);
		lblUpdateAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateAttendance.setBounds(133, 182, 217, 35);
		manageAttendance.add(lblUpdateAttendance);

		viewDetails(new User("A", "B", new Date(1,2,3), "C", "D", "E", 'M', "F", "G"));
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36,47,65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblManageGrades = new JLabel("Update Grades");
		lblManageGrades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageGrades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
				facultyCurrSemCrsSecs = null;
				facultyCurrSemCrsSecs = ((FacultyMember) Session.getUser()).getCurrentSemesterCourseSections();
				comboBox_4.removeAllItems();
				comboBox_5.removeAllItems();
				comboBox_6.removeAllItems();
				if (facultyCurrSemCrsSecs != null) {
					for (CourseSection c : facultyCurrSemCrsSecs) {
						comboBox_4.addItem(c.getCourse().getCourseCode() + " " + c.getSectionID() + " " + c.getCourse().getCourseName());
					}
				}

//				cs = Session.getUser().getCourseSections();
//				for (int i = 0; i < cs.size(); i++)
//				{
//					comboBox.addItem(cs.get(i).getCourse().getName() + cs.get(i).getSectionID() );
//				}

			}
		});
		lblManageGrades.setForeground(Color.WHITE);
		lblManageGrades.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageGrades.setBounds(57, 142, 182, 27);
		sidePanel.add(lblManageGrades);
		
		JLabel lblManageAttendance = new JLabel("Manage Attendance");
		lblManageAttendance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageAttendance.setForeground(Color.WHITE);
		lblManageAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageAttendance.setBounds(57, 87, 182, 27);
		sidePanel.add(lblManageAttendance);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HRFrame.class.getResource("/images/student.png")));
		label_1.setBounds(12, 142, 33, 32);
		sidePanel.add(label_1);
		
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
		
		JLabel lblAcademicManager = new JLabel("Faculty Member");
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
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblOldPassword.setText("");
				lblNewPassword.setText("");
				showPanel("Change Password");
			}
		});
		label_5.setIcon(new ImageIcon(HRFrame.class.getResource("/images/settings2.png")));
		label_5.setBounds(12, 85, 56, 59);
		topPanel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(HRFrame.class.getResource("/images/school.png")));
		label_6.setBounds(362, 0, 213, 152);
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
		containers.add(manageAttendance);
		containers.add(updateAttendance);
		containers.add(addAttendance);
		containers.add(updateGrade);
		containers.add(changePassword);
	}
	
	public void viewDetails(User user)
	{
		//home.setVisible(false);
		home.setVisible(true);
	}
	
	public void fillSections()
	{
		
	}
}
