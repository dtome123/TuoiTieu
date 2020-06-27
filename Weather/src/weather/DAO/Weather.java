/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.DAO;

/**
 *
 * @author Admin
 */
public class Weather {
    private String date;  
    private double precip; //luong  mua
    private double temp;// nhiet do
    private double rh;// do am
    
    
    public Weather(){
    }

    public Weather(String date, double precip, double temp, double rh) {
        this.date = date;
        this.precip = precip;
        this.temp = temp;
        this.rh = rh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrecip() {
        return precip;
    }

    public void setPrecip(double precip) {
        this.precip = precip;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getRh() {
        return rh;
    }

    public void setRh(double rh) {
        this.rh = rh;
    }
    
    
    
}
