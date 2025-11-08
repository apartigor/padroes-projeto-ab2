package questao3;

public class ControladorUsina {
    
    private EstadoUsina estadoAtual;
    private ContextoUsina contexto;
    
    public ControladorUsina(ContextoUsina contexto) {
        this.contexto = contexto;
        this.estadoAtual = new EstadoDesligada();
    }
    
    public void monitorar() {
        System.out.println("Estado Atual: " + estadoAtual.getNomeEstado());
        System.out.println("Descricao: " + estadoAtual.getDescricao());
        
        estadoAtual.verificarCondicoes(contexto);
    }
    
    public void iniciarOperacao() {
        if (estadoAtual instanceof EstadoDesligada) {
            System.out.println("\nIniciando operacao da usina...");
            estadoAtual = new EstadoOperacaoNormal();
            System.out.println("OK - Transicao: DESLIGADA para OPERACAO_NORMAL");
        } else {
            System.out.println("\nERRO - Transicao invalida: Usina ja esta em operacao");
        }
    }
    
    public void escalarParaAlertaAmarelo() {
        if (estadoAtual instanceof EstadoOperacaoNormal) {
            if (contexto.getTemperatura() > 300.0) {
                System.out.println("\nEscalando para alerta amarelo...");
                estadoAtual = new EstadoAlertaAmarelo();
                System.out.println("OK - Transicao: OPERACAO_NORMAL para ALERTA_AMARELO");
            } else {
                System.out.println("\nERRO - Condicoes nao atendidas para alerta amarelo");
                System.out.println("  Requer: temperatura > 300 graus C");
            }
        } else {
            System.out.println("\nERRO - Transicao invalida: Apenas de OPERACAO_NORMAL");
        }
    }
    
    public void escalarParaAlertaVermelho() {
        if (estadoAtual instanceof EstadoAlertaAmarelo) {
            if (contexto.getTemperatura() > 400.0 && contexto.getTempoEmAlerta() > 30) {
                System.out.println("\nEscalando para alerta vermelho...");
                estadoAtual = new EstadoAlertaVermelho();
                System.out.println("OK - Transicao: ALERTA_AMARELO para ALERTA_VERMELHO");
            } else {
                System.out.println("\nERRO - Condicoes nao atendidas para alerta vermelho");
                System.out.println("  Requer: temperatura > 400 graus C por mais de 30s");
            }
        } else {
            System.out.println("\nERRO - Transicao invalida: Apenas de ALERTA_AMARELO");
        }
    }
    
    public void declararEmergencia() {
        if (estadoAtual instanceof EstadoAlertaVermelho) {
            if (!contexto.isSistemaResfriamentoAtivo()) {
                System.out.println("\nDeclarando estado de emergencia...");
                estadoAtual = new EstadoEmergencia();
                System.out.println("OK - Transicao: ALERTA_VERMELHO para EMERGENCIA");
            } else {
                System.out.println("\nERRO - Condicoes nao atendidas para emergencia");
                System.out.println("  Requer: Falha no sistema de resfriamento");
            }
        } else {
            System.out.println("\nERRO - VIOLACAO DE SEGURANCA: EMERGENCIA so pode ser ativado apos ALERTA_VERMELHO");
            System.out.println("  Estado atual: " + estadoAtual.getNomeEstado());
        }
    }
    
    public void normalizarDeAlertaAmarelo() {
        if (estadoAtual instanceof EstadoAlertaAmarelo) {
            if (contexto.getTemperatura() <= 300.0) {
                System.out.println("\nNormalizando operacao...");
                estadoAtual = new EstadoOperacaoNormal();
                contexto.resetarTempoAlerta();
                System.out.println("OK - Transicao: ALERTA_AMARELO para OPERACAO_NORMAL");
            } else {
                System.out.println("\nERRO - Nao e possivel normalizar: temperatura ainda elevada");
            }
        } else {
            System.out.println("\nERRO - Transicao invalida: Apenas de ALERTA_AMARELO");
        }
    }
    
    public void desligarUsina() {
        if (estadoAtual instanceof EstadoEmergencia || estadoAtual instanceof EstadoAlertaVermelho) {
            System.out.println("\nExecutando desligamento de emergencia...");
            estadoAtual = new EstadoDesligada();
            contexto.resetarTempoAlerta();
            System.out.println("OK - Usina desligada com seguranca");
        } else {
            System.out.println("\nERRO - Desligamento de emergencia nao disponivel neste estado");
        }
    }
    
    public void ativarModoManutencao() {
        if (!(estadoAtual instanceof EstadoManutencao)) {
            System.out.println("\nAtivando modo manutencao...");
            EstadoUsina estadoAnterior = estadoAtual;
            estadoAtual = new EstadoManutencao(estadoAnterior);
            System.out.println("OK - Modo manutencao ativado - Estados normais suspensos");
        } else {
            System.out.println("\nERRO - Modo manutencao ja esta ativo");
        }
    }
    
    public void desativarModoManutencao() {
        if (estadoAtual instanceof EstadoManutencao) {
            EstadoManutencao manutencao = (EstadoManutencao) estadoAtual;
            System.out.println("\nDesativando modo manutencao...");
            estadoAtual = manutencao.getEstadoAnterior();
            System.out.println("OK - Retornando ao estado: " + estadoAtual.getNomeEstado());
        } else {
            System.out.println("\nERRO - Modo manutencao nao esta ativo");
        }
    }
    
    public EstadoUsina getEstadoAtual() {
        return estadoAtual;
    }
    
    public ContextoUsina getContexto() {
        return contexto;
    }
}
