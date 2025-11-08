package questao3;

public class EstadoEmergencia implements EstadoUsina {
    
    @Override
    public void verificarCondicoes(ContextoUsina contexto) {
        System.out.println("  [Verificacao] EMERGENCIA NUCLEAR DECLARADA");
        System.out.println("  " + contexto);
        System.out.println("  PROTOCOLO DE EMERGENCIA ATIVO");
        System.out.println("  Evacuacao da area recomendada");
        System.out.println("  Aguardando procedimento de desligamento seguro");
        System.out.println("  Info: Unico caminho: EMERGENCIA para DESLIGADA");
    }
    
    @Override
    public String getNomeEstado() {
        return "EMERGENCIA";
    }
    
    @Override
    public String getDescricao() {
        return "EMERGENCIA NUCLEAR - Protocolo de seguranca ativo";
    }
}
