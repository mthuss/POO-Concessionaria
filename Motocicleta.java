public class Motocicleta extends Veiculo
{
    private int cilindradas;
    private int tipo;
    

    public void imprimirDados()
    {
        String status = this.getStatus() ? "Vendida" : "À venda";
        String tipo[] = {"Trail","Street","Esportiva","Custom"};
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Cilidradas: " + this.getCilindradas());
        System.out.println("Tipo: " + tipo[this.getTipo() - 1]);
        System.out.println("Número do chassi: " + this.getNumChassi());
        System.out.println("Ano: " + this.getAno());
        System.out.println("Kilometragem: " + this.getKilometragem());
        System.out.println("Tipo de Combustível: " + this.getTipoCombustivel());
        System.out.println("Peso: " + this.getPeso());
        System.out.println("Status: " + status);
 
    }
    //Construtor
    public Motocicleta(long numChassi, String marca, String modelo, int ano, float kilometragem, String tipoCombustivel,
            float peso, boolean status, int cilindradas, int tipo) {
        super(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel, peso, status);
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }
    
    public Motocicleta(){
        this(0, "", "", 0, 0, "", 0, false, 0, -1);
    }
    
    //Getters e setters    
    public int getCilindradas() {
        return cilindradas;
    }
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
