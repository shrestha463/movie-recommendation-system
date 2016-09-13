/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import javax.swing.JOptionPane;
import java.io.IOException;
//import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.util.ArrayList;

public class EnTagRec{

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) throws IOException, ClassNotFoundException{
        String str=JOptionPane.showInputDialog("Write the text");
        String newstr=Stopwords.removeStopWords(str);
//        String newstr=Stopwords.removeStemmedStopWords(str);
        JOptionPane.showMessageDialog(null, newstr);

       // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger(
                "models/english-left3words-distsim.tagger");
 
        // The sample string
        String sample = new String(newstr);
 
        // The tagged string
        String tagged = tagger.tagString(sample);
 
//        Output the tagged string
//        JOptionPane.showMessageDialog(null, tagged);
		
	String x[] = tagged.split(" ");
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < x.length; i++) {
            if (x[i].substring(x[i].lastIndexOf("_") + 1).startsWith("N")) {
                list.add(x[i].split("_")[0]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            // Output the result
            JOptionPane.showMessageDialog(null, list.get(i));
        }
    }
}