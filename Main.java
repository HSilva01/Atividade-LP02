import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Estudante> estudantes = new ArrayList<>();
            ArrayList<Professor> professores = new ArrayList<>();
            ArrayList<Curso> cursos = new ArrayList<>();
            ArrayList<Turma> turmas = new ArrayList<>();
            
            // Criando alguns dados iniciais
            estudantes.add(new Estudante("Ana Silva", "111.111.111-11", "(11) 91111-1111", "Rua X, Bairro Y", "1111111", 8.0));
            professores.add(new Professor("Fernando Martins", "666.666.666-66", "(66) 96666-6666", "Rua P, Bairro O", "244576"));
            cursos.add(new Curso("Matemática Aplicada", 4));
            turmas.add(new Turma("20245", cursos.get(0), "4"));
            
            int opcao;
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Adicionar Estudante");
                System.out.println("2. Adicionar Professor");
                System.out.println("3. Adicionar Curso");
                System.out.println("4. Adicionar Turma");
                System.out.println("5. Exibir Turmas");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome do estudante: ");
                        String nomeEstudante = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpfEstudante = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefoneEstudante = scanner.nextLine();
                        System.out.print("Endereço: ");
                        String enderecoEstudante = scanner.nextLine();
                        System.out.print("Matrícula: ");
                        String matricula = scanner.nextLine();
                        System.out.print("Nota: ");
                        double nota = scanner.nextDouble();
                        scanner.nextLine();
                        
                        estudantes.add(new Estudante(nomeEstudante, cpfEstudante, telefoneEstudante, enderecoEstudante, matricula, nota));
                        System.out.println("Estudante adicionado com sucesso!");
                    }
                        
                    case 2 -> {
                        System.out.print("Nome do professor: ");
                        String nomeProfessor = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpfProfessor = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefoneProfessor = scanner.nextLine();
                        System.out.print("Endereço: ");
                        String enderecoProfessor = scanner.nextLine();
                        System.out.print("SIAPE: ");
                        String siape = scanner.nextLine();
                        
                        professores.add(new Professor(nomeProfessor, cpfProfessor, telefoneProfessor, enderecoProfessor, siape));
                        System.out.println("Professor adicionado com sucesso!");
                    }
                        
                    case 3 -> {
                        System.out.print("Nome do curso: ");
                        String nomeCurso = scanner.nextLine();
                        System.out.print("Total de semestres: ");
                        int totalSemestres = scanner.nextInt();
                        scanner.nextLine();
                        
                        cursos.add(new Curso(nomeCurso, totalSemestres));
                        System.out.println("Curso adicionado com sucesso!");
                    }
                        
                    case 4 -> {
                        if (cursos.isEmpty()) {
                            System.out.println("Adicione um curso primeiro!");
                            break;
                        }
                        System.out.print("Identificação da turma: ");
                        String idTurma = scanner.nextLine();
                        System.out.println("Selecione um curso:");
                        for (int i = 0; i < cursos.size(); i++) {
                            System.out.println((i + 1) + ". " + cursos.get(i).getNome());
                        }
                        int cursoIndex = scanner.nextInt() - 1;
                        scanner.nextLine();
                        System.out.print("Semestre: ");
                        String semestre = scanner.nextLine();
                        
                        turmas.add(new Turma(idTurma, cursos.get(cursoIndex), semestre));
                        System.out.println("Turma adicionada com sucesso!");
                    }
                        
                    case 5 -> {
                        if (turmas.isEmpty()) {
                            System.out.println("Nenhuma turma cadastrada.");
                        } else {
                            for (Turma turma : turmas) {
                                turma.exibirDados();
                            }
                        }
                    }
                        
                    case 6 -> System.out.println("Saindo...");
                        
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 6);
        }
    }
}
