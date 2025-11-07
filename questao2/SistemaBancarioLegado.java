package questao2;

import java.util.HashMap;
import java.util.UUID;

public class SistemaBancarioLegado {

    public String processarTransacao(HashMap<String, Object> parametros) {

        System.out.println("[Sistema Legado] Processando: " + parametros);
        
        if (!parametros.containsKey("chave_seguranca")) {
            System.out.println("[Sistema Legado] FALHA: Chave de segurança não encontrada.");
            return "ERRO_90_AUTENTICACAO";
        }
        
        if (!parametros.containsKey("codigo_moeda") || (Integer)parametros.get("codigo_moeda") == 0) {
             System.out.println("[Sistema Legado] FALHA: Código de moeda ausente ou inválido.");
            return "ERRO_12_MOEDA_INVALIDA";
        }

        double valor = (Double) parametros.get("valor_total");

        if (valor > 1000.0) {
            System.out.println("[Sistema Legado] NEGADO: Limite excedido.");
            return "NEGADO_51_LIMITE";
        }
        
        String id = UUID.randomUUID().toString().substring(0, 8);
        System.out.println("[Sistema Legado] APROVADO.");
        return "APROVADA:" + id;
    }
}