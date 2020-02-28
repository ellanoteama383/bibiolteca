/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Libro {
    private String nombre;
    private String codigoISBN;
    private Date fechaPublicacion;
    private String autor;
    private String areaInteres;
    private String codigo;
    private boolean  prestado;
    private int cantidadPorTitulo;
    private ArrayList<Usuario> prestamistas;

    public Libro(String nombre, String codigoISBN, Date fechaPublicacion, String autor, String areaInteres, String codigo, 
                            boolean prestado, int cantidadPorTitulo) {
        this.nombre = nombre;
        this.codigoISBN = codigoISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.areaInteres = areaInteres;
        this.codigo = codigo;
        this.prestado = prestado;
        this.cantidadPorTitulo = cantidadPorTitulo;
        
        prestamistas = new ArrayList<>();
    }
    
    public void addPrestamista(Usuario nuevoPrestamista){
        prestamistas.add(nuevoPrestamista);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(String codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAreaInteres() {
        return areaInteres;
    }

    public void setAreaInteres(String areaInteres) {
        this.areaInteres = areaInteres;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public int getCantidadPorTitulo() {
        return cantidadPorTitulo;
    }

    public void setCantidadPorTitulo(int cantidadPorTitulo) {
        this.cantidadPorTitulo = cantidadPorTitulo;
    }
    
    public boolean usuarioConEsteLibro(Usuario prestamista){
        boolean tiene = false;
        
        if(prestamistas.size() != 0){
            for(int i = 0; i < prestamistas.size(); i++){
                if(prestamista.getCedula().equalsIgnoreCase(prestamistas.get(i).getCedula()))
                {
                    tiene = true;
                    break;
                } else {
                    tiene = false;
                }
            }
        } else {
            tiene = false;
        }
        
        return tiene;
    }
    
         
}
