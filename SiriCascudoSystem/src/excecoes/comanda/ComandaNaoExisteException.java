package excecoes.comanda;

public class ComandaNaoExisteException extends Exception{
    public ComandaNaoExisteException(){
        super();
    }

    public ComandaNaoExisteException(String msg){
        super(msg);
    }
}
