package oop8;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddContact extends JFrame implements ActionListener, MouseListener, WindowListener, FocusListener
{
	public static final String EMPTY_NAME_TEXT = "< Enter Name >";
	public static final String EMPTY_PHONE_TEXT = "< Enter Phone >";
	public static final String EMPTY_EMAIL_TEXT = "< Enter Email >";

	JTextField txtName = new JTextField(EMPTY_NAME_TEXT);
	JTextField txtPhone = new JTextField(EMPTY_PHONE_TEXT);
	JTextField txtEmail = new JTextField(EMPTY_EMAIL_TEXT);
	JRadioButton rbF = new JRadioButton("F");
	JRadioButton rbM = new JRadioButton("M");
	JRadioButton rbNot = new JRadioButton("Not specified", true);
	JCheckBox chkDance = new JCheckBox("Dancing");
	JCheckBox chkRead = new JCheckBox("Reading");
	JCheckBox chkSwim = new JCheckBox("Swimming");
	String[] hometowns = {"Other", "Siirt", "Aydin", "Istanbul", "Mugla", "Giresun"};
	
	JComboBox cmbHometown = new JComboBox(hometowns);
	JComboBox cmbJobs = new JComboBox(new String[] {"other", "education", "health", "community"});
	JLabel lblJob = new JLabel("<icon here>");
	
	JButton btnClear = new JButton("CLEAR");
	JButton btnSubmit = new JButton("SUBMIT");
	
	DefaultListModel<Person> dlm = new DefaultListModel<Person>();
	int index = -1;
	
	public AddContact()
	{

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(300, 600);
		//setLocation(500, 300);
		setLocationRelativeTo(null);
		setTitle("Add New Contact");
		setLayout(new GridLayout(8, 2));
		
		JPanel pnlGender = new JPanel();
		pnlGender.setLayout(new FlowLayout());
		pnlGender.add(rbF); pnlGender.add(rbM); pnlGender.add(rbNot);
		
		JPanel pnlHobbies = new JPanel(new FlowLayout());
		//pnlHobbies.setLayout(new FlowLayout());
		pnlHobbies.add(chkDance); pnlHobbies.add(chkRead); pnlHobbies.add(chkSwim); 
		
		add(new JLabel("NAME:"));
		add(txtName);
		add(new JLabel("PHONE:"));
		add(txtPhone);
		add(new JLabel("EMAIL:"));
		add(txtEmail);
		add(new JLabel("GENDER: "));
		add(pnlGender);
		add(new JLabel("HOBBIES: "));
		add(pnlHobbies);
		add(new JLabel("HOMETOWN: "));
		add(cmbHometown);
		add(new JLabel("OCCUPATION: "));
		
		JPanel pnlJob = new JPanel(new FlowLayout());
		pnlJob.add(lblJob); pnlJob.add(cmbJobs);
		add(pnlJob);
		
		add(btnClear);
		add(btnSubmit);
		
		pack();
		
		ButtonGroup btnGenderGroup = new ButtonGroup();
		btnGenderGroup.add(rbF);
		btnGenderGroup.add(rbM);
		btnGenderGroup.add(rbNot);
		
		btnClear.addMouseListener(this);
		btnSubmit.addMouseListener(this);
		addWindowListener(this);
		txtName.addFocusListener(this);
		txtPhone.addFocusListener(this);
		txtEmail.addFocusListener(this);
		
		cmbJobs.addActionListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnClear)
		{
			Clear();
		}
		else if(e.getSource() == btnSubmit)
		{
				//submit the person to the dlm of the other page
//			PhoneBook pb = new PhoneBook();
//			pb.setVisible(true);
//			pb.dlm.addElement(new Person());
			
				
			
			Person p = new Person();
			p.name = txtName.getText();
			p.email = txtEmail.getText();
			p.phone = txtPhone.getText();
			if(rbF.isSelected())
				p.gender = "F";
			else if(rbM.isSelected())
				p.gender = "M";
			else
				p.gender = "not";
			
			p.hometown = cmbHometown.getSelectedItem().toString();
			p.job = cmbJobs.getSelectedItem() + "";
			if(chkDance.isSelected())
				p.hobbies.add(chkDance.getText());
			if(chkRead.isSelected())
				p.hobbies.add(chkRead.getText());
			if(chkSwim.isSelected())
				p.hobbies.add(chkSwim.getText());
			
			if(index == -1) {
				dlm.addElement(p);
				JOptionPane.showMessageDialog(null, "New Person Added");
				setVisible(false);
				
				}
			
			else
			{
				dlm.remove(index);
				dlm.add(index, p);
				JOptionPane.showMessageDialog(null, "Person Updated");
				setVisible(false);
				

				
			}
		}
	}
	
	public void Clear()
	{
		txtName.setText(EMPTY_NAME_TEXT);
		txtPhone.setText(EMPTY_PHONE_TEXT);
		txtEmail.setText(EMPTY_EMAIL_TEXT);
		
		rbNot.setSelected(true);
		
		chkDance.setSelected(false);
		chkRead.setSelected(false);
		chkSwim.setSelected(false);
		//cmbHometown.setSelectedItem("other");
		cmbHometown.setSelectedIndex(0);
		cmbJobs.setSelectedIndex(0);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

		Clear();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==txtName && txtName.getText().equals(EMPTY_NAME_TEXT)) {
			txtName.setText(" ");
		}
		if(e.getSource()==txtPhone && txtPhone.getText().equals(EMPTY_PHONE_TEXT)) {
			txtPhone.setText(" ");
		}
		if(e.getSource()==txtEmail && txtEmail.getText().equals(EMPTY_EMAIL_TEXT)) {
			txtEmail.setText(" ");
		}


	}


	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==txtName && txtName.getText().isBlank()) {
			txtName.setText(EMPTY_NAME_TEXT);
		}
		if(e.getSource()==txtPhone && txtPhone.getText().isBlank()) {
			txtPhone.setText(EMPTY_PHONE_TEXT);
		}
		if(e.getSource()==txtEmail && txtEmail.getText().isBlank()) {
			txtEmail.setText(EMPTY_EMAIL_TEXT);
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		lblJob.setIcon(new ImageIcon("file name"));
	}
}