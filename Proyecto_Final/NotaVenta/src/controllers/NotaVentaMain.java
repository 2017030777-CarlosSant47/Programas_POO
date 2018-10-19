package controllers;

import models.Factura;
import view.VdlgNotaVenta;

import javax.swing.*;

public class NotaVentaMain {

    public static void main(String[] agrs)
    {
        VdlgNotaVenta view = new VdlgNotaVenta(new JFrame(), true);
        Factura factura = new Factura();
        Controller controller = new Controller(factura, view);
    }
}
