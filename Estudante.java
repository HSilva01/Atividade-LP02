class Estudante extends Pessoa {
    private final String matricula;

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("Matrícula: %s%n", matricula);
    }
}
