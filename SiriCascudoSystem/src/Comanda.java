import java.util.Objects;

public class Comanda {
    private Pedido pedido;
    private String tipoPagamento;
    private String data;
    private int numComanda;

    public static final String CREDITO = "Crédito";
    public static final String DEBITO = "Débito";
    public static final String DINHEIRO_OU_PIX = "Dinheiro ou Pix";

    public Comanda(Pedido pedido, String tipoPagamento, String data, int numComanda) {
        this.pedido = pedido;
        this.tipoPagamento = tipoPagamento;
        this.data = data;
        this.numComanda = numComanda;
    }

    public Comanda() {
        this(null, "Sem pagamento", "dd/mm/yyyy", 0);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNumComanda() {
        return numComanda;
    }

    public void setNumComanda(int numComanda) {
        this.numComanda = numComanda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comanda comanda = (Comanda) o;
        return numComanda == comanda.numComanda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numComanda);
    }

    @Override
    public String toString() {
        return "------------------------------------------------" +
                "\nID da comanda: "+ this.numComanda+
                "\nPedido: " + pedido.getHamburguer().getDescricao() +
                "\nCódigo do pedido: " + pedido.getHamburguer().getCodigoPedido() +
                "\nQuantidade: " + pedido.getQuantidade() +
                "\nData: " + this.data +
                "\nValor total: " + pedido.calcularValorTotal() +
                "\nTipo de pagamento: " + this.tipoPagamento +
                "\n------------------------------------------------";
    }
}
