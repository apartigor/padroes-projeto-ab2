package questao4;

public class ValidadorServicoSEFAZ extends Validador {
    
    public ValidadorServicoSEFAZ(int timeoutMs) {
        super(timeoutMs);
    }
    
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal documento, ContextoValidacao contexto) {
        System.out.println("\n[5] Validando Servico SEFAZ...");
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            return new ResultadoValidacao(false, "Erro ao consultar SEFAZ", getNome());
        }
        
        if (documento.getNumeroNFe().contains("INVALIDO")) {
            return new ResultadoValidacao(false, "NFe rejeitada pela SEFAZ", getNome());
        }
        
        contexto.adicionarValidadorExecutado(this);
        return new ResultadoValidacao(true, "NFe autorizada pela SEFAZ", getNome());
    }
    
    @Override
    protected String getNome() {
        return "ValidadorServicoSEFAZ";
    }
}
