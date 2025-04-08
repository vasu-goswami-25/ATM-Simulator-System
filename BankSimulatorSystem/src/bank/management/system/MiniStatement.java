package bank.management.system;

import javax.swing.*; //JFrame
import java.awt.*; //Color class
import java.sql.*; //ResultSet in SQL Package

public class MiniStatement extends JFrame{
	
	MiniStatement(String pinnumber){
		
		setTitle("Mini Statement"); //Frame Title
		setLayout(null);
		
		JLabel mini=new JLabel();
		add(mini);
		
		//Indian Bank
		JLabel bank=new JLabel("Indian Bank");
		bank.setBounds(130,20,100,20);
		add(bank);
		
		//Card Number Show
		JLabel card=new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance=new JLabel();
		balance.setBounds(20,300,250,20);
		add(balance);
		
		//Display Card Number
		try {
			Conn conn=new Conn(); //Connection with DB
			ResultSet rs=conn.s.executeQuery("select *from login where pin= '"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		//Display All Transaction
		try {
			Conn conn=new Conn();
			int bal=0;
			ResultSet rs=conn.s.executeQuery("select *from bank where pin= '"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+ "<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
				if(rs.getString("type").equals("Deposit")) {
					bal+=Integer.parseInt(rs.getString("amount"));
				}else {
					bal-=Integer.parseInt(rs.getString("amount"));
				}
			}	
			balance.setText("Your current account balance is Rs: "+bal);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		mini.setBounds(20,100,400,200);
		
		//Frame
		setSize(350,500);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);	
	}
	
	
	public static void main(String[] args) {
		new MiniStatement("");	
	}

}
