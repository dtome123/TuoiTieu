/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.BUS;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import weather.DAO.Weather;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class WeatherController implements Initializable {
   @FXML
   private TableView<Weather> TableWeather;
   
   @FXML
   private TableColumn<Weather , String> date;
   
    @FXML
    private TableColumn<Weather , Double> humidity;
    
    @FXML
    private TableColumn<Weather , Double> rainfall;
    
    @FXML
    private TableColumn<Weather , Double> temperature;
    
    private ObservableList<Weather> weatherlist;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        APIWeather api = new APIWeather();
        String json =null;
        try {
             json= api.getJSON();
             System.out.println(json);
        } catch (IOException ex) {
            Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, ex);
        }
       weatherlist = FXCollections.observableArrayList(api.parseJsonToArray(json));
       date.setCellValueFactory(new PropertyValueFactory<Weather,String>("date"));
       
       humidity.setCellValueFactory(new PropertyValueFactory<Weather,Double>("rh"));
       
       rainfall.setCellValueFactory(new PropertyValueFactory<Weather,Double>("precip"));
        
       temperature.setCellValueFactory(new PropertyValueFactory<Weather,Double>("temp"));
       TableWeather.setItems(weatherlist);  
    }    
    
}
