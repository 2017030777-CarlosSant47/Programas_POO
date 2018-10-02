package programa1;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
                                     |####`--|#|---|##|---|#|--'##|#|
   _                                 |____,--|#|---|##|---|#|--.__|_|
 _|#)_____________________________________,--'EEEEEEEEEEEEEE'_=-.
((_____((_________________________,-Programing by CarlosSant47 ==)        _________
                               .--|##,----o  o  o  o  o  o  o__|/`---,-,-'=========`=+==.
                               |##|_Y__,__.-._,__,  __,-.___/ J \ .----.#############|##|
                               |##|              `-.|#|##|#|`===l##\   _\############|##|
                              =======-===l          |_|__|_|     \##`-"__,=======.###|##|
                                                                  \__,"          '======'
*/


public class BoletoMain {
    private static final String PROGRAM_NAME = "Boleto";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Object menu[] = {"1 - Crear Boleto", "2 - Calcular Subtotal", "3 - Calcular Descuento", "4 - Calcular Total a pagar",
        "5 - Modificar Boleto", "6 - Mostrar Informacion del Boleto", "7 - Salir"};
        final Object subMenu[] = {"1 - Modificar numero de boleto", "2 - Modificar nombre de cliente",
                "3 - Modificar destino", "4 - Modificar tipo de viaje", "5 - Modificar precio del boleto",
                "6 - Modificar fecha", "7 - Salir"};

        Object tipoBoleto[] = {"1 - Simple", "2 - Redondo"};
        int numBoleto = 0, tipoViaje = 0, op = 0, edad;
        String nombre = "", destino = "", fecha = "";
        float precio = 0.0f;
        String opMenu = "";
        Boleto boleto = new Boleto();
        do{
            /*
            printf("1 - Crear Boleto");
            printf("2 - Calcular Subtotal");
            printf("3 - Calcular Descuento");
            printf("4 - Calcular Total a pagar");
            printf("5 - Modificar Boleto");
            printf("6 - Mostrar Informacion del Boleto");
            printf("7 - Salir");
            */
            //printf("Elige una opccion");
            opMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

            for(int x = 0; x < menu.length; x++)
            {
                if(menu[x].toString().matches(opMenu)){
                    op = x + 1;
                    break;
                }
            }

            
            switch(op)
            {
                case 1:

                    numBoleto = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero del boleto",
                            PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                    //printf("Intduzca el nombre");
                    nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre",
                            PROGRAM_NAME, JOptionPane.OK_OPTION);
                    //printf("Introduzca el destino");
                    destino = JOptionPane.showInputDialog(null, "Introduzca el destino",
                            PROGRAM_NAME, JOptionPane.OK_OPTION);
                    //printf("Introduce la fecha");
                    fecha = JOptionPane.showInputDialog(null, "Introduzca el fecha",
                            PROGRAM_NAME, JOptionPane.OK_OPTION);
                    //printf("Introduce el precio del boleto $");
                    precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduzca el precio",
                            PROGRAM_NAME, JOptionPane.OK_OPTION));

                    do{
                        String opTipo = "";
                        opTipo = (String) JOptionPane.showInputDialog(null, "Introduce el tipo de boleto", "Menu",
                                JOptionPane.QUESTION_MESSAGE, null, tipoBoleto, tipoBoleto[0]);


                        for(int x = 0; x < tipoBoleto.length; x++)
                        {
                            if(tipoBoleto[x].toString().matches(opTipo)){
                                tipoViaje = x + 1;
                                break;
                            }
                        }
                    }while(tipoViaje > 2 || tipoViaje < 1);
                    boleto.setDestino(destino);
                    boleto.setFecha(fecha);
                    boleto.setTipoViaje(tipoViaje);
                    boleto.setNombreCliente(nombre);
                    boleto.setNoBoleto(numBoleto);
                    boleto.setPrecio(precio);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "El subototal a pagar es $" + boleto.calcularSubtotal() + " MXN",
                            PROGRAM_NAME, JOptionPane.DEFAULT_OPTION);
                    //printf("El subototal a pagar es $" + boleto.calcularSubtotal() + " MXN");
                    break;
                case 3:
                    //printf("Introduce la edad");
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la edad",
                            PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                    JOptionPane.showMessageDialog(null, "El descuento por edad es de $"+ boleto.calcularDescuento(edad) + " MXN",
                            PROGRAM_NAME, JOptionPane.DEFAULT_OPTION);
                    //printf("El descuento por edad es de $"+ boleto.calcularDescuento(edad) + " MXN");
                    break;
                case 4:

                    //printf("Introduce la edad");
                    //edad = in.nextInt();
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la edad",
                            PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));

                    //printf("El total a pagar es de $" + boleto.calcularTotal(edad) + " MXN");
                    JOptionPane.showMessageDialog(null, "El total a pagar es de $" + boleto.calcularTotal(edad) + " MXN",
                            PROGRAM_NAME, JOptionPane.DEFAULT_OPTION);
                    break;
                case 5:
                    String opSubMenu = "";
                    do{



                        opSubMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                                JOptionPane.QUESTION_MESSAGE, null, subMenu, subMenu[0]);
                        /*
                        printf("1 - Modificar numero de boleto");
                        printf("2 - Modificar nombre de cliente");
                        printf("3 - Modificar destino");
                        printf("4 - Modificar tipo de viaje");
                        printf("5 - Modificar precio del boleto");
                        printf("6 - Modificar fecha");
                        printf("7 - Salir");
                        */
                        op = returnValueMenu(subMenu, opSubMenu);

                        switch (op)
                        {
                            case 1:
                                //printf("Introduzca el numero de Boleto");
                                numBoleto = numBoleto = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero del boleto",
                                        PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE));
                                boleto.setNoBoleto(numBoleto);
                                break;
                            case 2:
                                //printf("Intduzca el nombre");
                                nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre",
                                        PROGRAM_NAME, JOptionPane.OK_OPTION);
                                boleto.setNombreCliente(nombre);
                                break;
                            case 3:
                                //printf("Introduzca el destino");
                                destino = JOptionPane.showInputDialog(null, "Introduzca el destino",
                                        PROGRAM_NAME, JOptionPane.OK_OPTION);
                                boleto.setDestino(destino);
                                break;
                            case 4:
                                String opTipo = "";
                                do{

                                    opTipo = (String) JOptionPane.showInputDialog(null, "Introduce el tipo de boleto", "Menu",
                                            JOptionPane.QUESTION_MESSAGE, null, tipoBoleto, tipoBoleto[0]);
                                    for(int x = 0; x < tipoBoleto.length; x++)
                                    {
                                        if(tipoBoleto[x].toString().matches(opTipo)){
                                            tipoViaje = x + 1;
                                            break;
                                        }
                                    }
                                }while(tipoViaje > 2 || tipoViaje < 1);
                                boleto.setTipoViaje(tipoViaje);
                                break;
                            case 5:
                                //printf("Introduce el precio del boleto $");
                                precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduzca el precio",
                                        PROGRAM_NAME, JOptionPane.OK_OPTION));
                                boleto.setPrecio(precio);
                                break;
                            case 6:
                                //printf("Introduzca la fecha");
                                fecha = JOptionPane.showInputDialog(null, "Introduzca el fecha",
                                        PROGRAM_NAME, JOptionPane.OK_OPTION);
                                boleto.setFecha(fecha);
                                break;
                            case 7:
                                break;
                            default: printf("Opccion invalida");
                        }
                    }while(op != 7);
                    op = 0;
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, boleto.mostrarInformacion(),
                            PROGRAM_NAME, JOptionPane.DEFAULT_OPTION);
                    //printf(boleto.mostrarInformacion());
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Adios uwu",
                            PROGRAM_NAME, JOptionPane.DEFAULT_OPTION);
                    //printf("Adios uwu");
                    break;
                default: printf("Esta opccion es invalida");
            }


        }while(op != 7);


    }
    
    
    private static void printf(String s)
    {
        System.out.println(s);
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
