package cardapio;

public class BordaRecheada extends AdicionalDecorator {
    public BordaRecheada(ItemCardapio pizza) {
        super(pizza);
    }

    @Override
    public double getPreco() {
        return pizza.getPreco() + 4.5;
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", com borda recheada";
    }
}