public class Hamburguer {
    protected boolean alface;
    protected boolean tomate;
    protected boolean cebola;
    protected String descricao;
    protected CodigoPedido codigoPedido;

    public static double calcularValorObj(CodigoPedido codigoPedido) {
        double preco = 0.0;

        switch (codigoPedido) {
            case HAMBURGUER -> preco = 20.0;
            case HAMBURGUERCHEDDAR -> preco = 25.0;
            case HAMBURGUERFRANGO -> preco = 22.0;
            default -> {
            }
        }

        return preco;
    }

    public Hamburguer(boolean alface, boolean tomate, boolean cebola, CodigoPedido codigoPedido) {
        this.alface = alface;
        this.tomate = tomate;
        this.cebola = cebola;
        this.descricao = toString();
        this.codigoPedido = codigoPedido;
    }

    public Hamburguer(){
        this(false, false, false, null);
    }

    public boolean temAlface() {
        return alface;
    }

    public void setAlface(boolean alface) {
        this.alface = alface;
    }

    public boolean temTomate() {
        return tomate;
    }

    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    public boolean temCebola() {
        return cebola;
    }

    public void setCebola(boolean cebola) {
        this.cebola = cebola;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        StringBuilder descricao = new StringBuilder("Hamburguer com pão brioche, blend de 160g");

        if (this.codigoPedido == CodigoPedido.HAMBURGUERCHEDDAR) {
            descricao.append(", queijo CHEDDAR");
        } else if (this.codigoPedido == CodigoPedido.HAMBURGUERFRANGO) {
            descricao.append(" de frango");
        } else {
            descricao.append("");
        }


        if (cebola) {
            descricao.append(", cebola");
        }
        if(alface){
            descricao.append(", alface");
        }
        if(tomate){
            descricao.append((", tomate"));
        }

        return descricao.toString();
    }


    public CodigoPedido getCodigoPedido() {
        return this.codigoPedido;
    }
}