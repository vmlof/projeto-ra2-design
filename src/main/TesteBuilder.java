package main;

import cardapio.Bebida;
import cardapio.BebidaFactory;
import cardapio.ItemCardapio;
import cardapio.PizzaFactory;
import pagamento.CartaoCredito;
import pagamento.Pagamento;
import pedido.Pedido;
import pedido.PedidoBuilder;
import pessoas.Cliente;

public class TesteBuilder {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        BebidaFactory bebidaFactory = new BebidaFactory();

        Cliente cliente = new Cliente("João Silva", "123.456.789-00",
                "(11) 99999-9999", "joao@email.com",
                "Rua Exemplo, 123");
        ItemCardapio pizzaMargherita = pizzaFactory.criarItem("pizza","media",null);
        ItemCardapio refrigerante = bebidaFactory.criarItem("refrigerante","800ml",null);


        Pedido pedido = new PedidoBuilder()
                .comCliente(cliente)
                .comTipoEntrega("Delivery")
                .comPagamento(new CartaoCredito())
                .comStatus("Preparando")
                .adicionarItem(pizzaMargherita, 1)
                .adicionarItem(refrigerante, 2)
                .construir();


        pedido.exibir();
    }

}
