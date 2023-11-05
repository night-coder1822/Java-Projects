package library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddUser extends JFrame implements ActionListener {

    JTextField tfusername,tfpassword,tfname,tfrollno, tfemail,tfphone,tfyear,tfdept;
    JButton submit,cancel;

    AddUser() {
        super("ADD USER");
        setSize(825,650);
        setLocation(300,40);
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(280, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);
        
        // USERNAME
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 150, 150, 30);
        lblusername.setFont(new Font("serif", Font.BOLD, 20));
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(140, 150, 225, 30);
        add(tfusername);

        // PASSWORD
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(430, 150, 150, 30);
        lblpassword.setFont(new Font("serif", Font.BOLD, 20));
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(550, 150, 225, 30);
        add(tfpassword);

        // NAME
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 230, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(140, 230, 225, 30);
        add(tfname);

        // ROLL NUMBER
        JLabel lblrollno = new JLabel("Roll No.");
        lblrollno.setBounds(430, 230, 150, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        tfrollno = new JTextField();
        tfrollno.setBounds(550, 230, 225, 30);
        add(tfrollno);

        // EMAIL
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 310, 150, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(140, 310, 225, 30);
        add(tfemail);

        // PHONE
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(430, 310, 150, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(550, 310, 225, 30);
        add(tfphone);

        // YEAR
        JLabel lblyear = new JLabel("Year");
        lblyear.setBounds(30, 390, 150, 30);
        lblyear.setFont(new Font("serif", Font.BOLD, 20));
        add(lblyear);

        tfyear = new JTextField();
        tfyear.setBounds(140, 390, 225, 30);
        add(tfyear);

        // DEPARTMENT
        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(430, 390, 150, 30);
        lbldept.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldept);

        tfdept = new JTextField();
        tfdept.setBounds(550, 390, 225, 30);
        add(tfdept);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(220, 500, 150, 45);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 500, 150, 45);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            String name = tfname.getText();
            String rollno = tfrollno.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String year = tfyear.getText();
            String dept = tfdept.getText();

            try {
                String query = "insert into ADDUSER values ('"+username+"','"+password+"','"+name+"','"+rollno+"','"+email+"','"+phone+"','"+year+"','"+dept+"')";
                String query1 = "insert into STUDENTLOGIN values ('"+username+"','"+password+"')";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Student Added Successfully!!");
                this.setVisible(false);
                new Project();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Project();
            this.setVisible(false);
        }
    }
    public static void main (String agrs[]) {
        new AddUser();
    }
}