public class HamburguerCheddar extends Hamburguer {
    private boolean cheddar;

    public HamburguerCheddar(boolean alface, boolean tomate, boolean cebola, boolean cheddar) {
        super(alface, tomate, cebola,CodigoPedido.HAMBURGUERCHEDDAR);
        this.cheddar = cheddar;
    }

    public HamburguerCheddar() {
        this(false, false, false, false);
    }

    public boolean temCheddar() {
        return cheddar;
    }

    public void setCheddar(boolean cheddar) {
        this.cheddar = cheddar;
        if (cheddar) {
            this.descricao = "Cheddar";
        } else {
            this.descricao = "";
        }
    }

    @Override
    public String toString() {
        return super.toString() + (cheddar ? ", Cheddar" : "");
    }
    @Override
    public CodigoPedido getCodigoPedido() {
        return CodigoPedido.HAMBURGUERCHEDDAR;
    }
}
