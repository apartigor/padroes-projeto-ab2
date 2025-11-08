package questao4;

public class CadeiaValidacao {
    
    private Validador primeiroValidador;
    
    public CadeiaValidacao() {
        construirCadeia();
    }
    
    private void construirCadeia() {
        Validador validador1 = new ValidadorSchemaXML(1000);
        Validador validador2 = new ValidadorCertificadoDigital(1000);
        Validador validador3 = new ValidadorRegrasFiscais(2000);
        Validador validador4 = new ValidadorBancoDados(1500);
        Validador validador5 = new ValidadorServicoSEFAZ(3000);
        
        validador1.setProximo(validador2);
        validador2.setProximo(validador3);
        validador3.setProximo(validador4);
        validador4.setProximo(validador5);
        
        primeiroValidador = validador1;
    }
    
    public boolean validarDocumento(DocumentoFiscal documento) {
        System.out.println("\n========================================");
        System.out.println("Iniciando validacao da NFe: " + documento.getNumeroNFe());
        System.out.println("========================================");
        
        ContextoValidacao contexto = new ContextoValidacao();
        ResultadoValidacao resultado = primeiroValidador.validar(documento, contexto);
        
        System.out.println("\n========================================");
        System.out.println("Resultado Final:");
        System.out.println(resultado);
        System.out.println("Total de falhas: " + contexto.getFalhasConsecutivas());
        
        if (!resultado.isSucesso() || contexto.isCircuitBreakerAtivado()) {
            contexto.executarRollback(documento);
            System.out.println("Status: REJEITADO");
            return false;
        }
        
        System.out.println("Status: APROVADO");
        return true;
    }
}
