package pessoas;

public class ClienteFactory {
    public static Pessoa criarCliente(String nome, String cpf, String email, String telefone, String endereco) {
        return new Cliente(nome, cpf, email, telefone, endereco);
    }
}
