package cardapio;

import java.util.List;

public class PizzaFactory extends ItemCardapioFactory {
    @Override
    public ItemCardapio criarItem(String tipo, String tamanho, List<String> adicionais) {
        if (!tipo.toLowerCase().startsWith("pizza")) {
            throw new IllegalArgumentException("Tipo de item desconhecido: " + tipo);
        }

        ItemCardapio pizza = criarPizzaBase(tipo,tamanho);
        if (adicionais != null) {
            for(String adicional : adicionais) {
                pizza = aplicarAdicional(pizza, adicional);
            }
        }
        return pizza;
    }

    private ItemCardapio criarPizzaBase(String tipoPizza, String tamanho) {
        double precoBase = switch (tamanho.toLowerCase()) {
            case "pequena" -> 25.0;
            case "media" -> 35.0;
            case "grande" -> 45.0;
            default -> 30.0;
        };
        return new Pizza(tipoPizza, precoBase, tamanho);
    }

    // Padrão Decorator
    private ItemCardapio aplicarAdicional(ItemCardapio pizza, String adicional) {
        return switch (adicional.toLowerCase()) {
            case "queijo extra" -> new QueijoExtra(pizza);
            case "borda recheada" -> new BordaRecheada(pizza);
            default -> pizza;
        };
    }

}