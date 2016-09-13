/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jayan
 */
public class DbConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public DbConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            st=con.createStatement();
            
            
        }//end of try
        catch(Exception ex){
            System.out.println("Error : "+ex);
        }//end of catch
    }//end of constructor
    public void getData(){
        try{
            String query="select * from person";
            rs=st.executeQuery(query);
            System.out.println("Records from database");
            while(rs.next()){
                String name=rs.getString("name");
                String age=rs.getString("age");
                System.out.println("Name : "+name+"   "+"Age : "+age);
            }
            
        }//end of try
        catch(Exception ex){
            System.out.println(ex);
        }//end of catch
    }
}