package programa1;

public class Puesto {

    private int numPuesto;
    private String descripcion;
    private String funcion;
    private int nivel;
    private int tipoPuesto;

    public Puesto()
    {
        this.numPuesto = 0;
        this.descripcion = "";
        this.funcion = "";
        this.nivel = 0;
        this.tipoPuesto = 0;
    }

    public Puesto(int numPuesto, String descripcion, String funcion, int nivel, int tipoPuesto)
    {
        this.numPuesto = numPuesto;
        this.descripcion = descripcion;
        this.funcion = funcion;
        this.nivel = nivel;
        this.tipoPuesto = tipoPuesto;
    }

    public Puesto(Puesto puesto)
    {
        this.numPuesto = puesto.numPuesto;
        this.descripcion =  puesto.descripcion;
        this.funcion =  puesto.funcion;
        this.nivel =  puesto.nivel;
        this.tipoPuesto =  puesto.tipoPuesto;
    }

    public int getNumPuesto() {
        return numPuesto;
    }

    public void setNumPuesto(int numPuesto) {
        this.numPuesto = numPuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(int tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }
}
