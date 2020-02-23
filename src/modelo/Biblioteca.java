package modelo;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
   

    public Biblioteca() {
        libros= new ArrayList<>();
        crearLibros();
       
    }
    
   
    public  void crearLibros(){
   
         Libro libro1 = new Libro("Cien años de soledad","1234567897549",new Date(1940,11,20),
                                 "Gabriel Garcia Marquez","Novela","1841796",false);
       
        Libro libro2 = new Libro("El alquimista","1234567897999",new Date(1990,12,15),
        "Paulo Coehlo","Ficcion","1841796",false);
        Libro libro3 = new Libro("La insoportable levedad del ser","4321567897549",new Date(1926,01,01),
        "Milan Kundera","Ficcion","1841796",false);
        Libro libro4 = new Libro("Vuelta al mundo en Ochenta dias","4321512344549",new Date(1918,06,20),
        "Julio Verne","Novela","3241796",false);
        Libro libro5 = new Libro("El coronel no tiene quien le escriba","1234567898909",new Date(1967,11,20),
        "Gabriel Garcia Marquez","Novela","1866796",false);
        
       
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
         
    }
    
    private void registrarUsuario(String cedula, String nombre, String correo, String direccion,
                                    String telefono){
        
        Usuario nuevoUsuario = new Usuario(cedula, nombre, correo, direccion, telefono);
        usuarios.add(nuevoUsuario);
        
    }
    
    public void verificarUsuario(String cedula){
        
        
        
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getCedula().equals(cedula)){
                
                
                JOptionPane.showInternalMessageDialog(null, "El usuario existe");
            } else {
                
                
                JOptionPane.showInternalMessageDialog(null, "El usuario no existe");
                
            }
        }
        
       
        
    }
    public void disponibles(){
      
        String nombre ="Libros disponibles :\n";
          
        for(int i=0;i<libros.size();i++){
            
            nombre+=libros.get(i).getNombre()+"\n";
           
        }
        JOptionPane.showMessageDialog(null,nombre);
        
        
    }
    
}
