package Frame;
import Frame.ViewProfile;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import config.Jdbcconnection;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class UpdateProfile extends JFrame{
	JFrame frame;
	Container container;
	JLabel lEmployeeId,lFirstname,lLastname,lGender,lRole,lActive,lpass,lconfpass;
	JTextField tEmployeeId,tFirstname,tLastname,tGender,tRole,tActive,tpass,tconfpass;
	JButton bUpdate;
	
	public UpdateProfile (int s) throws ClassNotFoundException, SQLException {
	
		
		Connection conn=Jdbcconnection.getDBConnection();
		container=getContentPane();
		getContentPane().setLayout(null);
		frame=new JFrame();   
		lEmployeeId=new JLabel("Employee ID");
		lEmployeeId.setFont(new Font("Serif", Font.PLAIN, 18));
		lFirstname=new JLabel("First Name");
		lFirstname.setFont(new Font("Serif", Font.PLAIN, 18));
		lLastname=new JLabel("Last Name");
		lLastname.setFont(new Font("Serif", Font.PLAIN, 18));
		lGender=new JLabel("Gender");
		lGender.setFont(new Font("Serif", Font.PLAIN, 18));
		lpass=new JLabel("pass");
		lpass.setFont(new Font("Serif", Font.PLAIN, 18));
		lconfpass=new JLabel("confpass");
		lconfpass.setFont(new Font("Serif", Font.PLAIN, 18));
		lRole=new JLabel("Role");
		lRole.setFont(new Font("Serif", Font.PLAIN, 18));
		lActive=new JLabel("Active");
		lActive.setFont(new Font("Serif", Font.PLAIN, 18));
		tEmployeeId=new JTextField();
		tFirstname=new JTextField();
		tLastname=new JTextField();
		tGender=new JTextField();
		tRole=new JTextField();
		tActive=new JTextField();
		tpass=new JTextField();
		tconfpass=new JTextField();
		bUpdate=new JButton("Update");
		bUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		PreparedStatement pst=conn.prepareStatement("select * from Employee where empId=?");
		pst.setInt(1,s);
		ResultSet rst=pst.executeQuery();
		while(rst.next())
		{
		    int a = rst.getInt("empId");
		    String b = rst.getString("FirstName");
		    String c = rst.getString("LastName");
		    String d = rst.getString("Role");
		    String e = rst.getString("Gender");
		    String f = rst.getString("Active");
		    tEmployeeId.setText(String.valueOf(a));
		    tFirstname.setText(b);
		    tLastname.setText(c);
		    tGender.setText(d);
		    tRole.setText(e);
		    tActive.setText(f);
		    container.setLayout(null);
		    setLocationAndSize();
		    addComponentsToContainer();
		    this.setVisible(true);
		    this.setBounds(350,50,770,781);
		    this.setResizable(true);
		    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("Your Profile");
		}
bUpdate.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
			
			
				try {
			
					PreparedStatement pst=conn.prepareStatement("update Employee set FirstName=?, LastName=?, Password=? where empId=?");
					pst.setString(1,tFirstname.getText());
					pst.setString(2,tLastname.getText());
					pst.setString(3,tpass.getText());
					pst.setInt(4,s);
					int i=pst.executeUpdate();
					JFrame g=new JFrame();
					if(i==1) {
						//System.out.println("1 Record Updated...");
						JOptionPane.showConfirmDialog(g, "updated ");
					}
					else {
						//System.out.println("Record Updation Failed...");
						JOptionPane.showConfirmDialog(g, "Failed...");
						}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
	}
	private void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(lFirstname);
		container.add(tFirstname);
		container.add(lLastname);
		container.add(tLastname);
		container.add(lGender);
		container.add(tGender);
		container.add(lRole);
		container.add(tRole);
		container.add(lActive);
		container.add(tActive);
		container.add(bUpdate);
		container.add(lpass);
		container.add(lconfpass);
		container.add(tpass);
		container.add(tconfpass);
	}
	private void setLocationAndSize() {
		lEmployeeId.setBounds(170, 100, 100, 30);
		lFirstname.setBounds(170, 150, 100, 30);
		lLastname.setBounds (170, 200, 100, 30);
		lGender.setBounds   (170, 250, 100, 30);
		lRole.setBounds		(170, 300, 100, 30);
		lActive.setBounds	(170, 350, 100, 30);
		lpass.setBounds		(170, 400, 100, 30);
		lconfpass.setBounds	(170, 450, 100, 30);
		
		tEmployeeId.setBounds	(440, 100, 150, 30);
		tFirstname.setBounds	(440, 150, 150, 30);
		tLastname.setBounds		(440, 200, 150, 30);
		tGender.setBounds		(440, 300, 150, 30);
		tRole.setBounds			(440, 250, 150, 30);
		tActive.setBounds		(440, 350, 150, 30);
		tpass.setBounds			(440, 400, 150, 30);
		tconfpass.setBounds		(440, 450, 150, 30);
		
		
		bUpdate.setBounds(320, 550, 100, 30);
	}

	
}
