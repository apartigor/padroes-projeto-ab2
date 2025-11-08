package questao4;

public abstract class Validador {
    
    protected Validador proximoValidador;
    protected int timeoutMs;
    
    public Validador(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }
    
    public void setProximo(Validador proximo) {
        this.proximoValidador = proximo;
    }
    
    public ResultadoValidacao validar(DocumentoFiscal documento, ContextoValidacao contexto) {
        
        if (contexto.isCircuitBreakerAtivado()) {
            return new ResultadoValidacao(false, "Circuit breaker ativado - validacao interrompida", getNome());
        }
        
        long inicio = System.currentTimeMillis();
        ResultadoValidacao resultado = executarValidacao(documento, contexto);
        long tempoDecorrido = System.currentTimeMillis() - inicio;
        
        if (tempoDecorrido > timeoutMs) {
            System.out.println("  AVISO: Timeout excedido (" + tempoDecorrido + "ms > " + timeoutMs + "ms)");
        }
        
        if (!resultado.isSucesso()) {
            contexto.incrementarFalhas();
            onFalha(documento, contexto);
        }
        
        if (proximoValidador != null && (resultado.isSucesso() || !deveInterromperCadeia())) {
            if (contexto.isCircuitBreakerAtivado()) {
                return resultado;
            }
            ResultadoValidacao resultadoProximo = proximoValidador.validar(documento, contexto);
            if (!resultadoProximo.isSucesso()) {
                return resultadoProximo;
            }
        }
        
        return resultado;
    }
    
    protected abstract ResultadoValidacao executarValidacao(DocumentoFiscal documento, ContextoValidacao contexto);
    
    protected abstract String getNome();
    
    protected boolean deveInterromperCadeia() {
        return true;
    }
    
    protected void onFalha(DocumentoFiscal documento, ContextoValidacao contexto) {
    }
    
    public void rollback(DocumentoFiscal documento) {
    }
}
