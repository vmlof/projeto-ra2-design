package pedido;

public class CozinhaObservador implements PedidoObserver {
    @Override
    public void atualizar(String status) {
        switch(status.toLowerCase()) {
            case "recebido" -> System.out.println("- Cozinha: Novo pedido recebido. Iniciar preparo.");
            case "preparando" -> System.out.println("- Cozinha: Pedido está sendo preparado.");
            case "pronto" -> System.out.println("- Cozinha: Pedido pronto para retirada.");
            case "saiu para entrega" -> System.out.println("- Cozinha: Pedido saiu para entrega.");
            case "finalizado" -> System.out.println("- Cozinha: Pedido finalizado.");
            default -> System.out.println("- Cozinha: Novo status de pedido: " + status);
        }
    }
}
