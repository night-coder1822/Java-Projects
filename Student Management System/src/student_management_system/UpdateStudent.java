package student_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener 
{
    JTextField tfphone,tfemail;
    JLabel labelrollno;
    JButton submit,cancel;
    Choice crollno;
    
    UpdateStudent() {
        setSize(900, 650);
        setLocation(250, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(280,20,500,50);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 35));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number -");
        lblrollnumber.setBounds(50,100,250,25);
        lblrollnumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(300,100,200,28);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from STUDENT");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,170,150,30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(250,170,150,30);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(470,170,150,30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(670,170,150,30);
        labelfname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelfname);
        
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50,240,150,30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
        labelrollno = new JLabel();
        labelrollno.setBounds(250,240,150,30);
        labelrollno.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelrollno);

        JLabel lblphone = new JLabel("Phone ");
        lblphone.setBounds(470,240,150,30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(670,240,150,30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email ID ");
        lblemail.setBounds(50,310,150,30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(250,310,150,30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X(%)");
        lblx.setBounds(470,310,150,30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        JLabel labelx = new JLabel();
        labelx.setBounds(670,310,150,30);
        labelx.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelx);

        JLabel lblxii = new JLabel("Class XII(%)");
        lblxii.setBounds(50,380,150,30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        JLabel labelxii = new JLabel();
        labelxii.setBounds(250,380,150,30);
        labelxii.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelxii);

        JLabel lblsgpa = new JLabel("SGPA");
        lblsgpa.setBounds(470,380,150,30);
        lblsgpa.setFont(new Font("serif", Font.BOLD, 20));
        add(lblsgpa);
        
        JLabel labelsgpa = new JLabel();
        labelsgpa.setBounds(670,380,150,30);
        labelsgpa.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelsgpa);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelsgpa.setText(rs.getString("sgpa"));
                labelrollno.setText(rs.getString("rollno"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelsgpa.setText(rs.getString("sgpa"));
                        labelrollno.setText(rs.getString("rollno"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        submit = new JButton("Update");
        submit.setBounds(250, 520, 150, 35);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 520, 150, 35);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = labelrollno.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try {
                String query = "update student set phone='"+phone+"', email='"+email+"' where rollno='"+rollno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) 
    {
        new UpdateStudent();
    }
}
