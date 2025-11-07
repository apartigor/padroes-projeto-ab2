package questao1;

public class AnalisadorDeRisco {

    private AlgoritmoDeRisco algoritmoAtual;

    public void setAlgoritmoDeRisco(AlgoritmoDeRisco algoritmo) {
        this.algoritmoAtual = algoritmo;
    }

    public String processarRisco(ContextoFinanceiro contexto) {
        if (algoritmoAtual == null) {
            return "ERRO: Nenhum algoritmo de risco foi definido.";
        }
        
        return algoritmoAtual.calcular(contexto);
    }
}