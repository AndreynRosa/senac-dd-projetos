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

    private JTextField txtNome;
    private JTextField txtCodigo;
    private JRadioButton btnServ;
    private JRadioButton btnMerc;
    private JRadioButton btnMateria;
    
    private GrupoProduto grupProd;

    public static void main(String[] args) {

        CadastroGrupoProduto cadGrupProd = new CadastroGrupoProduto();
        cadGrupProd.editar(1);
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

    public void editar(Integer id) {
        GrupoProdutoDAO grupProdDAO = new GrupoProdutoDAO();
        grupProd = grupProdDAO.getGrupoProdutoPorId(id);

        txtNome.setText(grupProd.getNomeGrupoProduto());
        txtCodigo.setText(id.toString());

        if (grupProd.getTipoProduto() == TipoProduto.SERVICO) {
            btnServ.setSelected(true);
        } else if (grupProd.getTipoProduto() == TipoProduto.MERCADORIA) {
            btnMerc.setSelected(true);
        }
    }

    public void gravar() {
        
        if(grupProd == null){
            grupProd = new GrupoProduto();
        }
        
        if(txtNome.getText().trim().equals("")){
            //JOptionPane ERROR
            txtNome.requestFocus();
            return;
        }
            
        //Validar se foi informado valor no nome
        
        //validar se existe algum radio button selecionado
        
        //fazer a pergunta para o usuário - confirmação JOptionPane
        

        //DataBinding
        
        if (btnServ.isSelected() == true) {
            grupProd.setTipoProduto(TipoProduto.SERVICO);
        }else if(btnMerc.isSelected() == true) {
            grupProd.setTipoProduto(TipoProduto.MERCADORIA);
        }    
        
        if(txtCodigo.getText().equals("")){ //inclusão
            
        }else { //alteração
            
        }
    }

}
