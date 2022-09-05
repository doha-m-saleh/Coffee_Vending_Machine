/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.Berverage;
import Model.Machine;

/**
 *
 * @author user
 */
public class OrderTransaction {
   private int Balance;

private int Change;
private Berverage beverage;
private boolean Cancel;
private double coffee_shot=1.00;
private double Sugar=1.00;
private boolean start;
private int OrderPrice;
private double cap_price= 10.00;
private double macc_price= 15.00;
private double ess_price= 20.00;
     
   

public OrderTransaction(){
int Balance= this.Balance;
 int OrderPrice=this.OrderPrice;
 int Change=this.Change;
Berverage beverage=this.beverage;
 boolean Cancel=this.Cancel;
 double coffee_shot=this.coffee_shot;
 double Sugar=this.Sugar;
}
//double CalculatePrice( Berverage a){
    
 //   if (a.name.equals("")){
    
  // double total_price =beverage.price+beverage.sugar+beverage.coffee_shot;
  //  }
    
   // return total_price;


//}

public void StartOrder(){
   Machine a = new Machine();
   a.SetWaterVolume(a.GetWaterVolume()-20);
   a.setorderstatus(true);

}


public void CancelOrder(){
   Machine a = new Machine();
   a.SetWaterVolume(a.GetWaterVolume()+20);
   a.setorderstatus(false); 
    
}

}
