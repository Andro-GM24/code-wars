/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemas;

import gestiondeinventarios.*;

/**
 *
 * @author Andro
 */
public class GestionarPago {
    
    
    /*función que resta el saldo o cobra al cliente*/
    public boolean RecibirPagoCliente(Persona h,Productos p,int cantidad){
        if(h.getSaldo()>(p.getPrecio()*cantidad)){
           h.setSaldo(h.getSaldo()-(p.getPrecio()*cantidad));
           return true;
        }else{
             return false;
        }
        
    }
    
    /*funcion que recibe pago desde la vista del vendedor*/
    
    public void RecibirPagoVendedor(Persona j,Productos p,int cantidad){
         j.setSaldo(j.getSaldo()+(p.getPrecio()*cantidad));
    }
    
    
    
}
