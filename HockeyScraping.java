/*
* The purpose of this code is to scrape information from game stat sheets provided
* by NHL.com. This data collected will be supplied to a database in different forms
* in order to allow statistical analysis.
 */
package hockeyscraping;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ryan
 */
public class HockeyScraping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //grab data
        String link = "http://www.nhl.com/scores/htmlreports/20132014/PL030314.HTM";
        Scraping one = new Scraping();
        one.start(link);
        List<List<String>> lineTokens = one.getLineTokens();
        
        for(int i = 0; i < lineTokens.size(); i++){
            for(int j = 0; j < lineTokens.get(i).size(); j++){
                System.out.print(lineTokens.get(i).get(j));
            }
            System.out.println("");
        }
        //parse data
        
        //supply data to database
        
    }   
}
