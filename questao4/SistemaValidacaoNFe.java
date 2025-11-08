package questao4;

public class SistemaValidacaoNFe {

    public static void main(String[] args) {

        CadeiaValidacao cadeia = new CadeiaValidacao();

        System.out.println("\nCENARIO 1: NFe valida completa");
        DocumentoFiscal nfe1 = new DocumentoFiscal(
                "NFe001",
                "<NFe><chave>123</chave></NFe>",
                "CERT-VALIDO-2025",
                1000.0);
        cadeia.validarDocumento(nfe1);

        System.out.println("\n\nCENARIO 2: Certificado expirado");
        DocumentoFiscal nfe2 = new DocumentoFiscal(
                "NFe002",
                "<NFe><chave>456</chave></NFe>",
                "CERT-EXPIRADO-2020",
                2000.0);
        cadeia.validarDocumento(nfe2);

        System.out.println("\n\nCENARIO 3: NFe duplicada");
        DocumentoFiscal nfe3 = new DocumentoFiscal(
                "NFe001",
                "<NFe><chave>789</chave></NFe>",
                "CERT-VALIDO-2025",
                1500.0);
        cadeia.validarDocumento(nfe3);

        System.out.println("\n\nCENARIO 4: Circuit Breaker (com 3 falhas consecutivas)");
        DocumentoFiscal nfe4 = new DocumentoFiscal(
                "NFe004",
                "",
                "CERT-EXPIRADO-2019",
                -100.0);
        cadeia.validarDocumento(nfe4);

        System.out.println("\n\nCENARIO 5: SEFAZ rejeita");
        DocumentoFiscal nfe5 = new DocumentoFiscal(
                "NFe-INVALIDO-005",
                "<NFe><chave>999</chave></NFe>",
                "CERT-VALIDO-2025",
                5000.0);
        cadeia.validarDocumento(nfe5);
    }
}
