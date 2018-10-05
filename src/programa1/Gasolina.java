package programa1;

public class Gasolina {
    private int idGasonlina;
    private int tipo;
    private String marca;
    private float precioBase;

    public Gasolina()
    {
        this.idGasonlina = 1;
        this.tipo = 1;
        this.precioBase = 0.0f;
        this.marca = "";

    }

    public Gasolina(int idGasonlina, int tipo, String marca, float precioBase)
    {
        this.idGasonlina = idGasonlina;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.marca = marca;
    }


    public Gasolina(Gasolina gas)
    {
        this.idGasonlina = gas.idGasonlina;
        this.tipo = gas.tipo;
        this.precioBase = gas.precioBase;
        this.marca = gas.marca;
    }




    public int getIdGasonlina() {
        return idGasonlina;
    }

    public void setIdGasonlina(int idGasonlina) {
        this.idGasonlina = idGasonlina;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public float calcularPrecio(){
        float precio = 0.0f;
        switch (this.tipo)
        {
            case 1:
                precio = this.precioBase + (this.precioBase * .10f);
                break;
            case 2:
                precio = this.precioBase + (this.precioBase * .20f);
                break;
            case 3:
                precio = this.precioBase + (this.precioBase * .25f);
                break;
            default: precio = this.precioBase + (this.precioBase * .10f);
        }

        return precio;
    }
}
