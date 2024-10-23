/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeinventarios;


import subsistemas.*;
/**
 *
 * @author Andro
 */
public class Comprar_facade {
    
    public Envio envio;
    public GestionarPago gestionarPago;
    public VerificarDisponibilidad verificarDisponibilidad;

    public Comprar_facade(Envio envio, GestionarPago gestionarPago, VerificarDisponibilidad verificarDisponibilidad) {
        this.envio = envio;
        this.gestionarPago = gestionarPago;
        this.verificarDisponibilidad = verificarDisponibilidad;
    }
    
    public boolean VerDisponibilidad(String nombre,Bodega a,int cantidad){
        if(verificarDisponibilidad.VerificarProducto(nombre) && verificarDisponibilidad.VerDisponibilidad( a,  1)){
                return true;
        }else{
                return false;
                }
    }
    
    
    public boolean comprar (Bodega a,int cantidad, Persona b ,Persona j , Productos c){
       if(verificarDisponibilidad.VerDisponibilidad(a, cantidad) &&  gestionarPago.RecibirPagoCliente(b, c, cantidad)  ){
           gestionarPago.RecibirPagoVendedor(j, c, cantidad);
           return true;
       }else{
           return false;
       }
    }
    
    public String enviar(Bodega a,int cantidad,String nombre,String direccion,String total,String producto){
        envio.EnviarProducto(a, cantidad);
        return envio.GenerarFactura(nombre, direccion, total, producto);
    }
    
    
    
}
