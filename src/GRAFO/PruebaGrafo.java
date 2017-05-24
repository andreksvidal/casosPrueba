/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFO;

/**
 *
 * @author Andrés Vidal.Universidad del Cauca - Ingeniería de Sistemas. 2017
 */
public class PruebaGrafo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Digrafo<Integer> digrafo= new Digrafo<>();
        
        digrafo.insertarVertice(0);
        digrafo.insertarVertice(1);
        digrafo.insertarVertice(2);
        digrafo.insertarVertice(3);
        digrafo.insertarVertice(4);
        digrafo.insertarVertice(5);
        digrafo.insertarVertice(6);
        digrafo.insertarVertice(7);
        digrafo.insertarVertice(8);
        digrafo.insertarVertice(9);
        digrafo.insertarVertice(10);
       
        
        digrafo.insertarArista(1,2);
        digrafo.insertarArista(2,3);
        digrafo.insertarArista(2,4);
        digrafo.insertarArista(4,5);
        digrafo.insertarArista(3,6);
        digrafo.insertarArista(5,6);
        digrafo.insertarArista(6,7);
        digrafo.insertarArista(6,8);
        digrafo.insertarArista(8,9);
        digrafo.insertarArista(9,10);
        digrafo.insertarArista(7,10);
        
        
        
       // System.out.println(digrafo.getAristas().getTamanio());
        
        System.out.println("Lista de Adyacencia:");
       ListaCD [] lista= digrafo.getListaAdyacencia();
       
        for (ListaCD listaCD : lista) {
            System.out.println(listaCD);
        }
      
        
        
        
        
        
        
        
    }
    
}