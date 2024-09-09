
package implementaciones;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import interfaces.TablaUpdaterInterface;

public class TablaUpdater implements TablaUpdaterInterface {
    @Override
    public void actualizarTabla(JTable tabla, Object[] datos) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.addRow(datos);
    }
}
