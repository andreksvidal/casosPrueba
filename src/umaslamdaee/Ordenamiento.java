/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umaslamdaee;

import java.util.ArrayList;

/**
 *
 * @author Andres Vidal Zemanate /* FIET-Ingenieria de Sistemas
 */
public class Ordenamiento {

    public void insercionDirecta(ArrayList<Individuo> Poblacion, String orden) {
        int p, j;
        Individuo aux;
        for (p = 1; p < Poblacion.size(); p++) { // desde el segundo elemento hasta
            aux = Poblacion.get(p); // el final, guardamos el elemento y
            j = p - 1; // empezamos a comprobar con el anterior
            if (orden.equalsIgnoreCase("ascendente")) {
                while ((j >= 0) && (aux.getEvaluacion() < Poblacion.get(j).getEvaluacion())) { // mientras queden posiciones y el
                    // valor de aux sea menor que los
                    Poblacion.set(j + 1, Poblacion.get(j));       // de la izquierda, se desplaza a
                    j--;                   // la derecha
                }
            } else {
                while ((j >= 0) && (aux.getEvaluacion() > Poblacion.get(j).getEvaluacion())) { // mientras queden posiciones y el
                    // valor de aux sea menor que los
                    Poblacion.set(j + 1, Poblacion.get(j));       // de la izquierda, se desplaza a
                    j--;                   // la derecha
                }
            }

            Poblacion.set(j + 1, aux);
        }
    }
}
