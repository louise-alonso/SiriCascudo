package excecoes.pedido;

public class PedidoNaoExisteException extends Exception{

    public PedidoNaoExisteException(){
        super();
    }

    public PedidoNaoExisteException(String msg){
        super(msg);
    }
}
