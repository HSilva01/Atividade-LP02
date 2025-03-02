public class Curso {

    private String nome;
    private int totalSemestres;
    private Professor coordenador;

    public Curso(String nome, int totalSemestres) {
        this.nome = nome;
        this.totalSemestres = totalSemestres;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalSemestres() {
        return totalSemestres;
    }

    public void setTotalSemestres(int totalSemestres) {
        this.totalSemestres = totalSemestres;
    }

    public void definirCoordenador(Professor professor) {
        this.coordenador = professor;
        professor.setCoodernador(true);
        System.out.println("Novo coordenador atribuído: " + professor.getNome());
    }

    public Professor getCoordenador() {
        return coordenador;
    }
}
