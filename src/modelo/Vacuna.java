
package modelo;

import interfaces.VacunaInterface;
import java.util.ArrayList;
import javax.swing.JTable;


public class Vacuna implements VacunaInterface {
    public String nombre;
    public Double valor;
    public Integer dosificacion;
    ArrayList<Vacuna> vacunas = new ArrayList<>();
    public Vacuna() {
    }

    public Vacuna(String nombre, Double valor, Integer dosificacion) {
        this.nombre = nombre;
        this.valor = valor;
        this.dosificacion = dosificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getDosificacion() {
        return dosificacion;
    }

    public void setDosificacion(Integer dosificacion) {
        this.dosificacion = dosificacion;
    }
     public void registrarVacuna(String nombre, Double valor, Integer dosificacion){
        vacunas.add(new Vacuna(nombre,valor,dosificacion));
    }
    
    public String buscarVacuna(String nombre){

     for(int i=0; i<vacunas.size();i++){
            if(nombre.equals(vacunas.get(i).getNombre())){
                return vacunas.get(i).getNombre();
            }
     }
     return null;
    }

    @Override
    public void actualizarTabla(JTable tabla, Object[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
