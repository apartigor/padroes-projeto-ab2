package questao4;

public class ValidadorSchemaXML extends Validador {
    
    public ValidadorSchemaXML(int timeoutMs) {
        super(timeoutMs);
    }
    
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal documento, ContextoValidacao contexto) {
        System.out.println("\n[1] Validando Schema XML...");
        
        if (documento.getXmlConteudo() == null || documento.getXmlConteudo().isEmpty()) {
            return new ResultadoValidacao(false, "XML vazio ou invalido", getNome());
        }
        
        if (!documento.getXmlConteudo().contains("<NFe>")) {
            return new ResultadoValidacao(false, "Schema XML nao conforme com XSD", getNome());
        }
        
        contexto.adicionarValidadorExecutado(this);
        return new ResultadoValidacao(true, "Schema XML valido", getNome());
    }
    
    @Override
    protected String getNome() {
        return "ValidadorSchemaXML";
    }
    
    @Override
    protected boolean deveInterromperCadeia() {
        return false;
    }
}
