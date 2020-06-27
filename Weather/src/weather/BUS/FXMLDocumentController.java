/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.BUS;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Admin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnhome;
    @FXML
    private Button btntreelist;
    @FXML
    private Button btnplans;
    @FXML
    private BorderPane bp;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
//        APIWeather q= new APIWeather();
//        try {
//            label.setText(q.Request());
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changehome(ActionEvent event) {
        loadPage("Weather");
        
    }

    @FXML
    private void changetree(ActionEvent event) {
    }

    @FXML
    private void changeplans(ActionEvent event) {
    }
    private void loadPage(String page){
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/weather/GUI/"+page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
        
    }
    
}
