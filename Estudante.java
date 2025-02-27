public class Estudante extends Pessoa implements Printable {
    private String nome;
private String matricula;
    
    public Estudante(String Estutante) {
        this.estudante = estutante;
    }
public String getEstudante(){
return  this.Estudante;


public void setEstudante(String Estudante) {
this.Estundante =Estudante;

    public Matricula(String nome) {
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
    System.out.println("Endereço: " + this.getEndereco());
    System.out.println("Telefone: " + this.getTelefone());
    System.out.println("Matrícula: " + this.matricula);
  }

  public void exibirHistorico() {
    System.out.println("Histórico do aluno " + this.getNome() + ":");
  }
}
