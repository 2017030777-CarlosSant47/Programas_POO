package programa1;

import javax.swing.*;
import java.util.Scanner;

public class BancoMain {


    private static final String NAMEPROGRAM = "Banco";
    public static void main(String[] agrs)
    {
        int numCuenta = 0, monto = 0, edad = 0, op = 0;
        String nombre, sucursal, fechaAper, fechaNac, domicilio = "";
        float saldo = 0.0f;
        String opMenu = "";
        Object menu[] = {"1 - Crear Cuenta", "2 - Depositar", "3 - Retirar", "4 - Consultar Saldo", "5 - Editar Cuenta",
                "6 - Mostrar informacion del cliente", "7 - Salir"};
        Object subMenu[] = {"1 - Editar nombre", "2 - Editar fecha de apertura", "3 - Editar fecha de nacimiento", "4 - Editar sucursal",
            "5 - Editar numero de cuenta", "6 - Editat domicilio", "7 - Salir"};
        Scanner in = new Scanner(System.in);
        CuentaBanco cuenta = new CuentaBanco();


        do{

            opMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

            for(int x = 0; x < menu.length; x++)
            {
                if(menu[x].toString().matches(opMenu))
                {
                    op = x + 1;
                    break;
                }
            }
            /*
            System.out.println("1 - Crear Cuenta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Retirar");
            System.out.println("4 - Consultar Saldo");
            System.out.println("5 - Editar Cuenta");
            System.out.println("6 - Mostrar informacion del cliente");
            System.out.println("7 - Salir");
            */
            //System.out.println("Elige una opccion");

            //op = in.nextInt();
            switch (op)
            {
                case 1:
                    //System.out.println("Introduce el numero de la cuenta");
                    numCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de la cuenta",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    //System.out.println("Introduce la sucursal");
                    sucursal = JOptionPane.showInputDialog(null, "Introduce la sucursal",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                    //System.out.println("Introduce la fecha de apertura");
                    fechaAper = JOptionPane.showInputDialog(null, "Introduce la fecha de apertura",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                    //System.out.println("Introduce el nombre");
                    nombre = JOptionPane.showInputDialog(null, "Introduce el nombre",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                    //System.out.println("Introduce la fecha de nacimiento");
                    fechaNac = JOptionPane.showInputDialog(null, "Introduce la fecha de nacimiento",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                    //System.out.println("Introduce el deposito de 1000 MXN o  mas");
                    monto = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el deposito de 1000 MXN o  mas",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    //System.out.println("Introduce la edad (mayor de 18)");
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la edad (mayor de 18)",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    //System.out.println("Introduce el domicilio");
                    domicilio = JOptionPane.showInputDialog(null, "Introduce el domicilio",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                    if(cuenta.crearCuenta(nombre, monto, fechaAper, edad, fechaNac, domicilio))
                    {
                        cuenta.setNumCueta(numCuenta);
                        cuenta.setSucursal(sucursal);
                    }
                    else
                    {
                        messageDialog("Banco", "Error al crear la cuenta", JOptionPane.OK_OPTION);
                        //System.out.println("Error al crear la cuenta");
                    }

                    break;
                case 2:
                    //System.out.println("Introduce la cantidad a depositar");
                    saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad a depositar",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    cuenta.depositarFondos(saldo);
                    break;
                case 3:

                    //System.out.println("Introduce la cantidad a retirar");
                    monto = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad a retirar",
                            NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                    if(!cuenta.retirarFondos(monto))
                    {
                        messageDialog(NAMEPROGRAM, "No ha suficientes fondos", JOptionPane.ERROR_MESSAGE);
                        //System.out.println("No hay suficientes fondos");
                    }
                    break;
                case 4:
                    messageDialog(NAMEPROGRAM, "El saldo es de $" + cuenta.consultarSaldo() + " MXN", JOptionPane.WARNING_MESSAGE);
                    //System.out.println("El saldo es de $" + cuenta.consultarSaldo() + " MXN");
                    break;
                case 5:
                    String opSubMenu = "";
                    do {
                        opSubMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                                JOptionPane.QUESTION_MESSAGE, null, subMenu, subMenu[0]);
                        /*
                        System.out.println("1 - Editar nombre");
                        System.out.println("2 - Editar fecha de apertura");
                        System.out.println("3 - Editar fecha de nacimiento");
                        System.out.println("4 - Editar sucursal");
                        System.out.println("5 - Editar numero de cuenta");
                        System.out.println("6 - Editat domicilio");
                        System.out.println("7 - Salir");
                        System.out.println("Elige una opccion");
                        */

                        for(int x = 0; x < subMenu.length; x++)
                        {
                            if(subMenu[x].toString().matches(opSubMenu))
                            {
                                op = x + 1;
                                break;//SUCULENTO BREAK e.e by Conalep Team
                            }
                        }
                        switch (op)
                        {
                            case 1:
                                //System.out.println("Introduce el nombre del cliente de la cuenta");
                                nombre = JOptionPane.showInputDialog(null, "Introduce el nombre",
                                        NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                                cuenta.setNombreCliente(nombre);
                                break;
                            case 2:
                                //System.out.println("Introduce la fecha de apertura");
                                fechaAper = JOptionPane.showInputDialog(null, "Introduce la fecha de apertura",
                                        NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                                cuenta.setFechaApertura(fechaAper);
                                break;
                            case 3:
                                //System.out.println("Introduce la fecha de nacimiento");
                                fechaNac = JOptionPane.showInputDialog(null, "Introduce la fecha de nacimiento",
                                        NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                                cuenta.setFechaNacimiento(fechaNac);
                                break;
                            case 4:
                                //System.out.println("Introduce la sucursal");
                                sucursal = JOptionPane.showInputDialog(null, "Introduce la sucursal",
                                        NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                                cuenta.setSucursal(sucursal);
                                break;
                            case 5:
                                //System.out.println("Introduce el numero de la cuenta");
                                numCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de la cuenta",
                                        NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE));
                                cuenta.setNumCueta(numCuenta);
                                break;
                            case 6:
                                //System.out.println("Introduce el domicilio");
                                domicilio = JOptionPane.showInputDialog(null, "Introduce el domicilio",
                                        NAMEPROGRAM, JOptionPane.QUESTION_MESSAGE);
                                cuenta.setDomicilio(domicilio);
                                break;
                            case 7:
                                break;
                            default: System.out.println("Opccion invalida");
                        }
                    }while (op != 7);
                    op = 0;
                    break;
                case 6:
                    messageDialog(NAMEPROGRAM, cuenta.getNombreCliente() + " Nacio el " + cuenta.getFechaNacimiento()
                            + " con domicilio en " + cuenta.getDomicilio(), JOptionPane.WARNING_MESSAGE);
                    //System.out.println(cuenta.getNombreCliente() + " Nacio el " + cuenta.getFechaNacimiento() + " con domicilio en " + cuenta.getDomicilio());
                    break;
                case 7:
                    messageDialog(NAMEPROGRAM, "Adios 7u7", JOptionPane.WARNING_MESSAGE);
                    //System.out.println("Adios 7u7");
                    break;
                default: System.out.println("Opccion invalida");
            }

        }while (op != 7);

    }

    private static void messageDialog(String title, String message, int option)
    {
        JOptionPane.showMessageDialog(null, message, title, option);

    }
}
