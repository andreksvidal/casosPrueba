/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umaslamdaee;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ingesis
 */
public class GeneradorPoblacion {

    private float min;
    private float max;   
   
    public GeneradorPoblacion(float min, float max) {
        this.min = min;
        this.max = max;
    }
        
    
    
    public ArrayList<Individuo> generarPoblacion(int dimensionGenes) {

      
        
        ArrayList<Individuo> individuos = new ArrayList();

        

        for (int i = 0; i < 100; i++) {
            double genes[] = new double[dimensionGenes] ;
            double sigmas[] = new double[dimensionGenes];

            for (int j = 0; j < dimensionGenes; j++) {
                sigmas[j] = 1;
                Random r = new Random();
                double gen = r.nextDouble() * (this.max - this.min) + this.min;
                genes[j]=gen;

            }
            
            Individuo ind= new Individuo();
            ind.setGenotipo(genes);
            ind.setVarianzas(sigmas);
            individuos.add(ind);
        }
        return individuos;
    }
}
