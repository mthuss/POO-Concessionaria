import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Vendedor extends Funcionario
{
    private float tempoRestante; //em horas(?)
    private Gerente gerente;
    
    ArrayList<Vendedor> listaVendedores = new ArrayList<>();
    String dadosVendedores = "vendedores.txt";
    File arq = new File(dadosVendedores);

    //Construtor
    public Vendedor(long RG, String nome, Data dataNasc, Data dataAdmissao, float salario, float tempoRestante,
            Gerente gerente) {
        super(RG, nome, dataNasc, dataAdmissao, salario);
        this.tempoRestante = tempoRestante;
        this.gerente = gerente;
    }

    public Vendedor(){
        this(0, "", null, null, 0, 0, null);
    }

    //Getters e Setters
    public float getTempoRestante() {
        return tempoRestante;
    }
    public void setTempoRestante(float tempoRestante) {
        this.tempoRestante = tempoRestante;
    }
    public Gerente getGerente() {
        return gerente;
    }
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}