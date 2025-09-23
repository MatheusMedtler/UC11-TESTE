package Classes;

public class Pedidos {
    String pecaPedida;
    int quantidade;
    String detalhes;
    String modelo;

    public Pedidos(String pecaPedida, int quantidade, String detalhes, String modelo) {
        this.pecaPedida = pecaPedida;
        this.quantidade = quantidade;
        this.detalhes = detalhes;
        this.modelo = modelo;
    }

    public String getDetalhes() {
        return detalhes;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public String getModelo() {
        return modelo;
    }
    public String getPecaPedida() {
        return pecaPedida;
    }

    public void setPecaPedida(String pecaPedida) {
        this.pecaPedida = pecaPedida;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
