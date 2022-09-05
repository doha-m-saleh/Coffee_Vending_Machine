/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ISala
 */
public class Berverage {

     private int ID;

    public Berverage(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
     private String name;
    public Berverage(String name,int ID) {
        
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

   
    
    
}
