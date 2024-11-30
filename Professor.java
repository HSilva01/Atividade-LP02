class Professor {
    private String nome;
    private boolean isCoordenador;

    public Professor(String nome, boolean isCoordenador) {
        this.nome = nome;
        this.isCoordenador = isCoordenador;
    }

    public String getNome() {
        return nome;
    }

    public boolean isCoordenador() {
        return isCoordenador;
    }
}
