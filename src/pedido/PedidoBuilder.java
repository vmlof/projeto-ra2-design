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
    private List<ItemPedido> itens = new ArrayList<>();

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public String getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

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
    public PedidoBuilder adicionarItens(ItemCardapio item, int quantidade) {
        this.itens.add(new ItemPedido(item,quantidade));
        return this;
    }
    public Pedido construir() {
        return new Pedido(this);
    }

}
