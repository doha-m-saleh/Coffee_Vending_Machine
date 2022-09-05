/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.Cappuccino;
/**
 *
 * @author user
 */
public class Ingredient_Handler {
    
    private Ingredient_Handler() {
    }
    
    public static Ingredient_Handler getInstance() {
        return Ingredient_HandlerHolder.INSTANCE;
    }
    
    private static class Ingredient_HandlerHolder {

        private static final Ingredient_Handler INSTANCE = new Ingredient_Handler();
    }
    
    
    double Detect_Water_Quantity(Cappuccino a){
    double water= a.getReq_Water();
    return water;
    }
    
    
     
     
     double Detect_Coffee_Quantity(Cappuccino a){
    double coffee= a.getReq_Coffie();
    return coffee;
    }

    private static class Beverage {

        public Beverage() {
        }
    }

  double Detect_Sugar_Quantity(Cappuccino a){
    double sugar;
    
   
    
    
    
        sugar = a.getReq_Suger();
    return sugar;
    }
}