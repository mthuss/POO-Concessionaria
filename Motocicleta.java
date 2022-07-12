
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class Motocicleta extends Veiculo
{
    private int cilindradas;
    private String tipo;
    int moto;
    Scanner input = new Scanner(System.in);
    ArrayList<Motocicleta> listaMotocicletas = new ArrayList<>();
    //Parte de arquivos 
    String arquivoMotocicletas = "motocicletas.txt";
    File arq = new File(arquivoMotocicletas);
 
    //Construtor
    public Motocicleta(long numChassi, String marca, String modelo, int ano, float kilometragem, String tipoCombustivel,
            float peso, String status, int cilindradas, String tipo) {
        super(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel, peso, status);
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }
    
    public Motocicleta(){
        this(0, "", "", 0, 0, "", 0, "", 0, "");
    }
    
    //Getters e setters    
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
