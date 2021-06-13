package Frame;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import controller.Employeecontroller;
import controller.Jobcontroller;
import controller.Skillcontroller;

public class HRAHome extends JFrame {
	Container container=null;
	 JButton bSetActive,bSetActiveJob,bSetDeactive,bSetDeactiveJob,bViewAllEmp,bViewJob,bViewSelectEmp,bAddSkill,bViewSkill,bSetActiveSkill,bSetDeactiveSkill,bLogout;
	 JLabel lTitle,lEmpId;
	 JTextField tEmpId,tData;
	 JFrame f;
	 
	 Employeecontroller empController=null;
	 Jobcontroller jobController=null;
	 Skillcontroller skillController=null;
	 
	 public HRAHome() throws ClassNotFoundException,SQLException {
		 container=getContentPane();
		 empController=new Employeecontroller();
		 jobController=new Jobcontroller();
		 skillController=new Skillcontroller();
		 lTitle=new JLabel("Welcome to HRA Portal");
		 tEmpId=new JTextField();
		 
		 
		 bSetActive=new JButton("Active Users");
		 bSetActive.setFont(new Font("Serif", Font.PLAIN, 15));
		 bSetActive.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 try {
					new ActivateEmp();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			 }
		 });
		 
		 
		 bSetDeactive=new JButton("Deactivate Employee");
		 bSetDeactive.setFont(new Font("Serif", Font.PLAIN, 15));
			bSetDeactive.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new DeactivateEmp();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}	
			});
			 
			bViewAllEmp=new JButton("View all Employees");
			bViewAllEmp.setFont(new Font("Serif", Font.PLAIN, 15));
			bViewAllEmp.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
						try {
							new AllEmployee();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					
				}
			});
	
			
			bViewSelectEmp=new JButton("View Employees By Id");
			bViewSelectEmp.setFont(new Font("Serif", Font.PLAIN, 15));
			bViewSelectEmp.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							
							new EmployeeId();
						
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
				}	
			});
			
			bViewSkill=new JButton("View all Skills");
			bViewSkill.setFont(new Font("Serif", Font.PLAIN, 15));
			bViewSkill.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new	AllSkill();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}	
			});
			
			bSetDeactiveSkill=new JButton("Deactivate Skill");
			bSetDeactiveSkill.setFont(new Font("Serif", Font.PLAIN, 15));
			bSetDeactiveSkill.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							new DeactivateSkill();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
				}	
			});
			
			bSetActiveSkill=new JButton("Activate Skill");
			bSetActiveSkill.setFont(new Font("Serif", Font.PLAIN, 15));
			bSetActiveSkill.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							new ActivateSkill();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					
				}	
			});
			
			bViewJob=new JButton("View all Jobs");
			bViewJob.setFont(new Font("Serif", Font.PLAIN, 15));
			bViewJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					//jobController.getAllJobs();
					try {
						new AllJobs();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				//	skillController.getAllSkills();
					
				}	
			});
			
			bSetDeactiveJob=new JButton("Deactivate Job");
			bSetDeactiveJob.setFont(new Font("Serif", Font.PLAIN, 15));
			bSetDeactiveJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
							try {
								new DeactivateJob();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
				}	
			});
			
			
			bSetActiveJob=new JButton("Activate Job");
			bSetActiveJob.setFont(new Font("Serif", Font.PLAIN, 15));
			bSetActiveJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							new ActivateJob();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}	
				}	
			});
			
			
			bLogout=new JButton("Logout");
			bLogout.setFont(new Font("Serif", Font.PLAIN, 15));
			bLogout.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
				
					Logout();
				}	
			});
			
			
		 
		 setLayoutManager();
		 setLocationAndSize();
		 addComponentsToContainer();
		 
		 this.setTitle("HRA Frame");
		 this.setVisible(true);
		 this.setBounds(10, 10, 500, 800);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
	 }
	 public void Logout(){
			this.dispose();
		}

	 
	 public void setLayoutManager() {
		    container.setLayout(null);
	 }
	 public void setLocationAndSize() {
		    lTitle.setBounds(49, 33, 500, 60);
			lTitle.setFont(getFont());
			bViewAllEmp.setBounds(160,92,200,30);
			bSetActive.setBounds(160,191,200,30);
			bSetDeactive.setBounds(160,141,200,30);
			bViewSelectEmp.setBounds(160,241,200,30);
			bViewSkill.setBounds(160,291,200,30);
			bSetDeactiveSkill.setBounds(160,341,200,30);
			bSetActiveSkill.setBounds(160,391,200,30);
			bViewJob.setBounds(160,441,200,30);
			bSetDeactiveJob.setBounds(160,491,200,30);
			bSetActiveJob.setBounds(160,541,200,30);
			bLogout.setBounds(160,591,200,30);
	 }
	 public void addComponentsToContainer() {
		    container.add(lTitle);
		    container.add(bSetActive);
		    container.add(bSetDeactive);	
			container.add(bViewAllEmp);	
			container.add(bViewSelectEmp);
			container.add(bViewSkill);	
			container.add(bSetDeactiveSkill);
			container.add(bSetActiveSkill);
			container.add(bViewJob);	
			container.add(bSetDeactiveJob);
			container.add(bSetActiveJob);
			container.add(bLogout);	
	 }

}
