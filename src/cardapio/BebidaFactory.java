package cardapio;

import java.util.List;

public class BebidaFactory extends ItemCardapioFactory {
    @Override
    public ItemCardapio criarItem(String nome, double preco, String tamanho, List<String> adicionais) {
        return new Bebida(nome, preco, tamanho);
    }
}