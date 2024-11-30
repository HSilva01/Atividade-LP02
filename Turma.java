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

