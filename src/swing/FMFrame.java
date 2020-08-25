package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import backend.*;

import javax.swing.ScrollPaneConstants;
import java.awt.Point;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FMFrame extends JFrame {

	private FMFrame frame;
	private JPanel contentPane;
	private JTextField txtl;
	private JTextField textField;
	private JScrollPane manageFee;
	private JScrollPane managePay;
	private ArrayList<Container> containers;
	private JPanel home;
	private JTextField txtEnterDate;
	private JTextField txtEnterAmount;
	private JButton btnPay;
	private JButton button_4;
	private JTable table2;
	private DefaultTableModel dtm;
	private JTable table3;
	private DefaultTableModel dtm2;
	private ArrayList<JTextField> datesPaid;
	private Staff staff = null;
	private JLabel errorMsg = new JLabel();
	private JLabel errorMsgStd = new JLabel();
	private ArrayList<Component> addedComps = new ArrayList<Component>();
	int feeY = 214;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMFrame frame = new FMFrame();
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
		if (a.equals("Manage Fees")) {
			containers.get(1).setVisible(true);
		}
		if (a.equals("Manage Pays")) {
			containers.get(2).setVisible(true);
		}

	}

	/**
	 * Create the frame.
	 */
	public FMFrame() {

		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		containers = new ArrayList<Container>();

		managePay = new JScrollPane();
		managePay.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(managePay);
		managePay.setBackground(Color.BLACK);
		managePay.setBounds(249, 152, 704, 442);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(249, 152, 704, 442);
		managePay.setViewportView(panel_2);
		panel_2.setPreferredSize(new Dimension(704, 550));
		panel_2.setLayout(null);

		JLabel lblProfile = new JLabel("Pay Management");
		lblProfile.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setBounds(33, 11, 212, 35);
		panel_2.add(lblProfile);

		JSeparator separator = new JSeparator();
		separator.setBounds(23, 44, 197, 2);
		panel_2.add(separator);

		txtl = new JTextField();
		txtl.setText("1234");
		txtl.setForeground(Color.WHITE);
		txtl.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtl.setColumns(10);
		txtl.setBorder(null);
		txtl.setBackground(new Color(36, 47, 65));
		txtl.setBounds(238, 73, 198, 20);
		panel_2.add(txtl);

		JLabel lblSchool = new JLabel("Employee ID");
		lblSchool.setForeground(Color.WHITE);
		lblSchool.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSchool.setBounds(133, 69, 95, 27);
		panel_2.add(lblSchool);

		txtEnterDate = new JTextField();
		txtEnterDate.setText("Enter Date");
		txtEnterDate.setForeground(Color.WHITE);
		txtEnterDate.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtEnterDate.setBounds(179, 143, 116, 22);
		txtEnterDate.setBackground(new Color(36, 47, 65));
		txtEnterDate.setBorder(null);
		panel_2.add(txtEnterDate);
		txtEnterDate.setColumns(10);

		txtEnterAmount = new JTextField();
		txtEnterAmount.setText("Enter Amount");
		txtEnterAmount.setBounds(338, 143, 116, 22);
		txtEnterAmount.setForeground(Color.WHITE);
		txtEnterAmount.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtEnterAmount.setBackground(new Color(36, 47, 65));
		txtEnterAmount.setBorder(null);
		panel_2.add(txtEnterAmount);
		txtEnterAmount.setColumns(10);
		txtEnterAmount.setVisible(false);
		txtEnterDate.setVisible(false);

		errorMsg.setBounds(238, 93, 198, 20);
		errorMsg.setForeground(Color.WHITE);
		panel_2.add(errorMsg);
		
		

		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				errorMsg.setText("");

				// System.out.println("HAHAAH");

				staff = Session.getInst().getStaff(txtl.getText());// returns not null;
				if (staff == null) {
					errorMsg.setText("Invalid ID");
					return;
				}

				txtEnterAmount.setVisible(true);
				txtEnterDate.setVisible(true);

				btnPay = new JButton("Pay");
				btnPay.setBounds(479, 142, 97, 25);
				panel_2.add(btnPay);

				String[] columnNames = { "Emp ID", "Name", "DOB" };

				String[] columnNames2 = { "Name", "Amount", "Date Paid" };

				JTable table2 = new JTable();

				if (dtm == null) {
					dtm = new DefaultTableModel(0, 0);
					dtm.setColumnIdentifiers(columnNames);
					table2.setModel(dtm);

					JScrollPane scrollPane_3 = new JScrollPane(table2);
					scrollPane_3.setForeground(Color.WHITE);
					scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
					scrollPane_3.setBackground(Color.WHITE);
					scrollPane_3.setAlignmentX(0.0f);
					scrollPane_3.setBounds(200, 200, 279, 40);
					panel_2.add(scrollPane_3);
				} else {
					if (dtm.getRowCount() > 0) {
						for (int i = dtm.getRowCount() - 1; i > -1; i--) {
							dtm.removeRow(i);
						}
					}

				}
				dtm.addRow(new Object[] { staff.getEmpID(), staff.getName(), staff.getDOB() });
				// dtm.addRow(new Object[] { "23","Blah","2017" });

				ArrayList<Pay> pays = Session.getAccountsDept().getPays(staff.getEmpID());

				if (dtm2 == null) {
					table3 = new JTable();
					dtm2 = new DefaultTableModel(0, 0);
					dtm2.setColumnIdentifiers(columnNames2);
					table3.setModel(dtm2);

					JScrollPane scrollPane_4 = new JScrollPane(table3);
					scrollPane_4.setForeground(Color.WHITE);
					scrollPane_4.setFont(new Font("Century Gothic", Font.PLAIN, 13));
					scrollPane_4.setBackground(Color.WHITE);
					scrollPane_4.setAlignmentX(0.0f);
					scrollPane_4.setBounds(200, 300, 279, 100);
					panel_2.add(scrollPane_4);
				} else {
					if (dtm2.getRowCount() > 0) {
						for (int i = dtm2.getRowCount() - 1; i > -1; i--) {
							dtm2.removeRow(i);
						}
					}
				}

				for (int i = 0; i < pays.size(); i++) {
					dtm2.addRow(new Object[] { pays.get(i).getStaffMember().getName(), pays.get(i).getDatePaid(),
							pays.get(i).getAmount() });
				}

				btnPay.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						errorMsg.setText("");
						try {
							double amount = Double.parseDouble(txtEnterAmount.getText());
							if(amount<0)
								amount = 1/0;
							String datePaid = txtEnterDate.getText();
							// System.out.println("HAHAAH");

							((FinanceManager) Session.getUser()).payStaff(staff.getEmpID(), datePaid, amount);
						} catch (Exception exception) {
							errorMsg.setText("Invalid Date or Amount");
						}
						// removing all rows
						if (dtm2.getRowCount() > 0) {
							for (int i = dtm2.getRowCount() - 1; i > -1; i--) {
								dtm2.removeRow(i);
							}
						}

						ArrayList<Pay> paysNew = Session.getAccountsDept().getPays(staff.getEmpID());

						for (int i = 0; i < paysNew.size(); i++) {
							dtm2.addRow(new Object[] { paysNew.get(i).getStaffMember().getName(),
									paysNew.get(i).getDatePaid(), paysNew.get(i).getAmount() });
						}

					}
				});

				panel_2.repaint();

			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setForeground(UIManager.getColor("Button.foreground"));
		btnSearch.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnSearch.setBackground(UIManager.getColor("Button.background"));
		btnSearch.setBounds(446, 71, 130, 23);
		panel_2.add(btnSearch);

		manageFee = new JScrollPane();
		manageFee.setBounds(249, 152, 704, 442);
		contentPane.add(manageFee);
		manageFee.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		manageFee.setBackground(Color.BLACK);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(704, 550));
		panel.setBackground(Color.BLACK);
		manageFee.setViewportView(panel);

		JLabel label_14 = new JLabel("Fee Management");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_14.setBounds(33, 11, 212, 35);
		panel.add(label_14);

		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(23, 44, 197, 2);
		panel.add(separator_10);

		textField = new JTextField();
		textField.setText("15L-1234");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(36, 47, 65));
		textField.setBounds(227, 63, 198, 20);
		panel.add(textField);

		JLabel label_15 = new JLabel("Roll Number");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_15.setBounds(130, 59, 87, 27);
		panel.add(label_15);

		JLabel label_16 = new JLabel("Amount");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_16.setBounds(207, 194, 57, 27);
		panel.add(label_16);
		label_16.setVisible(false);

		JLabel label_17 = new JLabel("DatePaid");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_17.setBounds(316, 194, 68, 27);
		panel.add(label_17);
		label_17.setVisible(false);

		JLabel label_18 = new JLabel("DueDate");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_18.setBounds(427, 194, 68, 27);
		panel.add(label_18);
		label_18.setVisible(false);

		JLabel label_19 = new JLabel("Semester");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_19.setBounds(87, 194, 68, 27);
		panel.add(label_19);
		label_19.setVisible(false);
		
		errorMsgStd.setBounds(238, 143, 198, 20);
		panel.add(errorMsgStd);

		JButton button_3 = new JButton("Search");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMsgStd.setText("");
				 Student student = Session.getInst().getStudent(textField.getText());
				 if (student == null) {
					 errorMsgStd.setText("Invalid Student Roll Number");
					 return;
				 }
				 
				 for(Component comp:addedComps) {
					 panel.remove(comp);
				 }
				 addedComps.clear();
				 
				String[] columnNames = { "Roll Number", "Name", "DOB" };
				
				if(table2==null) {
					table2 = new JTable();
					dtm = new DefaultTableModel(0, 0);
					dtm.setColumnIdentifiers(columnNames);
					table2.setModel(dtm);
	
					JScrollPane scrollPane_3 = new JScrollPane(table2);
					scrollPane_3.setForeground(Color.WHITE);
					scrollPane_3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
					scrollPane_3.setBackground(Color.WHITE);
					scrollPane_3.setAlignmentX(0.0f);
					scrollPane_3.setBounds(200, 100, 279, 40);
					panel.add(scrollPane_3);
				}
				else {
					if (dtm.getRowCount() > 0) {
						for (int i = dtm.getRowCount() - 1; i > -1; i--) {
							dtm.removeRow(i);
						}
					}
				}

				//dtm.addRow(new Object[] { "23", "Blah", "2017" });
				dtm.addRow(new Object[] { student.getRollNo(), student.getName(), student.getDOB()});
				label_16.setVisible(true);
				label_17.setVisible(true);
				label_18.setVisible(true);
				label_19.setVisible(true);

				String rollNum = (String) dtm.getValueAt(0, 0);
				ArrayList<Fee> fees = ((FinanceManager)Session.getUser()).getFees(rollNum);
				datesPaid = new ArrayList<JTextField>();
				
				feeY=214;
				if(fees==null) {
					panel.remove(button_4);
					button_4=null;
					panel.repaint();
					panel.revalidate();
					return;
				}
					
				for (Fee stFee:fees) {
					feeY += 30;
					JLabel label = new JLabel(stFee.getSemester().getSession());
					label.setBounds(87, feeY, 68, 27);
					// fees.get(i).getAmount();

					JLabel label2 = new JLabel(Double.toString(stFee.getAmount()));
					label2.setBounds(207, feeY, 68, 27);
					
					JTextField textField;
					if(stFee.getDatePaid()!=null) {
						DateFormat df = new SimpleDateFormat(stFee.getDatePaid().toString());
						String date = df.format(new Date(1, 2, 3));
						 textField = new JTextField(date);
						textField.setBounds(316, feeY, 68, 27);
						datesPaid.add(textField);
					}
					else {
						 textField = new JTextField("");
						textField.setBounds(316, feeY, 68, 27);
						datesPaid.add(textField);
					}
					

					DateFormat df2 = new SimpleDateFormat(stFee.getDueDate().toString());
					String date2 = df2.format(new Date(1, 2, 3));
					JLabel label3 = new JLabel(date2);
					label3.setBounds(427, feeY, 68, 27);
					
					panel.add(label);
					panel.add(label2);
					panel.add(textField);
					panel.add(label3);
					
					addedComps.add(label);
					addedComps.add(label2);
					addedComps.add(textField);
					addedComps.add(label3);
					
					// JLabel label = new JLabel(fees.get(i).getSemester().getSession());
					// feeY+=20;
					// label.setBounds(87, feeY, 68, 27);
					// fees.get(i).getAmount();
					//
					//
					// JLabel label2 = new JLabel(fees.get(i).getSemester().getSession());
					// label.setBounds(207, feeY, 68, 27);
					//
					// panel.add(label);
					// panel.add(label2);
					//
					// DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					// String date = df.format(fees.get(i).getDatePaid());
					// JTextField textField = new JTextField(date);
					// textField.setBounds(316, feeY, 68, 27);
					//
					// DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
					// String date2 = df.format(fees.get(i).getDatePaid());
					// JTextField textField2 = new JTextField(date2);
					// textField2.setBounds(427, feeY, 68, 27);
				}
				
				if(button_4!=null)
					button_4.setBounds(528, feeY, 88, 27);
				else {
					button_4 = new JButton("Update");
					button_4.setBounds(528, feeY, 88, 27);
					button_4.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							errorMsgStd.setText("");
							try {
								for(int i=0;i<fees.size();i++) {
									String datePaid = datesPaid.get(i).getText();
									if(datePaid.length()==0)
										datePaid = null;
									
									 Semester semester = fees.get(i).getSemester();
									 ((FinanceManager)Session.getUser()).updateFee(rollNum, datePaid, semester.getSession());
								}
							}
							catch(Exception exception) {
								errorMsgStd.setText("Invalid Date Entered");
							}
							// 
							// dtm2.addRow(staff.getName(), datePaid, amount);
	
						}
					});
					panel.add(button_4);
				}
				
				panel.repaint();
				panel.revalidate();

			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		button_3.setBackground(SystemColor.menu);
		button_3.setBounds(435, 61, 130, 23);
		panel.add(button_3);

		home = new JPanel();
		home.setLayout(null);
		home.setBackground(Color.BLACK);
		home.setBounds(249, 152, 704, 442);
		contentPane.add(home);

		JLabel label_2 = new JLabel("UserImage");
		label_2.setIcon(new ImageIcon(FMFrame.class.getResource("/images/user2.png")));
		label_2.setBounds(54, 71, 99, 152);
		home.add(label_2);

		JLabel label_3 = new JLabel("Profile");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBounds(69, 25, 93, 16);
		home.add(label_3);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(70, 50, 61, 2);
		home.add(separator_1);

		viewDetails(Session.getUser());

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
		lblHome.setIcon(new ImageIcon(FMFrame.class.getResource("/images/home.png")));
		lblHome.setBounds(12, 15, 56, 57);
		topPanel.add(lblHome);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(FMFrame.class.getResource("/images/settings2.png")));
		label_5.setBounds(12, 85, 56, 59);
		topPanel.add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(FMFrame.class.getResource("/images/school.png")));
		label_6.setBounds(362, 0, 258, 152);
		topPanel.add(label_6);

		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 152, 250, 442);
		sidePanel.setBackground(new Color(36, 47, 65));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);

		JLabel lblManageFaculty = new JLabel("Manage Pays");
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
		lblManageFaculty.setBounds(57, 103, 182, 27);

		sidePanel.add(lblManageFaculty);

		JLabel lblManageStudents = new JLabel("Manage Fees");
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
		lblManageStudents.setBounds(57, 158, 182, 27);
		sidePanel.add(lblManageStudents);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FMFrame.class.getResource("/images/student.png")));
		label_1.setBounds(12, 153, 33, 32);
		sidePanel.add(label_1);

		JLabel label = new JLabel("");
		label.setBounds(12, 103, 33, 32);
		sidePanel.add(label);
		label.setIcon(new ImageIcon(FMFrame.class.getResource("/images/faculty.png")));

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
		lblLogout.setIcon(new ImageIcon(FMFrame.class.getResource("/images/logout.png")));

		JLabel lblAcademicManager = new JLabel("Finance Manager");
		lblAcademicManager.setForeground(Color.WHITE);
		lblAcademicManager.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAcademicManager.setBounds(27, 26, 211, 32);
		sidePanel.add(lblAcademicManager);

		addContainers();

		for (int i = 1; i < containers.size(); i++) {
			containers.get(i).setVisible(false);
		}

	}

	public void addContainers() {
		containers.add(home);
		containers.add(manageFee);
		containers.add(managePay);
	}

	public void viewDetails(User user) {
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
		// home.setVisible(false);
		home.setVisible(true);
	}
}
