import java.util.Scanner;
public class Gerente extends Funcionario
{
    private int anosExp;

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
    
    public void alterar()
    {
        int dia, mes, ano;
        System.out.println("O que deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - RG");
        System.out.println("3 - Data de Nascimento");
        System.out.println("4 - Data de Admissão");
        System.out.println("5 - Salario");
        System.out.println("6 - Anos de Experiencia");
        System.out.println("7 - Login");
        System.out.println("8 - Senha");
        System.out.print("Seleção: ");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch(op)
        {
            case 1:
            System.out.print("Digite seu nome: ");
            sc.nextLine();
            this.setNome(sc.nextLine());
            break;
            
            case 2:
            System.out.print("Digite seu RG: ");
            this.setRG(sc.nextLong());
            break;
            
            case 3:
            System.out.println("Digite sua data de nascimento: ");
                
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
                this.setDataAdmissao(new Data(dia, mes, ano));
                break;
                
                
                case 4:
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
                this.setDataAdmissao(new Data(dia, mes, ano));
                break;
                
                case 5:
                System.out.print("Digite seu salário mensal:\nR$");
                this.setSalario(sc.nextFloat());
                break;
                
                case 6:
                System.out.println("Anos de experiencia: ");
                this.setAnosExp(sc.nextInt());
                break;
                
                
                case 7:
                Funcionario pesquisa;
                sc.nextLine();
                String login;
                do{
                    System.out.println("Digite seu novo login: ");
                    login = sc.nextLine();
                    pesquisa = Sistema.getMapUsuarios().get(login);
                    if(pesquisa != null)
                    System.out.println("Este login já está em uso! Tente novamente.");
                }while(pesquisa != null);
                this.setLogin(login);
                break;
                
                case 8:
                String senha,senhaConfirm;
                sc.nextLine();
                System.out.println("Crie uma nova senha:");
                do{
                    System.out.print("Senha: ");
                    senha = sc.nextLine();
                    System.out.print("Confirme sua senha: ");
                    senhaConfirm = sc.nextLine();
                    if(!senha.equals(senhaConfirm))
                        System.out.println("As senhas digitadas não são iguais! Tente novamente");
                }while(!senha.equals(senhaConfirm));
                this.setSenha(senha);
                break;
        }
    }


    public void imprimirDados()
    {
        System.out.println("Nome: " + this.getNome());
        System.out.println("RG: " + this.getRG());
        System.out.println("Data de nascimento: " + this.getDataNasc().criarData());
        System.out.println("Data de admissão: " + this.getDataAdmissao().criarData());
        System.out.printf("Salário: R$%.2f\n", this.getSalario());
        System.out.println("Anos de experiencia: " + this.getAnosExp() + " anos");
    }
    public Gerente(long RG, String nome, Data dataNasc, Data dataAdmissao, float salario, int anosExp, String login,
            String senha) {
        super(RG, nome, dataNasc, dataAdmissao, salario,login,senha);
        this.anosExp = anosExp;
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

}