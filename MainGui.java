
package javaapplication3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGui {
    JFrame f;
    JPanel p1,p2,p3;
    JLabel l1;
    ImageIcon image,adminimage;
    JButton admin;
    
    
    public MainGui()
    {
        f=new JFrame("Movie Recommendation System");
        f.setLayout(null);
        f.setSize(1000,1000);
        
          
        l1 = new JLabel("MOVIE RECOMMENDER");
        l1.setBounds(250,0,1000,100);
        l1.setFont(new Font("ARIAL", Font.BOLD, 40));
        l1.setForeground(Color.RED);
        f.add(l1);
        
        adminimage= new ImageIcon("j.png");
        admin=new JButton(adminimage);
        admin.setBounds(950,5,30,30);
        admin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               AdminLogin admin=new AdminLogin();
            }
        });
        f.add(admin);
        
        JButton signin= new JButton("Sign In");
        signin.setBounds(600, 100, 100, 25);
        signin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SignInForm f1=new SignInForm();
            }
        });
        f.add(signin);
        
        JButton signup=new JButton("Sign UP");
        signup.setBounds(701, 100, 99, 25);
        signup.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            SubmitForm a=new SubmitForm();
        }
        });
        f.add(signup);
        
        //JButton search= new JButton("Search");
        //search.setBounds(801, 100, 100, 25);
        //f.add(search);
        
        
        JLabel latest= new JLabel("Latest Releases");
        latest.setFont(new Font("Arial",Font.BOLD,20));
        latest.setBounds(10, 120, 500, 50);
        latest.setForeground(Color.ORANGE);
        f.add(latest);
        
        ImageIcon Licon1 = new ImageIcon("image/deadpool.jpg");
        JButton lrbtn1 = new JButton(Licon1);
        lrbtn1.setBounds(10, 180, 200, 200);
        lrbtn1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=FyKWUTwSYAs");
            }

                public void openWebPage(String url)
            {
                try
                {         
                  java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        f.add(lrbtn1);
        
        
        ImageIcon licon2= new ImageIcon("image/hunger.jpg");
        JButton lrbtn2= new JButton(licon2);
        lrbtn2.setBounds(230, 180, 200, 200);
        lrbtn2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=KmYNkasYthg");
            }

            public void openWebPage(String url)
            {
                try
                {         
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });

        f.add(lrbtn2);
        
        ImageIcon licon3= new ImageIcon("image/batman.jpg");
        JButton lrbtn3= new JButton(licon3);
        lrbtn3.setBounds(450, 180, 200, 200);
        lrbtn3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=eX_iASz1Si8");
            }

            public void openWebPage(String url)
            {
                try
                {         
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        f.add(lrbtn3);
        
        ImageIcon licon4= new ImageIcon("image/civil.jpg");
        JButton lrbtn4= new JButton(licon4);
        lrbtn4.setBounds(670, 180, 200, 200);
         lrbtn4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=dKrVegVI0Us");
            }

            public void openWebPage(String url)
            {
                try
                {         
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        
        f.add(lrbtn4);
        
        
        
        JLabel popular= new JLabel("Popular Movies");
        popular.setFont(new Font("Arial",Font.BOLD,20));
        popular.setBounds(10, 400, 500, 50);
        popular.setForeground(Color.ORANGE);
         lrbtn2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=KmYNkasYthg");
            }

            public void openWebPage(String url)
            {
                try
                {         
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        
        f.add(popular);
        
        ImageIcon Picon1= new ImageIcon("image/ff7.jpg");
        JButton pmbtn1= new JButton(Picon1);
        pmbtn1.setBounds(10, 480, 200, 200);
         pmbtn1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=Skpu5HaVkOc");
            }

            public void openWebPage(String url)
            {
                try
                {         
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        
        f.add(pmbtn1);
        
        ImageIcon Picon2=new ImageIcon("image/22.jpg");
        JButton pmbtn2= new JButton(Picon2);
        pmbtn2.setBounds(230, 480, 200, 200);
         pmbtn2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=rbZk_3KbRlg");
            }

            public void openWebPage(String url)
            {
                try
                {         
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        
        f.add(pmbtn2);
        
        ImageIcon Picon3=new ImageIcon("image/hobbit.jpg");
        JButton pmbtn3= new JButton(Picon3);
        pmbtn3.setBounds(450, 480, 200, 200);
         pmbtn3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=iVAgTiBrrDA");
            }

            public void openWebPage(String url)
            {
                try
                {         
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        
        f.add(pmbtn3);
        
        ImageIcon Picon4=new ImageIcon("image/xxx.jpg");
        JButton pmbtn4= new JButton(Picon4);
        pmbtn4.setBounds(670, 480, 200, 200);
         pmbtn4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                openWebPage("https://www.youtube.com/watch?v=dKtArxTOm-w");
            }

            public void openWebPage(String url)
            {
                try
                {         
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        
        f.add(pmbtn4);
        
        //adding image in background
        ImageIcon image = new ImageIcon("image/back11 copy.png");
        JLabel labeln = new JLabel(image);
        p1 = new JPanel(new BorderLayout());
        p1.setBounds(0  , 0   ,1000 , 1000);
        p1.add( labeln, BorderLayout.CENTER );
        f.add(p1);
      
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
class main
{
    
    public static void main(String[] args) 
    {
        MainGui m = new MainGui();
    }
}
