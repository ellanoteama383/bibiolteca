package modelo;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> librosPrestados;
    private Usuario usuarioActual;

    public Biblioteca() {
        libros= new ArrayList<>();
        librosPrestados= new ArrayList<>();
        usuarios = new ArrayList<>();
        
        Usuario usuarioEjemplo = new Usuario("Felipe Gutierrez Romero", "1010093086", 
                "email@gmail.com", "Calle 28 #10-40", "3187921623");
        usuarios.add(usuarioEjemplo);
        crearLibros();
       
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    
    
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
   
    public  void crearLibros(){
   
         Libro libro1 = new Libro("Cien años de soledad","1234567897549",new Date(1940,11,20),
                                 "Gabriel Garcia Marquez","Novela","1849996",false, 3);
       
        Libro libro2 = new Libro("El alquimista","1234567897999",new Date(1990,12,15),
        "Paulo Coehlo","Ficcion","1841796",false, 3);
        Libro libro3 = new Libro("La insoportable levedad del ser","4321567897549",new Date(1926,01,01),
        "Milan Kundera","Ficcion","1841799",false, 3);
        Libro libro4 = new Libro("Vuelta al mundo en Ochenta dias","4321512344549",new Date(1918,06,20),
        "Julio Verne","Novela","3241796",false, 3);
        Libro libro5 = new Libro("El coronel no tiene quien le escriba","1234567898909",new Date(1967,11,20),
        "Gabriel Garcia Marquez","Novela","1866796",false, 3);
        
       
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
         
    }
    
    public void registrarUsuario(String cedula, String nombre, String correo, String direccion,
                                    String telefono){
        
        Usuario nuevoUsuario = new Usuario(cedula, nombre, correo, direccion, telefono);
        usuarios.add(nuevoUsuario);
        setUsuarioActual(nuevoUsuario);
    }
    
    public boolean verificarUsuario(String cedula){
        boolean estado = false;
        
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getCedula().equals(cedula)){
                estado = true;
                break;
            } else {
                estado = false;
                break;
            }
        }
        
        return estado;
    }
    
    public void disponibles(){
      
        String nombre ="Libros disponibles :\n";
          
        for(int i=0;i<libros.size();i++){
            
            nombre+=libros.get(i).getNombre()+ " Disponibles: " + libros.get(i).getCantidadPorTitulo() + "\n";
           
        }
        JOptionPane.showMessageDialog(null,nombre);
        
        
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
    
    
    public void prestarLibro(Libro prestado){
        if(prestado.getCantidadPorTitulo() > 0)
        {
            prestado.setCantidadPorTitulo(prestado.getCantidadPorTitulo() - 1);
            prestado.addPrestamista(usuarioActual);
        }
        
        
        if(prestado.getCantidadPorTitulo() == 0)
        {
            librosPrestados.add(prestado);
            libros.remove(prestado);
        }
    }
    
}
