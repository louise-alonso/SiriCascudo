package excecoes.comanda;

public class ComandaJaExisteException extends Exception{

    public ComandaJaExisteException(){
        super();
    }

    public ComandaJaExisteException(String msg){
        super(msg);
    }
}
