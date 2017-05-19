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
public class PruebasSombreroMexicano {

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
        Evaluador evaluador = new EvaluadorFuncion2();//Para la funcion del sombrero Mexicano.
        /*FIN EVALUADORES*/

        int dimensionGenes = 2;//Dimension del vector del individuo.
        float rangoMinimo = -3;// Rango maximo del numero a generar aleatoriamente para crear un individuo.
        float rangoMaximo = 3;//  Rango minimo del numero a generar aleatoriamente para crear un individuo.

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
        System.out.println("Funcion SombreroMexicano: ");
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
