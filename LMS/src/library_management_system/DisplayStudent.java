package library_management_system;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DisplayStudent extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton login, cancel;
    JTextField tfusername,tfpassword;

    DisplayStudent() {
        super("Display Student");
        setSize(1000, 400);
        setLocation(200,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50, 40, 150, 30);
        lblusername.setFont(new Font("serif",Font.BOLD, 23));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(215, 40, 200, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(500, 40, 100, 30);
        lblpassword.setFont(new Font("serif",Font.BOLD, 23));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(655, 40, 200, 30);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 90, 100, 30);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Back to Project2");
        cancel.setBounds(180, 90, 150, 30);
        cancel.addActionListener(this);
        add(cancel);

        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(15, 150, 950, 200);
        add(jsp);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {

        if (ae.getSource() == login) {
            String query = "select * from adduser where username = '"+tfusername.getText()+"' and password = '"+tfpassword.getText()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            new Project2();
            setVisible(false);
        }
    } 
    public static void main(String[] args)
    {
        new DisplayStudent();
    }
}

