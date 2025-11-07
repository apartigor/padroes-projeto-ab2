package questao2;

import java.util.HashMap;

public class AdaptadorBancarioLegado implements ProcessadorTransacoes {

    private SistemaBancarioLegado sistemaLegado;

    public AdaptadorBancarioLegado(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    @Override
    public RespostaAutorizacao autorizar(String cartao, double valor, String moeda) {
        
        System.out.println("[Adaptador] Recebendo chamada moderna...");

        HashMap<String, Object> parametrosLegados = new HashMap<>();
        parametrosLegados.put("numero_cartao", cartao);
        parametrosLegados.put("valor_total", valor);
        
        int codigoMoeda = traduzirMoedaParaCodigo(moeda);
        parametrosLegados.put("codigo_moeda", codigoMoeda);
        
        parametrosLegados.put("chave_seguranca", "CHAVE_FIXA_12345");

        String respostaLegada = sistemaLegado.processarTransacao(parametrosLegados);
        
        System.out.println("[Adaptador] Resposta legada recebida: " + respostaLegada);

        return traduzirRespostaParaModerno(respostaLegada);
    }
    
    private int traduzirMoedaParaCodigo(String moeda) {
        if (moeda == null) {
            return 0;
        }
        
        switch (moeda.toUpperCase()) {
            case "USD":
                return 1;
            case "EUR":
                return 2;
            case "BRL":
                return 3;
            default:
                return 0;
        }
    }

    
    private RespostaAutorizacao traduzirRespostaParaModerno(String respostaLegada) {
        if (respostaLegada.startsWith("APROVADA:")) {
            
            String idTransacao = respostaLegada.split(":")[1];
            return new RespostaAutorizacao(true, idTransacao, "Transação aprovada com sucesso.");
            
        } else if (respostaLegada.startsWith("NEGADO_")) {
        
            return new RespostaAutorizacao(false, null, "Transação negada: Limite excedido.");
            
        } else {
            
             return new RespostaAutorizacao(false, null, "Falha na transação: " + respostaLegada);
        }
    }
}