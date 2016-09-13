package javaapplication3;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Movie1 {

    JFrame f;
    ImageIcon m1, m2, m3, m4, m5, m6, m7, m8;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JLabel ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8;
    JLabel moviename, recommendedmovie, l1, moviename1, label1;
    Connection con;
    Statement stmt;
    String sql;
    ResultSet rs;

    public Movie1() throws ClassNotFoundException, SQLException {
        JFrame frame = new JFrame("Recommended Movie");
        frame.setSize(1000, 900);
       

        JTextArea p1 = new JTextArea();
        p1.setEditable(true);
        p1.setBounds(0,0,1000,900);
        p1.setBackground(Color.white);
        
        p1.setLayout(null);

        label1 = new JLabel("MOVIE RECOMMENDER");
        label1.setBounds(250, 0, 1000, 100);
        label1.setFont(new Font("ARIAL", Font.BOLD, 40));
        label1.setForeground(Color.RED);
        p1.add(label1);
        
        //for comedy
        l1 = new JLabel("Recommended movies");
        l1.setForeground(Color.BLUE);
        l1.setBounds(100,80,250,30);
        l1.setFont(new Font("ARIAL", Font.BOLD, 15));
        p1.add(l1);
        
        m1 = new ImageIcon("New Folder/San_Andreas_poster.jpg");
        b1 = new JButton(m1);
        b1.setBounds(100, 120, 200, 200);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("San Andreas");
            }
        });
        p1.add(b1);

        ll1 = new JLabel("San Andreas");
        ll1.setBounds(160, 325, 150, 25);
        p1.add(ll1);
        
        m2 = new ImageIcon("New Folder/daynn.jpg");
        b2 = new JButton(m2);
        b2.setBounds(320, 120, 200, 200);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("Days and Nights");
            }
        });
        p1.add(b2);
        
        ll2 = new JLabel("Days and Nights");
        ll2.setBounds(380, 325, 150, 25);
        p1.add(ll2);
        
        m3 = new ImageIcon("New Folder/conjuring.jpg");
        b3 = new JButton(m3);
        b3.setBounds(540, 120, 200, 200);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("The Conjuring");
            }
        });
        p1.add(b3);
        
        ll3 = new JLabel("The Conjuring");
        ll3.setBounds(600, 325, 150, 25);
        p1.add(ll3);
        
        m4 = new ImageIcon("New Folder/horald.jpg");
        b4 = new JButton(m4);
        b4.setBounds(100, 360, 200, 200);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("Horald and kumar goes to white castle");
            }
        });
        p1.add(b4);

        ll4 = new JLabel("Horald and kumar goes to white castle");
        ll4.setBounds(90,560 , 250, 25);
        p1.add(ll4);
        
         m5 = new ImageIcon("New Folder/black-swan-poster.jpg");
        b5 = new JButton(m5);
        b5.setBounds(320, 360, 200, 200);
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("Black Swan");
            }
        });
        p1.add(b5);
        
        ll5 = new JLabel("Black Swan");
        ll5.setBounds(380, 560, 150, 25);
        p1.add(ll5);
        
        m6 = new ImageIcon("New Folder/maze_runner.jpg");
        b6 = new JButton(m6);
        b6.setBounds(540, 360, 200, 200);
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("Maze Runner");
            }
        });
        p1.add(b6);
        
        ll6 = new JLabel("Maze Runner");
        ll6.setBounds(600, 560, 150, 25);
        p1.add(ll6);
        
        m7 = new ImageIcon("New Folder/devil_inside.jpg");
        b7 = new JButton(m7);
        b7.setBounds(100, 600, 200, 200);
        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("Devil Inside");
            }
        });
        p1.add(b7);

        ll7 = new JLabel("The Devil Inside");
        ll7.setBounds(160, 795, 150, 25);
        p1.add(ll7);
        
        m8 = new ImageIcon("New Folder/Amivtyville-Horror.jpg");
        b8 = new JButton(m8);
        b8.setBounds(320, 600, 200, 200);
        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Search a12=new Search("Amityville");
            }
        });
        p1.add(b8);
        
        ll8 = new JLabel("Amivtyville");
        ll8.setBounds(380, 795, 150, 25);
        p1.add(ll8);

        JScrollPane scroll = new JScrollPane(p1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll);
        //textarea.add(scroll);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}

/*class a90 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Movie1 f1 = new Movie1();
    }
}*/
