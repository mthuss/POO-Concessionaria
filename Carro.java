public class Carro extends Veiculo {
    private int potencia; // em CAVALOS (?)
    private int numCilindros;
    private int numeroOcupantes;
    private int tipo;
    private int dimensoes[] = new int[3]; // AxLxC

    public void imprimirDados()
    {   
        String tipo[] = {"Utilitário","Pickup","Sedan","Hatch","Esportivo"};
        String status = this.getStatus() ? "Vendida" : "À venda";
        System.out.println("Numero do chassi: " + this.getNumChassi() + "\nMarca: " + this.getMarca() + "\nModelo: "
        + this.getModelo() + "\nAno: " + this.getAno() +
        "\nKilometragem: " + this.getKilometragem() + "\nTipo de Combustivel: " + this.getTipoCombustivel()
        + "\nPeso: " + this.getPeso() + "\nStatus de venda: " + status +
        "\nPotencia: " + this.getPotencia() + "\nNumero de Cilindros: " + this.getNumCilindros()
        + "\nNumero de assentos: " + this.getNumeroOcupantes() + "\nTipo de thisro: " + tipo[this.getTipo() - 1] +
        "\nDimensões (altura x largura x comprimento): " + this.getAltura() + "x" + this.getLargura() + "x"
        + this.getComprimento() + "\n");
 
    }
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

    public Carro()  { 
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

