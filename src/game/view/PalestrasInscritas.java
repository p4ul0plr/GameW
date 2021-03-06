/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view;

import game.entity.Evento;
import game.util.HibernateUtil;
import javax.swing.table.DefaultTableModel;
import game.view.Formulario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author UNIVASF
 */
public class PalestrasInscritas extends javax.swing.JDialog {

    /**
     * Creates new form PalestrasInscritas
     */
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
    public PalestrasInscritas(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(Evento.class);
        ArrayList<Evento> eventoA = (ArrayList<Evento>) c.list();
        session.getTransaction().commit();
        
        DefaultTableModel tabelaDePalestas = (DefaultTableModel) tblPalestrasDoUsuario.getModel();
        Object[] eventoV = new Object[tabelaDePalestas.getColumnCount()];
        for (int i = 0; i < eventoA.size(); i++) {
            eventoV[0] = eventoA.get(i).getNome();
            eventoV[1] = eventoA.get(i).getHorario();
            eventoV[2] = eventoA.get(i).getDataEvent();
            eventoV[3] = eventoA.get(i).getSala();
            eventoV[4] = eventoA.get(i).getPalestrante();
            eventoV[5] = eventoA.get(i).getTipo();
            tabelaDePalestas.addRow(eventoV);
        }
        //JOptionPane.showMessageDialog(null, "CPF: "+getCpf());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPalestrasDoUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscrições");

        tblPalestrasDoUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblPalestrasDoUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Evento", "Horário", "Data", "Número da Sala", "Palestrante", "Tipo de palestra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPalestrasDoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPalestrasDoUsuario.setRowHeight(25);
        jScrollPane1.setViewportView(tblPalestrasDoUsuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PalestrasInscritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PalestrasInscritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PalestrasInscritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PalestrasInscritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PalestrasInscritas dialog = new PalestrasInscritas(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPalestrasDoUsuario;
    // End of variables declaration//GEN-END:variables
}
