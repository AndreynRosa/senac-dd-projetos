/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.grupoproduto.view;

import br.senac.produto.model.GrupoProduto;
import br.senac.produto.model.GrupoProdutoDAO;
import br.senac.produto.model.TipoProduto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Aluno
 */
public class CadastroGrupoProduto extends JDialog {

    private JTextField txtNome;
    private JTextField txtCodigo;
    private JRadioButton btnServ;
    private JRadioButton btnMerc;
    private JRadioButton btnMateria;
    private GrupoProduto grupProd;
    private GrupoProdutoDAO grupProdDAO = new GrupoProdutoDAO();
    private Integer integerCod = null;
    public static void main(String[] args) {

        CadastroGrupoProduto cadGrupProd = new CadastroGrupoProduto();
        cadGrupProd.setVisible(true);

    }

    public CadastroGrupoProduto() {
        setTitle("Cadastro Grupo Produto");
        setSize(600, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        
        JButton btnGravar = new JButton("Gravar");//botão de baixo
        btnGravar.setSize(new Dimension(80, 30));
        btnGravar.setLocation(360, 40);

        setLayout(new BorderLayout());//footer
        JPanel pnBtns = new JPanel();
        add(pnBtns, BorderLayout.SOUTH);
        pnBtns.setPreferredSize(new Dimension(120, 100));
        pnBtns.setLayout(null);
        pnBtns.add(btnGravar);

        JPanel centerPn = new JPanel();//cneter
        centerPn.setPreferredSize(new Dimension(50, 30));
        centerPn.setLayout(new GridLayout(3, 2));

        JLabel lblCodigo = new JLabel("Codigo");//codigo
        txtCodigo = new JTextField();

        JLabel lblNome = new JLabel("Nome");//nome
        txtNome = new JTextField();

        JLabel lblTipo = new JLabel("Tipo");//tipo
        btnServ = new JRadioButton("Serviço");
        btnMerc = new JRadioButton("Mercadoria");
        btnMateria = new JRadioButton("MateriaPrima");
        ButtonGroup opt = new ButtonGroup();
        opt.add(btnServ);
        opt.add(btnMerc);
        opt.add(btnMateria);
        JPanel opt1 = new JPanel();
        opt1.add(btnServ);
        opt1.add(btnMerc);
        opt1.add(btnMateria);

        centerPn.add(lblCodigo);
        centerPn.add(txtCodigo);
        centerPn.add(lblNome);
        centerPn.add(txtNome);
        centerPn.add(lblTipo);
        centerPn.add(opt1);

        add(centerPn, BorderLayout.CENTER);

        btnGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });
    }

    public void editar(Integer id) throws SQLException {
        GrupoProdutoDAO grupProdDAO = new GrupoProdutoDAO();
        grupProd = grupProdDAO.getPorId(id);

        txtNome.setText(grupProd.getNomeGrupoProduto());
        txtCodigo.setText(id.toString());

        if (grupProd.getTipoProduto() == TipoProduto.SERVICO) {
            btnServ.setSelected(true);
        } else if (grupProd.getTipoProduto() == TipoProduto.MERCADORIA) {
            btnMerc.setSelected(true);
        } else if (grupProd.getTipoProduto() == TipoProduto.MATERIA_PRIMA) {
            btnMateria.setSelected(true);
        }
    }

    public void gravar() {
        if (validar() == false) {
            return;
        }
        if (!txtCodigo.getText().equals("")) {
            integerCod = new Integer(txtCodigo.getText());

        }
        if (grupProd == null) {
            grupProd = new GrupoProduto();
        }

        int resp = JOptionPane.showConfirmDialog(this, "Deseja continuar?", "Escolha um opção", JOptionPane.OK_OPTION);
        if (resp != JOptionPane.OK_OPTION) {
            return;
        }
        dataBinding();
    }

    public void dataBinding() {
        
        if (btnServ.isSelected()) {
            grupProd.setTipoProduto(TipoProduto.SERVICO);
        } else if (btnMerc.isSelected()) {
            grupProd.setTipoProduto(TipoProduto.MERCADORIA);
        } else if (btnMateria.isSelected()) {
            grupProd.setTipoProduto(TipoProduto.MATERIA_PRIMA);
        }
        grupProd.setNomeGrupoProduto(txtNome.getText());
        grupProd.setIdGrupoProduto(integerCod);

        try {
            if (txtCodigo.getText().equals("")) {
                Integer novoId = 0;
                novoId = grupProdDAO.inserir(grupProd);
                JOptionPane.showMessageDialog(this, "O produto " + grupProd.getNomeGrupoProduto() + "com id " + novoId);

            } else {

                grupProdDAO.alterar(grupProd);
                JOptionPane.showMessageDialog(this, "Alterado com sucesso");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e, "ERRO INESPERADO", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean validar() {

        if (txtNome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Digite nome do produto", "Atenção", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocus();
            return false;

        }

        if (btnMateria.isSelected() == false && btnMerc.isSelected() == false
                && btnServ.isSelected() == false) {

            JOptionPane.showMessageDialog(this, "Selecione um Tipo de produto", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
