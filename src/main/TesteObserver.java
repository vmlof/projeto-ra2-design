package main;

import cardapio.BebidaFactory;
import cardapio.ItemCardapio;
import cardapio.PizzaFactory;
import pagamento.CartaoCredito;
import pedido.Pedido;
import pedido.PedidoBuilder;
import pessoas.Cliente;
import pessoas.ClienteObservador;

public class TesteObserver {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        BebidaFactory bebidaFactory = new BebidaFactory();

        // Cliente
        Cliente cliente = new Cliente("João Silva", "123.456.789-00",
                "(11) 99999-9999", "joao@email.com", "Rua Exemplo, 123");

        // Cliente também será observador
        ClienteObservador clienteObservador = new ClienteObservador(cliente.getNome());

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

        // Registrar observador
        pedido.adicionarObservador(clienteObservador);

        // Exibir pedido
        pedido.exibir();

        // Atualizar status do pedido (isso aciona a notificação)
        pedido.atualizarStatus("Preparando");
        pedido.atualizarStatus("Saiu para entrega");
        pedido.atualizarStatus("Finalizado");
    }
}
