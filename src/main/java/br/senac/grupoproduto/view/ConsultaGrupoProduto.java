/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.grupoproduto.view;

import br.senac.produto.model.GrupoProduto;
import br.senac.produto.model.GrupoProdutoDAO;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class ConsultaGrupoProduto extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaGrupoProduto
     */
     
    CadastroGrupoProduto cadGrup = new CadastroGrupoProduto();
    public ConsultaGrupoProduto() {
        initComponents();
        buscarTB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPasswordField1 = new javax.swing.JPasswordField();
        lblID = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        bntNovoCad = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProd = new javax.swing.JTable();
        fieldNome = new javax.swing.JTextField();
        fieldTipProd = new javax.swing.JTextField();
        fieldID = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        bntNovoCad.setText("Novo");
        bntNovoCad.setFocusable(false);
        bntNovoCad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntNovoCad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntNovoCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNovoCadActionPerformed(evt);
            }
        });
        jToolBar1.add(bntNovoCad);

        btnAlterar.setText("Alterar");
        btnAlterar.setFocusable(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAlterar);

        btnExcluir.setText("Excluir");
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tabelaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CodigoProduto", "Descrição", "Tipo Produto"
            }
        ));
        jScrollPane1.setViewportView(tabelaProd);

        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });

        fieldTipProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTipProdActionPerformed(evt);
            }
        });

        lblNome.setText("Descrição");

        jLabel2.setText("Tipo Prod");

        jLabel3.setText("ID");

        javax.swing.GroupLayout lblIDLayout = new javax.swing.GroupLayout(lblID);
        lblID.setLayout(lblIDLayout);
        lblIDLayout.setHorizontalGroup(
            lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lblIDLayout.createSequentialGroup()
                .addGroup(lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(lblIDLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(fieldTipProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addComponent(fieldNome, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(310, Short.MAX_VALUE))
            .addGroup(lblIDLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        lblIDLayout.setVerticalGroup(
            lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblIDLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(lblIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldTipProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
        );

        getContentPane().add(lblID, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldTipProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTipProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTipProdActionPerformed
    private GrupoProdutoDAO grupProdDAO = new GrupoProdutoDAO();// variavel
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Integer indexRow = tabelaProd.getSelectedRow();
       if(indexRow == -1)
           JOptionPane.showMessageDialog(this, "Selecione uma registro da tabela","Anteção",JOptionPane.WARNING_MESSAGE);
       else{
            try {
                Integer idGrupPord = (Integer)tabelaProd.getModel().getValueAt(indexRow, 0);
                int pergunta = JOptionPane.showConfirmDialog(this, "Confirma Exclusão","Exclusão!!!",JOptionPane.YES_OPTION);
                if (pergunta == JOptionPane.YES_OPTION)
                    grupProdDAO = new GrupoProdutoDAO();
                grupProdDAO.excluir(idGrupPord);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaGrupoProduto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex, "Erro na exclusão", JOptionPane.WARNING_MESSAGE);
            }
        }
           buscarTB();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       Integer indexRow = tabelaProd.getSelectedRow();
       if(indexRow == -1)
           JOptionPane.showMessageDialog(this, "Selecione uma registro da tabela","Anteção",JOptionPane.WARNING_MESSAGE);
       else{
           try {
               Integer idGrupPord = (Integer)tabelaProd.getModel().getValueAt(indexRow, 0);
               cadGrup.setVisible(true);
               cadGrup.editar(idGrupPord);
               buscarTB();
           } catch (SQLException ex) {
               Logger.getLogger(ConsultaGrupoProduto.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(this, ex, "Erro na alteração", JOptionPane.WARNING_MESSAGE);
           }
       }
        buscarTB();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void bntNovoCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNovoCadActionPerformed
        
        cadGrup.setVisible(true);
         buscarTB();// metodo do TableModel
         
    }//GEN-LAST:event_bntNovoCadActionPerformed

    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
            buscarTB();
    }//GEN-LAST:event_btnBuscarActionPerformed

   
    
    
    public void buscarTB(){
        try {
            DefaultTableModel model = (DefaultTableModel) tabelaProd.getModel();
            model.setRowCount(0);
            for(GrupoProduto grupProd: grupProdDAO.listartoPorNome(txtField.getText())) {
                Object[] row = new Object[3];
                row[0] = grupProd.getIdGrupoProduto();
                row[1] = grupProd.getNomeGrupoProduto();
                row[2] = grupProd.getTipoProduto();
                model.addRow(row);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaGrupoProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
                    
        }
    }
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
            java.util.logging.Logger.getLogger(ConsultaGrupoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaGrupoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaGrupoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaGrupoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultaGrupoProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNovoCad;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JTextField fieldID;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldTipProd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tabelaProd;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables
    
    
    
    
  
     
    }

