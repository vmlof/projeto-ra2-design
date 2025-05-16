package cardapio;
// Padrão Decorator
public class QueijoExtra extends PizzaDecorator {
    public QueijoExtra(ItemCardapio pizza) {
        super(pizza);
    }

    @Override
    public double getPreco() {
        return pizzaDecorada.getPreco() + 3.5;
    }

    @Override
    public String getDescricao() {
        return pizzaDecorada.getDescricao() + " + Queijo Extra";
    }

    @Override
    public String getNome() {
        return pizzaDecorada.getNome() + " c/ Queijo Extra";
    }
}
