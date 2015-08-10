package hockeyscraping;

import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Ryan
 */
public class Scraping {
    
    static String link = null;
    private static List<String[]> ListLineTokens = null;
    
    //instantiation for scraping adds the link and creats the 2d array list of strings
    public static void start(String link){
        Scraping.link = link;
        ListLineTokens = new ArrayList<String[]>(); //ArrayList implementation for real use
    }

    public List<String[]> getLineTokens() {

        Document doc = null;
        String line = null;
        String delims = "[ ]+"; //within the square braces is the delimiter for the elements. 
        //ArrayList<String> temp = new ArrayList<String>(); 
        String[] tempLineTokens = null;
        //String[][] arrayLineTokens = new String[400][60]; //Array implementation for quick testing
        int i = 0;
        try{ //attempt to connect to the link provided
            doc = Jsoup.connect(link).maxBodySize(0).get();
        
        }catch (IOException e) {
            e.printStackTrace();
        }

        for(Element table : doc.select("table")){ //find each table element
            
            for(Element row : table.getElementsByClass("evenColor")){ //find each row in the table
                
                line = row.text(); //get the text from the row
                tempLineTokens = line.split(delims); //split the text by the delimeters set above
                
                ListLineTokens.add(tempLineTokens); //add each piece of data to the ArrayList representing the entire table
               
            }
            
        }

        return ListLineTokens;
    }
}
