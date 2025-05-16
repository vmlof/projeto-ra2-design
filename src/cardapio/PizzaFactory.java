package cardapio;

public class PizzaFactory extends ItemCardapioFactory {
    @Override
    public ItemCardapio criarItem(String tipo, String tamanho) {
        switch (tipo.toLowerCase()) {
            case "margherita":
                return new Pizza("Margherita", calcularPreco(tamanho, 5.0), tamanho);
            case "pepperoni":
                return new Pizza("Pepperoni", calcularPreco(tamanho, 1.0), tamanho);
            case "vegetariana":
                return new Pizza("Vegetariana", calcularPreco(tamanho, 0.0), tamanho);
            default:
                throw new IllegalArgumentException("Tipo de pizza desconhecido: " + tipo);
        }
    }

    private double calcularPreco(String tamanho, double adicionalTipo) {
        double precoBase = switch (tamanho.toLowerCase()) {
            case "pequena" -> 25.0;
            case "media" -> 35.0;
            case "grande" -> 50.0;
            default -> 30.0;
        };
        return precoBase + adicionalTipo;
    }
}