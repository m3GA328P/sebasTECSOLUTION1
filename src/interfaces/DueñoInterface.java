
package interfaces;

public interface DueñoInterface {
    void registrarDueño(String cedula, String nombre, String direccion, String telefono, String genero);
    String buscarDueño(String cedula);
}
