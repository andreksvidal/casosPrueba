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
public class Pareja {
    
     private Individuo padre;
     private Individuo madre;

    public Pareja(Individuo padre, Individuo madre) {
        this.padre = padre;
        this.madre = madre;
    }

    public Individuo getPadre() {
        return padre;
    }

    public void setPadre(Individuo padre) {
        this.padre = padre;
    }

    public Individuo getMadre() {
        return madre;
    }

    public void setMadre(Individuo madre) {
        this.madre = madre;
    }
     
     
     
}
