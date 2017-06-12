/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFO;

/**
 *
 * @author Andres Vidal - FIET - Ingeniería de Sistemas . 2017
 */
public class AsignacionVertice {
    
    
    public String variable;
    public String valorResolver;

    
    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getValorResolver() {
        return valorResolver;
    }

    public void setValorResolver(String valorResolver) {
        this.valorResolver = valorResolver;
    }

    public AsignacionVertice(String variable, String valorResolver) {
        this.variable = variable;
        this.valorResolver = valorResolver;
    }
    
    
    
}
