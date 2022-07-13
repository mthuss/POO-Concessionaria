public class Vendedor extends Funcionario
{
    private float tempoRestante; //em horas(?)
    private Gerente gerente;

    public Vendedor(long RG, String nome, Data dataNasc, Data dataAdmissao, float salario, float tempoRestante,
            Gerente gerente, String login, String senha) {
        super(RG, nome, dataNasc, dataAdmissao, salario,senha,login);
        this.tempoRestante = tempoRestante;
        this.gerente = gerente;
    }

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