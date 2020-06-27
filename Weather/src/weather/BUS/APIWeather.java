/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.BUS;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.Context;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Callback;
import org.json.JSONException;
import org.json.JSONObject;
import sun.awt.AppContext;
import weather.Main;
import org.json.JSONArray;
import weather.DAO.Weather;


/**
 *
 * @author Admin
 */
public class APIWeather {
    public APIWeather(){}
    public String getJSON() throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
        .url("https://api.weatherbit.io/v2.0/forecast/daily?city=saigon,VN&key=9a86e2ecb49b481fae7b9c447eda3964")
        .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    public ArrayList<Weather> parseJsonToArray(String JSon){
        ArrayList<Weather> list = new ArrayList<>();
        try {
            JSONObject root  = new JSONObject(JSon);
            JSONArray listWeather = root.getJSONArray("data");
            for(int i= 0; i< listWeather.length();i++){
            JSONObject jsondata = listWeather.getJSONObject(i);
            String date = jsondata.getString("valid_date");     
            double precip = jsondata.getDouble("precip"); 
            double temp = jsondata.getDouble("temp"); 
            double rh = jsondata.getDouble("rh"); 
            
            Weather tmp = new Weather(date, precip,temp,rh);
            list.add(tmp);
            
          }
        } catch (JSONException ex) {
            Logger.getLogger(APIWeather.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  list;
    }
 
    
    
    
}
