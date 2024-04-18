/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafeteria_decorator;

import adiciones.*;
import java.util.Scanner;
/**
 *
 * @author Estudiantes
 */
public class Cafeteria_Decorator {
    
    static Cafe b;
    
    public void darDatos(){
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
         System.out.println("su factura es de " + b.getPrecio() + " pesos y contiene "+ b.getDescripcion());
         System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*CafeBasico a = new CafeBasico();*/
        Cafeteria_Decorator cafeteria = new Cafeteria_Decorator();
       
        Scanner leer = new Scanner(System.in);
       char numero_opcion=0;
        do{
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
       
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("/////////////////////////////////////////// BIENVENIDO//////////////////////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("/////////////////////////////////ELIJA//SU//CAFE ESCRIBIENDO EL NUMERO DEL CAFE A PEDIR/////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////1.Mocca////////////////////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////2.irish////////////////////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////3.latte////////////////////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////4.Americano////////////////////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////5.Capuccino////////////////////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////6.Carajillo////////////////////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////7.Azteca////////////////////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
         numero_opcion=leer.next().charAt(0);
        
        
        switch(numero_opcion) {
            case '1' -> {
                 b = new Chocolate(new Leche(new EspumadeLeche(new CafeBasico())));
                break;
            }
            
            case '2' ->{
                b= new Wiskhy(new EspumadeLeche(new CafeBasico()));
                break;
            }
            
            case '3' ->{
                b= new Leche(new EspumadeLeche(new CafeBasico()));
                break;
            }
            case '4' ->{
                b=new Agua(new CafeBasico());
                break;
            }
            case '5' ->{
                b= new Leche(new EspumadeLeche(new CafeBasico()));
                break;
            }
            
            case '6' ->{
                b= new Brandy(new CafeBasico());
                break;
            }
            case '7' ->{
                b=new Leche(new Hielo(new Helado(new CafeBasico())));
                break;
            } 
            
        }
        
        cafeteria.darDatos();
        
        b=null;
        
        
            System.out.println("si quiere pedir otro ingrese 0 si no ingrese cualquier caracter ");
            numero_opcion=leer.next().charAt(0);
        
            
           
             
        }while(numero_opcion=='0');
           
            
        
        
        
        
        
        
    
    }
    
}
