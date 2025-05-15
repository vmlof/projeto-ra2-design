package main;

import cardapio.BebidaFactory;
import cardapio.ItemCardapio;
import cardapio.ItemCardapioFactory;
import cardapio.PizzaFactory;

import java.util.List;

public class TesteFactory {
    public static void main(String[] args) {
        ItemCardapioFactory factory;

        // Criar pizza
        factory = new PizzaFactory();
        ItemCardapio pizza = factory.criarItem("Calabresa", 30.0, "Grande", List.of("queijo extra", "borda recheada"));

        // Criar bebida
        factory = new BebidaFactory();
        ItemCardapio bebida = factory.criarItem("Coca-Cola", 8.0, "Lata", null);

        System.out.println("Pedido:");
        System.out.println(pizza.getNome() + " - R$" + pizza.getPreco());
        System.out.println(bebida.getNome() + " - R$" + bebida.getPreco());
    }
}
