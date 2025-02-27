public class Pessoa implements IPrintable {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getter para o nome
    public String getNome() {
        return nome;
    }

    // Setter para o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o CPF
    public String getCpf() {
        return cpf;
    }

    // Setter para o CPF
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter para o endereço
    public String getEndereco() {
        return endereco;
    }

    // Setter para o endereço
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Getter para o telefone
    public String getTelefone() {
        return telefone;
    }

    // Setter para o telefone
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void printInfo() {
        System.out.println(getClass().getSimpleName() + " " + nome + " - Cpf: " + cpf + " - End.: " + endereco + " - Tel.: " + telefone);
    }
}
