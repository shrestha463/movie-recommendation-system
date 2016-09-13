package javaapplication3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class AdminLogin implements ActionListener {

    JFrame f;
    JLabel title, footer, l1,imageicon,create;
    JLabel username, password;
    JTextField usernametxt;
    JPasswordField passwordtxt;
    JButton submit,back;
    String username1, password1;
    ImageIcon userlogin;
    JCheckBox b1;

    AdminLogin() {
        f = new JFrame("Admin panel");
        f.setSize(1000, 1000);
        f.setLayout(null);

        l1 = new JLabel("MOVIE RECOMMENDER");
        l1.setBounds(250, 0, 1000, 100);
        l1.setFont(new Font("ARIAL", Font.BOLD, 40));
        l1.setForeground(Color.RED);
        f.add(l1);

        title = new JLabel("Admin Panel");
        title.setFont(new Font("ARIAL", Font.BOLD, 15));
        title.setForeground(Color.blue);
        title.setBounds(440,150,100,50);
        f.add(title);
        
        userlogin=new ImageIcon("adminlogo.png");
        imageicon=new JLabel(userlogin);
        imageicon.setBounds(400,200,150,90);
        f.add(imageicon);

        username = new JLabel("Username");
        username.setBounds(400,300,200,25);
        f.add(username);

        usernametxt = new JTextField();
        usernametxt.setBounds(400,320,150,25);
        f.add(usernametxt);

        password = new JLabel("Password");
        password.setBounds(400,345,150,25);
        f.add(password);

        passwordtxt = new JPasswordField();
        passwordtxt.setBounds(400,370,150,25);
        f.add(passwordtxt);

        submit = new JButton("Submit");
        submit.setBounds(400,405,150,25);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        f.add(submit);
        
       /* b1=new JCheckBox();
        b1.setBounds(400,450,25,25);
        f.add(b1);
        
        create=new JLabel("Stay signed in");
        create.setBounds(425,450,300,25);
        f.add(create);*/
        
        back=new JButton("Back to home page");
        back.setBounds(325,480,300,25);
        Border noBorder=new LineBorder(Color.WHITE,0);
        back.setBorder(noBorder);
        back.setForeground(Color.blue);
        back.setBackground(Color.WHITE);
        back.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            MainGui m=new MainGui();
        }
        });
        f.add(back);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0,0,1000,1000);
        f.add(p1);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }//end of constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
                Statement st2 = con.createStatement();
                username1 = usernametxt.getText().toString();
                password1 = passwordtxt.getText().toString();
                String sql = "SELECT * FROM admin where username='" + username1 + "'";
                ResultSet rs = st2.executeQuery(sql);
                while (rs.next()) {
                    String uname = rs.getString(1);
                    String pass = rs.getString(2);
                    if (username1.equals(uname) && password1.equals(pass)) {
                        JOptionPane.showMessageDialog(null, "Login Successful ...");
                        AdminDataAdd admin1 = new AdminDataAdd();
                    }//end of if
                    else {
                        footer = new JLabel("Invalid Username or Password!!!");
                        footer.setBounds(10, 200, 200, 25);
                        f.add(footer);
                    }
                }//end of while
            } catch (Exception e1) {
                System.out.println("error" + e1.getMessage());
            }//end of catch
        }
    }
}

/*class a14 {

    public static void main(String[] args) {
        AdminLogin admin = new AdminLogin();
    }
}*/
