package grocery_stock_management_system;

import java.awt.*;
import javax.swing.*;

import java.util.*;
import java.awt.event.*;



public class ManageProduct extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JComboBox uom;

    JTextField pname, pquantity,pprice;
   
    
    JLabel lblpid;
    JButton add, back,print;
    
    ManageProduct() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addproduct.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel heading = new JLabel("Add Product Detail");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 40));
        image.add(heading);
        
        JLabel labelname = new JLabel("Product Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelname);
        
        pname = new JTextField();
        pname.setBounds(200, 150, 150, 30);
        image.add(pname);
       
        
        JLabel labelpquantity = new JLabel("Quantity");
        labelpquantity.setBounds(400, 250, 150, 30);
        labelpquantity.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelpquantity);
        
        pquantity = new JTextField();
        pquantity.setBounds(500, 250, 150, 30);
        image.add(pquantity);
        
        
        JLabel labelpprice = new JLabel("Price");
        labelpprice.setBounds(50, 250, 150, 30);
        labelpprice.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelpprice);
        
        pprice = new JTextField();
        pprice.setBounds(200, 250, 150, 30);
        image.add(pprice);
        
        
        JLabel labeluom = new JLabel("Unit of Measured");
        labeluom.setBounds(50, 350, 150, 30);
        labeluom.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeluom);
        
        String courses[] = {"each", "kg"};
        uom = new JComboBox(courses);
        uom.setBackground(Color.WHITE);
        uom.setBounds(200, 350, 150, 30);
        image.add(uom);
        
        
        JLabel labelpid = new JLabel("Product id");
        labelpid.setBounds(400, 150, 150, 30);
        labelpid.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelpid);
        
        lblpid = new JLabel("" + number);
        lblpid.setBounds(500, 150, 150, 30);
        lblpid.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblpid);
        
        
        add = new JButton("Add Details");
        add.setBounds(150, 480, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);
        
        back = new JButton("Back");
        back.setBounds(350, 480, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = pname.getText();
            
            
            
            String quantity = pquantity.getText();
            String price = pprice.getText();
            String uom_id = (String)uom.getSelectedItem();
            
            String productId = lblpid.getText();
            
            
            try {
                Conn conn = new Conn();
                String query = "insert into product values('"+name+"', '"+productId+"','"+uom_id+"','"+quantity+"', '"+price+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "failed to add product,we have this product in inventory");
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ManageProduct();
    }
}

