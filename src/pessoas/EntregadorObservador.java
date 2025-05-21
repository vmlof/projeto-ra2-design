package pessoas;

import pedido.PedidoObserver;

public class EntregadorObservador implements PedidoObserver {
    private final String nome;

    public EntregadorObservador(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String status) {
        if (status.equalsIgnoreCase("Pronto") || status.equalsIgnoreCase("Saiu para entrega")) {
            System.out.println("- Entregador(" + nome + "): Pedido está pronto para ser retirado.");
        }
    }
}
