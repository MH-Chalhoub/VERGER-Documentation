package verger;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import try_it.Excel_to_table;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.JProgressBar;
import javax.swing.SpinnerNumberModel;

public class Main_panel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_depence;
	private static DefaultTableModel m;
	private static DefaultTableModel m1;
	private static DefaultTableModel m2;
	private static DefaultTableModel m3;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTable table_entree;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTable table_facture;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTable table_employee_1;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTable table_verger;
	private JTable table_employee_2;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JCheckBox chckbxJm;
	private static DBHandlerVerger dbh;
	private JButton btnSubmit;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTable table;
	private JTable table_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
			//UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_panel frame = new Main_panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "serial" })
	public Main_panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 736);
		setTitle("Verger");
		dbh = new DBHandlerVerger();
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////logo///////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		ImageIcon depence_logo = new ImageIcon(new 
				ImageIcon("C:\\Users\\Chalhoub\\eclipse-workspace\\lab\\assets\\depence.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		ImageIcon entree_logo = new ImageIcon(new 
				ImageIcon("C:\\Users\\Chalhoub\\eclipse-workspace\\lab\\assets\\entree.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		ImageIcon facture_logo = new ImageIcon(new 
				ImageIcon("C:\\Users\\Chalhoub\\eclipse-workspace\\lab\\assets\\facture.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		ImageIcon employe_logo = new ImageIcon(new 
				ImageIcon("C:\\Users\\Chalhoub\\eclipse-workspace\\lab\\assets\\employe.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		ImageIcon verger_logo = new ImageIcon(new 
				ImageIcon("C:\\Users\\Chalhoub\\eclipse-workspace\\lab\\assets\\verger.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("Create");
		mnFile.add(mnNew);
		
		JMenuItem mntmExcelFromDepence = new JMenuItem("Excel From Dépence");
		mntmExcelFromDepence.setIcon(depence_logo);
		mnNew.add(mntmExcelFromDepence);
		
		JMenuItem mntmExcelFromEntrer = new JMenuItem("Excel From Entreé");
		mntmExcelFromEntrer.setIcon(entree_logo);
		mnNew.add(mntmExcelFromEntrer);
		
		JMenuItem mntmExcelFromFacture = new JMenuItem("Excel From Facture du Marché");
		mntmExcelFromFacture.setIcon(facture_logo);
		mnNew.add(mntmExcelFromFacture);
		
		JMenuItem mntmExcelFromTravailleur = new JMenuItem("Excel From Travailleur");
		mntmExcelFromTravailleur.setIcon(employe_logo);
		mnNew.add(mntmExcelFromTravailleur);
		
		JMenuItem mntmExcelFromVerger = new JMenuItem("Excel From Verger");
		mntmExcelFromVerger.setIcon(verger_logo);
		mnNew.add(mntmExcelFromVerger);
		
		JMenuItem mnSave = new JMenuItem("Save");
		mnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] s1 = getRowAt(0,7,m);
				JFrame fen = new JFrame("");
				JOptionPane.showMessageDialog(fen, s1[0], "Welcome", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnFile.add(mnSave);
		
		JMenuItem mnOpen = new JMenuItem("Open...");
		mnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Excel_to_table_verger frame = new Excel_to_table_verger();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mnOpen);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		
		JPanel depences = new JPanel();
		tabbedPane.addTab("Dépences", depence_logo, depences, "les dépences du travaille");
		depences.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_depence = new JTabbedPane(JTabbedPane.TOP);
		depences.add(tabbedPane_depence, BorderLayout.CENTER);
		
		JPanel depence_add = new JPanel();
		tabbedPane_depence.addTab("ADD", null, depence_add, null);
		depence_add.setLayout(new BorderLayout(0, 0));
		
		m = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				if (col == 0) {		//set Column 1 uneditable
					return false;
					}
				else {
					return true;
					}       
				}
		};
		
		String[] entete = {"Id", "Date", "Payé pour", "Article", "Montant", "Machine", "Location", "Notes"};
		m.setColumnIdentifiers(entete);
//		String[] line = {"111", "", "", "", "", "", ""};
//		for (int i=0;i<100;i++) {
//			m.addRow(line);
//		}
		
		refresh_depence();
		
		table_depence = new JTable(m);
		table_depence.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				btnSubmit.setEnabled(false);
			}
			@Override
			public void focusLost(FocusEvent e) {
				btnSubmit.setEnabled(true);
				
			}
		});
		table_depence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText((String) m.getValueAt(table_depence.getSelectedRow(), 1));
				textField_1.setText((String) m.getValueAt(table_depence.getSelectedRow(), 2));
				textField_2.setText((String) m.getValueAt(table_depence.getSelectedRow(), 3));
				textField_3.setText((String) m.getValueAt(table_depence.getSelectedRow(), 4));
				textField_4.setText((String) m.getValueAt(table_depence.getSelectedRow(), 5));
				textField_5.setText((String) m.getValueAt(table_depence.getSelectedRow(), 6));
				textField_6.setText((String) m.getValueAt(table_depence.getSelectedRow(), 7));
				
				//JFrame fen = new JFrame();
				//JOptionPane.showMessageDialog(fen, table_depence.getSelectedRow() + "", "Welcome", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		table_depence.setShowGrid(true);
		JScrollPane scrollPane_depence = new JScrollPane(table_depence);
		depence_add.add(scrollPane_depence, BorderLayout.CENTER);
		
		JPanel panel_depece = new JPanel();
		depence_add.add(panel_depece, BorderLayout.WEST);
		panel_depece.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel panel_depece_date = new JPanel();
		panel_depece.add(panel_depece_date);
		panel_depece_date.setLayout(new BoxLayout(panel_depece_date, BoxLayout.X_AXIS));
		
		JPanel panel_depece_date_1 = new JPanel();
		FlowLayout fl_panel_depece_date_1 = (FlowLayout) panel_depece_date_1.getLayout();
		fl_panel_depece_date_1.setAlignment(FlowLayout.LEFT);
		panel_depece_date.add(panel_depece_date_1);
		
		JLabel label = new JLabel("Date:");
		panel_depece_date_1.add(label);
		
		JPanel panel_depece_date_2 = new JPanel();
		FlowLayout fl_panel_depece_date_2 = (FlowLayout) panel_depece_date_2.getLayout();
		fl_panel_depece_date_2.setAlignment(FlowLayout.RIGHT);
		panel_depece_date.add(panel_depece_date_2);
		
		textField = new JTextField();
		
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		textField.setText(date);
		
		textField.setColumns(30);
		panel_depece_date_2.add(textField);
		
		JPanel panel_depece_pour = new JPanel();
		panel_depece.add(panel_depece_pour);
		panel_depece_pour.setLayout(new BoxLayout(panel_depece_pour, BoxLayout.X_AXIS));
		
		JPanel panel_depece_pour_1 = new JPanel();
		FlowLayout fl_panel_depece_pour_1 = (FlowLayout) panel_depece_pour_1.getLayout();
		fl_panel_depece_pour_1.setAlignment(FlowLayout.LEFT);
		panel_depece_pour.add(panel_depece_pour_1);
		
		JLabel label_1 = new JLabel("Pour:");
		panel_depece_pour_1.add(label_1);
		
		JPanel panel_depece_pour_2 = new JPanel();
		FlowLayout fl_panel_depece_pour_2 = (FlowLayout) panel_depece_pour_2.getLayout();
		fl_panel_depece_pour_2.setAlignment(FlowLayout.RIGHT);
		panel_depece_pour.add(panel_depece_pour_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(30);
		panel_depece_pour_2.add(textField_1);
		
		JPanel panel_depece_article = new JPanel();
		panel_depece.add(panel_depece_article);
		panel_depece_article.setLayout(new BoxLayout(panel_depece_article, BoxLayout.X_AXIS));
		
		JPanel panel_depece_article_1 = new JPanel();
		FlowLayout fl_panel_depece_article_1 = (FlowLayout) panel_depece_article_1.getLayout();
		fl_panel_depece_article_1.setAlignment(FlowLayout.LEFT);
		panel_depece_article.add(panel_depece_article_1);
		
		JLabel label_2 = new JLabel("Article:");
		panel_depece_article_1.add(label_2);
		
		JPanel panel_depece_article_2 = new JPanel();
		FlowLayout fl_panel_depece_article_2 = (FlowLayout) panel_depece_article_2.getLayout();
		fl_panel_depece_article_2.setAlignment(FlowLayout.RIGHT);
		panel_depece_article.add(panel_depece_article_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(30);
		panel_depece_article_2.add(textField_2);
		
		JPanel panel_depece_montant = new JPanel();
		panel_depece.add(panel_depece_montant);
		panel_depece_montant.setLayout(new BoxLayout(panel_depece_montant, BoxLayout.X_AXIS));
		
		JPanel panel_depece_montant_1 = new JPanel();
		FlowLayout fl_panel_depece_montant_1 = (FlowLayout) panel_depece_montant_1.getLayout();
		fl_panel_depece_montant_1.setAlignment(FlowLayout.LEFT);
		panel_depece_montant.add(panel_depece_montant_1);
		
		JLabel label_3 = new JLabel("Montant:");
		panel_depece_montant_1.add(label_3);
		
		JPanel panel_depece_montant_2 = new JPanel();
		FlowLayout fl_panel_depece_montant_2 = (FlowLayout) panel_depece_montant_2.getLayout();
		fl_panel_depece_montant_2.setAlignment(FlowLayout.RIGHT);
		panel_depece_montant.add(panel_depece_montant_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(30);
		panel_depece_montant_2.add(textField_3);
		
		JPanel panel_depece_machine = new JPanel();
		panel_depece.add(panel_depece_machine);
		panel_depece_machine.setLayout(new BoxLayout(panel_depece_machine, BoxLayout.X_AXIS));
		
		JPanel panel_depece_machine_1 = new JPanel();
		FlowLayout fl_panel_depece_machine_1 = (FlowLayout) panel_depece_machine_1.getLayout();
		fl_panel_depece_machine_1.setAlignment(FlowLayout.LEFT);
		panel_depece_machine.add(panel_depece_machine_1);
		
		JLabel label_4 = new JLabel("Machine:");
		panel_depece_machine_1.add(label_4);
		
		JPanel panel_depece_machine_2 = new JPanel();
		panel_depece_machine.add(panel_depece_machine_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(30);
		panel_depece_machine_2.add(textField_4);
		
		JPanel panel_depece_location = new JPanel();
		panel_depece.add(panel_depece_location);
		panel_depece_location.setLayout(new BoxLayout(panel_depece_location, BoxLayout.X_AXIS));
		
		JPanel panel_depece_location_1 = new JPanel();
		FlowLayout fl_panel_depece_location_1 = (FlowLayout) panel_depece_location_1.getLayout();
		fl_panel_depece_location_1.setAlignment(FlowLayout.LEFT);
		panel_depece_location.add(panel_depece_location_1);
		
		JLabel label_5 = new JLabel("Location:");
		panel_depece_location_1.add(label_5);
		
		JPanel panel_depece_location_2 = new JPanel();
		FlowLayout fl_panel_depece_location_2 = (FlowLayout) panel_depece_location_2.getLayout();
		fl_panel_depece_location_2.setAlignment(FlowLayout.RIGHT);
		panel_depece_location.add(panel_depece_location_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(30);
		panel_depece_location_2.add(textField_5);
		
		JPanel panel_depece_notes = new JPanel();
		panel_depece.add(panel_depece_notes);
		panel_depece_notes.setLayout(new BoxLayout(panel_depece_notes, BoxLayout.X_AXIS));
		
		JPanel panel_depece_notes_1 = new JPanel();
		FlowLayout fl_panel_depece_notes_1 = (FlowLayout) panel_depece_notes_1.getLayout();
		fl_panel_depece_notes_1.setAlignment(FlowLayout.LEFT);
		panel_depece_notes.add(panel_depece_notes_1);
		
		JLabel label_6 = new JLabel("Notes:");
		panel_depece_notes_1.add(label_6);
		
		JPanel panel_depece_notes_2 = new JPanel();
		FlowLayout fl_panel_depece_notes_2 = (FlowLayout) panel_depece_notes_2.getLayout();
		fl_panel_depece_notes_2.setAlignment(FlowLayout.RIGHT);
		panel_depece_notes.add(panel_depece_notes_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(30);
		panel_depece_notes_2.add(textField_6);
		
		JPanel panel_depece_submit = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_depece_submit.getLayout();
		flowLayout.setHgap(40);
		panel_depece.add(panel_depece_submit);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String date = textField.getText();
				String paye_pour = textField_1.getText();
				String article = textField_2.getText();
				float montant = 0;
				try {
					montant = Float.parseFloat(textField_3.getText());
				} catch (Exception e) {
				}
				String machine = textField_4.getText();
				String location = textField_5.getText();
				String note = textField_6.getText();
				Depence d = new Depence(location, date, paye_pour, article, montant, machine, note);
				try {
					dbh.addDepence(d);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				refresh_depence();
			}
		});
		panel_depece_submit.add(btnSubmit);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String date = textField.getText();
				String paye_pour = textField_1.getText();
				String article = textField_2.getText();
				float montant = 0;
				try {
					montant = Float.parseFloat(textField_3.getText());
				} catch (Exception e) {
				}
				String machine = textField_4.getText();
				String location = textField_5.getText();
				String note = textField_6.getText();
				Depence d = new Depence(location, date, paye_pour, article, montant, machine, note);
				try {
					dbh.updateDepence(Integer.parseInt((String) m.getValueAt(table_depence.getSelectedRow(), 0)), d);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				refresh_depence();
			}
		});
               		panel_depece_submit.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dbh.suppDepence(Integer.parseInt((String) m.getValueAt(table_depence.getSelectedRow(), 0)));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				textField.requestFocus();
				refresh_depence();
			}
		});
		panel_depece_submit.add(btnDelete);
		
		JPanel depence_total = new JPanel();
		tabbedPane_depence.addTab("Total", null, depence_total, null);
		depence_total.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		depence_total.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		panel_1.setBorder(BorderFactory.createTitledBorder("Date de debut : "));
		panel.add(panel_1);
		
		JLabel lblYyyy = new JLabel("yyyy:");
		panel_1.add(lblYyyy);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(2000), new Integer(2000), null, new Integer(1)));
		spinner_2.setPreferredSize(new Dimension(60, 30));
		panel_1.add(spinner_2);
				
				JLabel lblMm = new JLabel("mm:");
				panel_1.add(lblMm);
				
				JSpinner spinner_1 = new JSpinner();
				spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
				spinner_1.setPreferredSize(new Dimension(60, 30));
				panel_1.add(spinner_1);
				
				JLabel lblDd = new JLabel("dd:");
				panel_1.add(lblDd);
		
				JSpinner spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
				spinner.setPreferredSize(new Dimension(60, 30));
				panel_1.add(spinner);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Date de Fin : "));
		panel.add(panel_2);
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int day = calendar.get(Calendar.DATE);
	    int month = calendar.get(Calendar.MONTH) + 1;
		
		JLabel label_9 = new JLabel("yyyy:");
		panel_2.add(label_9);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(new Integer(2019), new Integer(2000), null, new Integer(1)));
	    int year = calendar.get(Calendar.YEAR);
	    spinner_5.setValue(Integer.valueOf(year));
		spinner_5.setPreferredSize(new Dimension(60, 30));
		panel_2.add(spinner_5);
		
		JLabel label_8 = new JLabel("mm:");
		panel_2.add(label_8);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_4.setValue(Integer.valueOf(month));
		spinner_4.setPreferredSize(new Dimension(60, 30));
		panel_2.add(spinner_4);
		
		JLabel label_7 = new JLabel("dd:");
		panel_2.add(label_7);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(12, 1, 31, 1));
		spinner_3.setValue(Integer.valueOf(day));
		spinner_3.setPreferredSize(new Dimension(60, 30));
		panel_2.add(spinner_3);
		
		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setString("0 L.L");
		progressBar.setStringPainted(true);
		depence_total.add(progressBar, BorderLayout.EAST);
		
		JPanel panel_depence_check = new JPanel();
		depence_total.add(panel_depence_check, BorderLayout.SOUTH);
		panel_depence_check.setLayout(new BorderLayout(0, 0));
		
		JButton btnCheck = new JButton("CHECK");
		panel_depence_check.add(btnCheck);
		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int year_start = (Integer) spinner_2.getValue();
				int month_start = (Integer) spinner_1.getValue();
				int day_start = (Integer) spinner.getValue();

				int year_end = (Integer) spinner_5.getValue();
				int month_end = (Integer) spinner_4.getValue();
				int day_end = (Integer) spinner_3.getValue();
				//JOptionPane.showMessageDialog(null,year_start + "-" + month_start + "-" + day_start+ "//" +year_end + "-" + month_end + "-" + day_end);
				
				try {
					float total = dbh.getSumDepenceMontant(year_start + "-" + month_start + "-" + day_start, year_end + "-" + month_end + "-" + day_end);
					//JOptionPane.showMessageDialog(null,"total : " + total);
					int total_all = (int) dbh.getAllSumDepenceMontant();
					progressBar.setMaximum(total_all);
					progressBar.setValue((int) total);
					progressBar.setString(total + " L.L");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				refresh_from_to_depence(year_start + "-" + month_start + "-" + day_start, year_end + "-" + month_end + "-" + day_end);
			}
		});
		
		JButton btnCheckAll = new JButton("CHECK ALL");
		btnCheckAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float total_all = dbh.getAllSumDepenceMontant();
					progressBar.setMaximum((int) total_all);
					progressBar.setValue((int) total_all);
					progressBar.setString(total_all + " L.L");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				refresh_all_depence();
			}
		});
		panel_depence_check.add(btnCheckAll, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		depence_total.add(scrollPane, BorderLayout.CENTER);
		
		m3 = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				if (col == 0) {		//set Column 1 uneditable
					return false;
					}
				else {
					return true;
					}       
				}
		};
		
		m3.setColumnIdentifiers(entete);
		
		refresh_depence();
		
		table = new JTable(m3);
		scrollPane.setViewportView(table);
		
		JPanel entree = new JPanel();
		tabbedPane.addTab("Entrée", entree_logo, entree, null);
		entree.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_entree = new JTabbedPane(JTabbedPane.TOP);
		entree.add(tabbedPane_entree);
		
		JPanel entree_add = new JPanel();
		tabbedPane_entree.addTab("ADD", null, entree_add, null);
		entree_add.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_entree = new JScrollPane();
		entree_add.add(scrollPane_entree, BorderLayout.CENTER);
		
		table_entree = new JTable();
		scrollPane_entree.setViewportView(table_entree);
		
		JPanel panel_entree = new JPanel();
		entree_add.add(panel_entree, BorderLayout.WEST);
		panel_entree.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel panel_entree_date = new JPanel();
		panel_entree.add(panel_entree_date);
		panel_entree_date.setLayout(new BoxLayout(panel_entree_date, BoxLayout.X_AXIS));
		
		JPanel panel_entree_date_1 = new JPanel();
		FlowLayout fl_panel_entree_date_1 = (FlowLayout) panel_entree_date_1.getLayout();
		fl_panel_entree_date_1.setAlignment(FlowLayout.LEFT);
		panel_entree_date.add(panel_entree_date_1);
		
		JLabel lblNewLabel = new JLabel("Date:");
		panel_entree_date_1.add(lblNewLabel);
		
		JPanel panel_entree_date_2 = new JPanel();
		FlowLayout fl_panel_entree_date_2 = (FlowLayout) panel_entree_date_2.getLayout();
		fl_panel_entree_date_2.setAlignment(FlowLayout.RIGHT);
		panel_entree_date.add(panel_entree_date_2);
		
		textField_7 = new JTextField();
		panel_entree_date_2.add(textField_7);
		textField_7.setColumns(30);
		
		JPanel panel_entree_expediteur = new JPanel();
		panel_entree.add(panel_entree_expediteur);
		panel_entree_expediteur.setLayout(new BoxLayout(panel_entree_expediteur, BoxLayout.X_AXIS));
		
		JPanel panel_entree_expediteur_1 = new JPanel();
		FlowLayout fl_panel_entree_expediteur_1 = (FlowLayout) panel_entree_expediteur_1.getLayout();
		fl_panel_entree_expediteur_1.setAlignment(FlowLayout.LEFT);
		panel_entree_expediteur.add(panel_entree_expediteur_1);
		
		JLabel lblNewLabel_1 = new JLabel("Expediteur:");
		panel_entree_expediteur_1.add(lblNewLabel_1);
		
		JPanel panel_entree_expediteur_2 = new JPanel();
		FlowLayout fl_panel_entree_expediteur_2 = (FlowLayout) panel_entree_expediteur_2.getLayout();
		fl_panel_entree_expediteur_2.setAlignment(FlowLayout.RIGHT);
		panel_entree_expediteur.add(panel_entree_expediteur_2);
		
		textField_8 = new JTextField();
		panel_entree_expediteur_2.add(textField_8);
		textField_8.setColumns(30);
		
		JPanel panel_entree_montant = new JPanel();
		panel_entree.add(panel_entree_montant);
		panel_entree_montant.setLayout(new BoxLayout(panel_entree_montant, BoxLayout.X_AXIS));
		
		JPanel panel_entree_montant_1 = new JPanel();
		FlowLayout fl_panel_entree_montant_1 = (FlowLayout) panel_entree_montant_1.getLayout();
		fl_panel_entree_montant_1.setAlignment(FlowLayout.LEFT);
		panel_entree_montant.add(panel_entree_montant_1);
		
		JLabel lblNewLabel_2 = new JLabel("Montant:");
		panel_entree_montant_1.add(lblNewLabel_2);
		
		JPanel panel_entree_montant_2 = new JPanel();
		FlowLayout fl_panel_entree_montant_2 = (FlowLayout) panel_entree_montant_2.getLayout();
		fl_panel_entree_montant_2.setAlignment(FlowLayout.RIGHT);
		panel_entree_montant.add(panel_entree_montant_2);
		
		textField_9 = new JTextField();
		panel_entree_montant_2.add(textField_9);
		textField_9.setColumns(30);
		
		JPanel panel_entree_fournisseur = new JPanel();
		panel_entree.add(panel_entree_fournisseur);
		panel_entree_fournisseur.setLayout(new BoxLayout(panel_entree_fournisseur, BoxLayout.X_AXIS));
		
		JPanel panel_entree_fournisseur_1 = new JPanel();
		FlowLayout fl_panel_entree_fournisseur_1 = (FlowLayout) panel_entree_fournisseur_1.getLayout();
		fl_panel_entree_fournisseur_1.setAlignment(FlowLayout.LEFT);
		panel_entree_fournisseur.add(panel_entree_fournisseur_1);
		
		JLabel lblNewLabel_3 = new JLabel("Fournisseur:");
		panel_entree_fournisseur_1.add(lblNewLabel_3);
		
		JPanel panel_entree_fournisseur_2 = new JPanel();
		FlowLayout fl_panel_entree_fournisseur_2 = (FlowLayout) panel_entree_fournisseur_2.getLayout();
		fl_panel_entree_fournisseur_2.setAlignment(FlowLayout.RIGHT);
		panel_entree_fournisseur.add(panel_entree_fournisseur_2);
		
		textField_10 = new JTextField();
		panel_entree_fournisseur_2.add(textField_10);
		textField_10.setColumns(30);
		
		JPanel panel_entree_note = new JPanel();
		panel_entree.add(panel_entree_note);
		panel_entree_note.setLayout(new BoxLayout(panel_entree_note, BoxLayout.X_AXIS));
		
		JPanel panel_entree_note_1 = new JPanel();
		FlowLayout fl_panel_entree_note_1 = (FlowLayout) panel_entree_note_1.getLayout();
		fl_panel_entree_note_1.setAlignment(FlowLayout.LEFT);
		panel_entree_note.add(panel_entree_note_1);
		
		JLabel lblNewLabel_4 = new JLabel("Notes:");
		panel_entree_note_1.add(lblNewLabel_4);
		
		JPanel panel_entree_note_2 = new JPanel();
		FlowLayout fl_panel_entree_note_2 = (FlowLayout) panel_entree_note_2.getLayout();
		fl_panel_entree_note_2.setAlignment(FlowLayout.RIGHT);
		panel_entree_note.add(panel_entree_note_2);
		
		textField_11 = new JTextField();
		panel_entree_note_2.add(textField_11);
		textField_11.setColumns(30);
		
		JPanel panel_entree_submit = new JPanel();
		panel_entree.add(panel_entree_submit);
		
		JButton btnSubmit_1 = new JButton("SUBMIT");
		panel_entree_submit.add(btnSubmit_1);
		
		JPanel entree_totale = new JPanel();
		tabbedPane_entree.addTab("Total", null, entree_totale, null);
		
		JPanel facture = new JPanel();
		tabbedPane.addTab("Facture du Marché", facture_logo, facture, null);
		facture.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_facture = new JTabbedPane(JTabbedPane.TOP);
		facture.add(tabbedPane_facture);
		
		JPanel facture_add = new JPanel();
		tabbedPane_facture.addTab("ADD", null, facture_add, null);
		facture_add.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_facture = new JScrollPane();
		facture_add.add(scrollPane_facture, BorderLayout.CENTER);
		
		table_facture = new JTable();
		scrollPane_facture.setViewportView(table_facture);
		
		JPanel panel_facture = new JPanel();
		facture_add.add(panel_facture, BorderLayout.WEST);
		panel_facture.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel panel_facture_date = new JPanel();
		panel_facture.add(panel_facture_date);
		panel_facture_date.setLayout(new BoxLayout(panel_facture_date, BoxLayout.X_AXIS));
		
		JPanel panel_facture_date_2 = new JPanel();
		FlowLayout fl_panel_facture_date_2 = (FlowLayout) panel_facture_date_2.getLayout();
		fl_panel_facture_date_2.setAlignment(FlowLayout.LEFT);
		panel_facture_date.add(panel_facture_date_2);
		
		JLabel lblNewLabel_5 = new JLabel("Date:");
		panel_facture_date_2.add(lblNewLabel_5);
		
		JPanel panel_47 = new JPanel();
		FlowLayout flowLayout_24 = (FlowLayout) panel_47.getLayout();
		flowLayout_24.setAlignment(FlowLayout.RIGHT);
		panel_facture_date.add(panel_47);
		
		textField_12 = new JTextField();
		panel_47.add(textField_12);
		textField_12.setColumns(30);
		
		JPanel panel_facture_quantite = new JPanel();
		panel_facture.add(panel_facture_quantite);
		panel_facture_quantite.setLayout(new BoxLayout(panel_facture_quantite, BoxLayout.X_AXIS));
		
		JPanel panel_facture_quantite_1 = new JPanel();
		FlowLayout fl_panel_facture_quantite_1 = (FlowLayout) panel_facture_quantite_1.getLayout();
		fl_panel_facture_quantite_1.setAlignment(FlowLayout.LEFT);
		panel_facture_quantite.add(panel_facture_quantite_1);
		
		JLabel lblNewLabel_6 = new JLabel("Quantité:");
		panel_facture_quantite_1.add(lblNewLabel_6);
		
		JPanel panel_facture_quantite_2 = new JPanel();
		FlowLayout fl_panel_facture_quantite_2 = (FlowLayout) panel_facture_quantite_2.getLayout();
		fl_panel_facture_quantite_2.setAlignment(FlowLayout.RIGHT);
		panel_facture_quantite.add(panel_facture_quantite_2);
		
		textField_13 = new JTextField();
		panel_facture_quantite_2.add(textField_13);
		textField_13.setColumns(26);
		
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_facture_quantite_2.add(button);
		
		JPanel panel_facture_marchee = new JPanel();
		panel_facture.add(panel_facture_marchee);
		panel_facture_marchee.setLayout(new BoxLayout(panel_facture_marchee, BoxLayout.X_AXIS));
		
		JPanel panel_facture_marchee_1 = new JPanel();
		FlowLayout fl_panel_facture_marchee_1 = (FlowLayout) panel_facture_marchee_1.getLayout();
		fl_panel_facture_marchee_1.setAlignment(FlowLayout.LEFT);
		panel_facture_marchee.add(panel_facture_marchee_1);
		
		JLabel lblNewLabel_7 = new JLabel("Marchée:");
		panel_facture_marchee_1.add(lblNewLabel_7);
		
		JPanel panel_facture_marchee_2 = new JPanel();
		FlowLayout fl_panel_facture_marchee_2 = (FlowLayout) panel_facture_marchee_2.getLayout();
		fl_panel_facture_marchee_2.setAlignment(FlowLayout.RIGHT);
		panel_facture_marchee.add(panel_facture_marchee_2);
		
		textField_14 = new JTextField();
		panel_facture_marchee_2.add(textField_14);
		textField_14.setColumns(30);
		
		JPanel panel_facture_numero = new JPanel();
		panel_facture.add(panel_facture_numero);
		panel_facture_numero.setLayout(new BoxLayout(panel_facture_numero, BoxLayout.X_AXIS));
		
		JPanel panel_facture_numero_1 = new JPanel();
		FlowLayout fl_panel_facture_numero_1 = (FlowLayout) panel_facture_numero_1.getLayout();
		fl_panel_facture_numero_1.setAlignment(FlowLayout.LEFT);
		panel_facture_numero.add(panel_facture_numero_1);
		
		JLabel lblNewLabel_8 = new JLabel("Numero facture:");
		panel_facture_numero_1.add(lblNewLabel_8);
		
		JPanel panel_facture_numero_2 = new JPanel();
		FlowLayout fl_panel_facture_numero_2 = (FlowLayout) panel_facture_numero_2.getLayout();
		fl_panel_facture_numero_2.setAlignment(FlowLayout.RIGHT);
		panel_facture_numero.add(panel_facture_numero_2);
		
		textField_15 = new JTextField();
		panel_facture_numero_2.add(textField_15);
		textField_15.setColumns(30);
		
		JPanel panel_facture_montant = new JPanel();
		panel_facture.add(panel_facture_montant);
		panel_facture_montant.setLayout(new BoxLayout(panel_facture_montant, BoxLayout.X_AXIS));
		
		JPanel panel_facture_montant_1 = new JPanel();
		FlowLayout fl_panel_facture_montant_1 = (FlowLayout) panel_facture_montant_1.getLayout();
		fl_panel_facture_montant_1.setAlignment(FlowLayout.LEFT);
		panel_facture_montant.add(panel_facture_montant_1);
		
		JLabel lblNewLabel_9 = new JLabel("Montant:");
		panel_facture_montant_1.add(lblNewLabel_9);
		
		JPanel panel_facture_montant_2 = new JPanel();
		FlowLayout fl_panel_facture_montant_2 = (FlowLayout) panel_facture_montant_2.getLayout();
		fl_panel_facture_montant_2.setAlignment(FlowLayout.RIGHT);
		panel_facture_montant.add(panel_facture_montant_2);
		
		textField_16 = new JTextField();
		panel_facture_montant_2.add(textField_16);
		textField_16.setColumns(30);
		
		JPanel panel_facture_location = new JPanel();
		panel_facture.add(panel_facture_location);
		panel_facture_location.setLayout(new BoxLayout(panel_facture_location, BoxLayout.X_AXIS));
		
		JPanel panel_facture_location_1 = new JPanel();
		FlowLayout fl_panel_facture_location_1 = (FlowLayout) panel_facture_location_1.getLayout();
		fl_panel_facture_location_1.setAlignment(FlowLayout.LEFT);
		panel_facture_location.add(panel_facture_location_1);
		
		JLabel lblNewLabel_10 = new JLabel("Location:");
		panel_facture_location_1.add(lblNewLabel_10);
		
		JPanel panel_facture_location_2 = new JPanel();
		FlowLayout fl_panel_facture_location_2 = (FlowLayout) panel_facture_location_2.getLayout();
		fl_panel_facture_location_2.setAlignment(FlowLayout.RIGHT);
		panel_facture_location.add(panel_facture_location_2);
		
		textField_17 = new JTextField();
		panel_facture_location_2.add(textField_17);
		textField_17.setColumns(30);
		
		JPanel facture_totale = new JPanel();
		tabbedPane_facture.addTab("Total", null, facture_totale, null);
		
		JPanel employee = new JPanel();
		tabbedPane.addTab("Travailleur", employe_logo, employee, null);
		employee.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_employee = new JTabbedPane(JTabbedPane.TOP);
		employee.add(tabbedPane_employee, BorderLayout.CENTER);
		
		JPanel employee_employee = new JPanel();
		tabbedPane_employee.addTab("Employés", null, employee_employee, null);
		employee_employee.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_employee_1 = new JScrollPane();
		employee_employee.add(scrollPane_employee_1, BorderLayout.CENTER);

		m2 = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				if (col == 0) {		//set Column 1 uneditable
					return false;
					}
				else {
					return true;
					}       
				}
		};
		
		
		String[] entete2 = {"Id", "Prenom", "Nom", "Lieu", "Date expiration de séjour","Mode de Payement"};
		m2.setColumnIdentifiers(entete2);
