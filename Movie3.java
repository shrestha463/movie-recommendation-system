package javaapplication3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Movie3 {

    JFrame f;
    ImageIcon m1, m2, m3, m4, m5, m6;
    JButton b1, b2, b3, b4, b5, b6;
    JLabel ll1, ll2, ll3, ll4, ll5, ll6;
    JLabel moviename, recommendedmovie, l1, moviename1, label1;
    Connection con;
    Statement stmt;
    String sql;
    ResultSet rs;

    public Movie3() throws ClassNotFoundException, SQLException {
        f = new JFrame("Recommended Movie");
        f.setSize(1000, 1000);
        f.setLayout(null);

        label1 = new JLabel("MOVIE RECOMMENDER");
        label1.setBounds(250, 0, 1000, 100);
        label1.setFont(new Font("ARIAL", Font.BOLD, 40));
        label1.setForeground(Color.RED);
        f.add(label1);
        //for Horror
        l1 = new JLabel("Recommended movies");
        l1.setForeground(Color.BLUE);
        l1.setBounds(110, 80, 400, 25);
        l1.setFont(new Font("ARIAL", Font.BOLD, 15));
        f.add(l1);
        
        m1 = new ImageIcon("New Folder/evildead.jpg");
        b1 = new JButton(m1);
        b1.setBounds(100, 120, 200, 200);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("The Evil Dead");
            }
        });
        f.add(b1);

        ll1 = new JLabel("The Evil Dead");
        ll1.setBounds(150, 280, 100, 100);
        f.add(ll1);
        
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0, 0, 1500, 1500);
        f.add(p1);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);

    }

}

/*class a93 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Movie3 f1 = new Movie3();
    }
}*/
