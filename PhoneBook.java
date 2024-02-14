package oop8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PhoneBook extends JFrame implements MouseListener
{
	JButton btnAdd = new JButton("ADD");
	JButton btnEdit = new JButton("EDIT");
	JButton btnDelete = new JButton("DELETE");
	JButton btnClear = new JButton("CLEAR");
	JButton btnSearch = new JButton("SEARCH");
	JButton btnSort = new JButton("SORT");
	
	DefaultListModel<Person> dlm = new DefaultListModel<>();
	JList<Person> list = new JList<>(dlm);
	JScrollPane sp = new JScrollPane(list);
	
	public PhoneBook()
	{
		setTitle("All Contacts");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pnl = new JPanel(new GridLayout(2, 3));
		pnl.add(btnAdd);
		pnl.add(btnEdit);
		pnl.add(btnDelete);
		pnl.add(btnClear);
		pnl.add(btnSearch);
		pnl.add(btnSort);
		
		add(pnl, BorderLayout.SOUTH);
		add(sp, BorderLayout.CENTER);
		
		//pack();
		setSize(300, 500);
		setLocationRelativeTo(null);
		//dlm.addElement(new Person());
//		dlm.addElement("ece");
//		dlm.addElement("alperen");
//		dlm.add(0, "harun");
//		dlm.add(0, "ugur");
//		for (int i = 6; i < 100; i++) {
//			dlm.addElement("person #" + i);
//		}
//		
		
		btnAdd.addMouseListener(this);
		btnEdit.addMouseListener(this);
		btnDelete.addMouseListener(this);
		btnClear.addMouseListener(this);
		btnSearch.addMouseListener(this);
		btnSort.addMouseListener(this);
	}
	public static void main(String[] args) {
		new PhoneBook().setVisible(true);
	}
	
	AddContact ac = new AddContact();
	Search sc= new Search();
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnAdd)
		{
			ac.Clear();
			ac.dlm = this.dlm;
			ac.index = -1;
			ac.setVisible(true);
		}
		else if(e.getSource() == btnEdit)
		{
			ac.Clear();
			ac.setVisible(true);
			ac.dlm = this.dlm;
			ac.index = list.getSelectedIndex();
			
			if(list.getSelectedIndex() == -1) return;
			
			Person p = list.getSelectedValue();
			ac.txtName.setText(p.name);
			ac.txtEmail.setText(p.email);
			ac.txtPhone.setText(p.phone);
			ac.cmbHometown.setSelectedItem(p.hometown);
			ac.cmbJobs.setSelectedItem(p.job);
			ac.rbF.setSelected(p.gender.equals("F"));
			ac.rbM.setSelected(p.gender.equals("M"));
			ac.rbNot.setSelected(p.gender.equals("not"));
			for (int i = 0; i < p.hobbies.size(); i++) 
			{
				if(p.hobbies.get(i).equals(ac.chkDance.getText()))
					ac.chkDance.setSelected(true);
				if(p.hobbies.get(i).equals(ac.chkRead.getText()))
					ac.chkRead.setSelected(true);
				if(p.hobbies.get(i).equals("Swimming"))
					ac.chkSwim.setSelected(true);
			}
			
			
 			//String line = list.getSelectedValue().toString();
			//ac.txtName.setText(line);
		}
		else if(e.getSource() == btnClear)
		{
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Sure?", JOptionPane.OK_CANCEL_OPTION);
			if(result == JOptionPane.OK_OPTION)
				dlm.clear();
		}
		else if(e.getSource() == btnDelete)
		{
			do {
				dlm.remove(list.getSelectedIndex());
				
			}while (list.getSelectedIndex() !=-1);
			/*if(list.getSelectedIndex() != -1)
			{
				dlm.remove(list.getSelectedIndex());
				//try to implement multiple selection
			}
		*/
		}
		else if (e.getSource() == btnSearch )
		{
			sc.Clear();
			sc.setVisible(true);
			
				sc.dlm = this.dlm;
			
			
		}
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
}