/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umaslamdaee;

/**
 *
 * @author ingesis
 */
public class Individuo {
    
    
     private double[] genotipo;
     private double varianzas[];
     private double evaluacion;

    public double[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(double[] genotipo) {
        this.genotipo = genotipo;
    }

    public double[] getVarianzas() {
        return varianzas;
    }

    public void setVarianzas(double[] varianzas) {
        this.varianzas = varianzas;
    }

    public double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(double evaluacion) {
        this.evaluacion = evaluacion;
    }
     
     
     
}
