/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemas;

import gestiondeinventarios.Bodega;

/**
 *
 * @author Andro
 */
public class VerificarDisponibilidad {
    
    /*función que al recibir el nombre busca que este disponible en Bodega*/
    public boolean VerificarProducto(String nombre){
        if(nombre.equals("camiseta") || nombre.equals("jeans") || nombre.equals("saco") || nombre.equals("chaqueta") || nombre.equals("pantalon")  ){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean VerDisponibilidad(Bodega c,int cantidad){
        
        if(c.getDisponibles().size() >= cantidad){
            return true;
        }else{
            return false;
        }
        
        
    }
    
    
}
