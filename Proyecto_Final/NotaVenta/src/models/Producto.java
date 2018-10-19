package models;

public abstract class Producto {

    protected int idProducto;
    protected String nombreProd;
    protected int unidad;
    protected float precio;


    public Producto()
    {
        this.idProducto = 0;
        this.nombreProd = "";
        this.unidad = 1;
        this.precio = 0.0f;
    }

    public Producto(int idProducto, String nombreProd, int unidad, float precio)
    {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.unidad = unidad;
        this.precio = precio;
    }



    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public abstract float calcularPrecio();
}
