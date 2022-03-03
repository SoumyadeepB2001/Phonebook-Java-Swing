import java.io.*;
import java.lang.*;
import java.util.logging.Level;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

class PhoneBook extends JFrame implements ActionListener, WindowListener {
	public JFrame frame1;
	//public JPanel p;
	public JLabel AddLab, EidLab, NameLab, PhoneNumLab, SearchLab, TitleLab;
	public JButton addBut, clrBut, clrSearch, delBut, saveBut, updateBut;
	public JScrollPane jScrollPane1;
	
	public JTextField tfadd, tfeid, tfname, tfnum, tfsearch;
	public static final String[] columns = {"Name", "Phone No.", "Address", "Email ID"};
    // Create the table model
    public DefaultTableModel model = new DefaultTableModel(columns, 0);
	public JTable jTable1;

	PhoneBook() {
		this.setTitle("PhoneBook");
		this.setLocationRelativeTo(null);
		initComponents();
		clrSearch.setFont(new Font("Verdana", Font.BOLD, 8));
		clrSearch.setForeground(Color.RED);
		frame1.setSize(1000, 500);
		frame1.setResizable(false);

		TitleLab.setBounds(0, 10, 952, 24);
		NameLab.setBounds(50, 100, 90, 30);
		PhoneNumLab.setBounds(50, 140, 90, 30);
		AddLab.setBounds(50, 180, 90, 30);
		EidLab.setBounds(50, 220, 90, 30);
		SearchLab.setBounds(480, 70, 50, 30);

		tfname.setBounds(160, 100, 220, 30);
		tfnum.setBounds(160, 140, 220, 30);
		tfadd.setBounds(160, 180, 220, 30);
		tfeid.setBounds(160, 220, 220, 30);
		tfsearch.setBounds(540, 70, 190, 28);

		addBut.setBounds(30, 290, 75, 30);
		delBut.setBounds(113, 290, 75, 30);
		updateBut.setBounds(196, 290, 75, 30);
		saveBut.setBounds(279, 290, 75, 30);
		clrBut.setBounds(362, 290, 75, 30);
		clrSearch.setBounds(740, 70, 40, 28);

		jTable1.setBounds(480, 100, 490, 350);
		jScrollPane1.setBounds(480, 100, 490, 350);

		frame1.add(TitleLab);
		frame1.add(NameLab);
		frame1.add(PhoneNumLab);
		frame1.add(AddLab);
		frame1.add(EidLab);
		frame1.add(SearchLab);
		frame1.add(addBut);
		frame1.add(delBut);
		frame1.add(updateBut);
		frame1.add(saveBut);
		frame1.add(clrBut);
		frame1.add(clrSearch);
		frame1.add(tfadd);
		frame1.add(tfeid);
		frame1.add(tfname);
		frame1.add(tfnum);
		frame1.add(tfsearch);
		frame1.add(jTable1);
		frame1.add(jScrollPane1);

		addBut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButActionPerformed(evt);
			}
		});

		delBut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				delButActionPerformed(evt);
			}
		});

		saveBut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButActionPerformed(evt);
			}
		});

		updateBut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateButActionPerformed(evt);
			}
		});

		clrBut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clrButActionPerformed(evt);
			}
		});

		clrSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clrSearchActionPerformed(evt);
			}
		});

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		frame1.setLayout(null);
		frame1.setVisible(true);
		
	}

	public void initComponents() {
		frame1 = new JFrame("PhoneBook");
		//p = new JPanel(new GridLayout(6, 6));
		jTable1 = new JTable(model);
		PhoneNumLab = new JLabel("Phone Number:");
		TitleLab = new JLabel("PHONEBOOK");
		NameLab = new JLabel("Name:");
		AddLab = new JLabel("Address:");
		EidLab = new JLabel("Email ID:");
		SearchLab = new JLabel("Search");
		tfname = new JTextField();
		tfeid = new JTextField();
		tfnum = new JTextField();
		tfadd = new JTextField();
		jScrollPane1 = new JScrollPane(jTable1);
		tfsearch = new JTextField();
		addBut = new JButton("Add");
		delBut = new JButton("Delete");
		saveBut = new JButton("Save");
		updateBut = new JButton("Update");
		clrBut = new JButton("Clear");
		clrSearch = new JButton("X");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tfsearch.setToolTipText("Type to search");
		addBut.setToolTipText("Add a new contact");
		delBut.setToolTipText("Remove an existing contact");
		saveBut.setToolTipText("Save the table");
		updateBut.setToolTipText("Update the existing table");
		clrBut.setToolTipText("Clear the text fields");
		clrSearch.setToolTipText("Clear Search Box");
		TitleLab.setFont(new java.awt.Font("Britannic Bold", 1, 24));
		TitleLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		TitleLab.setText("PHONEBOOK");

		jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable1.setColumnSelectionAllowed(true);
		jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		jTable1.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(jTable1);
		jTable1.getColumnModel().getSelectionModel()
				.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}

	public void addButActionPerformed(java.awt.event.ActionEvent evt) {
		filter(0);
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		var n = tfname.getText();
		if (n.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter the name of the contact.");
		} else
			model.addRow(new Object[] { tfname.getText(), tfnum.getText(), tfadd.getText(), tfeid.getText() });
		filter(0);
		tfsearch.setText("");
		tfname.setText("");
		tfnum.setText("");
		tfadd.setText("");
		tfeid.setText("");
	}

	public void delButActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTable1.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "No contact selected.");
		} else {
			int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to remove this contact?", "Remove Contact",
					JOptionPane.YES_NO_OPTION);
			if (YesOrNo == 0) {
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				int rowindex = jTable1.getSelectedRow();
				int modelRow = jTable1.convertRowIndexToModel(rowindex);
				model.removeRow(modelRow);
			}
		}
	}

	public void saveButActionPerformed(java.awt.event.ActionEvent evt) {

		filter(0);
		File file = new File("Contacts.txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < jTable1.getRowCount(); i++) {// rows
				for (int j = 0; j < jTable1.getColumnCount(); j++) {// columns
					if (jTable1.getValueAt(i, j) == null) {
						bw.write("" + "¶");
					} else {
						bw.write(String.valueOf(jTable1.getValueAt(i, j)));
						bw.write("¶");

					}
				}
				bw.newLine();
			}

			bw.close();
			fw.close();
			tfname.setText("");
			tfnum.setText("");
			tfadd.setText("");
			tfeid.setText("");
		} catch (IOException ex) {
			System.out.println("exception");
			java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updateButActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		var n = tfname.getText();
		if (n.equals(""))
			JOptionPane.showMessageDialog(null, "Please enter the name of the contact.");

		else {
			int viewRow = jTable1.getSelectedRow();
			int modelRow = jTable1.convertRowIndexToModel(viewRow);
			if (modelRow >= 0) {
				model.setValueAt(tfname.getText(), modelRow, 0);
				model.setValueAt(tfnum.getText(), modelRow, 1);
				model.setValueAt(tfadd.getText(), modelRow, 2);
				model.setValueAt(tfeid.getText(), modelRow, 3);
			}
		}
	}

	public void clrSearchActionPerformed(java.awt.event.ActionEvent evt) {
		filter(0);
		tfsearch.setText("");
		tfname.setText("");
		tfnum.setText("");
		tfadd.setText("");
		tfeid.setText("");
	}

	public void clrButActionPerformed(java.awt.event.ActionEvent evt) {
		tfname.setText("");
		tfnum.setText("");
		tfadd.setText("");
		tfeid.setText("");
	}

	public void filter(int n) {

		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		String s = tfsearch.getText();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
		if (n == 1) {
			jTable1.setRowSorter(tr);
			tr.setRowFilter(RowFilter.regexFilter("(?i)" + s));
		} else if (n == 0) {
			jTable1.setRowSorter(tr);
			tr.setRowFilter(null);
		}
	}

	public void formWindowOpened(java.awt.event.WindowEvent evt) {
		File file = new File("Contacts.txt");
		try {

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
			Object[] lines = br.lines().toArray();

			for (int i = 0; i < lines.length; i++) {
				String[] row = lines[i].toString().split("¶");
				model.addRow(row);
			}
		} catch (FileNotFoundException ex) {
			java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void main(String args[]) {
		new PhoneBook();
	}

}