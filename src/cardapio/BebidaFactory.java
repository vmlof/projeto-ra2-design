package cardapio;

public class BebidaFactory extends ItemCardapioFactory {
    @Override
    public ItemCardapio criarItem(String tipo, String tamanho) {
        switch (tipo.toLowerCase()) {
            case "refrigerante":
                return new Bebida("Refrigerante", calcularPreco(tamanho, 1.0), tamanho);
            case "suco de laranja":
                return new Bebida("Suco de Laranja", calcularPreco(tamanho, 2.0), tamanho);
            case "água mineral":
                return new Bebida("Água Mineral", calcularPreco(tamanho, 0.0), tamanho);
            default:
                throw new IllegalArgumentException("Tipo de bebida desconhecido: " + tipo);
        }
    }

    private double calcularPreco(String tamanho, double adicionalTipo) {
        return switch (tamanho.toLowerCase()) {
            case "250ml" -> 5.0;
            case "500ml" -> 7.0;
            case "1l" ->  10.0;
            case "800ml" -> 8.0;
            default -> 6.0;
        } + adicionalTipo;
    }
}