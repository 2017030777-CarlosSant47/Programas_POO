/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author CarlosSant47
 */
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

    public boolean revisarCantidadGas(int litros)
    {
        boolean vacio = false;
        if(((this.getCapacidad() - this.getLitrosvendidos()) - litros) < 0 || litros > this.capacidad)
        {
            vacio = true;
        }
        return vacio;

    }

    public float calcularVenta(int litros)
    {
        float venta = 0.0f;
            venta = gasolina.calcularPrecio() * litros;
            this.setLitrosvendidos(this.litrosvendidos + litros);


        return venta;
    }


    public float calcularVentaTotal(){
        float total = 0.0f;
        total = this.litrosvendidos * gasolina.calcularPrecio();
        return total;
    }


    public int revisarInventario()
    {
        return this.capacidad - this.litrosvendidos;
    }
}
