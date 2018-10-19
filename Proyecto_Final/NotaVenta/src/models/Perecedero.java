package models;

public class Perecedero  extends Producto{

    private String fechaCaducidad;
    private int temperatura;

    public Perecedero()
    {
        super();
        this.temperatura = 0;
        this.fechaCaducidad = "";
    }



    public Perecedero(int id, String nombrepro, int unidad, float precio, String fechaCaducidad, int temperatura)
    {
        super(id, nombrepro, unidad, precio);
        this.setFechaCaducidad(fechaCaducidad);
        this.setTemperatura(temperatura);
    }


    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public float calcularPrecio() {
        float precio  = 0.0f;
        switch (this.getUnidad())
        {
            case 1:
                precio = this.getPrecio() + (this.getPrecio() * 0.03f);
                break;
            case 2:
                precio = this.getPrecio() + (this.getPrecio() * 0.05f);
                break;
            case 3:
                precio = this.getPrecio() + (this.getPrecio() * 0.04f);
                break;
        }
        return precio + (precio * 0.50f);
    }
}
