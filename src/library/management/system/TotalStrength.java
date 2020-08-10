package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class TotalStrength extends JFrame implements ActionListener{


    private JPanel panel;
    private JButton b1,b2,b3;
    

    public static void main(String[] args) {
	new Forgot().setVisible(true);
    }

    public TotalStrength() {

        setLayout(null);
        setBackground(new Color(169, 169, 169));	
        setBounds(600, 300, 600, 400);
		
        panel = new JPanel();
	panel.setBackground(new Color(176, 224, 230)); //Every color is a combination of RGB
       
	setContentPane(panel); // its like a container div
	panel.setLayout(null); 
        
        JLabel l1 = new JLabel("Total Books");
	l1.setBounds(124, 89, 95, 24);
	panel.add(l1);
        
        JLabel l2 = new JLabel("Total Students");
	l2.setBounds(124, 129, 95, 24);
	panel.add(l2);
        
      b1 = new JButton("check");
	b1.addActionListener(this);
	b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b1.setBounds(250, 89, 95, 24);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	panel.add(b1);
        
        b3 = new JButton("check");
	b3.addActionListener(this);
	b3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b3.setBounds(250, 129, 95, 24);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	panel.add(b3);
        
       b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b2.setBounds(212, 300, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	
	panel.add(b2);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       
try {
    conn con = new conn(); //Creating obj of conn
    if(ae.getSource()== b1){
     String sql = "SELECT COUNT(*) FROM book";//sql query
       PreparedStatement st = con.c.prepareStatement(sql); 
      ResultSet r = st.executeQuery();
      r.next();
      int count = r.getInt(1) ;
      JOptionPane.showMessageDialog(null, "Total books are "+count);
      r.close() ;
    }
    if(ae.getSource()== b3){
     String sql = "SELECT COUNT(*) FROM student";//sql query
       PreparedStatement st = con.c.prepareStatement(sql); 
      ResultSet r = st.executeQuery();
      r.next();
      int count = r.getInt(1) ;
      JOptionPane.showMessageDialog(null, "Total students are "+count);
      r.close() ;
    }
    if(ae.getSource()== b2){
        this.setVisible(false);
	new Home().setVisible(true);
    }
   
} catch (Exception e) {
    e.printStackTrace();
} 
    }

}