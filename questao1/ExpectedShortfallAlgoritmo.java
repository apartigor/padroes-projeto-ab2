package questao1;

public class ExpectedShortfallAlgoritmo implements AlgoritmoDeRisco {

    @Override
    public String calcular(ContextoFinanceiro contexto) {
        double risco = contexto.getValorPortfolio() * contexto.getTaxaJuros() * 0.08;
        
        return "Calculo [Expected Shortfall (ES)]:" +
               " Pior cenário de " + String.format("%.2f", risco) +
               " com base no contexto " + contexto;
    }
}