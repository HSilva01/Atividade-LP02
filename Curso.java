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


