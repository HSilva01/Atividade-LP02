class Historico {
    private String quemAlterou;
    private String estudante;
    private double notaAnterior;
    private double notaAtual;

    public Historico(String quemAlterou, String estudante, double notaAnterior, double notaAtual) {
        this.quemAlterou = quemAlterou;
        this.estudante = estudante;
        this.notaAnterior = notaAnterior;
        this.notaAtual = notaAtual;
    }

    @Override
    public String toString() {
        return "Alteração feita por: " + quemAlterou + 
               ", Estudante: " + estudante + 
               ", Nota Anterior: " + notaAnterior + 
               ", Nota Atual: " + notaAtual;
    }
}
