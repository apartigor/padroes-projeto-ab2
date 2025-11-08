package questao3;

public class EstadoManutencao implements EstadoUsina {
    
    private EstadoUsina estadoAnterior;
    
    public EstadoManutencao(EstadoUsina estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }
    
    @Override
    public void verificarCondicoes(ContextoUsina contexto) {
        System.out.println("  [Verificacao] MODO MANUTENCAO ATIVO");
        System.out.println("  " + contexto);
        System.out.println("  Info: Alertas automaticos suspensos");
        System.out.println("  Info: Estado anterior: " + estadoAnterior.getNomeEstado());
        System.out.println("  Info: Verificacoes de seguranca em modo manual");
    }
    
    @Override
    public String getNomeEstado() {
        return "MANUTENCAO";
    }
    
    @Override
    public String getDescricao() {
        return "Modo manutencao - Controles manuais ativos";
    }
    
    public EstadoUsina getEstadoAnterior() {
        return estadoAnterior;
    }
}
