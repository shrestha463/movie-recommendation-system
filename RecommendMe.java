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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class RecommendMe {

    JFrame f;
    JLabel l1, mov1, mov2, mov3, mov4, mov5, rating, genre, description, actor1, actor2, starting, ratingval, genreval;
    JTextArea descriptionarea;
    ImageIcon movie11, movie22, movie33, movie44, movie55;
    JButton movie1, movie2, movie3, movie4, movie5;
    JLabel p1, startingn, actorn1, actorn2, actorn3, genren, genrenval,yearn,budgetn,ratingn,directedn,timen;

    Connection con;
    Statement stmt;
    ResultSet rs;

    public RecommendMe() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
            stmt = con.createStatement();
            String sql = "SELECT * FROM moviedata";
            rs = stmt.executeQuery(sql);

            f = new JFrame("Movie Recommendation System");
            f.setLayout(null);
            f.setSize(1000, 1500);

            l1 = new JLabel("MOVIE RECOMMENDER");
            l1.setBounds(250, 0, 1000, 100);
            l1.setFont(new Font("ARIAL", Font.BOLD, 40));
            l1.setForeground(Color.RED);
            f.add(l1);

            JLabel selectmovie = new JLabel("Select Movie for Recommendation");
            selectmovie.setFont(new Font("Arial", Font.BOLD, 15));
            selectmovie.setBounds(10, 80, 400, 20);
            selectmovie.setForeground(Color.BLUE);
            f.add(selectmovie);

            movie11 = new ImageIcon("1.jpeg");
            mov1 = new JLabel(movie11);
            mov1.setBounds(10, 130, 100, 100);
            f.add(mov1);

            movie1 = new JButton("22 Jump street");
            movie1.setFont(new Font("Arial", Font.BOLD, 15));
            movie1.setBounds(110, 130, 200, 20);
            Border noBorder = new LineBorder(Color.WHITE, 0);
            movie1.setForeground(Color.BLUE);
            movie1.setBorder(noBorder);

            startingn = new JLabel("Starting");
            startingn.setFont(new Font("Arial", Font.BOLD, 13));
            startingn.setBounds(130, 160, 100, 20);
            f.add(startingn);

            actorn1 = new JLabel("Jonah Hill");
            actorn2 = new JLabel("Peter Stormare");
            actorn1.setForeground(Color.BLUE);
            actorn2.setForeground(Color.BLUE);
            actorn1.setBounds(130, 180, 100, 20);
            actorn2.setBounds(200, 180, 100, 20);
            f.add(actorn1);
            f.add(actorn2);

            genren = new JLabel("Genre : ");
            genren.setBounds(130, 200, 100, 20);
            genrenval = new JLabel("Comedy");
            genrenval.setBounds(180, 200, 100, 20);
            f.add(genren);
            f.add(genrenval);
            
            yearn=new JLabel("Year : "+"2014");
            yearn.setBounds(130,220,200,20);
            f.add(yearn);
            
            budgetn=new JLabel("Budget : "+"65 M$");
            budgetn.setBounds(130,240,200,20);
            f.add(budgetn);
            
            ratingn = new JLabel("Rating : 7.1/10");
            ratingn.setBounds(10,230,100,20);
            f.add(ratingn);
            
            directedn=new JLabel("Directed By : Phil Lord");
            directedn.setBounds(130,260,200,20);
            f.add(directedn);
            
           timen=new JLabel("Runtime : 110 Min");
           timen.setBounds(10,250,200,20);
           f.add(timen);

            movie1.setBackground(Color.WHITE);
            movie1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Movie1 m = new Movie1();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            f.add(movie1);

            movie22 = new ImageIcon("civil.jpg");
            mov2 = new JLabel(movie22);
            mov2.setBounds(510, 130, 100, 100);
            f.add(mov2);

            movie2 = new JButton("Captain America Civil War");
            movie2.setBounds(610, 130, 200, 20);
            movie2.setFont(new Font("Arial", Font.BOLD, 15));
            movie2.setForeground(Color.BLUE);
            movie2.setBorder(noBorder);
            movie2.setBackground(Color.WHITE);

            startingn = new JLabel("Starting");
            startingn.setFont(new Font("Arial", Font.BOLD, 13));
            startingn.setBounds(630, 160, 200, 20);
            f.add(startingn);

            actorn1 = new JLabel("Chris Evans");
            actorn2 = new JLabel("Robert Downey Jr.");
            actorn1.setForeground(Color.BLUE);
            actorn2.setForeground(Color.BLUE);
            actorn1.setBounds(630, 180, 100, 20);
            actorn2.setBounds(720, 180, 150, 20);
            f.add(actorn1);
            f.add(actorn2);

            genren = new JLabel("Genre : ");
            genren.setBounds(630, 200, 100, 20);
            genrenval = new JLabel("Action");
            genrenval.setBounds(680, 200, 100, 20);
            f.add(genren);
            f.add(genrenval);
            
            yearn=new JLabel("Year : "+"2016");
            yearn.setBounds(630,220,200,20);
            f.add(yearn);
            
            budgetn=new JLabel("Budget : "+"250 M$");
            budgetn.setBounds(630,240,200,20);
            f.add(budgetn);
            
            ratingn = new JLabel("Rating : 8.3/10");
            ratingn.setBounds(510,230,100,20);
            f.add(ratingn);
            
           timen=new JLabel("Runtime : 146 Min");
           timen.setBounds(510,250,200,20);
           f.add(timen);
            
            directedn=new JLabel("Directed By : Anthony/Joe Russo");
            directedn.setBounds(630,260,200,20);
            f.add(directedn);


            movie2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Movie2 m = new Movie2();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            f.add(movie2);

            movie33 = new ImageIcon("conjuring.jpg");
            mov3 = new JLabel(movie33);
            mov3.setBounds(10, 310, 100, 100);
            f.add(mov3);
            movie3 = new JButton("The Conjuring");
            movie3.setBounds(110, 310, 200, 20);
            movie3.setFont(new Font("Arial", Font.BOLD, 15));
            movie3.setForeground(Color.BLUE);
            movie3.setBorder(noBorder);
            movie3.setBackground(Color.WHITE);
            
            startingn = new JLabel("Starting");
            startingn.setFont(new Font("Arial", Font.BOLD, 13));
            startingn.setBounds(130, 340, 200, 20);
            f.add(startingn);

            actorn1 = new JLabel("Patrick Wilson");
            actorn2 = new JLabel("Vera Farmigh");
            actorn1.setForeground(Color.BLUE);
            actorn2.setForeground(Color.BLUE);
            actorn1.setBounds(130, 360, 100, 20);
            actorn2.setBounds(230, 360, 100, 20);
            f.add(actorn1);
            f.add(actorn2);

            genren = new JLabel("Genre : ");
            genren.setBounds(130, 380, 100, 20);
            genrenval = new JLabel("Horror");
            genrenval.setBounds(180, 380, 100, 20);
            f.add(genren);
            f.add(genrenval);
           
            yearn=new JLabel("Year : "+"2013");
            yearn.setBounds(130,400,200,20);
            f.add(yearn);
            
            budgetn=new JLabel("Budget : "+"20 M$");
            budgetn.setBounds(130,420,200,20);
            f.add(budgetn);

            ratingn = new JLabel("Rating : 7.6/10");
            ratingn.setBounds(10,410,100,20);
            f.add(ratingn);
            
            timen=new JLabel("Runtime : 112 Min");
           timen.setBounds(10,430,200,20);
           f.add(timen);
            
            directedn=new JLabel("Directed By : James Wan");
            directedn.setBounds(130,440,200,20);
            f.add(directedn);

            movie3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Movie3 m = new Movie3();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            f.add(movie3);

            movie44 = new ImageIcon("4.jpg");
            mov4 = new JLabel(movie44);
            mov4.setBounds(510, 310, 100, 100);
            f.add(mov4);
            movie4 = new JButton("Friends with Benifits");
            movie4.setBounds(610, 310, 200, 20);
            movie4.setFont(new Font("Arial", Font.BOLD, 15));
            movie4.setForeground(Color.BLUE);
            movie4.setBorder(noBorder);
            movie4.setBackground(Color.WHITE);
            
            startingn = new JLabel("Starting");
            startingn.setFont(new Font("Arial", Font.BOLD, 13));
            startingn.setBounds(630, 340, 200, 20);
            f.add(startingn);

            actorn1 = new JLabel("Emma Stone");
            actorn2 = new JLabel("Justin Timberlake");
            actorn1.setForeground(Color.BLUE);
            actorn2.setForeground(Color.BLUE);
            actorn1.setBounds(630, 360, 100, 20);
            actorn2.setBounds(720, 360, 150, 20);
            f.add(actorn1);
            f.add(actorn2);

            genren = new JLabel("Genre : ");
            genren.setBounds(630, 380, 100, 20);
            genrenval = new JLabel("Romance");
            genrenval.setBounds(680, 380, 100, 20);
            f.add(genren);
            f.add(genrenval);
            
            yearn=new JLabel("Year : "+"2011");
            yearn.setBounds(630,400,200,20);
            f.add(yearn);
            
            budgetn=new JLabel("Budget : "+"35 M$");
            budgetn.setBounds(630,420,200,20);
            f.add(budgetn);
            
            ratingn = new JLabel("Rating : 6.6/10");
            ratingn.setBounds(510,410,100,20);
            f.add(ratingn);
            
            timen=new JLabel("Runtime : 102 Min");
           timen.setBounds(510,430,200,20);
           f.add(timen);
            directedn=new JLabel("Directed By : Will Gluck");
            directedn.setBounds(630,440,200,20);
            f.add(directedn);
            
            movie4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Movie4 m = new Movie4();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            f.add(movie4);

            movie55 = new ImageIcon("black-swan-poster.jpg");
            mov5 = new JLabel(movie55);
            mov5.setBounds(10, 510, 100, 100);
            f.add(mov5);
            
            movie5 = new JButton("Black Swan");
            movie5.setBounds(110, 510, 200, 20);
            movie5.setFont(new Font("Arial", Font.BOLD, 15));
            movie5.setForeground(Color.BLUE);
            movie5.setBorder(noBorder);
            movie5.setBackground(Color.WHITE);
            
            startingn = new JLabel("Starting");
            startingn.setFont(new Font("Arial", Font.BOLD, 13));
            startingn.setBounds(130, 540, 200, 20);
            f.add(startingn);

            actorn1 = new JLabel("Natalie Portman");
            actorn2 = new JLabel("Mila Kunis");
            actorn1.setForeground(Color.BLUE);
            actorn2.setForeground(Color.BLUE);
            actorn1.setBounds(130, 560, 150, 20);
            actorn2.setBounds(230, 560, 150, 20);
            f.add(actorn1);
            f.add(actorn2);

            genren = new JLabel("Genre : ");
            genren.setBounds(130, 580, 100, 20);
            genrenval = new JLabel("Adventure");
            genrenval.setBounds(180, 580, 100, 20);
            f.add(genren);
            f.add(genrenval);
            
            yearn=new JLabel("Year : "+"2010");
            yearn.setBounds(130,600,200,20);
            f.add(yearn);
            
            budgetn=new JLabel("Budget : "+"13 M$");
            budgetn.setBounds(130,620,200,20);
            f.add(budgetn);
            
            ratingn = new JLabel("Rating : 8/10");
            ratingn.setBounds(10,610,100,20);
            f.add(ratingn);
            
            timen=new JLabel("Runtime : 108 Min");
           timen.setBounds(10,630,200,20);
           f.add(timen);
            
            directedn=new JLabel("Directed By : Darren Aronafsky");
            directedn.setBounds(130,640,200,20);
            f.add(directedn);
            
            movie5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Movie5 m = new Movie5();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RecommendMe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            f.add(movie5);
            while (rs.next()) {
                String movie = rs.getString("2");
                String movie111 = "22 JUMP STREET";
                String movie222 = "Super man vs batman";
                String movie333 = "The Evil Dead";
                String movie444 = "Friends with benefits";
                String movie555 = "Hobbit";
                if (movie.equals(movie111)) {
                    starting = new JLabel("Starting");
                    starting.setBounds(110, 150, 30, 25);
                    f.add(starting);

                    /*  actor1=new JLabel(rs.getString("4"));
                     actor1.setBounds(null);
                     f.add(actor1);
                
                     actor2=new JLabel(rs.getString("5"));
                     actor2.setBounds(null);
                     f.add(actor2);
                
                     rating=new JLabel("Rating");
                     rating.setBounds(null);
                     f.add(rating);
                
                     ratingval=new JLabel(rs.getString("3"));
                     ratingval.setBounds(null);
                     f.add(ratingval);
                
                     genre=new JLabel("Genre");
                     genre.setBounds(null);
                     f.add(genre);
                
                     genreval=new JLabel(rs.getString("7"));
                     genreval.setBounds(null);
                     f.add(genreval);
                
                     description=new JLabel("Description");
                     genre.setBounds(null);
                     f.add(genre);
                
                     descriptionarea=new JTextArea(rs.getString("10"));
                     descriptionarea.setBounds(null);
                     f.add(descriptionarea);*/
                }
            }

        } catch (Exception ae) {
            System.out.println("Error" + ae.getStackTrace());
        }

        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0, 0, 1000, 1000);
        f.add(p1);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}

class a100 {

    public static void main(String[] args) {
        RecommendMe r11 = new RecommendMe();
    }
}
