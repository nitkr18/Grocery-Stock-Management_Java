package grocery_stock_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Update extends JFrame implements ActionListener{
    
    
    JTextField  pquantity,pprice;
   
    JLabel lblpid,lblpname;
    String productid;

    JButton update, back;
   
    Update(String productId) {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        JLabel heading = new JLabel("Update Product Detail");
        heading.setBounds(320, 18, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        image.add(heading);
        
     
        
        JLabel labelphone = new JLabel("Product Name");
        labelphone.setBounds(50, 100, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelphone);
        lblpname = new JLabel();
        lblpname.setBounds(200, 100, 150, 30);
        lblpname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblpname);
        
        JLabel labelemail = new JLabel("Quantity");
        labelemail.setBounds(510, 100, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelemail);
        
        pquantity = new JTextField();
        pquantity.setBounds(600, 100, 150, 30);
        image.add(pquantity);
        
        
        
        JLabel labeldesignation = new JLabel("Price");
        labeldesignation.setBounds(50, 200, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeldesignation);
        
        pprice = new JTextField();
        pprice .setBounds(200, 200, 150, 30);
        image.add(pprice );
        
        
        
        JLabel labelempId = new JLabel("Product id");
        labelempId.setBounds(510, 200, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelempId);
        
        lblpid = new JLabel();
        lblpid.setBounds(600, 200, 150, 30);
        lblpid.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblpid);
        
        try {
            Conn c = new Conn();
            String query = "select * from product where product_id = '"+productId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                
                lblpname.setText(rs.getString("product_name"));
                
                pprice.setText(rs.getString("price_per_unit"));
                
                lblpid.setText(rs.getString("Product_id"));
                pquantity.setText(rs.getString("quantity"));
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        update = new JButton("Update Details");
        update.setBounds(250, 350, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        image.add(update);
        
        back = new JButton("Back");
        back.setBounds(450, 350, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String price = pprice.getText();
            String quantity = pquantity.getText();
            String productid= lblpid.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update product set price_per_unit='"+price+"',quantity='"+quantity+"' where product_id='"+productid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Inventory();
        }
    }

    public static void main(String[] args) {
        new Update("");
    }
}
