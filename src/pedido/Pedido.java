package pedido;

import cardapio.ItemCardapio;
import pagamento.Pagamento;
import pessoas.*;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private  final Pessoa cliente;
    private final String tipoEntrega;
    private final List<ItemPedido> itens;
    private Pagamento pagamento; // Strategy
    private String status;
    private  List<PedidoObserver> observadores = new ArrayList<>();

    public Pedido(PedidoBuilder builder) {
        this.cliente = builder.getCliente();
        this.tipoEntrega = builder.getTipoEntrega();
        this.pagamento = builder.getPagamento();
        this.status = builder.getStatus() != null ? builder.getStatus() : "Recebido";
        this.itens = new ArrayList<>(builder.getItens());
    }

    public int getQuantidadeTotalItens() {
        int total = 0;
        for (ItemPedido item : itens) {
            total += item.getQuantidade();
        }
        return total;
    }

    public Pessoa getCliente() {return cliente;}

    public void adicionarItem(ItemCardapio item, int quantidade) {
        itens.add(new ItemPedido(item, quantidade));
    }

    public void setFormaPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    } // Strategy

    public void realizarPagamento() {
        if (pagamento != null) {
            pagamento.pagar(calcularTotal()); // Strategy
        } else {
            System.out.println("Forma de pagamento não definida.");
        }
    }

    public void adicionarObservador(PedidoObserver observer) {
        observadores.add(observer);
    }

    public void removerObservador(PedidoObserver observer) {
        observadores.remove(observer);
    }

    private void notificarObservadores() {
        for (PedidoObserver observer : observadores) {
            observer.atualizar(status);
        }
    }

    public void atualizarStatus(String novoStatus) {
        if (novoStatus != null && !novoStatus.equals(this.status)) {
            this.status = novoStatus;
            System.out.println("Status do pedido atualizado para: " + status);
            notificarObservadores();
        }
    }

    public String getStatus() {
        return status;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido ip : itens) {
            total += ip.getSubtotal();
        }
        return total;
    }

    public void exibir() {
        System.out.println("Cliente: " + cliente.getNome() + " (" + cliente.getCpf() + ")");
        System.out.println("Contato: " + cliente.getEmail() + ", " + cliente.getTelefone());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Entrega: " + tipoEntrega);
        System.out.println("Itens:");

        if (itens.isEmpty()) {
            System.out.println("  Nenhum item no pedido");
        } else {
            for (ItemPedido ip : itens) {
                System.out.println("  " + ip.toString());
            }
        }
        System.out.printf("Total: R$%.2f%n", calcularTotal());
        System.out.println("Status: " + status);
        System.out.println("Pagamento: " + (pagamento != null ? pagamento.getClass().getSimpleName() : "Não definido"));
    }
}
