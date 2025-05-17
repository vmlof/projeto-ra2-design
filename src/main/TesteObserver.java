package main;

import cardapio.BebidaFactory;
import cardapio.ItemCardapio;
import cardapio.PizzaFactory;
import pagamento.CartaoCredito;
import pedido.CozinhaObservador;
import pedido.Pedido;
import pedido.PedidoBuilder;
import pessoas.Cliente;
import pessoas.ClienteObservador;
import pessoas.EntregadorObservador;

public class TesteObserver {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        BebidaFactory bebidaFactory = new BebidaFactory();

        // Cliente
        Cliente cliente = new Cliente("João Silva", "123.456.789-00",
                "(11) 99999-9999", "joao@email.com", "Rua Exemplo, 123");


        // Itens
        ItemCardapio pizza = pizzaFactory.criarItem("pizza", "grande", null);
        ItemCardapio bebida = bebidaFactory.criarItem("refrigerante", "600ml", null);

        // Pedido
        Pedido pedido = new PedidoBuilder()
                .comCliente(cliente)
                .comTipoEntrega("Delivery")
                .comPagamento(new CartaoCredito())
                .comStatus("Recebido")
                .adicionarItem(pizza, 1)
                .adicionarItem(bebida, 2)
                .construir();

        // Observadores
        pedido.adicionarObservador(new ClienteObservador(cliente.getNome()));
        pedido.adicionarObservador(new CozinhaObservador());
        pedido.adicionarObservador(new EntregadorObservador("Carlos"));

        // Testando notificações
        pedido.atualizarStatus("Preparando");
        System.out.println();

        pedido.atualizarStatus("Pronto");
        System.out.println();

        pedido.atualizarStatus("Saiu para entrega");
        System.out.println();

        pedido.atualizarStatus("Finalizado");

    }
}
