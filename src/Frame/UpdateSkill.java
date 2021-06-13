package Frame;
import Frame.ViewProfile;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.Jdbcconnection;

import javax.swing.JButton;
import java.awt.Font;

public class UpdateSkill extends JFrame{
	JFrame frame;
	Container container;
	JLabel lEsId,lempId,lSkillId,lExpYear;
	JTextField tEsId,tempId,tSkillId,tExpYear;
	JButton bUpdate;
	
	
	public UpdateSkill (int l) throws ClassNotFoundException, SQLException {
	
		
		
		Connection conn=Jdbcconnection.getDBConnection();
		container=getContentPane();
		getContentPane().setLayout(null);
		frame=new JFrame();   
		lEsId=new JLabel("Emp Skill ID");
		lEsId.setFont(new Font("Serif", Font.PLAIN, 18));
		lempId=new JLabel("Emloyee Id");
		lempId.setFont(new Font("Serif", Font.PLAIN, 18));
		lSkillId=new JLabel("Skill Id");
		lSkillId.setFont(new Font("Serif", Font.PLAIN, 18));
		lExpYear=new JLabel("ExpYear");
		lExpYear.setFont(new Font("Serif", Font.PLAIN, 18));
		
		tEsId=new JTextField();
		tempId=new JTextField();
		tSkillId=new JTextField();
		tExpYear=new JTextField();
		
		bUpdate=new JButton("Update");
		bUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		PreparedStatement pst=conn.prepareStatement("select * from empskill where employeeId=?");
		pst.setInt(1,l);
		ResultSet rst=pst.executeQuery();
		  
		while(rst.next())
		{
		    int a = rst.getInt("EsId");
		    int b = rst.getInt("EmployeeId");
		    int c = rst.getInt("SkillId");
		    int d = rst.getInt("ExpYear");
		   
		    tEsId.setText(String.valueOf(a));
		    tempId.setText(String.valueOf(b));
		    tSkillId.setText(String.valueOf(c));
		    tExpYear.setText(String.valueOf(d));
		    container.setLayout(null);
		    setLocationAndSize();
		
		    addComponentsToContainer();
		   
		    this.setVisible(true);
		    this.setBounds(350,50,770,781);
		    this.setResizable(true);
		    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("Your skill Profile");
		 
		}
bUpdate.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
			
			
				try {
					int x=Integer.parseInt(tExpYear.getText());
					int y=Integer.parseInt(tempId.getText());
					
					
					PreparedStatement pst=conn.prepareStatement("update empskill set ExpYear=? where employeeId=?");
					pst.setInt(1,x);
					pst.setInt(2,y);
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
		container.add(lEsId);
		container.add(lempId);
		container.add(lSkillId);
		container.add(lExpYear);
		container.add(tEsId);
		container.add(tempId);
		container.add(tSkillId);
		container.add(tExpYear);
		container.add(bUpdate);
		
	}
	private void setLocationAndSize() {
		lEsId.setBounds		 (170, 100, 100, 30);
		lempId.setBounds	(170, 150, 100, 30);
		lSkillId.setBounds	 (170, 200, 100, 30);
		lExpYear.setBounds   (170, 250, 100, 30);
		
		
		tEsId.setBounds	   		 (440, 100, 150, 30);
		tempId.setBounds  		(440, 150, 150, 30);
		tSkillId.setBounds		(440, 200, 150, 30);
		tExpYear.setBounds		(440, 250, 150, 30);
		
		
		
		bUpdate.setBounds(320, 350, 100, 30);
		
	
	 
	}
}
