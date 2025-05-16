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

        itens.add(pizzaFactory.criarItem("margherita", "média", null));
        itens.add(pizzaFactory.criarItem("calabresa", "grande", null));
        itens.add(pizzaFactory.criarItem("quatro queijos", "pequena", null));

        itens.add(bebidaFactory.criarItem("refrigerante", "250ml",null));
        itens.add(bebidaFactory.criarItem("suco de laranja", "1l",null));
        itens.add(bebidaFactory.criarItem("água mineral", "800ml",null));
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
