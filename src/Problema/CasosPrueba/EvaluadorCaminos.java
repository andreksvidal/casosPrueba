/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Problema.CasosPrueba;

import GRAFO.Arista;
import java.util.ArrayList;



/**
 * 
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public abstract class EvaluadorCaminos {

   
    
    
    
    public abstract double probCobertura(double[] genotipo, ArrayList<Object> entradas, ArrayList<ArrayList<Arista>> caminos);   
}
