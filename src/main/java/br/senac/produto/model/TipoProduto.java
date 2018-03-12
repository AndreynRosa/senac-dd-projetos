
package br.senac.produto.model;

public enum TipoProduto {
    MERCADORIA(1),SERVICO(2), MATERIA_PRIMA(3);
    private Integer id;

    private TipoProduto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
  }

