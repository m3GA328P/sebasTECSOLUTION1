package facade;

import control.TablaUpdater;
import factories.FactoryConcreta;
import interfaces.DueñoInterface;
import interfaces.MascotaInterface;
import interfaces.ServicioInterface;
import interfaces.TablaUpdaterInterface;
import interfaces.VacunaInterface;
import modelo.Dueño;
import modelo.Mascota;
import modelo.Servicio;

import javax.swing.JTable;

public class VeterinariaFacade {
    private DueñoInterface dueño;
    private MascotaInterface mascota;
    private ServicioInterface servicio;
    private TablaUpdaterInterface tablaUpdater;

    public VeterinariaFacade() {
        FactoryConcreta factory = new FactoryConcreta();
        this.dueño = factory.crearDueño();
        this.mascota = factory.crearMascota();
        this.servicio = factory.crearServicio();
        this.tablaUpdater = factory.crearTablaUpdater();
    }

    public void registrarDueño(String cedula, String nombre, String direccion, String telefono, String genero) {
        dueño.registrarDueño(cedula, nombre, direccion, telefono, genero);
    }

    public void registrarMascota(String nombre, String fechaNacimiento, String cedulaDueño, String raza, double peso, String ultimaVacuna) {
        mascota.registrarMascota(nombre, fechaNacimiento, cedulaDueño, raza, peso, ultimaVacuna);
    }

    public void registrarServicio(String cedulaMascota, String descripcion, String fecha, double costo) {
        servicio.registrarServicio(cedulaMascota, descripcion, fecha, costo);
    }

    public void actualizarTabla(JTable tabla, Object[] datos) {
        tablaUpdater.actualizarTabla(tabla, datos);
    }
    public String buscarDueño(String cedula) {
        return dueño.buscarDueño(cedula); 
    }

}
