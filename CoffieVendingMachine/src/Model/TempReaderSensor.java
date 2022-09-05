/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Esper.Config;
import Events.WaterHeaterSensor;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISala
 */
public class TempReaderSensor extends Thread {
    private int random(int min, int max) {
        
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    private Machine Machinee;
    private int temp;
    
    public TempReaderSensor (Machine Machinee) {
        this.Machinee = Machinee;
        this.temp = 20;
    }
    
    public void raiseTemp() {
        temp += random(5, 10);
    }
    
    public void idle() {
        if (temp > 20) {
            temp -= 0.5;
        } else {
            temp += random(2, 5);
        }
    }
    
    @Override
    public void run() {
        while (true) {
            
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TempReaderSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Config.sendEvent(new WaterHeaterSensor(temp));
        }
    }
}
