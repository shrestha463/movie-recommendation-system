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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SuccessfullyLogin implements ActionListener {

    JFrame f;
    JPanel p1;
    JButton logout;
    JLabel username;
    JTextField search;
    JTextArea desc;
    JButton searchbtn, movie1, movie2, movie3, movie4, movie5, recommendme;
    JLabel mov1, mov2, mov3, mov4, mov5, l1;
    String Username;
    ImageIcon image, movie11, movie22, movie33, movie44, movie55;
    String genrename1;
    Connection con, con1;
    Statement st, st1, st2;
    ResultSet rs1, rs, rs2;

    JLabel moviename, genre, starting, actor, actor1, actor2, actor3, budget, rating, year, description, movieimage;
    JLabel genrename, budgetval, ratingval, yearval, descriptionval;

    String moviename11, genre11, starting11, actor11, actor22, actor33, budget11, rating11, year11, description11, movieimage11, search11;
    String moviename12;

    public SuccessfullyLogin(String name) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
        st = con.createStatement();
        st1 = con1.createStatement();
        st2 = con.createStatement();
        String username12 = name;
        System.out.println(username12);

        String sql1 = "SELECT interest from userlogin where username='" + username12 + "'";
        rs = st1.executeQuery(sql1);
        while (rs.next()) {
            genrename1 = rs.getString("interest");
            genre(genrename1);
            //  System.out.println(genrename1);
        }

        f = new JFrame("MOVIE RECOMMENDOR");
        f.setSize(1000, 1200);
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0, 0, 1000, 1200);
        
        p1.setLayout(null);

        l1 = new JLabel("MOVIE RECOMMENDER");
        l1.setBounds(250, 0, 1000, 100);
        l1.setFont(new Font("ARIAL", Font.BOLD, 40));
        l1.setForeground(Color.RED);
        p1.add(l1);
        
        search = new JTextField("Click here to search movie");
        search.setBounds(10, 110, 650, 30);
        p1.add(search);

        searchbtn = new JButton("Search");
        searchbtn.addActionListener(this);
        searchbtn.setBounds(660, 110, 100, 30);
        searchbtn.setForeground(Color.white);
        searchbtn.setBackground(Color.blue);
        p1.add(searchbtn);

        recommendme = new JButton("Recommend Me");
        recommendme.setBounds(765, 110, 150, 30);
        recommendme.setForeground(Color.white);
        recommendme.setBackground(Color.blue);
        recommendme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RecommendMe r100 = new RecommendMe();
            }
        });
        p1.add(recommendme);

        JLabel username1 = new JLabel("Hi " + "\t" + "\t" + username12);
        username1.setBounds(810, 0, 100, 30);
        logout = new JButton("Logout");
        logout.setBounds(900, 0, 60, 30);
        Border noBorder = new LineBorder(Color.WHITE, 0);
        logout.setForeground(Color.BLUE);
        logout.setBorder(noBorder);
        logout.setBackground(Color.WHITE);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainGui m = new MainGui();
            }
        });

        JLabel intrested = new JLabel("Interested Movies");
        intrested.setFont(new Font("Arial", Font.BOLD, 20));
        intrested.setBounds(10, 150, 300, 25);
        intrested.setForeground(Color.BLUE);
        p1.add(intrested);
        
        String gen = genre(genrename1);
        System.out.println(gen);
        String sql = "SELECT * from moviedata where genre='" + gen + "' AND rating>=7";
        Username = name;
        rs1 = st.executeQuery(sql);
        int x = 0;
        int y = 0;
        while (rs1.next()) {

            byte[] bt = rs1.getBytes(11);

            movieimage = new JLabel(new ImageIcon(bt));
            movieimage.setBounds(5 + x + y, 180, 200, 200);
            p1.add(movieimage);

            moviename = new JLabel(rs1.getString(2));
            moviename.setBounds(220 + x, 180, 300, 25);
            moviename.setForeground(Color.blue);
            moviename.setFont(new Font("ARIAL", Font.BOLD, 15));
            p1.add(moviename);

            actor = new JLabel("Starting");
            actor.setBounds(220 + x, 210, 200, 25);
            p1.add(actor);

            actor1 = new JLabel(rs1.getString(4));
            actor1.setFont(new Font("ARIAL", Font.BOLD, 12));
            actor1.setForeground(Color.blue);
            actor1.setBounds(220 + x, 240, 200, 25);
            p1.add(actor1);

            actor2 = new JLabel(rs1.getString(5));
            actor2.setFont(new Font("ARIAL", Font.BOLD, 12));
            actor2.setForeground(Color.blue);
            actor2.setBounds(220 + x, 270, 200, 25);
            p1.add(actor2);

            actor3 = new JLabel(rs1.getString(6));
            actor3.setFont(new Font("ARIAL", Font.BOLD, 12));
            actor3.setForeground(Color.blue);
            actor3.setBounds(220 + x, 300, 200, 25);
            p1.add(actor3);

            rating = new JLabel("Rating");
            rating.setBounds(220 + x, 330, 50, 25);
            p1.add(rating);

            ratingval = new JLabel(rs1.getString("Rating"));
            ratingval.setBounds(270 + x, 330, 100, 25);
            p1.add(ratingval);

            genre = new JLabel("Genre");
            genre.setBounds(220 + x, 360, 50, 25);
            p1.add(genre);

            genrename = new JLabel(rs1.getString(7));
            genrename.setBounds(260 + x, 360, 100, 25);
            p1.add(genrename);

            year = new JLabel("Year");
            year.setBounds(220 + x, 390, 50, 25);
            p1.add(year);

            yearval = new JLabel(rs1.getString(8));
            yearval.setBounds(260 + x, 390, 100, 25);
            p1.add(yearval);

            description = new JLabel("Description");
            description.setBounds(10 + x, 400, 100, 25);
            p1.add(description);

            desc = new JTextArea(rs1.getString(10));
            desc.setBounds(0 + x, 430, 400, 500);
            desc.setEditable(false);
            p1.add(desc);

            x = x + 500;
            y = y + 10;

        }

        p1.add(logout);
        p1.add(username1);


        
        JScrollPane scroll = new JScrollPane(p1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        f.add(scroll);
        
       // f.add(p1);
       // f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//end of constructor

    String genre(String g) {
        genrename1 = g;
        return g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn) {
            search11 = search.getText();

            System.out.println("1 " + search11);

            String sql1 = "SELECT moviename FROM moviedata where moviename='" + search11 + "'";
            try {
                rs2 = st2.executeQuery(sql1);
                while (rs2.next()) {
                    String moviesnames = rs2.getString("moviename");
                    System.out.println("2 " + moviesnames);
                    if (search11.equals(moviesnames)) {
                        Search sea = new Search(search11);
                    }//end of if
                    if (!search11.equals(moviesnames)) {
                        JOptionPane.showMessageDialog(null, "Movie Not found!!!");
                    }
                }//end of while

            }//end of try
            catch (Exception e1) {
                System.out.println(e1.getMessage());
            }

        }//end of if

    }//end of action performed

}

/*class a {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        SuccessfullyLogin a21 = new SuccessfullyLogin("jayan");
    }
}*/
