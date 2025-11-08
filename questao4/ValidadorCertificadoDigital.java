package questao4;

public class ValidadorCertificadoDigital extends Validador {
    
    public ValidadorCertificadoDigital(int timeoutMs) {
        super(timeoutMs);
    }
    
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal documento, ContextoValidacao contexto) {
        System.out.println("\n[2] Validando Certificado Digital...");
        
        if (documento.getCertificadoDigital() == null) {
            return new ResultadoValidacao(false, "Certificado digital ausente", getNome());
        }
        
        if (documento.getCertificadoDigital().contains("EXPIRADO")) {
            return new ResultadoValidacao(false, "Certificado digital expirado", getNome());
        }
        
        if (documento.getCertificadoDigital().contains("REVOGADO")) {
            return new ResultadoValidacao(false, "Certificado digital revogado", getNome());
        }
        
        contexto.adicionarValidadorExecutado(this);
        return new ResultadoValidacao(true, "Certificado digital valido", getNome());
    }
    
    @Override
    protected String getNome() {
        return "ValidadorCertificadoDigital";
    }
    
    @Override
    protected boolean deveInterromperCadeia() {
        return false;
    }
}
