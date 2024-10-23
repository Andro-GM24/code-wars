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
public class Envio {
    public void EnviarProducto(Bodega c , int cantidad ){
        c.getDisponibles().remove(c.getDisponibles().size()-cantidad);
        
    }
    
    
    public String GenerarFactura(String nombre,String direccion,String total,String producto){
        
        return "el cliente "+nombre+" compró una/varias referencias de " + producto +" pagando un total de "+total+" $ para recibir en la direccion "+ direccion ;
    }
}
