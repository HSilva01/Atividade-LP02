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
