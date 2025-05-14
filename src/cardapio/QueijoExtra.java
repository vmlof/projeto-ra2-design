package cardapio;

public class QueijoExtra extends AdicionalDecorator {
    public QueijoExtra(ItemCardapio pizza) {
        super(pizza);
    }

    @Override
    public double getPreco() {
        return pizza.getPreco() + 3.0;
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", com queijo extra";
    }
}
