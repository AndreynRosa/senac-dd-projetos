package br.senac.pedidovenda.model;

public enum TipoPedidoVenda {
    
    PEDIDO(1), ORCAMENTO(2);
    
    private Integer id;
            
    private TipoPedidoVenda(Integer id){
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    public static TipoPedidoVenda getPorId(Integer id){
        if(id != null){
            switch(id){
                case 1:
                    return PEDIDO;
                case 2:
                    return ORCAMENTO;
            }
        }
        return null;
    }
}