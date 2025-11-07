package questao2;

public class ClienteBancario {

    public static void main(String[] args) {
        
        SistemaBancarioLegado sistemaLegado = new SistemaBancarioLegado();

        ProcessadorTransacoes processador = new AdaptadorBancarioLegado(sistemaLegado);
        
        System.out.println("--- Transação 1 (BRL- Para aprovar) ---");
        RespostaAutorizacao resp1 = processador.autorizar("1111-2222-3333-4444", 500.0, "BRL");
        System.out.println("CLIENTE RECEBEU: " + resp1);
        
        System.out.println("\n--- Transação 2 (USD - Falha [Limite Excedido]) ---");
        RespostaAutorizacao resp2 = processador.autorizar("5555-6666-7777-8888", 2500.0, "USD");
        System.out.println("CLIENTE RECEBEU: " + resp2);
        
        System.out.println("\n--- Transação 3 (YNC - Falha [Moeda Inválida]) ---");
        RespostaAutorizacao resp3 = processador.autorizar("7777-8888-9999-0000", 100.0, "YNC");
        System.out.println("CLIENTE RECEBEU: " + resp3);
    }
}