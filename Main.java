import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudante> estudantes = new ArrayList<>();
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Log> logs = new ArrayList<>();
        
        // Criando alguns objetos iniciais
        Professor coordenador = new Professor("Carlos Silva", "12345678900", "99999-9999", "Rua A, 100", "SIAPE123");
        coordenador.setCoordenador(true);
        professores.add(coordenador);
        
        estudantes.add(new Estudante("Ana Souza", "11111111111", "98888-8888", "Rua B, 200", "MAT123", new Nota(6.0, 5.0, 7.0)));
        estudantes.add(new Estudante("Bruno Santos", "22222222222", "97777-7777", "Rua C, 300", "MAT124", new Nota(3.0, 4.5, 5.0)));
        estudantes.add(new Estudante("Carlos Mendes", "33333333333", "96666-6666", "Rua D, 400", "MAT125", new Nota(2.0, 2.5, 3.0)));
        estudantes.add(new Estudante("Daniela Lima", "44444444444", "95555-5555", "Rua E, 500", "MAT126", new Nota(9.0, 8.5, 10.0)));
        estudantes.add(new Estudante("Eduardo Nunes", "55555555555", "94444-4444", "Rua F, 600", "MAT127", new Nota(7.0, 6.5, 7.5)));

        int opcao;
        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Exibir lista de alunos");
            System.out.println("2. Exibir estatísticas das notas");
            System.out.println("3. Mostrar alunos em recuperação");
            System.out.println("4. Alterar nota de aluno em recuperação");
            System.out.println("5. Exibir log de alterações");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    for (Estudante e : estudantes) {
                        e.exibirDados();
                    }
                    break;
                case 2:
                    int aprovados = 0, reprovados = 0, recuperacao = 0;
                    for (Estudante e : estudantes) {
                        double media = e.getNota().calcularMedia();
                        if (media >= 7) aprovados++;
                        else if (media >= 2.5) recuperacao++;
                        else reprovados++;
                    }
                    System.out.println("Aprovados: " + aprovados);
                    System.out.println("Em recuperação: " + recuperacao);
                    System.out.println("Reprovados: " + reprovados);
                    break;
                case 3:
                    System.out.println("Alunos em recuperação:");
                    for (Estudante e : estudantes) {
                        if (e.getNota().calcularMedia() >= 2.5 && e.getNota().calcularMedia() < 7) {
                            e.exibirDados();
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite a matrícula do aluno: ");
                    String matricula = scanner.nextLine();
                    for (Estudante e : estudantes) {
                        if (e.getMatricula().equals(matricula) && e.getNota().calcularMedia() >= 2.5 && e.getNota().calcularMedia() < 7) {
                            System.out.print("Digite a nova nota 1: ");
                            double novaNota1 = scanner.nextDouble();
                            System.out.print("Digite a nova nota 2: ");
                            double novaNota2 = scanner.nextDouble();
                            System.out.print("Digite a nova nota 3: ");
                            double novaNota3 = scanner.nextDouble();

                            double[] notasAntigas = { e.getNota().getNota1(), e.getNota().getNota2(), e.getNota().getNota3() };
                            e.getNota().setNota1(novaNota1);
                            e.getNota().setNota2(novaNota2);
                            e.getNota().setNota3(novaNota3);
                            logs.add(new Log(coordenador.getNome(), notasAntigas, new double[]{novaNota1, novaNota2, novaNota3}));
                            System.out.println("Notas atualizadas!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Histórico de Alterações:");
                    for (Log log : logs) {
                        log.exibirLog();
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
