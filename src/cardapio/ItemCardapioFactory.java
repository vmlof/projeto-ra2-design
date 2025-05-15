package cardapio;

import java.util.List;

public abstract class ItemCardapioFactory {
    public abstract ItemCardapio criarItem(String nome, double preco, String tamanho, List<String> adicionais);
}
