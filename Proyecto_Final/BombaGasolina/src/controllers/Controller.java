package controllers;

import models.Gasolina;
import models.Bomba;
import views.vdlgBomba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author CarlosSant47
 */
public class Controller implements ActionListener{
    private Bomba bomba;
    private vdlgBomba formBomba;
    private JTextField[] txtForms = new JTextField[5];


    public Controller(Bomba bomba, vdlgBomba formBomba)
    {
        this.bomba = bomba;
        this.formBomba = formBomba;

        formBomba.btnGuardar.addActionListener(this);
        formBomba.btnInventario.addActionListener(this);
        formBomba.btnLimpiar.addActionListener(this);
        formBomba.btnMostrar.addActionListener(this);
        formBomba.btnVenta.addActionListener(this);
        formBomba.btnVentaTotal.addActionListener(this);
        txtForms[0] = formBomba.txtNBomba;//VER MAS ABAJO
        txtForms[1] = formBomba.txtPrecio;
        txtForms[2] = formBomba.txtCapacidad;
        txtForms[3] = formBomba.txtMarca;
        txtForms[4] = formBomba.txtidGasolina;
        formBomba.setVisible(true);
        formBomba.setTitle("Bomba");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == formBomba.btnGuardar)
        {
            if(validarCampos())
            {
                JOptionPane.showMessageDialog(null, "No puedes dejar los campos vacios", "Error", JOptionPane.ERROR_MESSAGE);//YA VIENE VALIDADO
                //POR SI LAS MOSCAS, NO CAERE EN SUS TRUQUITOS PROFE MUAJAJAJAJAJAJAJAJ
            }
            else {
                Gasolina gasolina = new Gasolina(Integer.parseInt(formBomba.txtidGasolina.getText()), formBomba.cmbTipo.getSelectedIndex() + 1,
                        formBomba.txtMarca.getText(), Float.parseFloat(formBomba.txtPrecio.getText()));
                bomba.setCapacidad(Integer.parseInt(formBomba.txtCapacidad.getText()));
                bomba.setGasolina(gasolina);
                bomba.setNumBomba(Integer.parseInt(formBomba.txtNBomba.getText()));
                bomba.setLitrosvendidos(0);
                limpiarCampos();
            }

        }
        else if(e.getSource() == formBomba.btnLimpiar)
        {
            limpiarCampos();
        }
        else if(e.getSource() == formBomba.btnInventario)
        {
            JOptionPane.showMessageDialog(null, "El inventario total es " + bomba.revisarInventario(), "Bomba", JOptionPane.WARNING_MESSAGE);
        }
        else if (e.getSource() == formBomba.btnMostrar)
        {
            formBomba.txtCapacidad.setText(String.valueOf(bomba.getCapacidad()));
            formBomba.txtidGasolina.setText(String.valueOf(bomba.getGasolina().getIdGasonlina()));
            formBomba.txtMarca.setText(bomba.getGasolina().getMarca());
            formBomba.txtPrecio.setText(String.valueOf(bomba.getGasolina().getPrecioBase()));
            formBomba.txtNBomba.setText(String.valueOf(bomba.getNumBomba()));
            formBomba.cmbTipo.setSelectedIndex(bomba.getGasolina().getTipo() - 1);
        }
        else if(e.getSource() == formBomba.btnVentaTotal)
        {
            JOptionPane.showMessageDialog(null, "la venta total es de $" + bomba.calcularVentaTotal(), "Bomba", JOptionPane.WARNING_MESSAGE);

        }
        else if(e.getSource() == formBomba.btnVenta)
        {

            if(formBomba.txtVenta.getText().matches(""))
            {
                JOptionPane.showMessageDialog(null, "Introduce la cantidad de litros", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(bomba.revisarCantidadGas(Integer.parseInt(formBomba.txtVenta.getText())))
                {
                    JOptionPane.showMessageDialog(null, "No hay Combustible", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "La venta total es de $" + bomba.calcularVenta(Integer.parseInt(formBomba.txtVenta.getText())), "Venta", JOptionPane.QUESTION_MESSAGE);
                }
            }
        }

    }

    private void limpiarCampos()
    {
        formBomba.txtCapacidad.setText("");
        formBomba.txtMarca.setText("");
        formBomba.txtidGasolina.setText("");
        formBomba.txtPrecio.setText("");
        formBomba.txtNBomba.setText("");
        formBomba.cmbTipo.setSelectedIndex(-1);
    }

    private boolean validarCampos()
    {
        boolean exito = false;
        for (int x = 0; x < txtForms.length; x++)
        {
            if(txtForms[x].getText().matches("") || formBomba.cmbTipo.getSelectedIndex() <= -1)
            {
                //PARA QUE PONER UNO PR UNO SI EN UN ARRELGO ES MAS FACIL ESTE TRUCO LO APRENDI EN C++ Y EN ANDROID
                exito = true;
                break;
            }
        }
        return exito;


    }

}
