java
package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ArrayList<Estudante> estudantes = new ArrayList<>();
    ArrayList<Professor> professores = new ArrayList<>();
    ArrayList<Curso> cursos = new ArrayList<>();
    ArrayList<Turma> turmas = new ArrayList<>();
    Nota nota = new Nota();
    
estudantes.add(new Estudante("Ana Silva", "111.111.111-11", "(11) 91111-1111", "Rua X, Bairro Y", "1111111", 8.0));
        estudantes.add(new Estudante("Bruno Mendes", "222.222.222-22", "(22) 92222-2222", "Rua W, Bairro Z", "2222222", 6.5));
        estudantes.add(new Estudante("Carla Souza", "333.333.333-33", "(33) 93333-3333", "Rua V, Bairro U", "3333333", 7.2));
        estudantes.add(new Estudante("Daniel Rocha", "444.444.444-44", "(44) 94444-4444", "Rua T, Bairro S", "4444444", 5.8));
        estudantes.add(new Estudante("Eduarda Lima", "555.555.555-55", "(55) 95555-5555", "Rua Q, Bairro R", "5555555", 9.1));
    
     professores.add(new Professor("Fernando Martins", "666.666.666-66", "(66) 96666-6666", "Rua P, Bairro O", "244576"));
        professores.add(new Professor("Gisele Andrade", "777.777.777-77", "(77) 97777-7777", "Rua N, Bairro M", "325078"));

    cursos.add(new Curso("Linguagem de programação", "3"));
    cursos.add(new Curso("Estrutura de dados", "5"));

    turmas.add(new Turma("20243", cursos.get(0), "5"));
    turmas.add(new Turma("20247", cursos.get(1), "6"));

    turmas.get(0).adicionarProfessor(professores.get(0));
    for (Estudante estudante : estudantes) {
      turmas.get(0).adicionarEstudante(estudante);
    }

    turmas.get(1).adicionarProfessor(professores.get(1));
    for (Estudante estudante : estudantes) {
      turmas.get(1).adicionarEstudante(estudante);
    }

    int opcao;
    Scanner entrada = new Scanner(System.in);

    do {
      System.out.println("╔════════════════════════════════════╗");
      System.out.println("║                MENU                ║");
      System.out.println("╠════════════════════════════════════╣");
      System.out.println("║     1 - Cadastrar um coordenador   ║");
      System.out.println("║  2 - Atribuir notas aos estudantes ║");
      System.out.println("║     3 - Mostrar a estatística      ║");
      System.out.println("║      4 - Lista de recuperação      ║");
      System.out.println("║          5 - Lista geral           ║");
      System.out.println("║           6 - Histórico            ║");
      System.out.println("║             0 - Sair               ║");
      System.out.println("╚════════════════════════════════════╝");
      System.out.print("Opção: ");
      opcao = entrada.nextInt(); 

      switch (opcao) {
        case 1:
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

        case 2:
          System.out.println("Cadastrar notas");

          for (int i = 0, totalEstudantes = estudantes.size(); i < totalEstudantes; i++) {
            Estudante estudante = estudantes.get(i);
            System.out.printf("Estudante(a): %s\n", estudante.getNome());

            System.out.print("Informe a nota 1: ");
            nota.setNota1(entrada.nextDouble());

            System.out.print("Informe a nota 2: ");
            nota.setNota2(entrada.nextDouble());

            System.out.print("Informe a nota 3: ");
            nota.setNota3(entrada.nextDouble());

            System.out.printf("Média: %.2f\n", nota.calcularMedia());
            System.out.print("Situação: ");
            nota.verificarSituacao();
          }
          break;

        case 3:
          turmas.get(0).setEstatica(); 
          System.out.println();
          turmas.get(1).setEstatica(); 
          break;

        case 4:
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

          for (Estudante estudante : turma.getEstudantes()) {
              if (nota.calcularMedia() >= 2.5 && nota.calcularMedia() < 7) {
                  System.out.print("Insira uma nota de recuperação para " + estudante.getNome() + ": ");
                  double novaNota = entrada.nextDouble();
                  turma.alterarNotaEstudante(coordenador, estudante, novaNota);
                  System.out.println("Nota de recuperação registrada.");
              }
          }
          break;

        case 5:
          turmas.get(0).exibirDados();
          System.out.println();
        
          System.out.println("Cursos:");
          for (Curso curso : cursos) {
            System.out.println("Nome do curso: " + curso.getNomeCurso() + ", Semestres: " + curso.getQtdSemestre());
          }
        
          turmas.get(1).exibirDados();
          System.out.println("Cursos:");
          for (Curso curso : cursos) {
            System.out.println("Nome do curso: " + curso.getNomeCurso() + ", Semestres: " + curso.getQtdSemestre());
          }
          break;

        case 6:
          System.out.println("Histórico de alterações dos estudantes:");
          for (Estudante estudante : estudantes) {
              estudante.exibirHistorico();
              System.out.println();
          }
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
