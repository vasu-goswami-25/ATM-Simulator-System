package bank.management.system;

import javax.swing.*; //JFrame in swing package
import java.awt.*;  //image class in AWT package
import java.awt.event.*; //for actionListener 

public class PinChange extends JFrame implements ActionListener{
	
	//Local To Global Declaration
	JPasswordField pin,repin;
	JButton change,back;
	String pinnumber;
	
	PinChange(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		
		//For ATM Image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		//show headline-Change Pin
		JLabel text=new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(220,220,600,30);
		image.add(text);
		
		//New Pin
		JLabel pintext=new JLabel("New PIN:");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(145,250,300,30);
		image.add(pintext);
		
		//Text New Pin 
		 pin=new JPasswordField(); //Do not show pin to user at enter time 
		pin.setFont(new Font("System",Font.BOLD,18));
		pin.setBounds(300,255,150,20);
		image.add(pin);
		
		//Re-Enter New Pin
		JLabel repintext=new JLabel("Re-Enter New PIN:");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(145,280,500,30);
		image.add(repintext);
		
		//Text Re-New Pin 
		 repin=new JPasswordField(); //Do not show re-pin to user at enter time 
		repin.setFont(new Font("System",Font.BOLD,18));
		repin.setBounds(300,285,150,20);
		image.add(repin);
		
		//Change Button
		 change=new JButton("CHANGE");
		change.setBounds(320,375,130,25);
		change.addActionListener(this); //Action on Change Button
		image.add(change);
		
		//Back Button
		 back=new JButton("BACK");
		back.setBounds(320,405,130,25);
		back.addActionListener(this); //Action on Back Button
		image.add(back);
		
		//for Frame
		setSize(800,700);
		setLocation(250,0);
		setUndecorated(true); //for Upper bar clear
		setVisible(true);
		
	}
	
	//@Override ActionPerformed Function
	public void actionPerformed(ActionEvent ae) {
		//Exception Handling
		if(ae.getSource()==change) {
			try {
				String npin=pin.getText();
				String rpin=repin.getText();
				
				//If new pin not equal to Re-Pin
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null,"Entered PIN Does not match");
					return;
				}	
				
				//If new Pin is Empty
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter new PIN");
					return;
				}
				
				//If Re-Pin is Empty
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter re-PIN");
					return;
				}
				
				//Database Connection
				Conn conn=new Conn();
				//for in all table same PinNumber Change pin(Table-bank/login/signup3)
				String query1="update bank set pin= '"+rpin+"' where pin='"+pinnumber+"'";
				String query2="update login set pin= '"+rpin+"' where pin='"+pinnumber+"'";
				String query3="update signupthree set pin= '"+rpin+"' where pin='"+pinnumber+"'";
				
				//Execute Query(DML Command)
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				JOptionPane.showMessageDialog(null,"PIN Changed Succcessfully");
				
				setVisible(false);
				new Transactions(rpin).setVisible(true);
				
		}catch(Exception e) {
			System.out.println(e);
		}
	  } else {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
}
	
	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}
}
