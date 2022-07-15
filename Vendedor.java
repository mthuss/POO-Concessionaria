import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Map;

public class Vendedor extends Funcionario {
    private float tempoRestante; // em horas(?)
    private Gerente gerente;
    private String login, senha;
    // String dadosVendedores = "vendedores.txt";
    // File arq = new File(dadosVendedores);

    public void imprimirDados() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("RG: " + this.getRG());
        System.out.println("Data de Nascimento: " + this.getDataNasc().criarData());
        System.out.println("Data de Admissão: " + this.getDataAdmissao().criarData());
        System.out.println("Salário: " + this.getSalario());
        System.out.println("Tempo de Treinamento: " + this.getTempoRestante() + "h");
        if (this.getGerente() != null)
            System.out.println("Gerente Responsável: " + this.getGerente().getNome());
        else
            System.out.println("Gerente Responsável: Não tem " + this.getGerente().getNome());
        System.out.println("Login: " + this.getLogin());
        System.out.println("Senha: " + this.getSenha());

    }

    public void cadastrar(String login) {
        Scanner input = new Scanner(System.in);
        String senha, confirSenha;
        System.out.print("Digite o nome do vendedor: ");
        this.setNome(input.nextLine());
        System.out.print("Digite o RG do vendedor: ");
        this.setRG(input.nextLong());
        System.out.println("Digite a data de nascimento do vendedor: ");
        int dia, mes, ano;
        do {
            System.out.print("Dia: ");
            dia = input.nextInt();
        } while (!Data.validarDia(dia));

        do {
            System.out.print("Mês: ");
            mes = input.nextInt();
        } while (!Data.validarMes(mes));

        do {
            System.out.print("Ano: ");
            ano = input.nextInt();
        } while (!Data.validarAno(ano));

        Data dataNasc = new Data(dia, mes, ano);
        this.setDataNasc(dataNasc);

        System.out.println("Digite a data de admissão o vendedor: ");
        do {
            System.out.print("Dia: ");
            dia = input.nextInt();
        } while (!Data.validarDia(dia));

        do {
            System.out.print("Mês: ");
            mes = input.nextInt();
        } while (!Data.validarMes(mes));

        do {
            System.out.print("Ano: ");
            ano = input.nextInt();
        } while (!Data.validarAno(ano));

        Data dataAdmissao = new Data(dia, mes, ano);
        this.setDataAdmissao(dataAdmissao);

        System.out.print("Digite o salário do vendedor:\nR$");
        this.setSalario(input.nextFloat());

        System.out.print("Digite o tempo de treinamento:");
        this.setTempoRestante(input.nextFloat());
        input.nextLine();

        String login_adm;
        Gerente pesquisa;
        Map<String, Funcionario> usuarios = Sistema.getMapUsuarios();
        boolean temGerente = false;
        for (Funcionario f : usuarios.values()) {
            if (f instanceof Gerente)
                temGerente = true;
        }
        if (temGerente) {
            do {
                System.out.print("Digite o login do gerente responsável: ");
                login_adm = input.nextLine();
                pesquisa = (Gerente) Sistema.getMapUsuarios().get(login_adm);
                if (pesquisa != null && pesquisa instanceof Gerente) {
                    this.setGerente(pesquisa);
                } else {
                    System.out.println("Digite um login válido!");
                }
            } while (pesquisa == null || !(pesquisa instanceof Gerente));
        } else
            this.setGerente(null);

        System.out.println("Crie uma senha para o vendedor:");
        // input.nextLine();
        do {
            System.out.print("Senha: ");
            senha = input.nextLine();
            System.out.print("Confirme sua senha: ");
            confirSenha = input.nextLine();
            if (!senha.equals(confirSenha))
                System.out.println("As senhas digitadas não são iguais! Tente novamente");
        } while (!senha.equals(confirSenha));
        this.setLogin(login);
        this.setSenha(senha);

    }

    public void alterar() {
        Scanner input = new Scanner(System.in);
        int dia, mes, ano;
        int op;
        String confirmSenha;
        do {
            System.out.println("\nQual dado deseja alterar?");
            System.out.println("1 - Alterar Nome");
            System.out.println("2 - Alterar RG");
            System.out.println("3 - Alterar Data de Nascimento");
            System.out.println("4 - Alterar Data de Admissão");
            System.out.println("5 - Alterar Salário");
            System.out.println("6 - Alterar Tempo de treinamento");
            System.out.println("7 - Alterar Gerente Responsável");
            System.out.println("8 - Alterar login");
            System.out.println("9 - Alterar senha");
            System.out.println("10 - Sair");
            System.out.println("\nDigite a opção desejada: ");
            op = input.nextInt();
            input.nextLine();

            switch (op) {
                case 1:
                    System.out.print("\nDigite o novo nome: ");
                    this.setNome(input.nextLine());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 2:
                    System.out.print("\nDigite o novo RG: ");
                    this.setRG(input.nextLong());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 3:
                    System.out.println("\nDigite a nova data de nascimento: ");
                    do {
                        System.out.print("Dia: ");
                        dia = input.nextInt();
                    } while (!Data.validarDia(dia));

                    do {
                        System.out.print("Mês: ");
                        mes = input.nextInt();
                    } while (!Data.validarMes(mes));

                    do {
                        System.out.print("Ano: ");
                        ano = input.nextInt();
                    } while (!Data.validarAno(ano));
                    Data novaData = new Data(dia, mes, ano);
                    this.setDataNasc(novaData);
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 4:
                    System.out.println("\nDigite a nova data de admissão: ");
                    do {
                        System.out.print("Dia: ");
                        dia = input.nextInt();
                    } while (!Data.validarDia(dia));

                    do {
                        System.out.print("Mês: ");
                        mes = input.nextInt();
                    } while (!Data.validarMes(mes));

                    do {
                        System.out.print("Ano: ");
                        ano = input.nextInt();
                    } while (!Data.validarAno(ano));
                    novaData = new Data(dia, mes, ano);
                    this.setDataAdmissao(novaData);
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 5:
                    System.out.print("\nDigite o novo Salário: R$ ");
                    this.setSalario(input.nextLong());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 6:
                    System.out.print("\nDigite o novo tempo de treinamento: ");
                    this.setSalario(input.nextInt());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 7:
                    System.out.print("\nDigite o login do novo gerente responsável: ");
                    input.nextLine();
                    String login_adm = input.nextLine();
                    Gerente pesquisa = (Gerente) Sistema.getMapUsuarios().get(login_adm); // REVER ISSO AQUI
                    if (pesquisa != null) {
                        this.setGerente(pesquisa);
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    } else {
                        System.out.print("Digite um login válido!");
                    }
                    break;
                case 8:
                    System.out.print("\nDigite o novo login: ");
                    this.setLogin(input.nextLine());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 9:
                    do {
                        System.out.print("Digite a nova senha: ");
                        senha = input.nextLine();
                        System.out.print("Confirme a senha: ");
                        confirmSenha = input.nextLine();
                        if (!senha.equals(confirmSenha))
                            System.out.println("As senhas digitadas não são iguais! Tente novamente");
                    } while (!senha.equals(confirmSenha));
                    this.setSenha(senha);
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;

            }
        } while (op != 10);

    }

    // Construtor
    public Vendedor(long RG, String nome, Data dataNasc, Data dataAdmissao, float salario, float tempoRestante,
            Gerente gerente, String login, String senha) {
        super(RG, nome, dataNasc, dataAdmissao, salario, login, senha);
        this.tempoRestante = tempoRestante;
        this.gerente = gerente;
    }

    public Vendedor() {
        this(0, "", null, null, 0, 0, null, "", "");
    }

    // Getters e Setters
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