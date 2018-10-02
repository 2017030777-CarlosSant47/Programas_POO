package programa1;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.Scanner;

public class CotizacionMain {

    private static final String PROGRAM_NAME = "Cotizacion Auto";
    public static void main(String[] args)
    {
        Cotizacion cotizacion = new Cotizacion();
        int numCotizacion = 0, plazo = 0, porcentaje = 0, op = 0;
        float precio = 0.0f;
        String descripcion = "";
        Scanner in = new Scanner(System.in);
        Object menu[] = {"1 - Crear Cotizacion", "2 - Calcular Pago Inicial", "3 - Calcular Pago Final",
                "4 - Calcular Pago Mensual", "5 - Modificar Cotizacion", "6 - Salir"};
        Object subMenu[] ={"1- Modificar NumCotizacion", "2 - Modificar Descripcion", "3 - Modificar Porcentaje de pago inicial",
                "4 - Modifcar precio", "5 - Modificar Plazo", "6 - Salir"};
        String opMenu = "";

        do{

            opMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

            op = returnValueMenu(menu, opMenu);
            /*
            System.out.println("1 - Crear Cotizacion");
            System.out.println("2 - Calcular Pago Inicial");
            System.out.println("3 - Calcular Pago Final");
            System.out.println("4 - Calcular Pago Mensual");
            System.out.println("5 - Modificar Cotizacion");

            System.out.println("6 - Salir");
            System.out.println("Elije una opccion");
            */


            switch (op)
            {
                case 1:
                    //System.out.println("Introduce el numero de cotizacion");
                    numCotizacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el plazo a pagar",
                            PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                    //System.out.println("Introduce el precio");
                    precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduce el precio",
                            PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                    //System.out.println("Introduce el plazo a pagar");
                    plazo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el plazo a pagar",
                            PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                    //System.out.println("Introduce el porcentaje de pago inicial");
                    porcentaje = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el porcentaje de pago inicial",
                            PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                    //System.out.println("Introduce la descripcion");
                    descripcion = JOptionPane.showInputDialog(null, "Introduce la descripcion",
                            PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE);
                    //in.next();
                    cotizacion.setPrecio(precio);
                    cotizacion.setDescripcion(descripcion);
                    cotizacion.setPorcentajePagIn(porcentaje);
                    cotizacion.setPlazo(plazo);
                    cotizacion.setNumCotizacion(numCotizacion);
                    break;
                case 2:
                    messageDialog(PROGRAM_NAME, "El pago inicial es de $" + cotizacion.calcularPagoInicial(), JOptionPane.WARNING_MESSAGE);
                    //System.out.println("El pago inicial es de $" + cotizacion.calcularPagoInicial());
                    break;
                case 3:
                    messageDialog(PROGRAM_NAME, "El pago final es de %" + cotizacion.calcularPagoFinal(), JOptionPane.WARNING_MESSAGE);
                    //System.out.println("El pago final es de %" + cotizacion.calcularPagoFinal());
                    break;
                case 4:
                    messageDialog(PROGRAM_NAME, "El pago por el pazo de " + cotizacion.getPlazo() + " Meses es de $" +
                            cotizacion.calcularPagoMensual(), JOptionPane.WARNING_MESSAGE);

                    //System.out.println("El pago por el pazo de " + cotizacion.getPlazo() + " Meses es de $" +
                            //cotizacion.calcularPagoMensual());
                    break;
                case 5:

                    String opSubMenu = "";
                    do {
                        opSubMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                                JOptionPane.QUESTION_MESSAGE, null, subMenu, subMenu[0]);
                        /*
                        System.out.println("1- Modificar NumCotizacion");
                        System.out.println("2 - Modificar Descripcion");
                        System.out.println("3 - Modificar Porcentaje de pago inicial");
                        System.out.println("4 - Modifcar precio");
                        System.out.println("5 - Modificar Plazo");
                        System.out.println("6 - Salir");
                        System.out.println("Elige una opccion");
                        */
                        switch (op = returnValueMenu(subMenu, opSubMenu))
                        {
                            case 1:
                                //System.out.println("Introduce el numero de cotizacion");
                                numCotizacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el plazo a pagar",
                                        PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                                cotizacion.setNumCotizacion(numCotizacion);
                                break;
                            case 2:
                                //System.out.println("Introduce la descripcion");
                                descripcion = JOptionPane.showInputDialog(null, "Introduce la descripcion",
                                        PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE);
                                cotizacion.setDescripcion(descripcion);
                                break;
                            case 3:
                                //System.out.println("Introduce el porcentaje de pago inicial");
                                porcentaje = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el porcentaje de pago inicial",
                                        PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                                cotizacion.setPorcentajePagIn(porcentaje);
                                break;
                            case 4:
                                //System.out.println("Introduce el precio");
                                precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduce el precio",
                                        PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                                cotizacion.setPrecio(precio);
                                break;
                            case 5:
                                //System.out.println("Introduce el plazo a pagar");
                                plazo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el plazo a pagar",
                                        PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                                cotizacion.setPlazo(plazo);
                                break;
                            case 6:
                                break;//Y LE DAMOS UN SUCULENTO BREAK e.e
                            default: System.out.println("Opccion invalida");
                        }
                    }while (op != 6);
                    op = 0;
                    break;
                case 6:
                    messageDialog(PROGRAM_NAME, "Adios uwu", JOptionPane.WARNING_MESSAGE);
                    break;
                default: System.out.println("Opccion invalida");
            }
        }while (op != 6);




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
        return position;//REGRESA LA POSICION DE DONDE SE ENCONTRO LA CADENA DE TEXT + 1 EL CUAL LOS CASE INDEXAN A LA SUPUESTA OPCCION
    }

    private static void messageDialog(String title, String message, int option)
    {
        JOptionPane.showMessageDialog(null, message, title, option);

    }

}
