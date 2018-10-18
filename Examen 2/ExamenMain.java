package programa1;

import javax.swing.*;

public class ExamenMain {

    public static void main(String[] agrs)
    {
        Docente docente = new Docente();
        int numEmpleado = 0, numMaterias = 0, pagoHoras = 0, numPuesto = 0, nivel = 0, tipoPuesto = 0;
        String nombre = "", fechaIngreso = "", funcion = "", descripcion;
        Object menu[] = {"Capturar Empleado", "Campturar Puesto", "Calcular Pago", "Calcular Percepciones", "Calcular Impuesto", "Total a pagat"
        ,"Salir"}, nivelMenu[] = {"Tecnico", "Lic e Ing", "Maestria", "Doctorado"}, puestoMenu[] = {"Eventual", "Base"};

        int op = 0;
        String opMenu = "";
        do {
            opMenu = (String) JOptionPane.showInputDialog(null, "Elige una opccion", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
            op = returnValueMenu(menu, opMenu);

            switch (op)
            {
                case 1:
                    numEmpleado = Integer.parseInt(JOptionPane.showInputDialog(null,"Intruduce el numero de empleado", "Docente", JOptionPane.WARNING_MESSAGE));
                    nombre = JOptionPane.showInputDialog(null,"Intruduce el nombre", "Docente", JOptionPane.WARNING_MESSAGE);
                    fechaIngreso = JOptionPane.showInputDialog(null,"Intruduce el fecha Ingreso", "Docente", JOptionPane.WARNING_MESSAGE);
                    numMaterias = Integer.parseInt(JOptionPane.showInputDialog(null,"Intruduce el numero de materias impartidas", "Docente", JOptionPane.WARNING_MESSAGE));
                    pagoHoras = Integer.parseInt(JOptionPane.showInputDialog(null,"Intruduce el pago por hora", "Docente", JOptionPane.WARNING_MESSAGE));

                    docente.setNumMaterias(numMaterias);
                    docente.setPagoHora(pagoHoras);
                    docente.setNombre(nombre);
                    docente.setFechaIngreso(fechaIngreso);
                    docente.setNumEmpleado(numEmpleado);

                    break;
                case 2:

                    String opNivel = "", opPuesto;
                    numPuesto = Integer.parseInt(JOptionPane.showInputDialog(null,"Intruduce el numero de puesto", "Docente", JOptionPane.WARNING_MESSAGE));
                    descripcion =  JOptionPane.showInputDialog(null,"Intruduce la descripcion", "Docente", JOptionPane.WARNING_MESSAGE);
                    funcion =  JOptionPane.showInputDialog(null,"Intruduce la funcion", "Docente", JOptionPane.WARNING_MESSAGE);
                    opNivel = (String) JOptionPane.showInputDialog(null, "Elige el nivel de puesto", "Nivel",
                            JOptionPane.QUESTION_MESSAGE, null, nivelMenu, nivelMenu[0]);
                    opPuesto = (String) JOptionPane.showInputDialog(null, "Elige el tipo de puesto", "Tipo Puesto",
                            JOptionPane.QUESTION_MESSAGE, null, puestoMenu, puestoMenu[0]);
                    nivel = returnValueMenu(nivelMenu, opNivel);
                    tipoPuesto = returnValueMenu(puestoMenu, opPuesto);
                    Puesto puesto = new Puesto(numPuesto, descripcion, funcion, nivel, tipoPuesto);
                    docente.setPuesto(puesto);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "El pago del empleado es de $" + docente.calcularPago(), "Docente", JOptionPane.WARNING_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "El pago de percepcion es de $" + docente.calcularPercepcion(), "Docente", JOptionPane.WARNING_MESSAGE);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "El impuesto es de $" + docente.calcularImpuesto(), "Docente", JOptionPane.WARNING_MESSAGE);

                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "El pago total es de $" + docente.calcularTotal(), "Docente", JOptionPane.WARNING_MESSAGE);

                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Adios uwu", "Docente", JOptionPane.WARNING_MESSAGE);

                    break;
                default:
            }
        }while (menu.length != op);


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
