package pedido;

import java.util.ArrayList;
import java.util.List;

public class CentralDePedidos {

    private static CentralDePedidos instancia;
    private final List<Pedido> pedidos = new ArrayList<>();

    private CentralDePedidos() {

    }

    public static CentralDePedidos getInstancia() {
        if (instancia == null) {
            instancia = new CentralDePedidos();
        }
        return instancia;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.adicionarObservador(new CentralDePedidosObserver());
    }

     class CentralDePedidosObserver implements PedidoObserver {
        @Override
        public void atualizar(String status) {
            System.out.println("[Central] Pedido atualizado para: " + status);
        }
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }

    public void listarPedidos() {
        for (Pedido p : pedidos) {
            p.exibir();
            System.out.println("----------------------");
        }
    }

    public List<Pedido> buscarPorStatus(String status) {
        List<Pedido> encontrados = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (status.equalsIgnoreCase(p.getStatus())) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }
}
