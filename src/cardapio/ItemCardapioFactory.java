package cardapio;

import java.util.List;

public abstract class ItemCardapioFactory {
    public abstract ItemCardapio criarItem(String tipo, String tamanho, List<String> adicionais);
}
