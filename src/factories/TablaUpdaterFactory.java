package factories;

import interfaces.TablaUpdaterInterface;
import implementaciones.TablaUpdater;

public class TablaUpdaterFactory {
    public static TablaUpdaterInterface crearTablaUpdater() {
        return new TablaUpdater();
    }
}
