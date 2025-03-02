public class Estudante extends Pessoa {
    private String matricula;
    private final Nota nota;

    public Estudante(String nome, String cpf, String telefone, String endereco, String matricula) {
        super(nome, cpf, telefone, endereco);
        this.matricula = matricula;
        this.nota = new Nota(); // Criando um objeto Nota para armazenar as notas do estudante
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(double nota1, double nota2, double nota3) {
        this.nota.setNota1(nota1);
        this.nota.setNota2(nota2);
        this.nota.setNota3(nota3);
    }

    public double calcularMedia() {
        return nota.calcularMedia(); // Chama o método da classe Nota para calcular a média
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Matrícula: " + matricula);
        System.out.println("Notas: " + nota.getNota1() + ", " + nota.getNota2() + ", " + nota.getNota3());
        System.out.println("Média: " + calcularMedia());
        nota.verificarSituacao(); // Exibe a situação do aluno com base na média
    }
}
