public abstract class Funcionario
{
    private long RG;
    private String nome;
    private Data dataNasc;
    private Data dataAdmissao;
    private float salario;
    private String login, senha;


    public Funcionario(long RG, String nome, Data dataNasc, Data dataAdmissao, float salario, String login,
            String senha) {
        this.RG = RG;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public long getRG() {
        return RG;
    }
    public void setRG(long RG) {
        this.RG = RG;
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
    public Data getDataAdmissao() {
        return dataAdmissao;
    }
    public void setDataAdmissao(Data dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
}