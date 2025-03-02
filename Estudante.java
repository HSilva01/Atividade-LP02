public class Estudante extends Pessoa {

    private String matricula;

    public Estudante(String nome, String cpf, String telefone, String endereco, String matricula) {
        super(nome, cpf, telefone, endereco);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double calcularMedia() {
        return 0.0; // A lógica de cálculo ficará dentro da classe Turma
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Matrícula: " + matricula);
    }
