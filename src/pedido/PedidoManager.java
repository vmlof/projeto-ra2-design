package pedido;

import java.util.ArrayList;
import java.util.List;

// Padrão Singleton
public class PedidoManager {
    private static PedidoManager instance;
    private final List<Pedido> pedidos;

    private PedidoManager() {
        pedidos = new ArrayList<Pedido>();
    }

    public static PedidoManager getInstance() {
        if (instance == null) {
            instance = new PedidoManager();
        }
        return instance;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }

    public void exibirTodosPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }
        for (Pedido pedido : pedidos) {
            pedido.exibir();
            System.out.println("----------------------------");
        }
    }

    public Pedido buscarPedidoPorCliente(String cpf) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getCpf().equals(cpf)) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> buscarPedidosPorCpf(String cpf) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getCpf().equals(cpf)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public List<Pedido> buscarPedidosPorStatus(String status) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus().equalsIgnoreCase(status)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public void removerPedidosFinalizados() {
        List<Pedido> finalizados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus().equalsIgnoreCase("Finalizado")) {
                finalizados.add(pedido);
            }
        }
        pedidos.removeAll(finalizados);
    }

    public boolean atualizarStatusPedidoPorCpf(String cpf, String novoStatus) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getCpf().equals(cpf)) {
                pedido.atualizarStatus(novoStatus);
                return true;
            }
        }
        return false;
    }
}
