package control;

import interfaces.DueñoInterface;
import interfaces.DueñoListener;
import interfaces.MascotaInterface;
import interfaces.MascotaListener;
import interfaces.ServicioInterface;
import interfaces.ServicioListener;
import interfaces.TablaUpdaterInterface;
import interfaces.TablaUpdaterListener;
import interfaces.VacunaInterface;
import interfaces.VacunaListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Dueño;
import modelo.Mascota;
import modelo.Servicio;
import modelo.Vacuna;
import vista.Vista;

public class Controlador implements ActionListener, DueñoListener, MascotaListener, ServicioListener, VacunaListener, TablaUpdaterListener {
    private Vista vista;
    private DueñoInterface d;
    private MascotaInterface m;
    private ServicioInterface s;
    private VacunaInterface v;
    private TablaUpdaterInterface tablaUpdater;


    private static Controlador instancia;


    private Controlador(Vista vista, DueñoInterface d, MascotaInterface m, ServicioInterface s, VacunaInterface v, TablaUpdaterInterface tablaUpdater) {
        this.vista = vista;
        this.d = d;
        this.m = m;
        this.s = s;
        this.v = v;
        this.tablaUpdater = tablaUpdater;

        actionListener(this);

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            vista.jDateChooser1.setDate(formato.parse("01/01/2010"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        vista.jTable1.setEnabled(false);
        vista.jTable1.setVisible(false);
        vista.jButton5.setEnabled(false);
        vista.jTextField12.setEditable(false);
        vista.jTextField11.setEditable(false);
        vista.jTextField13.setEditable(false);
    }


    public static Controlador getInstancia(Vista vista, DueñoInterface d, MascotaInterface m, ServicioInterface s, VacunaInterface v, TablaUpdaterInterface tablaUpdater) {
        if (instancia == null) {
            instancia = new Controlador(vista, d, m, s, v, tablaUpdater);
        }
        return instancia;
    }

  
    private void actionListener(ActionListener Controlador) {
        vista.jButton1.addActionListener(Controlador);
        vista.jButton2.addActionListener(Controlador);
        vista.jButton3.addActionListener(Controlador);
        vista.jButton4.addActionListener(Controlador);
        vista.jButton5.addActionListener(Controlador);
        vista.jButton7.addActionListener(Controlador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == vista.jButton1) {
                registrarDueño(e);
            } else if (e.getSource() == vista.jButton2) {
                limpiarCamposDueño(e);
            } else if (e.getSource() == vista.jButton3) {
                registrarMascota(e);
            } else if (e.getSource() == vista.jButton4) {
                limpiarCamposMascota(e);
            } else if (e.getSource() == vista.jButton7) {
                if (vista.jTextField6.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar la Cedula del Responsable de la Mascota");
                    vista.jTextField6.requestFocus();
                } else if (m.buscarMascota(vista.jTextField6.getText()) != null) {
                    vista.jTable1.setEnabled(true);
                    vista.jTable1.setVisible(true);
                    vista.jButton7.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Seleccione 1 Servicio de la Tabla");
                } else {
                    JOptionPane.showMessageDialog(null, "No Existe una Mascota con esa Persona como Responsable, Debe Registrar Mascota");
                }
            } else if (e.getSource() == vista.jButton5) {
                registrarServicio(e);
            }
        } catch (Exception ev) {
            ev.printStackTrace();
        }
    }

    @Override
    public void registrarDueño(ActionEvent e) {
        if (validarCamposDueño()) {
            int seleccionado = vista.jComboBox1.getSelectedIndex();
            d.registrarDueño(vista.jTextField1.getText(), vista.jTextField2.getText(), vista.jTextField5.getText(), vista.jTextField4.getText(), vista.jComboBox1.getItemAt(seleccionado));
            JOptionPane.showMessageDialog(null, "Cliente/Dueño Registrado Exitosamente");

            Object[] fila = {
                vista.jTextField1.getText(),
                vista.jTextField2.getText(),
                vista.jTextField5.getText(),
                vista.jTextField4.getText(),
                vista.jComboBox1.getItemAt(seleccionado)
            };

            actualizarTabla(vista.jTable2, fila);
        }
    }

    @Override
    public void limpiarCamposDueño(ActionEvent e) {
        vista.jTextField1.setText("");
        vista.jTextField2.setText("");
        vista.jTextField5.setText("");
        vista.jTextField4.setText("");
        vista.jComboBox1.setSelectedIndex(0);
    }

    @Override
    public void registrarMascota(ActionEvent e) {
        if (validarCamposMascota() && d.buscarDueño(vista.jTextField7.getText()) != null) {
            Calendar calendario = GregorianCalendar.getInstance();
            java.util.Date fecha = calendario.getTime();
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

            m.registrarMascota(vista.jTextField3.getText(), formatoDeFecha.format(vista.jDateChooser1.getDate()), vista.jTextField7.getText(), vista.jTextField8.getText(), Double.parseDouble(vista.jTextField10.getText()), vista.jTextField9.getText());
            JOptionPane.showMessageDialog(null, "Mascota Registrada Exitosamente");

            Object[] fila = {
                vista.jTextField3.getText(),
                formatoDeFecha.format(vista.jDateChooser1.getDate()),
                vista.jTextField7.getText(),
                vista.jTextField8.getText(),
                vista.jTextField10.getText(),
                vista.jTextField9.getText()
            };

            actualizarTabla(vista.jTable3, fila);
        } else {
            JOptionPane.showMessageDialog(null, "No Existe un Cliente/Dueño con esa Cedula Registrado, Debe Registrarse");
        }
    }

    @Override

        public void limpiarCamposMascota(ActionEvent e) {
            vista.jTextField3.setText("");
            vista.jTextField7.setText("");
            vista.jTextField8.setText("");
            vista.jTextField10.setText("");
            vista.jTextField9.setText("");
            vista.jDateChooser1.setDate(new Date("01/01/2010"));
        }

        @Override
        public void registrarServicio(ActionEvent e) {
            if (vista.jTable1.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione 1 Tratamiento de la Tabla");
            } else {
                s.registrarServicio(vista.jTextField6.getText(), vista.jTextField12.getText(), vista.jTextField11.getText(), Double.parseDouble(vista.jTextField13.getText()));
                JOptionPane.showMessageDialog(null, "Servicio Registrado Exitosamente");

                Object[] fila = {
                    vista.jTextField6.getText(),
                    vista.jTextField12.getText(),
                    vista.jTextField11.getText(),
                    vista.jTextField13.getText()
                };

                actualizarTabla(vista.jTable4, fila);

                vista.jButton5.setEnabled(false);
                vista.jTable1.setEnabled(false);
                vista.jTable1.setVisible(false);
                vista.jButton7.setEnabled(true);
                vista.jTextField12.setText("");
                vista.jTextField11.setText("");
                vista.jTextField13.setText("");
                vista.jTextField6.setText("");
            }
        }

        @Override
        public void actualizarTabla(JTable tabla, Object[] datos) {
            tablaUpdater.actualizarTabla(tabla, datos);
        }
        
        private boolean validarCamposDueño() {
            if (vista.jTextField1.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar la Cedula del Cliente");
                vista.jTextField1.requestFocus();
                return false;
            } else if (vista.jTextField2.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar el Nombre del Cliente");
                vista.jTextField2.requestFocus();
                return false;
            } else if (vista.jTextField5.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar la Dirección del Cliente");
                vista.jTextField5.requestFocus();
                return false;
            } else if (vista.jTextField4.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar el Telefono del Cliente");
                vista.jTextField4.requestFocus();
                return false;
            } else if (vista.jComboBox1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar el Genero del Cliente");
                return false;
            }
            return true;
        }

        private boolean validarCamposMascota() {
            if (vista.jTextField3.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar el Nombre de la Mascota");
                vista.jTextField3.requestFocus();
                return false;
            } else if (vista.jTextField7.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar la Cedula del Responsable de la Mascota");
                vista.jTextField7.requestFocus();
                return false;
            } else if (vista.jTextField8.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar la Raza de la Mascota");
                vista.jTextField8.requestFocus();
                return false;
            } else if (vista.jTextField10.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar el Peso de la Mascota");
                vista.jTextField10.requestFocus();
                return false;
            } else if (vista.jTextField9.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar la Ultima Vacuna de la Mascota");
                vista.jTextField9.requestFocus();
                return false;
            }
            return true;
        }

    @Override
    public void registrarVacuna(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}


    
