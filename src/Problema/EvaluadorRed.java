/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problema;

import java.util.ArrayList;
import umaslamdaee.Evaluador;
import umaslamdaee.Individuo;

/**
 *
 * @author Andres Vidal Zemanate /* FIET-Ingenieria de Sistemas
 */
public class EvaluadorRed extends Evaluador {

    private ArrayList<int[]> patrones;

    public EvaluadorRed() {
        super();
        patrones = new ArrayList();

        int patrona[] = {0, 0, 0, 0};
        int patronb[] = {0, 0, 1, 0};
        int patronc[] = {0, 1, 0, 0};
        int patrond[] = {0, 1, 1, 0};
        int patrone[] = {1, 0, 0, 0};
        int patronf[] = {1, 0, 1, 0};
        int patrong[] = {1, 1, 0, 0};
        int patronh[] = {1, 1, 1, 1};
        patrones.add(patrona);
        patrones.add(patronb);
        patrones.add(patronc);
        patrones.add(patrond);
        patrones.add(patrone);
        patrones.add(patronf);
        patrones.add(patrong);
        patrones.add(patronh);
    }

    @Override
    public void evaluar(ArrayList<Individuo> poblacion) {
        System.out.println("******************");
        for (int i = 0; i < poblacion.size(); i++) { //para cada individuo de la poblacion hacer:

            //OBTENER EL INDIVIUO i: 
            Individuo individuo = poblacion.get(i);

            double sumatoriaErrores = obtenerErrores(individuo.getGenotipo());
            
            System.out.println("Suma errores patron + ["+i+"] => ["+sumatoriaErrores+"]" );
            
            //Se calcula el fitness para este indiviuo:
            
            double fitness= (sumatoriaErrores*sumatoriaErrores)/patrones.size();
            System.out.println("Fitness [" +i+"]  :  [ "+  fitness+"]");
            System.out.println("******************");   
            individuo.setEvaluacion(fitness);
        }
        System.out.println("");
        
    }

    public double sigmoidal(Double x) {
        Double denominador = 1 + Math.pow(Math.E, (-1 * x));
        return 1 / denominador;

    }

    private double obtenerErrores(double[] genotipo) {
        
        ArrayList<Double> ErroresxPatron= new ArrayList();
        
        //para cada patron a aplicar en el individuo:
        for (int i = 0; i < patrones.size(); i++) {
            //sacar la suma WiXi
            
            double WiXi =  obtenerSumaWiXi(genotipo,patrones.get(i)); 
            //Aplicar funcion sigmoidal
            double sigmoide= sigmoidal(WiXi);
            //SALIDA ESPERADA:Ubicada en la ultima casilla del vector del patron de entrenamiento.
            double SalidaEsperada= patrones.get(i)[patrones.get(i).length-1];
            
            //Error en este patron:
            double Ei =   SalidaEsperada - sigmoide;
            ErroresxPatron.add(Ei);
        }
        
        double sumaErrores=0;
        
        for (int i = 0; i < ErroresxPatron.size(); i++) {
            
            sumaErrores= sumaErrores + ErroresxPatron.get(i);
            
        }
        
        return sumaErrores;
        
    }

    private double obtenerSumaWiXi(double[] genotipoIndividuo, int[] patron) {
        double suma=0;
        
        for (int i = 0; i < genotipoIndividuo.length; i++) {
            suma= suma+ (genotipoIndividuo[i]*patron[i]);
        }
        
        return suma;
           
    }

}
