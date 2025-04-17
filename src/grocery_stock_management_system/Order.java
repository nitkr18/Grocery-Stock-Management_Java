package grocery_stock_management_system;

import java.awt.*;
import javax.swing.*;

import java.util.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Order extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(9999);

    JTextField cname, cquantity, pprice, cmobile;
    JComboBox pname;
    JTable table;
    String name, product_id;
    JLabel lbloid, lblpid;
    JButton add, back, print;

    Order() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/order.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel heading = new JLabel("New Order");
        heading.setBounds(320, 40, 500, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(heading);

        JLabel labelname = new JLabel("Customer Name");
        labelname.setBounds(20, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelname);

        cname = new JTextField();
        cname.setBounds(170, 150, 150, 30);
        image.add(cname);

        JLabel labelmobile = new JLabel("Mobile no");
        labelmobile.setBounds(350, 150, 150, 30);
        labelmobile.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelmobile);

        cmobile = new JTextField();
        cmobile.setBounds(450, 150, 150, 30);
        image.add(cmobile);

        JLabel labelpname = new JLabel("Product Name");
        labelpname.setBounds(20, 250, 150, 30);
        labelpname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelpname);

        pname = new JComboBox();
        pname.setBackground(Color.WHITE);
        pname.setBounds(170, 250, 150, 30);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select product_name from product");
            while (rs.next()) {
                name = rs.getString("product_name");

                pname.addItem(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        image.add(pname);

        JLabel labelpquantity = new JLabel("Quantity");
        labelpquantity.setBounds(350, 250, 150, 30);
        labelpquantity.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelpquantity);

        cquantity = new JTextField();
        cquantity.setBounds(450, 250, 150, 30);
        image.add(cquantity);

        JLabel labelpprice = new JLabel("Price");
        labelpprice.setBounds(50, 350, 150, 30);
        labelpprice.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelpprice);

        pprice = new JTextField();
        pprice.setBounds(150, 350, 150, 30);
        image.add(pprice);

        JLabel labeloid = new JLabel("Order id");
        labeloid.setBounds(350, 350, 150, 30);
        labeloid.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeloid);

        lbloid = new JLabel("" + number);
        lbloid.setBounds(450, 350, 150, 30);
        lbloid.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lbloid);

        add = new JButton("Add Details");
        add.setBounds(50, 500, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);

        back = new JButton("Back");
        back.setBounds(250, 500, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        
        print = new JButton("Print");
        print.setBounds(450, 500, 150, 40);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        image.add(print);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = cname.getText();

            String Mobile_no = cmobile.getText();
            String oquantity = cquantity.getText();
            String price = pprice.getText();
            String productname = (String) pname.getSelectedItem();

            String OrderId = lbloid.getText();

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO `order` (`customer_name`, `mobile_no`, `order_id`, `product_name`, `price`, `quantity`) VALUES ('" + name + "', '" + Mobile_no + "', '" + OrderId + "', '" + productname + "', '" + price + "', '" + oquantity + "');";
                conn.s.executeUpdate(query);
                String que = "UPDATE product SET quantity =quantity-('" + oquantity + "') where product_name='" + productname + "'";
                conn.s.executeUpdate(que);
                JOptionPane.showMessageDialog(null, "Details added successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            String OrderId = lbloid.getText();
            try {
                table = new JTable();
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from order where order_id='" +OrderId+ "'");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new Order();
    }
}
