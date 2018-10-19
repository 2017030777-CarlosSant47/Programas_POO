package controllers;
import models.*;
import view.VdlgNotaVenta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller implements ActionListener {

    private VdlgNotaVenta view;
    private Factura factura;
    private JTextField txtForm[] = new JTextField[14];

    public Controller(Factura factura, VdlgNotaVenta view)
    {
        this.factura = factura;
        this.view = view;
        view.btnCalcularSub.addActionListener(this);
        view.btnCalcularTotal.addActionListener(this);
        view.btnGuardar.addActionListener(this);
        view.btnMostrar.addActionListener(this);
        view.btnLimpiar.addActionListener(this);
        txtForm[0] = view.txtConsepto;
        txtForm[1] = view.txtDomicilio;
        txtForm[2] = view.txtFecha;
        txtForm[3] = view.txtFechaCad;
        txtForm[4] = view.txtFechaFac;
        txtForm[5] = view.txtIdProducto;
        txtForm[6] = view.txtIva;
        txtForm[7] = view.txtNombreProd;
        txtForm[8] = view.txtNumVenta;
        txtForm[9] = view.txtRfc;
        txtForm[10] = view.txtTemp;
        txtForm[11] = view.txtNombre;
        txtForm[12] = view.txtPrecio;
        txtForm[13] = view.txtCantidad;

        //POR SI LAS MOCAS LO QUIERE TRONAR e.e
        view.txtIva.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char c = keyEvent.getKeyChar();
                if(!(c >= 47 && c <= 57))
                {
                    keyEvent.consume();

                }
                super.keyTyped(keyEvent);
            }
        });
        view.txtTemp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char c = keyEvent.getKeyChar();
                if(!(c >= 47 && c <= 57))
                {
                    keyEvent.consume();

                }
                super.keyTyped(keyEvent);
            }
        });
        view.txtPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char c = keyEvent.getKeyChar();
                if(!(c >= 48 && c <= 57 || c == 46))
                {
                    keyEvent.consume();

                }
                super.keyTyped(keyEvent);
            }
        });
        view.txtCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char c = keyEvent.getKeyChar();
                if(!(c >= 47 && c <= 57))
                {
                    keyEvent.consume();

                }
                super.keyTyped(keyEvent);
            }
        });

        view.txtIdProducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char c = keyEvent.getKeyChar();
                if(!(c >= 47 && c <= 57))
                {
                    keyEvent.consume();

                }
                super.keyTyped(keyEvent);
            }
        });

        view.txtNumVenta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char c = keyEvent.getKeyChar();
                if(!(c >= 47 && c <= 57))
                {
                    keyEvent.consume();

                }
                super.keyTyped(keyEvent);
            }
        });
        //validad por numeros igual por si las moscas JAJAJAJAJAJJA
        view.setVisible(true);
        view.setTitle("Nota venta");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.btnGuardar)
        {
            if(validarCampos())
            {
                JOptionPane.showMessageDialog(null, "No puedes dejar los campos vacios", "Nota venta", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                factura.setDomicilio(view.txtDomicilio.getText());
                factura.setFechaFac(view.txtFechaFac.getText());
                factura.setIva(Integer.parseInt(view.txtIva.getText()));
                factura.setNombre(view.txtNombre.getText());
                factura.setRfc(view.txtRfc.getText());
                factura.setFecha(view.txtFecha.getText());
                factura.setConsepto(view.txtConsepto.getText());
                factura.setNumero(Integer.parseInt(view.txtNumVenta.getText()));
                factura.setCantidad(Float.parseFloat(view.txtCantidad.getText()));
                factura.setTipoPago(view.cmbPago.getSelectedIndex() + 1);
                Perecedero perecedero = new Perecedero(Integer.parseInt(view.txtIdProducto.getText()), view.txtNombreProd.getText(), view.cmbUnidad.getSelectedIndex() + 1,
                        Float.parseFloat(view.txtPrecio.getText()), view.txtFechaCad.getText(), Integer.parseInt(view.txtTemp.getText()));
                factura.setProducto(perecedero);
                limpiarCampos();
            }
        }
        else if(e.getSource() == view.btnCalcularSub)
        {
            if(factura.getNumero() <= 0)
            {
                JOptionPane.showMessageDialog(null, "No hay Venta Creada", "Nota Venta", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El subtotal es de $" + factura.calcularPago(), "Nota Venta", JOptionPane.QUESTION_MESSAGE);
            }
        }
        else if(e.getSource() == view.btnCalcularTotal)
        {
            if(factura.getNumero() <= 0)
            {
                JOptionPane.showMessageDialog(null, "No hay Venta Creada", "Nota Venta", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Con impuesto de " + factura.calcularImpuesto() + "\n El total a pagar es de $" + factura.calcularTotal(),
                        "Factura", JOptionPane.QUESTION_MESSAGE);
            }
        }
        else if(e.getSource() == view.btnLimpiar)
        {
            limpiarCampos();
        }
        else if(e.getSource() == view.btnMostrar)
        {
            if(factura.getNumero() <= 0)
            {
                JOptionPane.showMessageDialog(null, "No hay Venta Creada", "Nota Venta", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                view.txtCantidad.setText(String.valueOf(factura.getCantidad()));
                view.txtConsepto.setText(factura.getConsepto());
                view.txtDomicilio.setText(factura.getDomicilio());
                view.txtFecha.setText(factura.getFecha());
                view.txtFechaCad.setText(factura.getProducto().getFechaCaducidad());
                view.txtFechaFac.setText(factura.getFechaFac());
                view.txtIdProducto.setText(String.valueOf(factura.getProducto().getIdProducto()));
                view.txtIva.setText(String.valueOf(factura.getIva()));
                view.txtNombre.setText(factura.getNombre());
                view.txtNombreProd.setText(factura.getProducto().getNombreProd());
                view.txtNumVenta.setText(String.valueOf(factura.getNumero()));
                view.txtPrecio.setText(String.valueOf(factura.getProducto().getPrecio()));
                view.txtRfc.setText(factura.getRfc());
                view.txtTemp.setText(String.valueOf(factura.getProducto().getTemperatura()));
                view.cmbPago.setSelectedIndex(factura.getTipoPago() - 1);
                view.cmbUnidad.setSelectedIndex(factura.getProducto().getUnidad() - 1);

            }

        }

    }



    public boolean validarCampos()
    {
        //HAGALE COMO SEA NO LO HARA TRONAR MUAJAJAJJAJAJA A no vale el entero de mas de 10 digitos :v
        boolean exito = false;
        for(int x = 0; x < txtForm.length; x++)
        {
            if(txtForm[x].getText().matches("") || view.cmbPago.getSelectedIndex() <=-1 || view.cmbUnidad.getSelectedIndex() <= -1)
            {
                exito = true;
                break;
            }
        }
        return exito;
    }

    private void limpiarCampos()
    {
        for (int x = 0; x < txtForm.length; x++)
        {
            txtForm[x].setText("");
        }

        view.cmbUnidad.setSelectedIndex(-1);
        view.cmbPago.setSelectedIndex(-1);
    }
}
