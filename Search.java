package javaapplication3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Search {

    JFrame f;
    JLabel moviename, genre, starting, actor, actor1, actor2, actor3, budget, rating, year, description, movieimage, label1;
    JLabel genrename, budgetval, ratingval, yearval, ratingicon;
    JTextArea descriptionval;
    JButton back;
    Connection con;
    Statement stmt,stmt1;
    ResultSet rs,rs1;
    String search;
    JScrollPane scroll;

    public Search(String search1) {
        try {

            search = search1;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
            stmt = con.createStatement();
            stmt1=con.createStatement();
            //    String sql="select * from admindata where moviename='"+search+"' ";
            String sql = "select * from moviedata";
            String sql1="select * from description";
            rs = stmt.executeQuery(sql);
           // rs1 =   stmt.executeQuery(sql1);
            f = new JFrame("Search");
            f.setSize(1000, 1200);

            JPanel p1 = new JPanel();
            p1.setBackground(Color.white);
            p1.setBounds(0, 0, 1000, 1200);
            //f.add(p1);

            p1.setLayout(null);

            label1 = new JLabel("MOVIE RECOMMENDER");
            label1.setBounds(250, 0, 1000, 100);
            label1.setFont(new Font("ARIAL", Font.BOLD, 40));
            label1.setForeground(Color.RED);
            p1.add(label1);

            JLabel searched = new JLabel("Searched Movie");
            searched.setFont(new Font("Arial", Font.BOLD, 20));
            searched.setBounds(200, 80, 200, 30);
            searched.setForeground(Color.DARK_GRAY);
            p1.add(searched);
            while (rs.next()) {
                String movie123 = rs.getString(2);
                if (movie123.equalsIgnoreCase(search)) {
                    byte[] bt = rs.getBytes(11);
                    movieimage = new JLabel(new ImageIcon(bt));
                    movieimage.setBounds(200, 120, 220, 200);
                    p1.add(movieimage);

                    moviename = new JLabel(rs.getString(2));
                    moviename.setFont(new Font("Arial", Font.BOLD, 15));
                    moviename.setForeground(Color.DARK_GRAY);
                    moviename.setBounds(430, 120, 300, 30);
                    p1.add(moviename);

                    actor = new JLabel("Starting : ");
                    actor.setBounds(430, 150, 300, 25);
                    p1.add(actor);

                    actor1 = new JLabel(rs.getString(4));
                    actor1.setFont(new Font("ARIAL", Font.BOLD, 12));
                    actor1.setForeground(Color.DARK_GRAY);
                    actor1.setBounds(430, 180, 300, 25);
                    p1.add(actor1);

                    actor2 = new JLabel(rs.getString(5));
                    actor2.setFont(new Font("ARIAL", Font.BOLD, 12));
                    actor2.setForeground(Color.DARK_GRAY);
                    actor2.setBounds(430, 210, 300, 25);
                    p1.add(actor2);

                    actor3 = new JLabel(rs.getString(6));
                    actor3.setFont(new Font("ARIAL", Font.BOLD, 12));
                    actor3.setForeground(Color.DARK_GRAY);
                    actor3.setBounds(430, 240, 300, 25);
                    p1.add(actor3);

                    rating = new JLabel("Rating : ");
                    rating.setBounds(430, 270, 100, 25);
                    p1.add(rating);

                    ratingval = new JLabel(rs.getString("rating"));
                    ratingval.setBounds(480, 270, 100, 25);
                    p1.add(ratingval);

                    genre = new JLabel("Genre : ");
                    genre.setBounds(430, 300, 100, 25);
                    p1.add(genre);

                    genrename = new JLabel(rs.getString(7));
                    genrename.setBounds(480, 300, 100, 25);
                    p1.add(genrename);

                    budget = new JLabel("Budget : ");
                    budget.setBounds(430, 330, 100, 25);
                    p1.add(budget);

                    budgetval = new JLabel(rs.getString(9) + " M$");
                    budgetval.setBounds(485, 330, 100, 25);
                    p1.add(budgetval);

                    year = new JLabel("Year : ");
                    year.setBounds(430, 360, 100, 25);
                    p1.add(year);

                    yearval = new JLabel(rs.getString(8));
                    yearval.setBounds(470, 360, 100, 25);
                    p1.add(yearval);

                    description = new JLabel("Description");
                    description.setFont(new Font("ARIAL", Font.BOLD, 15));
                    description.setForeground(Color.DARK_GRAY);
                    description.setBounds(200, 370, 100, 25);
                    p1.add(description);

                /*    descriptionval = new JTextArea(rs.getString(10));
                    descriptionval.setEditable(false);
                    descriptionval.setForeground(Color.DARK_GRAY);
                    descriptionval.setBounds(200, 400, 300, 250);
                    p1.add(descriptionval);*/

                }
            }
            rs1 =   stmt.executeQuery(sql1);
            while(rs1.next()){
                String movie12 = rs1.getString(1);
                if (movie12.equalsIgnoreCase(search)) {
                    descriptionval = new JTextArea(rs1.getString(2));
                    descriptionval.setEditable(false);
                    descriptionval.setForeground(Color.DARK_GRAY);
                    descriptionval.setBounds(200, 400, 600, 250);
                    p1.add(descriptionval);
                }
                
            }
            back = new JButton("Click here to return to main page");
            back.setBounds(300, 660, 400, 25);
            Border noBorder = new LineBorder(Color.WHITE, 0);
            back.setForeground(Color.BLUE);
            back.setBorder(noBorder);
            back.setBackground(Color.WHITE);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainGui a21 = new MainGui();
                }
            });
            p1.add(back);

            JScrollPane scroll = new JScrollPane(p1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            f.add(scroll);

            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }//end of constructor

}

/*class a134 {

    public static void main(String[] args) {
        Search a12 = new Search("xxx");
    }
}*/
