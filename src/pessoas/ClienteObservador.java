package pessoas;

import pedido.PedidoObserver;

public class ClienteObservador implements PedidoObserver {
    private String nome;

    public ClienteObservador(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String status) {
        System.out.println("[Cliente: " + nome + "] Pedido agora está: " + status);
    }
}
