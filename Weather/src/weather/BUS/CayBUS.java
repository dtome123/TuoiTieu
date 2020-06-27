/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.BUS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import weather.DB.ConnectionDB;
import weather.DB.Execute;

/**
 *
 * @author Admin
 */
public class CayBUS {
    
    public void getListCay(){
        ConnectionDB db = new ConnectionDB();
        Connection con = db.getConnect();
        String sql ="select * from Cay";
        ResultSet rs = null;
        Execute ex = new Execute();
        try {
            rs=ex.ExcuteSELECT(sql, con);
            while(rs.next()){
                System.out.println("Ma: "+ rs.getString("MaCay"));
            }
            
        } catch (SQLException ex1) {
            Logger.getLogger(CayBUS.class.getName()).log(Level.SEVERE, null, ex1);
            
        }
        
        
    }
    
}
