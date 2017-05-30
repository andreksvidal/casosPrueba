/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problema.CasosPrueba.Algorimo1;

import GRAFO.Arista;
import GRAFO.AsignadorValor;
import GRAFO.ValidadorCondicion;
import GRAFO.Vertice;
import Problema.CasosPrueba.EvaluadorCaminos;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public class EvaluadorCaminosAlgoritmo1 extends EvaluadorCaminos {

    @Override
    public double probCobertura(double[] genotipo, ArrayList<Object> entradas, ArrayList<ArrayList<Arista>> caminos) {

        HashMap<String, Integer> variablesSimples = new HashMap();
        HashMap<String, AsignadorValor> condiciones = new HashMap();
        for (int i = 0; i < entradas.size(); i++) {
            String clase = entradas.get(i).getClass().getName();

            if (clase.equalsIgnoreCase("String")) {
                variablesSimples.put(clase, i);
            } else {
                AsignadorValor asignadorValor = (AsignadorValor) entradas.get(i);
                String valor = asignadorValor.getCondicion();
                condiciones.put(valor, asignadorValor);
            }

        }

        double caminosCubiertos = 0;
        ArrayList<ArrayList<Double>> subVectores = traerSubVectores(genotipo, entradas.size(), caminos);

        ValidadorCondicion validador = new ValidadorCondicion();
        for (int caminoi = 0; caminoi < caminos.size(); caminoi++) {
            ArrayList<Arista> caminoActual = caminos.get(caminoi);
            ArrayList<Double> subVectorActual = subVectores.get(caminoi);

            boolean bandera = true;

            for (Arista arista : caminoActual) {
                if (arista.getCondicion() != null) {
                    String clave = arista.getCondicion().getValor();

                    if (variablesSimples.containsKey(clave)) {
                        if (!validador.validadorIf(subVectorActual.get(variablesSimples.get(clave)), arista.getCondicion().getCondicion(), arista.getCondicion().getValorComparar())) {
                            bandera = false;
                            break;
                        }

                    } else {

                        if (validador.validadorIf(condiciones.get(arista.getCondicion().getValor()).resolverValor(subVectorActual, variablesSimples), arista.getCondicion().getCondicion(), arista.getCondicion().getValorComparar())) {
                            bandera = false;
                            break;
                        }
                    }
                }

            }

            if (bandera) {
                caminosCubiertos++;
            }
        }
        double probabilidad = (double) caminosCubiertos / caminos.size();
        return probabilidad;
    }

    private ArrayList<ArrayList<Double>> traerSubVectores(double[] genotipo, int size, ArrayList<ArrayList<Arista>> caminos) {

        ArrayList<ArrayList<Double>> genotipos = new ArrayList();
        for (int i = 0; i < genotipo.length; i++) {
            ArrayList<Double> tmp = new ArrayList<>();
            for (int j = 0; j < size - 1; j++) {
                tmp.add(genotipo[i + j]);
            }
            genotipos.add(tmp);
        }

        for (int i = 0; i < caminos.size(); i++) {
            ArrayList<Arista> caminoTmp = caminos.get(i);
            for (int j = 0; j < caminoTmp.size(); j++) {

            }
        }
        return genotipos;
    }

}
