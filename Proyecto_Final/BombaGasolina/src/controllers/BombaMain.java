package controllers;

import models.Bomba;
import models.Gasolina;
import views.vdlgBomba;

import javax.swing.*;

public class BombaMain {

    public static void main(String[] agrs)
    {
        Bomba bomba = new Bomba();
        vdlgBomba vdlgBomba = new vdlgBomba(new JFrame(), true);

        Controller controller = new Controller(bomba, vdlgBomba);
    }
}
