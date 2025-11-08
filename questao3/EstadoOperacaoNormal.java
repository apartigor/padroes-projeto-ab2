package questao3;

public class EstadoOperacaoNormal implements EstadoUsina {
    
    @Override
    public void verificarCondicoes(ContextoUsina contexto) {
        System.out.println("  [Verificacao] Monitorando condicoes normais...");
        System.out.println("  " + contexto);
        
        if (contexto.getTemperatura() > 300.0) {
            System.out.println("  ATENCAO: Temperatura excedeu 300 graus C!");
            System.out.println("  Transicao necessaria para ALERTA_AMARELO");
        } else {
            System.out.println("  Todos os parametros dentro da normalidade");
        }
    }
    
    @Override
    public String getNomeEstado() {
        return "OPERACAO_NORMAL";
    }
    
    @Override
    public String getDescricao() {
        return "Usina operando normalmente";
    }
}
