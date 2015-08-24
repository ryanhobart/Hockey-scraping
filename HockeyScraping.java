/*
* The purpose of this project is to scrape information from game stat sheets provided
* by NHL.com. This data collected will be supplied to a database in different forms
* in order to allow statistical analysis.
*/
 
 /*
 Start date: May 4th 2015
 Last update: August 9th 2015 (added comments, did some quick testing of functionality)
 Current functionality: Will retrieve text from provided website as a table. Currently unable to split into individual events for parsing
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
        String link = "http://www.nhl.com/scores/htmlreports/20142015/PL030416.HTM"; //test game sheet
        Scraping one = new Scraping(); //instantiating Scraping object
        List<String[]> lineTokens = one.getGameData(link); //use Scraping to create table of events as 2d array list of strings
        
        //parse data
	Parsing two = new Parsing(lineTokens);
        String home_roster_link = "http://www.hockey-reference.com/teams/CHI/2015.html";
        String away_roster_link = "http://www.hockey-reference.com/teams/TBL/2015.html";
        Scraping home_roster = new Scraping();
        Scraping away_roster = new Scraping();
        List<String[]> homeRosterData = home_roster.getPlayerNames(home_roster_link);
        //List<String[]> awayRosterData = away_roster.getPlayerNames(away_roster_link);
        for(int i = 0; i < homeRosterData.size(); i++){
            for(int j = 0; j < homeRosterData.get(i).length; j++){
                System.out.print(homeRosterData.get(i)[j] + ", ");
            }
            System.out.println("");
            
        }

        //supply data to database
			//learn how to do this
    }  
    
}
