package pessoas;

public class Pessoa {
    private final String nome, cpf, email, telefone, endereco;

    public Pessoa(String nome, String cpf, String email, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public String getEmail() {return email;}
    public String getTelefone() {return telefone;}
    public String getEndereco() {return endereco;}

    @Override
    public String toString() {
        return nome + " " + cpf + " " + email + " " + telefone + " " + endereco;
    }
}
