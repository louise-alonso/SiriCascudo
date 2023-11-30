package excecoes.pedido;

public class PedidoNaoEncontradoException extends Exception {

    public PedidoNaoEncontradoException() {
        super();
    }

    public PedidoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
