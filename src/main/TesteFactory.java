package main;

import cardapio.BebidaFactory;
import cardapio.ItemCardapio;
import cardapio.ItemCardapioFactory;
import cardapio.PizzaFactory;

import java.util.List;

public class TesteFactory {
    public static void main(String[] args) {
        ItemCardapioFactory pizzaFactory = new PizzaFactory();

        // Criando pizzas com preços diferentes por tipo
        ItemCardapio margherita = pizzaFactory.criarItem("margherita", "media",null);
        ItemCardapio pepperoni = pizzaFactory.criarItem("pepperoni", "media",null);
        ItemCardapio vegetariana = pizzaFactory.criarItem("vegetariana", "media",null);

        System.out.println("Margherita (média): R$" + margherita.getPreco()); // 35 + 5 = 40
        System.out.println("Pepperoni (média): R$" + pepperoni.getPreco());    // 35 + 1 = 36
        System.out.println("Vegetariana (média): R$" + vegetariana.getPreco());// 35 + 0 = 35

        // Mostrando com tamanho grande
        ItemCardapio margheritaGrande = pizzaFactory.criarItem("margherita", "grande",null);
        System.out.println("Margherita (grande): R$" + margheritaGrande.getPreco()); // 45 + 5 = 50
    }
}
