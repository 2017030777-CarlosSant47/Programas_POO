package programa1;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;


//PROGRAMIG BY CARLOSSANT47

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
        //NO SE EDITAR LA CANTIDAD DE LITROS VENDIDOS e.e
        Object subMenu[] = {"1 - Editar capacidad", "2 - Editar numero de bomba", "3 - Editar gasolina", "4 - Salir"};
        Object menuGasolina[] = {"1 - Editar id de gasolina", "2 - Editar Tipo de gasolina", "3 - Editar precio", "4 - Editar Marca", "5 - Salir"};

        do {
            opMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

            op = returnValueMenu(menu, opMenu);
            switch (op)
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
                    float venta = bomba.calcularVenta(litros);
                    if((int)venta == 0)
                    {
                        JOptionPane.showMessageDialog(null, "No hay combustible ", NAMEPROGRAM, JOptionPane.WARNING_MESSAGE);

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El total de la venta es de $" + venta, NAMEPROGRAM, JOptionPane.WARNING_MESSAGE);
                    }
                    break; //SUCULENTO BREAK e.e (TEAM CONALEP)
                case 3:
                    JOptionPane.showMessageDialog(null, "El total de ventas es de $" + bomba.calcularVentaTotal(), NAMEPROGRAM, JOptionPane.WARNING_MESSAGE);
                    break;
                case 4:
                    String subO = "";
                    do {
                        subO = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                                JOptionPane.QUESTION_MESSAGE, null, subMenu, subMenu[0]);
                        op = returnValueMenu(subMenu, subO);
                        switch (op)
                        {
                            case 1:
                                capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la capacidad de la bomba",
                                        NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                                bomba.setCapacidad(capacidad);
                                break;
                            case 2:
                                numBomba = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de bomba",
                                        NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                                bomba.setNumBomba(numBomba);
                                break;
                            case 3:
                                String opGasolina = "";
                                do{
                                    opGasolina = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                                            JOptionPane.QUESTION_MESSAGE, null, menuGasolina, menuGasolina[0]);

                                    op = returnValueMenu(menuGasolina, opGasolina);

                                    switch (op)
                                    {
                                        case 1:
                                            idGasolina = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el id Gasolina",
                                                    NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                                            bomba.getGasolina().setIdGasonlina(idGasolina);
                                            break;
                                        case 2:
                                            tipoGas = (String) JOptionPane.showInputDialog(null, "Elige el tipo de gasolina", "Menu",
                                                    JOptionPane.QUESTION_MESSAGE, null, menuTipoGasolina, menuTipoGasolina[0]);
                                            tipoGasolina = returnValueMenu(menuTipoGasolina, tipoGas);
                                            bomba.getGasolina().setTipo(tipoGasolina);
                                            break;
                                        case 3:
                                            precioBase = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduce el precio de la gasolina",
                                                    NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                                            bomba.getGasolina().setPrecioBase(precioBase);
                                            break;
                                        case 4:
                                            marca = JOptionPane.showInputDialog(null, "Introduce la marca de la gasolina",
                                                    NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                                            bomba.getGasolina().setMarca(marca);
                                            break;
                                        case 5:
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Error opccion invalida", NAMEPROGRAM, JOptionPane.ERROR_MESSAGE);
                                    }
                                }while (op != 5);
                                break;
                            case 4:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Error opccion invalida", NAMEPROGRAM, JOptionPane.ERROR_MESSAGE);
                        }
                    }while (op != 4);
                    op = 0;
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Adios uwu", NAMEPROGRAM, JOptionPane.WARNING_MESSAGE);
                    //TORTA DE CARNE DE VACA MUERTA xD TEAM CONALEP(3rd Semestre 2015 308)
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error opccion invalida", NAMEPROGRAM, JOptionPane.ERROR_MESSAGE);
            }
        }while (op != 5);
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
