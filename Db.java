/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hockeyscraping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import org.jsoup.Connection;

/**
 *
 * @author Ryan
 */
public class Db {
    
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    public static List<String[]> data;
    
    public Db(){
        data = new ArrayList<String[]>();
    }
    
}
