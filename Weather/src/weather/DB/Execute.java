/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Execute {
    
    public void ExcuteINSERTDELETEUPDATE(String sql, Connection connection) {
        try {
            Statement statement = connection.createStatement();

            int n = statement.executeUpdate(sql);
            if (n >= 1) {
                System.out.println(" sucess");
            } else {
                System.out.println("erro !!!");
            }
            connection.close();

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    public ResultSet ExcuteSELECT(String sql, Connection connection) {
        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            return rs;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return null;
        }

    }
    


    
}
