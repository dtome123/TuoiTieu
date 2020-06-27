/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ConnectionDB {

    Statement createStatement;
    

public Connection getConnect() {
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=SQLWeather";
            String user =  "sa";
            String pass ="123456789";
            Class.forName(driver); //load driver
            Connection con = DriverManager.getConnection(url,user,pass); //connect to DB
            return con;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return null;
        }
    } 
}
