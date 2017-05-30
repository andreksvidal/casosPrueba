/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author acer_acer
 */
public class AsignadorValor {
    
    
    private String condicion ;

    public AsignadorValor(String condicion) {
        this.condicion = condicion;
    }

    
    
    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
    
    
    public double resolverValor (ArrayList<Double> subVector , HashMap<String, Integer> variablesSimples)
    {
        int p= variablesSimples.get("p");
        int q= variablesSimples.get("q");
        
        return  subVector.get(p) + subVector.get(q);
    }
}