//		String[] line = {"111", "", "", "", ""};
//		for (int i=0;i<100;i++) {
//			m2.addRow(line);
//		}
		refresh_employee();
		
		table_employee_1 = new JTable(m2);
		table_employee_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_19.setText((String) m2.getValueAt(table_employee_1.getSelectedRow(), 1));
				textField_20.setText((String) m2.getValueAt(table_employee_1.getSelectedRow(), 2));
				textField_18.setText((String) m2.getValueAt(table_employee_1.getSelectedRow(), 3));
				textField_21.setText((String) m2.getValueAt(table_employee_1.getSelectedRow(), 4));
				String mode = (String) m2.getValueAt(table_employee_1.getSelectedRow(), 5);
				if(mode.contains("Par jour")) {
					chckbxJm.setSelected(true);
					textField_21.setEnabled(false);
				}
				else {
					chckbxJm.setSelected(false);
					textField_21.setEnabled(true);
				}
			}
		});
		table_employee_1.setShowGrid(true);
		scrollPane_employee_1.setViewportView(table_employee_1);
		
		JPanel panel_employee_1 = new JPanel();
		employee_employee.add(panel_employee_1, BorderLayout.WEST);
		panel_employee_1.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel panel_employee_1_prenom = new JPanel();
		panel_employee_1.add(panel_employee_1_prenom);
		panel_employee_1_prenom.setLayout(new BoxLayout(panel_employee_1_prenom, BoxLayout.X_AXIS));
		
		JPanel panel_employee_1_prenom_1 = new JPanel();
		FlowLayout fl_panel_employee_1_prenom_1 = (FlowLayout) panel_employee_1_prenom_1.getLayout();
		fl_panel_employee_1_prenom_1.setAlignment(FlowLayout.LEFT);
		panel_employee_1_prenom.add(panel_employee_1_prenom_1);
		
		JLabel lblPrenom = new JLabel("Prenom:");
		panel_employee_1_prenom_1.add(lblPrenom);
		
		JPanel panel_employee_1_prenom_2 = new JPanel();
		FlowLayout fl_panel_employee_1_prenom_2 = (FlowLayout) panel_employee_1_prenom_2.getLayout();
		fl_panel_employee_1_prenom_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_1_prenom.add(panel_employee_1_prenom_2);
		
		textField_19 = new JTextField();
		textField_19.setColumns(30);
		panel_employee_1_prenom_2.add(textField_19);
		
		JPanel panel_employee_1_nom = new JPanel();
		panel_employee_1.add(panel_employee_1_nom);
		panel_employee_1_nom.setLayout(new BoxLayout(panel_employee_1_nom, BoxLayout.X_AXIS));
		
		JPanel panel_employee_1_nom_1 = new JPanel();
		FlowLayout fl_panel_employee_1_nom_1 = (FlowLayout) panel_employee_1_nom_1.getLayout();
		fl_panel_employee_1_nom_1.setAlignment(FlowLayout.LEFT);
		panel_employee_1_nom.add(panel_employee_1_nom_1);
		
		JLabel lblNom = new JLabel("Nom:");
		panel_employee_1_nom_1.add(lblNom);
		
		JPanel panel_employee_1_nom_2 = new JPanel();
		FlowLayout fl_panel_employee_1_nom_2 = (FlowLayout) panel_employee_1_nom_2.getLayout();
		fl_panel_employee_1_nom_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_1_nom.add(panel_employee_1_nom_2);
		
		textField_20 = new JTextField();
		textField_20.setColumns(30);
		panel_employee_1_nom_2.add(textField_20);
		
		JPanel panel_employee_1_location = new JPanel();
		panel_employee_1.add(panel_employee_1_location);
		panel_employee_1_location.setLayout(new BoxLayout(panel_employee_1_location, BoxLayout.X_AXIS));
		
		JPanel panel_employee_1_location_1 = new JPanel();
		FlowLayout fl_panel_employee_1_location_1 = (FlowLayout) panel_employee_1_location_1.getLayout();
		fl_panel_employee_1_location_1.setAlignment(FlowLayout.LEFT);
		panel_employee_1_location.add(panel_employee_1_location_1);
		
		JLabel lblNewLabel_11 = new JLabel("Lieu:");
		panel_employee_1_location_1.add(lblNewLabel_11);
		
		JPanel panel_employee_1_location_2 = new JPanel();
		FlowLayout fl_panel_employee_1_location_2 = (FlowLayout) panel_employee_1_location_2.getLayout();
		fl_panel_employee_1_location_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_1_location.add(panel_employee_1_location_2);
		
		textField_18 = new JTextField();
		panel_employee_1_location_2.add(textField_18);
		textField_18.setColumns(30);
		
		JPanel panel_employee_1_sejour = new JPanel();
		panel_employee_1.add(panel_employee_1_sejour);
		panel_employee_1_sejour.setLayout(new BoxLayout(panel_employee_1_sejour, BoxLayout.X_AXIS));
		
		JPanel panel_employee_1_sejour_1 = new JPanel();
		FlowLayout fl_panel_employee_1_sejour_1 = (FlowLayout) panel_employee_1_sejour_1.getLayout();
		fl_panel_employee_1_sejour_1.setAlignment(FlowLayout.LEFT);
		panel_employee_1_sejour.add(panel_employee_1_sejour_1);
		
		JLabel lblExpDeSejour = new JLabel("Exp de sejour:");
		panel_employee_1_sejour_1.add(lblExpDeSejour);
		
		JPanel panel_employee_1_sejour_2 = new JPanel();
		FlowLayout fl_panel_employee_1_sejour_2 = (FlowLayout) panel_employee_1_sejour_2.getLayout();
		fl_panel_employee_1_sejour_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_1_sejour.add(panel_employee_1_sejour_2);
		
		textField_21 = new JTextField();
		textField_21.setColumns(22);
		panel_employee_1_sejour_2.add(textField_21);
		
		chckbxJm = new JCheckBox("Par Jour");
		chckbxJm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxJm.isSelected()) {
					textField_21.setEnabled(false);
					textField_21.setText("EMPTY");
				}
				else {
					textField_21.setEnabled(true);
					textField_21.setText("");
				}
			}
		});
		panel_employee_1_sejour_2.add(chckbxJm);
		
		JPanel panel_employee_1_submit = new JPanel();
		panel_employee_1.add(panel_employee_1_submit);
		
		JButton button_1 = new JButton("SUBMIT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String prenom = textField_19.getText();
				String nom = textField_20.getText();
				String lieu = textField_18.getText();
				String date_exp_sejour;
				int mode;
				if(chckbxJm.isSelected()) {
					mode=1;
					date_exp_sejour = "";
				}
				else {
					mode=0;
					date_exp_sejour = textField_21.getText();
				}
				Employe e = new Employe(prenom, nom, lieu, date_exp_sejour, mode);
				try {
					dbh.addEmploye(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				refresh_employee();
			}
		});
		panel_employee_1_submit.add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String prenom = textField_19.getText();
				String nom = textField_20.getText();
				String lieu = textField_18.getText();
				String date_exp_sejour;
				int mode;
				if(chckbxJm.isSelected()) {
					mode=1;
					date_exp_sejour = "";
				}
				else {
					mode=0;
					date_exp_sejour = textField_21.getText();
				}
				Employe e = new Employe(lieu, prenom, nom, date_exp_sejour, mode);
				try {
					dbh.updateEmploye(Integer.parseInt((String) m2.getValueAt(table_employee_1.getSelectedRow(), 0)), e);
					//System.out.println(""+Integer.parseInt((String) m2.getValueAt(table_employee_1.getSelectedRow(), 0)));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				refresh_employee();
			}
		});
		panel_employee_1_submit.add(button_2);
		
		JButton button_3 = new JButton("DELETE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dbh.suppEmploye(Integer.parseInt((String) m2.getValueAt(table_employee_1.getSelectedRow(), 0)));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				textField.requestFocus();
				refresh_employee();
			}
		});
		panel_employee_1_submit.add(button_3);
		
		JPanel employee_payement = new JPanel();
		tabbedPane_employee.addTab("Payement", null, employee_payement, null);
		employee_payement.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_employee_2 = new JScrollPane();
		employee_payement.add(scrollPane_employee_2, BorderLayout.CENTER);
		
		table_employee_2 = new JTable();
		scrollPane_employee_2.setViewportView(table_employee_2);
		
		JPanel panel_employee_2 = new JPanel();
		employee_payement.add(panel_employee_2, BorderLayout.WEST);
		panel_employee_2.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel panel_employee_2_id = new JPanel();
		panel_employee_2.add(panel_employee_2_id);
		panel_employee_2_id.setLayout(new BoxLayout(panel_employee_2_id, BoxLayout.X_AXIS));
		
		JPanel panel_employee_2_id_1 = new JPanel();
		FlowLayout fl_panel_employee_2_id_1 = (FlowLayout) panel_employee_2_id_1.getLayout();
		fl_panel_employee_2_id_1.setAlignment(FlowLayout.LEFT);
		panel_employee_2_id.add(panel_employee_2_id_1);
		
		JLabel lblNewLabel_13 = new JLabel("Id:");
		panel_employee_2_id_1.add(lblNewLabel_13);
		
		JPanel panel_employee_2_id_2 = new JPanel();
		FlowLayout fl_panel_employee_2_id_2 = (FlowLayout) panel_employee_2_id_2.getLayout();
		fl_panel_employee_2_id_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_2_id.add(panel_employee_2_id_2);
		
		textField_25 = new JTextField();
		panel_employee_2_id_2.add(textField_25);
		textField_25.setColumns(30);
		
		JPanel panel_employee_2_payement = new JPanel();
		panel_employee_2.add(panel_employee_2_payement);
		panel_employee_2_payement.setLayout(new BoxLayout(panel_employee_2_payement, BoxLayout.X_AXIS));
		
		JPanel panel_employee_2_payement_1 = new JPanel();
		FlowLayout fl_panel_employee_2_payement_1 = (FlowLayout) panel_employee_2_payement_1.getLayout();
		fl_panel_employee_2_payement_1.setAlignment(FlowLayout.LEFT);
		panel_employee_2_payement.add(panel_employee_2_payement_1);
		
		JLabel lblDateDePayement = new JLabel("Date de payement:");
		panel_employee_2_payement_1.add(lblDateDePayement);
		
		JPanel panel_employee_2_payement_2 = new JPanel();
		FlowLayout fl_panel_employee_2_payement_2 = (FlowLayout) panel_employee_2_payement_2.getLayout();
		fl_panel_employee_2_payement_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_2_payement.add(panel_employee_2_payement_2);
		
		textField_26 = new JTextField();
		panel_employee_2_payement_2.add(textField_26);
		textField_26.setColumns(30);
		
		JPanel panel_employee_2_montant = new JPanel();
		panel_employee_2.add(panel_employee_2_montant);
		panel_employee_2_montant.setLayout(new BoxLayout(panel_employee_2_montant, BoxLayout.X_AXIS));
		
		JPanel panel_employee_2_montant_1 = new JPanel();
		FlowLayout fl_panel_employee_2_montant_1 = (FlowLayout) panel_employee_2_montant_1.getLayout();
		fl_panel_employee_2_montant_1.setAlignment(FlowLayout.LEFT);
		panel_employee_2_montant.add(panel_employee_2_montant_1);
		
		JLabel lblMontant = new JLabel("Montant (Par Mois) : ");
		panel_employee_2_montant_1.add(lblMontant);
		
		JPanel panel_employee_2_montant_2 = new JPanel();
		FlowLayout fl_panel_employee_2_montant_2 = (FlowLayout) panel_employee_2_montant_2.getLayout();
		fl_panel_employee_2_montant_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_2_montant.add(panel_employee_2_montant_2);
		
		textField_27 = new JTextField();
		textField_27.setColumns(30);
		panel_employee_2_montant_2.add(textField_27);
		
		JPanel panel_employee_2_plus = new JPanel();
		panel_employee_2.add(panel_employee_2_plus);
		panel_employee_2_plus.setLayout(new BoxLayout(panel_employee_2_plus, BoxLayout.X_AXIS));
		
		JPanel panel_employee_2_plus_1 = new JPanel();
		FlowLayout fl_panel_employee_2_plus_1 = (FlowLayout) panel_employee_2_plus_1.getLayout();
		fl_panel_employee_2_plus_1.setAlignment(FlowLayout.LEFT);
		panel_employee_2_plus.add(panel_employee_2_plus_1);
		
		JLabel lblNbhPlus = new JLabel("NBH plus:");
		panel_employee_2_plus_1.add(lblNbhPlus);
		
		JPanel panel_employee_2_plus_2 = new JPanel();
		FlowLayout fl_panel_employee_2_plus_2 = (FlowLayout) panel_employee_2_plus_2.getLayout();
		fl_panel_employee_2_plus_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_2_plus.add(panel_employee_2_plus_2);
		
		textField_28 = new JTextField();
		textField_28.setEnabled(false);
		textField_28.setColumns(30);
		panel_employee_2_plus_2.add(textField_28);
		
		JPanel panel_employee_2_abcsent = new JPanel();
		panel_employee_2.add(panel_employee_2_abcsent);
		panel_employee_2_abcsent.setLayout(new BoxLayout(panel_employee_2_abcsent, BoxLayout.X_AXIS));
		
		JPanel panel_employee_2_abcsent_1 = new JPanel();
		FlowLayout fl_panel_employee_2_abcsent_1 = (FlowLayout) panel_employee_2_abcsent_1.getLayout();
		fl_panel_employee_2_abcsent_1.setAlignment(FlowLayout.LEFT);
		panel_employee_2_abcsent.add(panel_employee_2_abcsent_1);
		
		JLabel lblNbhAbscent = new JLabel("NBH abscent:");
		panel_employee_2_abcsent_1.add(lblNbhAbscent);
		
		JPanel panel_employee_2_abcsent_2 = new JPanel();
		FlowLayout fl_panel_employee_2_abcsent_2 = (FlowLayout) panel_employee_2_abcsent_2.getLayout();
		fl_panel_employee_2_abcsent_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_2_abcsent.add(panel_employee_2_abcsent_2);
		
		textField_29 = new JTextField();
		textField_29.setEnabled(false);
		textField_29.setColumns(30);
		panel_employee_2_abcsent_2.add(textField_29);
		
		JPanel panel_employee_2_travailler = new JPanel();
		panel_employee_2.add(panel_employee_2_travailler);
		panel_employee_2_travailler.setLayout(new BoxLayout(panel_employee_2_travailler, BoxLayout.X_AXIS));
		
		JPanel panel_employee_2_travailler_1 = new JPanel();
		FlowLayout fl_panel_employee_2_travailler_1 = (FlowLayout) panel_employee_2_travailler_1.getLayout();
		fl_panel_employee_2_travailler_1.setAlignment(FlowLayout.LEFT);
		panel_employee_2_travailler.add(panel_employee_2_travailler_1);
		
		JLabel lblNewLabel_14 = new JLabel("NBJ travailler:");
		panel_employee_2_travailler_1.add(lblNewLabel_14);
		
		JPanel panel_employee_2_travailler_2 = new JPanel();
		FlowLayout fl_panel_employee_2_travailler_2 = (FlowLayout) panel_employee_2_travailler_2.getLayout();
		fl_panel_employee_2_travailler_2.setAlignment(FlowLayout.RIGHT);
		panel_employee_2_travailler.add(panel_employee_2_travailler_2);
		
		textField_30 = new JTextField();
		textField_30.setEnabled(false);
		panel_employee_2_travailler_2.add(textField_30);
		textField_30.setColumns(30);
		
		JPanel panel_6 = new JPanel();
		panel_employee_2.add(panel_6);
		
		JCheckBox chckbxParJour = new JCheckBox("Par Jour");
		chckbxParJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxParJour.isSelected()) {
					textField_28.setEnabled(true);
					textField_29.setEnabled(true);
					textField_30.setEnabled(true);
					lblMontant.setText("Montant (Par Jour) : ");
				}
				else {
					textField_28.setEnabled(false);
					textField_29.setEnabled(false);
					textField_30.setEnabled(false);
					lblMontant.setText("Montant (Par Mois) : ");
				}
			}
		});
		panel_6.add(chckbxParJour);
		
		JPanel panel_employee_2_submit = new JPanel();
		panel_employee_2.add(panel_employee_2_submit);
		
		JButton button_4 = new JButton("SUBMIT");
		panel_employee_2_submit.add(button_4);
		
		JButton button_5 = new JButton("UPDATE");
		panel_employee_2_submit.add(button_5);
		
		JButton button_6 = new JButton("DELETE");
		panel_employee_2_submit.add(button_6);
		
		JPanel employee_totale = new JPanel();
		tabbedPane_employee.addTab("Total", null, employee_totale, null);
		employee_totale.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		employee_totale.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(BorderFactory.createTitledBorder("Date de debut : "));
		panel_3.add(panel_4);
		
		JLabel label_10 = new JLabel("yyyy:");
		panel_4.add(label_10);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setPreferredSize(new Dimension(60, 30));
		panel_4.add(spinner_6);
		
		JLabel label_11 = new JLabel("mm:");
		panel_4.add(label_11);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setPreferredSize(new Dimension(60, 30));
		panel_4.add(spinner_7);
		
		JLabel label_12 = new JLabel("dd:");
		panel_4.add(label_12);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setPreferredSize(new Dimension(60, 30));
		panel_4.add(spinner_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(BorderFactory.createTitledBorder("Date de Fin : "));
		panel_3.add(panel_5);
		
		JLabel label_13 = new JLabel("yyyy:");
		panel_5.add(label_13);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setPreferredSize(new Dimension(60, 30));
		panel_5.add(spinner_9);
		
		JLabel label_14 = new JLabel("mm:");
		panel_5.add(label_14);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setPreferredSize(new Dimension(60, 30));
		panel_5.add(spinner_10);
		
		JLabel label_15 = new JLabel("dd:");
		panel_5.add(label_15);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setPreferredSize(new Dimension(60, 30));
		panel_5.add(spinner_11);
		
		JProgressBar progressBar_1 = new JProgressBar(0, 100);
		progressBar_1.setValue(0);
		progressBar_1.setStringPainted(true);
		progressBar_1.setString("0 L.L");
		employee_totale.add(progressBar_1, BorderLayout.EAST);
		
		JPanel panel_employee_check = new JPanel();
		employee_totale.add(panel_employee_check, BorderLayout.SOUTH);
		panel_employee_check.setLayout(new BorderLayout(0, 0));
		
		JButton btnCheck1 = new JButton("CHECK");
		panel_employee_check.add(btnCheck1, BorderLayout.NORTH);
		
		JButton btnCheckAll1 = new JButton("CHECK ALL");
		panel_employee_check.add(btnCheckAll1, BorderLayout.SOUTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		employee_totale.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel verger = new JPanel();
		tabbedPane.addTab("Verger", verger_logo, verger, null);
		verger.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_verger = new JTabbedPane(JTabbedPane.TOP);
		verger.add(tabbedPane_verger, BorderLayout.CENTER);
		
		JPanel verger_verger = new JPanel();
		tabbedPane_verger.addTab("Verger", null, verger_verger, null);
		verger_verger.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_verger = new JScrollPane();
		verger_verger.add(scrollPane_verger, BorderLayout.CENTER);
		
		m1 = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				if (col == 0) {		//set Column 1 uneditable
					return false;
					}
				else {
					return true;
					}       
				}
		};
		
		String[] entete1 = {"Nom", "Lieu", "Surface"};
		m1.setColumnIdentifiers(entete1);
