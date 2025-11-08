package questao4;

public class ValidadorRegrasFiscais extends Validador {
    
    public ValidadorRegrasFiscais(int timeoutMs) {
        super(timeoutMs);
    }
    
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal documento, ContextoValidacao contexto) {
        System.out.println("\n[3] Validando Regras Fiscais...");
        
        double impostoEsperado = documento.getValorTotal() * 0.18;
        documento.setImpostoCalculado(impostoEsperado);
        
        if (documento.getValorTotal() <= 0) {
            return new ResultadoValidacao(false, "Valor total invalido", getNome());
        }
        
        if (impostoEsperado < 0) {
            return new ResultadoValidacao(false, "Calculo de imposto incorreto", getNome());
        }
        
        contexto.adicionarValidadorExecutado(this);
        return new ResultadoValidacao(true, "Regras fiscais OK - Imposto calculado: R$ " + 
                                      String.format("%.2f", impostoEsperado), getNome());
    }
    
    @Override
    protected String getNome() {
        return "ValidadorRegrasFiscais";
    }
    
    @Override
    public void rollback(DocumentoFiscal documento) {
        System.out.println("  [ROLLBACK] " + getNome() + " - Revertendo calculo de impostos");
        documento.setImpostoCalculado(0.0);
    }
    
    @Override
    protected boolean deveInterromperCadeia() {
        return false;
    }
}
