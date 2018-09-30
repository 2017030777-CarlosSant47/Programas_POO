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
public class Programa1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Object menu[] = {"1 - Iniciar objeto", "2 - Consultar fecha", "3 - Cuantos dias tiene el mes", "4 - Es año biciesto",
                "5 - Modificar Fecha", "6 - Salir"};
        Object submenu[] = {"1 - Modificar Dia", "2 - Modificar Mes", "3 - Modificar Año", "4 - Salir"};
        String opMenu = "";
        int day = 0, month = 0, year = 0, op = 0;
        Fecha hoy = new Fecha();
        do{
            opMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
            /*
            System.out.println("1 - Iniciar objeto");
            System.out.println("2 - Consultar fecha");
            System.out.println("3 - Cuantos dias tiene el mes");
            System.out.println("4 - Es año biciesto");
            System.out.println("5 - Modificar Fecha");
            System.out.println("6 - Salir");
            System.out.println("Elige una opccion \n -> ");
            op = in.nextInt();
            */

            switch(opMenu)
            {
                case (String) "1 - Iniciar objeto":

                    day = Integer.parseInt(JOptionPane.showInputDialog(null, "Dame el dia",
                            "Fecha", JOptionPane.QUESTION_MESSAGE));

                    month = Integer.parseInt(JOptionPane.showInputDialog(null, "Dame el mes",
                            "Fecha", JOptionPane.QUESTION_MESSAGE));

                    year = Integer.parseInt(JOptionPane.showInputDialog(null, "Dame el año",
                            "Fecha", JOptionPane.QUESTION_MESSAGE));
                    /*
                    System.out.println("Dame el dia");
                    day = in.nextInt();
                    System.out.println("Dame el mes");
                    month = in.nextInt();
                    System.out.println("Dame el año");
                    year = in.nextInt();
                    */
                    hoy.setDia(day);
                    hoy.setMes(month);
                    hoy.setAño(year);
                    break;
                case (String)"2 - Consultar fecha":
                    JOptionPane.showMessageDialog(null, hoy.fechaConFormato(), "Fecha", JOptionPane.QUESTION_MESSAGE);
                    //System.out.println("La fecha es " + hoy.fechaConFormato());
                    break;
                case "3 - Cuantos dias tiene el mes":
                    JOptionPane.showMessageDialog(null, "Los el mes numero " + hoy.getMes() + " tiene " + hoy.diasMes(), "Fecha", JOptionPane.QUESTION_MESSAGE);

                    //System.out.println("Los el mes numero" + hoy.getMes() + " tiene " + hoy.diasMes());
                    break;
                case "4 - Es año biciesto":
                    if(hoy.isBiciesto())
                    {
                        JOptionPane.showMessageDialog(null, "El año " + hoy.getAño() + " es biciesto", "Fecha", JOptionPane.QUESTION_MESSAGE);

                        //System.out.println("El año " + hoy.getAño() + " es biciesto");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El año " + hoy.getAño() + " no es biciesto", "Fecha", JOptionPane.QUESTION_MESSAGE);
                        //System.out.println("El año " + hoy.getAño() + " no es biciesto");
                    }
                    break;
                case "5 - Modificar Fecha":
                    String opSubMenu = "";
                    do{
                        /*
                        System.out.println("1 - Modificar Dia");
                        System.out.println("2 - Modificar Mes");
                        System.out.println("3 - Modificar Año");
                        System.out.println("4 - Salir");
                        System.out.println("Elige una opccion");
                        op = in.nextInt();
                        */
                        opSubMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                                JOptionPane.QUESTION_MESSAGE, null, submenu, submenu[0]);
                        switch(opSubMenu)
                        {
                            case "1 - Modificar Dia":
                                day = Integer.parseInt(JOptionPane.showInputDialog(null, "Dame el dia",
                                        "Fecha", JOptionPane.QUESTION_MESSAGE));
                                hoy.setDia(day);
                                break;
                            case "2 - Modificar Mes":
                                month = Integer.parseInt(JOptionPane.showInputDialog(null, "Dame el mes",
                                        "Fecha", JOptionPane.QUESTION_MESSAGE));
                                hoy.setMes(month);
                                break;
                            case "3 - Modificar Año":
                                year = Integer.parseInt(JOptionPane.showInputDialog(null, "Dame el año",
                                        "Fecha", JOptionPane.QUESTION_MESSAGE));
                                hoy.setAño(year);
                            case "4 - Salir":
                                break;
                            default: System.out.println("Opccion invalida");
                        }
                       
                    }while(opSubMenu != "4 - Salir");
                    break;
                case "6 - Salir":
                    messageDialog("Fecha", "Adios :) oxoxoxoxo", JOptionPane.OK_OPTION);
                    System.out.printf("Adios :) oxoxoxoxo");
                    break;

                default: System.out.println("Opccion invalida");
            }
            /*
            System.out.println("Presione cualquier boton para continuar");
            in.nextInt();
            */
        }while(opMenu != "6 - Salir");
    }


    private static void messageDialog(String title, String message, int option)
    {
        JOptionPane.showMessageDialog(null, message, title, option);

    }

    
}
