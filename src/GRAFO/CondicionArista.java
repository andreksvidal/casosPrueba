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

    public CondicionArista(String valor, String condicion, double valorComparar) {
        this.valor = valor;
        this.condicion = condicion;
        this.valorComparar = valorComparar;
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
