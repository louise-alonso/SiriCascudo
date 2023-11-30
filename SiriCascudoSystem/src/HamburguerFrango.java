public class HamburguerFrango extends Hamburguer {
    private boolean frango;

    public HamburguerFrango(boolean alface, boolean tomate, boolean cebola, boolean frango) {
        super(alface, tomate, cebola,CodigoPedido.HAMBURGUERFRANGO);
        this.frango = frango;
    }

    public HamburguerFrango() {
        this(false, false, false, false);
    }

    public boolean temFrango() {
        return frango;
    }

    public void setFrango(boolean frango) {
        this.frango = frango;
        if (frango) {
            this.descricao = "Frango";
        } else {
            this.descricao = "";
        }
    }

    @Override
    public String toString() {
        return super.toString() + (frango ? ", Frango" : "");
    }
    @Override
    public CodigoPedido getCodigoPedido() {
        return CodigoPedido.HAMBURGUERFRANGO;
    }
}
