/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import java.util.logging.Logger;

/**
 *
 * Stock_Sensor
 * @author user
 */
public class water_weight_Sensor {
   
  
    
    private double weight;
 public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public static Logger getLOG() {
        return LOG;
    }
    public water_weight_Sensor(double weight) {
        this.weight = weight;
    }
    private static final Logger LOG = Logger.getLogger(water_weight_Sensor.class.getName());

   

    
    
 
    
 
    
}

