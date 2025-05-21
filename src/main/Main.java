package main;

import cardapio.BebidaFactory;
import cardapio.ItemCardapio;
import cardapio.PizzaFactory;
import pagamento.CartaoCredito;
import pagamento.Pix;
import pedido.CozinhaObservador;
import pedido.Pedido;
import pedido.PedidoBuilder;
import pedido.PedidoManager;
import pessoas.Cliente;
import pessoas.ClienteObservador;
import pessoas.EntregadorObservador;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PedidoManager pm = PedidoManager.getInstance(); // Singleton
        PizzaFactory pizzaFactory = new PizzaFactory(); // Factory
        BebidaFactory bebidaFactory = new BebidaFactory(); // Factory

        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00",
                "(11) 99999-9999", "joao@email.com", "Rua Brasil, 123");

        ItemCardapio pizzaMargherita = pizzaFactory.criarItem("pizza margherita","media",null);
        ItemCardapio sucoDeLaranja = bebidaFactory.criarItem("suco de laranja","500ml",null);

        Pedido pedido1 = new PedidoBuilder() // Builder
                .comCliente(cliente1)
                .comTipoEntrega("Delivery")
                .comPagamento(new CartaoCredito()) // Strategy
                .comStatus("recebido")
                .adicionarItem(pizzaMargherita,1)
                .adicionarItem(sucoDeLaranja,1)
                .construir();


        Cliente cliente2 = new Cliente("Maria Oliveira", "987.654.321-00",
                "(21) 88888-8888", "maria@email.com", "Rua das Flores, 456");

        ItemCardapio pizzaCalabresa = pizzaFactory.criarItem("pizza calabresa", "grande",
                List.of("queijo extra","borda recheada") ); // Decorator

        Pedido pedido2 = new PedidoBuilder()
                .comCliente(cliente2)
                .comTipoEntrega("Retirada")
                .comPagamento(new Pix())
                .comStatus("preparando")
                .adicionarItem(pizzaCalabresa, 1)
                .construir();

        // Observer
        pedido1.adicionarObservador(new ClienteObservador(cliente1.getNome()));
        pedido1.adicionarObservador(new CozinhaObservador());

        pedido2.adicionarObservador(new ClienteObservador(cliente2.getNome()));
        pedido2.adicionarObservador(new EntregadorObservador("José"));
        pedido2.adicionarObservador(new CozinhaObservador());

        pm.adicionarPedido(pedido1);
        pm.adicionarPedido(pedido2);
        pm.exibirTodosPedidos();

        System.out.println("=== Atualização de status ===");

        pm.atualizarStatusPedidoPorCpf("123.456.789-00","pronto");
        pm.atualizarStatusPedidoPorCpf("987.654.321-00","pronto");

    }
}