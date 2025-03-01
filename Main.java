import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Estudante> estudantes = new ArrayList<>();
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Turma> turmas = new ArrayList<>();

        estudantes.add(new Estudante("Ana Silva", "111.111.111-11", "(11) 91111-1111", "Rua X, Bairro Y", "1111111", 8.0));
        estudantes.add(new Estudante("Bruno Mendes", "222.222.222-22", "(22) 92222-2222", "Rua W, Bairro Z", "2222222", 6.5));
        estudantes.add(new Estudante("Carla Souza", "333.333.333-33", "(33) 93333-3333", "Rua V, Bairro U", "3333333", 7.2));
        estudantes.add(new Estudante("Daniel Rocha", "444.444.444-44", "(44) 94444-4444", "Rua T, Bairro S", "4444444", 5.8));
        estudantes.add(new Estudante("Eduarda Lima", "555.555.555-55", "(55) 95555-5555", "Rua Q, Bairro R", "5555555", 9.1));

        professores.add(new Professor("Fernando Martins", "666.666.666-66", "(66) 96666-6666", "Rua P, Bairro O", "244576"));
        professores.add(new Professor("Gisele Andrade", "777.777.777-77", "(77) 97777-7777", "Rua N, Bairro M", "325078"));

        cursos.add(new Curso("Matemática Aplicada", "4"));
        cursos.add(new Curso("Física Computacional", "6"));

        turmas.add(new Turma("20245", cursos.get(0), "4"));
        turmas.add(new Turma("20248", cursos.get(1), "6"));

        turmas.get(0).adicionarProfessor(professores.get(0));
        for (Estudante estudante : estudantes) {
            turmas.get(0).adicionarEstudante(estudante);
        }

        turmas.get(1).adicionarProfessor(professores.get(1));
        for (Estudante estudante : estudantes) {
            turmas.get(1).adicionarEstudante(estudante);
        }

        turmas.get(0).exibirDados();
        System.out.println();
        turmas.get(1).exibirDados();
    }
}
