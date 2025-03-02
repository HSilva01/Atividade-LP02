public class Turma {

    private String identificacao;
    private Curso curso;
    private final String semestre;
    private List<Professor> professores = new ArrayList<>();
    private List<Estudante> estudantes = new ArrayList<>();
    private List<Log> logs = new ArrayList<>();
    private List<Nota> notas = new ArrayList<>(); // Agora armazenamos as notas separadamente

    public Turma(String identificacao, Curso curso, String semestre) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.semestre = semestre;
    }

    public void adicionarEstudante(Estudante estudante) {
        if (estudante != null) {
            estudantes.add(estudante);
            notas.add(new Nota(0, 0, 0)); // Criamos um objeto Nota para cada estudante
        }
    }

    public void adicionarProfessor(Professor professor) {
        if (professor != null) {
            professores.add(professor);
        }
    }

    public void alterarNotaEstudante(Professor coordenador, Estudante estudante, double novaNota1, double novaNota2, double novaNota3) {
        if (!coordenador.isCoordenador()) {
            System.out.println("Somente coordenadores podem alterar notas.");
            return;
        }

        int index = estudantes.indexOf(estudante);
        if (index != -1) {
            Nota nota = notas.get(index);
            double[] notasAnteriores = {nota.getNota1(), nota.getNota2(), nota.getNota3()};
            nota.setNota1(novaNota1);
            nota.setNota2(novaNota2);
            nota.setNota3(novaNota3);
            logs.add(new Log(coordenador.getNome(), notasAnteriores, new double[]{novaNota1, novaNota2, novaNota3}));
            System.out.println("Notas alteradas com sucesso!");
        } else {
            System.out.println("Estudante não encontrado na turma.");
        }
    }

    public void exibirEstatisticas() {
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
