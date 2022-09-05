/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ISala
 */
public class WaterHeaterOn_Off {
     private boolean state;
    private WaterHeaterOn_Off WOO;
    private Machine Machinee;

    public WaterHeaterOn_Off(Machine Machinee) {
        this.state = false;
        this.Machinee = Machinee;
    }

    public void setState(boolean state) {
        this.state = state;
        
}}
