/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adiciones;

import cafeteria_decorator.*;
/**
 *
 * @author Andro
 */
public class Brandy extends CafeDecorator {
    
    public Brandy(Cafe cafepersonalizado) {
        super(cafepersonalizado);
    }
    
    @Override
    public float getPrecio() {
       return super.getPrecio()+ 2500; 
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion()+ " brandy,";
    } 
}
