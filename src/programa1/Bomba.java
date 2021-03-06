package programa1;

public class Bomba {

    private int numBomba;
    private Gasolina gasolina;
    private int litrosvendidos;
    private int capacidad;


    public Bomba()
    {
        this.numBomba = 1;
        this.gasolina = null;
        this.litrosvendidos = 0;
        this.capacidad = 1000;
    }

    public int getNumBomba() {
        return numBomba;
    }

    public void setNumBomba(int numBomba) {
        this.numBomba = numBomba;
    }

    public Gasolina getGasolina() {
        return gasolina;
    }

    public void setGasolina(Gasolina gasolina) {
        this.gasolina = gasolina;
    }

    public int getLitrosvendidos() {
        return litrosvendidos;
    }

    public void setLitrosvendidos(int litrosvendidos) {
        this.litrosvendidos = litrosvendidos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    private int revisarCantidadGas()
    {
        return this.getCapacidad() - this.getLitrosvendidos();
    }

    public float calcularVenta(int litros)
    {
        float venta = 0.0f;
        if(this.revisarCantidadGas() > 0)
        {
            venta = gasolina.calcularPrecio() * litros;
            this.setLitrosvendidos(this.getLitrosvendidos() + litros);
        }

        return venta;
    }


    public float calcularVentaTotal(){
        float total = 0.0f;
        total = this.litrosvendidos * gasolina.calcularPrecio();
        return total;
    }


}
