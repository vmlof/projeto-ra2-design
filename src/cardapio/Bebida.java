package cardapio;

public class Bebida implements ItemCardapio {
    private final String nome;
    private final double preco;
    private final String ml;

    public Bebida(String nome, double preco, String ml) {
        this.nome = nome;
        this.preco = preco;
        this.ml = ml;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return  nome + ", tamanho " + ml;
    }
}