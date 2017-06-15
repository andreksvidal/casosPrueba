/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFO;

/**
 *
 * @author acer_acer
 */
public class CondicionArista {
    private String valor;
    private String condicion;
    private double valorComparar;
    private boolean esFinCiclo;
    private Arista origen;
    private Arista aristaSalida;
    
    
    public CondicionArista(String valor, String condicion, double valorComparar) {
        this.valor = valor;
        this.condicion = condicion;
        this.valorComparar = valorComparar;
        this.esFinCiclo=false;
        this.origen=null;
        this.aristaSalida=null;
    }

    public CondicionArista(String valor, String condicion, double valorComparar, Arista origen, Arista aristaSalida) {
        this.valor = valor;
        this.condicion = condicion;
        this.valorComparar = valorComparar;
        this.origen = origen;
        this.aristaSalida=aristaSalida;
        this.esFinCiclo=true;
    }

    public boolean esFinCiclo() {
        return esFinCiclo;
    }

    public void setEsFinCiclo(boolean esFinCiclo) {
        this.esFinCiclo = esFinCiclo;
    }

    public Arista getOrigen() {
        return origen;
    }

    public Arista getAristaSalida() {
        return aristaSalida;
    }

    public void setAristaSalida(Arista aristaSalida) {
        this.aristaSalida = aristaSalida;
    }

    
    
    public void setOrigen(Arista origen) {
        this.origen = origen;
    }
    
    

    
    
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public double getValorComparar() {
        return valorComparar;
    }

    public void setValorComparar(double valorComparar) {
        this.valorComparar = valorComparar;
    }            
    
}
