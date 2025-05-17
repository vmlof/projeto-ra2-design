package pedido;

import cardapio.ItemCardapio;

public class ItemPedido {
    private final ItemCardapio item;
    private int quantidade;

    public ItemPedido(ItemCardapio item, int quantidade) {
        if (item == null) throw new IllegalArgumentException("Item do cardápio não pode ser nulo");
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser positiva");

        this.item = item;
        this.quantidade = quantidade;
    }

    public ItemCardapio getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return item.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%dx %s - R$%.2f", quantidade, item.getDescricao(), getSubtotal());
    }
}
