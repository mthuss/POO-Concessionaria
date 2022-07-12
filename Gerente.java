import java.util.Scanner;
public class Gerente extends Funcionario
{
    private int anosExp;
    private String login, senha;

    public void cadastrar()
    {
        String senha,senhaConfirm;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu RG: ");
        long RG = sc.nextLong();
        System.out.println("Digite sua data de nascimento: ");
        int dia, mes, ano;
        do{
            System.out.print("Dia: ");
            dia = sc.nextInt();
        }while(!Data.validarDia(dia));

        do{
            System.out.print("Mês: ");
            mes = sc.nextInt();
        }while(!Data.validarMes(mes));

        do{
            System.out.print("Ano: ");
            ano = sc.nextInt();
        }while(!Data.validarAno(ano));

        Data dataNasc = new Data(dia, mes, ano);


        System.out.println("Digite sua data de admissão: ");
        do{
            System.out.print("Dia: ");
            dia = sc.nextInt();
        }while(!Data.validarDia(dia));

        do{
            System.out.print("Mês: ");
            mes = sc.nextInt();
        }while(!Data.validarMes(mes));

        do{
            System.out.print("Ano: ");
            ano = sc.nextInt();
        }while(!Data.validarAno(ano));

        Data dataAdmissao = new Data(dia, mes, ano);

        System.out.print("Digite seu salário mensal:\nR$");
        float salario = sc.nextFloat();
        System.out.println("Anos de experiencia: ");
        int anosExp = sc.nextInt();
        System.out.println("Crie um login e senha:");
        sc.nextLine();
        System.out.print("Login: ");
        String login = sc.nextLine();
        do{
            System.out.print("Senha: ");
            senha = sc.nextLine();
            System.out.print("Confirme sua senha: ");
            senhaConfirm = sc.nextLine();
            if(!senha.equals(senhaConfirm))
                System.out.println("As senhas digitadas não são iguais! Tente novamente");
        }while(!senha.equals(senhaConfirm));
        this.setRG(RG);
        this.setNome(nome);
        this.setDataNasc(dataNasc);
        this.setDataAdmissao(dataAdmissao);
        this.setSalario(salario);
        this.setAnosExp(anosExp);
        this.setLogin(login);
        this.setSenha(senha);
        //sc.close();
    }
    public void cadastrar(String login) //Versao da funcao de cadastrar que recebe login como parametro (ver case 1 na Main.java para mais detalhes)
    {
        String senha,senhaConfirm;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu RG: ");
        long RG = sc.nextLong();
        System.out.println("Digite sua data de nascimento: ");
        int dia, mes, ano;

        do{
            System.out.print("Dia: ");
            dia = sc.nextInt();
        }while(!Data.validarDia(dia));

        do{
            System.out.print("Mês: ");
            mes = sc.nextInt();
        }while(!Data.validarMes(mes));

        do{
            System.out.print("Ano: ");
            ano = sc.nextInt();
        }while(!Data.validarAno(ano));
       Data dataNasc = new Data(dia, mes, ano);


        System.out.println("Digite sua data de admissão: ");
        do {
            System.out.print("Dia: ");
            dia = sc.nextInt();
        }while(!Data.validarDia(dia));

        do{
            System.out.print("Mês: ");
            mes = sc.nextInt();
        }while(!Data.validarMes(mes));

        do{
            System.out.print("Ano: ");
            ano = sc.nextInt();
        } while (!Data.validarAno(ano));
        Data dataAdmissao = new Data(dia, mes, ano);

        System.out.print("Digite seu salário mensal:\nR$");
        float salario = sc.nextFloat();
        System.out.println("Anos de experiencia: ");
        int anosExp = sc.nextInt();
        System.out.println("Crie uma senha:");
        sc.nextLine();
        do{
            System.out.print("Senha: ");
            senha = sc.nextLine();
            System.out.print("Confirme sua senha: ");
            senhaConfirm = sc.nextLine();
            if(!senha.equals(senhaConfirm))
                System.out.println("As senhas digitadas não são iguais! Tente novamente");
        }while(!senha.equals(senhaConfirm));
        this.setRG(RG);
        this.setNome(nome);
        this.setDataNasc(dataNasc);
        this.setDataAdmissao(dataAdmissao);
        this.setSalario(salario);
        this.setAnosExp(anosExp);
        this.setLogin(login);
        this.setSenha(senha);
        //sc.close();
    }

    public void imprimirDados()
    {
        System.out.println("Nome: " + this.getNome());
        System.out.println("RG: " + this.getRG());
        System.out.println("Data de nascimento: " + this.getDataNasc().criarData());
        System.out.println("Data de admissão: " + this.getDataAdmissao().criarData());
        System.out.println("Salário: R$" + this.getSalario());
        System.out.println("Anos de experiencia: " + this.getAnosExp() + " anos");
    }
    public Gerente(long RG, String nome, Data dataNasc, Data dataAdmissao, float salario, int anosExp, String login,
            String senha) {
        super(RG, nome, dataNasc, dataAdmissao, salario);
        this.anosExp = anosExp;
        this.login = login;
        this.senha = senha;
    }

    public Gerente()
    {
        this(0,"",null,null,0,0,"","");
    }

    public int getAnosExp() {
        return anosExp;
    }

    public void setAnosExp(int anosExp) {
        this.anosExp = anosExp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}