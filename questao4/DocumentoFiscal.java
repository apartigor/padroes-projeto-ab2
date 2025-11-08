package questao4;

public class DocumentoFiscal {
    
    private String numeroNFe;
    private String xmlConteudo;
    private String certificadoDigital;
    private double valorTotal;
    private double impostoCalculado;
    private boolean inseridoBancoDados;
    
    public DocumentoFiscal(String numeroNFe, String xmlConteudo, String certificadoDigital, double valorTotal) {
        this.numeroNFe = numeroNFe;
        this.xmlConteudo = xmlConteudo;
        this.certificadoDigital = certificadoDigital;
        this.valorTotal = valorTotal;
        this.impostoCalculado = 0.0;
        this.inseridoBancoDados = false;
    }
    
    public String getNumeroNFe() {
        return numeroNFe;
    }
    
    public String getXmlConteudo() {
        return xmlConteudo;
    }
    
    public String getCertificadoDigital() {
        return certificadoDigital;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }
    
    public double getImpostoCalculado() {
        return impostoCalculado;
    }
    
    public void setImpostoCalculado(double imposto) {
        this.impostoCalculado = imposto;
    }
    
    public boolean isInseridoBancoDados() {
        return inseridoBancoDados;
    }
    
    public void setInseridoBancoDados(boolean inserido) {
        this.inseridoBancoDados = inserido;
    }
    
    @Override
    public String toString() {
        return String.format("NFe: %s, Valor: R$ %.2f, Imposto: R$ %.2f, BD: %s", 
                           numeroNFe, valorTotal, impostoCalculado, inseridoBancoDados ? "Sim" : "Nao");
    }
}
