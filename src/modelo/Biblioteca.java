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
   
         Libro libro2 = new Libro("Cien años de soledad","1234567897549",new Date(1940,11,20),
                                 "Gabriel Garcia Marquez","Novela","1849991",false, 3);
    
         Libro libro3 = new Libro("Cien años de soledad","1234567897549",new Date(1940,11,20),
                                 "Gabriel Garcia Marquez","Novela","1849994",false, 3);
       
       
       
        Libro libro4 = new Libro("El alquimista","1234567897999",new Date(1990,12,15),
        "Paulo Coehlo","Ficcion","1841796",false, 2);
        Libro libro5 = new Libro("El alquimista","1234567897998",new Date(1990,12,15),
        "Paulo Coehlo","Ficcion","1841797",false, 2);
        
        Libro libro6 = new Libro("La insoportable levedad del ser","4321567897549",new Date(1926,01,01),
        "Milan Kundera","Ficcion","1841790",false, 2);
         Libro libro7 = new Libro("La insoportable levedad del ser","4321567897549",new Date(1926,01,01),
        "Milan Kundera","Ficcion","1841799",false, 2);
       
        
       
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
        libros.add(libro6);
        libros.add(libro7);
         
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
            
            prestado.setPrestamistas(usuarioActual);
            librosPrestados.add(prestado);
            libros.remove(prestado);
            for(int i=0; i<getLibros().size();i++){
                if(getLibros() .get(i).getCodigoISBN().equalsIgnoreCase(prestado.getCodigoISBN())){
                   getLibros().get(i).setCantidadPorTitulo(getLibros().get(i).getCantidadPorTitulo()-1);
                }
            }
    }    
    public void devolveLibro(Libro dev){
       
            librosPrestados.remove(dev);
            for(int i=0; i<getLibros().size();i++){
                if(getLibros().get(i).getCodigoISBN().equalsIgnoreCase(dev.getCodigoISBN())){
                   getLibros().get(i).setCantidadPorTitulo(getLibros().get(i).getCantidadPorTitulo()+1);
                }
            }   
             libros.add(dev);
    }
    
    public void librosPrestados(){
         String nombre ="Libros prestados :\n";
          
        for(int i=0;i<librosPrestados.size();i++){
            
            nombre+=librosPrestados.get(i).getNombre();
           
        }
        JOptionPane.showMessageDialog(null,nombre);
        
    }
            
            
        
    }


