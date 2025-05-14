package cardapio;

import java.util.List;

public class ItemCardapioFactory {
    public static ItemCardapio criarItem(String tipo, String nome, double preco, String tamanho, List<String> adicionais) {
        ItemCardapio item;

        switch (tipo.toLowerCase()) {
            case "pizza":
                item = new Pizza(nome, preco, tamanho);
                break;
            case "bebida":
                item = new Bebida(nome, preco, tamanho);
                break;
            default:
                throw new IllegalArgumentException("Tipo de item inválido: " + tipo);
        }

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
