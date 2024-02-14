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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Search extends JFrame implements ActionListener, MouseListener, WindowListener, FocusListener
{
	public static final String EMPTY_NAME_TEXT = "< Enter Name >";
	JTextField txtName = new JTextField(EMPTY_NAME_TEXT);
	JButton btnSearch = new JButton("Search");
	DefaultListModel<Person> dlm = new DefaultListModel<Person>();
	JList<Person> list = new JList<>(dlm);
	int index = -1;
	AddContact ac = new AddContact();
	public Search() {
		setTitle("Search ?");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new GridLayout(1,3));
		setSize(300,100);
		setLocationRelativeTo(null);
		add(new JLabel ("Name:"));
		add(txtName);
		add (btnSearch);
		pack();
		btnSearch.addMouseListener(this);
		txtName.addFocusListener(this);
		
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==txtName && txtName.getText().equals(EMPTY_NAME_TEXT)) {
			txtName.setText(" ");
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==txtName && txtName.getText().isBlank()) {
			txtName.setText(EMPTY_NAME_TEXT);
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnSearch) {
			String value = txtName.getName();
			
			for (int i = 0; i < dlm.size(); i++) {
				
				/*do {
					JOptionPane.showMessageDialog(null, " "+dlm.elementAt(i).name+" "+dlm.elementAt(i).email+" "+dlm.elementAt(i).gender);
				} while (txtName.getText().equals(dlm.elementAt(i).name));
				*/
				if(txtName.getText().equals(dlm.elementAt(i).name)) {
					ac.dlm = this.dlm;
					ac.setVisible(true);
					
					ac.txtName.setText(dlm.elementAt(i).name);
					ac.txtEmail.setText(dlm.elementAt(i).email);
					ac.txtPhone.setText(dlm.elementAt(i).phone);
					ac.cmbHometown.setSelectedItem(dlm.elementAt(i).hometown);
					ac.cmbJobs.setSelectedItem(dlm.elementAt(i).job);
					ac.rbF.setSelected(dlm.elementAt(i).gender.equals("F"));
					ac.rbM.setSelected(dlm.elementAt(i).gender.equals("M"));
					ac.rbNot.setSelected(dlm.elementAt(i).gender.equals("not"));
					for (int a = 0; a < dlm.elementAt(i).hobbies.size(); a++) 
					{
						if(dlm.elementAt(i).hobbies.get(a).equals(ac.chkDance.getText()))
							ac.chkDance.setSelected(true);
						if(dlm.elementAt(i).hobbies.get(a).equals(ac.chkRead.getText()))
							ac.chkRead.setSelected(true);
						if(dlm.elementAt(i).hobbies.get(a).equals("Swimming"))
							ac.chkSwim.setSelected(true);
					}
					
					
					JOptionPane.showMessageDialog(null, " "+dlm.elementAt(i).name+" "+dlm.elementAt(i).email+" "+dlm.elementAt(i).gender);
					dlm.remove(i);
					setVisible(false);
				}
				/*else
					JOptionPane.showMessageDialog(null, "Sonuç Bulunamadý!");
			*/
				
			}
			
			//setVisible(false);
			
		}
		// TODO Auto-generated method stub
		
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void Clear() {
		txtName.setText(EMPTY_NAME_TEXT);
		// TODO Auto-generated method stub
		
	}

}
