package javaapplication3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;




public class LoginForm  {
    
    
    JFrame f;
    JPanel p1;
    JButton signin;
    JButton signup;
    JButton b1,admin;
    ImageIcon image,adminimage;
      
    
    
    
    public LoginForm(){
       f=new JFrame ("MOVIE RECOMMENDOR");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(1500,1500);
        
        JLabel title=new JLabel("MOVIE RECOMMENDOR SYSTEM");
        title.setBounds(200,10,1000,40);
        adminimage= new ImageIcon("j.png");
        admin=new JButton(adminimage);
        admin.setBounds(950,0,30,30);
        admin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               AdminLogin admin=new AdminLogin();
            }
        });
        f.add(admin);
        
        title.setFont(new Font("ARIAL", Font.BOLD, 40));
        title.setForeground(Color.red);
        title.setBackground(Color.green);
        
        f.add(title);
           
       /* p1=new JPanel();
        p1.setBounds(100, 60, 1000, 30);*/
        
        
        
        signin=new JButton("Sign In");
        signin.setBounds(780,60,100,25);
         signin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SignInForm f1=new SignInForm();
            }
        });
       
        
        signup=new JButton("Sign up");
        signup.setBounds(880,60,100,25);
        signup.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SubmitForm n1=new SubmitForm();
            }
        });
        
        
        
        try
        {
            BufferedImage buttonIcon = ImageIO.read(new File("image11.jpg"));
        b1= new JButton(new ImageIcon(buttonIcon));
        f.add(b1);
        
        }
        catch(IOException e)
                {
                    System.out.println("no button assigned");
                }
        //f.add(p1);
        f.add(signin);
        f.add(signup);
        
       
        
        
        // for latest releases
        image = new ImageIcon("a1.jpg");
        
        JLabel first= new JLabel("Latest Release");
        first.setBounds(20, 100, 200, 25);
        first.setFont(new Font("ARIAL", Font.BOLD, 20));
        first.setForeground(Color.white);
        
        f.add(first);
        
        
        JLabel label = new JLabel(image);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(20, 150, 200, 210);
        panel.add( label, BorderLayout.CENTER );
        
        ImageIcon image2 = new ImageIcon("a2.jpg");
        JLabel label1 = new JLabel(image2);
        JPanel p2 = new JPanel(new BorderLayout());
        p2.setBounds(230, 150, 200, 210);
        p2.add(label1, BorderLayout.CENTER );
        
        image = new ImageIcon("a3.jpg");
        JLabel label2 = new JLabel(image);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBounds(440, 150, 200, 200);
        panel2.add( label2, BorderLayout.CENTER );
        
        image = new ImageIcon("a4.jpg");
        JLabel label3 = new JLabel(image);
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBounds(670, 150, 200, 200);
        panel3.add( label3, BorderLayout.CENTER );
        
        f.add(panel);
        f.add(p2);
        f.add(panel2);
        f.add(panel3);
        
        // most popular
        
        ImageIcon pop1 = new ImageIcon("a5.jpeg");
        
        JLabel f1= new JLabel("Most Poular");
        f1.setBounds(20, 400, 200, 25);
        f1.setFont(new Font("ARIAL", Font.BOLD, 20));
        f1.setForeground(Color.white);
        
        f.add(f1);
        
        
        JLabel l1 = new JLabel(pop1);
        JPanel pp1 = new JPanel(new BorderLayout());
        pp1.setBounds(20, 450, 200, 210);
        pp1.add( l1, BorderLayout.CENTER );
        
        ImageIcon pop2 = new ImageIcon("a6.jpg");
        JLabel f2 = new JLabel(pop2);
        JPanel pp2 = new JPanel(new BorderLayout());
        pp2.setBounds(230, 450, 200, 210);
        pp2.add(f2, BorderLayout.CENTER );
        
        image = new ImageIcon("a7.jpg");
        JLabel f3 = new JLabel(image);
        JPanel pp3 = new JPanel(new BorderLayout());
        pp3.setBounds(440, 450, 200, 200);
        pp3.add( f3, BorderLayout.CENTER );
        
        image = new ImageIcon("a8.jpg");
        JLabel f4 = new JLabel(image);
        JPanel pp4 = new JPanel(new BorderLayout());
        pp4.setBounds(670, 450, 200, 200);
        pp4.add( f4, BorderLayout.CENTER );
        
        
        f.add(pp1);
        f.add(pp2);
        f.add(pp3);
        f.add(pp4);
        
        image = new ImageIcon("back11.png");
        JLabel labeln = new JLabel(image);
        JPanel paneln = new JPanel(new BorderLayout());
        paneln.setBounds(0  , 0   ,1000 , 1000);
        paneln.add( labeln, BorderLayout.CENTER );
        f.add(paneln);
        f.setVisible(true);

        
        
        
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end of constructor

    
    
}
class f2{
    public static void main(String[] args) {
        LoginForm l1=new LoginForm();
    }
}

