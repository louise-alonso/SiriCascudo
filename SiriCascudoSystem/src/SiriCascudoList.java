import excecoes.comanda.ComandaJaExisteException;
import excecoes.comanda.ComandaNaoExisteException;
import excecoes.comanda.ListaComandasVaziaException;
import excecoes.pedido.ListaPedidosVaziaException;
import excecoes.pedido.PedidoNaoExisteException;

import java.util.ArrayList;
import java.util.List;

public class SiriCascudoList implements SiriCascudoInterface {
    private List<Comanda> comandas;
    private List<Pedido> pedidos;

    public SiriCascudoList() {
        this.comandas = new ArrayList<Comanda>();
        this.pedidos = new ArrayList<Pedido>();
    }

    public SiriCascudoList(List<Comanda> comandas, List<Pedido> pedidos) {
        this.comandas = comandas;
        this.pedidos = pedidos;
    }

    @Override
    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() throws ListaPedidosVaziaException {
        if (this.pedidos.size() > 0) {
            return this.pedidos;
        } else {
            throw new ListaPedidosVaziaException("A lista de pedidos está vazia!");
        }
    }

    @Override
    public boolean apagarPedido(int idPedido) throws PedidoNaoExisteException {
        boolean apagou = false;
        for (Pedido p : this.pedidos) {
            if (p.getNumComanda() == idPedido) {
                this.pedidos.remove(p);
                apagou = true;
                break;
            }
        }
        if(!apagou){
            throw new PedidoNaoExisteException("O pedido inserido não existe no cadastro!");
        }
        return apagou;
    }

    @Override
    public void criarComanda(Comanda comanda) throws ComandaJaExisteException {
        if (this.comandas.size() > 0) {
            for (Comanda c : this.comandas) {
                if (c.equals(comanda)) {
                    throw new ComandaJaExisteException("A comanda abaixo já existe no sistema!\n"+
                            comanda);
                }
            }
            comandas.add(comanda);
        } else {
            comandas.add(comanda);
        }
    }

    @Override
    public List<Comanda> listarComandas() throws ListaComandasVaziaException {
        if (this.comandas.size() > 0) {
            return this.comandas;
        }
        throw new ListaComandasVaziaException("Não há comandas cadastradas no sistema!");
    }

    @Override
    public boolean apagarComanda(int idComanda) throws ComandaNaoExisteException {
            for (Comanda c : this.comandas) {
                if (c.getNumComanda() == idComanda) {
                    this.comandas.remove(c);
                    return true;
                }
            }
        throw new ComandaNaoExisteException("A comanda de id "+ idComanda+" não existe no sistema!");
    }

    public List<Pedido> getPedidos(){
        return this.pedidos;
    }

    public List<Comanda> getComandas(){
        return this.comandas;
    }
}