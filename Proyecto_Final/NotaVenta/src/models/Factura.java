package models;

public class Factura extends NotaVenta {

    private String nombre;
    private String rfc;
    private String domicilio;
    private String fechaFac;
    private int iva;



    public Factura()
    {
        super();
        this.setNombre("");
        this.setDomicilio("");
        this.setFechaFac("");
        this.setIva(16);
        this.setRfc("");
    }

    public Factura(int numero, String fecha, String consepto, int tipoPago, Perecedero perecedero, float cantidad, String nombre, String rfc, String domicilio, String fechaFac, int iva)
    {
        super(numero, tipoPago, fecha, consepto, cantidad, perecedero);
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
        this.setFechaFac(fechaFac);
        this.setIva(iva);
        this.setRfc(rfc);

    }


    @Override
    public float calcularPago() {
        return this.getProducto().calcularPrecio() * this.getCantidad();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaFac() {
        return fechaFac;
    }

    public void setFechaFac(String fechaFac) {
        this.fechaFac = fechaFac;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public float calcularImpuesto()
    {
        return (this.calcularPago() * iva) / 100;
    }

    public float calcularTotal()
    {
        return this.calcularImpuesto() + calcularPago();
    }




}
