package cardapio;

import java.util.List;

public class PizzaFactory extends ItemCardapioFactory {
    @Override
    public ItemCardapio criarItem(String nome, double preco, String tamanho, List<String> adicionais) {
        ItemCardapio item = new Pizza(nome, preco, tamanho);

        if (adicionais != null) {
            for (String adicional : adicionais) {
                switch (adicional.toLowerCase()) {
                    case "queijo extra":
                        item = new QueijoExtra(item);
                        break;
                    case "borda recheada":
                        item = new BordaRecheada(item);
                        break;
                }
            }
        }
        return item;
    }
}
