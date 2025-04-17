package grocery_stock_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveProduct extends JFrame implements ActionListener {
    
    Choice cproductId;
    JButton delete, back;
    
    RemoveProduct() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Product Id");
        labelempId.setBounds(50, 50, 100, 30);
        labelempId.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelempId);
        
        cproductId = new Choice();
        cproductId.setBounds(200, 55, 150, 30);
        add(cproductId);
        
        try {
            Conn c = new Conn();
            String query = "select * from Product";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cproductId.add(rs.getString("product_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Product Name");
        labelname.setBounds(50, 100, 200, 50);
        labelname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(250, 110, 100, 30);
        lblname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lblname);
        
        
        try {
            Conn c = new Conn();
            String query = "select * from product where product_id = '"+cproductId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("product_name"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cproductId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from product where product_id = '"+cproductId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("product_name"));
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 200, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 200, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from product where product_id = '"+cproductId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Product Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveProduct();
    }
}
