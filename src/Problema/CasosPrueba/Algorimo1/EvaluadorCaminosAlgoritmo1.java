/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Problema.CasosPrueba.Algorimo1;

import Problema.CasosPrueba.EvaluadorCaminos;
import java.util.ArrayList;

/**
 * 
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public class EvaluadorCaminosAlgoritmo1 extends EvaluadorCaminos{

  

    
    @Override
    public double probCobertura(double[] genotipo) {
        double caminosCubiertos= cubreCamino1(Math.floor(genotipo[0]),Math.floor(genotipo[1]))+ cubreCamino2(Math.floor(genotipo[2]),Math.floor(genotipo[3])) + cubreCamino3(Math.floor(genotipo[4]),Math.floor(genotipo[5])) + cubreCamino4(Math.floor(genotipo[6]),Math.floor(genotipo[7])) ;
        double probabilidad= (double)caminosCubiertos/4;
        return probabilidad;
    }
    
    public int cubreCamino1(double p, double q)
    {
        /*4-8*/
        if(p+q<=10)
        {
            return 0;
        }
        else if(p<=50)
        {
            return 0;
        }
            
        return 1;
    }
    
    
    public int cubreCamino2(double p, double q)
    {
        /*3-8*/
        if(p+q>10)
        {
            return 0;
        }
        else if(p<=50)
        {
            return 0;
        }
            
        return 1;
    }
    
    
    public int cubreCamino3(double p, double q)
    {
        /*4-7*/
        if(p+q<=10)
        {
            return 0;
        }
        else if(p>50)
        {
            return 0;
        }
            
        return 1;
    }
    
    
     public int cubreCamino4(double p, double q)
    {
        /*3-7*/
        if(p+q>10)
        {
            return 0;
        }
        else if(p>50)
        {
            return 0;
        }
            
        return 1;
    }
    
    
    

   
}
