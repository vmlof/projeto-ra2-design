package cardapio;

public abstract class AdicionalDecorator implements ItemCardapio {
    protected ItemCardapio pizza;

    public AdicionalDecorator(ItemCardapio pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getNome() {
        return pizza.getNome();
    }

    @Override
    public double getPreco() {
        return pizza.getPreco();
    }
}