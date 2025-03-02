import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ArrayList<Estudante> estudantes = new ArrayList<>();
    ArrayList<Professor> professores = new ArrayList<>();
    ArrayList<Curso> cursos = new ArrayList<>();
    ArrayList<Turma> turmas = new ArrayList<>();
    ArrayList<Historico> logs = new ArrayList<>();
    Nota nota = new Nota();
    
    

    estudantes.add(new Estudante("Adam", "123.123.123-12", "(12) 91234-1234", "Av. Céu, Bairro Jardim do Éden, Número 1", "20072210001"));
    estudantes.add(new Estudante("Bart", "234.234.234-23", "(23) 92345-2345", "Av. Céu, Bairro Jardim do Éden, Número 2", "20072210002"));
    estudantes.add(new Estudante("Carl", "345.345.345-34", "(34) 93456-3456", "Av. Céu, Bairro Jardim do Éden, Número 3", "20072210003"));
    estudantes.add(new Estudante("Damian", "456.456.456-45", "(45) 94567-4567", "Av. Céu, Bairro Jardim do Éden, Número 4", "20072210004"));
    estudantes.add(new Estudante("Evan", "567.567.567-56", "(56) 95678-5678", "Av. Céu, Bairro Jardim do Éden, Número 5", "20072210005"));
    
    professores.add(new Professor("João Erudito", "987.987.987-98", "(98) 99876-9876", "Rua da Felicidade, Bairro do Sôssego, Número 100", "143143"));
    professores.add(new Professor("Maria Bibliófila", "876.876.876-87", "(87) 98765-8765", "Rua da Felicidade, Bairro do Sôssego, Número 101", "321321"));

    cursos.add(new Curso("Linguagem de programação", 3));
    cursos.add(new Curso("Estrutura de dados", 5));

    turmas.add(new Turma("20243", cursos.get(0), "5"));
    turmas.add(new Turma("20247", cursos.get(1), "6"));

    turmas.get(0).adicionarProfessor(professores.get(0));
    for (Estudante estudante : estudantes) {
      turmas.get(0).adicionarAluno(estudante);
    }

    turmas.get(1).adicionarProfessor(professores.get(1));
    for (Estudante aluno : estudantes) {
      turmas.get(1).adicionarAluno(aluno);
    }

 

    int opcao;
    Scanner entrada = new Scanner(System.in);

    do {
    
      System.out.println("MENU");
      System.out.println("1 - Histórico");
      System.out.println("2-Lista geral");
      System.out.println("2-Atribuir notas aos estudantes");
      System.out.println("3-Mostrar a estatística");
      System.out.println("4-Lista de recuperação");
      System.out.println("6-Cadastrar um coordenador");
      System.out.println("0 - Sair");
      System.out.print("Opção: ");
      opcao = entrada.nextInt(); 

      switch (opcao) {
        case 1:
        System.out.println("Histórico de alterações dos alunos:");
        for (Estudante estudante: estudantes) {
          estudante.exibirHistorico();
            System.out.println();
        }
    break;

    case 2:
    turmas.get(0).exibirDados();
    System.out.println();

    System.out.println("Cursos:");
    for (Curso curso : cursos) {
      System.out.println("Nome do curso: " + curso.getNome() + ", Semestres: " + curso.getTotalSemestres());
    }

    turmas.get(1).exibirDados();
    System.out.println("Cursos:");
    for (Curso curso : cursos) {
      System.out.println("Nome do curso: " + curso.getNome() + ", Semestres: " + curso.getTotalSemestres());
    }
    break;
          
  case 3:
  System.out.println("Cadastrar notas");

   for (int i = 0, totalAlunos = estudantes.size(); i < totalAlunos; i++) {
    Estudante estudante = estudantes.get(i);
    System.out.printf("Aluno(a): %s\n", estudante.getNome());

    System.out.print("Informe a primeira nota: ");
        nota.setNota1(entrada.nextDouble());

        System.out.print("Informe a segunda nota: ");
        nota.setNota2(entrada.nextDouble());

        System.out.print("Informe a terceira nota: ");
        nota.setNota3(entrada.nextDouble());

        System.out.printf(" A Média do aluno é: %.2f\n", nota.calcularMedia());
        System.out.print("Situação: ");
        nota.verificarSituacao();
    }
 break;
         
    case 4:

          turmas.get(0).setEstatica(); 
          System.out.println();
          turmas.get(1).setEstatica(); 
            
            break;

          case 5:
          System.out.println("Lista de recuperação");
          System.out.println("Escolha a turma para listar alunos em recuperação:");
          for (int i = 0; i < turmas.size(); i++) {
              System.out.println((i + 1) + " - Turma: " + turmas.get(i).getIdentificacao());
          }
          int turmaEscolhida = entrada.nextInt();
          if (turmaEscolhida < 1 || turmaEscolhida > turmas.size()) {
              System.out.println("Turma inválida!");
              break;
          }
      
          Turma turma = turmas.get(turmaEscolhida - 1);
      
          System.out.println("Escolha o coordenador para alterar as notas:");
          for (Professor professor : professores) {
              if (professor.getCoordenador()) {
                  System.out.println("Coordenador disponível: " + professor.getNome());
              }
          }
      
          Professor coordenador = null;
          for (Professor professor : professores) {
              if (professor.getCoordenador()) {
                  coordenador = professor;
                  break;
              }
          }
      
          if (coordenador == null) {
              System.out.println("Nenhum coordenador está disponível.");
              break;
          }
      
          for (Estudante estudante : turma.getAlunos()) {
              if (nota.calcularMedia() >= 2.5 && nota.calcularMedia() < 7) {
                  System.out.print("Insira uma nota de recuperação para " + estudante.getNome() + ": ");
                  double novaNota = entrada.nextDouble();
                  turma.alterarNotaEstudante(coordenador, estudante, novaNota);
                  System.out.println("Nota de recuperação registrada.");
              }
          }
          break;
      
            case 6:
            System.out.println("Lista de professores:");
            for (int i = 0; i < professores.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, professores.get(i).getNome());
            }
        
            System.out.print("Escolha o professor para vincular como coordenador: ");
            int escolha = entrada.nextInt();
        
            if (escolha < 1 || escolha > professores.size()) {
                System.out.println("Escolha inválida.");
                break;
            }
        
            Professor professorEscolhido = professores.get(escolha - 1);
        
           
            professorEscolhido.setCoodernador(true);
            System.out.println(professorEscolhido.getNome() + " agora é o coordenador.");
            break;
          case 0:
            System.out.println("Saindo...");
            break;
          default:
            System.out.println("Opção inválida!");
        }
      } while (opcao != 0);
    entrada.close();
  }
}