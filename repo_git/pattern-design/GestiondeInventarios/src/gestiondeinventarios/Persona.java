/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeinventarios;

/**
 *
 * @author Andro
 */
public class Persona {
    
    public String nombre,direccion;
    public int saldo;

    public Persona(String nombre, String direccion, int saldo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.saldo = saldo;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
   
    
}
