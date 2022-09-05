/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class water_volume extends Thread{
 
    

    
    private Machine Machinee;

    public water_volume(Machine Machinee, int vol) {
        this.Machinee = Machinee;
        this.vol = vol;
    }
    private int vol;
public void raisevol() {
       Machinee.SetWaterVolume(100);
    }

public boolean check_water_level(){

if(Machinee.GetWaterVolume()>20){
        System.out.println("level is adequate");    
        return true;
    }
else {
  System.out.println("Water level is very low!!!");    
        return false;}
}
    

    @Override
      public void run() {
        while (true) {
            if (Machinee.OrderCheck()) {
                if(check_water_level()== false){
                    raisevol();
                }
            } else {
              //  Machinee.Getwater_weight_Sensor().idle();
              //  Proceed with order
            }
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WaterHeaterM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    
}
