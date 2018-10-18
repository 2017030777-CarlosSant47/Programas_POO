package programa1;

public abstract class Empleado {
    protected int numEmpleado;
    protected String nombre;
    protected Puesto puesto;
    protected String fechaIngreso;



    public Empleado()
    {
        this.setNombre("");
        this.setNumEmpleado(0);
        this.setPuesto(null);
        this.setFechaIngreso("12/02/2000");
    }

    public Empleado(int numEmpleado, String nombre, Puesto puesto, String fechaIngreso)
    {
        this.setFechaIngreso(fechaIngreso);
        this.setPuesto(puesto);
        this.setNumEmpleado(numEmpleado);
        this.setNombre(nombre);
    }


    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public abstract float calcularPago();


    public abstract float calcularImpuesto();

}
