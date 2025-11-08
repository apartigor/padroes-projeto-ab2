package questao3;

public class EstadoDesligada implements EstadoUsina {
    
    @Override
    public void verificarCondicoes(ContextoUsina contexto) {
        System.out.println("  [Verificacao] Usina desligada - sistemas inativos");
    }
    
    @Override
    public String getNomeEstado() {
        return "DESLIGADA";
    }
    
    @Override
    public String getDescricao() {
        return "Usina esta desligada e segura";
    }
}
