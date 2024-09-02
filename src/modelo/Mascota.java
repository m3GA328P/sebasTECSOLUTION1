
package modelo;
import java.util.ArrayList;

public class Mascota {
  public String nombre;
public String fechaNacimiento;
public String cedula;
public String raza;
public Double peso;
public String ultimaVacuna;
ArrayList<Mascota> mascotas= new ArrayList<>();
    public Mascota() {
    }
    public Mascota(String nombre, String fechaNacimiento, String cedula, String raza, Double peso, String ultimaVacuna) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.raza = raza;
        this.peso = peso;
        this.ultimaVacuna = ultimaVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getUltimaVacuna() {
        return ultimaVacuna;
    }

    public void setUltimaVacuna(String ultimaVacuna) {
        this.ultimaVacuna = ultimaVacuna;
    }

     public void registrarMascota(String nombre, String fechaNacimiento, String cedula, String raza, Double peso, String ultimaVacuna){
        mascotas.add(new Mascota(nombre,fechaNacimiento,cedula,raza,peso,ultimaVacuna));
    }
    
    public String buscarMascota(String cedula){
     for(int i=0; i<mascotas.size();i++){
            if(cedula.equals(mascotas.get(i).getCedula())){
                return mascotas.get(i).getCedula();
            }
     }

     return null;
    }
}
