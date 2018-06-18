/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pedidovenda.view;

import static br.senac.componentes.db.UtilSQL.fmtData;
import br.senac.pedidovenda.model.FormaPagamento;
import br.senac.pedidovenda.model.PedidoVenda;
import br.senac.pedidovenda.model.PedidoVendaDAO;
import br.senac.pedidovenda.model.TipoPedidoVenda;
import com.mysql.jdbc.log.Log;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class MenuPedidoVenda extends javax.swing.JFrame {

    boolean config;
    private PedidoVenda pVenda = new PedidoVenda();
    private PedidoVendaDAO pVendaDAO = new PedidoVendaDAO();
    private Integer integerCod = null;
    private Long idPVenda = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public MenuPedidoVenda() {
        initComponents();
        config = true;
        editarBotoesInterface(config);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldIdCliente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JToggleButton();
        btnInserir = new javax.swing.JToggleButton();
        btnExcluir = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        fieldIdPedido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxFormaPagamento = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        radBtnOrcamento = new javax.swing.JRadioButton();
        radBtnVendas = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldValorFrete = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        checkBoxTelemarkting = new javax.swing.JCheckBox();
        checkBoxFretGratis = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaObs = new javax.swing.JTextArea();
        btnGravar = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        fieldDataPedido = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id Pedido");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Id Cliente");

        fieldIdPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdPedidoActionPerformed(evt);
            }
        });

        jLabel3.setText("Data Pedido");

        jLabel4.setText("Forma de Pagamento");

        comboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha uma opção", "Dinheiro", "Cartão Crédito", "Cartao Débtio", "Cheque" }));
        comboBoxFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFormaPagamentoActionPerformed(evt);
            }
        });

        radBtnOrcamento.setText("Orçamento");
        radBtnOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnOrcamentoActionPerformed(evt);
            }
        });

        radBtnVendas.setText("Venda");
        radBtnVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnVendasActionPerformed(evt);
            }
        });

        jLabel5.setText("Opções");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(radBtnOrcamento)
                .addGap(6, 6, 6)
                .addComponent(radBtnVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radBtnOrcamento)
                    .addComponent(radBtnVendas)
                    .addComponent(jLabel5))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel6.setText("Valor do Frente");

        checkBoxTelemarkting.setText("Telemarkting");
        checkBoxTelemarkting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxTelemarktingActionPerformed(evt);
            }
        });

        checkBoxFretGratis.setText("Frete Grátis");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(checkBoxTelemarkting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(checkBoxFretGratis)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxTelemarkting)
                    .addComponent(checkBoxFretGratis))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel7.setText("Observações:");

        textAreaObs.setColumns(20);
        textAreaObs.setRows(5);
        jScrollPane1.setViewportView(textAreaObs);

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fieldIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(fieldDataPedido, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldIdCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                                    .addComponent(comboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldValorFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscar)
                    .addComponent(btnInserir)
                    .addComponent(btnExcluir)
                    .addComponent(fieldIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fieldIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(fieldDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(fieldValorFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGravar))))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void fieldIdPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdPedidoActionPerformed

    private void comboBoxFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFormaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxFormaPagamentoActionPerformed

    private void radBtnOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnOrcamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radBtnOrcamentoActionPerformed

    private void radBtnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnVendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radBtnVendasActionPerformed

    private void checkBoxTelemarktingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxTelemarktingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxTelemarktingActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        config = !config;
        editarBotoesInterface(config);
        try {
            inserir();
        } catch (ParseException ex) {
            Logger.getLogger(MenuPedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    
        try {
            buscar();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        config = !config;
        editarBotoesInterface(config);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            gravar();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void editarBotoesInterface(boolean config) {
        fieldIdPedido.setEnabled(config);
        btnGravar.setVisible(!config);
        if (!config) {//Limpar
            btnBuscar.setText("Limpar");
            fieldIdCliente.requestFocus();
            //limpar();

        } else {
            btnBuscar.setText("Buscar");
            fieldIdPedido.requestFocus();
        }

    }

    private void limpar() {
        fieldIdPedido.setText("");
        fieldIdCliente.setText("");
        comboBoxFormaPagamento.setSelectedItem(null);
        radBtnOrcamento.setSelected(false);
        radBtnVendas.setSelected(false);
        fieldValorFrete.setText("");
        checkBoxTelemarkting.setSelected(false);
        checkBoxFretGratis.setSelected(false);

    }

    private void inserir() throws ParseException, SQLException {
        if (!fieldIdCliente.getText().equals("")) {
            pVenda.setIdPessoa(Long.parseLong(fieldIdCliente.getText()));
        }
        if (!fieldDataPedido.getText().equals("")) {

            Date date = dateFormat.parse(fieldDataPedido.getText());
        }
        if (comboBoxFormaPagamento.getSelectedItem().equals("DINHEIRO")) {
            pVenda.setFormaPagamento(FormaPagamento.DINHEIRO);
        } else if (comboBoxFormaPagamento.getSelectedItem().equals("CARTAO_CREDITO")) {
            pVenda.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
        } else if (comboBoxFormaPagamento.getSelectedItem().equals("CARTAO_DEBITO")) {
            pVenda.setFormaPagamento(FormaPagamento.CARTAO_DEBITO);
        } else if (comboBoxFormaPagamento.getSelectedItem().equals("CHEQUE")) {
            pVenda.setFormaPagamento(FormaPagamento.CHEQUE);
        }

        if (radBtnOrcamento.isSelected()) {
            pVenda.setTipoPedidoVenda(TipoPedidoVenda.ORCAMENTO);
        } else if (radBtnVendas.isSelected()) {
            pVenda.setTipoPedidoVenda(TipoPedidoVenda.PEDIDO);

        }

        if (!fieldValorFrete.getText().equals("")) {
            pVenda.setFreteGratis(false);
            pVenda.setVlFrete(Double.parseDouble(fieldValorFrete.getText()));
        }

        if (checkBoxTelemarkting.isSelected()) {
            pVenda.setTelemarketing(true);

        } else if (checkBoxFretGratis.isSelected()) {
            pVenda.setFreteGratis(true);

        }
        if (!textAreaObs.getText().equals("")) {
            pVenda.setObservacoes(textAreaObs.getText());
        }
        
        pVendaDAO.inserir(pVenda);
        JOptionPane.showMessageDialog(this,
                    "O novo id do novo produt é: ", "Atenção", JOptionPane.WARNING_MESSAGE);

    }

    private boolean validar() {
        if (fieldIdCliente.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Digite um id de pedido", "Atenção", JOptionPane.WARNING_MESSAGE);
            fieldIdCliente.requestFocus();
            return false;
        }
        if (fieldDataPedido.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Campo de data vazio", "Atenção", JOptionPane.WARNING_MESSAGE);
            fieldDataPedido.requestFocus();
            return false;
        }
        if (comboBoxFormaPagamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Selecione uma forma de pagamento", "Atenção", JOptionPane.WARNING_MESSAGE);
            comboBoxFormaPagamento.requestFocus();
            return false;
        }
        if (radBtnOrcamento.isSelected() == false && radBtnVendas.isSelected() == false) {
            JOptionPane.showMessageDialog(this,
                    "Selecione uma opção de vendas", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;

        } else if (fieldValorFrete.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Digite o valor do frete", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (checkBoxTelemarkting.isSelected() == false && checkBoxFretGratis.isSelected()== false) {
            JOptionPane.showMessageDialog(this,
                    "Escolha uma opção Telemarkint ou Frete Gratis", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    private void gravar() throws SQLException {
        if (!validar()) {
            return;
        }

        if (!fieldIdPedido.getText().equals("")) {
            integerCod = new Integer(Integer.parseInt(fieldIdPedido.getText()));
        }
        if (pVenda == null) {
            pVenda = new PedidoVenda();
        }
        try {
            inserir();
        } catch (ParseException ex) {
            Logger.getLogger(MenuPedidoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Inserção com sucesso!");
    }

    private void excluir() throws SQLException {
        idPVenda = new Long(fieldIdCliente.getText());
        if (idPVenda.equals(pVendaDAO.getPorId(idPVenda))) {
            pVendaDAO.excluir(idPVenda);
        }

    }
/**
    private PedidoVenda buscarPedidoVenda() throws SQLException {
       idPVenda = new Long(Long.parseLong(fieldIdCliente.getText()));
        if (pVenda == null) {
            pVenda = new PedidoVenda();

            return pVendaDAO.getPorId(idPVenda);
        }
        JOptionPane.showMessageDialog(this,
                " PedidoVenda não encontrado", "Erro inesperado", JOptionPane.WARNING_MESSAGE);
        return null;
    }
**/
    private void buscar() throws SQLException {
        System.out.println("o:"+fieldIdPedido.getText());
        idPVenda = (Long.parseLong(fieldIdPedido.getText()));
        
        pVenda =(pVendaDAO.getPorId(idPVenda));
      
        if (pVenda != null) {
            fieldIdPedido.setText(pVenda.getIdPedido().toString());
            fieldIdCliente.setText(pVenda.getIdPessoa().toString());
            fieldDataPedido.setText(dateFormat.format(pVenda.getDtPedido()));
            comboBoxFormaPagamento.setSelectedIndex(pVenda.getFormaPagamento().getId());
            if(pVenda.getTipoPedidoVenda().getId().equals(2)){
                radBtnOrcamento.setSelected(true);
    
            }else{
                radBtnVendas.setSelected(true);
            }
            fieldValorFrete.setText(pVenda.getVlFrete().toString());
            if(pVenda.getFreteGratis() == true){
                checkBoxFretGratis.setSelected(true);
            }else{
                checkBoxTelemarkting.setSelected(true);     
            }
            textAreaObs.setText(pVenda.getObservacoes());

        }
    }

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
            java.util.logging.Logger.getLogger(MenuPedidoVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPedidoVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPedidoVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPedidoVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPedidoVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBuscar;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JToggleButton btnGravar;
    private javax.swing.JToggleButton btnInserir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox checkBoxFretGratis;
    private javax.swing.JCheckBox checkBoxTelemarkting;
    private javax.swing.JComboBox<String> comboBoxFormaPagamento;
    private javax.swing.JFormattedTextField fieldDataPedido;
    private javax.swing.JTextField fieldIdCliente;
    private javax.swing.JTextField fieldIdPedido;
    private javax.swing.JTextField fieldValorFrete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JRadioButton radBtnOrcamento;
    private javax.swing.JRadioButton radBtnVendas;
    private javax.swing.JTextArea textAreaObs;
    // End of variables declaration//GEN-END:variables

}
