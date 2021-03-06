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
import Problema.CasosPrueba.EvaluadorCaminos;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public class EvaluadorCaminosAlgoritmo2 extends EvaluadorCaminos {

    @Override
    public double probCobertura(double[] genotipo, ArrayList<Object> entradas, ArrayList<ArrayList<Arista>> caminos, HashMap<String, Double> varialesFlujo) {

        AsignadorValor asignador = new AsignadorValor();
        ValidadorCondicion validador = new ValidadorCondicion();

        
        HashMap<String, Integer> variablesSimples = new HashMap();
        
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
        
        for (int caminoi = 0; caminoi < caminos.size(); caminoi++) {
            
            ArrayList<ArrayList<Double>> valoresActuales = (ArrayList<ArrayList<Double>>) subVectores.clone();            
            ArrayList<Arista> caminoActual = caminos.get(caminoi);
            ArrayList<Double> subVectorActual = valoresActuales.get(caminoi);
            HashMap<String, Double> varialesFlujoActuales=(HashMap<String, Double>) varialesFlujo.clone();
            
            
            boolean bandera = verificarCubreCamino(caminoActual, subVectorActual, varialesFlujoActuales, variablesSimples, validador,asignador);           

            if (bandera) {
                caminosCubiertos++;
            }
        }
        double probabilidad = (double) caminosCubiertos / caminos.size();
        //System.out.println("Probabilidad"+ probabilidad);
        return probabilidad;
    }
    
    
    
    private boolean verificarCubreCamino(ArrayList<Arista> caminoActual,ArrayList<Double> subVectorActual,HashMap<String, Double> varialesFlujoActuales,HashMap<String, Integer> variablesSimples,ValidadorCondicion validador,AsignadorValor asignador)
    {
        HashMap<Arista,Integer> contadores= new HashMap();
        
        boolean bandera=true;
         for (int aristaActual = 0; aristaActual <caminoActual.size(); aristaActual++) {
            
                Arista arista= caminoActual.get(aristaActual);
                
                actualizarValoresSubVector(subVectorActual, arista, variablesSimples, varialesFlujoActuales);

                if (arista.getCondicion() != null) {
                    
                    String clave = arista.getCondicion().getValor();

                    if (variablesSimples.containsKey(clave)) {
                        if (!validador.validadorIf(subVectorActual.get(variablesSimples.get(clave)), arista.getCondicion().getCondicion(), arista.getCondicion().getValorComparar())) {
                            bandera = false;
                            break;
                        }

                    }
                    else {

                        if (!validador.validadorIf(asignador.resolverValor(clave, subVectorActual, variablesSimples, varialesFlujoActuales), arista.getCondicion().getCondicion(), arista.getCondicion().getValorComparar())) {
                            bandera = false;
                            break;
                        }
                    }
                    
                    if(arista.getCondicion().esFinCiclo())
                    {
                        if(bandera)
                        {
                            
                       
                           if(contadores.containsKey(arista))
                           {
                               if(contadores.get(arista)>=100)
                               {
                                   bandera=false;
                                   break;
                               }
                               
                               int incremento=contadores.get(arista);
                               incremento++;
                               contadores.put(arista, incremento);
                           }
                           else
                           {
                               contadores.put(arista,0);
                           }
                           
                           Arista aRegresar= arista.getCondicion().getOrigen();
                           int posRegresar=getPosArista(caminoActual, aRegresar);
                           
                           if(posRegresar!=-1)
                           {
                               aristaActual=posRegresar-1;
                           }
                           else
                           {
                               System.out.println("Raios, por aqui no deberia entrar. :'v");
                           }
                           
                        }
                        else
                        {
                            Arista aristaSalida= arista.getCondicion().getAristaSalida();
                            int posSalida=getPosArista(caminoActual, aristaSalida);
                            
                            if(posSalida!=-1)
                           {
                               aristaActual=posSalida-1;
                           }
                           else
                           {
                               System.out.println("Raios, por aqui no deberia entrar. :'v");
                           }
                        }
                    }
                    
                }
                //valoresActuales.set(caminoi, subVectorActual);
            }
         
         return bandera;
         
    }
    
    
    public int getPosArista(ArrayList<Arista> caminoActual,Arista aristaActual)
    {
        for (int i = 0; i < caminoActual.size(); i++) {
            Arista comparar = caminoActual.get(i);
            
            if (comparar.equals(aristaActual))
                return i;
        }
        
        return -1;
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
