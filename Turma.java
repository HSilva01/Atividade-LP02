import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String identificacao;
    private Curso curso;
    private String semestre;
    private List<Professor> professores = new ArrayList<>();
    private List<Estudante> estudantes = new ArrayList<>();
    private List<Log> logs = new ArrayList<>();

    public Turma(String identificacao, Curso curso, String semestre) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.semestre = semestre;
    }

    public void adicionarEstudante(Estudante estudante) {
        if (estudante != null) {
            estudantes.add(estudante);
        }
    }

    public void adicionarProfessor(Professor professor) {
        if (professor != null) {
            professores.add(professor);
        }
    }

    public void alterarNotaEstudante(Professor coordenador, Estudante estudante, double novaNota1, double novaNota2, double novaNota3) {
        if (coordenador.getCoordenador()) {
            double[] notasAnteriores = { estudante.getNota().getNota1(), estudante.getNota().getNota2(), estudante.getNota().getNota3() };
            estudante.getNota().setNota1(novaNota1);
            estudante.getNota().setNota2(novaNota2);
            estudante.getNota().setNota3(novaNota3);
            logs.add(new Log(coordenador.getNome(), notasAnteriores, new double[]{novaNota1, novaNota2, novaNota3}));
            System.out.println("Notas alteradas com sucesso!");
        } else {
            System.out.println("Somente coordenadores podem alterar notas.");
        }
    }

    public void exibirEstatisticas() {
        int aprovados = 0, reprovados = 0, recuperacao = 0;
        for (Estudante estudante : estudantes) {
            double media = estudante.getNota().calcularMedia();
            if (media >= 7) {
                aprovados++;
            } else if (media >= 2.5) {
                recuperacao++;
            } else {
                reprovados++;
            }
        }
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Em recuperação: " + recuperacao);
        System.out.println("Reprovados: " + reprovados);
    }

    public void exibirListaRecuperacao() {
        System.out.println("Estudantes em recuperação:");
        for (Estudante estudante : estudantes) {
            if (estudante.getNota().calcularMedia() >= 2.5 && estudante.getNota().calcularMedia() < 7) {
                estudante.exibirDados();
            }
        }
    }

    public void exibirLogs() {
        System.out.println("Histórico de alterações de notas:");
        for (Log log : logs) {
            log.exibirLog();
        }
    }
}
