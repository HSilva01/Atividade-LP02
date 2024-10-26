abstract class Pessoa implements Printable {
    protected final String nome;
    protected final String cpf;
    protected final String endereco;
    protected final String telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void print() {
        System.out.printf("Nome: %s%nCPF: %s%nEndereço: %s%nTelefone: %s%n", nome, cpf, endereco, telefone);
    }
}

