/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFO;

/**
 *
 * @author Andres Vidal - FIET - Ingeniería de Sistemas . 2017
 */
public class ValidadorCondicion {

    public boolean validadorIf(double valor,String operador, double valorComparar) {
        switch (operador) {
            case "==":
                return valor == valorComparar;
            case ">":
                return valor > valorComparar;
            case "<":
                return valor < valorComparar;
            case ">=":
                return valor >= valorComparar;
            case "<=":
                return valor <= valorComparar;
            case "!=":
                return valor != valorComparar;
            default:
                return false;                   
        }        
    }

}
