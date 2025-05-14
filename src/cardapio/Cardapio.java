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

        itens.add(ItemCardapioFactory.criarItem("pizza","Margherita",25.0,"média",null));
        itens.add(ItemCardapioFactory.criarItem("pizza","Calabresa",30.0,"grande",null));
        itens.add(ItemCardapioFactory.criarItem("pizza","Quatro Queijos",35.0,"pequena",null));

        itens.add(ItemCardapioFactory.criarItem("bebida","Refrigerante",6.0,"250ml",null));
        itens.add(ItemCardapioFactory.criarItem("bebida","Suco de Laranja",8.0,"1l",null));
        itens.add(ItemCardapioFactory.criarItem("bebida","Água Mineral",3.0,"800ml",null));
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
