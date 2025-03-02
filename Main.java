import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Estudante> estudantes = new ArrayList<>();
            ArrayList<Nota> notas = new ArrayList<>();
            ArrayList<Professor> professores = new ArrayList<>();
            ArrayList<Log> logs = new ArrayList<>();

            Professor coordenador = new Professor("Carlos Silva", "12345678900", "99999-9999", "Rua A, 100", "SIAPE123");
            coordenador.setCoordenador(true);
            professores.add(coordenador);

            estudantes.add(new Estudante("Ana Souza", "11111111111", "98888-8888", "Rua B, 200", "MAT123"));
            estudantes.add(new Estudante("Bruno Santos", "22222222222", "97777-7777", "Rua C, 300", "MAT124"));
            estudantes.add(new Estudante("Carlos Mendes", "33333333333", "96666-6666", "Rua D, 400", "MAT125"));
            estudantes.add(new Estudante("Daniela Lima", "44444444444", "95555-5555", "Rua E, 500", "MAT126"));
            estudantes.add(new Estudante("Eduardo Nunes", "55555555555", "94444-4444", "Rua F, 600", "MAT127"));

            for (int i = 0; i < estudantes.size(); i++) {
                notas.add(new Nota(0, 0, 0));
            }

            int opcao;
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
                opcao = scanner.nextInt(); 
                scanner.nextLine(); // Limpa buffer

                switch (opcao) {
                    case 1 -> {
                        for (Estudante e : estudantes) {
                            e.exibirDados();
                        }
                    }
                    case 2 -> {
                        int aprovados = 0, reprovados = 0, recuperacao = 0;
                        for (int i = 0; i < estudantes.size(); i++) {
                            double media = notas.get(i).calcularMedia();
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
                    case 3 -> {
                        System.out.println("Alunos em recuperação:");
                        for (int i = 0; i < estudantes.size(); i++) {
                            if (notas.get(i).calcularMedia() >= 2.5 && notas.get(i).calcularMedia() < 7) {
                                estudantes.get(i).exibirDados();
                            }
                        }
                    }
                    case 4 -> {
                        System.out.print("Digite a matrícula do aluno: ");
                        String matricula = scanner.nextLine();

                        int index = -1;
                        for (int i = 0; i < estudantes.size(); i++) {
                            if (estudantes.get(i).getMatricula().equals(matricula)) {
                                index = i;
                                break;
                            }
                        }

                        if (index == -1) {
                            System.out.println("Estudante não encontrado!");
                        } else {
                            Nota nota = notas.get(index);
                            double mediaAtual = nota.calcularMedia();

                            if (mediaAtual >= 2.5 && mediaAtual < 7) {
                                System.out.print("Digite a nova nota 1: ");
                                double novaNota1 = scanner.nextDouble();
                                System.out.print("Digite a nova nota 2: ");
                                double novaNota2 = scanner.nextDouble();
                                System.out.print("Digite a nova nota 3: ");
                                double novaNota3 = scanner.nextDouble();
                                scanner.nextLine(); // Limpa buffer

                                double[] notasAntigas = {nota.getNota1(), nota.getNota2(), nota.getNota3()};
                                nota.setNota1(novaNota1);
                                nota.setNota2(novaNota2);
                                nota.setNota3(novaNota3);

                                logs.add(new Log(coordenador.getNome(), notasAntigas, new double[]{novaNota1, novaNota2, novaNota3}));
                                System.out.println("Notas atualizadas!");
                            } else {
                                System.out.println("O estudante não está em recuperação.");
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("Histórico de Alterações:");
                        for (Log log : logs) {
                            log.exibirLog();
                        }
                    }
                    case 6 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } while (opcao != 6);
        }
    }
}
