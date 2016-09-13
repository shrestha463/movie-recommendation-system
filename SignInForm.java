package javaapplication3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SignInForm implements ActionListener {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    PreparedStatement stat;

    JLabel username, password, usernamedata, signinform, footer, l1, imageicon, create, l2;
    JTextField usernametxt, passwordtxt1;
    JPasswordField passwordtxt;
    ImageIcon userlogin;
    JButton signin, logout, createacc;
    JFrame f1;
    String name;
    JCheckBox b1;

    SignInForm() {

        f1 = new JFrame("Sign In");
        f1.setSize(1000, 1000);
        f1.setLayout(null);

        l1 = new JLabel("MOVIE RECOMMENDER");
        l1.setBounds(250, 0, 1000, 100);
        l1.setFont(new Font("ARIAL", Font.BOLD, 40));
        l1.setForeground(Color.RED);
        f1.add(l1);

        l2 = new JLabel("Sign in to Continue to Movie Recommendation system");
        l2.setForeground(Color.BLUE);
        l2.setBounds(300, 160, 600, 30);
        f1.add(l2);

        userlogin = new ImageIcon("user.png");
        imageicon = new JLabel(userlogin);
        imageicon.setBounds(400, 200, 100, 100);
        f1.add(imageicon);

        username = new JLabel("Username");
        username.setBounds(300, 310, 300, 25);
        f1.add(username);

        usernametxt = new JTextField();
        usernametxt.setBounds(300, 340, 300, 25);
        f1.add(usernametxt);
        

        password = new JLabel("Password");
        password.setBounds(300, 370, 300, 25);
        f1.add(password);

        passwordtxt = new JPasswordField();
        passwordtxt.setBounds(300, 390, 300, 25);
        f1.add(passwordtxt);

        signin = new JButton("Sign In");
        signin.setBackground(Color.blue);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        signin.setBounds(300, 420, 300, 25);
        f1.add(signin);

       /* b1 = new JCheckBox();
        b1.setBounds(300, 450, 25, 25);
        if(b1.isSelected()){
            usernametxt.setText(myname);
        }
        f1.add(b1);

        create = new JLabel("Stay signed in");
        create.setBounds(325, 450, 300, 25);
        f1.add(create);*/

        Border noBorder = new LineBorder(Color.WHITE, 0);
        createacc = new JButton("Create an account");
        createacc.setBounds(300, 490, 300, 25);
        createacc.setForeground(Color.BLUE);
        createacc.setBorder(noBorder);
        createacc.setBackground(Color.WHITE);
        createacc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitForm n1 = new SubmitForm();
            }
        });
        f1.add(createacc);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0, 0, 1000, 1000);
        f1.add(p1);

        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f1.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signin) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
                Statement st2 = con.createStatement();
                String username1 = usernametxt.getText();
                String password1 = passwordtxt.getText();
                String sql = "SELECT username,password FROM user where username='" + username1 + "' ";
                //System.out.println(username1);
                ResultSet rs = st2.executeQuery(sql);
                while (rs.next()) {

                    String uname = rs.getString("username");
                    String pass = rs.getString("password");

                    if (username1.equals(uname) && password1.equals(pass)) {
                        JOptionPane.showMessageDialog(null, "Login Successful ...");
                        SuccessfullyLogin a21 = new SuccessfullyLogin(username1);
                    }//end of if
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password!!!");
                    }
                }//end of while
                
            }//end of try
            catch (Exception e1) {
                System.out.println("error" + e1.getMessage());
            }//end of catch
        }//end of if
    }//end of action event
}//end of if

class lf1 {

    public static void main(String[] args) {
        SignInForm f11 = new SignInForm();
    }
}
