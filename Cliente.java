public class Cliente
{
    private long CPF;
    private String nome;
    private Data dataNasc;

    //Dados endereço
    //-----------------------------
    private String rua;
    private int numeroCasa;
    private String bairro;
    private String cidade;

    //------------------------------
    private float renda;
    private int dependentes;

    public void imprimirDados()
    {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.CPF);
        System.out.println("Data de Nascimento: " + this.dataNasc.criarData());
        System.out.println("Endereço:\n  Rua: " + this.rua + ",nº " + this.numeroCasa);
        System.out.println("  Bairro: " + this.bairro);
        System.out.println("  Cidade: "+ this.cidade);
        System.out.println("Renda: R$" + this.renda);
        System.out.println("Número de dependentes: " + this.dependentes);
    }
    //getters e setters
    //-------------------------------------
    public long getCPF() {
        return CPF;
    }
    public void setCPF(long CPF) {
        this.CPF = CPF;
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
    public int getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(int numeroCasa) {
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
     public int getDependentes() {
        return dependentes;
    }
    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }
  
    //Construtor
    //-----------------------------------------------------------------------
    public Cliente(long CPF, String nome, Data dataNasc, String rua, int numeroCasa, String bairro, String cidade,
            float renda,int dependentes) {
        this.CPF = CPF;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.renda = renda;
        this.dependentes = dependentes;
    }

    public Cliente(){
        this.CPF = 0;
        this.nome = "";
        this.dataNasc = null;
        this.rua = "";
        this.numeroCasa = 0;
        this.bairro = "";
        this.cidade = "";
        this.renda = 0f;
    }

    
}
