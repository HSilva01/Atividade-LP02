import java.util.*;

class Estudante {
    private String nome;
    private double[] notas = new double[3];
    private Double notaRecuperacao = null;

    public Estudante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public Double getNotaRecuperacao() {
        return notaRecuperacao;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public void setNotaRecuperacao(double nota) {
        this.notaRecuperacao = nota;
    }

    public double calcularMediaSimples() {
        return (notas[0] + notas[1] + notas[2]) / 3;
    }

    public double calcularMediaFinal() {
        double media = calcularMediaSimples();
        if (notaRecuperacao != null && media < 7) {
            return (media + notaRecuperacao) / 2;
        }
        return media;
    }

    public String getStatus() {
        double media = calcularMediaFinal();
        if (notaRecuperacao == null && media < 7) {
            return "SN";
        } else if (media >= 7) {
            return "APROVADO";
        } else if (media >= 5) {
            return "EM RECUPERAÇÃO";
        } else {
            return "REPROVADO";
        }
    }
}

class Professor {
    private String nome;
    private boolean isCoordenador;

    public Professor(String nome, boolean isCoordenador) {
        this.nome = nome;
        this.isCoordenador = isCoordenador;
    }

    public String getNome() {
        return nome;
    }

    public boolean isCoordenador() {
        return isCoordenador;
    }
}

class Historico {
    private String quemAlterou;
    private String estudante;
    private double notaAnterior;
    private double notaAtual;

    public Historico(String quemAlterou, String estudante, double notaAnterior, double notaAtual) {
        this.quemAlterou = quemAlterou;
        this.estudante = estudante;
        this.notaAnterior = notaAnterior;
        this.notaAtual = notaAtual;
    }

    @Override
    public String toString() {
        return "Alteração feita por: " + quemAlterou + 
               ", Estudante: " + estudante + 
               ", Nota Anterior: " + notaAnterior + 
               ", Nota Atual: " + notaAtual;
    }
}

class Turma {
    private String identificacao;
    private String curso;
    private Professor professor;
    private List<Estudante> estudantes = new ArrayList<>();

    public Turma(String identificacao, String curso, Professor professor) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.professor = professor;
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

class SistemaEscolar {
    private List<Turma> turmas = new ArrayList<>();
    private List<Historico> historicos = new ArrayList<>();

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void registrarHistorico(String quemAlterou, String estudante, double notaAnterior, double notaAtual) {
        historicos.add(new Historico(quemAlterou, estudante, notaAnterior, notaAtual));
    }

    public void exibirHistorico() {
        for (Historico h : historicos) {
            System.out.println(h);
        }
    }

    public void exibirEstatisticas(Turma turma) {
        int aprovados = 0, recuperacao = 0, reprovados = 0;
        for (Estudante e : turma.getEstudantes()) {
            String status = e.getStatus();
            if (status.equals("APROVADO")) aprovados++;
            else if (status.equals("EM RECUPERAÇÃO")) recuperacao++;
            else reprovados++;
        }
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Em Recuperação: " + recuperacao);
        System.out.println("Reprovados: " + reprovados);
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaEscolar sistema = new SistemaEscolar();

        // Criando coordenador e professor
        Professor coordenador = new Professor("Luis Araujo", true);
        Professor professor = new Professor("Ana Souza", false);

        // Criando turma
        Turma turma = new Turma("1912", "Licenciatura em Computação", professor);
        sistema.adicionarTurma(turma);

        // Adicionando estudantes
        Estudante e1 = new Estudante("João");
        e1.setNotas(new double[]{6.5, 7.0, 8.0});
        turma.adicionarEstudante(e1);

        Estudante e2 = new Estudante("Maria");
        e2.setNotas(new double[]{2.0, 3.0, 4.0});
        turma.adicionarEstudante(e2);

        Estudante e3 = new Estudante("Carlos");
        e3.setNotas(new double[]{5.0, 6.0, 7.0});
        turma.adicionarEstudante(e3);

        // Estatísticas
        sistema.exibirEstatisticas(turma);

        // Atualizando nota de recuperação
        e2.setNotaRecuperacao(6.0);
        sistema.registrarHistorico(coordenador.getNome(), e2.getNome(), 4.0, 6.0);

        // Exibindo histórico
        sistema.exibirHistorico();
    }
}
