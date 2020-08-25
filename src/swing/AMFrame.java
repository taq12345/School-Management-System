package swing;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import backend.*;
import dal.DAL;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AMFrame extends JFrame {

	private AMFrame frame;
	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtFirst;
	private JTextField textField_3;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textPos;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_41;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JComboBox comboBox_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_23;
	private JComboBox comboBox_24;
	private JComboBox comboBox_25;
	private JComboBox comboBox_9;
	private JComboBox comboBox_14;
	private JComboBox comboBox_5;
	private JComboBox comboBox_15;
	private JComboBox comboBox_2;

	private JPanel addSchool;
	private JTextArea textArea;
	private ArrayList<Container> containers;
	private JPanel manageCourses;
	private JPanel manageStudents;
	private JScrollPane addSection;
	private JPanel manageFaculty;
	private JPanel manageSections;
	private JPanel manageSchools;
	private JScrollPane registerStudent;
	private JScrollPane updateStudent;
	private JPanel removeStudent;
	private JScrollPane registerFaculty;
	private JScrollPane addCourse;
	private JScrollPane removeFaculty;
	private JPanel updateCourse;
	private JPanel updateSection;
	private JPanel removeSection;
	private JPanel updateSchool;
	private JPanel removeCourse;
	private JScrollPane updateFaculty;
	private JScrollPane manageRegistrations;
	private JPanel home;
	private JTextField textField_52;
	private JTextField textField_16;
	private JTextField textField_6;
	private JTextField textField_17;
	private JList list3;
	private DefaultListModel listModel3;
	private JTextField textField_7;
	private JTextField textField_54;
	private JTextField textField_53;
	private JTextField textField_55;
	private JButton btnRemove;
	JComboBox comboBox_18;
	JTable table2;
	DefaultTableModel dtm;
	JScrollPane scrollPane_3;
	JTable table3;
	DefaultTableModel dtm2;
	JScrollPane scrollPane_4;
	private int regY = 226;
	private JButton btnRemove_1;
	private JButton btnRemove_2;
	private JTextField textField_26;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField;
	private JTextField textField_30;
	private JTextField textField_1;
	ArrayList<JComboBox> comboBoxes = new ArrayList<JComboBox>();
	private JTextField textField_2;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AMFrame frame = new AMFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showPanel(String a) {
		for (int i = 0; i < containers.size(); i++) {
			containers.get(i).setVisible(false);
		}
		if (a.equals("Home")) {
			containers.get(0).setVisible(true);
		}
		if (a.equals("Manage Courses")) {
			containers.get(1).setVisible(true);
		}
		if (a.equals("Manage Students")) {
			containers.get(2).setVisible(true);
		}
		if (a.equals("Manage Faculty")) {
			containers.get(3).setVisible(true);
		}
		if (a.equals("Manage Sections")) {
			containers.get(4).setVisible(true);
		}
		if (a.equals("Manage Schools")) {
			containers.get(5).setVisible(true);
		}
		if (a.equals("Register Student")) {
			containers.get(6).setVisible(true);
		}
		if (a.equals("Update Student")) {
			containers.get(7).setVisible(true);
		}
		if (a.equals("Remove Student")) {
			containers.get(8).setVisible(true);
		}
		if (a.equals("Register Faculty")) {
			containers.get(9).setVisible(true);
		}
		if (a.equals("Add Course")) {
			containers.get(10).setVisible(true);
		}
		if (a.equals("Remove Course")) {
			containers.get(11).setVisible(true);
		}
		if (a.equals("Update Course")) {
			containers.get(12).setVisible(true);
		}
		if (a.equals("Update Section")) {
			containers.get(13).setVisible(true);
		}
		if (a.equals("Remove Section")) {
			containers.get(14).setVisible(true);
		}
		if (a.equals("Update School")) {
			containers.get(15).setVisible(true);
		}
		if (a.equals("Add Section")) {
			containers.get(16).setVisible(true);
		}
		if (a.equals("Add Course")) {
			containers.get(17).setVisible(true);
		}
		if (a.equals("Add School")) {
			containers.get(18).setVisible(true);
		}
		if (a.equals("Remove Faculty")) {
			containers.get(19).setVisible(true);
		}
		if (a.equals("Update Faculty")) {
			containers.get(20).setVisible(true);
		}
		if (a.equals("Manage Registrations")) {
			containers.get(21).setVisible(true);
		}

	}

	/**
	 * Create the frame.
	 */
	public AMFrame() {
		frame = this;
		AcademicManager user = (AcademicManager) Session.getUser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		listModel3 = new DefaultListModel();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		containers = new ArrayList<Container>();

		addSection = new JScrollPane();
		addSection.setBounds(249, 152, 704, 442);
		contentPane.add(addSection);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setPreferredSize(new Dimension(704, 550));
		panel_6.setBackground(Color.BLACK);
		addSection.setViewportView(panel_6);

		JLabel lblAddSection_1 = new JLabel("Add Section");
		lblAddSection_1.setForeground(Color.WHITE);
		lblAddSection_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddSection_1.setBounds(33, 11, 123, 35);
		panel_6.add(lblAddSection_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(33, 48, 123, 2);
		panel_6.add(separator_2);

		JLabel label_9 = new JLabel("Code");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_9.setBounds(33, 114, 54, 27);
		panel_6.add(label_9);

		JLabel label_13 = new JLabel("School");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_13.setBounds(33, 74, 61, 27);
		panel_6.add(label_13);

		comboBox_23 = new JComboBox();
		comboBox_23.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_24.removeAllItems();
				fillCourseCodes(comboBox_24, comboBox_23.getSelectedIndex());
				comboBox_25.removeAllItems();
				fillFaculty(comboBox_25, comboBox_23.getSelectedIndex());
			}
		});
		comboBox_23.setForeground(Color.BLACK);
		comboBox_23.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_23.setBorder(null);
		comboBox_23.setBackground(Color.WHITE);
		comboBox_23.setBounds(191, 78, 154, 20);
		panel_6.add(comboBox_23);

		JButton btnAddSection = new JButton("Add Section");
		btnAddSection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					System.out.println("here");
					String c_code = comboBox_24.getSelectedItem().toString();
					System.out.println(c_code);
					char sID = textField_17.getText().charAt(0);
					System.out.println(sID);
					String school = comboBox_23.getSelectedItem().toString();
					System.out.println(school);
					String faculty = comboBox_25.getSelectedItem().toString();
					System.out.println(faculty);

					if (user.addSection(school, c_code, faculty, sID))
						JOptionPane.showMessageDialog(frame, "Section added!", "Alert", JOptionPane.OK_OPTION);
					else
						JOptionPane.showMessageDialog(frame, "Could not add section", "Alert",
								JOptionPane.WARNING_MESSAGE);

				} catch (Exception excep) {
					JOptionPane.showMessageDialog(frame, "Invalid details entered! Please check types/format", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAddSection.setForeground(Color.BLACK);
		btnAddSection.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnAddSection.setBackground(new Color(36, 47, 65));
		btnAddSection.setBounds(191, 243, 154, 23);
		panel_6.add(btnAddSection);

		comboBox_24 = new JComboBox();
		comboBox_24.setBounds(191, 117, 154, 22);
		panel_6.add(comboBox_24);

		JLabel lblSectionId = new JLabel("Faculty");
		lblSectionId.setForeground(Color.WHITE);
		lblSectionId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSectionId.setBounds(33, 154, 82, 27);
		panel_6.add(lblSectionId);

		JLabel label_4 = new JLabel("Section ID");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_4.setBounds(33, 194, 82, 27);
		panel_6.add(label_4);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(191, 197, 154, 22);
		panel_6.add(textField_17);

		comboBox_25 = new JComboBox();
		comboBox_25.setBounds(191, 157, 154, 22);
		panel_6.add(comboBox_25);

		manageRegistrations = new JScrollPane();
		manageRegistrations.setBounds(249, 152, 706, 442);
		contentPane.add(manageRegistrations);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setPreferredSize(new Dimension(704, 550));
		panel_4.setBackground(Color.BLACK);
		panel_4.setPreferredSize(new Dimension(704, 2000));

		manageRegistrations.setViewportView(panel_4);

		JLabel lblManageRegistrations_1 = new JLabel("Manage Registrations");
		lblManageRegistrations_1.setForeground(Color.WHITE);
		lblManageRegistrations_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblManageRegistrations_1.setBounds(33, 11, 218, 35);
		panel_4.add(lblManageRegistrations_1);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(33, 48, 207, 2);
		panel_4.add(separator_6);

		textField_1 = new JTextField();
		textField_1.setText("15L-1234");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(36, 47, 65));
		textField_1.setBounds(233, 82, 198, 20);
		panel_4.add(textField_1);

		JLabel label_61 = new JLabel("Roll Number");
		label_61.setForeground(Color.WHITE);
		label_61.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_61.setBounds(119, 78, 87, 27);
		panel_4.add(label_61);

		JButton button_2 = new JButton("Search");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				regY = 226;
				String[] columnNames = { "Roll Number", "Name", "CGPA" };
				panel_4.removeAll();
				comboBoxes = new ArrayList<JComboBox>();
				panel_4.add(label_61);
				panel_4.add(textField_1);
				panel_4.add(button_2);
				panel_4.add(lblManageRegistrations_1);
				panel_4.add(separator_6);

				table2 = new JTable();
				dtm = new DefaultTableModel(0, 0);
				dtm.setColumnIdentifiers(columnNames);
				table2.setModel(dtm);

				scrollPane_3 = new JScrollPane(table2);
				scrollPane_3.setForeground(Color.WHITE);
				scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
				scrollPane_3.setBackground(Color.WHITE);
				scrollPane_3.setAlignmentX(0.0f);
				scrollPane_3.setBounds(197, 135, 279, 40);
				manageRegistrations.add(scrollPane_3);

				String rollNum = textField_1.getText();
				Student student = Session.getInst().getStudent(rollNum);
				if (student != null) {
					School studentSchool = Session.getInst().getStudentSchool(rollNum);
					ArrayList<Course> courses = studentSchool.getOfferedCourses();

					dtm.addRow(new Object[] { student.getRollNo(), student.getName(), student.getCGPA() });

					for (int i = 0; i < courses.size(); i++) {
						JLabel label = new JLabel(courses.get(i).getCourseName());
						label.setBounds(20, regY, 200, 50);
						label.setForeground(Color.WHITE);

						panel_4.add(label);

						JLabel label2 = new JLabel(Integer.toString(courses.get(i).getCreditHours()));
						label2.setBounds(240, regY, 20, 50);
						label2.setForeground(Color.WHITE);

						panel_4.add(label2);

						JComboBox comboBox = new JComboBox();
						comboBox.setBounds(280, regY, 50, 50);

						panel_4.add(comboBox);
						comboBoxes.add(comboBox);
						ArrayList<CourseSection> courseSections = courses.get(i).getSections();
						for (int j = 0; j < courseSections.size(); j++) {

							comboBox.addItem(courseSections.get(j).getSectionID());
						}

						if (student.isRegistered(courses.get(i), Session.getSem()) == true) {
							JButton jButton = new JButton("UPDATE");
							jButton.setBounds(350, regY, 100, 50);
							jButton.setName(Integer.toString(i));
							jButton.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									System.out.println(Integer.parseInt(jButton.getName()));
									if (user.updateStudentCourseRegistration(studentSchool.getId(), rollNum,
											courses.get(Integer.parseInt(jButton.getName())).getCourseCode(),
											(char) comboBoxes.get(Integer.parseInt(jButton.getName()))
													.getSelectedItem()))
										JOptionPane.showMessageDialog(frame, "Successfully Updated!", "Alert",
												JOptionPane.OK_OPTION);
									else
										JOptionPane.showMessageDialog(frame, "Could not update!", "Alert",
												JOptionPane.WARNING_MESSAGE);

								}
							});

							JButton jButton2 = new JButton("DROP");
							jButton2.setBounds(470, regY, 100, 50);
							jButton2.setName(Integer.toString(i));
							jButton2.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									if (user.removeStudentCourseRegistration(studentSchool.getId(), rollNum,
											courses.get(Integer.parseInt(jButton2.getName())).getCourseCode()))
										JOptionPane.showMessageDialog(frame, "Course Dropped!", "Alert",
												JOptionPane.OK_OPTION);
									else
										JOptionPane.showMessageDialog(frame, "Could not drop!", "Alert",
												JOptionPane.WARNING_MESSAGE);

								}
							});

							panel_4.add(jButton);
							panel_4.add(jButton2);
						} else if (!student.isPassed(courses.get(i), Session.getSem())) {
							JButton jButton3 = new JButton("REGISTER");
							jButton3.setBounds(350, regY, 150, 50);
							jButton3.setName(Integer.toString(i));
							panel_4.add(jButton3);
							jButton3.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									if (((AcademicManager) Session.getUser()).registerStudentInCourse(
											studentSchool.getId(), rollNum,
											courses.get(Integer.parseInt(jButton3.getName())).getCourseCode(),
											(char) comboBoxes.get(Integer.parseInt(jButton3.getName()))
													.getSelectedItem()))
										JOptionPane.showMessageDialog(frame, "Successfully Registered!", "Alert",
												JOptionPane.OK_OPTION);
									else
										JOptionPane.showMessageDialog(frame, "Could not register!", "Alert",
												JOptionPane.WARNING_MESSAGE);
								}
							});
						} else if (student.isPassed(courses.get(i), Session.getSem())) {
							JLabel label4 = new JLabel("PASSED");
							label4.setBounds(350, regY, 100, 50);
							label4.setForeground(Color.WHITE);
							panel_4.add(label4);
							comboBoxes.get(i).setVisible(false);
						}

						regY += 100;
						panel_4.repaint();
						panel_4.revalidate();
						panel_4.setVisible(false);
						panel_4.setVisible(true);
						manageRegistrations.setVisible(false);
						manageRegistrations.setVisible(true);

					}
				} else {
					panel_4.removeAll();
					comboBoxes = new ArrayList<JComboBox>();
					panel_4.add(label_61);
					panel_4.add(textField_1);
					panel_4.add(button_2);
					panel_4.add(lblManageRegistrations_1);
					panel_4.add(separator_6);
					panel_4.repaint();
					panel_4.revalidate();
					panel_4.setVisible(false);
					panel_4.setVisible(true);
					manageRegistrations.setVisible(false);
					manageRegistrations.setVisible(true);
					JOptionPane.showMessageDialog(frame, "Could not find student!", "Alert",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_2.setBackground(SystemColor.menu);
		button_2.setBounds(457, 80, 130, 23);
		panel_4.add(button_2);

		manageSchools = new JPanel();
		manageSchools.setLayout(null);
		manageSchools.setPreferredSize(new Dimension(704, 430));
		manageSchools.setForeground(Color.WHITE);
		manageSchools.setBackground(Color.BLACK);
		manageSchools.setBounds(249, 152, 704, 442);
		contentPane.add(manageSchools);

		JLabel lblAddSchool = new JLabel("Add School");
		lblAddSchool.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblAddSchool.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblAddSchool.setForeground(Color.WHITE);
		lblAddSchool.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddSchool.setBounds(133, 90, 158, 35);
		manageSchools.add(lblAddSchool);

		JLabel lblUpdateSchool = new JLabel("Update School");
		lblUpdateSchool.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblUpdateSchool.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

				fillSchools(comboBox_18);
			}
		});
		lblUpdateSchool.setForeground(Color.WHITE);
		lblUpdateSchool.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateSchool.setBounds(133, 266, 172, 35);
		manageSchools.add(lblUpdateSchool);

		manageCourses = new JPanel();
		manageCourses.setLayout(null);
		manageCourses.setPreferredSize(new Dimension(704, 430));
		manageCourses.setForeground(Color.WHITE);
		manageCourses.setBackground(Color.BLACK);
		manageCourses.setBounds(249, 152, 704, 443);
		contentPane.add(manageCourses);

		JLabel lblAddCourse = new JLabel("Add Course");
		lblAddCourse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblAddCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
				fillSchools(comboBox_2);

			}
		});
		lblAddCourse.setForeground(Color.WHITE);
		lblAddCourse.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddCourse.setBounds(133, 90, 158, 35);
		manageCourses.add(lblAddCourse);

		JLabel lblRemoveCourse = new JLabel("Remove Course");
		lblRemoveCourse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblRemoveCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

				if (scrollPane_3.isVisible())
					scrollPane_3.setVisible(false);
				if (btnRemove_2.isVisible())
					btnRemove_2.setVisible(false);
			}
		});
		lblRemoveCourse.setForeground(Color.WHITE);
		lblRemoveCourse.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRemoveCourse.setBounds(133, 179, 172, 35);
		manageCourses.add(lblRemoveCourse);

		addCourse = new JScrollPane();
		addCourse.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		addCourse.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(addCourse);
		addCourse.setBackground(Color.BLACK);
		addCourse.setBounds(249, 151, 754, 443);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(249, 152, 704, 442);
		addCourse.setViewportView(panel_2);
		panel_2.setPreferredSize(new Dimension(704, 550));
		panel_2.setLayout(null);

		JLabel lblProfile = new JLabel("Add Course");
		lblProfile.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setBounds(33, 11, 123, 35);
		panel_2.add(lblProfile);

		JSeparator separator = new JSeparator();
		separator.setBounds(33, 48, 123, 2);
		panel_2.add(separator);

		JLabel lblName = new JLabel("Code");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(33, 102, 54, 27);
		panel_2.add(lblName);

		JLabel lblPhone = new JLabel("Name");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPhone.setBounds(33, 140, 54, 27);
		panel_2.add(lblPhone);

		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(36, 47, 65));
		textField_4.setBounds(191, 106, 154, 20);
		panel_2.add(textField_4);

		JLabel lblEmail = new JLabel("Credit Hours");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmail.setBounds(33, 178, 99, 27);
		panel_2.add(lblEmail);

		textField_5 = new JTextField();
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(new Color(36, 47, 65));
		textField_5.setBounds(191, 182, 154, 20);
		panel_2.add(textField_5);

		JLabel lblCnic_1 = new JLabel("Description");
		lblCnic_1.setForeground(Color.WHITE);
		lblCnic_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCnic_1.setBounds(33, 252, 82, 27);
		panel_2.add(lblCnic_1);

		txtFirst = new JTextField();
		txtFirst.setForeground(Color.WHITE);
		txtFirst.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtFirst.setColumns(10);
		txtFirst.setBorder(null);
		txtFirst.setBackground(new Color(36, 47, 65));
		txtFirst.setBounds(191, 143, 303, 22);
		panel_2.add(txtFirst);

		JLabel lblSchool = new JLabel("School");
		lblSchool.setForeground(Color.WHITE);
		lblSchool.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSchool.setBounds(33, 216, 61, 27);
		panel_2.add(lblSchool);

		comboBox_2 = new JComboBox();
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_2.setBorder(null);
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(191, 220, 154, 20);

		fillSchools(comboBox_2);
		panel_2.add(comboBox_2);

		JButton btnUploadPhoto = new JButton("Add Course");
		btnUploadPhoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String schoolID = (String) comboBox_2.getSelectedItem();
					String code = textField_4.getText();
					String name = txtFirst.getText();
					int creditHours = Integer.parseInt(textField_5.getText());
					String desc = textArea.getText();
					ArrayList<String> preReqs = (ArrayList<String>) list3.getSelectedValuesList();

					for (int i = 0; i < preReqs.size(); i++) {
						System.out.println(preReqs.get(i));
					}

					if (preReqs.size() == 0)
						preReqs = null;

					if (user.addCourse(schoolID, code, name, creditHours, desc, preReqs)) {
						JOptionPane.showMessageDialog(frame, "Course Added!", "Alert", JOptionPane.OK_OPTION);
					} else
						JOptionPane.showMessageDialog(frame, "Could not add course!", "Alert",
								JOptionPane.WARNING_MESSAGE);
				} catch (Exception excep) {
					JOptionPane.showMessageDialog(frame, "Invalid details entered! Please check types/format", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnUploadPhoto.setForeground(Color.BLACK);
		btnUploadPhoto.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUploadPhoto.setBackground(new Color(36, 47, 65));
		btnUploadPhoto.setBounds(359, 392, 154, 23);
		panel_2.add(btnUploadPhoto);

		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textArea.setBorder(null);
		textArea.setBackground(new Color(36, 47, 65));
		textArea.setBounds(191, 255, 303, 82);
		panel_2.add(textArea);

		JLabel lblPreReq = new JLabel("Pre Reqs");
		lblPreReq.setForeground(Color.WHITE);
		lblPreReq.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPreReq.setBounds(33, 350, 82, 27);
		panel_2.add(lblPreReq);
		addCourse.setVisible(false);
		list3 = new JList(listModel3);
		list3.setSelectedIndex(0);
		// list3.addListSelectionListener(this);
		list3.setVisibleRowCount(5);
		// list.setBounds(50,50,50,50);
		JScrollPane listScrollPane = new JScrollPane(list3);
		listScrollPane.setBounds(191, 350, 100, 100);
		panel_2.add(listScrollPane);

		JButton btnFillPrereqs = new JButton("Fill Prereqs");
		btnFillPrereqs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					listModel3.removeAllElements();
					ArrayList<Course> courses = Session.getInst().getSchool(comboBox_2.getSelectedItem().toString())
							.getCourses();
					for (int i = 0; i < courses.size(); i++) {
						listModel3.addElement(courses.get(i).getCourseCode());
					}
				} catch (Exception excep) {
					JOptionPane.showMessageDialog(frame, "Could not fill pre reqs!", "Alert",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		btnFillPrereqs.setForeground(Color.BLACK);
		btnFillPrereqs.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnFillPrereqs.setBackground(new Color(36, 47, 65));
		btnFillPrereqs.setBounds(359, 358, 154, 23);
		panel_2.add(btnFillPrereqs);

		updateStudent = new JScrollPane();
		updateStudent.setBounds(249, 152, 704, 442);
		contentPane.add(updateStudent);
		updateStudent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		updateStudent.setBackground(Color.BLACK);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setPreferredSize(new Dimension(704, 550));
		panel_5.setBackground(Color.BLACK);
		updateStudent.setViewportView(panel_5);

		JLabel label_78 = new JLabel("Update Student Details");
		label_78.setForeground(Color.WHITE);
		label_78.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_78.setBounds(33, 11, 227, 35);
		panel_5.add(label_78);

		JSeparator separator_19 = new JSeparator();
		separator_19.setBounds(33, 48, 227, 2);
		panel_5.add(separator_19);

		JLabel label_79 = new JLabel("Name");
		label_79.setForeground(Color.WHITE);
		label_79.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_79.setBounds(33, 102, 54, 27);
		panel_5.add(label_79);

		JLabel label_80 = new JLabel("Date of Birth");
		label_80.setForeground(Color.WHITE);
		label_80.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_80.setBounds(33, 140, 99, 27);
		panel_5.add(label_80);

		JLabel label_81 = new JLabel("Phone");
		label_81.setForeground(Color.WHITE);
		label_81.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_81.setBounds(33, 178, 54, 27);
		panel_5.add(label_81);

		textField_45 = new JTextField();
		textField_45.setForeground(Color.WHITE);
		textField_45.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_45.setColumns(10);
		textField_45.setBorder(null);
		textField_45.setBackground(new Color(36, 47, 65));
		textField_45.setBounds(191, 182, 154, 20);
		panel_5.add(textField_45);

		JLabel label_82 = new JLabel("Email");
		label_82.setForeground(Color.WHITE);
		label_82.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_82.setBounds(33, 214, 54, 27);
		panel_5.add(label_82);

		textField_46 = new JTextField();
		textField_46.setForeground(Color.WHITE);
		textField_46.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_46.setColumns(10);
		textField_46.setBorder(null);
		textField_46.setBackground(new Color(36, 47, 65));
		textField_46.setBounds(191, 218, 154, 20);
		panel_5.add(textField_46);

		JLabel label_83 = new JLabel("CNIC");
		label_83.setForeground(Color.WHITE);
		label_83.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_83.setBounds(33, 252, 54, 27);
		panel_5.add(label_83);

		textField_47 = new JTextField();
		textField_47.setForeground(Color.WHITE);
		textField_47.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_47.setColumns(10);
		textField_47.setBorder(null);
		textField_47.setBackground(new Color(36, 47, 65));
		textField_47.setBounds(191, 256, 154, 20);
		panel_5.add(textField_47);

		textField_48 = new JTextField();
		textField_48.setForeground(Color.WHITE);
		textField_48.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_48.setColumns(10);
		textField_48.setBorder(null);
		textField_48.setBackground(new Color(36, 47, 65));
		textField_48.setBounds(191, 295, 154, 20);
		panel_5.add(textField_48);

		JLabel label_84 = new JLabel("Gender");
		label_84.setForeground(Color.WHITE);
		label_84.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_84.setBounds(33, 328, 61, 27);
		panel_5.add(label_84);

		JLabel label_85 = new JLabel("Emergency Contact");
		label_85.setForeground(Color.WHITE);
		label_85.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_85.setBounds(33, 290, 148, 27);
		panel_5.add(label_85);

		JComboBox comboBox_19 = new JComboBox();
		comboBox_19.setForeground(Color.BLACK);
		comboBox_19.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_19.setBorder(null);
		comboBox_19.setBackground(Color.WHITE);
		comboBox_19.setBounds(191, 331, 154, 20);
		comboBox_19.addItem('M');
		comboBox_19.addItem('F');
		panel_5.add(comboBox_19);

		textField_49 = new JTextField();
		textField_49.setText("First");
		textField_49.setForeground(Color.WHITE);
		textField_49.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_49.setColumns(10);
		textField_49.setBorder(null);
		textField_49.setBackground(new Color(36, 47, 65));
		textField_49.setBounds(191, 105, 154, 22);
		panel_5.add(textField_49);

		JLabel label_86 = new JLabel("Address");
		label_86.setForeground(Color.WHITE);
		label_86.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_86.setBounds(33, 366, 61, 27);
		panel_5.add(label_86);

		textField_50 = new JTextField();
		textField_50.setForeground(Color.WHITE);
		textField_50.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_50.setColumns(10);
		textField_50.setBorder(null);
		textField_50.setBackground(new Color(36, 47, 65));
		textField_50.setBounds(191, 371, 303, 20);
		panel_5.add(textField_50);

		JLabel label_87 = new JLabel("School");
		label_87.setForeground(Color.WHITE);
		label_87.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_87.setBounds(33, 404, 61, 27);
		panel_5.add(label_87);

		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setForeground(Color.BLACK);
		comboBox_21.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_21.setBorder(null);
		comboBox_21.setBackground(Color.WHITE);
		comboBox_21.setBounds(191, 409, 154, 20);
		fillSchools(comboBox_21);
		panel_5.add(comboBox_21);

		JButton button_16 = new JButton("Update");
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String rollNo = textField_51.getText();
					String name = textField_49.getText();
					Date DOB = Date.valueOf(textField_31.getText());
					String phone = textField_45.getText();
					String email = textField_46.getText();
					String CNIC = textField_47.getText();
					String eCont = textField_48.getText();
					char gender = (char) comboBox_19.getSelectedItem();
					String address = textField_50.getText();

					Student std = Session.getInst().getStudent(rollNo);

					if (user.updateStudent(rollNo, name, DOB, phone, email, CNIC, gender, eCont, address,
							std.getFatherCNIC(), std.getFatherName()))
						JOptionPane.showMessageDialog(frame, "Student updated!", "Alert", JOptionPane.OK_OPTION);
					else
						JOptionPane.showMessageDialog(frame, "Student not updated!", "Alert",
								JOptionPane.WARNING_MESSAGE);
				} catch (Exception excep) {
					JOptionPane.showMessageDialog(frame, "Invalid details entered! Please check types/format", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_16.setForeground(Color.WHITE);
		button_16.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_16.setBackground(new Color(36, 47, 65));
		button_16.setBounds(191, 485, 130, 23);
		panel_5.add(button_16);

		JLabel label_88 = new JLabel("Roll Number");
		label_88.setForeground(Color.WHITE);
		label_88.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_88.setBounds(33, 69, 87, 27);
		panel_5.add(label_88);

		textField_51 = new JTextField();
		textField_51.setForeground(Color.WHITE);
		textField_51.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_51.setColumns(10);
		textField_51.setBorder(null);
		textField_51.setBackground(new Color(36, 47, 65));
		textField_51.setBounds(191, 72, 154, 22);
		panel_5.add(textField_51);

		JButton button_17 = new JButton("Search");
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String rollNo = textField_51.getText();
				System.out.println(rollNo);

				Student student = Session.getInst().getStudent(rollNo);

				if (student != null) {
					textField_49.setText(student.getName());
					textField_31.setText(student.getDOB().toString());
					textField_45.setText(student.getPhoneNo());
					textField_46.setText(student.getEmail());
					textField_47.setText(student.getCNIC());
					textField_48.setText(student.getEmergencyContact());
					textField_50.setText(student.getAddress());
				} else
					JOptionPane.showMessageDialog(frame, "Student not found!", "Alert", JOptionPane.WARNING_MESSAGE);
			}
		});

		button_17.setForeground(Color.WHITE);
		button_17.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_17.setBackground(new Color(36, 47, 65));
		button_17.setBounds(364, 73, 130, 23);
		panel_5.add(button_17);

		textField_31 = new JTextField();
		textField_31.setForeground(Color.WHITE);
		textField_31.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_31.setColumns(10);
		textField_31.setBorder(null);
		textField_31.setBackground(new Color(36, 47, 65));
		textField_31.setBounds(191, 145, 154, 20);
		panel_5.add(textField_31);

		updateFaculty = new JScrollPane();
		updateFaculty.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		updateFaculty.setBackground(Color.BLACK);
		updateFaculty.setBounds(249, 152, 704, 440);
		contentPane.add(updateFaculty);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setPreferredSize(new Dimension(704, 600));
		panel_7.setBackground(Color.BLACK);
		updateFaculty.setViewportView(panel_7);

		JLabel lblUpdateFaculty_1 = new JLabel("Update Faculty");
		lblUpdateFaculty_1.setForeground(Color.WHITE);
		lblUpdateFaculty_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateFaculty_1.setBounds(33, 11, 212, 35);
		panel_7.add(lblUpdateFaculty_1);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(33, 48, 197, 2);
		panel_7.add(separator_5);

		JLabel label_15 = new JLabel("Name");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_15.setBounds(33, 102, 54, 27);
		panel_7.add(label_15);

		JLabel label_16 = new JLabel("Date of Birth");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_16.setBounds(33, 140, 99, 27);
		panel_7.add(label_16);

		JLabel label_21 = new JLabel("Phone");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_21.setBounds(33, 178, 54, 27);
		panel_7.add(label_21);

		textField_26 = new JTextField();
		textField_26.setForeground(Color.WHITE);
		textField_26.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_26.setColumns(10);
		textField_26.setBorder(null);
		textField_26.setBackground(new Color(36, 47, 65));
		textField_26.setBounds(191, 182, 154, 20);
		panel_7.add(textField_26);

		JLabel label_50 = new JLabel("Email");
		label_50.setForeground(Color.WHITE);
		label_50.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_50.setBounds(33, 214, 54, 27);
		panel_7.add(label_50);

		textField_56 = new JTextField();
		textField_56.setForeground(Color.WHITE);
		textField_56.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_56.setColumns(10);
		textField_56.setBorder(null);
		textField_56.setBackground(new Color(36, 47, 65));
		textField_56.setBounds(191, 218, 154, 20);
		panel_7.add(textField_56);

		JLabel label_51 = new JLabel("CNIC");
		label_51.setForeground(Color.WHITE);
		label_51.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_51.setBounds(33, 252, 54, 27);
		panel_7.add(label_51);

		textField_57 = new JTextField();
		textField_57.setForeground(Color.WHITE);
		textField_57.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_57.setColumns(10);
		textField_57.setBorder(null);
		textField_57.setBackground(new Color(36, 47, 65));
		textField_57.setBounds(191, 256, 154, 20);
		panel_7.add(textField_57);

		textField_58 = new JTextField();
		textField_58.setForeground(Color.WHITE);
		textField_58.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_58.setColumns(10);
		textField_58.setBorder(null);
		textField_58.setBackground(new Color(36, 47, 65));
		textField_58.setBounds(191, 295, 154, 20);
		panel_7.add(textField_58);

		textField_59 = new JTextField();
		textField_59.setForeground(Color.WHITE);
		textField_59.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_59.setColumns(10);
		textField_59.setBorder(null);
		textField_59.setBackground(new Color(36, 47, 65));
		textField_59.setBounds(191, 523, 154, 20);
		panel_7.add(textField_59);

		JLabel label_52 = new JLabel("Gender");
		label_52.setForeground(Color.WHITE);
		label_52.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_52.setBounds(33, 328, 61, 27);
		panel_7.add(label_52);

		JLabel label_90 = new JLabel("Emergency Contact");
		label_90.setForeground(Color.WHITE);
		label_90.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_90.setBounds(33, 290, 148, 27);
		panel_7.add(label_90);

		JComboBox comboBox_26 = new JComboBox();
		comboBox_26.setForeground(Color.BLACK);
		comboBox_26.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_26.setBorder(null);
		comboBox_26.setBackground(Color.WHITE);
		comboBox_26.setBounds(191, 331, 154, 20);
		comboBox_26.addItem('M');
		comboBox_26.addItem('F');
		panel_7.add(comboBox_26);

		textField_60 = new JTextField();
		textField_60.setText("First");
		textField_60.setForeground(Color.WHITE);
		textField_60.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_60.setColumns(10);
		textField_60.setBorder(null);
		textField_60.setBackground(new Color(36, 47, 65));
		textField_60.setBounds(191, 105, 154, 22);
		panel_7.add(textField_60);

		JLabel label_91 = new JLabel("Address");
		label_91.setForeground(Color.WHITE);
		label_91.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_91.setBounds(33, 366, 61, 27);
		panel_7.add(label_91);

		textField_61 = new JTextField();
		textField_61.setForeground(Color.WHITE);
		textField_61.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_61.setColumns(10);
		textField_61.setBorder(null);
		textField_61.setBackground(new Color(36, 47, 65));
		textField_61.setBounds(191, 371, 262, 20);
		panel_7.add(textField_61);

		JLabel label_92 = new JLabel("School");
		label_92.setForeground(Color.WHITE);
		label_92.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_92.setBounds(33, 404, 61, 27);
		panel_7.add(label_92);

		JComboBox comboBox_28 = new JComboBox();
		comboBox_28.setForeground(Color.BLACK);
		comboBox_28.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_28.setBorder(null);
		comboBox_28.setBackground(Color.WHITE);
		comboBox_28.setBounds(191, 409, 154, 20);
		fillSchools(comboBox_28);
		panel_7.add(comboBox_28);

		JLabel label_93 = new JLabel("Picture");
		label_93.setForeground(Color.WHITE);
		label_93.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_93.setBounds(33, 447, 61, 27);
		panel_7.add(label_93);

		JLabel label_94 = new JLabel("Degrees");
		label_94.setForeground(Color.WHITE);
		label_94.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_94.setBounds(33, 485, 80, 27);
		panel_7.add(label_94);

		textField_62 = new JTextField();
		textField_62.setForeground(Color.WHITE);
		textField_62.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_62.setColumns(10);
		textField_62.setBorder(null);
		textField_62.setBackground(new Color(36, 47, 65));
		textField_62.setBounds(191, 485, 303, 20);
		panel_7.add(textField_62);

		JLabel label_95 = new JLabel("Position");
		label_95.setForeground(Color.WHITE);
		label_95.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_95.setBounds(33, 523, 61, 27);
		panel_7.add(label_95);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// REGISTER FACULTY
				String name = textField_60.getText();

				// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				// try {
				// Date dob = (Date) format.parse(textField.getText());
				// } catch (ParseException e1) {
				// // TODO Auto-generated catch block
				// e1.printStackTrace();
				// }
				// java.sql.Date sql = new java.sql.Date(dob.getTime());
				String phone = textField_26.getText();
				String email = textField_56.getText();
				String cnic = textField_57.getText();
				String emer = textField_58.getText();
				char gender = (char) comboBox_26.getSelectedItem();
				System.out.println(gender);
				String address = textField_61.getText();
				String schoolID = (String) comboBox_28.getSelectedItem();
				ArrayList<String> degrees = new ArrayList<String>();
				degrees.add(textField_62.getText());
				String position = textField_59.getText();
				// Date dateHired = datePicker.getDate..
				String empID = textField_6.getText();
				// if (Session.getUser().updateFaculty(schoolID, name, "password", dob, phone,
				// email, cnic, gender,
				// emer, address, Date dateHired, degrees,
				// position, empID) == null)
				{
					// error prompt
				}
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUpdate.setBackground(new Color(36, 47, 65));
		btnUpdate.setBounds(191, 561, 130, 23);
		panel_7.add(btnUpdate);

		JLabel label_96 = new JLabel("Date Hired");
		label_96.setForeground(Color.WHITE);
		label_96.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_96.setBounds(368, 324, 99, 27);
		panel_7.add(label_96);

		textField_63 = new JTextField();
		textField_63.setForeground(Color.WHITE);
		textField_63.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_63.setColumns(10);
		textField_63.setBorder(null);
		textField_63.setBackground(new Color(36, 47, 65));
		textField_63.setBounds(191, 68, 154, 22);
		panel_7.add(textField_63);

		JLabel label_97 = new JLabel("Employee ID");
		label_97.setForeground(Color.WHITE);
		label_97.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_97.setBounds(33, 65, 116, 27);
		panel_7.add(label_97);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FacultyMember staff = (FacultyMember) Session.getInst().getStaff(textField_63.getText());
					if (staff != null) {
						textField_60.setText(staff.getName());
						textField.setText(staff.getDOB().toString());
						textField_26.setText(staff.getPhoneNo());
						textField_56.setText(staff.getEmail());
						textField_57.setText(staff.getCNIC());
						textField_58.setText(staff.getEmergencyContact());
						textField_61.setText(staff.getAddress());
						textField_30.setText(staff.getDateHired().toString());
						textField_59.setText(staff.getPosition());

					}
				} catch (Exception excep) {
					JOptionPane.showMessageDialog(frame, "An error occurred! Please check parameters", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
		btnSearch_1.setBounds(364, 69, 89, 23);
		panel_7.add(btnSearch_1);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(36, 47, 65));
		textField.setBounds(191, 145, 154, 20);
		panel_7.add(textField);

		textField_30 = new JTextField();
		textField_30.setForeground(Color.WHITE);
		textField_30.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_30.setColumns(10);
		textField_30.setBorder(null);
		textField_30.setBackground(new Color(36, 47, 65));
		textField_30.setBounds(470, 328, 154, 20);
		panel_7.add(textField_30);

		registerFaculty = new JScrollPane();
		registerFaculty.setBounds(249, 152, 704, 442);
		contentPane.add(registerFaculty);
		registerFaculty.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		registerFaculty.setBackground(Color.BLACK);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(704, 600));
		panel.setBackground(Color.BLACK);
		registerFaculty.setViewportView(panel);

		JLabel label_27 = new JLabel("Faculty Registration");
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_27.setBounds(33, 11, 212, 35);
		panel.add(label_27);

		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(33, 48, 197, 2);
		panel.add(separator_12);

		JLabel label_28 = new JLabel("Name");
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_28.setBounds(33, 102, 54, 27);
		panel.add(label_28);

		textField_3 = new JTextField();
		textField_3.setText("Last");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(36, 47, 65));
		textField_3.setBounds(364, 106, 130, 20);
		panel.add(textField_3);

		JLabel label_29 = new JLabel("Date of Birth");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_29.setBounds(33, 140, 99, 27);
		panel.add(label_29);

		JLabel label_30 = new JLabel("Phone");
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_30.setBounds(33, 178, 54, 27);
		panel.add(label_30);

		textField_8 = new JTextField();
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(new Color(36, 47, 65));
		textField_8.setBounds(191, 182, 154, 20);
		panel.add(textField_8);

		JLabel label_31 = new JLabel("Email");
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_31.setBounds(33, 214, 54, 27);
		panel.add(label_31);

		textField_9 = new JTextField();
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		textField_9.setBackground(new Color(36, 47, 65));
		textField_9.setBounds(191, 218, 154, 20);
		panel.add(textField_9);

		JLabel label_32 = new JLabel("CNIC");
		label_32.setForeground(Color.WHITE);
		label_32.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_32.setBounds(33, 252, 54, 27);
		panel.add(label_32);

		textField_10 = new JTextField();
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_10.setColumns(10);
		textField_10.setBorder(null);
		textField_10.setBackground(new Color(36, 47, 65));
		textField_10.setBounds(191, 256, 154, 20);
		panel.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setForeground(Color.WHITE);
		textField_11.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_11.setColumns(10);
		textField_11.setBorder(null);
		textField_11.setBackground(new Color(36, 47, 65));
		textField_11.setBounds(191, 295, 154, 20);
		panel.add(textField_11);

		textPos = new JTextField();
		textPos.setForeground(Color.WHITE);
		textPos.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textPos.setColumns(10);
		textPos.setBorder(null);
		textPos.setBackground(new Color(36, 47, 65));
		textPos.setBounds(191, 523, 154, 20);
		panel.add(textPos);

		JLabel label_33 = new JLabel("Gender");
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_33.setBounds(33, 328, 61, 27);
		panel.add(label_33);

		JLabel label_34 = new JLabel("Emergency Contact");
		label_34.setForeground(Color.WHITE);
		label_34.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_34.setBounds(33, 290, 148, 27);
		panel.add(label_34);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setForeground(Color.BLACK);
		comboBox_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_6.setBorder(null);
		comboBox_6.setBackground(Color.WHITE);
		comboBox_6.setBounds(191, 331, 154, 20);
		comboBox_6.addItem('M');
		comboBox_6.addItem('F');
		panel.add(comboBox_6);

		textField_12 = new JTextField();
		textField_12.setText("First");
		textField_12.setForeground(Color.WHITE);
		textField_12.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_12.setColumns(10);
		textField_12.setBorder(null);
		textField_12.setBackground(new Color(36, 47, 65));
		textField_12.setBounds(191, 105, 154, 22);
		panel.add(textField_12);

		JLabel label_35 = new JLabel("Address");
		label_35.setForeground(Color.WHITE);
		label_35.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_35.setBounds(33, 366, 61, 27);
		panel.add(label_35);

		textField_13 = new JTextField();
		textField_13.setForeground(Color.WHITE);
		textField_13.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_13.setColumns(10);
		textField_13.setBorder(null);
		textField_13.setBackground(new Color(36, 47, 65));
		textField_13.setBounds(191, 371, 303, 20);
		panel.add(textField_13);

		JLabel label_36 = new JLabel("School");
		label_36.setForeground(Color.WHITE);
		label_36.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_36.setBounds(33, 404, 61, 27);
		panel.add(label_36);

		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setForeground(Color.BLACK);
		comboBox_8.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_8.setBorder(null);
		comboBox_8.setBackground(Color.WHITE);
		comboBox_8.setBounds(191, 409, 154, 20);
		fillSchools(comboBox_8);
		panel.add(comboBox_8);

		JLabel label_37 = new JLabel("Picture");
		label_37.setForeground(Color.WHITE);
		label_37.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_37.setBounds(33, 447, 61, 27);
		panel.add(label_37);

		JLabel label_38 = new JLabel("Degrees");
		label_38.setForeground(Color.WHITE);
		label_38.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_38.setBounds(33, 485, 80, 27);
		panel.add(label_38);

		textField_14 = new JTextField();
		textField_14.setForeground(Color.WHITE);
		textField_14.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_14.setColumns(10);
		textField_14.setBorder(null);
		textField_14.setBackground(new Color(36, 47, 65));
		textField_14.setBounds(191, 485, 303, 20);
		panel.add(textField_14);

		JLabel label_39 = new JLabel("Position");
		label_39.setForeground(Color.WHITE);
		label_39.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_39.setBounds(33, 523, 61, 27);
		panel.add(label_39);

		JButton button_4 = new JButton("Register");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// REGISTER FACULTY
				try {
					String name = textField_12.getText() + " " + textField_3.getText();
					Date dob = Date.valueOf(textField_32.getText());
					String phone = textField_8.getText();
					String email = textField_9.getText();
					String cnic = textField_10.getText();
					String emer = textField_11.getText();
					char gender = (char) comboBox_6.getSelectedItem();
					System.out.println(gender);
					String address = textField_13.getText();
					String schoolID = (String) comboBox_8.getSelectedItem();
					ArrayList<String> degrees = new ArrayList<String>();
					degrees.add(textField_14.getText());
					String position = textPos.getText();
					Date dateHired = Date.valueOf(textField_33.getText());
					String empID = textField_6.getText();

					if (user.RegisterFaculty(schoolID, name, "12345", dob, phone, email, cnic, gender, emer, address,
							dateHired, degrees, position, empID)) {
						JOptionPane.showMessageDialog(frame, "Successfully Registered!", "Alert",
								JOptionPane.OK_OPTION);
					} else
						JOptionPane.showMessageDialog(frame, "Could not register!", "Alert",
								JOptionPane.WARNING_MESSAGE);
				} catch (Exception excep) {
					JOptionPane.showMessageDialog(frame, "Invalid details entered! Please check types/format", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_4.setBackground(new Color(36, 47, 65));
		button_4.setBounds(191, 561, 130, 23);
		panel.add(button_4);

		JLabel lblDateHired = new JLabel("Date Hired");
		lblDateHired.setForeground(Color.WHITE);
		lblDateHired.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDateHired.setBounds(368, 324, 99, 27);
		panel.add(lblDateHired);

		textField_6 = new JTextField();
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(new Color(36, 47, 65));
		textField_6.setBounds(191, 68, 154, 22);
		panel.add(textField_6);

		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setForeground(Color.WHITE);
		lblEmployeeId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEmployeeId.setBounds(33, 65, 116, 27);
		panel.add(lblEmployeeId);

		textField_32 = new JTextField();
		textField_32.setForeground(Color.WHITE);
		textField_32.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_32.setColumns(10);
		textField_32.setBorder(null);
		textField_32.setBackground(new Color(36, 47, 65));
		textField_32.setBounds(191, 145, 154, 20);
		panel.add(textField_32);

		textField_33 = new JTextField();
		textField_33.setForeground(Color.WHITE);
		textField_33.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_33.setColumns(10);
		textField_33.setBorder(null);
		textField_33.setBackground(new Color(36, 47, 65));
		textField_33.setBounds(463, 328, 154, 20);
		panel.add(textField_33);

		removeFaculty = new JScrollPane();
		removeFaculty.setBounds(249, 152, 704, 442);
		contentPane.add(removeFaculty);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(704, 430));
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.BLACK);
		removeFaculty.setViewportView(panel_3);

		JLabel lblRemoveFaculty_1 = new JLabel("Remove Faculty");
		lblRemoveFaculty_1.setForeground(Color.WHITE);
		lblRemoveFaculty_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRemoveFaculty_1.setBounds(33, 11, 227, 35);
		panel_3.add(lblRemoveFaculty_1);

		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(33, 48, 165, 2);
		panel_3.add(separator_14);

		JLabel lblSearchFaculty = new JLabel("Search Faculty");
		lblSearchFaculty.setForeground(Color.WHITE);
		lblSearchFaculty.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSearchFaculty.setBounds(54, 77, 179, 17);
		panel_3.add(lblSearchFaculty);

		textField_24 = new JTextField();
		textField_24.setText("1234");
		textField_24.setForeground(Color.WHITE);
		textField_24.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_24.setColumns(10);
		textField_24.setBorder(null);
		textField_24.setBackground(new Color(36, 47, 65));
		textField_24.setBounds(221, 75, 282, 22);
		panel_3.add(textField_24);

		JButton button_7 = new JButton("Search");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// FacultyMember fac = Session.getInst().getFaculty(textField_24.getText());
				// if (fac != null)
				// {

				String[] columnNames = { "Emp ID", "Name", "DOB" };

				table2 = new JTable();
				dtm = new DefaultTableModel(0, 0);
				dtm.setColumnIdentifiers(columnNames);
				table2.setModel(dtm);

				scrollPane_3 = new JScrollPane(table2);
				scrollPane_3.setForeground(Color.WHITE);
				scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
				scrollPane_3.setBackground(Color.WHITE);
				scrollPane_3.setAlignmentX(0.0f);
				scrollPane_3.setBounds(197, 135, 279, 40);
				panel_3.add(scrollPane_3);

				dtm.addRow(new Object[] { "LOL", "LOL", "LOL" });
			}
		});
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_7.setBackground(new Color(36, 47, 65));
		button_7.setBounds(539, 76, 130, 23);
		panel_3.add(button_7);

		JButton button_19 = new JButton("Search");
		button_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FacultyMember fac = Session.getInst().getFacultyMember(textField_55.getText());
				if (fac != null) {

					String[] columnNames = { "Emp ID", "Name", "DOB" };

					table3 = new JTable();
					dtm2 = new DefaultTableModel(0, 0);
					dtm2.setColumnIdentifiers(columnNames);
					table3.setModel(dtm2);

					scrollPane_4 = new JScrollPane(table3);
					scrollPane_4.setForeground(Color.WHITE);
					scrollPane_4.setFont(new Font("Century Gothic", Font.PLAIN, 13));
					scrollPane_4.setBackground(Color.WHITE);
					scrollPane_4.setAlignmentX(0.0f);
					scrollPane_4.setBounds(197, 281, 279, 40);
					panel_3.add(scrollPane_4);

					dtm2.addRow(new Object[] { fac.getEmpID(), fac.getName(), fac.getDOB() });

					btnRemove = new JButton("Remove");
					btnRemove.setBounds(297, 392, 97, 25);
					panel_3.add(btnRemove);
					panel_3.repaint();
					btnRemove.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (user.isTeacherTeachingInCurrSem((String) dtm.getValueAt(0, 0))) {
								if (user.removeFaculty((String) dtm.getValueAt(0, 0), (String) dtm2.getValueAt(0, 0)))
									JOptionPane.showMessageDialog(frame, "Faculty Removed!", "Alert",
											JOptionPane.OK_OPTION);
								else
									JOptionPane.showMessageDialog(frame, "Cannot remove!", "Alert",
											JOptionPane.WARNING_MESSAGE);
							} else {
								if (user.removeFaculty((String) dtm.getValueAt(0, 0), null))
									JOptionPane.showMessageDialog(frame, "Faculty Removed!", "Alert",
											JOptionPane.OK_OPTION);
								else
									JOptionPane.showMessageDialog(frame, "Cannot remove!", "Alert",
											JOptionPane.WARNING_MESSAGE);
							}

						}
					});
					panel_3.add(btnRemove);
					panel_3.repaint();
				}
			}
		});
		button_19.setForeground(Color.BLACK);
		button_19.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_19.setBackground(new Color(36, 47, 65));
		button_19.setBounds(539, 222, 130, 23);
		panel_3.add(button_19);

		textField_55 = new JTextField();
		textField_55.setText("1234");
		textField_55.setForeground(Color.WHITE);
		textField_55.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_55.setColumns(10);
		textField_55.setBorder(null);
		textField_55.setBackground(new Color(36, 47, 65));
		textField_55.setBounds(221, 221, 282, 22);
		panel_3.add(textField_55);

		JLabel lblSearchReplacement = new JLabel("Search Replacement");
		lblSearchReplacement.setForeground(Color.WHITE);
		lblSearchReplacement.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSearchReplacement.setBounds(54, 223, 179, 17);
		panel_3.add(lblSearchReplacement);

		removeCourse = new JPanel();
		removeCourse.setLayout(null);
		removeCourse.setPreferredSize(new Dimension(704, 430));
		removeCourse.setForeground(Color.WHITE);
		removeCourse.setBackground(Color.BLACK);
		removeCourse.setBounds(249, 152, 704, 443);
		contentPane.add(removeCourse);

		JLabel label_10 = new JLabel("Remove Course");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_10.setBounds(33, 11, 227, 35);
		removeCourse.add(label_10);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(33, 48, 227, 2);
		removeCourse.add(separator_4);

		JLabel label_11 = new JLabel("Search Course by ID");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_11.setBounds(54, 60, 179, 17);
		removeCourse.add(label_11);

		textField_53 = new JTextField();
		textField_53.setText("CS 101");
		textField_53.setForeground(Color.WHITE);
		textField_53.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_53.setColumns(10);
		textField_53.setBorder(null);
		textField_53.setBackground(new Color(36, 47, 65));
		textField_53.setBounds(245, 58, 282, 22);
		removeCourse.add(textField_53);

		JButton button_18 = new JButton("Search");
		button_18.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String c_code = textField_53.getText();

				Course course = Session.getInst().getCourse(c_code);

				if (course != null) {
					String[] columnNames = { "Course Name", "Course Code" };

					table2 = new JTable();
					dtm = new DefaultTableModel(0, 0);
					dtm.setColumnIdentifiers(columnNames);
					table2.setModel(dtm);

					scrollPane_3 = new JScrollPane(table2);
					scrollPane_3.setForeground(Color.WHITE);
					scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
					scrollPane_3.setBackground(Color.WHITE);
					scrollPane_3.setAlignmentX(0.0f);
					scrollPane_3.setBounds(197, 135, 279, 40);
					removeCourse.add(scrollPane_3);

					dtm.addRow(new Object[] { course.getCourseName(), course.getCourseCode() });

					btnRemove_2 = new JButton("Remove");
					btnRemove_2.setBounds(274, 236, 89, 23);
					btnRemove_2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (user.removeCourse((String) dtm.getValueAt(0, 1)))
								JOptionPane.showMessageDialog(frame, "Course deleted!", "Alert", JOptionPane.OK_OPTION);
							else
								JOptionPane.showMessageDialog(frame, "Course could not be deleted!", "Alert",
										JOptionPane.WARNING_MESSAGE);
						}
					});
					removeCourse.add(btnRemove_2);
					// removeCourse.remove(btnRemove_2);

					removeCourse.repaint();
				} else
					JOptionPane.showMessageDialog(frame, "Course not found!", "Alert", JOptionPane.WARNING_MESSAGE);
			}
		});
		button_18.setForeground(Color.BLACK);
		button_18.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_18.setBackground(new Color(36, 47, 65));
		button_18.setBounds(539, 59, 130, 23);
		removeCourse.add(button_18);

		addSchool = new JPanel();
		addSchool.setLayout(null);
		addSchool.setPreferredSize(new Dimension(704, 550));
		addSchool.setBackground(Color.BLACK);
		addSchool.setBounds(249, 152, 704, 443);
		contentPane.add(addSchool);

		JLabel lblAddSchool_1 = new JLabel("Add School");
		lblAddSchool_1.setForeground(Color.WHITE);
		lblAddSchool_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddSchool_1.setBounds(33, 11, 123, 35);
		addSchool.add(lblAddSchool_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(33, 48, 123, 2);
		addSchool.add(separator_3);

		JLabel lblId = new JLabel("School ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblId.setBounds(33, 102, 104, 27);
		addSchool.add(lblId);

		JLabel label_12 = new JLabel("Name");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_12.setBounds(33, 140, 54, 27);
		addSchool.add(label_12);

		textField_7 = new JTextField();
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(new Color(36, 47, 65));
		textField_7.setBounds(191, 106, 154, 20);
		addSchool.add(textField_7);

		textField_54 = new JTextField();
		textField_54.setForeground(Color.WHITE);
		textField_54.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_54.setColumns(10);
		textField_54.setBorder(null);
		textField_54.setBackground(new Color(36, 47, 65));
		textField_54.setBounds(191, 143, 154, 22);
		addSchool.add(textField_54);

		JButton btnAddSchool = new JButton("Add School");
		btnAddSchool.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField_54.getText();
				String schoolID = textField_7.getText();

				if (!user.addSchool(schoolID, name)) {
					JOptionPane.showMessageDialog(frame, "Cannot add school!", "Alert", JOptionPane.WARNING_MESSAGE);
				} else
					JOptionPane.showMessageDialog(frame, "School added successfully!", "Alert", JOptionPane.OK_OPTION);
			}
		});

		btnAddSchool.setForeground(Color.BLACK);
		btnAddSchool.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnAddSchool.setBackground(new Color(36, 47, 65));
		btnAddSchool.setBounds(191, 215, 154, 23);
		addSchool.add(btnAddSchool);

		updateSchool = new JPanel();
		updateSchool.setBounds(249, 153, 704, 442);
		contentPane.add(updateSchool);
		updateSchool.setLayout(null);
		updateSchool.setPreferredSize(new Dimension(704, 550));
		updateSchool.setBackground(Color.BLACK);

		JLabel label_75 = new JLabel("Update School");
		label_75.setForeground(Color.WHITE);
		label_75.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_75.setBounds(33, 11, 213, 35);
		updateSchool.add(label_75);

		JSeparator separator_18 = new JSeparator();
		separator_18.setBounds(33, 48, 154, 2);
		updateSchool.add(separator_18);

		textField_41 = new JTextField();
		textField_41.setForeground(Color.WHITE);
		textField_41.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_41.setColumns(10);
		textField_41.setBorder(null);
		textField_41.setBackground(new Color(36, 47, 65));
		textField_41.setBounds(206, 152, 154, 20);
		updateSchool.add(textField_41);

		JButton button_14 = new JButton("Update");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String schoolID = (String) comboBox_18.getSelectedItem();
				String name = textField_41.getText();

				if (user.updateSchool(schoolID, name))
					JOptionPane.showMessageDialog(frame, "School Updated!", "Alert", JOptionPane.OK_OPTION);
				else
					JOptionPane.showMessageDialog(frame, "School could not be updated!", "Alert",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		button_14.setForeground(Color.BLACK);
		button_14.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_14.setBackground(new Color(36, 47, 65));
		button_14.setBounds(73, 229, 227, 23);
		updateSchool.add(button_14);

		JLabel label_76 = new JLabel("Updated Name");
		label_76.setForeground(Color.WHITE);
		label_76.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_76.setBounds(33, 148, 122, 27);
		updateSchool.add(label_76);

		JLabel label_77 = new JLabel("School");
		label_77.setForeground(Color.WHITE);
		label_77.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_77.setBounds(33, 108, 122, 27);
		updateSchool.add(label_77);

		comboBox_18 = new JComboBox();
		comboBox_18.setBounds(206, 111, 138, 22);
		updateSchool.add(comboBox_18);

		removeStudent = new JPanel();
		removeStudent.setBounds(249, 152, 704, 442);
		contentPane.add(removeStudent);
		removeStudent.setLayout(null);
		removeStudent.setPreferredSize(new Dimension(704, 550));
		removeStudent.setBackground(Color.BLACK);

		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String rollNo = textField_25.getText();
				System.out.println(rollNo);

				Student student = Session.getInst().getStudent(rollNo);

				if (student != null) {

					String[] columnNames = { "Roll Number", "Name", "DOB" };

					table2 = new JTable();
					dtm = new DefaultTableModel(0, 0);
					dtm.setColumnIdentifiers(columnNames);
					table2.setModel(dtm);

					dtm.addRow(new Object[] { student.getRollNo(), student.getName(), student.getDOB() });

					scrollPane_3 = new JScrollPane(table2);
					scrollPane_3.setForeground(Color.WHITE);
					scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
					scrollPane_3.setBackground(Color.WHITE);
					scrollPane_3.setAlignmentX(0.0f);
					scrollPane_3.setBounds(197, 135, 279, 40);
					removeStudent.add(scrollPane_3);

					// add student details instead

					btnRemove_1 = new JButton("Remove");
					btnRemove_1.setBounds(270, 215, 97, 25);
					btnRemove_1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							boolean removed = user.removeStudent((String) dtm.getValueAt(0, 0));

							if (removed)
								JOptionPane.showMessageDialog(frame, "Student has been removed!", "Alert",
										JOptionPane.OK_OPTION);
							else
								JOptionPane.showMessageDialog(frame, "Could not remove student!", "Alert",
										JOptionPane.WARNING_MESSAGE);

						}
					});
					removeStudent.add(btnRemove_1);
					removeStudent.repaint();

					// else remove btnRemove_1
					scrollPane_3.setVisible(true);
					btnRemove_1.setVisible(true);
				} else
					JOptionPane.showMessageDialog(frame, "Could not find student!", "Alert",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnSearch.setBackground(SystemColor.menu);
		btnSearch.setBounds(442, 98, 130, 23);
		removeStudent.add(btnSearch);

		JLabel label_53 = new JLabel("Remove Student");
		label_53.setForeground(Color.WHITE);
		label_53.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_53.setBounds(33, 11, 170, 35);
		removeStudent.add(label_53);

		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(33, 48, 170, 2);
		removeStudent.add(separator_15);

		JLabel label_54 = new JLabel("Roll Number");
		label_54.setForeground(Color.WHITE);
		label_54.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_54.setBounds(104, 96, 87, 27);
		removeStudent.add(label_54);

		textField_25 = new JTextField();
		textField_25.setText("15L-1234");
		textField_25.setForeground(Color.WHITE);
		textField_25.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_25.setColumns(10);
		textField_25.setBorder(null);
		textField_25.setBackground(new Color(36, 47, 65));
		textField_25.setBounds(218, 100, 198, 20);
		removeStudent.add(textField_25);

		registerStudent = new JScrollPane();
		registerStudent.setBounds(249, 152, 704, 442);
		contentPane.add(registerStudent);
		registerStudent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		registerStudent.setBackground(Color.BLACK);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(704, 550));
		panel_1.setBackground(Color.BLACK);
		registerStudent.setViewportView(panel_1);

		JLabel label_40 = new JLabel("Student Registration");
		label_40.setForeground(Color.WHITE);
		label_40.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_40.setBounds(33, 11, 212, 35);
		panel_1.add(label_40);

		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(33, 48, 197, 2);
		panel_1.add(separator_13);

		JLabel label_41 = new JLabel("Name");
		label_41.setForeground(Color.WHITE);
		label_41.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_41.setBounds(33, 63, 54, 27);
		panel_1.add(label_41);

		textField_15 = new JTextField();
		textField_15.setText("Last");
		textField_15.setForeground(Color.WHITE);
		textField_15.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_15.setColumns(10);
		textField_15.setBorder(null);
		textField_15.setBackground(new Color(36, 47, 65));
		textField_15.setBounds(364, 67, 130, 20);
		panel_1.add(textField_15);

		JLabel label_42 = new JLabel("Date of Birth");
		label_42.setForeground(Color.WHITE);
		label_42.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_42.setBounds(33, 101, 99, 27);
		panel_1.add(label_42);

		JLabel label_43 = new JLabel("Phone");
		label_43.setForeground(Color.WHITE);
		label_43.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_43.setBounds(33, 139, 54, 27);
		panel_1.add(label_43);

		textField_18 = new JTextField();
		textField_18.setForeground(Color.WHITE);
		textField_18.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_18.setColumns(10);
		textField_18.setBorder(null);
		textField_18.setBackground(new Color(36, 47, 65));
		textField_18.setBounds(191, 143, 154, 20);
		panel_1.add(textField_18);

		JLabel label_44 = new JLabel("Email");
		label_44.setForeground(Color.WHITE);
		label_44.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_44.setBounds(33, 175, 54, 27);
		panel_1.add(label_44);

		textField_19 = new JTextField();
		textField_19.setForeground(Color.WHITE);
		textField_19.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_19.setColumns(10);
		textField_19.setBorder(null);
		textField_19.setBackground(new Color(36, 47, 65));
		textField_19.setBounds(191, 179, 154, 20);
		panel_1.add(textField_19);

		JLabel label_45 = new JLabel("CNIC");
		label_45.setForeground(Color.WHITE);
		label_45.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_45.setBounds(33, 252, 54, 27);
		panel_1.add(label_45);

		textField_20 = new JTextField();
		textField_20.setForeground(Color.WHITE);
		textField_20.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_20.setColumns(10);
		textField_20.setBorder(null);
		textField_20.setBackground(new Color(36, 47, 65));
		textField_20.setBounds(191, 256, 154, 20);
		panel_1.add(textField_20);

		textField_21 = new JTextField();
		textField_21.setForeground(Color.WHITE);
		textField_21.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_21.setColumns(10);
		textField_21.setBorder(null);
		textField_21.setBackground(new Color(36, 47, 65));
		textField_21.setBounds(191, 295, 154, 20);
		panel_1.add(textField_21);

		JLabel label_46 = new JLabel("Gender");
		label_46.setForeground(Color.WHITE);
		label_46.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_46.setBounds(33, 328, 61, 27);
		panel_1.add(label_46);

		JLabel label_47 = new JLabel("Emergency Contact");
		label_47.setForeground(Color.WHITE);
		label_47.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_47.setBounds(33, 290, 148, 27);
		panel_1.add(label_47);

		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setForeground(Color.BLACK);
		comboBox_10.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_10.setBorder(null);
		comboBox_10.setBackground(Color.WHITE);
		comboBox_10.setBounds(191, 331, 154, 20);
		comboBox_10.addItem('M');
		comboBox_10.addItem('F');
		panel_1.add(comboBox_10);

		textField_22 = new JTextField();
		textField_22.setText("First");
		textField_22.setForeground(Color.WHITE);
		textField_22.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_22.setColumns(10);
		textField_22.setBorder(null);
		textField_22.setBackground(new Color(36, 47, 65));
		textField_22.setBounds(191, 66, 154, 22);
		panel_1.add(textField_22);

		JLabel label_48 = new JLabel("Address");
		label_48.setForeground(Color.WHITE);
		label_48.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_48.setBounds(33, 366, 61, 27);
		panel_1.add(label_48);

		textField_23 = new JTextField();
		textField_23.setForeground(Color.WHITE);
		textField_23.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_23.setColumns(10);
		textField_23.setBorder(null);
		textField_23.setBackground(new Color(36, 47, 65));
		textField_23.setBounds(191, 371, 303, 20);
		panel_1.add(textField_23);

		JLabel label_49 = new JLabel("School");
		label_49.setForeground(Color.WHITE);
		label_49.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_49.setBounds(33, 404, 61, 27);
		panel_1.add(label_49);

		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setForeground(Color.BLACK);
		comboBox_12.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_12.setBorder(null);
		comboBox_12.setBackground(Color.WHITE);
		comboBox_12.setBounds(191, 409, 154, 20);
		fillSchools(comboBox_12);
		panel_1.add(comboBox_12);

		JButton button_6 = new JButton("Register");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// REGISTER STUDENT
				try {
					String name = textField_22.getText() + " " + textField_15.getText();
					Date date = Date.valueOf(textField_2.getText());
					String phone = textField_18.getText();
					String email = textField_19.getText();
					String cnic = textField_20.getText();
					String emer = textField_21.getText();
					char gender = (char) comboBox_10.getSelectedItem();
					String address = textField_23.getText();
					String schoolID = (String) comboBox_12.getSelectedItem();
					String fCNIC = textField_52.getText();
					String fname = textField_16.getText();

					AcademicManager user = (AcademicManager) Session.getUser();

					int rollNo = 150000;

					if (DAL.ifRollNoExists(Integer.toString(rollNo))) {
						rollNo++;
					}

					if (user.registerStudent(schoolID, name, date, phone, email, cnic, gender, emer, address,
							"L" + Integer.toString(rollNo), fCNIC, fname)) {
						JOptionPane.showMessageDialog(frame, "Registered!", "Alert", JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showMessageDialog(frame, "Could not register!", "Alert",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception excep) {
					JOptionPane.showMessageDialog(frame, "Invalid details entered! Please check types/format", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_6.setBackground(new Color(36, 47, 65));
		button_6.setBounds(191, 485, 130, 23);
		panel_1.add(button_6);

		JLabel lblFatherCnic = new JLabel("Father CNIC");
		lblFatherCnic.setForeground(Color.WHITE);
		lblFatherCnic.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblFatherCnic.setBounds(33, 212, 93, 27);
		panel_1.add(lblFatherCnic);

		textField_52 = new JTextField();
		textField_52.setForeground(Color.WHITE);
		textField_52.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_52.setColumns(10);
		textField_52.setBorder(null);
		textField_52.setBackground(new Color(36, 47, 65));
		textField_52.setBounds(191, 216, 154, 20);
		panel_1.add(textField_52);

		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblFatherName.setBounds(364, 212, 99, 27);
		panel_1.add(lblFatherName);

		textField_16 = new JTextField();
		textField_16.setForeground(Color.WHITE);
		textField_16.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_16.setColumns(10);
		textField_16.setBorder(null);
		textField_16.setBackground(new Color(36, 47, 65));
		textField_16.setBounds(469, 216, 154, 20);
		panel_1.add(textField_16);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(36, 47, 65));
		textField_2.setBounds(191, 106, 154, 20);
		panel_1.add(textField_2);

		home = new JPanel();
		home.setBounds(249, 152, 704, 442);
		contentPane.add(home);
		home.setLayout(null);
		home.setBackground(Color.BLACK);

		JLabel label_7 = new JLabel("UserImage");
		label_7.setIcon(new ImageIcon(AMFrame.class.getResource("/images/user2.png")));
		label_7.setBounds(54, 71, 99, 152);
		home.add(label_7);

		JLabel label_8 = new JLabel("Profile");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_8.setBounds(69, 25, 93, 16);
		home.add(label_8);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(70, 50, 61, 2);
		home.add(separator_1);
		JLabel lblEhtishamulhaq = new JLabel(user.getName());
		lblEhtishamulhaq.setForeground(Color.WHITE);
		lblEhtishamulhaq.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEhtishamulhaq.setBounds(70, 252, 175, 27);
		home.add(lblEhtishamulhaq);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(71, 283, 61, 2);
		home.add(separator_1_1);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(71, 323, 61, 2);
		home.add(separator_2_1);

		JLabel label_7_1 = new JLabel(user.getPhoneNo());
		label_7_1.setForeground(Color.WHITE);
		label_7_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_7_1.setBounds(70, 292, 175, 27);
		home.add(label_7_1);

		JLabel lblPrincessshamsgmailcom = new JLabel(user.getEmail());
		lblPrincessshamsgmailcom.setForeground(Color.WHITE);
		lblPrincessshamsgmailcom.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPrincessshamsgmailcom.setBounds(70, 334, 205, 27);
		home.add(lblPrincessshamsgmailcom);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(71, 365, 61, 2);
		home.add(separator_3_1);

		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(71, 405, 61, 2);
		home.add(separator_4_1);

		JLabel lblHStreet = new JLabel(user.getAddress());
		lblHStreet.setForeground(Color.WHITE);
		lblHStreet.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblHStreet.setBounds(70, 374, 239, 27);
		home.add(lblHStreet);

		JSeparator separator_5_1 = new JSeparator();
		separator_5_1.setBounds(418, 405, 61, 2);
		home.add(separator_5_1);

		JLabel lblGenderM = new JLabel("Gender: " + user.getGender());
		lblGenderM.setForeground(Color.WHITE);
		lblGenderM.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblGenderM.setBounds(417, 374, 175, 27);
		home.add(lblGenderM);

		JLabel lblDob = new JLabel("DOB: " + user.getDOB());
		lblDob.setForeground(Color.WHITE);
		lblDob.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDob.setBounds(417, 334, 250, 27);
		home.add(lblDob);

		JSeparator separator_6_1 = new JSeparator();
		separator_6_1.setBounds(418, 365, 61, 2);
		home.add(separator_6_1);

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

		updateCourse = new JPanel();
		updateCourse.setBounds(249, 152, 704, 442);
		contentPane.add(updateCourse);
		updateCourse.setLayout(null);
		updateCourse.setPreferredSize(new Dimension(704, 550));
		updateCourse.setBackground(Color.BLACK);

		JLabel label_55 = new JLabel("Update Course");
		label_55.setForeground(Color.WHITE);
		label_55.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_55.setBounds(33, 11, 154, 35);
		updateCourse.add(label_55);

		JSeparator separator_16 = new JSeparator();
		separator_16.setBounds(33, 48, 154, 2);
		updateCourse.add(separator_16);

		JLabel label_56 = new JLabel("Code");
		label_56.setForeground(Color.WHITE);
		label_56.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_56.setBounds(33, 102, 54, 27);
		updateCourse.add(label_56);

		JLabel label_57 = new JLabel("Name");
		label_57.setForeground(Color.WHITE);
		label_57.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_57.setBounds(33, 140, 54, 27);
		updateCourse.add(label_57);

		textField_27 = new JTextField();
		textField_27.setForeground(Color.WHITE);
		textField_27.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_27.setColumns(10);
		textField_27.setBorder(null);
		textField_27.setBackground(new Color(36, 47, 65));
		textField_27.setBounds(191, 106, 154, 20);
		updateCourse.add(textField_27);

		JLabel label_58 = new JLabel("Credit Hours");
		label_58.setForeground(Color.WHITE);
		label_58.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_58.setBounds(33, 178, 99, 27);
		updateCourse.add(label_58);

		textField_28 = new JTextField();
		textField_28.setForeground(Color.WHITE);
		textField_28.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_28.setColumns(10);
		textField_28.setBorder(null);
		textField_28.setBackground(new Color(36, 47, 65));
		textField_28.setBounds(191, 182, 154, 20);
		updateCourse.add(textField_28);

		JLabel label_59 = new JLabel("Description");
		label_59.setForeground(Color.WHITE);
		label_59.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_59.setBounds(33, 252, 82, 27);
		updateCourse.add(label_59);

		textField_29 = new JTextField();
		textField_29.setForeground(Color.WHITE);
		textField_29.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField_29.setColumns(10);
		textField_29.setBorder(null);
		textField_29.setBackground(new Color(36, 47, 65));
		textField_29.setBounds(191, 143, 303, 22);
		updateCourse.add(textField_29);

		JLabel label_60 = new JLabel("School");
		label_60.setForeground(Color.WHITE);
		label_60.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_60.setBounds(33, 216, 61, 27);
		updateCourse.add(label_60);

		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setForeground(Color.BLACK);
		comboBox_13.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_13.setBorder(null);
		comboBox_13.setBackground(Color.WHITE);
		comboBox_13.setBounds(191, 220, 154, 20);
		updateCourse.add(comboBox_13);

		JButton button_9 = new JButton("Update Course");
		button_9.setForeground(Color.BLACK);
		button_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_9.setBackground(new Color(36, 47, 65));
		button_9.setBounds(191, 348, 154, 23);
		updateCourse.add(button_9);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textArea_1.setBorder(null);
		textArea_1.setBackground(new Color(36, 47, 65));
		textArea_1.setBounds(191, 255, 303, 82);
		updateCourse.add(textArea_1);

		JButton button_10 = new JButton("Search");
		button_10.setForeground(Color.BLACK);
		button_10.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_10.setBackground(new Color(36, 47, 65));
		button_10.setBounds(405, 104, 89, 23);
		updateCourse.add(button_10);

		updateSection = new JPanel();
		updateSection.setBounds(249, 152, 704, 442);
		contentPane.add(updateSection);
		updateSection.setLayout(null);
		updateSection.setPreferredSize(new Dimension(704, 550));
		updateSection.setBackground(Color.BLACK);

		JLabel label_22 = new JLabel("Update Section");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_22.setBounds(33, 11, 154, 35);
		updateSection.add(label_22);

		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(33, 48, 154, 2);
		updateSection.add(separator_11);

		JLabel label_23 = new JLabel("Code");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_23.setBounds(33, 123, 54, 27);
		updateSection.add(label_23);

		JLabel label_24 = new JLabel("Section");
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_24.setBounds(33, 161, 54, 27);
		updateSection.add(label_24);

		JLabel label_25 = new JLabel("Faculty Member");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_25.setBounds(33, 201, 154, 25);
		updateSection.add(label_25);

		JLabel label_26 = new JLabel("Max Seats");
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_26.setBounds(33, 237, 104, 27);
		updateSection.add(label_26);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setForeground(Color.BLACK);
		comboBox_4.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_4.setBorder(null);
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(191, 203, 154, 20);
		updateSection.add(comboBox_4);

		JButton button_1 = new JButton("Update Course Section");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String schoolID = (String) comboBox_9.getSelectedItem();
				String c_code = (String) comboBox_14.getSelectedItem();
				String section = (String) comboBox_5.getSelectedItem();
				String empID = (String) comboBox_4.getSelectedItem();
				int maxSeats = (int) comboBox_15.getSelectedItem();

			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_1.setBackground(new Color(36, 47, 65));
		button_1.setBounds(164, 317, 227, 23);
		updateSection.add(button_1);

		comboBox_5 = new JComboBox();
		comboBox_5.setForeground(Color.BLACK);
		comboBox_5.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_5.setBorder(null);
		comboBox_5.setBackground(Color.WHITE);
		comboBox_5.setBounds(191, 164, 154, 20);
		updateSection.add(comboBox_5);

		comboBox_9 = new JComboBox();
		comboBox_9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_14.removeAllItems();
				// fillCourseCodes(comboBox_14, comboBox_9.getSelectedIndex());
				comboBox_5.removeAllItems();
				// fillCourseSections(comboBox_5, comboBox_9.getSelectedIndex(),
				// comboBox_14.getSelectedIndex());
				comboBox_4.removeAllItems();
				// fillFaculty(comboBox_4, comboBox_9.getSelectedIndex());

			}
		});
		comboBox_9.setForeground(Color.BLACK);
		comboBox_9.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_9.setBorder(null);
		comboBox_9.setBackground(Color.WHITE);
		comboBox_9.setBounds(191, 82, 154, 20);
		updateSection.add(comboBox_9);

		JLabel lblSchool_1 = new JLabel("School");
		lblSchool_1.setForeground(Color.WHITE);
		lblSchool_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSchool_1.setBounds(33, 79, 54, 27);
		updateSection.add(lblSchool_1);

		comboBox_14 = new JComboBox();
		comboBox_14.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox_5.removeAllItems();
				// fillCourseSections(comboBox_5, comboBox_9.getSelectedIndex(),
				// comboBox_14.getSelectedIndex());

			}
		});
		comboBox_14.setForeground(Color.BLACK);
		comboBox_14.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_14.setBorder(null);
		comboBox_14.setBackground(Color.WHITE);
		comboBox_14.setBounds(191, 123, 154, 20);
		updateSection.add(comboBox_14);

		comboBox_15 = new JComboBox();
		comboBox_15.setBounds(191, 242, 74, 20);
		updateSection.add(comboBox_15);
		updateSection.setVisible(false);

		removeSection = new JPanel();
		removeSection.setBounds(249, 152, 704, 442);
		contentPane.add(removeSection);
		removeSection.setLayout(null);
		removeSection.setPreferredSize(new Dimension(704, 550));
		removeSection.setBackground(Color.BLACK);

		JLabel label_17 = new JLabel("Remove Section");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_17.setBounds(33, 11, 213, 35);
		removeSection.add(label_17);

		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(33, 48, 154, 2);
		removeSection.add(separator_10);

		JLabel label_18 = new JLabel("Code");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_18.setBounds(33, 172, 54, 27);
		removeSection.add(label_18);

		JLabel label_19 = new JLabel("Section");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_19.setBounds(33, 225, 54, 27);
		removeSection.add(label_19);

		JButton button = new JButton("Remove Section");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String schoolID = (String) comboBox_1.getSelectedItem();
				String c_code = (String) comboBox_3.getSelectedItem();
				char secID = (char) comboBox.getSelectedItem();

				// if(Session.getUser().removeSection(schoolID, c_code, secID) == false)
				// {
				// prompt
				// }
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button.setBackground(new Color(36, 47, 65));
		button.setBounds(95, 320, 227, 23);
		removeSection.add(button);

		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox.setBorder(null);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(191, 232, 154, 20);
		removeSection.add(comboBox);

		JLabel label_20 = new JLabel("School");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_20.setBounds(33, 112, 54, 27);
		removeSection.add(label_20);

		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox_3.removeAllItems();
				comboBox.removeAllItems();
				// fillCourseCodes(comboBox_3, comboBox_1.getSelectedIndex());
				// fillCourseSections(comboBox, comboBox_1.getSelectedIndex(),
				// comboBox_3.getSelectedIndex());
			}
		});
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_1.setBorder(null);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(191, 115, 154, 20);
		removeSection.add(comboBox_1);

		comboBox_3 = new JComboBox();
		comboBox_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox.removeAllItems();
				// fillCourseSections(comboBox, ,comboBox_1.getSelectedIndex(),
				// comboBox_3.getSelectedIndex());
			}
		});
		comboBox_3.setForeground(Color.BLACK);
		comboBox_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		comboBox_3.setBorder(null);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(191, 175, 154, 20);
		removeSection.add(comboBox_3);
		removeSection.setVisible(false);
		for (int i = 5; i <= 50; i++) {
			comboBox_15.addItem(i);
		}

		manageSections = new JPanel();
		manageSections.setBounds(249, 152, 704, 442);
		contentPane.add(manageSections);
		manageSections.setLayout(null);
		manageSections.setPreferredSize(new Dimension(704, 430));
		manageSections.setForeground(Color.WHITE);
		manageSections.setBackground(Color.BLACK);

		JLabel lblRemoveSection = new JLabel("Remove Section");
		lblRemoveSection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblRemoveSection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

				comboBox_1.removeAllItems();
				fillSchools(comboBox_1);
				comboBox_3.removeAllItems();
				fillCourseCodes(comboBox_3, comboBox_1.getSelectedIndex());
				comboBox.removeAllItems();
				fillCourseSections(comboBox, comboBox_1.getSelectedIndex(), comboBox_3.getSelectedIndex());

			}
		});

		JLabel lblAddSection = new JLabel("Add Section");
		lblAddSection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblAddSection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

				comboBox_23.removeAllItems();
				fillSchools(comboBox_23);
				comboBox_24.removeAllItems();
				fillCourseCodes(comboBox_24, comboBox_23.getSelectedIndex());
				comboBox_25.removeAllItems();
				fillFaculty(comboBox_25, comboBox_23.getSelectedIndex());

			}

		});
		lblAddSection.setForeground(Color.WHITE);
		lblAddSection.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddSection.setBounds(133, 90, 158, 35);
		manageSections.add(lblAddSection);
		lblRemoveSection.setForeground(Color.WHITE);
		lblRemoveSection.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRemoveSection.setBounds(133, 179, 172, 35);
		manageSections.add(lblRemoveSection);

		JLabel lblUpdateSection = new JLabel("Update Section");
		lblUpdateSection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblUpdateSection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

				comboBox_9.removeAllItems();
				fillSchools(comboBox_9);
				comboBox_14.removeAllItems();
				// fillCourseCodes(comboBox_14, comboBox_9.getSelectedIndex());
				comboBox_4.removeAllItems();
				// fillFaculty(comboBox_4, comboBox_9.getSelectedIndex());
				comboBox_5.removeAllItems();
				// fillCourseSections(comboBox_5, comboBox_9.getSelectedIndex(),
				// comboBox_14.getSelectedIndex());

			}
		});
		lblUpdateSection.setForeground(Color.WHITE);
		lblUpdateSection.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateSection.setBounds(133, 266, 172, 35);
		manageSections.add(lblUpdateSection);
		viewDetails(new User("A", "B", new Date(1, 2, 3), "C", "D", "E", 'M', "F", "G"));

		manageStudents = new JPanel();
		manageStudents.setBounds(249, 152, 704, 442);
		contentPane.add(manageStudents);
		manageStudents.setLayout(null);
		manageStudents.setPreferredSize(new Dimension(704, 430));
		manageStudents.setForeground(Color.WHITE);
		manageStudents.setBackground(Color.BLACK);

		JLabel lblRegisterStudent = new JLabel("Register Student");
		lblRegisterStudent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblRegisterStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblRegisterStudent.setForeground(Color.WHITE);
		lblRegisterStudent.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRegisterStudent.setBounds(133, 90, 158, 35);
		manageStudents.add(lblRegisterStudent);

		JLabel lblRemoveStudent = new JLabel("Remove Student");
		lblRemoveStudent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblRemoveStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

				if (scrollPane_3.isVisible())
					scrollPane_3.setVisible(false);
				if (btnRemove_1.isVisible())
					btnRemove_1.setVisible(false);
			}
		});
		lblRemoveStudent.setForeground(Color.WHITE);
		lblRemoveStudent.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRemoveStudent.setBounds(133, 179, 172, 35);
		manageStudents.add(lblRemoveStudent);

		JLabel lblUpdateStudent = new JLabel("Update Student");
		lblUpdateStudent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblUpdateStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblUpdateStudent.setForeground(Color.WHITE);
		lblUpdateStudent.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateStudent.setBounds(133, 266, 172, 35);
		manageStudents.add(lblUpdateStudent);

		manageFaculty = new JPanel();
		manageFaculty.setBounds(249, 152, 704, 442);
		contentPane.add(manageFaculty);
		manageFaculty.setLayout(null);
		manageFaculty.setPreferredSize(new Dimension(704, 430));
		manageFaculty.setForeground(Color.WHITE);
		manageFaculty.setBackground(Color.BLACK);

		JLabel lblRegisterFaculty = new JLabel("Register Faculty");
		lblRegisterFaculty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblRegisterFaculty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblRegisterFaculty.setForeground(Color.WHITE);
		lblRegisterFaculty.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRegisterFaculty.setBounds(133, 90, 158, 35);
		manageFaculty.add(lblRegisterFaculty);

		JLabel lblRemoveFaculty = new JLabel("Remove Faculty");
		lblRemoveFaculty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblRemoveFaculty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblRemoveFaculty.setForeground(Color.WHITE);
		lblRemoveFaculty.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRemoveFaculty.setBounds(133, 179, 172, 35);
		manageFaculty.add(lblRemoveFaculty);

		JLabel lblUpdateFaculty = new JLabel("Update Faculty");
		lblUpdateFaculty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblUpdateFaculty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblUpdateFaculty.setForeground(Color.WHITE);
		lblUpdateFaculty.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUpdateFaculty.setBounds(133, 266, 172, 35);
		manageFaculty.add(lblUpdateFaculty);

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
		lblHome.setIcon(new ImageIcon(AMFrame.class.getResource("/images/home.png")));
		lblHome.setBounds(12, 15, 56, 57);
		topPanel.add(lblHome);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(AMFrame.class.getResource("/images/settings2.png")));
		label_5.setBounds(12, 85, 56, 59);
		topPanel.add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(AMFrame.class.getResource("/images/school.png")));
		label_6.setBounds(362, 0, 258, 152);
		topPanel.add(label_6);

		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36, 47, 65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);

		JLabel lblManageFaculty = new JLabel("Manage Faculty");
		lblManageFaculty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblManageFaculty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageFaculty.setForeground(Color.WHITE);
		lblManageFaculty.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageFaculty.setBounds(55, 111, 182, 27);

		sidePanel.add(lblManageFaculty);

		JLabel lblManageStudents = new JLabel("Manage Students");
		lblManageStudents.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblManageStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageStudents.setForeground(Color.WHITE);
		lblManageStudents.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageStudents.setBounds(55, 163, 182, 27);
		sidePanel.add(lblManageStudents);

		JLabel lblManageSections = new JLabel("Manage Sections");
		lblManageSections.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblManageSections.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());

			}
		});
		lblManageSections.setForeground(Color.WHITE);
		lblManageSections.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageSections.setBounds(55, 217, 182, 22);
		sidePanel.add(lblManageSections);

		JLabel lblManageCourses = new JLabel("Manage Courses");
		lblManageCourses.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblManageCourses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageCourses.setForeground(Color.WHITE);
		lblManageCourses.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageCourses.setBounds(55, 269, 182, 27);
		sidePanel.add(lblManageCourses);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AMFrame.class.getResource("/images/student.png")));
		label_1.setBounds(10, 163, 33, 32);
		sidePanel.add(label_1);

		JLabel label = new JLabel("");
		label.setBounds(11, 111, 33, 32);
		sidePanel.add(label);
		label.setIcon(new ImageIcon(AMFrame.class.getResource("/images/faculty.png")));

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(AMFrame.class.getResource("/images/course2.png")));
		label_3.setBounds(10, 269, 40, 32);
		sidePanel.add(label_3);

		JLabel lblLogout = new JLabel("");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Session.getInst().logout();
				frame.setVisible(false);
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
			}
		});
		lblLogout.setBounds(93, 363, 56, 54);
		sidePanel.add(lblLogout);
		lblLogout.setIcon(new ImageIcon(AMFrame.class.getResource("/images/logout.png")));

		JLabel lblAcademicManager = new JLabel("Academic Manager");
		lblAcademicManager.setForeground(Color.WHITE);
		lblAcademicManager.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAcademicManager.setBounds(28, 0, 211, 32);
		sidePanel.add(lblAcademicManager);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AMFrame.class.getResource("/images/section2.png")));
		label_2.setBounds(10, 217, 33, 27);
		sidePanel.add(label_2);

		JLabel lblManageSchools = new JLabel("Manage Schools");
		lblManageSchools.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblManageSchools.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageSchools.setForeground(Color.WHITE);
		lblManageSchools.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageSchools.setBounds(55, 325, 182, 22);
		sidePanel.add(lblManageSchools);

		JLabel label_89 = new JLabel("");
		label_89.setIcon(new ImageIcon(AMFrame.class.getResource("/images/registration.png")));
		label_89.setBounds(10, 325, 33, 27);
		sidePanel.add(label_89);

		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(AMFrame.class.getResource("/images/registration.png")));
		label_14.setBounds(10, 61, 33, 27);
		sidePanel.add(label_14);

		JLabel lblManageRegistrations = new JLabel("Manage Registrations");
		lblManageRegistrations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel evlbl = (JLabel) e.getComponent();
				showPanel(evlbl.getText());
			}
		});
		lblManageRegistrations.setForeground(Color.WHITE);
		lblManageRegistrations.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblManageRegistrations.setBounds(55, 61, 182, 22);
		sidePanel.add(lblManageRegistrations);

		addContainers();

		for (int i = 1; i < containers.size(); i++) {
			containers.get(i).setVisible(false);
		}

	}

	void addContainers() {
		containers.add(home);
		containers.add(manageCourses);
		containers.add(manageStudents);
		containers.add(manageFaculty);
		containers.add(manageSections);
		containers.add(manageSchools);

		containers.add(registerStudent);
		containers.add(updateStudent);
		containers.add(removeStudent);

		containers.add(registerFaculty);
		containers.add(addCourse);
		containers.add(removeCourse);
		containers.add(updateCourse);

		containers.add(updateSection);
		containers.add(removeSection);

		containers.add(updateSchool);
		containers.add(addSection);
		containers.add(addCourse);
		containers.add(addSchool);
		containers.add(removeFaculty);
		containers.add(updateFaculty);
		containers.add(manageRegistrations);

	}

	public void viewDetails(User user) {
		// home.setVisible(false);
		home.setVisible(true);
	}

	public void fillSchools(JComboBox combo) {
		combo.removeAllItems();
		ArrayList<School> schools = Session.getInst().getSchools();
		for (int i = 0; i < schools.size(); i++) {
			combo.addItem(schools.get(i).getId());
		}
	}

	public void fillCourseCodes(JComboBox combo, int index) {
		combo.removeAllItems();
		School school = Session.getInst().getSchools().get(index);
		ArrayList<Course> courses = school.getCurrentSemCourses();
		for (int i = 0; i < courses.size(); i++) {
			combo.addItem(courses.get(i).getCourseCode());
		}
	}

	public void fillCourseSections(JComboBox combo, int index1, int index2) {
		combo.removeAllItems();
		School school = Session.getInst().getSchools().get(index1);
		ArrayList<CourseSection> sections = school.getCurrentSemCourses().get(index2).getCurrentSemCourseSecitons();
		for (int i = 0; i < sections.size(); i++) {
			combo.addItem(sections.get(i).getSectionID());
		}
	}

	// isteacherteachingincurrentsem. if false then replacement null

	public void fillFaculty(JComboBox combo, int index) {
		combo.removeAllItems();
		School school = Session.getInst().getSchools().get(index);
		ArrayList<FacultyMember> faculty = school.getFaculty();
		for (int i = 0; i < faculty.size(); i++) {
			combo.addItem(faculty.get(i).getEmpID());
		}
	}

	public void fillPreReqs(String schoolID) {
		listModel3.removeAllElements();
		ArrayList<Course> courses = Session.getInst().getSchool(schoolID).getCourses();
		System.out.println(schoolID);
		for (int i = 0; i < courses.size(); i++) {
			listModel3.addElement(courses.get(i).getCourseCode());
		}
	}
}
