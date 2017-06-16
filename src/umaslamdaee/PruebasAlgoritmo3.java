/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umaslamdaee;

import GRAFO.Arista;
import GRAFO.AsignacionVertice;
import GRAFO.AsignadorValor;
import GRAFO.CondicionArista;
import GRAFO.Digrafo;
import Problema.CasosPrueba.Algorimo1.EvaluadorCaminosAlgoritmo1;
import Problema.CasosPrueba.EvaluadorAlgoritmos;
import Problema.CasosPrueba.EvaluadorCaminos;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public class PruebasAlgoritmo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////
        /*BLOQUE DE PARAMETROS MODIFICABLES*/
        ///////////////////////////////////////////////////////////
        int lambda = 25;//Valor de lambda.
        int maximoIteraciones = 5000;//Maximo numero de itereciones para la convergencia del algoritmo.

        /*EVALUADORES*/
        EvaluadorCaminos evCaminos = new EvaluadorCaminosAlgoritmo1();
        ArrayList<ArrayList<Arista>> caminosAristas = crearGrafo();
        ArrayList<Object> entradas = new ArrayList();
        
        entradas.add("number");
        entradas.add(new AsignadorValor());
       
        HashMap<String , Double> variablesFlujo= new HashMap();
        
        variablesFlujo.put("sum", 0.0);
        variablesFlujo.put("pos", 1.0);
        variablesFlujo.put("digit", 0.0);
        variablesFlujo.put("result",0.0);
        variablesFlujo.put("value", 0.0);
        Evaluador evaluador = new EvaluadorAlgoritmos(evCaminos,caminosAristas.size() , entradas,caminosAristas,variablesFlujo);
        /*FIN EVALUADORES*/

        int dimensionGenes = caminosAristas.size() * (entradas.size()-1);//Dimension del vector del individuo. #Caminos * 2 variables en este caso .
        float rangoMinimo = -100;// Rango maximo del numero a generar aleatoriamente para crear un individuo.
        float rangoMaximo = 100;//  Rango minimo del numero a generar aleatoriamente para crear un individuo.

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

        digrafo.insertarVertice(1);
        digrafo.insertarVertice(2);
        digrafo.insertarVerticeConAsignacion(3 , new AsignacionVertice("digit" , "number MOD 10"));
        digrafo.insertarVertice(4);
        digrafo.insertarVerticeConAsignacion(5, new AsignacionVertice("value", "3*digit"));
        digrafo.insertarVerticeConAsignacion(6 , new AsignacionVertice("value", "digit"));
        digrafo.insertarVerticeConAsignacion(7 , new AsignacionVertice("sum", "sum+value"));
        digrafo.insertarVerticeConAsignacion(8, new AsignacionVertice("number", "number/10"));
        digrafo.insertarVerticeConAsignacion(9 , new AsignacionVertice("pos", "pos+1"));
        digrafo.insertarVertice(10);
        digrafo.insertarVerticeConAsignacion(11 , new AsignacionVertice("result","sum MOD 11"));
        digrafo.insertarVertice(12);
        digrafo.insertarVerticeConAsignacion(13, new AsignacionVertice("result", "1"));
        digrafo.insertarVertice(14);
        
        
        
       
        digrafo.insertarArista(1, 2);
        digrafo.insertarArista(2, 3);
        digrafo.insertarArista(3, 4);
        digrafo.insertarAristaCondicion(4,5, new CondicionArista("pos MOD 2", "==", 0));
        digrafo.insertarAristaCondicion(4, 6 ,  new CondicionArista("pos MOD 2","!=", 0));//
        digrafo.insertarArista(5, 7);
        digrafo.insertarArista(6, 7);//
        digrafo.insertarArista(7, 8);
        digrafo.insertarArista(8, 9);
        digrafo.insertarArista(9, 10);
        
        digrafo.insertarAristaCondicion(10, 11, new CondicionArista("number", ">", 0));
        digrafo.insertarAristaCondicion(10, 3, new CondicionArista("number", "<=",0,digrafo.buscarArista(3, 4),digrafo.buscarArista(10, 11)));
        
        digrafo.insertarArista(11, 12);
        digrafo.insertarAristaCondicion(12, 13 , new CondicionArista("result","==", 10));
        digrafo.insertarAristaCondicion(12, 14 , new CondicionArista("result", "!=", 10));
        digrafo.insertarArista(14,13);
        
        
        digrafo.hashAristas();
        digrafo.getCaminos(digrafo.buscarVertice(1), digrafo.buscarVertice(10));

        ArrayList<Arista> camino1= new ArrayList();
        ArrayList<Arista> camino2= new ArrayList();
        ArrayList<Arista> camino3= new ArrayList();
        ArrayList<Arista> camino4= new ArrayList();
        
        
//        camino1.add(digrafo.buscarArista(1,2));
//        camino1.add(digrafo.buscarArista(2,3));
//        camino1.add(digrafo.buscarArista(3,4));
//        camino1.add(digrafo.buscarArista(4,6));
//        camino1.add(digrafo.buscarArista(6,7));
//        camino1.add(digrafo.buscarArista(7,8));
//        camino1.add(digrafo.buscarArista(8,9));
//        camino1.add(digrafo.buscarArista(9,10));
//        camino1.add(digrafo.buscarArista(10,11));
//        camino1.add(digrafo.buscarArista(11,12));
//        
//        camino1.add(digrafo.buscarArista(12,14));
//        
        
        
        camino2.add(digrafo.buscarArista(1,2));
        camino2.add(digrafo.buscarArista(2,3));
        camino2.add(digrafo.buscarArista(3,4));
        camino2.add(digrafo.buscarArista(4,5));
        camino2.add(digrafo.buscarArista(5,7));
        camino2.add(digrafo.buscarArista(7,8));
        camino2.add(digrafo.buscarArista(8,9));
        camino2.add(digrafo.buscarArista(9,10));
        camino2.add(digrafo.buscarArista(10,3));
        camino2.add(digrafo.buscarArista(10,11));
        camino2.add(digrafo.buscarArista(11,12));
        camino2.add(digrafo.buscarArista(12,13));
       
        
        camino3.add(digrafo.buscarArista(1,2));
        camino3.add(digrafo.buscarArista(2,3));
        camino3.add(digrafo.buscarArista(3,4));
        camino3.add(digrafo.buscarArista(4,5));
        camino3.add(digrafo.buscarArista(5,7));
        camino3.add(digrafo.buscarArista(7,8));
        camino3.add(digrafo.buscarArista(8,9));
        camino3.add(digrafo.buscarArista(9,10));
        camino3.add(digrafo.buscarArista(10,3));
        camino3.add(digrafo.buscarArista(10,11));
        camino3.add(digrafo.buscarArista(11,12));
        camino3.add(digrafo.buscarArista(12,14));
        camino3.add(digrafo.buscarArista(14,13));
       
        
        
        ArrayList<ArrayList<Arista>> caminosAristas = new ArrayList<>();
//        caminosAristas.add(camino1);
        caminosAristas.add(camino2);
          caminosAristas.add(camino3);
//        caminosAristas.add(camino4);
   
        return caminosAristas;
    }
    
    public void obtenerCaminos(){
        
    }

}
