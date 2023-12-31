/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;

import controladorCivitas.Respuesta;

import civitas.CivitasJuego;
import javax.swing.JOptionPane;

/**
 *
 * @author carlosqp
 */
public class CivitasView extends javax.swing.JFrame implements Vista{

    private CivitasJuego juego = null;
    
    /**
     * Creates new form CivitasView
     */
    public CivitasView() {
        initComponents();
        this.panelRanking.setVisible(false);
    }
    
    public void setCivitasJuego(CivitasJuego juego) {
        this.juego = juego;
        this.setVisible(true);
    }

    @Override
    public void actualiza() {
        this.jugadorPanel.setJugador(this.juego.getJugadorActual());
        
        String infoCasillaActual = this.juego.getTablero().getCasilla(this.juego.getJugadorActual().getCasillaActual()).toString();
        this.casillaActual.setText(infoCasillaActual);
        
        this.mostrarSiguienteOperacion(this.juego.siguientePaso());
           
        //this.labelRanking.setVisible(false);
        //this.ranking.setVisible(false);
        
        if(this.juego.finalDelJuego()) {

             //Si el juego ha finalizado, crear el ranking y mostrarlo (PONER CAMPOS VISIBLES)
            String result = "";
            int i = 1;
            for (civitas.Jugador j: this.juego.ranking()) {
                result += Integer.toString(i) + "- " + j.ToString() + "\n";
                i++;
            }
            
            this.ranking.setText(result); 
//            this.labelRanking.setVisible(true);
//            this.ranking.setVisible(true);
            this.panelRanking.setVisible(true);
        }

        this.repaint();
        this.revalidate();
    }

    @Override
    public void pausa() {
        int val= JOptionPane.showConfirmDialog(null, "¿Continuar?", "Siguiente paso", JOptionPane.YES_NO_OPTION);
        if (val==1) System.exit(0);    
    }

    @Override
    public Respuesta comprar() {
        int opcion= 1-JOptionPane.showConfirmDialog(null, "¿Quieres comprar la calle actual?",
                "Compra", JOptionPane.YES_NO_OPTION); 
        return Respuesta.values()[opcion];
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        GestionarDialog gestion = new GestionarDialog(this);
        return OperacionInmobiliaria.values()[gestion.getGestionElegida()];
    }

    @Override
    public int elegirPropiedad() {
        PropiedadDialog propiedad = new PropiedadDialog (this, this.juego.getJugadorActual());
        return propiedad.getPropiedadElegida();
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operacion) {
        // Actualice el textfield de la siguiente operación con la operación que recibe como argumento
        this.siguienteOperacion.setText(operacion.toString());
        
        // Si la operación actual del juego es AVANZAR, se mostrará la vista 
        // (singleton) del dado (llamando al método createInstance de Dado).
        if(operacion ==OperacionJuego.AVANZAR) {
            GUI.Dado.createInstance(this);
        }
            
        // Al final hay que actualizar todos los componentes de la ventana principal (repaint).
        this.repaint();
        this.revalidate();
    }

    @Override
    public void mostrarEventos() {
        //if (!civitas.Diario.getInstance().getEventos().isEmpty())
            DiarioDialog diarioD= new DiarioDialog(this); //crea la ventana del diario
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jugadorPanel = new GUI.JugadorPanel();
        casillaPanel = new javax.swing.JPanel();
        labelCasillaActual = new javax.swing.JLabel();
        siguienteOperacionPanel = new javax.swing.JPanel();
        labelSiguienteOperacion = new javax.swing.JLabel();
        siguienteOperacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        casillaActual = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelRanking = new javax.swing.JPanel();
        labelRanking = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ranking = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        titulo.setText("Juego Civitas");

        labelCasillaActual.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelCasillaActual.setText("Casilla Actual:");

        labelSiguienteOperacion.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelSiguienteOperacion.setText("Siguiente Operación:");

        siguienteOperacion.setEditable(false);

        javax.swing.GroupLayout siguienteOperacionPanelLayout = new javax.swing.GroupLayout(siguienteOperacionPanel);
        siguienteOperacionPanel.setLayout(siguienteOperacionPanelLayout);
        siguienteOperacionPanelLayout.setHorizontalGroup(
            siguienteOperacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siguienteOperacionPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelSiguienteOperacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siguienteOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(438, Short.MAX_VALUE))
        );
        siguienteOperacionPanelLayout.setVerticalGroup(
            siguienteOperacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siguienteOperacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(siguienteOperacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(siguienteOperacionPanelLayout.createSequentialGroup()
                        .addComponent(labelSiguienteOperacion)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addComponent(siguienteOperacion)))
        );

        casillaActual.setEditable(false);
        casillaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaActualActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(casillaActual);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout casillaPanelLayout = new javax.swing.GroupLayout(casillaPanel);
        casillaPanel.setLayout(casillaPanelLayout);
        casillaPanelLayout.setHorizontalGroup(
            casillaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, casillaPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(siguienteOperacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(casillaPanelLayout.createSequentialGroup()
                .addGroup(casillaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(casillaPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelCasillaActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(casillaPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        casillaPanelLayout.setVerticalGroup(
            casillaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(casillaPanelLayout.createSequentialGroup()
                .addGroup(casillaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCasillaActual)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siguienteOperacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane5.setViewportView(jScrollPane3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        labelRanking.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelRanking.setText("Ranking:");

        ranking.setEditable(false);
        ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingActionPerformed(evt);
            }
        });
        jScrollPane2.setViewportView(ranking);

        javax.swing.GroupLayout panelRankingLayout = new javax.swing.GroupLayout(panelRanking);
        panelRanking.setLayout(panelRankingLayout);
        panelRankingLayout.setHorizontalGroup(
            panelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRankingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRanking)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE))
        );
        panelRankingLayout.setVerticalGroup(
            panelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRankingLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRanking))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugadorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(casillaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(casillaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(355, 355, 355))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(332, 332, 332))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rankingActionPerformed

    private void casillaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaActualActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(CivitasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CivitasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CivitasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CivitasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CivitasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField casillaActual;
    private javax.swing.JPanel casillaPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private GUI.JugadorPanel jugadorPanel;
    private javax.swing.JLabel labelCasillaActual;
    private javax.swing.JLabel labelRanking;
    private javax.swing.JLabel labelSiguienteOperacion;
    private javax.swing.JPanel panelRanking;
    private javax.swing.JTextField ranking;
    private javax.swing.JTextField siguienteOperacion;
    private javax.swing.JPanel siguienteOperacionPanel;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
