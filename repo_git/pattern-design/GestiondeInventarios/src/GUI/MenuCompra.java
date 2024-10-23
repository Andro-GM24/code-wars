package GUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import subsistemas.*; // no es necesario a este acceso ya que solo se usa la fachada que une todos los sistemas 
import gestiondeinventarios.*;
/**
 *
 * @author Andro
 */
public class MenuCompra extends JFrame implements ActionListener{
    
    
    
    //logica
    Productos producto = new Productos("", 0) ;
    
     Productos[] productos_array ;

                              
             
    
    
    
    Bodega bodega = new Bodega(15, producto);
    Persona cliente = new Persona("Pedro", "", 200000);
    Persona vendedor = new Persona("", "", 200000);
    int cantidad=0;
    Envio envio_sb = new Envio();
    GestionarPago gestionarpago_sb = new GestionarPago();
    VerificarDisponibilidad vf_sb = new VerificarDisponibilidad();
    Comprar_facade fachada = new Comprar_facade(envio_sb,gestionarpago_sb,vf_sb);
    
    
  
    
   
     JLabel titulo_1 = new JLabel("Ingrese el nombre del producto"); // creamos un titulo 
     JLabel titulo_2 = new JLabel("ingrese el precio del productop");
     JLabel titulo_3 = new JLabel("Ingrese la dirección de envio");
     JLabel unidades = new JLabel("unidades");
     JLabel unidades_disponible = new JLabel("");
     JLabel disponibles = new JLabel("disponibles");
     JLabel total = new JLabel("");
     JLabel total_signo = new JLabel("$COP"); 
      JLabel imagen = new JLabel();
      JLabel compra_finalizada = new JLabel();
     
     JTextField nombre_txt= new JTextField();
     JTextField cantidad_txt= new JTextField();
     JTextField precio_txt = new JTextField();
     JTextField direccion_txt = new JTextField();
     
     
     
     
     JButton pago_bt = new JButton("enviar");
     JButton envio_bt = new JButton("Confirmar");
     JButton fin_bt = new JButton("Enviar");
     JButton comprar = new JButton("comprar");
     
     JPanel contenedor = new JPanel();
     JPanel disponibilidad_vista= new JPanel();
     JPanel pago_vista = new JPanel();
     JPanel envio_vista = new JPanel();
    
    public MenuCompra(){
        initComponents();
    }

