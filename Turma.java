class Turma {
  import java.util.ArrayList;
import java.util.List;

public class Turma {

  private String identificacao;
  private Curso curso;
  private String semestre;
  private ArrayList<Professor> professores = new ArrayList<>();
  private ArrayList<Aluno> alunos = new ArrayList<>();
  private List<Log> logs = new ArrayList<>();
  Nota nota = new Nota();

  public Turma(){

  }

    public Turma(String identificacao, String Curso curso, Professor professor) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.professor = professor;
    }
      public ArrayList<Professor> getProfessores() {
    return professores;
  }

  public void setProfessores(ArrayList<Professor> professores) {
    this.professores = professores;
  }

    public void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public Professor getProfessor() {
        return professor;
    }
}

