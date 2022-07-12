public class Carro extends Veiculo {
    private int potencia; // em CAVALOS (?)
    private int numCilindros;
    private int numeroOcupantes;
    private int tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int[] getDimensoes() {
        return dimensoes;
    }
    public int getAltura() {
        return dimensoes[0];
    }
    public int getLargura() {
        return dimensoes[1];
    }
    public int getComprimento() {
        return dimensoes[2];
    }

    public void setDimensoes(int[] dimensoes) {
        this.dimensoes = dimensoes;
    }

    public Carro(long numChassi, String marca, String modelo, int ano, float kilometragem, String tipoCombustivel,
            float peso, boolean status, int potencia, int numCilindros, int numeroOcupantes, int tipo,
            int[] dimensoes) {
        super(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel, peso, status);
        this.potencia = potencia;
        this.numCilindros = numCilindros;
        this.numeroOcupantes = numeroOcupantes;
        this.tipo = tipo;
        this.dimensoes = dimensoes;
    }

    public Carro()  { //builder vazio só porque sim
        super(0L, "", "", 0000, 0.0f, "", 0.0f, false);
        this.potencia = 0;
        this.numCilindros = 0;
        this.numeroOcupantes = 0;
        this.tipo = -1;
        this.dimensoes[0] = 0;
        this.dimensoes[1] = 0;
        this.dimensoes[2] = 0;
    }
}

