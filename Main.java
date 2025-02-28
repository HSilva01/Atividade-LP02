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

