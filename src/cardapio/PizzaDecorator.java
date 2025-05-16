package cardapio;
// Padrão Decorator
public abstract class PizzaDecorator  implements  ItemCardapio {
    protected final ItemCardapio pizzaDecorada;

    public PizzaDecorator(ItemCardapio pizzaDecorada) {
        this.pizzaDecorada = pizzaDecorada;
    }

    @Override
    public String getNome() {
        return pizzaDecorada.getNome();
    }

    @Override
    public abstract double getPreco();

    @Override
    public abstract String getDescricao();
}
