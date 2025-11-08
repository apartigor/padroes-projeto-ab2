package questao4;

public class ResultadoValidacao {
    
    private boolean sucesso;
    private String mensagem;
    private String nomeValidador;
    
    public ResultadoValidacao(boolean sucesso, String mensagem, String nomeValidador) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.nomeValidador = nomeValidador;
    }
    
    public boolean isSucesso() {
        return sucesso;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
    public String getNomeValidador() {
        return nomeValidador;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: %s", 
                           nomeValidador, 
                           sucesso ? "OK" : "FALHA", 
                           mensagem);
    }
}
