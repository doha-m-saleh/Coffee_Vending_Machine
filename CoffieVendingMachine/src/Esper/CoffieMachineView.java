/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esper;

import Model.Machine;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.*;  


public class CoffieMachineView{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);

        // Register events
        Config.registerEvents();

        // Create Machine
        Machine Machinee =new Machine();
        
      

        Config.createStatement("select temp from WaterHeaterSensor")
                .setSubscriber(new Object() {
                    public void update(int temp) throws InterruptedException {
                        Machinee.tempSignal(temp);
                    }
                });

        Config.createStatement("select state from WaterHeaterOff")
                .setSubscriber(new Object() {
                    public void update(boolean state) throws InterruptedException {
                        Machinee.setState(state);
                    }
                });
        Config.createStatement("select tato from MachineOnOFF")
                .setSubscriber(new Object() {
                    public void update(boolean tato) throws InterruptedException {
                        Machinee.setState(tato);
                    }
                });
        Config.createStatement("select BNumber from BreverageNumber")
                .setSubscriber(new Object() {
                    public void update(int BNumber) throws InterruptedException {
                        Machinee.SelectBervarage(BNumber);
                         
                   }
                });
          Config.createStatement("select weight from water_weight_Sensor").setSubscriber(new Object(){
        public void update(double Weight) throws InterruptedException {
                        Machinee.SetWaterVolume(Weight);
                    }
        
        
        });
       
        
        
    }

}