package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import controller.Jobcontroller;

public class ActivateJob extends JFrame{
	Container container;
	JFrame f;
	JLabel lJobId;
	JTextField tJobId;
	JButton bActivate;
	Jobcontroller jobController=null;
	
	public ActivateJob() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lJobId=new JLabel("ENTER the Job ID");
		lJobId.setFont(new Font("Serif", Font.PLAIN, 15));
		tJobId=new JTextField();
		bActivate=new JButton("Activate");
		bActivate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jobController=new Jobcontroller();
		
		bActivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(tJobId.getText());
				jobController.activateJob(s);
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Activate Job");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	

	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lJobId.setBounds(30, 150, 300, 30);
		tJobId.setBounds(200, 150, 150, 30);
		bActivate.setBounds(200, 250, 100, 30);
	}

	private void addComponentsToContainer() {
		container.add(lJobId);
		container.add(tJobId);
		container.add(bActivate);
	}


}
