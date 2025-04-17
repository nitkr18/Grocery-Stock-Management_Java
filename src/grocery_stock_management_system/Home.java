package grocery_stock_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton order, add, update, remove;
    
    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("Grocery Stock Management System");
        heading.setBounds(50, 30, 1000, 80);
        heading.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 50));
        image.add(heading);
        
        add = new JButton("Add new Item");
        add.setBounds(70, 150, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        order = new JButton("Order");
        order.setBounds(270, 150, 150, 40);
        order.addActionListener(this);
        image.add(order);
        
        update = new JButton("Inventory");
        update.setBounds(70, 240, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Delete Item");
        remove.setBounds(270, 240, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add ) {
            setVisible(false);
            new ManageProduct();
        } else if (ae.getSource() == order) {
            setVisible(false);
            new Order();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new Inventory();
        } else {
            setVisible(false);
            new RemoveProduct();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
