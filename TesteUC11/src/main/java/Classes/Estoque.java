package Classes;

public class Estoque {
    int estoqueAtual;
    int estoqueMaximo;
    String item;
    String local;

    public Estoque(int estoqueAtual, int estoqueMaximo, String item, String local) {
        this.estoqueAtual = estoqueAtual;
        this.estoqueMaximo = estoqueMaximo;
        this.item = item;
        this.local = local;
    }

    public void aumentarEstoque(int quantidade){
        if(estoqueAtual+quantidade<=estoqueMaximo) {
            this.estoqueAtual += quantidade;
        }
    }
    public boolean retirarDoEstoque(int quantidade){
        if(quantidade<=estoqueAtual){
            estoqueAtual-=quantidade;
        }
        return false;
    }
    public int getEstoqueAtual(){
        return estoqueAtual;
    }

}
