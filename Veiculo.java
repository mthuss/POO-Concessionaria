public abstract class Veiculo
{
    private long numChassi;
    private String marca;
    private String modelo;
    private int ano;
    private float kilometragem;
    private String tipoCombustivel;
    private float peso;
    private boolean status = false; //true: vendido / false: a venda

    public Veiculo(long numChassi, String marca, String modelo, int ano, float kilometragem, String tipoCombustivel,
    float peso, boolean status) {
        this.numChassi = numChassi;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.kilometragem = kilometragem;
        this.tipoCombustivel = tipoCombustivel;
        this.peso = peso;
        this.status = status;
    }
    public long getNumChassi() {
        return numChassi;
    }
    public void setNumChassi(long numChassi) {
        this.numChassi = numChassi;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getKilometragem() {
        return kilometragem;
    }
    public void setKilometragem(float kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }
    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}