package excecoes.pedido;

public class PedidoJaExisteException extends Exception {

    public PedidoJaExisteException() {
        super();
    }

    public PedidoJaExisteException(String mensagem) {
        super(mensagem);
    }
}
