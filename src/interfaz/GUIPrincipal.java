/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import GRAFO.Arista;
import GRAFO.AsignacionVertice;
import GRAFO.AsignadorValor;
import GRAFO.CondicionArista;
import GRAFO.Digrafo;
import GRAFO.Vertice;
import Problema.CasosPrueba.Algorimo1.EvaluadorCaminosAlgoritmo1;
import Problema.CasosPrueba.EvaluadorAlgoritmos;
import Problema.CasosPrueba.EvaluadorCaminos;
import interfaz.DraggableLabel;
import connector.ConnectorContainer;
import connector.JConnector;
import line.ConnectLine;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import umaslamdaee.Evaluador;
import umaslamdaee.Individuo;
import umaslamdaee.UMasLamdaEE;

/**
 *
 * @author acer_acer
 */
public class GUIPrincipal extends javax.swing.JFrame implements Serializable {

    ConnectorContainer panelConnectors;
    Point initialClick;
    JConnector[] connectors;
    int iterador;
    JLabel primerSeleccionado;
    JLabel segundoSeleccionado;
    ArrayList<JLabel> nodos;
    int itConnector;
    static GUIPrincipal gui;
    Digrafo<Integer> digrafo;

    public GUIPrincipal() {
        initComponents();
        chkArista.setSelected(false);
        chkVertice.setSelected(false);
        digrafo = new Digrafo<>();
        itConnector = 0;
        nodos = new ArrayList<>();
        iterador = 1;
        primerSeleccionado = null;
        segundoSeleccionado = null;
        connectors = new JConnector[50];
        panelConnectors = new ConnectorContainer(connectors);
        panelConnectors.setBackground(Color.white);
        panelConnectors.setSize(580, 590);
        panelConnectors.setLocation(10, 10);
        getContentPane().add(panelConnectors);
        this.setSize(850, 700);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnNuevoNodo = new javax.swing.JButton();
        btnCargarGrafo = new javax.swing.JButton();
        btnGuardarGrafo = new javax.swing.JButton();
        chkArista = new javax.swing.JCheckBox();
        chkVertice = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones grafo"));
        jPanel2.setLayout(null);

        btnNuevoNodo.setText("Nuevo nodo");
        btnNuevoNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoNodoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevoNodo);
        btnNuevoNodo.setBounds(40, 20, 120, 23);

