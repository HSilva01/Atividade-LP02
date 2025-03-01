
public class Professor extends Pessoa {

    private String siape;
    private boolean coordenador;

    public Professor(String nome, String cpf, String telefone, String endereco, String siape) {
        super(nome, cpf, telefone, endereco);
        this.siape = siape;
        this.coordenador = false; // Por padrão, o professor não é coordenador
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public boolean isCoordenador() {
        return coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("SIAPE: " + siape);
        System.out.println("Coordenador: " + (coordenador ? "Sim" : "Não"));
    }
}
