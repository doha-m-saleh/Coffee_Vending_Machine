/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ISala
 */
public class Macchiato extends Berverage {
    private final double req_Coffie;
    private final double req_Milk;
    private double req_Suger;
    private final double req_Water;

    public Macchiato(double req_Coffie, double req_Milk, double req_Suger, double req_Water, String name, int ID) {
        super(name,ID);
        this.req_Coffie = req_Coffie;
        this.req_Milk = req_Milk;
        this.req_Suger = req_Suger;
        this.req_Water = req_Water;
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
    public void AddExtraSuger(double Suger){
        req_Suger+=Suger;
    }
    
    
}
