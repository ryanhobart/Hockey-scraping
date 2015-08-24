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
        Scraping one = new Scraping(link); //instantiating Scraping object
        List<String[]> lineTokens = one.getGameData(); //use Scraping to create table of events as 2d array list of strings
        String[] teams = one.getTeams();
        
        //parse data
	Parsing two = new Parsing(lineTokens);
        String home_roster_link = "http://www.hockey-reference.com/teams/" + teams[0] + "/2015.html";
        String away_roster_link = "http://www.hockey-reference.com/teams/" + teams[1] + "/2015.html";
        Scraping home_roster = new Scraping(home_roster_link);
        Scraping away_roster = new Scraping(away_roster_link);
        List<String[]> homeRosterData = home_roster.getPlayerNames();
        List<String[]> awayRosterData = away_roster.getPlayerNames();
        

        //supply data to database
			//learn how to do this
    }  
    
}
