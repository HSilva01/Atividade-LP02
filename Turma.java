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
        this.logs = new ArrayList<>();
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
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
}

public class Nota {
    private Double nota1;
    private Double nota2;
    private Double nota3;

    public Nota() {
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }

    public Nota(Double nota1, Double nota2, Double nota3) {
        this.nota1 = validarNota(nota1);
        this.nota2 = validarNota(nota2);
        this.nota3 = validarNota(nota3);
    }

    private Double validarNota(Double nota) {
        if (nota == null || nota < 0.0 || nota > 10.0) {
            return 0.0;
        }
        return nota;
    }

    public Double getNota1() {
        return this.nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = validarNota(nota1);
    }

    public Double getNota2() {
        return this.nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = validarNota(nota2);
    }

    public Double getNota3() {
        return this.nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = validarNota(nota3);
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public String verificarSituacao() {
        double media = this.calcularMedia();

        if (media < 2.5) {
            return "Reprovado";
        } else if (media < 7) {
            return "Em Recuperação";
        } else {
            return "Aprovado";
        }
    }
}

