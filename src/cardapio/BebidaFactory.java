package cardapio;

import java.util.List;

public class BebidaFactory extends ItemCardapioFactory {
    @Override
    public ItemCardapio criarItem(String tipo, String tamanho, List<String> adicionais) {
        switch (tipo.toLowerCase()) {
            case "refrigerante" -> new Bebida("Refrigerante", calcularPreco(tamanho), tamanho);
            case "suco de laranja" -> new Bebida("Suco de Laranja", calcularPreco(tamanho), tamanho);
            case "água mineral" -> new Bebida("Água Mineral", calcularPreco(tamanho), tamanho);
            default -> throw new IllegalArgumentException("Tipo de bebida desconhecido: " + tipo);
        };
        return new Bebida("refrigerante", calcularPreco(tamanho), tamanho);
    }

    private double calcularPreco(String tamanho) {
        return switch (tamanho.toLowerCase()) {
            case "250ml" -> 5.0;
            case "500ml" -> 7.0;
            case "1l" ->  10.0;
            case "800ml" -> 8.0;
            default -> 6.0;
        };
    }
}