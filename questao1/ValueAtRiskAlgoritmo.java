package questao1;

public class ValueAtRiskAlgoritmo implements AlgoritmoDeRisco {

    @Override
    public String calcular(ContextoFinanceiro contexto) {
        double risco = contexto.getValorPortfolio() * contexto.getTaxaJuros() * 0.05;
        
        return "Calculo [Value at Risk (VaR)]:" +
               " Risco de " + String.format("%.2f", risco) +
               " com base no contexto " + contexto;
    }
}