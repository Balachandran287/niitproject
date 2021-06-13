package Frame;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import config.Jdbcconnection;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class ViewProfile extends JFrame{
	
	private static JFrame f;
	Container container;
	JLabel lEmployeeId,lFirstname,lLastname,lGender,lRole,lActive;
	JTextField tEmployeeId,tFirstname,tLastname,tGender,tRole,tActive;
	
	public ViewProfile (int s) throws ClassNotFoundException, SQLException {
		getContentPane().setBackground(Color.PINK);
		
		Connection conn=Jdbcconnection.getDBConnection();
		container=getContentPane();
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 780, 86);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblProfile.setBounds(308, 32, 240, 30);
		panel.add(lblProfile);
		f=new JFrame();   
		lEmployeeId=new JLabel("Employee ID");
		lFirstname=new JLabel("First Name");
		lLastname=new JLabel("Last Name");
		lGender=new JLabel("Gender");
		lRole=new JLabel("Role");
		lActive=new JLabel("Active");
		tEmployeeId=new JTextField();
		tFirstname=new JTextField();
		tLastname=new JTextField();
		tGender=new JTextField();
		tRole=new JTextField();
		tActive=new JTextField();
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
			lEmployeeId.setBounds(150, 100, 100, 30);
			lEmployeeId.setFont(new Font("Serif", Font.PLAIN, 18));
			lFirstname.setBounds(150, 150, 100, 30);
			lFirstname.setFont(new Font("Serif", Font.PLAIN, 18));
			lLastname.setBounds(150, 200, 100, 30);
			lLastname.setFont(new Font("Serif", Font.PLAIN, 18));
			lGender.setBounds(150, 250, 100, 30);
			lGender.setFont(new Font("Serif", Font.PLAIN, 18));
			lRole.setBounds(150,300,200,30);
			lRole.setFont(new Font("Serif", Font.PLAIN, 18));
			lActive.setBounds(150, 350, 100, 30);
			lActive.setFont(new Font("Serif", Font.PLAIN, 18));
			
			tEmployeeId.setBounds(400, 100, 250, 30);
			tFirstname.setBounds(400,150,250,30);
			tLastname.setBounds(400, 200, 250, 30);
			tGender.setBounds(400,250,250,30);
			tRole.setBounds(400,300,250,30);
			tActive.setBounds(400, 350, 250, 30);
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
		    this.setVisible(true);
		    this.setBounds(350,50,770,781);
		    this.setResizable(false);
		    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("Your Profile");
		}
	}
	
}
