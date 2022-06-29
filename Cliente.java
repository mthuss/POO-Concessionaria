import java.util.ArrayList;

public class Cliente
{
    private long CPF;
    private String nome;
    private Data dataNasc;

    //Dados endereço
    //-----------------------------
    private String rua;
    private String numeroCasa;
    private String bairro;
    private String cidade;

    //------------------------------
    private float renda;
    private ArrayList<Cliente> dependentes; //não sei se é assim que faria (recursão?)
}