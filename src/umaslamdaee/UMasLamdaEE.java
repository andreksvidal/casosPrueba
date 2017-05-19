/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umaslamdaee;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ingesis
 */
public class UMasLamdaEE {

    /*PARAMETROS DEL ALGORITMO*/
    private int lambda;
    private int limiteIteraciones;
    private int iteracionesActuales = 0;
    private ArrayList<Individuo> poblacion;
    private GeneradorPoblacion generadorP;
    ArrayList<Individuo> yaSeleccionados;
    private boolean falloAlgoritmo;
    private Evaluador evaludador;
    private int dimensionGenes;
    private  float rangoMinimo;
    private float rangoMaximo;
    private String objetivo;
    
    /*FIN PARAMETROS ALGORITMO*/

    
    
    public UMasLamdaEE( int lambda, int limiteIteraciones, Evaluador evaludador, int  DimensionGenes, float rangoMinimo , float rangoMaximo, String objetivo) {
        this.lambda = lambda;
        this.limiteIteraciones = limiteIteraciones;
       
        this.evaludador = evaludador;
        this.dimensionGenes=DimensionGenes;
        this.rangoMaximo=rangoMaximo;
        this.rangoMinimo=rangoMinimo;
        this.objetivo=objetivo;
    }

    public boolean isFalloAlgoritmo() {
        return falloAlgoritmo;
    }

    
    
    
    public Individuo ejecutarAlgoritmo() {
        this.generadorP = new GeneradorPoblacion(this.rangoMinimo,this.rangoMaximo);
        poblacion = generadorP.generarPoblacion(this.dimensionGenes);
        evaluarPoblacion(poblacion);
        OrdenarPoblacion();
        while (!convergeAlgoritmo()) {
            //float numAciertos=0;
            evaluarPoblacion(this.poblacion);
            OrdenarPoblacion();

            ArrayList<Integer> yaSeleccionados = new ArrayList();
            ArrayList<Individuo> listaHijos = new ArrayList();

            for (int i = 0; i < lambda; i++) {

                Pareja padres = seleccionarPadres(yaSeleccionados);
                Individuo hijo = generarCruce(padres);// SobreCruzamiento
                Individuo hijoMutado = mutarIndividuo(hijo);
                listaHijos.add(hijoMutado);
              
            }

            /**/
            for (int i = 0; i < listaHijos.size(); i++) {
                this.poblacion.add(listaHijos.get(i));
            }
            /*Prefiero hacerlo asi para facilitar la verificacion de errores en el proceso*/

            yaSeleccionados = new ArrayList<>();//Limpio la lista de padres seleccionados.

            evaluarPoblacion(listaHijos); //Solo necesito evaluar los nuevos hijos. 
            OrdenarPoblacion();//ordeno de acuerdo al fitness en forma decreciente.
            eliminarLambdaMalos();
            this.iteracionesActuales++;
        }

      
            return this.poblacion.get(0);
        

 

    }

    private boolean convergeAlgoritmo() {
        if (this.iteracionesActuales > this.limiteIteraciones) {
            this.falloAlgoritmo = false;
            return true;
        } else {
            Individuo mejorActual = this.poblacion.get(0);
            if (mejorActual.getEvaluacion() == 0) {
                return true;
            }
        }
        return false;
    }

    private void evaluarPoblacion(ArrayList<Individuo> poblacionEvaluar) {
        evaludador.evaluar(poblacionEvaluar);

    }

    private void OrdenarPoblacion() {
        Ordenamiento ordenador = new Ordenamiento();
        //ordenamiento por insercion en orden decreciente:
        if(this.objetivo.equalsIgnoreCase("+"))
            ordenador.insercionDirecta(poblacion, "descendente");
        else
            ordenador.insercionDirecta(poblacion, "ascendente");
    }

    private Pareja seleccionarPadres(ArrayList<Integer> Yaseleccionados) {
        int indicePadre = (int) (Math.random()*99);
       
        int indiceMadre = (int) (Math.random()*99);
      
        while(indicePadre==indiceMadre)
        {
             indiceMadre = (int) (Math.random()*99);
         
        }
        
        
        
        Individuo padre = this.poblacion.get(indicePadre);
        Individuo madre = this.poblacion.get(indiceMadre);
        return new Pareja(padre, madre);
    }

    private Individuo generarCruce(Pareja padres) {
        Individuo nuevoIndividuo = new Individuo();
        int longitud = padres.getPadre().getGenotipo().length;
        double[] resCruce = new double[longitud];
        for (int i = 0; i < longitud; i++) {
            resCruce[i] = (padres.getPadre().getGenotipo()[i] + padres.getMadre().getGenotipo()[i]) / 2;

        }
        nuevoIndividuo.setGenotipo(resCruce);
        double varianzas [] = new double [this.dimensionGenes];
        
        for (int i = 0; i < varianzas.length; i++) {
           varianzas[i]=(padres.getPadre().getVarianzas()[i] + padres.getMadre().getVarianzas()[i]) / 2;
            
        }
        nuevoIndividuo.setVarianzas(varianzas);
        return nuevoIndividuo;

    }

    private Individuo mutarIndividuo(Individuo hijo) {
       
        double alfa=0.6;
        Random r = new Random();
        for (int i = 0; i < hijo.getVarianzas().length; i++) {
            double sigmaip=hijo.getVarianzas()[i] * (1 + (alfa* r.nextGaussian()));
            hijo.getVarianzas()[i]=sigmaip;
            double xip=hijo.getGenotipo()[i] + (sigmaip* r.nextGaussian());
            
            hijo.getGenotipo()[i]=xip;
            
        }
        return hijo;
    }

    private void eliminarLambdaMalos() {
        for (int i = 0; i < lambda; i++) {
            int ultimo = poblacion.size() - 1;
            poblacion.remove(ultimo);
        }

    }

}
