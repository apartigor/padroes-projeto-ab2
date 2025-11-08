package questao4;

import java.util.HashSet;
import java.util.Set;

public class ValidadorBancoDados extends Validador {
    
    private static Set<String> bancoDados = new HashSet<>();
    
    public ValidadorBancoDados(int timeoutMs) {
        super(timeoutMs);
    }
    
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal documento, ContextoValidacao contexto) {
        System.out.println("\n[4] Validando Banco de Dados...");
        
        if (bancoDados.contains(documento.getNumeroNFe())) {
            return new ResultadoValidacao(false, "NFe duplicada - ja existe no banco", getNome());
        }
        
        bancoDados.add(documento.getNumeroNFe());
        documento.setInseridoBancoDados(true);
        
        contexto.adicionarValidadorExecutado(this);
        return new ResultadoValidacao(true, "NFe inserida no banco com sucesso", getNome());
    }
    
    @Override
    protected String getNome() {
        return "ValidadorBancoDados";
    }
    
    @Override
    public void rollback(DocumentoFiscal documento) {
        if (documento.isInseridoBancoDados()) {
            System.out.println("  [ROLLBACK] " + getNome() + " - Removendo NFe do banco");
            bancoDados.remove(documento.getNumeroNFe());
            documento.setInseridoBancoDados(false);
        }
    }
}
