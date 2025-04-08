package bank.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; //ResultSet in SQL Package 
import java.util.Date; //Date class in UTIL Package

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balance,back;
	String pinnumber;
	
	//Constructor
	FastCash(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		
		//Set ATM Image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		//for headline- Select amount
		JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(170,230,600,30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		// 1-button for Rs100/-
		 deposit=new JButton("Rs 100");
		deposit.setBounds(150,325,110,20);
		deposit.addActionListener(this);
		image.add(deposit);
		
		// 2-button for Rs500/-
		 withdrawl=new JButton("Rs 500");
		withdrawl.setBounds(320,325,130,20);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		// 3-button for Rs1000/-
		 fastcash=new JButton("Rs 1000");
		fastcash.setBounds(150,350,110,20);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		// 4-button for Rs2000/-
		 ministatement=new JButton("Rs 2000");
		ministatement.setBounds(320,350,130,20);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		// 5-button for Rs5000/-
		 pinchange=new JButton("Rs 5000");
		pinchange.setBounds(150,375,110,20);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		// 6-button for Rs10,000/-
		 balance=new JButton("Rs 10,000");
		balance.setBounds(320,375,130,20);
		balance.addActionListener(this);
		image.add(balance);
		
		// 7-button for Exit
		 back=new JButton("Back");
		back.setBounds(320,400,130,20);
		back.addActionListener(this);
		image.add(back);
				
				
		setSize(800,700);
		setLocation(250,0);
	    setUndecorated(true);  //Upper bar delete
		setVisible(true);
	}
	
	//Override ActionPerformed Class
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}else {
			//take button access TypeCast for JButton
			String amount =((JButton)ae.getSource()).getText().substring(3); // RS 500 ->500
			//MAKE CONNECTION
			Conn c=new Conn();
			try {
				//Pick all Values who PIN Number Match This
				ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
				//TO Find User Balance
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance+=Integer.parseInt(rs.getString("amount"));
					}else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}
				}
		       //Check balance is available or not 
				if(ae.getSource()!=back && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null,"Insufficient Balance");
					return;
				} 
						
				Date date=new Date();
				
				String query="insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");

				setVisible(false);
				new Transactions(pinnumber).setVisible(true);	
				
			}catch(Exception e) {
				System.out.println(e);
			}	
		}
	}
	
	public static void main(String[] args) {
		new FastCash("");
	}
}
