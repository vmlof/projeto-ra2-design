package pagamento;

public class Pix implements Pagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via Pix no valor de R$ " + valor);
    }
}
