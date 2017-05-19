/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Problema;

import java.util.ArrayList;
import umaslamdaee.Evaluador;
import umaslamdaee.Individuo;

/**
 * 
 * @author Andres Vidal Zemanate
/* FIET-Ingenieria de Sistemas
 */
public class EvaluadorFuncion2 extends Evaluador{

    @Override
    public void evaluar(ArrayList<Individuo> poblacion) {
      
         for (Individuo individuo : poblacion) {
            double evaluacion= evaluarConfuncion2(individuo.getGenotipo());
            
            individuo.setEvaluacion(evaluacion);
        }
    }

    private double evaluarConfuncion2(double[] genotipo) {
        double numerador=0.0, denominador=0.0;
        
        numerador= Math.sin(Math.sqrt((genotipo[0]*genotipo[0]) + (genotipo[1]*genotipo[1])));
        denominador= Math.sqrt((genotipo[0]*genotipo[0]) + (genotipo[1]*genotipo[1]));
        
        double funcion= numerador/denominador;
        
        return funcion;
    }
    
     

}
