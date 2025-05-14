package main;

import cardapio.ItemCardapio;
import cardapio.ItemCardapioFactory;
import pagamento.Pix;
import pedido.*;
import pessoas.Cliente;
import pessoas.ClienteObservador;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Factory Pattern - Criação de itens do cardápio
        List<String> adicionais = new ArrayList<>();
        adicionais.add("queijo extra");
        adicionais.add("borda recheada");

        ItemCardapio pizza = ItemCardapioFactory.criarItem("pizza", "Pizza Margherita", 25.0, "Grande", adicionais);
        ItemCardapio bebida = ItemCardapioFactory.criarItem("bebida", "Coca-Cola", 5.0, "Lata", null);

        System.out.println("Itens do Cardápio Criados:");
        System.out.println("- " + pizza.getNome() + " (R$" + pizza.getPreco() + ")");
        System.out.println("- " + bebida.getNome() + " (R$" + bebida.getPreco() + ")");
        System.out.println();

        // 2. Builder Pattern - Criação do pedido
        Cliente cliente = new Cliente("João Silva", "12345678900", "joao@gmail.com", "999999999", "Rua das Flores");

        Pedido pedido = new PedidoBuilder()
                .comCliente(cliente)
                .comTipoEntrega("Delivery")
                .comPagamento(new Pix())
                .comStatus("Criado")
                .adicionarItens(pizza, 1)
                .adicionarItens(bebida, 2)
                .construir();

        System.out.println("Pedido criado para: " + cliente.getNome());
        System.out.println();

        // 3. Observer Pattern - Configuração
        // Cria observador do cliente
        ClienteObservador clienteObservador = new ClienteObservador(cliente.getNome());
        pedido.adicionarObservador(clienteObservador);

        // Adiciona pedido à central (que também observa)
        CentralDePedidos central = CentralDePedidos.getInstancia();
        central.adicionarPedido(pedido);

        // 4. Simulação do fluxo do pedido
        System.out.println("Atualizando status do pedido:");
        pedido.atualizarStatus("Preparando");
        pedido.atualizarStatus("A caminho");
        pedido.atualizarStatus("Entregue");
        System.out.println();

        // 5. Exibir informações do pedido
        System.out.println("Resumo do Pedido:");
        pedido.exibir();
        System.out.println();

        // 6. Realizar pagamento
        System.out.println("Processando pagamento:");
        pedido.realizarPagamento();
    }
}