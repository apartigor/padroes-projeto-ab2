package questao3;

public class EstadoAlertaVermelho implements EstadoUsina {
    
    @Override
    public void verificarCondicoes(ContextoUsina contexto) {
        System.out.println("  [Verificacao] ALERTA VERMELHO - SITUACAO CRITICA");
        System.out.println("  " + contexto);
        
        if (!contexto.isSistemaResfriamentoAtivo()) {
            System.out.println("  FALHA NO SISTEMA DE RESFRIAMENTO!");
            System.out.println("  Transicao OBRIGATORIA para EMERGENCIA");
        } else {
            System.out.println("  Sistema de resfriamento ainda operacional");
            System.out.println("  Mantendo alerta vermelho ate estabilizacao");
        }
        
        System.out.println("  Info: Nao e permitido retornar diretamente para ALERTA_AMARELO");
        System.out.println("  Info: Necessario desligar e reiniciar com procedimento completo");
    }
    
    @Override
    public String getNomeEstado() {
        return "ALERTA_VERMELHO";
    }
    
    @Override
    public String getDescricao() {
        return "Alerta maximo - Situacao critica";
    }
}
