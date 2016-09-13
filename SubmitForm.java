package javaapplication3;

/**
 *
 * @author Jayan
 */
import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import java.awt.Color;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SubmitForm extends JFrame implements ActionListener {

    JLabel fname, mname, lname, address, emailid, username, createpassword, confirmpassword, interest, signupform, l1,imageicon;

    JButton submitbtn, cancelbtn, resetbtn;

    JTextField fnametxt, mnametxt, lnametxt, addresstxt, emailidtxt, usernametxt;

    JPasswordField createpasswordtxt, confirmpasswordtxt;

    JComboBox interestbox;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    PreparedStatement stat;
    ImageIcon userlogin;

    JFrame f1;

    SubmitForm() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
            st = con.createStatement();
        }//end of try
        catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }//end of catch

        f1 = new JFrame("Sign up form");
        f1.setLayout(null);
        f1.setSize(1000, 1000);

        l1 = new JLabel("MOVIE RECOMMENDER");
        l1.setBounds(250, 0, 1000, 100);
        l1.setFont(new Font("ARIAL", Font.BOLD, 40));
        l1.setForeground(Color.RED);
        f1.add(l1);

        signupform = new JLabel("SignUp for free");
        signupform.setBounds(400,160,400,30);
        signupform.setFont(new Font("ARIAL", Font.BOLD, 15));
        signupform.setForeground(Color.BLUE);
        f1.add(signupform);
        
        userlogin=new ImageIcon("user.png");
        imageicon=new JLabel(userlogin);
        imageicon.setBounds(400,200,100,100);
        f1.add(imageicon);

        fname = new JLabel("Name ");
        fname.setBounds(200,310,150,25);
        fnametxt = new JTextField("First name");
        fnametxt.setBounds(350,310,150,25);

        mnametxt = new JTextField("Middle name");
        mnametxt.setBounds(505,310,150,25);
        lnametxt = new JTextField("Last name");
        lnametxt.setBounds(660, 310, 150, 25);

        address = new JLabel("Address ");
        address.setBounds(200,340,150,25);
        addresstxt = new JTextField();
        addresstxt.setBounds(350,340,300,25);

        emailid = new JLabel("Email ");
        emailid.setBounds(200,370,150,25);
        emailidtxt = new JTextField();
        emailidtxt.setBounds(350,370,250,25);

        username = new JLabel("Username ");
        username.setBounds(200,400,150,25);
        usernametxt = new JTextField();
        usernametxt.setBounds(350,400,150,25);

        createpassword = new JLabel("Create Password  ");
        createpassword.setBounds(200,430,150,25);
        createpasswordtxt = new JPasswordField();
        createpasswordtxt.setBounds(350,430,150,25);

        confirmpassword = new JLabel("Confirm Password  ");
        confirmpassword.setBounds(200,460,150,25);
        confirmpasswordtxt = new JPasswordField();
        confirmpasswordtxt.setBounds(350,460,150,25);

        /*if(!createpasswordtxt.equals(confirmpasswordtxt))
         {
         JOptionPane.showMessageDialog(null, "Password do not Match please reenter password");
         }*/
        interest = new JLabel("Intrest");
        interest.setBounds(200,490,150,25);
        String interest1[] = {"",  "Romantic", "Horror",   "Action", "Comedy", "Adventure"};
        interestbox = new JComboBox(interest1);
        interestbox.setBounds(350,490,150,25);

        submitbtn = new JButton("Submit");
        submitbtn.addActionListener(this);
        submitbtn.setBackground(Color.blue);
        submitbtn.setForeground(Color.white);
        submitbtn.setBounds(200,520,100,25);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBackground(Color.blue);
        cancelbtn.setForeground(Color.white);
        cancelbtn.setBounds(305, 520, 100, 25);
        cancelbtn.addActionListener(this);

        resetbtn = new JButton("Reset");
        resetbtn.setForeground(Color.white);
        resetbtn.setBackground(Color.blue);
        resetbtn.setBounds(410, 520, 100, 25);
        resetbtn.addActionListener(this);
        

        f1.add(fname);
        f1.add(fnametxt);

        f1.add(mnametxt);

        f1.add(lnametxt);

        f1.add(address);
        f1.add(addresstxt);

        f1.add(emailid);
        f1.add(emailidtxt);

        f1.add(username);
        f1.add(usernametxt);

        f1.add(createpassword);
        f1.add(createpasswordtxt);

        f1.add(confirmpassword);
        f1.add(confirmpasswordtxt);

        f1.add(interest);
        f1.add(interestbox);

        f1.add(cancelbtn);
        f1.add(submitbtn);
        f1.add(resetbtn);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0,0,1000,1000);
        f1.add(p1);

        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
            st = con.createStatement();

        }//end of try
        catch (Exception ex) {
            System.out.println("Error : " + ex);
        }//end of catch
    }//end of constructor
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitbtn) {
            try {
                String fname1, lname1, mname1, username1, password1, email1;
                fname1 = fnametxt.getText();
                lname1 = lnametxt.getText();
                mname1 = mnametxt.getText();
                username1 = usernametxt.getText();
                password1 = createpasswordtxt.getText();
                email1 = emailidtxt.getText();
                String cpassword = confirmpasswordtxt.getText();
                String address1 = addresstxt.getText();
                String intrest1 = interestbox.getSelectedItem().toString();
                if (!password1.equals(cpassword)) {
                    JOptionPane.showMessageDialog(null, "Password doesnot match" + "\n" + "please reenter password");
                } else {
                    try {
                        stat = con.prepareStatement("insert into userlogin(fname,mname,lname,address,email,username,password,interest)values(?,?,?,?,?,?,?,?)");
                        stat.setString(1, fname1);
                        stat.setString(2, mname1);
                        stat.setString(3, lname1);
                        stat.setString(4, address1);
                        stat.setString(5, email1);
                        stat.setString(6, username1);
                        stat.setString(7, password1);
                        stat.setString(8, intrest1);
                        int retval = stat.executeUpdate();
                        if (retval == 1) {
                            JOptionPane.showMessageDialog(null, "one record inserted");
                        } else {
                            JOptionPane.showMessageDialog(null, "insertion failed");
                        }

                    }//end of try
                    catch (Exception qe) {
                        System.out.println("could not execute the query" + qe.getMessage());
                    }//end of catch

                }//end  of else
            }//end of try
            catch (Exception ex) {
                System.out.println(ex);
            }//end of catch
        }//end of if
        else if (e.getSource() == cancelbtn) {
            System.exit(0);
        } else {
            fnametxt.setText("  ");
            mnametxt.setText(" ");
            lnametxt.setText(" ");
            addresstxt.setText(" ");
            emailidtxt.setText(" ");
            usernametxt.setText(" ");
            createpasswordtxt.setText("");
            confirmpasswordtxt.setText("");
            interestbox.setSelectedItem("");
        }
    }

    private String LineSeparator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class pack {

    public static void main(String[] args) {
        SubmitForm n1 = new SubmitForm();
    }
}
