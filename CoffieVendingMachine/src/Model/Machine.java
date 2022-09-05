/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import View.CoffieMachineView;
import Esper.Config;
import Events.MachineOnOFF;
import Events.WaterHeaterOff;
import Events.water_weight_Sensor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISala
 */
public class Machine {
    
    private CoffieMachineView gui;
   
    //ReCreating varibles Of Classes
    private boolean state = true;
    private boolean start =false;
    ArrayList Brevrages = new ArrayList();
    public int BrevrageID=0;
    int counter=0;
    private int extraSuger=0;
    private int ExtraSugerCounter=0;
     private boolean Lock=true;
     private int  BNumber;
     private int BTemp;
     private int Start=-3;
    private double intial_water_vol=100;
    private boolean isPlacingOrder = true;
    
    //Create Objects 
    private final TempReaderSensor tempReaderSensor;
    private final WaterHeaterM waterHeaterM ;
     private final WaterHeaterOn_Off WOO;
     private Cappuccino Capp;
     private Macchiato macchito;
     private Espresso espresso;
     private Screen screen;
     private water_weight_Sensor  water_volume_sensor;
     private OrderTransaction OT;
     private water_volume WV;
    
    
     
    
     
    
    public Machine(){
        gui = new CoffieMachineView();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        
        //Define
      
      
               
            
        
        //Constructors Call
         WOO = new WaterHeaterOn_Off(this);
         tempReaderSensor = new TempReaderSensor(this);
         waterHeaterM = new WaterHeaterM(this);
         screen =new Screen(this);
         WV=new water_volume(this,100);
        
         water_volume_sensor = new water_weight_Sensor(this.intial_water_vol);
         
         
        //Start the Threads
        tempReaderSensor.start();
        waterHeaterM.start();
        WV.start();
        
    }
    public void tempSignal(int temp) throws InterruptedException {
        System.out.println("The temp is now " + temp);
        gui.getCurrentTempTxt1().setText(temp + "");
         BTemp =temp;
        if (temp >= 100) {
           
            Config.sendEvent(new WaterHeaterOff(false));
            
      
            
        }
        
        else if(temp <=50){
        Config.sendEvent(new WaterHeaterOff(true));
        
        if(temp<=50)
          gui.getMacchiato().setEnabled(false);
        gui.getEspresso().setEnabled(false);
        gui.getCappcation().setEnabled(false);
        gui.getSuger_Shot().setEnabled(false);
         
        }else{
         gui.getMacchiato().setEnabled(true);
        gui.getEspresso().setEnabled(true);
        gui.getCappcation().setEnabled(true);
        gui.getSuger_Shot().setEnabled(true);
        }
        
    }
    public void StartMachine(boolean Start)throws InterruptedException{
            
            Config.sendEvent(new MachineOnOFF(true));
    }
    
    public void SelectBervarage(int BrevrageNumber){
        String[] Brevrage ={"Macchito 3$","Cappuccino 4$","Expresso 7$"};
        int[] SugerMoney = {0,1,2,3};
        int[] BervrageMoney ={3,4,7};
        new Thread(() -> {
            
            switch (BrevrageNumber) {
                case 1:
                    
                    if(Lock){
                   
                    macchito = new Macchiato(30,30+extraSuger,30,30,"Macchiato",0);
                    gui.getCurrentTempTxt().setText(Brevrage[BrevrageNumber-1]+"\r\n");
                    System.out.println(Brevrage[BrevrageNumber-1]);
                    gui.getMacchiato().setEnabled(false);
                    Start=0;
                    Lock=false;
                    BNumber=BrevrageNumber;
                    }
                  
                    
                    break;
                   
                case 2:
                     if(Lock){
                    System.out.println("BNumber 1");
                    Capp =new Cappuccino(30,30+extraSuger,30,"Cappuccino",0);
                    gui.getCurrentTempTxt().setText(Brevrage[BrevrageNumber-1]+"\r\n");
                    Lock=false;
                    Start=0;
                    gui.getCappcation().setEnabled(false);
                    BNumber=BrevrageNumber;
                 
                     }
                 break;
                case 3:
                    if(Lock){
                    System.out.println("BNumber 3");
                    gui.getEspresso().setEnabled(false);
                    espresso = new Espresso(30,30+extraSuger,30,30,"Expresso",0);
                     gui.getCurrentTempTxt().setText(Brevrage[BrevrageNumber-1]+"\r\n");
                    Lock=false;
                    Start=0;
                    
                   BNumber=BrevrageNumber;
                   
                    }
                  break;
                case 4:
                    if(ExtraSugerCounter<=2){
                    extraSuger+=1;
                    gui.getSuger_Shot().setEnabled(true);
                    System.out.println(extraSuger);
                    ExtraSugerCounter++;
                    gui.getCurrentTempTxt().setText(Brevrage[BNumber-1]+"+"+extraSuger+"$");
                    
                    }else{
                        ExtraSugerCounter=0;
                        extraSuger=0;
                        gui.getCurrentTempTxt().setText(Brevrage[BNumber-1]);
                    }
                    
                    break;
                case 5:
                    if(BTemp>=50){
                        System.out.println(BTemp);
                  Lock=true;
                  extraSuger=0;
                  ExtraSugerCounter=0;
                  gui.getCurrentTempTxt().setText(" ");
                  gui.getMacchiato().setEnabled(true);
                  gui.getCappcation().setEnabled(true);
                  gui.getEspresso().setEnabled(true);
                  BNumber=0;
                  Start=-1;
                    }
                    
                case 6:
                    if(Start==0){
                        Start=1;
                        System.out.println("a7a");
                        System.out.println(BNumber);
                        System.out.println(extraSuger);
                        gui.getCurrentTempTxt().setText(("Total Amount : "+(SugerMoney[extraSuger]+BervrageMoney[BNumber-1]))+"$");
                        
                    }
                    else if(Start==1){
                       gui.getCurrentTempTxt().setText("Preparing");
                       
           
                    }}
            
                
            
        }).start();
      
                 

      
        
        
    }
    
    
          public double GetWaterVolume() {
        return intial_water_vol;
    }
        public void SetWaterVolume(double vol) {
        this.intial_water_vol = vol;
       
    }
    public CoffieMachineView getGUI() {
        return gui;
    }
    public WaterHeaterM GetWaterHeaterM() {
        return waterHeaterM;
    }
    public TempReaderSensor GetTempReaderSensor() {
        return tempReaderSensor;
    }
      public boolean isMachineOn() {
        return state;
    }
        
      
     
    
     public void setState(boolean state) {
        this.state = state;
        this.WOO.setState(state);
       
    }
          public void setorderstatus(boolean status) {
        this.isPlacingOrder = status;
       
    }
     
     public boolean OrderCheck() {
        return isPlacingOrder;
    
}
      
      
  

}
