package questao3;

public class EstadoAlertaAmarelo implements EstadoUsina {
    
    @Override
    public void verificarCondicoes(ContextoUsina contexto) {
        System.out.println("  [Verificacao] ALERTA AMARELO - Monitoramento intensificado");
        System.out.println("  " + contexto);
        
        if (contexto.getTemperatura() <= 300.0) {
            contexto.resetarTempoAlerta();
            System.out.println("  Temperatura normalizada - pode retornar a OPERACAO_NORMAL");
        }
        else if (contexto.getTemperatura() > 400.0) {
            System.out.println("  CRITICO: Temperatura > 400 graus C!");
            System.out.println("  Tempo em alerta: " + contexto.getTempoEmAlerta() + "s");
            
            if (contexto.getTempoEmAlerta() > 30) {
                System.out.println("  Temperatura critica sustentada por mais de 30s!");
                System.out.println("  Transicao necessaria para ALERTA_VERMELHO");
            } else {
                System.out.println("  Aguardando para confirmar tendencia...");
            }
        } else {
            System.out.println("  Temperatura elevada mas controlada");
            contexto.resetarTempoAlerta();
        }
    }
    
    @Override
    public String getNomeEstado() {
        return "ALERTA_AMARELO";
    }
    
    @Override
    public String getDescricao() {
        return "Alerta nivel 1 - Parametros elevados";
    }
}
