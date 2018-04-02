/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.grupoproduto.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Aluno
 */
public class CadastroGrupoProduto extends JDialog {

    public static void main(String[] args) {

        CadastroGrupoProduto cadGrupProd = new CadastroGrupoProduto();
        cadGrupProd.setVisible(true);
    }

    public CadastroGrupoProduto() {
        setTitle("Cadastro Grupo Produto");
        setSize(600, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JButton btnGravar = new JButton("Salvar");//botão de baixo
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
        JTextField txtCodigo = new JTextField();
        
        JLabel lblNome = new JLabel("Nome");//nome
        JTextField txtNome = new JTextField();
        
        JLabel lblTipo = new JLabel("Tipo");//tipo
        JRadioButton btnServ = new JRadioButton("Serviço");
        JRadioButton btnMerc = new JRadioButton("Mercadoria");
        JRadioButton btnMateria = new JRadioButton("MateriaPrima");
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
    }
}
