package modelo;
import interfaces.DueñoInterface;
import java.util.ArrayList;

public class Dueño implements DueñoInterface, Cloneable {
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String genero;
    private ArrayList<Dueño> dueños = new ArrayList<>();

    public Dueño() {}

    public Dueño(String cedula, String nombre, String direccion, String telefono, String genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {  
        this.cedula = cedula;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
      @Override
    public Dueño clone() {
        try {
            return (Dueño) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registrarDueño(String cedula, String nombre, String direccion, String telefono, String genero) {
        dueños.add(new Dueño(cedula, nombre, direccion, telefono, genero));
    }

    public String buscarDueño(String cedula) {
        for (Dueño dueño : dueños) {
            if (cedula.equals(dueño.getCedula())) {
                return dueño.getCedula();
            }
        }
        return null;
    }
}
