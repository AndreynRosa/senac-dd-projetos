package br.senac.pedidovenda.model;

public enum FormaPagamento {
    
    DINHEIRO(1), CARTAO_CREDITO(2), CARTAO_DEBITO(3), CHEQUE(4);
    
    private Integer id = null;
            
    private FormaPagamento(Integer id){
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    public static FormaPagamento getPorId(Integer id){
        if(id != null && id <= 4){
            switch(id){
                case 1:
                    return DINHEIRO;
                case 2:
                    return CARTAO_CREDITO;
                case 3:
                    return CARTAO_DEBITO;
                case 4:
                    return CHEQUE;
            }
        }
        return null;
    }    
    
}