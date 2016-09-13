package javaapplication3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;

public class AdminDataAdd implements ActionListener {
    JFrame f;
    JLabel movie,rating,actor1,actor2,actor3,genre,year,budget,description,image,subtitle,l1,title,imageicon,vector;
    JTextField movietxt,ratingtxt,actor1txt,actor2txt,actor3txt,genretxt,yeartxt,budgettxt,imagetxt,subtitletxt,filechoose,vectorchoose;
    JTextArea descriptiontxt;
    JButton save,reset;
    ImageIcon userlogin;
    JPanel p1;
    JFileChooser fc;
    JButton subtitleadd,vectoradd;
    
    AdminDataAdd() throws ClassNotFoundException, SQLException{
       
        f=new JFrame("Admin panel");
        f.setSize(1000,1000);
        f.setLayout(null);
        
        l1 = new JLabel("MOVIE RECOMMENDER");
        l1.setBounds(250, 0, 1000, 100);
        l1.setFont(new Font("ARIAL", Font.BOLD, 40));
        l1.setForeground(Color.RED);
        f.add(l1);
      
        title=new JLabel("Movie data input");
        title.setFont(new Font("Arial",Font.BOLD,15));
        title.setForeground(Color.BLUE);
        title.setBounds(400,110,400,25);
        f.add(title);
        
        userlogin=new ImageIcon("adminlogo.png");
        imageicon=new JLabel(userlogin);
        imageicon.setBounds(400,140,150,90);
        f.add(imageicon);
        
        movie=new JLabel("Movie Name");
        movie.setBounds(300,250,100,25);
        f.add(movie);
        movietxt=new JTextField();
        movietxt.setBounds(400,250,300,25);
        f.add(movietxt);
        
        rating=new JLabel("Rating");
        rating.setBounds(300,280,100,25);
        f.add(rating);
        ratingtxt=new JTextField();
        ratingtxt.setBounds(400,280,40,25);
        f.add(ratingtxt);
        
        actor1=new JLabel("Starting");
        actor1.setBounds(300,310,100,25);
        f.add(actor1);
        actor1txt=new JTextField();
        actor1txt.setBounds(400,310,100,25);
        f.add(actor1txt);
        
        actor2txt=new JTextField();
        actor2txt.setBounds(505,310,100,25);
        f.add(actor2txt);
       
        actor3txt=new JTextField();
        actor3txt.setBounds(610,310,100,25);
        f.add(actor3txt);
        
        genre=new JLabel("Genre");
        genre.setBounds(300,340,100,25);
        f.add(genre);
        genretxt=new JTextField();
        genretxt.setBounds(400,340,100,25);
        f.add(genretxt);
        
        year=new JLabel("Year");
        year.setBounds(300,370,100,25);
        f.add(year);
        yeartxt=new JTextField();
        yeartxt.setBounds(400,370,50,25);
        f.add(yeartxt);
        
        budget=new JLabel("Budget");
        budget.setBounds(300,400,100,25);
        f.add(budget);
        budgettxt=new JTextField();
        budgettxt.setBounds(400,400,100,25);
        f.add(budgettxt);
        
        subtitle=new JLabel("Subtitle");
        subtitle.setBounds(300,430,100,25);
        f.add(subtitle);
        
        filechoose=new JTextField();
        filechoose.setBounds(400,430,400,25);
        f.add(filechoose);
        
        subtitleadd=new JButton("Open File");
        subtitleadd.setBounds(800,430,100,25);
        subtitleadd.addActionListener(this);
        f.add(subtitleadd);
        
        vector=new JLabel("Vector");
        vector.setBounds(300,460,100,25);
        f.add(vector);
        
        vectorchoose=new JTextField();
        vectorchoose.setBounds(400,460,400,25);
        f.add(vectorchoose);
        
        vectoradd=new JButton("Open file");
        vectoradd.setBounds(800,460,100,25);
        vectoradd.addActionListener(this);
        f.add(vectoradd);
        
        description=new JLabel("Description");
        description.setBounds(300,490,100,25);
        f.add(description);
        descriptiontxt=new JTextArea();
        descriptiontxt.setBounds(300,515,500,120);
        descriptiontxt.setBackground(Color.lightGray);
        f.add(descriptiontxt);
        
        save=new JButton("Submit");
        save.addActionListener(this);
        save.setBounds(300,645,100,25);
        save.setForeground(Color.white);
        save.setBackground(Color.blue);
        f.add(save);
        
        reset=new JButton("Reset");
        reset.addActionListener(this);
        reset.setBounds(405,645,100,25);
        reset.setForeground(Color.white);
        reset.setBackground(Color.blue);
        f.add(reset);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0,0,1000,1000);
        f.add(p1);
        
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==save){
           try{
          Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","");
        Statement st2=con.createStatement();
           String moviename=movietxt.getText();
           String rating=ratingtxt.getText();
           String actor1=actor1txt.getText();
           String actor2=actor2txt.getText();
           String actor3=actor3txt.getText();
           String genre=genretxt.getText();
           String year=yeartxt.getText();
           String budget=budgettxt.getText();
           String description=descriptiontxt.getText();
           String sql="insert into moviedata (moviename,rating,actor1,actor2,actor3,genre,year,budget,description) values('"+moviename+"','"+rating+"','"+actor1+"','"+actor2+"','"+actor3+"','"+genre+"','"+year+"','"+budget+"','"+description+"')";
           st2.executeUpdate(sql);
           }catch(ClassNotFoundException | SQLException ae){System.out.println("error"+ae.getMessage());}
       }
       if(e.getSource()==reset){
           movietxt.setText("");
           ratingtxt.setText("");
           actor1txt.setText("");
           actor2txt.setText("");
           actor3txt.setText("");
           genretxt.setText("");
           yeartxt.setText("");
           budgettxt.setText("");
           descriptiontxt.setText("");
       }
       if(e.getSource()==subtitleadd){
           JFileChooser datafile= new JFileChooser();		
        int returnValue = datafile.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {   
        	File selectedFile = datafile.getSelectedFile();  
                String filename=selectedFile.toString(); 
                filechoose.setText(filename);
	}
       }
       if(e.getSource()==vectoradd){
           JFileChooser datafile= new JFileChooser();		
        int returnValue = datafile.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {   
        	File selectedFile = datafile.getSelectedFile();  
                String filename=selectedFile.toString();
                vectorchoose.setText(filename);
	}
       }
    }
}
/*class a15{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AdminDataAdd admin1=new AdminDataAdd();
    }
}*/
