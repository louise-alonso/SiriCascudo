import excecoes.comanda.ComandaJaExisteException;
import excecoes.comanda.ComandaNaoExisteException;
import excecoes.comanda.ListaComandasVaziaException;
import excecoes.pedido.PedidoJaExisteException;
import excecoes.pedido.PedidoNaoEncontradoException;
import excecoes.pedido.ListaPedidosVaziaException;
import excecoes.pedido.PedidoNaoExisteException;

import java.io.IOException;
import java.util.List;

public interface SiriCascudoInterface {

    void registrarPedido(Pedido pedido);
    List<Pedido> listarPedidos() throws ListaPedidosVaziaException;
    boolean apagarPedido(int idPedido) throws PedidoNaoExisteException;

    void criarComanda(Comanda comanda) throws ComandaJaExisteException;
    List<Comanda> listarComandas() throws ListaComandasVaziaException;
    boolean apagarComanda(int idComanda) throws ComandaNaoExisteException;

}
