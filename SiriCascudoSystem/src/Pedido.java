import java.util.List;

public class Pedido {
    private Hamburguer hamburguer;
    private String bebida;
    private boolean combo;
    private int quantidade;
    private int numComanda;
    private double valorPedido;

    public Pedido(Hamburguer hamburguer,String bebida, boolean combo, int quantidade, int numComanda) {
        this.hamburguer = hamburguer;
        this.bebida = bebida;
        this.combo = combo;
        this.quantidade = quantidade;
        this.numComanda = numComanda;
        this.valorPedido = calcularValorTotal();
    }

    public Hamburguer getHamburguer() {
        return hamburguer;
    }

    public void setHamburguer(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public boolean isCombo() {
        return combo;
    }

    public void setCombo(boolean combo) {
        this.combo = combo;
    }

    public int getNumComanda() {
        return numComanda;
    }

    public void setNumComanda(int numComanda) {
        this.numComanda = numComanda;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public double calcularValorTotal() {
        if(combo){
            return hamburguer.calcularValorObj(hamburguer.getCodigoPedido()) * quantidade + 20.0;
        }else if(bebida != "" || bebida != " ") {
            return hamburguer.calcularValorObj(hamburguer.getCodigoPedido()) * quantidade + 10;
        }
        return hamburguer.calcularValorObj(hamburguer.getCodigoPedido()) * quantidade;
    }

    @Override
    public String toString() {
        return "Pedido: " + hamburguer.getCodigoPedido() + ", Quantidade: " + quantidade + ", Total: " + calcularValorTotal();
    }
}
