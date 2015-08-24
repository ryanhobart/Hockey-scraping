/* The purpose of this class is
*
*/
package hockeyscraping;

import java.util.List;

/**
 *
 * @author Ryan
 */
public class Parsing {
    public static List<String[]> tableDataTokens;
    
    public Parsing(List<String[]> tableDataTokens){
        this.tableDataTokens = tableDataTokens;        
    }
    
    public static String manStrength(int index){
        return tableDataTokens.get(index)[2];
    }
    public static String eventType(int index){
        return tableDataTokens.get(index)[5];
    }
    public static String[] getPlayerNumbers(int index){
        String[] players = new String[10]; //array of player numbers
        if(Parsing.eventType(index).equals("BLOCK")){
            //tokens 17, 20, 23, are away FWDs, 
            // 26, 29, are away D
            // 34, 37 and 40 are home FWDs
            // 43, 46 are home D
            players[0] = tableDataTokens.get(index)[17];
            players[1] = tableDataTokens.get(index)[20];
            players[2] = tableDataTokens.get(index)[23];
            players[3] = tableDataTokens.get(index)[26];
            players[4] = tableDataTokens.get(index)[29];
            players[5] = tableDataTokens.get(index)[34];
            players[6] = tableDataTokens.get(index)[37];
            players[7] = tableDataTokens.get(index)[40];
            players[8] = tableDataTokens.get(index)[43];
            players[9] = tableDataTokens.get(index)[46];
            
        }
        if(Parsing.eventType(index).equals("MISS")){
            //tokens 15, 18, 21 are away FWDs, 
            // 24, 27 are away D
            // 32, 35, 38 are home FWDs
            // 41, 44 are home D
            players[0] = tableDataTokens.get(index)[15];
            players[1] = tableDataTokens.get(index)[18];
            players[2] = tableDataTokens.get(index)[21];
            players[3] = tableDataTokens.get(index)[24];
            players[4] = tableDataTokens.get(index)[27];
            players[5] = tableDataTokens.get(index)[32];
            players[6] = tableDataTokens.get(index)[35];
            players[7] = tableDataTokens.get(index)[48];
            players[8] = tableDataTokens.get(index)[41];
            players[9] = tableDataTokens.get(index)[44];

        }
        if(Parsing.eventType(index).equals("SHOT")){
            //tokens 16, 19, 22, are away FWDs, 
            // 25, 28, are away D
            // 33, 36 and 39 are home FWDs
            // 42, 45 are home D
            players[0] = tableDataTokens.get(index)[16];
            players[1] = tableDataTokens.get(index)[19];
            players[2] = tableDataTokens.get(index)[22];
            players[3] = tableDataTokens.get(index)[25];
            players[4] = tableDataTokens.get(index)[28];
            players[5] = tableDataTokens.get(index)[33];
            players[6] = tableDataTokens.get(index)[36];
            players[7] = tableDataTokens.get(index)[39];
            players[8] = tableDataTokens.get(index)[42];
            players[9] = tableDataTokens.get(index)[45];
        }
        return players;    
    }
    public static String[] retriveName(String playerNumber, List<String[]> rosterData){
        String[] name = null;
        for(int i = 0; i < rosterData.size(); i++){
            if(rosterData.get(i)[0].equals(playerNumber)){
                name[0] = rosterData.get(i)[2];
                name[1] = rosterData.get(i)[3];
            }
        }
        return name;
    }

}
