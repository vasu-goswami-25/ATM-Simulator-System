package bank.management.system;

import javax.swing.*; //JFrame
import java.awt.*; //Image
import java.awt.event.*; //actionListener
import java.sql.*; //ResultSet

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String pinnumber; 
	
	BalanceEnquiry(String pinnumber){
		this.pinnumber=pinnumber; //Local To Global Declaration
		setLayout(null);
		
		//For ATM Image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		
		//Back Button
		back=new JButton("Back");
		back.setBounds(320,405,130,25);
		back.addActionListener(this);
		image.add(back);
		
		
		Conn c=new Conn();
		int balance=0;
		try {
			//Pick all Values who PIN Number Match This
			ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			//TO Find User Balance
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
				}else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		//Show Your Balance	
		JLabel text=new JLabel("Your Current Balance is Rs: "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(150,240,300,30);
		image.add(text);
		
		//For Frame
		setSize(800,700);
		setLocation(250,0);
		setUndecorated(true);
		setVisible(true);	
	}
	
	//@Override the Function
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

}
