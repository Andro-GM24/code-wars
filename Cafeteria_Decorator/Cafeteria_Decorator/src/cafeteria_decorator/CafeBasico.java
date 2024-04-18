/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafeteria_decorator;

/**
 *
 * @author Estudiantes
 */
public class CafeBasico implements Cafe {

    public String descripcion;
    public float precio;
    
    
    @Override
    public float getPrecio() {
        return 2500; 
    }

    @Override
    public String getDescripcion() {
        return " espresso, ";
    }
    
}
