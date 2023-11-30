package excecoes.comanda;

public class ListaComandasVaziaException extends Exception {

    public ListaComandasVaziaException() {
        super();
    }

    public ListaComandasVaziaException(String msg) {
        super(msg);
    }
}
