public class Carro extends Veiculo {
    private int potencia; // em CAVALOS (?)

    private int numCilindros;
    private int numeroOcupantes;
    private String tipo;
    private int dimensoes[] = new int[3]; // AxLxC

    // getters e setters
    // -------------------------------------------------------
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getNumCilindros() {
        return numCilindros;
    }

    public void setNumCilindros(int numCilindros) {
        this.numCilindros = numCilindros;
    }

    public int getNumeroOcupantes() {
        return numeroOcupantes;
    }

    public void setNumeroOcupantes(int numeroOcupantes) {
        this.numeroOcupantes = numeroOcupantes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int[] getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(int[] dimensoes) {
        this.dimensoes = dimensoes;
    }

    public Carro(long numChassi, String marca, String modelo, int ano, float kilometragem, String tipoCombustivel,
            float peso, boolean status, int potencia, int numCilindros, int numeroOcupantes, String tipo,
            int[] dimensoes) {
        super(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel, peso, status);
        this.potencia = potencia;
        this.numCilindros = numCilindros;
        this.numeroOcupantes = numeroOcupantes;
        this.tipo = tipo;
        this.dimensoes = dimensoes;
    }

}