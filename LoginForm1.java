package javaapplication3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;



public class LoginForm1 implements ActionListener{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    PreparedStatement stat;
    
    JFrame f1;
    JPanel p1,p2,p3;
    JLabel username,fname,mname,lname;
    JLabel password,confirmpassword;
    JLabel email;
    JTextField usernametxt,fnametxt,mnametxt,lnametxt;
    JTextField emailtxt;
    JPasswordField passwordtxt,confirmpasswordtxt;
    JButton submit;
    JButton signin;
    JButton signout;
   
    
    
    
    
    public LoginForm1(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            st=con.createStatement();               
        }//end of try
        catch(Exception ex){
            System.out.println("Error : "+ex.getMessage());
        }//end of catch
        f1=new JFrame("login");
        f1.setSize(700,700);
        f1.setLayout(null);
        
    /*    p1=new JPanel();
        p1.setSize(700,25);
        JLabel signup1=new JLabel("Signup form");
        signup1.setBounds(10,45,40,20);
        p1.setBackground(Color.orange);
        p1.add(signup1);
        f1.add(p1);
        
        p2=new JPanel();
        signin=new JButton("SignIn");
        p2.setBackground(Color.blue);
        p2.setBounds(700,40,650,30);
        p2.add(signin);
        f1.add(p2);*/
       
        fnametxt=new JTextField("First Name");
        fnametxt.setBounds(10,60,100,30);
        f1.add(fnametxt);
        
        mnametxt=new JTextField("Middle Name");
        mnametxt.setBounds(115,60,100,30);
        f1.add(mnametxt);
        
        lnametxt=new JTextField("Last Name");
        lnametxt.setBounds(220,60,100,30);
        f1.add(lnametxt);
        
        username=new JLabel("Username  ");
        username.setBounds(10,100,100,30);
        f1.add(username);
        
        usernametxt=new JTextField();
        usernametxt.setBounds(120,100,150,30);
        f1.add(usernametxt);
        
        email=new JLabel("Email  ");
        email.setBounds(10,140,100,30);
        f1.add(email);
        
        emailtxt=new JTextField();
        emailtxt.setBounds(120,140,200,30);
        f1.add(emailtxt);
        
        password=new JLabel("Password");
        password.setBounds(10,180,100,30);
        f1.add(password);
        
        passwordtxt=new JPasswordField();
        passwordtxt.setBounds(120,180,200,30);
        f1.add(passwordtxt);
        
        confirmpassword=new JLabel("Confirm Password");
        confirmpassword.setBounds(10,220,200,30);
        f1.add(confirmpassword);
        
       confirmpasswordtxt=new JPasswordField();
        confirmpasswordtxt.setBounds(120,220,200,30);
        f1.add(confirmpasswordtxt);
        
        submit=new JButton("Submit");
        submit.setBounds(10,260,100,30);
        submit.addActionListener(this);
        f1.add(submit);
        
        
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }//end of constructor
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            try{
                String fname1,lname1,mname1,username1,password1,email1;
                fname1=fnametxt.getText();
                lname1=lnametxt.getText();
                mname1=mnametxt.getText();
                username1=usernametxt.getText();
                password1=passwordtxt.getText();
                email1=emailtxt.getText();
                String cpassword=confirmpasswordtxt.getText();
                if(!password1.equals(cpassword)){
                    JOptionPane.showMessageDialog(null,"Password doesnot match"+"\n"+ "please reenter password");
                }
                
                else{
                    try{
                        stat=con.prepareStatement("insert into loginform(fname,mname,lname,username,password,email)values(?,?,?,?,?,?)");
                        stat.setString(1,fname1);
                        stat.setString(2,mname1);
                        stat.setString(3,lname1);
                        stat.setString(4,username1);
                        stat.setString(5,password1);
                        stat.setString(6,email1);
                        int retval=stat.executeUpdate();
                        if(retval==1){
                            System.out.println("1 record inserted");
                        }
                        else{
                            System.out.println("insertion failed");
                        }
                        
                    }//end of try
                    catch(Exception qe){System.out.println("could not execute the query"+qe.getMessage());
                    }//end of catch
                          
                }//end  of else
        }//end of try
            catch(Exception ex){
            System.out.println(ex);
        }//end of catch
        }//end of if
    }//end of actionperformed 
}
class f3{
    public static void main(String[] args) {
        LoginForm1 l1=new LoginForm1();
    }
}

