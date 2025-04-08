package bank.management.system;

import javax.swing.*; //for extends JFrame
import java.awt.*;    //Image class in AWT Package
import java.awt.event.*; //for actionListener
import java.util.*;  //Date Class in Util's Package

public class Withdrawl extends JFrame implements ActionListener{
	//Global Variable Declaration
	JTextField amount;
	JButton withdraw,back;
	String pinnumber;
	
	Withdrawl(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		
		//Set ATM Image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image =new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		//for Statement Enter Amount
		JLabel text=new JLabel("Enter Amount you want to Withdrawl");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,230,300,30);
		image.add(text);
		
		//Enter the Amount
		 amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,20));
		amount.setBounds(170,290,250,20);
		image.add(amount);
		
		//Withdraw Button
		withdraw=new JButton("Withdraw");
		withdraw.setBounds(320,375,130,20);
		withdraw.addActionListener(this);
		image.add(withdraw);  
		
		//Back Button
		 back=new JButton("Back");
		back.setBounds(320,400,130,20);
		back.addActionListener(this);
		image.add(back);  
		
		//Made Frame
		setSize(800,700);
		setLocation(250,0);
		setVisible(true);
	}
	
	//ActionPerformend Declaration
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==withdraw) {
			String number=amount.getText();
			Date date=new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
			}else {
				try {
					Conn conn=new Conn();
					String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Withdrawl("");
	}

}
