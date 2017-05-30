package Problema.CasosPrueba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import GRAFO.Arista;
import Problema.CasosPrueba.EvaluadorCaminos;
import java.util.ArrayList;
import umaslamdaee.Evaluador;
import umaslamdaee.Individuo;

/**
 * 
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public class EvaluadorAlgoritmos extends Evaluador{

    
    private final EvaluadorCaminos evaluadorCaminos;
    private final int cantcasosPrueba;
    private ArrayList<Object> entradas;
    private ArrayList<ArrayList<Arista>> caminos;
    
    public EvaluadorAlgoritmos(EvaluadorCaminos evaluadorCaminos, int cantcasosPrueba,ArrayList<Object> entradas,ArrayList<ArrayList<Arista>> caminos) {
        this.evaluadorCaminos = evaluadorCaminos;
        this.cantcasosPrueba = cantcasosPrueba;
        this.entradas=entradas;
        this.caminos=caminos;
    }
    
   
       
    @Override
    public void evaluar(ArrayList<Individuo> poblacion) {
         
        for (Individuo individuo : poblacion) {
            double evaluacion= evaluadorCaminos.probCobertura(individuo.getGenotipo() , entradas,caminos);
            individuo.setEvaluacion(evaluacion);
        }
    }
    
    
    

}