        btnCargarGrafo.setText("Cargar grafo");
        btnCargarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarGrafoActionPerformed(evt);
            }
        });
        jPanel2.add(btnCargarGrafo);
        btnCargarGrafo.setBounds(40, 50, 120, 23);

        btnGuardarGrafo.setText("Guardar grafo");
        btnGuardarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGrafoActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarGrafo);
        btnGuardarGrafo.setBounds(40, 80, 120, 23);

        chkArista.setText("Arista con condicion");
        jPanel2.add(chkArista);
        chkArista.setBounds(30, 140, 140, 23);

        chkVertice.setText("Nodo con asignacion");
        jPanel2.add(chkVertice);
        chkVertice.setBounds(30, 110, 150, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(610, 10, 193, 180);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Calcular Resultados"));
        jPanel3.setLayout(null);

        jButton3.setText("Calcular Resultados");
        jPanel3.add(jButton3);
        jButton3.setBounds(37, 307, 127, 23);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(597, 180, 0, 0);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));
        jPanel1.setLayout(null);

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(59, 21, 71, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(12, 49, 166, 300);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(610, 210, 190, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnNuevoNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoNodoActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("C:\\Users\\acer_acer\\Documents\\NetBeansProjects\\pruebasGrafo\\src\\nodo.png");
        JLabel nuevo = new DraggableLabel(icon);
        nuevo.setSize(35, 36);
        nuevo.setLocation(1, 20);
        JLabel text = new JLabel("" + iterador);
        text.setSize(10, 10);
        text.setLocation(14, 14);
        nuevo.add(text);
        nuevo.setName("" + iterador);
        nuevo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                initialClick = evt.getPoint();
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    if (primerSeleccionado != null) {
                        JLabel lbl = (JLabel) evt.getComponent();
                        segundoSeleccionado = buscarNodo(lbl.getName());
                        llamarCondicion();
                        connectors[itConnector] = new JConnector(segundoSeleccionado, primerSeleccionado, ConnectLine.LINE_ARROW_SOURCE, JConnector.CONNECT_LINE_TYPE_SIMPLE, Color.red);
                        itConnector++;
                        primerSeleccionado = null;
                        segundoSeleccionado = null;
                        repaint();
                    } else {
                        JLabel lbl = (JLabel) evt.getComponent();
                        primerSeleccionado = buscarNodo(lbl.getName());
                    }

                }
            }

            private JLabel buscarNodo(String name) {
                for (int i = 0; i < nodos.size(); i++) {
                    if (nodos.get(i).getName().equals(name)) {
                        return nodos.get(i);
                    }
                }
                return null;
            }
        });
        nuevo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                int thisX = nuevo.getLocation().x;
                int thisY = nuevo.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = (thisX + evt.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + evt.getY()) - (thisY + initialClick.y);

                // Move picture to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;

                nuevo.setLocation(X, Y);
                nuevo.repaint();
            }
        });
        llamarVertice(iterador);
        iterador++;
        nodos.add(nuevo);
        panelConnectors.add(nuevo);
        repaint();
    }//GEN-LAST:event_btnNuevoNodoActionPerformed

    private void llamarVertice(int iterador) {
        if (chkVertice.isSelected()) {
            GUIVerticeAsignacion guiCond = new GUIVerticeAsignacion(this, true);
            guiCond.setVisible(rootPaneCheckingEnabled);
            if (guiCond.getTxtVariable().getText().equals("") || guiCond.getTxtOperacion().getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Informacion Incompleta", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                AsignacionVertice tmpCond = new AsignacionVertice(guiCond.getTxtVariable().getText(), guiCond.getTxtOperacion().getText());
                digrafo.insertarVerticeConAsignacion(iterador,tmpCond);
            }
        } else {
            digrafo.insertarVertice(iterador);
        }

    }

    private void llamarCondicion() {
        if (chkArista.isSelected()) {
            //Verificar si arista es recursiva y retornar origen y destino
            GUICondicion guiCond = new GUICondicion(this, true);
            guiCond.setVisible(rootPaneCheckingEnabled);
            if (guiCond.getTxtComparador().getText().equals("") || guiCond.getTxtOperacion().getText().equals("") || guiCond.getTxtValor().getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Informacion Incompleta", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                CondicionArista tmpCond = new CondicionArista(guiCond.getTxtComparador().getText(), guiCond.getTxtOperacion().getText(), Double.parseDouble(guiCond.getTxtValor().getText()));
                digrafo.insertarAristaCondicion(Integer.parseInt(primerSeleccionado.getName()), Integer.parseInt(segundoSeleccionado.getName()), tmpCond);
            }
        } else {
            digrafo.insertarArista(Integer.parseInt(primerSeleccionado.getName()), Integer.parseInt(segundoSeleccionado.getName()));
        }
    }
    private void btnCargarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarGrafoActionPerformed
        // TODO add your handling code here:        
        gui.setVisible(false);
        GUIPrincipal newGui = new GUIPrincipal();
        try (ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream("C:\\Users\\acer_acer\\Documents\\NetBeansProjects\\generacionPruebas\\src\\obj1.ser"))) {
            newGui = (GUIPrincipal) ois.readObject();
            newGui.setVisible(rootPaneCheckingEnabled);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Grafo cargado");
        repaint();
    }//GEN-LAST:event_btnCargarGrafoActionPerformed

    private void btnGuardarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGrafoActionPerformed
        // TODO add your handling code here:

        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream("C:\\Users\\acer_acer\\Documents\\NetBeansProjects\\generacionPruebas\\src\\obj1.ser"))) {
            oos.writeObject(gui);
            System.out.println("Se guardo el grafo");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarGrafoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ////////////////////////////////////////////////////////////
        /*BLOQUE DE PARAMETROS MODIFICABLES*/
        ///////////////////////////////////////////////////////////
        int lambda = 25;//Valor de lambda.
        int maximoIteraciones = 1000;//Maximo numero de itereciones para la convergencia del algoritmo.

        /*EVALUADORES*/
        EvaluadorCaminos evCaminos = new EvaluadorCaminosAlgoritmo1();
        ArrayList<ArrayList<Arista>> caminosAristas = encontrarCaminos();
//        for (ArrayList<Arista> caminosArista : caminosAristas) {
//            for (Arista arista : caminosArista) {
//                System.out.println("Vert A: " + arista.getVertA().getInfo() + " Vert B:" + arista.getVertB().getInfo());
//            }
//        }
        ArrayList<Object> entradas = new ArrayList();

        entradas.add("p");
        entradas.add("q");
        entradas.add(new AsignadorValor());

        HashMap<String, Double> variablesFlujo = new HashMap();

        Evaluador evaluador = new EvaluadorAlgoritmos(evCaminos, 4, entradas, caminosAristas, variablesFlujo);
        /*FIN EVALUADORES*/

        int dimensionGenes = caminosAristas.size() * 2;//Dimension del vector del individuo. #Caminos * 2 variables en este caso .
        float rangoMinimo = -100;// Rango maximo del numero a generar aleatoriamente para crear un individuo.
        float rangoMaximo = 100;//  Rango minimo del numero a generar aleatoriamente para crear un individuo.

        String objetivo = "+"; //Acepta 2 parametros : > "+" : Cuando el objetivo es maximizar , ordena de mayor a menor.
        //                      > "-" : Cuando el objetivo es minimizar , ordena de menor a mayor.
        //Atencion! :  si el parametro es diferente, toma por defecto "-".
        ////////////////////////////////////////////////////////////
        /*FIN BLOQUE DE PARAMETROS MODIFICABLES*/
        ///////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////
        /*BLOQUE NO MODIFICABLE*/
        ///////////////////////////////////////////////////////////
        UMasLamdaEE algoritmo = new UMasLamdaEE(lambda, maximoIteraciones, evaluador, dimensionGenes, rangoMinimo, rangoMaximo, objetivo);
        Individuo resultado = algoritmo.ejecutarAlgoritmo();
        System.out.println("Casos de prueba para Algoritmo: ");
        if (!algoritmo.isFalloAlgoritmo()) {
            System.out.println("El algoritmo convergió a lo siguiente:");

        } else {
            System.out.println("El algoritmo no logro converger luego de las iteraciones etablecidas, el mejor individuo fue: ");

        }

        for (Double xi : resultado.getGenotipo()) {

            System.out.printf("[%f]", Math.floor(xi));

        }
        System.out.printf("\nCon una evaluacion de: [%f]", resultado.getEvaluacion());
        System.out.println("");

        ////////////////////////////////////////////////////////////
        /*FIN BLOQUE NO MODIFICABLE*/
        ///////////////////////////////////////////////////////////
    }//GEN-LAST:event_jButton1ActionPerformed

    private ArrayList<ArrayList<Arista>> encontrarCaminos() {
        digrafo.hashAristas();
        digrafo.getCaminos(digrafo.buscarVertice(1), digrafo.buscarVertice(iterador-1));
        

        ArrayList<ArrayList<Vertice>> caminos = digrafo.getCaminos();
        ArrayList<ArrayList<Arista>> caminosAristas = new ArrayList<>();
        for (int i = 0; i < caminos.size(); i++) {
            ArrayList<Vertice> caminoTmp = caminos.get(i);
            ArrayList<Arista> caminoArTmp = new ArrayList<>();
            for (int j = 0; j < caminoTmp.size() - 1; j++) {
                caminoArTmp.add(digrafo.buscarArista(caminoTmp.get(j), caminoTmp.get(j + 1)));
            }
            caminosAristas.add(caminoArTmp);
        }
        return caminosAristas;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        gui = new GUIPrincipal();
        gui.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarGrafo;
    private javax.swing.JButton btnGuardarGrafo;
    private javax.swing.JButton btnNuevoNodo;
    private javax.swing.JCheckBox chkArista;
    private javax.swing.JCheckBox chkVertice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}