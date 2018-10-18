package programa1;

public class Docente extends Empleado{
    private int numMaterias;
    private float pagoHora;


    public Docente()
    {
        super();
        this.numMaterias = 0;
        this.pagoHora = 0;
    }



    public Docente(int numEmpleado, String nombre, Puesto puesto, String fechaIngreso, int numMaterias, int pagoHora)
    {
        super(numEmpleado, nombre, puesto, fechaIngreso);

        this.pagoHora = pagoHora;
        this.numMaterias = numMaterias;
    }



    public int getNumMaterias() {
        return numMaterias;
    }

    public void setNumMaterias(int numMaterias) {
        this.numMaterias = numMaterias;
    }

    public float getPagoHora() {
        return pagoHora;
    }

    public void setPagoHora(float pagoHora) {
        this.pagoHora = pagoHora;
    }

    @Override
    public float calcularPago() {
        return this.numMaterias * this.pagoHora + ((this.numMaterias * this.pagoHora)*0.18f);
    }

    @Override
    public float calcularImpuesto() {
        float impuesto = 0;
        switch (this.getPuesto().getNivel())
        {
            case 1:
            case 2:
                impuesto = this.calcularPago() * 0.16f;
                break;
            case 3:
            case 4:
                impuesto = (this.calcularPago()) * 0.18f;
                break;
            default: impuesto = (this.calcularPago()) * 0.16f;
        }
        return impuesto;
    }


    public float calcularPercepcion()
    {
        float percepcion = 0;
        switch (this.numMaterias)
        {
            case 1:
            case 2:
            case 3:
                percepcion = calcularPago() *0.10f;
                break;
            case 4:
            case 5:
                percepcion = calcularPago() * 0.30f;
                break;
            default: percepcion = calcularPago() * 0.30f;
        }
        return percepcion;
    }

    public float calcularTotal()
    {
        return (this.calcularPago() - this.calcularImpuesto()) + this.calcularPercepcion();
    }




}
