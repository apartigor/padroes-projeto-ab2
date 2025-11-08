package questao3;

public class ContextoUsina {
    
    private double temperatura;
    private double pressao;
    private double nivelRadiacao;
    private boolean sistemaResfriamentoAtivo;
    private long tempoEmAlerta;
    
    public ContextoUsina(double temperatura, double pressao, double nivelRadiacao, 
                         boolean sistemaResfriamentoAtivo) {
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.nivelRadiacao = nivelRadiacao;
        this.sistemaResfriamentoAtivo = sistemaResfriamentoAtivo;
        this.tempoEmAlerta = 0;
    }
    
    public double getTemperatura() {
        return temperatura;
    }
    
    public double getPressao() {
        return pressao;
    }
    
    public double getNivelRadiacao() {
        return nivelRadiacao;
    }
    
    public boolean isSistemaResfriamentoAtivo() {
        return sistemaResfriamentoAtivo;
    }
    
    public long getTempoEmAlerta() {
        return tempoEmAlerta;
    }
    
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    public void setPressao(double pressao) {
        this.pressao = pressao;
    }
    
    public void setNivelRadiacao(double nivelRadiacao) {
        this.nivelRadiacao = nivelRadiacao;
    }
    
    public void setSistemaResfriamentoAtivo(boolean ativo) {
        this.sistemaResfriamentoAtivo = ativo;
    }
    
    public void incrementarTempoAlerta(long segundos) {
        this.tempoEmAlerta += segundos;
    }
    
    public void resetarTempoAlerta() {
        this.tempoEmAlerta = 0;
    }
    
    @Override
    public String toString() {
        return String.format("Temp=%.1f graus C, Pressao=%.1f bar, Radiacao=%.2f mSv, Resfriamento=%s, TempoAlerta=%ds",
                           temperatura, pressao, nivelRadiacao, 
                           sistemaResfriamentoAtivo ? "OK" : "FALHA", tempoEmAlerta);
    }
}
