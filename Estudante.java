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
