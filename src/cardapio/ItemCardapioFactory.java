package cardapio;


public abstract class ItemCardapioFactory {
    public abstract ItemCardapio criarItem(String tipo, String tamanho);
}
