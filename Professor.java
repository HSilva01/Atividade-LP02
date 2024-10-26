class Professor extends Pessoa {
    private final int siape;

    public Professor(String nome, String cpf, String endereco, String telefone, int siape) {
        super(nome, cpf, endereco, telefone);
        this.siape = siape;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("SIAPE: %d%n", siape);
    }
}
