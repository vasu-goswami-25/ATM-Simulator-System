package bank.management.system;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
	//Global Declaration from Remove Local 
	long random;
	JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,pinTextField,stateTextField;
	JButton next;
	JRadioButton male,female,married,unmarried,other;
	JDateChooser dateChooser;
	
	
	SignupOne(){
		setLayout(null);
		//Generate random no
		Random ran=new Random();
		random=Math.abs((ran.nextLong()%9000L)+ 1000L);
		
		//Display Application form no
		JLabel formno=new JLabel("APPLICATION FORM NO."+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,30,600,40);
		add(formno);
		
		//Display Page 1
		JLabel personDetails=new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personDetails.setBounds(290,80,400,30);
		add(personDetails);
		
		//NAME
		JLabel name=new JLabel("Name: ");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		//For Text Into NAME
		nameTextField=new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		//FATHER NAME
		JLabel fname=new JLabel("Father's Name: ");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,180,200,30);
		add(fname);
		
		fnameTextField=new JTextField();
		fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		fnameTextField.setBounds(300,180,400,30);
		add(fnameTextField);
		
		//DOB
		JLabel dob=new JLabel("Date of Birth: ");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,220,200,30);
		add(dob);
		//Calendar for DOB
		dateChooser=new JDateChooser();
		dateChooser.setBounds(300,220,400,30);
		add(dateChooser);
		
		//GENDER
		JLabel gender=new JLabel("Gender: ");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,260,100,30);
		add(gender);
		//Radio Button for male
		male=new JRadioButton("Male");
		male.setBounds(300,260,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		//Radio Button for Female
		female=new JRadioButton("Female");
		female.setBounds(450,260,100,30);
		female.setBackground(Color.WHITE);
		add(female);
		//Select Only One gender 
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		//E-MAIL ADDRESS
		JLabel email=new JLabel("Email Address: ");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,300,200,30);
		add(email);
		
		emailTextField=new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextField.setBounds(300,300,400,30);
		add(emailTextField);
		
		//MARITAL STATUS
		JLabel status=new JLabel("Marital Status: ");
		status.setFont(new Font("Raleway",Font.BOLD,20));
		status.setBounds(100,340,200,30);
		add(status);
		//Radio button for Married
		married=new JRadioButton("Married");
		married.setBounds(300,340,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		//Radio button for Unmarried
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(450,340,100,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		//Radio button for Other
		other=new JRadioButton("Other");
		other.setBounds(630,340,60,30);
		other.setBackground(Color.WHITE);
		add(other);
		//Select Only One gender 
		ButtonGroup statusgroup=new ButtonGroup();
		statusgroup.add(married);
		statusgroup.add(unmarried);
		statusgroup.add(other);
		
		//ADDRESS
		JLabel address=new JLabel("Address: ");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,380,100,30);
		add(address);
		
		addressTextField=new JTextField();
		addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextField.setBounds(300,380,400,30);
		add(addressTextField);
		
		//CITY
		JLabel city=new JLabel("City: ");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,420,100,30);
		add(city);
		
		cityTextField=new JTextField();
		cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextField.setBounds(300,420,400,30);
		add(cityTextField);
		
		//STATE
		JLabel state=new JLabel("State: ");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,460,200,30);
		add(state);
		
		stateTextField=new JTextField();
		stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
		stateTextField.setBounds(300,460,400,30);
		add(stateTextField);
		
		//PIN CODE
		JLabel pin=new JLabel("Pin Code: ");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(100,500,100,30);
		add(pin);
				
		pinTextField=new JTextField();
		pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
		pinTextField.setBounds(300,500,400,30);
		add(pinTextField);
		
		//NEXT BUTTON
		next=new JButton("Next");
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
		String formno=""+random; //long
		String name=nameTextField.getText();
		String fname=fnameTextField.getText();
		String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}else if(female.isSelected()) {
			gender="Female";
		}
		String email=emailTextField.getText();
		
		String status=null;
		if(married.isSelected()) {
			status="Married";
		}else if(unmarried.isSelected()) {
			status="Unmarried";
		}else if(other.isSelected()) {
			status="Other";
		}
		String address=addressTextField.getText();
		String city=cityTextField.getText();
		String state=stateTextField.getText();
		String pin=pinTextField.getText();
		
		//Show POP-UP (If not fill the name) 
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is Required");
			}else if(fname.equals("")) {
				JOptionPane.showMessageDialog(null,"Father Name is Required");
			}else if(dob.equals("")) {
				JOptionPane.showMessageDialog(null,"DOB is Required");
			}else if(gender == null) {
				JOptionPane.showMessageDialog(null,"Gender is Required");
			}else if(email.equals("")) {
				JOptionPane.showMessageDialog(null,"Email is Required");
			}else if(status==null) {
				JOptionPane.showMessageDialog(null,"Maritial is Required");
			}else if(address.equals("")) {
				JOptionPane.showMessageDialog(null,"Address is Required");
			}else if(city.equals("")) {
				JOptionPane.showMessageDialog(null,"City is Required");
			}else if(pin.equals("")) {
				JOptionPane.showMessageDialog(null,"Pin Code is Required");
			}else if(state.equals("")) {
				JOptionPane.showMessageDialog(null,"State is Required");
			}else {
				Conn c=new Conn();
				//MYSQL QUERY
				String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+status+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				c.s.executeUpdate(query);
				//for open signupTwo tab to click on Next Button
				setVisible(false);
				new SignupTwo(formno).setVisible(true);

			}
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void main(String[] args) {
		new SignupOne();
	}
}
