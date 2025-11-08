package questao4;

import java.util.ArrayList;
import java.util.List;

public class ContextoValidacao {
    
    private int falhasConsecutivas;
    private final int limiteCircuitBreaker = 3;
    private List<Validador> validadoresExecutados;
    
    public ContextoValidacao() {
        this.falhasConsecutivas = 0;
        this.validadoresExecutados = new ArrayList<>();
    }
    
    public void incrementarFalhas() {
        falhasConsecutivas++;
        if (falhasConsecutivas >= limiteCircuitBreaker) {
            System.out.println("\n[CIRCUIT BREAKER] Ativado apos " + falhasConsecutivas + " falhas");
        }
    }
    
    public boolean isCircuitBreakerAtivado() {
        return falhasConsecutivas >= limiteCircuitBreaker;
    }
    
    public int getFalhasConsecutivas() {
        return falhasConsecutivas;
    }
    
    public void adicionarValidadorExecutado(Validador validador) {
        validadoresExecutados.add(validador);
    }
    
    public List<Validador> getValidadoresExecutados() {
        return validadoresExecutados;
    }
    
    public void executarRollback(DocumentoFiscal documento) {
        if (!validadoresExecutados.isEmpty()) {
            System.out.println("\n[ROLLBACK] Iniciando rollback dos validadores executados...");
            for (int i = validadoresExecutados.size() - 1; i >= 0; i--) {
                validadoresExecutados.get(i).rollback(documento);
            }
        }
    }
}
