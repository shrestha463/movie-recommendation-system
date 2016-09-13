/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jayan
 */
class label {
    public static void main(String[] args) {
       JFrame frame=new JFrame("test");
       frame.setSize(500,500);
       
       JPanel textarea=new JPanel();
       textarea.setBounds(0,0,200,200);
       frame.add(textarea);
       
       
       JTextArea b1=new JTextArea("this is a paragraph wirh iub kthw ful foem oif rhe "
               + "hgskyfschc,jfjhgjkbjhklhkl");
      b1.setBounds(10,10,100,200);

       
       JScrollPane scroll=new JScrollPane(b1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       textarea.add(scroll);
       //textarea.add(scroll);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
 