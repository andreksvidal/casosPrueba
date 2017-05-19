/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umaslamdaee;

import Problema.EvaluadorFuncion1;
import Problema.EvaluadorFuncion2;
import Problema.EvaluadorRed;

/**
 *
 * @author Andres Vidal Zemanate /* FIET-Ingenieria de Sistemas
 */
public class PruebasAckley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ////////////////////////////////////////////////////////////
        /*BLOQUE DE PARAMETROS MODIFICABLES*/
        ///////////////////////////////////////////////////////////
        int lambda = 25;//Valor de lambda.
        int maximoIteraciones = 500;//Maximo numero de itereciones para la convergencia del algoritmo.

        /*EVALUADORES*/
        /*Permiten calcular el fitness dependiendo del problema.*/
        Evaluador evaluador = new EvaluadorFuncion1(20, 0.2, 2 * Math.PI);//Para la primera funcion.(Requiere los valores de las constantes a,b, y c.).
    

        int dimensionGenes = 5;//Dimension del vector del individuo.
        float rangoMinimo = -4;// Rango maximo del numero a generar aleatoriamente para crear un individuo.
        float rangoMaximo = 4;//  Rango minimo del numero a generar aleatoriamente para crear un individuo.

        String objetivo = "-"; //Acepta 2 parametros : > "+" : Cuando el objetivo es maximizar , ordena de mayor a menor.
        //                      > "-" : Cuando el objetivo es minimizar , ordena de menor a mayor.
        //Atencion! :  si el parametro es diferente, toma por defecto "-".
        ////////////////////////////////////////////////////////////
        /*FIN BLOQUE DE PARAMETROS MODIFICABLES*/
        ///////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////
        /*BLOQUE NO MODIFICABLE*/
        ///////////////////////////////////////////////////////////
        UMasLamdaEE algoritmo = new UMasLamdaEE(lambda, maximoIteraciones, evaluador, dimensionGenes, rangoMinimo, rangoMaximo, objetivo);
        Individuo resultado = algoritmo.ejecutarAlgoritmo();
        System.out.println("Funcion de Ackley : ");
        if (!algoritmo.isFalloAlgoritmo()) {
            System.out.println("El algoritmo convergió a lo siguiente:");

        } else {
            System.out.println("El algoritmo no logro converger luego de las iteraciones etablecidas, el mejor individuo fue: ");

        }

        for (Double xi : resultado.getGenotipo()) {

            System.out.printf("[%f]", xi);

        }
        System.out.printf("\nCon una evaluacion de: [%f]", resultado.getEvaluacion());
        System.out.println("");
        ////////////////////////////////////////////////////////////
        /*FIN BLOQUE NO MODIFICABLE*/
        ///////////////////////////////////////////////////////////
    }
    
    
    

}
