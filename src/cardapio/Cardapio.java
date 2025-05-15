package cardapio;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private List<ItemCardapio> itens;

    public Cardapio() {
        this.itens = new ArrayList<>();
        inicializarCardapio();
    }

    private void inicializarCardapio() {

        ItemCardapioFactory pizzaFactory = new PizzaFactory();
        ItemCardapioFactory bebidaFactory = new BebidaFactory();

        itens.add(pizzaFactory.criarItem("Margherita", 25.0, "média", null));
        itens.add(pizzaFactory.criarItem("Calabresa", 30.0, "grande", null));
        itens.add(pizzaFactory.criarItem("Quatro Queijos", 35.0, "pequena", null));

        itens.add(bebidaFactory.criarItem("Refrigerante", 6.0, "250ml", null));
        itens.add(bebidaFactory.criarItem("Suco de Laranja", 8.0, "1l", null));
        itens.add(bebidaFactory.criarItem("Água Mineral", 3.0, "800ml", null));
    }

    public void exibirCardapio() {
        int i = 1;
        System.out.println("----- Cardápio ----------");
        for (ItemCardapio item : itens) {
            System.out.println(i + ") " + item);
            i++;
        }
        System.out.println("-------------------------");
    }

}