    private void initComponents() {
        
       productos_array = new Productos[15];
        
        for (int i = 0; i < 15; i++) {
            // Aquí puedes definir los atributos de cada producto, por ejemplo, nombre y precio
            String nombreProducto = "Producto " + (i + 1);
            int precioProducto = (int) Math.random() ; // Precio aleatorio entre 0 y 100
        

            // Creación del objeto Producto y almacenamiento en el array
            productos_array[i] = new Productos(nombreProducto, precioProducto);
            bodega.Añadir_productos(productos_array[i]);
        }
              
       
        
       
        setLayout(null);//la organización null
        setBounds(200, 200,750,500);//tamaño de ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);//salir con enter
        
        contenedor.setLayout(null);
         disponibilidad_vista.setLayout( null);
         pago_vista.setLayout(null);
         envio_vista.setLayout(null);
        
           //layouts para paneles y contenedor
        
        
        
        
        
        envio_vista.add(fin_bt);//añade botonoes
        envio_vista.add(compra_finalizada);
        disponibilidad_vista.add(pago_bt);
        pago_vista.add(envio_bt);
        
        add(contenedor);
        contenedor.add(disponibilidad_vista);//añade paneles y el contenedor de ellos
        contenedor.add(pago_vista);
        contenedor.add(envio_vista);
        
        
        
        
        
        /*deshabilitar_disponibilidad_bt();*/
        
        pago_bt.addActionListener(this);
        envio_bt.addActionListener(this);   // añade funcion action listener a todos los botones
        fin_bt.addActionListener(this);
        
        
        
        nombre_txt.setBounds(125,230,260,40);
        cantidad_txt.setBounds(125,230 , 25, 40);
        precio_txt.setBounds(125,230,260,40);
        direccion_txt.setBounds(125,230,260,40);
        
        
        fin_bt.setBounds(170, 300, 140, 50);
        pago_bt.setBounds(170, 300, 140, 50);// tamaño y ubicación botones
        envio_bt.setBounds(160, 300, 100, 50);
        comprar.setBounds(500, 250, 150, 50);
                
        titulo_1.setBounds(150, 70, 300, 40);
        titulo_2.setBounds(150, 40, 300, 40);// tamaño y ubicación tituloa
        titulo_3.setBounds(150, 40, 300, 40);
        unidades.setBounds(160, 230, 90, 40);
        unidades_disponible.setBounds(160, 180, 40, 40);
        disponibles.setBounds(200, 180, 200, 40);
        total.setBounds(100, 130, 200, 40);
        total_signo.setBounds(210, 130, 100, 40);
        unidades_disponible.setBounds(160, 200, 90, 40);
        compra_finalizada.setBounds(120, 350, 200, 50);
        
        
        precio_txt.setBounds(160, 120, 200, 40);
        
        contenedor.setBounds(200, 5, 530, 450);
        disponibilidad_vista.setBounds(15, 10, 500, 425);
        pago_vista.setBounds(15, 10, 500, 425); //tamaño y ubicacioón paneles
        envio_vista.setBounds(15, 10, 500, 425);
        imagen.setBounds(15, 50, 100, 400);
        
        titulo_1.setFont(new Font(titulo_1.getFont().getName(), titulo_1.getFont().getStyle(), 20));
       titulo_2.setFont(new Font(titulo_2.getFont().getName(), titulo_2.getFont().getStyle(), 20));
        titulo_3.setFont(new Font(titulo_3.getFont().getName(), titulo_3.getFont().getStyle(), 20));
        nombre_txt.setFont(new Font(nombre_txt.getFont().getName(), nombre_txt.getFont().getStyle(), 20));
        cantidad_txt.setFont(new Font(cantidad_txt.getFont().getName(), cantidad_txt.getFont().getStyle(), 20));
        unidades.setFont(new Font(unidades.getFont().getName(), unidades.getFont().getStyle(), 20));
        precio_txt.setFont(new Font(precio_txt.getFont().getName(), precio_txt.getFont().getStyle(), 20));
        direccion_txt.setFont(new Font(direccion_txt.getFont().getName(), direccion_txt.getFont().getStyle(), 20));
        total.setFont(new Font(total.getFont().getName(), total.getFont().getStyle(), 20));
        total_signo.setFont(new Font(total_signo.getFont().getName(), total_signo.getFont().getStyle(), 20));
        unidades_disponible.setFont(new Font(unidades_disponible.getFont().getName(), unidades_disponible.getFont().getStyle(), 20));
        disponibles.setFont(new Font(disponibles.getFont().getName(), disponibles.getFont().getStyle(), 20));
        compra_finalizada.setFont(new Font(disponibles.getFont().getName(), disponibles.getFont().getStyle(), 20));
        
        contenedor.setBackground(Color.darkGray);
        disponibilidad_vista.setBackground(Color.lightGray);
        pago_vista.setBackground(Color.lightGray);       //colores paneles
        envio_vista.setBackground(Color.lightGray);
        
        //contenido panel 1
        disponibilidad_vista.add(titulo_1);
        disponibilidad_vista.add(nombre_txt);
        
        
        
        //contenido panel 2 

        
        pago_vista.add(titulo_2);
        
        pago_vista.add(imagen);
        pago_vista.add(cantidad_txt);
        pago_vista.add(unidades);
        pago_vista.add(precio_txt);
        
        pago_vista.add(comprar);
        pago_vista.add(unidades_disponible);
        pago_vista.add(disponibles);
        
         //contenido panel 3
        envio_vista.add(titulo_3);
        envio_vista.add(direccion_txt);
        envio_vista.add(total);
        envio_vista.add(total_signo);
        
        //logica
        disponibilidad_vista.setVisible(true);
        pago_vista.setVisible(false);
        envio_vista.setVisible(false);
        
        
    }

    private void deshabilitar_disponibilidad_bt(){
        if(disponibilidad_vista.isVisible()){
            fin_bt.setVisible(false);
            pago_bt.setVisible(true);
            
        }else/*(pago_vista.isVisible())*/{
        pago_bt.setVisible(false);
        envio_bt.setVisible(true);
    }
            
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            Object evt = e.getSource();
            
            if(evt.equals(pago_bt)){//evento de el boton menu 1
                if(fachada.VerDisponibilidad(nombre_txt.getText(), bodega, 1)){
                producto.setNombre(nombre_txt.getText());//se le asigna el nombre al producto
                unidades_disponible.setText(String.valueOf(bodega.getDisponibles().size()));// se le asigna la cantidad disponible en el objeto bodega y se tranforma a int
                 disponibilidad_vista.setVisible(false);
                pago_vista.setVisible(true);
                }else{
                    /*mandar mensaje*/
                }
                
            }
            
            
            
            if(evt.equals(envio_bt)){//boton portal entre parte 2 a parte 3
                cantidad=Integer.parseInt(cantidad_txt.getText());/*obtener la cantidad solicitada*/
                producto.setPrecio(Integer.parseInt(precio_txt.getText()));/*dar el precio a sus producto*/
                if(fachada.comprar(bodega, cantidad, cliente,vendedor, producto)){
                    total.setText(String.valueOf(cantidad*producto.getPrecio()));/*calcular total*/
                pago_vista.setVisible(false);
                envio_vista.setVisible(true);
                }
                
                
                
                
                
            }
            
            if(evt.equals(fin_bt)){
                
                cliente.setDireccion(direccion_txt.getText());
                
              compra_finalizada.setText( fachada.enviar(bodega, cantidad, cliente.getNombre(), cliente.getDireccion(), String.valueOf(cantidad*producto.getPrecio()), producto.getNombre()));
                    
                
                
                
                
                
                
                
            }
            
            
            
            
            
            
    }
    
    
    
}
