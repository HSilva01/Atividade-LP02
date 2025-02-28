import java.util.ArrayList;
import java.util.List;

public class Turma {

  
    private String identificacao;
    private Curso curso;
    private String semestre;
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Estudante> estudantes = new ArrayList<>();
    private List<Log> logs = new ArrayList<>();
    Nota nota = new Nota();
      
    
      public Turma(){
    
      }
    
        public Turma(String identificacao, Curso curso, String semestre) {
            this.identificacao = identificacao;
            this.curso = curso;
            this.semestre = semestre;
            this.logs = new ArrayList<>();
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
  
      public ArrayList<Estudante> getEstudantes() {
          return estudantes;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public ArrayList<Professor> getProfessor() {
        return professores;
    }
}
public class CalculadoraNotas {
    public static double calcularMedia(double[] notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return notas.length > 0 ? soma / notas.length : 0;
    }
    
     static String verificarSituacao(double media) {
             if (media >= 7) {
                 return "Aprovado";
             } else if (media >= 5) {
                 return "Em Recuperação";
             } else {
                 return "Reprovado";
             }
         }
         
         public static void main(String[] args) {
             double[] notas = {7.5, 8.0, 6.5};
             double media = calcularMedia(notas);
             System.out.println("Média: " + media);
             System.out.println("Situação: " + verificarSituacao(media));
    }
}


public void alterarNotaEstudante(Professor coordenador, Estudante estudante, double novaNota) {
    if (coordenador.getCoordenador()) {
        double[] notasAnteriores = 
          Nota.getNota1().clone();
          Nota.getNota2().clone();
          Nota.getNota3().clone();
        
        double[] novasNotas = {novaNota, novaNota, novaNota};
        estudante.setNotas(novasNotas);
    } else {
        System.out.println("Somente coordenadores podem alterar notas");
    }
}

public void exibirDados(Turma turma) {
    System.out.println("Turma: " + turma.getIdentificacao());
    System.out.println("Professores:");
    for (Professor professor : turma.getProfessores()) {
        professor.exibirDados();
    }
    System.out.println("Estutante:");
    for (Estudante estudante : turma.getEstudantes()) {
        estudante.exibirDados();
    }
}

