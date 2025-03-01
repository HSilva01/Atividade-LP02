import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String identificacao;
    private Curso curso;
    private String semestre;
    private final List<Professor> professores;
    private final List<Estudante> estudantes;
    private final List<Log> logs;

    public Turma(String identificacao, Curso curso, String semestre) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.semestre = semestre;
        this.professores = new ArrayList<>();
        this.estudantes = new ArrayList<>();
        this.logs = new ArrayList<>();
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void adicionarProfessor(Professor professor) {
        if (professor != null) {
            professores.add(professor);
        }
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void adicionarEstudante(Estudante estudante) {
        if (estudante != null) {
            estudantes.add(estudante);
        }
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void adicionarLog(Log log) {
        if (log != null) {
            logs.add(log);
        }
    }

    public void alterarNotaEstudante(Professor coordenador, Estudante estudante, double novaNota) {
        if (coordenador.isCoordenador()) {
            System.out.println("Notas alteradas com sucesso para " + estudante.getNome());
        } else {
            System.out.println("Somente coordenadores podem alterar notas.");
        }
    }

    public void exibirDados() {
        System.out.println("Turma: " + identificacao);
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Semestre: " + semestre);
        System.out.println("Professores:");
        for (Professor professor : professores) {
            professor.exibirDados();
        }
        System.out.println("Estudantes:");
        for (Estudante estudante : estudantes) {
            estudante.exibirDados();
        }
    }
}

