/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafeteria_decorator;

/**
 *
 * @author Estudiantes
 */
public class CafeDecorator implements Cafe{
    private Cafe cafepersonalizado;
    
    public CafeDecorator(Cafe cafepersonalizado){
        this.cafepersonalizado=cafepersonalizado;
    }

    @Override
    public float getPrecio() {
       return cafepersonalizado.getPrecio(); 
    }

    @Override
    public String getDescripcion() {
        return cafepersonalizado.getDescripcion();
    }
}
