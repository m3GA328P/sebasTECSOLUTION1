package control;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaUpdater {

    public void agregarFila(DefaultTableModel modelo, Object[] datos) {
        modelo.addRow(datos);
    }

    public void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
    }

    public void actualizarTabla(JTable tabla, Object[] datos) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        agregarFila(modelo, datos);
        tabla.setModel(modelo);
    }
}
