public class Gerente extends Funcionario
{ //Teste 😈
    private int anosExp;

    public Gerente(long RG, String nome, Data dataNasc, Data dataAdmissao, float salario, int anosExp) {
        super(RG, nome, dataNasc, dataAdmissao, salario);
        this.anosExp = anosExp;
    }

    public int getAnosExp() {
        return anosExp;
    }

    public void setAnosExp(int anosExp) {
        this.anosExp = anosExp;
    }
}