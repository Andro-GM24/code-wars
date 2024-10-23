/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeinventarios;

import java.util.ArrayList;

/**
 *
 * @author Andro
 */
public class Bodega {
    
     ArrayList<Productos> disponibles = new ArrayList<Productos>();

    public Bodega(int a, Productos b) {
        
        for (int i = 0; i < a; i++) {
            this.disponibles.add(new Productos("",0)); // Reemplaza Elemento por el tipo real que estés usando
        }
        
        
    }
    

    public ArrayList<Productos> getDisponibles() {
        return disponibles;
    }

    public void Añadir_productos(Productos e) {
        disponibles.add(e);
    }
    
    
    
    
     
     

    
}
