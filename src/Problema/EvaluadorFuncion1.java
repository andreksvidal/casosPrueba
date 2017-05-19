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
public class EvaluadorFuncion1 extends Evaluador{

    
    private double a;
    private double b;
    private double c;

    public EvaluadorFuncion1(double a, double b ,double c) {
        super();
        this.a = a;
        this.b=b;
        this.c = c;
    }
    
    
    
    @Override
    public void evaluar(ArrayList<Individuo> poblacion) {
        
        for (Individuo individuo : poblacion) {
            double evaluacion= evaluarConfuncion1(individuo.getGenotipo());
            
            individuo.setEvaluacion(evaluacion);
        }
    }
    
    
    public double evaluarConfuncion1(double genotipo[])
    {
        double exp1=0,exp2=0,exp3=0,exp4=0;
        double d=genotipo.length;
        double sumaXi2=0;
        double sumaCosCXi=0;
        
        for (double xi : genotipo) {
            sumaXi2=sumaXi2+ (xi*xi);
            sumaCosCXi=sumaCosCXi + (Math.cos(c*xi));
        }
        
        
        
        exp1=(this.a*-1)*  Math.pow(Math.E,(-1*this.b)*(Math.sqrt((1/d) * sumaXi2)));
        
        exp2=(-1)*Math.pow(Math.E, (1/d)*sumaCosCXi);
        
        exp3=this.a;
        
        exp4= Math.E;
        
        
        double funcion = exp1+ exp2 + exp3 + exp4;
        
        return  funcion;
    }
    
        
        
}
