package pagamento;

public class CartaoDebito implements Pagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento no cartão de débito no valor de R$ " + valor);
    }
}
