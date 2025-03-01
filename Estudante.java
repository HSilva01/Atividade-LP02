public class Estudante extends Pessoa implements Printable {
    private String matricula;
    


    public Estudante(String nomeEstudante, String cpfEstudante, String telefoneEstudante, String enderecoEstudante,
        String matricula2) {
          super(nomeEstudante, cpfEstudante, telefoneEstudante, enderecoEstudante);
          this.matricula = matricula;
    }



    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

  
    public void exibirDados() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Matrícula: " + this.matricula);
       
    }
}