//		String[] line = {"111", "", "", "", "", "", ""};
//		for (int i=0;i<100;i++) {
//			m1.addRow(line);
//		}
		
		refresh_verger();
		
		table_verger = new JTable(m1);
		table_verger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_23.setText((String) m1.getValueAt(table_verger.getSelectedRow(), 0));
				textField_24.setText((String) m1.getValueAt(table_verger.getSelectedRow(), 1));
				textField_22.setText((String) m1.getValueAt(table_verger.getSelectedRow(), 2));
			}
		});
		table_verger.setShowGrid(true);
		scrollPane_verger.setViewportView(table_verger);
		
		JPanel panel_verger = new JPanel();
		verger_verger.add(panel_verger, BorderLayout.WEST);
		panel_verger.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel panel_verger_nom = new JPanel();
		panel_verger.add(panel_verger_nom);
		panel_verger_nom.setLayout(new BoxLayout(panel_verger_nom, BoxLayout.X_AXIS));
		
		JPanel panel_verger_nom_1 = new JPanel();
		FlowLayout fl_panel_verger_nom_1 = (FlowLayout) panel_verger_nom_1.getLayout();
		fl_panel_verger_nom_1.setAlignment(FlowLayout.LEFT);
		panel_verger_nom.add(panel_verger_nom_1);
		
		JLabel lblNewLabel_12 = new JLabel("Nom:");
		panel_verger_nom_1.add(lblNewLabel_12);
		
		JPanel panel_verger_nom_2 = new JPanel();
		FlowLayout fl_panel_verger_nom_2 = (FlowLayout) panel_verger_nom_2.getLayout();
		fl_panel_verger_nom_2.setAlignment(FlowLayout.RIGHT);
		panel_verger_nom.add(panel_verger_nom_2);
		
		textField_23 = new JTextField();
		textField_23.setColumns(30);
		panel_verger_nom_2.add(textField_23);
		
		JPanel panel_verger_location = new JPanel();
		panel_verger.add(panel_verger_location);
		panel_verger_location.setLayout(new BoxLayout(panel_verger_location, BoxLayout.X_AXIS));
		
		JPanel panel_verger_location_1 = new JPanel();
		FlowLayout fl_panel_verger_location_1 = (FlowLayout) panel_verger_location_1.getLayout();
		fl_panel_verger_location_1.setAlignment(FlowLayout.LEFT);
		panel_verger_location.add(panel_verger_location_1);
		
		JLabel lblLocation_1 = new JLabel("Lieu:");
		panel_verger_location_1.add(lblLocation_1);
		
		JPanel panel_verger_location_2 = new JPanel();
		FlowLayout fl_panel_verger_location_2 = (FlowLayout) panel_verger_location_2.getLayout();
		fl_panel_verger_location_2.setAlignment(FlowLayout.RIGHT);
		panel_verger_location.add(panel_verger_location_2);
		
		textField_22 = new JTextField();
		panel_verger_location_2.add(textField_22);
		textField_22.setColumns(30);
		
		JPanel panel_verger_surface = new JPanel();
		panel_verger.add(panel_verger_surface);
		panel_verger_surface.setLayout(new BoxLayout(panel_verger_surface, BoxLayout.X_AXIS));
		
		JPanel panel_verger_surface_1 = new JPanel();
		FlowLayout fl_panel_verger_surface_1 = (FlowLayout) panel_verger_surface_1.getLayout();
		fl_panel_verger_surface_1.setAlignment(FlowLayout.LEFT);
		panel_verger_surface.add(panel_verger_surface_1);
		
		JLabel lblSurface = new JLabel("Surface:");
		panel_verger_surface_1.add(lblSurface);
		
		JPanel panel_verger_surface_2 = new JPanel();
		FlowLayout fl_panel_verger_surface_2 = (FlowLayout) panel_verger_surface_2.getLayout();
		fl_panel_verger_surface_2.setAlignment(FlowLayout.RIGHT);
		panel_verger_surface.add(panel_verger_surface_2);
		
		textField_24 = new JTextField();
		textField_24.setColumns(30);
		panel_verger_surface_2.add(textField_24);
		
		JPanel panel_verger_submit = new JPanel();
		panel_verger.add(panel_verger_submit);
		
		JButton button_7 = new JButton("SUBMIT");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textField_23.getText();
				float surface = 0;
				try {
					surface = Float.parseFloat(textField_24.getText());
				} catch (Exception e1) {
				}
				String location = textField_22.getText();
				Verger v = new Verger(nom, surface, location);
				try {
					dbh.addVerger(v);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				refresh_verger();
			}
		});
		panel_verger_submit.add(button_7);
		
		JButton button_8 = new JButton("UPDATE");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textField_23.getText();
				float surface = 0;
				try {
					surface = Float.parseFloat(textField_24.getText());
				} catch (Exception e1) {
				}
				String location = textField_22.getText();
				Verger v = new Verger(nom, surface, location);
				try {
					dbh.updateVerger((String) m1.getValueAt(table_verger.getSelectedRow(), 0), v);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				refresh_verger();
			}
		});
		panel_verger_submit.add(button_8);
		
		JButton button_9 = new JButton("DELETE");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dbh.suppVerger((String) m1.getValueAt(table_verger.getSelectedRow(), 0));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				textField_23.requestFocus();
				refresh_verger();
			}
		});
		panel_verger_submit.add(button_9);
		
		JPanel verger_production = new JPanel();
		tabbedPane_verger.addTab("Prduction", null, verger_production, null);
		
		setLocationRelativeTo(null);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////frame_logo/////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		ImageIcon frame_logo = new ImageIcon("C:\\Users\\Chalhoub\\eclipse-workspace\\lab\\assets\\frameicon.png");
		setIconImage(frame_logo.getImage());
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//setResizable(false);
		//setUndecorated(true);
		//setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
	}
	
	public String[] getRowAt(int row, int colNumber, DefaultTableModel m) {
	     String[] result = new String[colNumber];

	     for (int col = 0; col < colNumber; col++) {
	         result[col] = (String) m.getValueAt(row, col);
	     }

	     return result;
	}
	
	public void refresh_depence() {
		try {
			ArrayList<Depence> AllDepences;
			AllDepences = dbh.getAllDepence();
			m.setRowCount(0);
			for(int count=0 ; count<AllDepences.size() ; count++) {
				Depence d = AllDepences.get(count);
				m.addRow(new String[] {d.getId() + "", d.getDate(), d.getPayePour(), d.getArticle(), d.getMontant() + "", d.getMachine(), d.getLocation(), d.getNote()});
				}
			//m.setRowCount(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refresh_all_depence() {
		try {
			ArrayList<Depence> AllDepences;
			AllDepences = dbh.getAllDepence();
			m3.setRowCount(0);
			for(int count=0 ; count<AllDepences.size() ; count++) {
				Depence d = AllDepences.get(count);
				m3.addRow(new String[] {d.getId() + "", d.getDate(), d.getPayePour(), d.getArticle(), d.getMontant() + "", d.getMachine(), d.getLocation(), d.getNote()});
				}
			//m.setRowCount(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refresh_from_to_depence(String date_start, String date_end) {
		try {
			ArrayList<Depence> AllDepences;
			AllDepences = dbh.getFromToDepence(date_start, date_end);
			m3.setRowCount(0);
			for(int count=0 ; count<AllDepences.size() ; count++) {
				Depence d = AllDepences.get(count);
				m3.addRow(new String[] {d.getId() + "", d.getDate(), d.getPayePour(), d.getArticle(), d.getMontant() + "", d.getMachine(), d.getLocation(), d.getNote()});
				}
			//m.setRowCount(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refresh_verger() {
		try {
			ArrayList<Verger> AllVergers;
			AllVergers = dbh.getAllVerger();
			m1.setRowCount(0);
			for(int count=0 ; count<AllVergers.size() ; count++) {
				Verger v = AllVergers.get(count);
				m1.addRow(new String[] {v.getNom(), v.getSurface() + "", v.getLocation()});
				}
			//m.setRowCount(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refresh_employee() {
		try {
			ArrayList<Employe> AllEmployes;
			AllEmployes = dbh.getAllEmploye();
			m2.setRowCount(0);
			//System.out.println(AllEmployes.size() + "");
			for(int count=0 ; count<AllEmployes.size() ; count++) {
				Employe e = AllEmployes.get(count);
				String mode;
				String date_exp_sejour;
				if(e.getMode()==1) {
					mode="Par jour";
					date_exp_sejour="EMPTY";
				}
				else {
					mode="Par mois";
					date_exp_sejour=e.getDateExpSejour();
				}
				m2.addRow(new String[] {e.getId() + "", e.getPrenom(), e.getnom(), e.getnomV(), date_exp_sejour, mode});
				}
			//m.setRowCount(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
