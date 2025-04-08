package bank.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	//Global Declaration from Remove Local 
	
	JTextField Pan,aadhar;
	JRadioButton sYes,sNo,eYes,eNo;
	JComboBox religion,category,occupation,education,income;
	String formno;
	
	SignupTwo(String formno){
		this.formno=formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		//Display Page 1
		JLabel additionalDetails=new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290,40,400,30);
		add(additionalDetails);
		
		//RELIGION
		JLabel name=new JLabel("Religion: ");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		//For choose Religion
		String valReligion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
		religion=new JComboBox(valReligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		//CATEGORY
		JLabel fname=new JLabel("Category: ");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,180,200,30);
		add(fname);
		//For choose Category
		String valcategory[]= {"General","OBC","SC","ST","Other"};
		category=new JComboBox(valcategory);
		category.setBounds(300,180,400,30);
		category.setBackground(Color.WHITE);
		add(category);
		
		//INCOME
		JLabel dob=new JLabel("Income: ");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,220,200,30);
		add(dob);
		//For choose Income
		String valincome[]= {"Null","<1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
		income=new JComboBox(valincome);
		income.setBounds(300,220,400,30);
		income.setBackground(Color.WHITE);
		add(income);
		
		//EDUCATIONAL
		JLabel gender=new JLabel("Educational: ");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,260,200,30);
		add(gender);	
		//QUALIFICATION
		JLabel email=new JLabel("Qualification: ");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,280,200,30);
		add(email);
		//For choose Education
		String valeducation[]= {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
		education=new JComboBox(valeducation);
		education.setBounds(300,280,400,30);
		education.setBackground(Color.WHITE);
		add(education);
		
		//OCCUPATIONAL
		JLabel status=new JLabel("Occupational: ");
		status.setFont(new Font("Raleway",Font.BOLD,20));
		status.setBounds(100,340,200,30);
		add(status);
		//For choose Occupation
		String valoccupation[]= {"Salaried","Self-Employeed","Student","Bussinessman","Retired","Other"};
		occupation=new JComboBox(valoccupation);
		occupation.setBounds(300,340,400,30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		//PAN NUMBER
		JLabel address=new JLabel("PAN Number: ");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,380,200,30);
		add(address);
		
		Pan=new JTextField();
		Pan.setFont(new Font("Raleway",Font.BOLD,14));
		Pan.setBounds(300,380,400,30);
		add(Pan);
		
		//AADHAR NUMBER
		JLabel city=new JLabel("Aadhar Number: ");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,420,200,30);
		add(city);
		
		aadhar=new JTextField();
		aadhar.setFont(new Font("Raleway",Font.BOLD,14));
		aadhar.setBounds(300,420,400,30);
		add(aadhar);
		
		//SENIOR CITIZEN
		JLabel seniorcitizen=new JLabel("Senior Citizen: ");
		seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
		seniorcitizen.setBounds(100,460,200,30);
		add(seniorcitizen);
				
		//Radio button for Yes
		sYes=new JRadioButton("Yes");
		sYes.setBounds(300,460,60,30);
		sYes.setBackground(Color.WHITE);
		add(sYes);
		//Radio button for No
		sNo=new JRadioButton("No");
		sNo.setBounds(400,460,60,30);
		sNo.setBackground(Color.WHITE);
		add(sNo);
		//Select Only One Senior Citizen 
		ButtonGroup sgroup=new ButtonGroup();
		sgroup.add(sYes);
		sgroup.add(sNo);
		
				
		//EXISITING ACCOUNT
		JLabel exisitingaccount=new JLabel("Exisiting Account: ");
		exisitingaccount.setFont(new Font("Raleway",Font.BOLD,20));
		exisitingaccount.setBounds(100,500,200,30);
		add(exisitingaccount);
				
		//Radio button for Yes
		eYes=new JRadioButton("Yes");
		eYes.setBounds(300,500,60,30);
		eYes.setBackground(Color.WHITE);
		add(eYes);
		//Radio button for No
		eNo=new JRadioButton("No");
		eNo.setBounds(400,500,60,30);
		eNo.setBackground(Color.WHITE);
		add(eNo);
		//Select Only One Senior Citizen 
		ButtonGroup egroup=new ButtonGroup();
		egroup.add(sYes);
		egroup.add(sNo);
		
		
		//NEXT BUTTON
		JButton next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(630,550,70,20);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,650);
		setLocation(250,10);
		setVisible(true);
	}
	
	//Find Values who User give us
	public void actionPerformed(ActionEvent ae) {
	
		String sreligion=(String) religion.getSelectedItem();
		String scategory=(String) category.getSelectedItem();
		String sincome=(String) income.getSelectedItem();
		String seducation=(String) education.getSelectedItem();
		String soccupation=(String) occupation.getSelectedItem();
		
		String seniorcitizen=null;
		if(sYes.isSelected()) {
			seniorcitizen="Yes";
		}else if(sNo.isSelected()) {
			seniorcitizen="No";
		}
		
		String exisitingaccount=null;
		if(sYes.isSelected()) {
			exisitingaccount="Yes";
		}else if(sNo.isSelected()) {
			exisitingaccount="No";
		}
		
		String sPan=Pan.getText();
		String saadhar=aadhar.getText();
		
		//Show POP-UP (If not fill the name) 
		try {
				Conn c=new Conn();
				//MYSQL QUERY(Data fill into new table)
				String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+exisitingaccount+"','"+sPan+"','"+saadhar+"')";
				c.s.executeUpdate(query);
				
				//SignupThree Object
				setVisible(false);
				new SignupThree(formno).setVisible(true); 
				
	}catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void main(String[] args) {
		new SignupTwo("");
	}
}
