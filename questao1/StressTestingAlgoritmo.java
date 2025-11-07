package questao1;

public class StressTestingAlgoritmo implements AlgoritmoDeRisco {

    @Override
    public String calcular(ContextoFinanceiro contexto) {
        double risco = contexto.getValorPortfolio() * 0.3 * (contexto.getPeriodoDias() / 30.0);
        
        return "Calculo [Stress Testing]:" +
               " Risco de " + String.format("%.2f", risco) +
               " em cenário extremo " + contexto;
    }
}