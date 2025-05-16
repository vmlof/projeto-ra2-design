package cardapio;
// Padrão Decorator
public class BordaRecheada extends PizzaDecorator {
    public BordaRecheada(ItemCardapio pizza) {
        super(pizza);
    }

    @Override
    public double getPreco() {
        return pizzaDecorada.getPreco() + 5.0;
    }

    @Override
    public String getDescricao() {
        return pizzaDecorada.getDescricao() + " + Borda Recheada";
    }

    @Override
    public String getNome() {
        return pizzaDecorada.getNome() + " c/ Borda Recheada";
    }
}
