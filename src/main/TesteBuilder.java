package main;

import cardapio.BebidaFactory;
import cardapio.ItemCardapio;
import cardapio.PizzaFactory;
import pagamento.CartaoCredito;
import pedido.Pedido;
import pedido.PedidoBuilder;
import pedido.PedidoManager;
import pessoas.Cliente;

import java.util.List;

public class TesteBuilder {
    public static void main(String[] args) {
        PedidoManager pm = PedidoManager.getInstance(); // Singleton
        PizzaFactory pizzaFactory = new PizzaFactory();
        BebidaFactory bebidaFactory = new BebidaFactory();

        // Cliente 1
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00",
                "(11) 99999-9999", "joao@email.com", "Rua Exemplo, 123");

        ItemCardapio pizzaMargherita = pizzaFactory.criarItem("pizza", "media", null);
        ItemCardapio refrigerante = bebidaFactory.criarItem("refrigerante", "800ml", null);

        Pedido pedido1 = new PedidoBuilder()
                .comCliente(cliente1)
                .comTipoEntrega("Delivery")
                .comPagamento(new CartaoCredito())
                .comStatus("Preparando")
                .adicionarItem(pizzaMargherita, 1)
                .adicionarItem(refrigerante, 2)
                .construir();

        // Cliente 2
        Cliente cliente2 = new Cliente("Maria Oliveira", "987.654.321-00",
                "(21) 88888-8888", "maria@email.com", "Rua das Flores, 456");

        ItemCardapio pizzaCalabresa = pizzaFactory.criarItem("pizza", "grande", null);

        Pedido pedido2 = new PedidoBuilder()
                .comCliente(cliente2)
                .comTipoEntrega("Retirada")
                .comPagamento(new CartaoCredito())
                .comStatus("Finalizado")
                .adicionarItem(pizzaCalabresa, 1)
                .construir();

        // Adicionando pedidos
        pm.adicionarPedido(pedido1);
        pm.adicionarPedido(pedido2);

        // Exibindo todos os pedidos
        System.out.println("=== TODOS OS PEDIDOS ===");
        pm.exibirTodosPedidos();

        // Buscar por CPF
        System.out.println("\n=== PEDIDOS DE JOÃO ===");
        List<Pedido> pedidosJoao = pm.buscarPedidosPorCpf("123.456.789-00");
        for (Pedido p : pedidosJoao) {
            p.exibir();
        }

        // Buscar por status
        System.out.println("\n=== PEDIDOS FINALIZADOS ===");
        List<Pedido> pedidosFinalizados = pm.buscarPedidosPorStatus("Finalizado");
        for (Pedido p : pedidosFinalizados) {
            p.exibir();
        }

        // Atualizar status de João
        System.out.println("\n=== ATUALIZANDO STATUS DO PEDIDO DE JOÃO ===");
        boolean atualizado = pm.atualizarStatusPedidoPorCpf("123.456.789-00", "Em entrega");
        if (atualizado) {
            System.out.println("Status atualizado com sucesso!");
        } else {
            System.out.println("Pedido não encontrado.");
        }

        // Exibir novamente todos os pedidos
        System.out.println("\n=== PEDIDOS APÓS ATUALIZAÇÃO ===");
        pm.exibirTodosPedidos();

        // Remover pedidos finalizados
        System.out.println("\n=== REMOVENDO PEDIDOS FINALIZADOS ===");
        pm.removerPedidosFinalizados();

        // Exibir pedidos restantes
        System.out.println("\n=== PEDIDOS RESTANTES ===");
        pm.exibirTodosPedidos();
    }
}
