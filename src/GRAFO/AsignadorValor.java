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
    public double resolverValor(String valorResolver, ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {

        switch (valorResolver) {
            case "p+q":
                return resSumaPyQ(subVector, variablesSimples);
            case "number MOD 10":
                return resNumberMod10(subVector, variablesSimples);
            case "3*digit":
                return res3PorDigit(subVector, variablesSimples);
            case "pos MOD 2":
                return  resPosMod2(subVector, variablesSimples);
            case "sum+value":
                return resSumMasValue(subVector, variablesSimples);
            case "pos+1":
                return resPosMas1(subVector, variablesSimples);
            case "number/10":
                return resNumberDiv10(subVector, variablesSimples);
            case "sum MOD 11":
                return resSumMod11(subVector, variablesSimples);
            default:
                return Double.NEGATIVE_INFINITY;

        }

    }

    public double resSumaPyQ(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        int p = variablesSimples.get("p");
        int q = variablesSimples.get("q");
        return subVector.get(p) + subVector.get(q);
    }

    public double resPosMod2(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        int res = variablesSimples.get("res");
        return subVector.get(res) % 2;
    }

    public double resNumberMod10(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        int number = variablesSimples.get("number");
        return subVector.get(number) % 10;
    }

    public double res3PorDigit(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        return resNumberMod10(subVector, variablesSimples) * 3;
    }

    public double resSumMasValue(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        int sum = variablesSimples.get("sum");
        return subVector.get(sum) + res3PorDigit(subVector, variablesSimples);
    }

    public double resPosMas1(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        int pos = variablesSimples.get("pos");
        return subVector.get(pos) + 1;
    }

    public double resNumberDiv10(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples)
    {
        int number = variablesSimples.get("number");
        return subVector.get(number) / 10;
    }
    
    public double resSumMod11(ArrayList<Double> subVector, HashMap<String, Integer> variablesSimples) {
        int sum = variablesSimples.get("sum");
        return subVector.get(sum) % 11;
    }
    
    

}
