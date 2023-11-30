package excecoes.pedido;

public class ListaPedidosVaziaException extends Exception {

    public ListaPedidosVaziaException() {
        super();
    }

    public ListaPedidosVaziaException(String mensagem) {
        super(mensagem);
    }
}
