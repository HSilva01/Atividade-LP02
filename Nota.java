public class Nota {

    private Double nota1;
    private Double nota2;
    private Double nota3;

    public Nota() {
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }

    public Nota(Double nota1, Double nota2, Double nota3) {
        this.nota1 = (nota1 != null) ? nota1 : 0.0;
        this.nota2 = (nota2 != null) ? nota2 : 0.0;
        this.nota3 = (nota3 != null) ? nota3 : 0.0;
    }

    public Double getNota1() {
        return this.nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return this.nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return this.nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public boolean verificarSituacao() {
        double media = this.calcularMedia();
        if (media < 2.5) {
            System.out.println("Reprovado");
            return false;
        } else if (media < 7) {
            System.out.println("Em recuperação");
            return false;
        } else {
            System.out.println("Aprovado");
            return true;
        }
    }
}
