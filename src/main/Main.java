package main;

import cardapio.ItemCardapio;
import cardapio.PizzaFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();


        ItemCardapio pizza1 = pizzaFactory.criarItem(
                "margherita",
                "media",
                List.of("queijo extra")
        );

        ItemCardapio pizza2 = pizzaFactory.criarItem(
                "pepperoni",
                "grande",
                List.of("queijo extra", "borda recheada")
        );

        System.out.println(pizza1.getNome() + ": R$" + pizza1.getPreco());
        System.out.println("Descrição: " + pizza1.getDescricao());

        System.out.println("\n" + pizza2.getNome() + ": R$" + pizza2.getPreco());
        System.out.println("Descrição: " + pizza2.getDescricao());
    }
}