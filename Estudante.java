public class Estudante extends Pessoa implements Printable {
    private String matricula;
    private double nota; 

    public Estudante(String nomeEstudante, String cpfEstudante, String telefoneEstudante, String enderecoEstudante, String matricula, double nota) {
        super(nomeEstudante, cpfEstudante, telefoneEstudante, enderecoEstudante);
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Nota: " + this.nota);
    }
}

