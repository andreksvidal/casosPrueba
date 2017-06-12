/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author acer_acer
 */
public class AsignadorValor {

    //220570
    public double resolverValor(String valorResolver, ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples , HashMap<String, Double> variablesFlujo) {

        switch (valorResolver) {
            case "p+q":
                return resSumaPyQ(subVector, variablesSimples);
            case "number MOD 10":
                return resNumberMod10(subVector, variablesSimples);
            case "3*digit":
                return res3PorDigit(subVector, variablesFlujo);
            case "pos MOD 2":
                return  resPosMod2(subVector, variablesFlujo);
            case "sum+value":
                return resSumMasValue(subVector, variablesSimples,variablesFlujo);
            case "pos+1":
                return resPosMas1(subVector, variablesFlujo);
            case "number/10":
                return resNumberDiv10(subVector, variablesSimples);
            case "sum MOD 11":
                return resSumMod11(subVector, variablesFlujo);
            case "1":
                return 1.0;
            default:
                return Double.NEGATIVE_INFINITY;

        }

    }

    public double resSumaPyQ(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        int p = variablesSimples.get("p");
        int q = variablesSimples.get("q");
        return subVector.get(p) + subVector.get(q);
    }

    public double resPosMod2(ArrayList<Double> subVector, HashMap<String, Double> variablesFlujo) {
        double posMod2 = variablesFlujo.get("pos")%2;
        return posMod2;
    }

    public double resNumberMod10(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        int number = variablesSimples.get("number");
        return subVector.get(number) % 10;
    }

    public double res3PorDigit(ArrayList<Double> subVector, HashMap<String, Double> variablesFlujo) {
        double digit= variablesFlujo.get("digit");
        return 3*digit;
    }

    public double resSumMasValue(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples, HashMap<String, Double>variablesFlujo) {
        double sum = variablesFlujo.get("sum");
        double value= variablesFlujo.get("value");
        return sum + value;
    }

    public double resPosMas1(ArrayList<Double> subVector, HashMap<String, Double> variablesFlujo) {
        double pos = variablesFlujo.get("pos");
        return pos +1;
    }

    public double resNumberDiv10(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples)
    {
        int number = variablesSimples.get("number");
        return subVector.get(number) / 10;
    }
    
    public double resSumMod11(ArrayList<Double> subVector, HashMap<String, Double> variablesFlujo) {
        double sum = variablesFlujo.get("sum");
        return sum % 11;
    }
    
    

}
