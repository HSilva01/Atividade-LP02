public class Historico {

    private double[] notasAnteriores;
    private double[] notasAtuais;
    private String coordenador;

    public Historico(String coordenador, double[] notasAnteriores, double[] notasAtuais) {
        this.coordenador = coordenador;
        this.notasAnteriores = notasAnteriores;
        this.notasAtuais = notasAtuais;
    }

    public double[] getNotasAtuais() {
        return notasAtuais;
    }

    public void setNotasAtuais(double[] notasAtuais) {
        this.notasAtuais = notasAtuais;
    }

    public double[] getNotasAnteriores() {
        return notasAnteriores;
    }

    public void setNotasAnteriores(double[] notasAnteriores) {
        this.notasAnteriores = notasAnteriores;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public void exibirLog() {
        System.out.println("Coordenador responsável: " + coordenador);
        System.out.print("Notas anteriores: ");
        for (double nota : notasAnteriores) {
            System.out.printf("%.2f ", nota);
        }
        System.out.println();
        System.out.print("Notas atuais: ");
        for (double nota : notasAtuais) {
            System.out.printf("%.2f ", nota);
        }
        System.out.println();
    }
}
