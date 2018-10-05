package programa1;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class BombaMain {

    private static final String NAMEPROGRAM = "Bomba Gasolina";

    public static void main(String[] agrs)
    {
        Bomba bomba = new Bomba();
        int numBomba = 0, capacidad = 0, tipoGasolina = 0, idGasolina = 0;
        float precioBase = 0.0f;
        String marca = "";
        int op = 0;
        String opMenu = "";
        Object menu[] = {"1 - Crear Bomba y Gasolina", "2 - Generar Venta", "3 - Calcular Venta total", "4 - Editar caracteristica", "5- Salir"};
        Object menuTipoGasolina[] = {"Tipo 1", "Tipo 2", "Tipo 3"};

        do {
            opMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);



            switch (returnValueMenu(menu, opMenu))
            {
                case 1:
                    String tipoGas = "";
                    idGasolina = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el id Gasolina",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    marca = JOptionPane.showInputDialog(null, "Introduce la marca de la gasolina",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                    precioBase = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduce el precio de la gasolina",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    tipoGas = (String) JOptionPane.showInputDialog(null, "Elige el tipo de gasolina", "Menu",
                            JOptionPane.QUESTION_MESSAGE, null, menuTipoGasolina, menuTipoGasolina[0]);
                    tipoGasolina = returnValueMenu(menuTipoGasolina, tipoGas);
                    numBomba = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de bomba",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la capacidad de la bomba",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    bomba.setCapacidad(capacidad);
                    bomba.setGasolina(new Gasolina(idGasolina, tipoGasolina, marca, precioBase));
                    bomba.setNumBomba(numBomba);
                    break;
                case 2:
                    int litros = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce los litros vendidos",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    int venta = bomba.calcularVenta(litros);
                    if(venta == 0)
                    {
                        JOptionPane.showMessageDialog(null, "No hay combustible ", NAMEPROGRAM, JOptionPane.WARNING_MESSAGE);

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El total de la venta es de $" + venta, NAMEPROGRAM, JOptionPane.WARNING_MESSAGE);
                    }
                    break; //SUCULENTO BREAK by CONALEP TEAM
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }while ()




    }

    private static int returnValueMenu(Object[] objects, String compare)
    {
        int position = 0;
        for(int x = 0; x < objects.length; x++)
        {
            if(objects[x].toString().matches(compare))
            {
                position = x + 1;
                break;
            }
        }
        return position;
    }

}
