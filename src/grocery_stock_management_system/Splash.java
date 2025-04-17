package grocery_stock_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    Splash() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 650, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 650);
        add(image);
        
        
        JLabel heading = new JLabel("Grocery Stock Management System");
        heading.setBounds(150, 30, 1000, 60);
        heading.setFont(new Font("Raleway", Font.BOLD, 50));
        heading.setForeground(Color.white);
        image.add(heading);
        
        
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 500, 300, 70);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        
        setSize(1120, 650);
        setLocation(200, 50);
        setVisible(true);
        
       
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}
