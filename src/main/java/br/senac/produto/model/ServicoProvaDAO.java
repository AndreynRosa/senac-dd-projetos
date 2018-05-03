/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.produto.model;

import br.senac.grupoproduto.model.BaseDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class ServicoProvaDAO implements BaseDAO<ServicoProva, Long>{
    
    private static ArrayList<ServicoProva> listaServico = new ArrayList<>();
    
    public ServicoProvaDAO() { //construtor
        if (listaServico.size() > 0) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GrupoProdutoDAO dao = new GrupoProdutoDAO();
        try {
            //MOCK: Objetos para testes - crie o construtor no GrupoProduto
            listaServico.add(new ServicoProva(1L, "Revisão", TipoProduto.SERVICO,
                    sdf.parse("10/10/2002"), 1.5F, dao.getPorId(3), 2.4F));
            listaServico.add(new ServicoProva(2L, "Corte Cabelo", TipoProduto.SERVICO,
                    sdf.parse("10/10/2015"), 1.5F, dao.getPorId(2), 2.4F));
            listaServico.add(new ServicoProva(3L, "Segurança Patrimonial", TipoProduto.SERVICO,
                    sdf.parse("01/03/1998"), 5.5F, dao.getPorId(7), 2.4F));
            listaServico.add(new ServicoProva(4L, "Curso EAD Sistemas", TipoProduto.SERVICO,
                    sdf.parse("10/10/2002"), 1.5F, dao.getPorId(8), 2.4F));
            listaServico.add(new ServicoProva(5L, "Curso EAD Redes", TipoProduto.SERVICO,
                    sdf.parse("10/10/2002"), 1.5F, dao.getPorId(8), 2.4F));
        } catch (ParseException ex) {
            throw new RuntimeException("Erro ServicoDAO", ex);
        }
    }

    @Override
    public boolean excluir(Long id) {
        if(listaServico.remove(new ServicoProva(id)) == false)
            throw new RuntimeException("Serviço não encontrado: "+ id);
        else 
			return true;
    }

    @Override
    public ServicoProva getPorId(Long id) {
        int index = listaServico.indexOf(new ServicoProva(id));
        if(index != -1)
            return listaServico.get(index);
        else
            throw new RuntimeException("Serviço não encontrado: "+ id);
    }

    @Override
    public Long inserir(ServicoProva servico) {
        if(servico == null){
            throw new RuntimeException("Produto inválido!");
        } else if(servico.getNomeProduto() == null || 
                servico.getNomeProduto().equals("")){
            throw new RuntimeException("Nome do produto inválido!");
        }
        
        long maiorId = 0L;
        for(ServicoProva servID : listaServico){
            if(servID.getIdProduto() > maiorId){
                maiorId = servID.getIdServico();
            }
        }
        maiorId = maiorId + 1;
        servico.setIdServico(maiorId);
        listaServico.add(servico);
        return maiorId;
    }

    @Override
    public boolean alterar(ServicoProva servico) {
        int index = listaServico.indexOf(servico);
        if(index != -1)
            listaServico.set(index, servico);
        else
            throw new RuntimeException("Serviço não encontrado: "+ servico.getIdProduto() + " " + servico.getNomeProduto());
        
        return true;
        
    }
    
    public List<ServicoProva> listarTodos(){
        return listaServico;
    }

}