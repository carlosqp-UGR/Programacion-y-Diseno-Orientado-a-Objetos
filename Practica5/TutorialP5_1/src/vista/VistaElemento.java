/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


public class VistaElemento extends javax.swing.JPanel {

    /**
     * Creates new form VistaElemento
     */
    public VistaElemento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        num = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        num.setEditable(false);
        num.setText("jTextField2");
        num.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(num);
    }// </editor-fold>//GEN-END:initComponents

    public void recibeModelo(Integer i) {
        this.num.setText(i.toString());
        repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField num;
    // End of variables declaration//GEN-END:variables
}