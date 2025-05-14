package pedido;

import cardapio.ItemCardapio;
import pagamento.Pagamento;
import pessoas.*;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private  Pessoa cliente;
    private String tipoEntrega;
    private Pagamento pagamento;
    private String status;
    private  List<PedidoObserver> observadores = new ArrayList<>();
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(PedidoBuilder builder) {
        this.cliente = builder.getCliente();
        this.tipoEntrega = builder.getTipoEntrega();
        this.pagamento = builder.getPagamento();
        this.status = builder.getStatus();
        this.itens = builder.getItens();
    }


    public void adicionarItem(ItemCardapio item, int quantidade) {
        itens.add(new ItemPedido(item, quantidade));
    }

    public void setFormaPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void realizarPagamento() {
        if (pagamento != null) {
            pagamento.pagar(calcularTotal());
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
        System.out.println("Contato: " + cliente.getTelefone() + ", " + cliente.getEmail());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Entrega: " + tipoEntrega);
        System.out.println("Itens:");

        for (ItemPedido ip : itens) {
            System.out.println(ip);
        }

        System.out.printf("Total: R$%.2f%n", calcularTotal());
        System.out.println("Pagamento: " + (pagamento != null ? pagamento.getClass().getSimpleName() : "Não definido"));
    }
}
