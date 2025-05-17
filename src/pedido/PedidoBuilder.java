package pedido;

import cardapio.ItemCardapio;
import pagamento.Pagamento;
import pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {
    private Pessoa cliente;
    private String tipoEntrega;
    private Pagamento pagamento;
    private String status;
    private final List<ItemPedido> itens = new ArrayList<>();

    public PedidoBuilder comCliente(Pessoa cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder comTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
        return this;
    }

    public PedidoBuilder comPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
        return this;
    }

    public PedidoBuilder comStatus(String status) {
        this.status = status;
        return this;
    }

    public PedidoBuilder adicionarItem(ItemCardapio item, int quantidade) {
        if (item == null) throw new IllegalArgumentException("Item não pode ser nulo");

        this.itens.add(new ItemPedido(item,quantidade));
        return this;
    }

    public PedidoBuilder adicionarItens(List<ItemPedido> itens) {
        this.itens.addAll(itens);
        return this;
    }

    public Pedido construir() {
        validar();
        return new Pedido(this);
    }

    private void validar() {
        if (cliente == null) throw new NullPointerException("Cliente é obrigatório");
        if (pagamento == null) throw new NullPointerException("Forma de pagamento é obrigatória");
        if (itens == null || itens.isEmpty()) throw new IllegalStateException("Pedido deve ter pelo menos um item");
    }

    Pessoa getCliente() { return cliente;}
    String getTipoEntrega() { return tipoEntrega;}
    Pagamento getPagamento() { return pagamento;}
    String getStatus() { return status;}
    List<ItemPedido> getItens() {return new ArrayList<>(itens); }

}
