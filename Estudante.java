public class Estudante extends Pessoa implements Printable {
private String matricula;

 
  public Estudante(String nome, String cpf, String telefone, String endereco, String matricula) {
      super(nome, cpf, telefone, endereco);
   
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

  public void exibirHistorico() {
    System.out.println("Histórico do Estudante " + this.getNome() + ":");
  }
}