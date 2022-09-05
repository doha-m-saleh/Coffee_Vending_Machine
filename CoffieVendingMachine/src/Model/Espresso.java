/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ISala
 */
public class Espresso extends Berverage {
    
    private double req_Coffie;
    private double req_Milk;
    private double req_Suger;
    private double req_Water;

  

    public Espresso(double req_Coffie, double req_Milk, double req_Suger, double req_Water, String name, int ID) {
        super(name,ID);
        this.req_Coffie = req_Coffie;
        this.req_Milk = req_Milk;
        this.req_Suger = req_Suger;
        this.req_Water = req_Water;
    }
    
      public void AddExtraSuger(double Suger){
        req_Suger+=Suger;
    }

    public double getReq_Coffie() {
        return req_Coffie;
    }

    public double getReq_Milk() {
        return req_Milk;
    }

    public double getReq_Suger() {
        return req_Suger;
    }

    public double getReq_Water() {
        return req_Water;
    }

    public void setReq_Coffie(double req_Coffie) {
        this.req_Coffie = req_Coffie;
    }

    public void setReq_Milk(double req_Milk) {
        this.req_Milk = req_Milk;
    }

    public void setReq_Suger(double req_Suger) {
        this.req_Suger = req_Suger;
    }

    public void setReq_Water(double req_Water) {
        this.req_Water = req_Water;
    }
}
