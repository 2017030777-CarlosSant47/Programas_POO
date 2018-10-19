package models;

public abstract class NotaVenta {
    protected int numero;
    protected String consepto;
    protected String fecha;
    protected int tipoPago;
    private float cantidad;
    protected Perecedero producto;


    public NotaVenta()
    {
        this.consepto = "";
        this.fecha = "01/01/1979";
        this.tipoPago = 1;
        this.numero = 0;
        this.producto = null;
        this.setCantidad(0);

    }

    public NotaVenta(int numero, int tipoPago, String fecha, String consepto, float cantidad, Perecedero producto)
    {
        this.consepto = consepto;
        this.fecha = fecha;
        this.tipoPago = tipoPago;
        this.numero = numero;
        this.producto = producto;
        this.setCantidad(cantidad);
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getConsepto() {
        return consepto;
    }

    public void setConsepto(String consepto) {
        this.consepto = consepto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Perecedero getProducto() {
        return producto;
    }

    public void setProducto(Perecedero producto) {
        this.producto = producto;
    }


    public abstract float calcularPago();

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}
