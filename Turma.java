import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String identificacao;
    private Curso curso;
    private String semestre;
    private List<Professor> professores = new ArrayList<>();
    private List<Estudante> estudantes = new ArrayList<>();
    private List<Log> logs = new ArrayList<>();

    public Turma() {}

    public Turma(String identificacao, Curso curso, String semestre) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.semestre = semestre;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        if (professores != null) {
            this.professores = professores;
        }
    }

    public void adicionarEstudante(Estudante estudante) {
        if (estudante != null) {
            estudantes.add(estudante);
        }
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
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

    public void alterarNotaEstudante(Professor coordenador, Estudante estudante, double novaNota) {
        if (coordenador.getCoordenador()) {
            Nota nota = estudante.getNome(); 
            if (nota != null) {
                double[] notasAnteriores = {
                    nota.getNota1(),
                    nota.getNota2(),
                    nota.getNota3()
                };

                nota.setNota1(novaNota);
                nota.setNota2(novaNota);
                nota.setNota3(novaNota);

                System.out.println("Notas alteradas com sucesso!");
            } else {
                System.out.println("Estudante não possui notas cadastradas.");
            }
        } else {
            System.out.println("Somente coordenadores podem alterar notas.");
        }
    }

    public void exibirDados() {
        System.out.println("Turma: " + identificacao);
        System.out.println("Professores:");
        for (Professor professor : professores) {
            professor.exibirDados();
        }
        System.out.println("Estudantes:");
        for (Estudante estudante : estudantes) {
            estudante.exibirDados();
        }
    }

    public void adicionarProfessor(Professor professor) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'adicionarProfessor'");
    }
}
