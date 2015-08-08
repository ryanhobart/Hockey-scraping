/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private static List<List<String>> ListLineTokens = null;
    
    //instantiation for scraping adds the link and creats the 2d array list of strings
    public static void start(String link){
        Scraping.link = link;
        ListLineTokens = new ArrayList<List<String>>();
    }

    public List<List<String>> getLineTokens() {

        Document doc = null;
        String line = null;
        String delims = "[ ]+"; //within the square braces is the delimiter for the elements. 
        ArrayList<String> temp = new ArrayList<String>();
        String[] tempLineTokens = null;
        
        try{ 
            doc = Jsoup.connect(link).maxBodySize(0).get();
        
        }catch (IOException e) {
            e.printStackTrace();
        }
        for (Element table : doc.select("table")) {
            int j = 0;
            ListLineTokens.add(null);
            for(Element row : table.getElementsByClass("evenColor")){

                         
                line = row.text();
                tempLineTokens= line.split(delims);
                
                for(int i = 0; i < tempLineTokens.length; i++)         
 
                        ListLineTokens.get(j).add(tempLineTokens[i]);
                        
            }
         
        j++   ; 
        }
        

        return ListLineTokens;
    }
}
