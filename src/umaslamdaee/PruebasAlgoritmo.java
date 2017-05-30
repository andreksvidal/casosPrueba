/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umaslamdaee;

import GRAFO.Arista;
import GRAFO.AsignadorValor;
import GRAFO.CondicionArista;
import GRAFO.Digrafo;
import GRAFO.Vertice;
import Problema.CasosPrueba.Algorimo1.EvaluadorCaminosAlgoritmo1;
import Problema.CasosPrueba.EvaluadorAlgoritmos;
import Problema.CasosPrueba.EvaluadorCaminos;
import java.util.ArrayList;

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
        EvaluadorCaminos evCaminos = new EvaluadorCaminosAlgoritmo1();
        ArrayList<ArrayList<Arista>> caminosAristas = crearGrafo();
        ArrayList<Object> entradas = new ArrayList();
        
        entradas.add("p");
        entradas.add("q");
        entradas.add(new AsignadorValor("p+q"));
        
        Evaluador evaluador = new EvaluadorAlgoritmos(evCaminos, 4, entradas,caminosAristas);//Para la funcion del sombrero Mexicano.
        /*FIN EVALUADORES*/

        int dimensionGenes = 4 * 2;//Dimension del vector del individuo.
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

    private static ArrayList<ArrayList<Arista>> crearGrafo() {
        Digrafo<Integer> digrafo = new Digrafo<>();

        digrafo.insertarVertice(0);
        digrafo.insertarVertice(1);
        digrafo.insertarVertice(2);
        digrafo.insertarVertice(3);
        digrafo.insertarVertice(4);
        digrafo.insertarVertice(5);
        digrafo.insertarVertice(6);
        digrafo.insertarVertice(7);
        digrafo.insertarVertice(8);
        digrafo.insertarVertice(9);
        digrafo.insertarVertice(10);

        digrafo.insertarArista(1, 2);
        digrafo.insertarAristaCondicion(2, 3, new CondicionArista("p+q", "<", 10));
        digrafo.insertarAristaCondicion(2, 4, new CondicionArista("p+q", ">", 10));
        digrafo.insertarArista(3, 6);
        digrafo.insertarArista(4, 5);
        digrafo.insertarArista(5, 6);
        digrafo.insertarAristaCondicion(6, 7, new CondicionArista("p", "<", 50));
        digrafo.insertarAristaCondicion(6, 8, new CondicionArista("p", ">", 50));
        digrafo.insertarArista(8, 9);
        digrafo.insertarArista(9, 10);
        digrafo.insertarArista(7, 10);

        // System.out.println(digrafo.getAristas().getTamanio());
        System.out.println("Lista de Adyacencia:");

        digrafo.getCaminos(digrafo.buscarVertice(1), digrafo.buscarVertice(10));

        ArrayList<ArrayList<Vertice>> caminos = digrafo.getCaminos();
        ArrayList<ArrayList<Arista>> caminosAristas = new ArrayList<>();
        for (int i = 0; i < caminos.size(); i++) {
            ArrayList<Vertice> caminoTmp=caminos.get(i);
            ArrayList<Arista> caminoArTmp=new ArrayList<>();
            for (int j = 0; j < caminoTmp.size()-1; j++) {
                caminoArTmp.add(digrafo.buscarArista(caminoTmp.get(i), caminoTmp.get(i+1)));
            }
            caminosAristas.add(caminoArTmp);
        }
        return caminosAristas;

    }
    
    public void obtenerCaminos(){
        
    }

}
