/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Esper;
import Events.BreverageNumber;
import Events.MachineOnOFF;
import Events.WaterHeaterSensor;
import Events.WaterHeaterOff;
import Events.water_weight_Sensor;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;



public class Config {
    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
    public static void registerEvents() {
        engine.getEPAdministrator().getConfiguration().addEventType(WaterHeaterSensor.class);
        engine.getEPAdministrator().getConfiguration().addEventType(WaterHeaterOff.class);
        engine.getEPAdministrator().getConfiguration().addEventType(MachineOnOFF.class);
        engine.getEPAdministrator().getConfiguration().addEventType(BreverageNumber.class);
        engine.getEPAdministrator().getConfiguration().addEventType(water_weight_Sensor.class);
        System.out.println("Events Successfully Registered.");
    }

    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }
    
    public static void sendEvent(Object o)
    {
        engine.getEPRuntime().sendEvent(o);
    }

}
