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
    
    public static String getManStrength(int index){
        return tableDataTokens.get(index)[2];
    }
    public static String getEventType(int index){
        return tableDataTokens.get(index)[5];
    }
    public static String[] getPlayerNumbers(int index){
        String[] players = new String[11]; //array of player numbers
        if(Parsing.getEventType(index).equals("GOAL")){
            int count = 1;
            for(int j = 0; j < tableDataTokens.get(index).length; j++){
                if(tableDataTokens.get(index)[j].equals("G") && count == 1){
                    players[0] = tableDataTokens.get(index)[j-16];
                    players[1] = tableDataTokens.get(index)[j-13];
                    players[2] = tableDataTokens.get(index)[j-10];
                    players[3] = tableDataTokens.get(index)[j-7];
                    players[4] = tableDataTokens.get(index)[j-4];
                    players[5] = "||";
                    players[6] = tableDataTokens.get(index)[j+1];
                    players[7] = tableDataTokens.get(index)[j+4];
                    players[8] = tableDataTokens.get(index)[j+7];
                    players[9] = tableDataTokens.get(index)[j+10];
                    players[10] = tableDataTokens.get(index)[j+13];
                    count = 2;
                }}
        }
            
        if(Parsing.getEventType(index).equals("BLOCK")){
            //tokens 17, 20, 23, are away FWDs, 
            // 26, 29, are away D
            // 34, 37 and 40 are home FWDs
            // 43, 46 are home D
            for(int j = 0; j < tableDataTokens.get(index).length; j++){
                if(tableDataTokens.get(index)[j].equals("Zone")){
                    players[0] = tableDataTokens.get(index)[j+1];
                    players[1] = tableDataTokens.get(index)[j+4];
                    players[2] = tableDataTokens.get(index)[j+7];
                    players[3] = tableDataTokens.get(index)[j+10];
                    players[4] = tableDataTokens.get(index)[j+13];
                    players[5] = "||";
                    players[6] = tableDataTokens.get(index)[j+18];
                    players[7] = tableDataTokens.get(index)[j+21];
                    players[8] = tableDataTokens.get(index)[j+24];
                    players[9] = tableDataTokens.get(index)[j+27];
                    players[10] = tableDataTokens.get(index)[j+30];
                }}}
        if(Parsing.getEventType(index).equals("MISS")){
            //tokens 15, 18, 21 are away FWDs, 
            // 24, 27 are away D
            // 32, 35, 38 are home FWDs
            // 41, 44 are home D
            for(int j = 0; j < tableDataTokens.get(index).length; j++){
                if(tableDataTokens.get(index)[j].equals("Zone,")){
                    players[0] = tableDataTokens.get(index)[j+3];
                    players[1] = tableDataTokens.get(index)[j+6];
                    players[2] = tableDataTokens.get(index)[j+9];
                    players[3] = tableDataTokens.get(index)[j+12];
                    players[4] = tableDataTokens.get(index)[j+15];
                    players[5] = "||";
                    players[6] = tableDataTokens.get(index)[j+20];
                    players[7] = tableDataTokens.get(index)[j+23];
                    players[8] = tableDataTokens.get(index)[j+26];
                    players[9] = tableDataTokens.get(index)[j+29];
                    players[10] = tableDataTokens.get(index)[j+32];
                }}}
        if(Parsing.getEventType(index).equals("SHOT")){
            //tokens 16, 19, 22, are away FWDs, 
            // 25, 28, are away D
            // 33, 36 and 39 are home FWDs
            // 42, 45 are home D
            for(int j = 0; j < tableDataTokens.get(index).length; j++){
                if(tableDataTokens.get(index)[j].equals("Zone,")){
                    players[0] = tableDataTokens.get(index)[j+3];
                    players[1] = tableDataTokens.get(index)[j+6];
                    players[2] = tableDataTokens.get(index)[j+9];
                    players[3] = tableDataTokens.get(index)[j+12];
                    players[4] = tableDataTokens.get(index)[j+15];
                    players[5] = "||";
                    players[6] = tableDataTokens.get(index)[j+20];
                    players[7] = tableDataTokens.get(index)[j+23];
                    players[8] = tableDataTokens.get(index)[j+26];
                    players[9] = tableDataTokens.get(index)[j+29];
                    players[10] = tableDataTokens.get(index)[j+32];
                }}}
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
