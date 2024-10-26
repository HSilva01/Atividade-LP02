import java.util.ArrayList;
import java.util.List;

interface Printable {
    void print();
}

class Curso {
    private final String nome;
    private final int duracaoEmSemestres;

    public Curso(String nome, int duracaoEmSemestres) {
        this.nome = nome;
        this.duracaoEmSemestres = duracaoEmSemestres;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoEmSemestres() {
        return duracaoEmSemestres;
    }

    @Override
    public String toString() {
        return String.format("%s - Duração: %d semestres", nome, duracaoEmSemestres);
    }
}

abstract class Pessoa implements Printable {
    protected final String nome;
    protected final String cpf;
    protected final String endereco;
    protected final String telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void print() {
        System.out.printf("Nome: %s%nCPF: %s%nEndereço: %s%nTelefone: %s%n", nome, cpf, endereco, telefone);
    }
}

class Professor extends Pessoa {
    private final int siape;

    public Professor(String nome, String cpf, String endereco, String telefone, int siape) {
        super(nome, cpf, endereco, telefone);
        this.siape = siape;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("SIAPE: %d%n", siape);
    }
}

class Estudante extends Pessoa {
    private final String matricula;

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("Matrícula: %s%n", matricula);
    }
}

class Turma {
    private final String identificacao;
    private final Curso curso;
    private final List<Estudante> estudantes = new ArrayList<>();
    private Professor professor;

    public Turma(String identificacao, Curso curso) {
        this.identificacao = identificacao;
        this.curso = curso;
    }

    public void vincularProfessor(Professor professor) {
        this.professor = professor;
    }

    public void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public void print() {
        System.out.printf("Turma: %s, Curso: %s%n", identificacao, curso);
        if (professor != null) {
            System.out.println("Professor:");
            professor.print();
        } else {
            System.out.println("Nenhum professor vinculado.");
        }
        System.out.println("Estudantes:");
        estudantes.forEach(Estudante::print);
    }
}

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Análise e Desenvolvimento de Sistemas", 8);
        Curso curso2 = new Curso("Banco de Dados Avançado", 6);

        Professor professor1 = new Professor("Luis Araujo", "000.000.00-0", "Rua X, Bairro Y", "987662577", 12345);
        Professor professor2 = new Professor("Rosangela Garcia", "111.111.11-1", "Rua Z, Bairro W", "912345678", 67890);

        Estudante estudante1 = new Estudante("João Souza", "222.222.22-2", "Rua A, Bairro B", "987654321", "2023001");
        Estudante estudante2 = new Estudante("Mirele Oliveira", "333.333.33-3", "Rua C, Bairro D", "998877665", "2023002");
        Estudante estudante3 = new Estudante("Ana Costa", "444.444.44-4", "Rua E, Bairro F", "985633211", "2023003");
        Estudante estudante4 = new Estudante("Andressa Mota", "555.555.55-5", "Rua G, Bairro H", "998544721", "2023004");
        Estudante estudante5 = new Estudante("Analice Silva", "666.666.66-6", "Rua I, Bairro J", "9971655", "2023005");

        Turma turma1 = new Turma("TURMA1", curso1);
        Turma turma2 = new Turma("TURMA2", curso2);

        turma1.vincularProfessor(professor1);
        turma1.adicionarEstudante(estudante1);
        turma1.adicionarEstudante(estudante2);
        turma1.adicionarEstudante(estudante3);
        turma1.adicionarEstudante(estudante4);
        turma1.adicionarEstudante(estudante5);

        turma2.vincularProfessor(professor2);
        turma2.adicionarEstudante(estudante1);
        turma2.adicionarEstudante(estudante2);
        turma2.adicionarEstudante(estudante3);
        turma2.adicionarEstudante(estudante4);
        turma2.adicionarEstudante(estudante5);

        turma1.print();
        System.out.println();
        turma2.print();
    }
}
