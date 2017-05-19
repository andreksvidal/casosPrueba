/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umaslamdaee;

import Problema.CasosPrueba.Algorimo1.EvaluadorCaminosAlgoritmo1;
import Problema.CasosPrueba.EvaluadorAlgoritmos;
import Problema.CasosPrueba.EvaluadorCaminos;

/**
 *
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public class PruebasAlgoritmo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////
        /*BLOQUE DE PARAMETROS MODIFICABLES*/
        ///////////////////////////////////////////////////////////
        int lambda = 25;//Valor de lambda.
        int maximoIteraciones = 100;//Maximo numero de itereciones para la convergencia del algoritmo.

        /*EVALUADORES*/   
        EvaluadorCaminos evCaminos= new EvaluadorCaminosAlgoritmo1();
        Evaluador evaluador = new EvaluadorAlgoritmos(evCaminos,4);//Para la funcion del sombrero Mexicano.
        /*FIN EVALUADORES*/

        int dimensionGenes = 4*2;//Dimension del vector del individuo.
        float rangoMinimo = -1000;// Rango maximo del numero a generar aleatoriamente para crear un individuo.
        float rangoMaximo = 1000;//  Rango minimo del numero a generar aleatoriamente para crear un individuo.

        String objetivo = "+"; //Acepta 2 parametros : > "+" : Cuando el objetivo es maximizar , ordena de mayor a menor.
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
        System.out.println("Casos de prueba para Algoritmo: ");
        if (!algoritmo.isFalloAlgoritmo()) {
            System.out.println("El algoritmo convergió a lo siguiente:");

        } else {
            System.out.println("El algoritmo no logro converger luego de las iteraciones etablecidas, el mejor individuo fue: ");

        }

        for (Double xi : resultado.getGenotipo()) {

            System.out.printf("[%f]", Math.floor(xi));

        }
        System.out.printf("\nCon una evaluacion de: [%f]", resultado.getEvaluacion());
        System.out.println("");
       
        ////////////////////////////////////////////////////////////
        /*FIN BLOQUE NO MODIFICABLE*/
        ///////////////////////////////////////////////////////////
    }
    
}
