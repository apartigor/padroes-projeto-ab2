package questao3;

public class SistemaUsinaNuclear {

    public static void main(String[] args) {

        System.out.println("\nCENARIO 1: Operacao Normal");
        ContextoUsina contexto = new ContextoUsina(250.0, 15.0, 2.5, true);
        ControladorUsina usina = new ControladorUsina(contexto);
        usina.iniciarOperacao();

        System.out.println("\nCENARIO 2: Alerta Amarelo");
        contexto.setTemperatura(320.0);
        usina.escalarParaAlertaAmarelo();

        System.out.println("\nCENARIO 3: Alerta Vermelho");
        contexto.setTemperatura(420.0);
        contexto.incrementarTempoAlerta(35);
        usina.escalarParaAlertaVermelho();

        System.out.println("\nCENARIO 4: Emergencia");
        contexto.setSistemaResfriamentoAtivo(false);
        usina.declararEmergencia();

        System.out.println("\nCENARIO 5: Teste de Restricao");
        ControladorUsina usina2 = new ControladorUsina(new ContextoUsina(200.0, 10.0, 1.5, false));
        usina2.iniciarOperacao();
        usina2.declararEmergencia();

        System.out.println("\nCENARIO 6: Modo Manutencao");
        ControladorUsina usina3 = new ControladorUsina(new ContextoUsina(300.0, 12.0, 2.0, true));
        usina3.iniciarOperacao();
        usina3.ativarModoManutencao();
        usina3.desativarModoManutencao();
    }
}
