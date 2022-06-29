public class Motocicleta extends Veiculo
{
    private int cilindradas;
    private String tipo;
 
    public Motocicleta(long numChassi, String marca, String modelo, int ano, float kilometragem, String tipoCombustivel,
            float peso, boolean status, int cilindradas, String tipo) {
        super(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel, peso, status);
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }

    public int getCilindradas() {
        return cilindradas;
    }
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}