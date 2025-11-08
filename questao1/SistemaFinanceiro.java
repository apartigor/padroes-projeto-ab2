package questao1;

public class SistemaFinanceiro {

    public static void main(String[] args) {

        ContextoFinanceiro contexto = new ContextoFinanceiro(1000000.0, 0.05, 30);
        AnalisadorDeRisco analisador = new AnalisadorDeRisco();

        System.out.println("--- Executando analise diaria (VaR) ---");
        AlgoritmoDeRisco var = new ValueAtRiskAlgoritmo();
        analisador.setAlgoritmoDeRisco(var);
        System.out.println(analisador.processarRisco(contexto));

        System.out.println("\n--- Executando analise de cauda (ES) ---");
        AlgoritmoDeRisco es = new ExpectedShortfallAlgoritmo();
        analisador.setAlgoritmoDeRisco(es);
        System.out.println(analisador.processarRisco(contexto));

        System.out.println("\n--- Executando simulacao de crise (Stress) ---");
        AlgoritmoDeRisco stress = new StressTestingAlgoritmo();
        analisador.setAlgoritmoDeRisco(stress);
        System.out.println(analisador.processarRisco(contexto));
    }
}