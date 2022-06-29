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

    //getters e setters
    //-------------------------------------
    public long getCPF() {
        return CPF;
    }
    public void setCPF(long cPF) {
        CPF = cPF;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Data getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(Data dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public float getRenda() {
        return renda;
    }
    public void setRenda(float renda) {
        this.renda = renda;
    }
     public ArrayList<Cliente> getDependentes() {
        return dependentes;
    }
    public void setDependentes(ArrayList<Cliente> dependentes) {
        this.dependentes = dependentes;
    }
  
    //Construtor
    //-----------------------------------------------------------------------
    public Cliente(long CPF, String nome, Data dataNasc, String rua, String numeroCasa, String bairro, String cidade,
            float renda) {
        this.CPF = CPF;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.renda = renda;
    }
}