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
