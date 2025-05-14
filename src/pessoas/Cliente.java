package pessoas;

import java.time.LocalDate;

public class Cliente  extends Pessoa{
    private final LocalDate dataCadastro;

    public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
        super(nome, cpf, email, telefone, endereco);
        this.dataCadastro = LocalDate.now();
    }
    @Override
    public String toString() {
        return super.getNome() + " " + super.getCpf() + " " + super.getEmail() + " " + super.getTelefone() + " " + dataCadastro.toString();
    }
}
