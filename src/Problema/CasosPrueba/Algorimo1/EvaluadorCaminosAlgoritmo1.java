/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problema.CasosPrueba.Algorimo1;

import GRAFO.Arista;
import GRAFO.AsignacionVertice;
import GRAFO.AsignadorValor;
import GRAFO.ValidadorCondicion;
import GRAFO.Vertice;
import Problema.CasosPrueba.EvaluadorCaminos;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public class EvaluadorCaminosAlgoritmo1 extends EvaluadorCaminos {

    @Override
    public double probCobertura(double[] genotipo, ArrayList<Object> entradas, ArrayList<ArrayList<Arista>> caminos, HashMap<String, Double> varialesFlujo) {

        HashMap<String, Integer> variablesSimples = new HashMap();
        AsignadorValor asignador = new AsignadorValor();
        for (int i = 0; i < entradas.size(); i++) {
            String clase = entradas.get(i).getClass().getName();

            if (clase.equalsIgnoreCase("java.lang.String")) {
                variablesSimples.put((String) entradas.get(i), i);
            } else {
                asignador = (AsignadorValor) entradas.get(i);
            }

        }

        double caminosCubiertos = 0;
        ArrayList<ArrayList<Double>> subVectores = traerSubVectores(genotipo, variablesSimples.size());
        ArrayList<ArrayList<Double>> valoresActuales = (ArrayList<ArrayList<Double>>) subVectores.clone();

        ValidadorCondicion validador = new ValidadorCondicion();

        for (int caminoi = 0; caminoi < caminos.size(); caminoi++) {
            ArrayList<Arista> caminoActual = caminos.get(caminoi);
            ArrayList<Double> subVectorActual = valoresActuales.get(caminoi);
            boolean bandera = true;

            for (Arista arista : caminoActual) {

                actualizarValoresSubVector(subVectorActual, arista, variablesSimples, varialesFlujo);

                if (arista.getCondicion() != null) {
                    String clave = arista.getCondicion().getValor();

                    if (variablesSimples.containsKey(clave)) {
                        if (!validador.validadorIf(subVectorActual.get(variablesSimples.get(clave)), arista.getCondicion().getCondicion(), arista.getCondicion().getValorComparar())) {
                            bandera = false;
                            break;
                        }

                    }
                    
                    if (variablesSimples.containsKey(clave)) {
                        if (!validador.validadorIf(subVectorActual.get(variablesSimples.get(clave)), arista.getCondicion().getCondicion(), arista.getCondicion().getValorComparar())) {
                            bandera = false;
                            break;
                        }

                    }else {

                        if (!validador.validadorIf(asignador.resolverValor(clave, subVectorActual, variablesSimples, varialesFlujo), arista.getCondicion().getCondicion(), arista.getCondicion().getValorComparar())) {
                            bandera = false;
                            break;
                        }
                    }
                }
                valoresActuales.set(caminoi, subVectorActual);
            }

            if (bandera) {
                caminosCubiertos++;
            }
        }
        double probabilidad = (double) caminosCubiertos / caminos.size();
        return probabilidad;
    }

    private ArrayList<ArrayList<Double>> traerSubVectores(double[] genotipo, int numSimples) {

        ArrayList<ArrayList<Double>> genotipos = new ArrayList();
        int numeroCasos = genotipo.length / numSimples;

        int subVectori = 0;
        while (subVectori < genotipo.length) {
            ArrayList<Double> subVector = new ArrayList();

            for (int posi = 0; posi < numSimples; posi++) {
                subVector.add(genotipo[subVectori + posi]);
            }
            genotipos.add(subVector);
            subVectori += numSimples;
        }
        return genotipos;
    }

    private void actualizarValoresSubVector(ArrayList<Double> subVectorActual, Arista arista, HashMap<String, Integer> variablesSimples, HashMap<String, Double> variablesFlujo) {

        AsignadorValor asignador = new AsignadorValor();
        AsignacionVertice asignacion = arista.getVertA().getAsignacion();
        if (asignacion != null) {
            String variable = asignacion.getVariable();
            if (variablesSimples.containsKey(variable)) {
                String valorResolver = asignacion.getValorResolver();

                if (variablesFlujo.containsKey(valorResolver)) {
                    subVectorActual.set(variablesSimples.get(variable), variablesFlujo.get(valorResolver));
                } else {
                    double valorResuelto = asignador.resolverValor(valorResolver, subVectorActual, variablesSimples, variablesFlujo);
                    if (variablesSimples.containsKey(variable)) {
                        subVectorActual.set(variablesSimples.get(variable), valorResuelto);
                    } else if (variablesFlujo.containsKey(variable)) {
                        variablesFlujo.put(variable, valorResuelto);
                    }
                }

            } else if (variablesFlujo.containsKey(variable)) {
                String valorResolver = asignacion.getValorResolver();

                if (variablesFlujo.containsKey(valorResolver)) {
                    variablesFlujo.put(variable, variablesFlujo.get(valorResolver));
                } else {
                    double valorResuelto = asignador.resolverValor(valorResolver, subVectorActual, variablesSimples, variablesFlujo);
                    if (variablesSimples.containsKey(variable)) {
                        subVectorActual.set(variablesSimples.get(variable), valorResuelto);
                    } else if (variablesFlujo.containsKey(variable)) {
                        variablesFlujo.put(variable, valorResuelto);
                    }

                }

            }

        }
    }

}
