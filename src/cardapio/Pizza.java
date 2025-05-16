package cardapio;

public class Pizza implements ItemCardapio {
    private final String nome;
    private final double preco;
    private final String tamanho;

    public Pizza(String nome, double preco, String tamanho) {
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    @Override
    public String getNome() {
        return nome + " (" + tamanho + ")";
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return "Pizza " + nome + ", tamanho " + tamanho;
    }
}