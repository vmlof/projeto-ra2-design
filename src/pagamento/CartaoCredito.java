package pagamento;
// Padrão Strategy
public class CartaoCredito implements Pagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento no cartão de crédito no valor de R$ " + valor);
    }
}
