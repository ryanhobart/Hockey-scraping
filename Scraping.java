/* The purpose of this class is to access the supplied webpage to determine if it exists, and if it does,
* to grab all the table data from it and provide it back to the main class as an ArrayList of ArrayLists of Strings. Each string
represents a token in the table, so the 2d ArrayList is a direct representation of the table.
*/

package hockeyscraping;

import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ryan
 */
public class Scraping {
    
    private static List<String[]> ListLineTokens = null;
    String tableClass;
    
    //instantiation for scraping adds the link and creats the 2d array list of strings
    public Scraping(){
        ListLineTokens = new ArrayList<String[]>(); //ArrayList implementation for real use
    }
    

    public List<String[]> getGameData(String link) {

        Document doc = null;
        String line = null;
        String delims = "[ ]+"; //within the square braces is the delimiter for the elements. 
        //ArrayList<String> temp = new ArrayList<String>(); 
        String[] tempLineTokens = null;
        //String[][] arrayLineTokens = new String[400][60]; //Array implementation for quick testing
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
    
    public List<String[]> getPlayerNames(String link){
        Document doc = null;
        String line = null;
        String delims = "[ ]+"; //within the square braces is the delimiter for the elements. 
        //ArrayList<String> temp = new ArrayList<String>(); 
        String[] tempLineTokens = null;
        
        List<String[]> rosterNames = new ArrayList<String[]>();
        //String[][] arrayLineTokens = new String[400][60]; //Array implementation for quick testing
        try{ //attempt to connect to the link provided
            doc = Jsoup.connect(link).maxBodySize(0).get();
        
        }catch (IOException e) {
            e.printStackTrace();
        }
        //these next lines traverse the tree in the HTML code to find the table we're looking for
        Element page = doc.getElementById("page_container");
        Element content = doc.getElementById("page_content");
        Element all_roster = content.getElementById("all_roster");
        Element roster = all_roster.getElementById("roster");
        
        for(Element table : roster.select("table")){
            for(Element row : table.select("table")){
                line = row.text();//get the text from the row
                tempLineTokens = line.split(delims);//split it into tokens
            }
        }
        /*The data for the roster comes in one long line of string tokens
        * The following for loop organizes the string tokens into an array list for
        * the whole roster which will more closely represent the table fromt the website.
        * This will be easier to search and utilize.
        */
        int goalieBuffer = 0; /*this buffer prevents the tempLineTokens counter from getting ahead of the
        * temp counter when there's a goalie to add to the roster. Goalie lines are 3 tokens shorter,
        * so for each goalie, the internal for loop needs to run 3 times without adding data from tempLineTokens.
        * After it does this, goalieBuffer increases by 3, and is subtracted from the index when accessing data in
        * tempLineTokens to prevent getting ahead.
        */
        for(int j = 11; j < tempLineTokens.length; j=j+18){

            String [] temp = new String[18];            
            for(int i = 0; i < 18; i++){
                if(j+14 < tempLineTokens.length){ //this checks to make sure the look ahead for GAA doesn't exceed the limits of tempLineTokens
                    if(j+i < tempLineTokens.length && !tempLineTokens[j+14-goalieBuffer].equals("GAA")){ //this check if it's a goalie line, and makes sure we're staying inside the limits of tempLineTokens
                        //code for adding a skater line
                        temp[i] = tempLineTokens[j+i-goalieBuffer];
                    }else{
                        //code for adding a goalie line
                        if(i < 15)
                            temp[i] = tempLineTokens[j+i-goalieBuffer];
                        else if(15 <= i && i <18)
                          temp[i] = "";
                 }}}
            //code for increasing goalieBuffer. Has to be outside of adding the goalie line, so that it is only increased once per goalie line
            if(j+14 < tempLineTokens.length){
                if(tempLineTokens[j+14-goalieBuffer].equals("GAA")){
                        goalieBuffer = goalieBuffer + 3;
            }}
            rosterNames.add(temp);//adds the created string array to the roster list
        }
        return rosterNames;
    }}
