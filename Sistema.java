import java.util.Scanner;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Sistema {

    int indiceVenda = 0;
    public static Map<String, Funcionario> usuarios = new HashMap<>(); // Idealmente, mover isso para o Sistema.java.
    public static ArrayList<Carro> carros = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Motocicleta> motocicletas = new ArrayList<>();
    public static ArrayList<Venda> vendas = new ArrayList<>();

    public static void menuVendedor(Vendedor vendedor) {
        int op;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Menu Vendedor: ");
            System.out.println("1 - Visualizar Veículos");
            System.out.println("2 - Visualizar Clientes");
            System.out.println("3 - Visualizar Vendas");
            System.out.println("4 - Realizar uma Venda");
            System.out.println("5 - Sair");

            op = input.nextInt();
            input.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Visualizar Veículos");
                    System.out.println("1 - Visualizar Carros");
                    System.out.println("2 - Visualizar Motos");
                    int subop = input.nextInt();
                    input.nextLine();
                    switch (subop) {
                        case 1:
                            // Método de exibir carros
                            break;
                        case 2:
                            visualizarMotocicletas();
                            break;
                    }
                    break;
                case 2:
                    // método listar clientes
                    break;
                case 3:
                    // método listar vendas
                    break;
                case 4:
                    // ???
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }

        } while (op != 5);

    }

    // ------------------------------------------
    // Funções do Menu ADM

    // ------------------------------------------
    // Carros
    // ------------------------------------------

    static void cadastrarCarro() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite os dados referentes ao carro:");
        System.out.print("Numero do chassi: "); // Long
        long auxChassi = scan.nextLong();

        System.out.print("Marca: "); // String
        scan.nextLine();
        String auxMarca = scan.nextLine();

        System.out.print("Modelo: "); // String
        String auxModelo = scan.nextLine();

        System.out.print("Ano de fabricação: "); // int
        int auxAno = scan.nextInt();
        scan.nextLine();

        System.out.print("Kilometragem: "); // float
        float auxKilo = scan.nextFloat();
        scan.nextLine();

        System.out.print("Tipo de combustivel: "); // String
        String auxCombustivel = scan.nextLine();

        System.out.print("Peso em kilogramas: "); // float
        float auxPeso = scan.nextFloat();

        // aqui seria o status mas será falso por padrão

        System.out.print("Potência em cavalos: "); // int
        int auxPotencia = scan.nextInt();

        System.out.print("Número de cilindros: "); // int
        int auxCilindros = scan.nextInt();

        System.out.print("Numero de assentos: "); // int
        int auxAssentos = scan.nextInt();

        int auxTipo; // para o tipo de carro
        do {
            System.out.println("\tTipo de carro: ");
            System.out.println("1-utilitário\n2-pickup\n3-sedan\n4-hatch\n5-esportivo");
            System.out.print("Comando: ");
            auxTipo = scan.nextInt();

            if (auxTipo < 1 || auxTipo > 5)
                System.out.println("\tValor invalido");
        } while (auxTipo < 1 || auxTipo > 5);

        int auxDimensoes[] = new int[3];
        System.out.println("\tDimensões:");
        System.out.print("Altura: ");
        auxDimensoes[0] = scan.nextInt();

        System.out.print("Largura ");
        auxDimensoes[1] = scan.nextInt();

        System.out.print("Comprimento: ");
        auxDimensoes[2] = scan.nextInt();

        Carro car = new Carro(auxChassi, auxMarca, auxModelo, auxAno, auxKilo, auxCombustivel,
                auxPeso, false, auxPotencia, auxCilindros, auxAssentos, auxTipo, auxDimensoes);

        carros.add(car);
        carrosWriteFile();
    }

    // ------------------------------------------

    public static void alterarCarros() {
        int indice = 0;
        Scanner sc = new Scanner(System.in);

        mostraArrayCarros();

        if (carros.size() == 0)
            System.out.println("\nNão há carros cadastradas.");

        else {
            do {
                System.out.print("Digite o indice do carro que deseja alterar: ");
                indice = sc.nextInt();
                sc.nextLine();
                indice--;
                if (indice < 0 || indice > carros.size() - 1)
                    System.out.println("\tIndice inválido!");

            } while (indice < 0 || indice > carros.size() - 1);

            int opMenu;
            do {
                System.out.println("\nQual dado deseja alterar?");
                System.out.println("1 - Alterar Numero do chassi");
                System.out.println("2 - Alterar Marca");
                System.out.println("3 - Alterar Modelo");
                System.out.println("4 - Alterar Ano de fabricação");
                System.out.println("5 - Alterar Kilometragem");
                System.out.println("6 - Alterar Tipo de combustivel");
                System.out.println("7 - Alterar valor do Peso");
                System.out.println("8 - Alterar Potencia");
                System.out.println("9 - Alterar Numero de cilindros");
                System.out.println("10 - Alterar Numero de assentos");
                System.out.println("11 - Alterar Tipo de carro");
                System.out.println("12 - Alterar Dados de tamanho");

                System.out.print("\nComando: ");
                opMenu = sc.nextInt();
                sc.nextLine();

                switch (opMenu) {
                    case 1:
                        Long auxChassi;
                        System.out.print("\nDigite o numero do chassi: ");
                        auxChassi = sc.nextLong();
                        carros.get(indice).setNumChassi(auxChassi);
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 2:
                        String auxMarca;
                        System.out.print("\nDigite a marca: ");
                        auxMarca = sc.nextLine();
                        carros.get(indice).setMarca(auxMarca);
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 3:
                        String auxModelo;
                        System.out.print("\nDigite o modelo: ");
                        auxModelo = sc.nextLine();
                        carros.get(indice).setMarca(auxModelo);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 4:
                        int auxAno;
                        System.out.print("\nDigite o novo ano: ");
                        auxAno = sc.nextInt();
                        carros.get(indice).setAno(auxAno);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 5:
                        Float auxKilo;
                        System.out.print("\nDigite a kilometragem: ");
                        auxKilo = sc.nextFloat();
                        carros.get(indice).setKilometragem(auxKilo);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 6:
                        String auxCombustivel;
                        System.out.print("\nDigite o tipo de combustivel: ");
                        auxCombustivel = sc.nextLine();
                        carros.get(indice).setTipoCombustivel(auxCombustivel);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 7:
                        Float auxPeso;
                        System.out.print("\nDigite o Peso: ");
                        auxPeso = sc.nextFloat();
                        carros.get(indice).setPeso(auxPeso);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 8:
                        int auxPotencia;
                        System.out.print("\nDigite a Potencia: ");
                        auxPotencia = sc.nextInt();
                        carros.get(indice).setPotencia(auxPotencia);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 9:
                        int auxCilindros;
                        System.out.print("\nDigite o número de Cilindros: ");
                        auxCilindros = sc.nextInt();
                        carros.get(indice).setNumCilindros(auxCilindros);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 10:
                        int auxAssentos;
                        System.out.print("\nDigite o número de Assentos: ");
                        auxAssentos = sc.nextInt();
                        carros.get(indice).setKilometragem(auxAssentos);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 11:
                        int auxTipo;
                        do {
                            System.out.println("1-utilitário\n2-pickup\n3-sedan\n4-hatch\n5-esportivo");
                            System.out.print("\nDigite o tipo: ");
                            auxTipo = sc.nextInt();
                            carros.get(indice).setTipo(auxTipo);

                            if (auxTipo < 1 || auxTipo > 5)
                                System.out.println("\tValor inválido");
                        } while (auxTipo < 1 || auxTipo > 5);

                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;

                    case 12:
                        int[] auxMedidas = new int[3];
                        System.out.print("\nDigite a Altura: ");
                        auxMedidas[0] = sc.nextInt();
                        System.out.print("\nDigite a Largura: ");
                        auxMedidas[1] = sc.nextInt();
                        System.out.print("\nDigite o Comprimento: ");
                        auxMedidas[2] = sc.nextInt();

                        carros.get(indice).setDimensoes(auxMedidas);
                        ;

                        System.out.println("\n==> Dados atualizados com sucesso!");
                        break;

                    default:
                        System.out.println("\nDigite uma opção válida!\n");
                        break;
                }
            } while (opMenu < 1 || opMenu > 12);

            carrosWriteFile(); // repassa pro File os dados alterados
        }
    }

    // ------------------------------------------

    public static void removerCarro() {
        mostraArrayCarros();
        Scanner sc = new Scanner(System.in);

        int indice = 0;

        if (carros.size() == 0)
            System.out.println("\nNão há carros cadastradas.");

        else {

            do {
                System.out.print("Digite o indice do carro que deseja remover: ");
                indice = sc.nextInt();
                indice--; // diminui em 1 pra adequar ao valor do arrayList pois o "mostraArrayCarros"
                          // Mostra os valores começando no indice 1 👍

                if (indice < 0 || indice > carros.size() - 1)
                    System.out.println("\tValor Inválido");
            } while (indice < 0 || indice > carros.size() - 1);

            carros.remove(indice);

            System.out.println("\n==> Carro removido com sucesso!");

            carrosWriteFile();
        }
    }

    // ------------------------------------------

    public static void mostraArrayCarros() {
        for (int i = 0; i < carros.size(); i++) {
            System.out.printf("Carro %d:\n", i+1);
            carros.get(i).imprimirDados();
            System.out.printf("\n");
        }
    }

    // ------------------------------------------

    public static void carrosWriteFile() {
        try {
            File arq = new File("registroCarros");
            FileWriter escritor = new FileWriter(arq);

            for (Carro car : carros)
                escritor.write(car.getNumChassi() + ";" + car.getMarca() + ";" + car.getModelo() + ";" + car.getAno() +
                        ";" + car.getKilometragem() + ";" + car.getTipoCombustivel() + ";" + car.getPeso() + ";"
                        + car.getStatus() +
                        ";" + car.getPotencia() + ";" + car.getNumCilindros() + ";" + car.getNumeroOcupantes() + ";"
                        + car.getTipo() +
                        ";" + car.getAltura() + "x" + car.getLargura() + "x" + car.getComprimento() + "\n");

            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }

    // ------------------------------------------
    // Motos
    // ------------------------------------------
    public static void cadastrarMotocicletas() {
        Motocicleta novaMotocicleta = new Motocicleta();
        Scanner input = new Scanner(System.in);
        int ano;
        System.out.println("Digite as cilidradas: ");
        novaMotocicleta.setCilindradas(input.nextInt());

        int tipo;
        do {
            System.out.println("Qual o tipo da motocicleta?");
            System.out.println("1 - Trail");
            System.out.println("2 - Street");
            System.out.println("3 - Esportiva");
            System.out.println("4 - Custom");
            tipo = input.nextInt();
            if(tipo < 1 || tipo > 4)
                System.out.println("Digite uma opção válida!");
        } while (tipo < 1 || tipo > 4);
        novaMotocicleta.setTipo(tipo);

        System.out.println("Digite o número do chassi: ");
        novaMotocicleta.setNumChassi(input.nextInt());
        input.nextLine();

        System.out.println("Digite a marca: ");
        novaMotocicleta.setMarca(input.nextLine());

        System.out.println("Digite o modelo: ");
        novaMotocicleta.setModelo(input.nextLine());

        do {
            System.out.println("Digite o ano: ");
            ano = input.nextInt();
            input.nextLine();
        } while (!Data.validarAno(ano));

        novaMotocicleta.setAno(ano);

        System.out.println("Digite a kilometragem: ");
        novaMotocicleta.setKilometragem(input.nextInt());
        input.nextLine();

        System.out.println("Digite o tipo de combustível: ");
        novaMotocicleta.setTipoCombustivel(input.nextLine());

        System.out.println("Digite o peso: ");
        novaMotocicleta.setPeso(input.nextFloat());
        input.nextLine();

        novaMotocicleta.setStatus(false);

        motocicletas.add(novaMotocicleta);
        escreverMotosNoArquivo();
    }

    // ------------------------------------------

    public static void alterarMotocicletas() {
        int opMenu;
        int ano;
        Scanner input = new Scanner(System.in);
        visualizarMotocicletas();
        System.out.println("Qual motocicleta deseja alterar?");
        int moto = (input.nextInt() - 1);

        if (motocicletas.size() == 0)
            System.out.println("\nNão há motocicletas cadastradas.");
        else {

            do {
                System.out.println("Qual motocicleta deseja alterar?");
                moto = (input.nextInt() - 1);

                if (moto < 0 || moto > motocicletas.size() - 1)
                    System.out.println("\tValor Invalido");

            } while (moto < 0 || moto > motocicletas.size() - 1);

            System.out.println("\nQual dado deseja alterar?");
            System.out.println("1 - Alterar cilindradas");
            System.out.println("2 - Alterar tipo");
            System.out.println("3 - Alterar número do chassi");
            System.out.println("4 - Alterar marca");
            System.out.println("5 - Alterar modelo");
            System.out.println("6 - Alterar ano");
            System.out.println("7 - Alterar kilometragem");
            System.out.println("8 - Alterar tipo de combustível");
            System.out.println("9 - Alterar peso");
            System.out.println("10 - Alterar status");
            System.out.println("\nDigite a opção desejada: ");
            opMenu = input.nextInt();
            input.nextLine();
            int tipo;
            switch (opMenu) {
                case 1:
                    System.out.print("\nDigite as novas cilindradas: ");
                    motocicletas.get(moto).setCilindradas(input.nextInt());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 2:
                    do {
                        System.out.print("\nDigite o novo tipo: ");
                        System.out.println("1 - Trail");
                        System.out.println("2 - Street");
                        System.out.println("3 - Esportiva");
                        System.out.println("4 - Custom");
                        tipo = input.nextInt();
                            if(tipo < 1 || tipo > 4)
                                System.out.println("Digite uma opção válida!");

                    } while (tipo < 1 || tipo > 4);

                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 3:
                    System.out.print("\nDigite o novo número de chassi: ");
                    motocicletas.get(moto).setNumChassi(input.nextLong());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 4:
                    System.out.print("\nDigite a nova marca: ");
                    motocicletas.get(moto).setMarca(input.nextLine());
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 5:
                    System.out.print("\nDigite o novo modelo: ");
                    motocicletas.get(moto).setModelo(input.nextLine());
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 6:
                    do {
                        System.out.print("\nDigite o novo ano: ");
                        ano = input.nextInt();
                        input.nextLine();
                    } while (!Data.validarAno(ano));
                    motocicletas.get(moto).setAno(input.nextInt());
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 7:
                    System.out.print("\nDigite a nova kilometragem: ");
                    motocicletas.get(moto).setKilometragem(input.nextFloat());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 8:
                    System.out.print("\nDigite o novo tipo de combustível: ");
                    motocicletas.get(moto).setTipoCombustivel(input.nextLine());
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 9:
                    System.out.print("\nDigite o novo peso: ");
                    motocicletas.get(moto).setPeso(input.nextFloat());
                    input.nextLine();
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 10:
                    System.out.print("\nDigite o novo status: ");
                    motocicletas.get(moto).setStatus(input.nextBoolean());
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                case 11:
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    break;
            }
        }

        escreverMotosNoArquivo();
    }

    // ------------------------------------------

    public static void removerMotocicleta() {
        Scanner input = new Scanner(System.in);
        visualizarMotocicletas();
        System.out.println("Qual motocicleta deseja remover?");
        int moto = (input.nextInt() - 1);

        if (motocicletas.size() == 0) {
            System.out.println("\nNão há motocicletas cadastradas.");
        }

        else {
            do {
                System.out.println("Qual motocicleta deseja remover?");
                moto = (input.nextInt() - 1);
                input.nextLine();

                if (moto < 0 || moto > motocicletas.size() - 1)
                    System.out.println("\tValor Invalido");

            } while (moto < 0 || moto > motocicletas.size() - 1);

            motocicletas.remove(moto);
            System.out.println("\n\nMotocicleta removida com sucesso!");
        }

        escreverMotosNoArquivo();
    }

    // ------------------------------------------

    public static void escreverMotosNoArquivo() {
        try {
            File arq = new File("registroMotocicletas");
            FileWriter escritor = new FileWriter(arq, true);
            // lembrar que a escrita do arquivo prossegue do ponto que parou
            for (int i = 0; i < motocicletas.size(); i++) {
                escritor.write(motocicletas.get(i).getCilindradas() + ";");
                escritor.write(motocicletas.get(i).getTipo() + ";");
                escritor.write(motocicletas.get(i).getNumChassi() + ";");
                escritor.write(motocicletas.get(i).getMarca() + ";");
                escritor.write(motocicletas.get(i).getModelo() + ";");
                escritor.write(motocicletas.get(i).getAno() + ";");
                escritor.write(motocicletas.get(i).getKilometragem() + ";");
                escritor.write(motocicletas.get(i).getTipoCombustivel() + ";");
                escritor.write(motocicletas.get(i).getPeso() + ";");
                escritor.write(motocicletas.get(i).getStatus() + ";");
                escritor.write("\n");
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro" + e);
        }
    }

    // ------------------------------------------

    public static void visualizarMotocicletas() {
        for (int i = 0; i < motocicletas.size(); i++) {
            System.out.printf("\nMotocicleta %d\n", i + 1);
            motocicletas.get(i).imprimirDados();
            System.out.println("");
       }
    }

    // ------------------------------------------
    // Menu ADM
    // ------------------------------------------
    public static void menuADM(Gerente adm) {
        Scanner sc = new Scanner(System.in);
        int op_adm;

        do {
            System.out.println("\nMenu Gerente: ");
            System.out.println("\n\t--Cadastros:--");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Vendedor");
            System.out.println("3 - Cadastrar Carro");
            System.out.println("4 - Cadastrar Motocicleta");

            System.out.println("\n\t--Alteração:--");
            System.out.println("5 - ALterar dados do Cliente");
            System.out.println("6 - Alterar dados do Vendedor");
            System.out.println("7 - Alterar dados do Carro");
            System.out.println("8 - Alterar dados do Motocicleta");

            System.out.println("\n\t--Exclusão:--");
            System.out.println("9 - Remover Cliente");
            System.out.println("10 - Remover Vendedor");
            System.out.println("11 - Remover Carro");
            System.out.println("12 - Remover Motocicleta");

            System.out.println("\n\t--Mostrar:--");
            System.out.println("13 - Mostrar Cliente");
            System.out.println("14 - Mostrar Vendedor");
            System.out.println("15 - Mostrar Carro");
            System.out.println("16 - Mostrar Motocicleta");

            System.out.println("\n0 - Sair");

            System.out.print("\nComando: ");
            op_adm = sc.nextInt();
            sc.nextLine();

            switch (op_adm) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarVendedor();
                    break;
                case 3:
                    cadastrarCarro();
                    break;
                case 4:
                    cadastrarMotocicletas();
                    break;
                case 5:
                    alterarCliente();
                    break;
                case 6:
                    alterarVendedor();
                    break;
                case 7:
                    alterarCarros();
                    break;
                case 8:
                    alterarMotocicletas();
                    break;
                case 9:
                    removerCliente();
                    break;
                case 10:
                    removerVendedor();
                    break;
                case 11:
                    removerCarro();
                    break;
                case 12:
                    removerMotocicleta();
                    break;
                case 13:
                    visualizarCliente();
                    break;
                case 14:
                    listarVendedores();
                    break;
                case 15:
                    mostraArrayCarros();
                    break;
                case 16:
                    visualizarMotocicletas();
                    break;

                case 99:
                    String auxLogin = adm.getLogin();
                    adm.alterar();
                    if (!auxLogin.equals(adm.getLogin())) // Chave do hashmap (login) foi alterada
                    {
                        // atualiza a chave no hashmap (remove e reinsere com a chave nova)
                        usuarios.remove(auxLogin);
                        usuarios.put(adm.getLogin(), adm);
                    }
                default:
                    break;
            }

        } while (op_adm != 0);
    }

    public static void addGerente(Gerente novoGerente) {
        usuarios.put(novoGerente.getLogin(), novoGerente);
    }

    public static void addVendedor(Vendedor novoVendedor) {
        usuarios.put(novoVendedor.getLogin(), novoVendedor);
    }

    // Vendedor -------------------------------------------------
    // PASSAR AS FUNÇÕES DESSE MENU PRO MENU GERENTE PRINCIPAL

    // public void menuVendedoresGerente(){
    // int op;
    //
    // Scanner input = new Scanner(System.in);
    // do{
    // System.out.println("Menu Vendedores");
    // System.out.println("1 - Cadastrar um novo vendedor");
    // System.out.println("2 - Visualizar vendedores");
    // System.out.println("3 - Alterar informações de um vendedor");
    // System.out.println("4 - Excluir um vendedor");
    // System.out.println("5 - Sair");
    //
    // op = input.nextInt();
    // input.nextLine();
    //
    // switch(op){
    // case 1:
    // cadastrarVendedor();
    // break;
    // case 2:
    // listarVendedores();
    // break;
    // case 3:
    // alterarVendedor();
    // break;
    // case 4:
    // removerVendedor();
    // break;
    // case 5:
    // break;
    // default:
    // System.out.println("Digite uma opção válida!");
    // break;
    // }
    // }while(op != 5);
    // }

    public static void cadastrarVendedor() {
        Scanner input = new Scanner(System.in);
        String senha, confirSenha;
        Vendedor novoVendedor = new Vendedor();
        System.out.print("Digite o nome do vendedor: ");
        novoVendedor.setNome(input.nextLine());
        System.out.print("Digite o RG do vendedor: ");
        novoVendedor.setRG(input.nextLong());
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
        novoVendedor.setDataNasc(dataNasc);

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
        novoVendedor.setDataAdmissao(dataAdmissao);

        System.out.print("Digite o salário do vendedor:\nR$");
        novoVendedor.setSalario(input.nextFloat());

        System.out.print("Digite o tempo de treinamento:");
        novoVendedor.setTempoRestante(input.nextFloat());

        input.nextLine();
        String login_adm;
        Gerente gerente;
        Funcionario pesquisa;
        boolean temGerente = false;
        for (Funcionario f : usuarios.values()) {
            if (f instanceof Gerente)
                temGerente = true;
        }
        if (temGerente) {
            do {
                System.out.print("Digite o login do gerente responsável: ");
                login_adm = input.nextLine();
                pesquisa = Sistema.getMapUsuarios().get(login_adm);
                if (pesquisa != null && pesquisa instanceof Gerente) {
                {
                    gerente = (Gerente) pesquisa;
                    novoVendedor.setGerente(gerente);
                }
                } else {
                    System.out.println("Digite um login válido!");
                }
            } while (pesquisa == null || !(pesquisa instanceof Gerente));
        } else
            novoVendedor.setGerente(null);

        System.out.println("Crie um login e senha para o vendedor:");
        // input.nextLine();
        String login;
        do {
            System.out.print("Login: ");
            login = input.nextLine();
            if (usuarios.get(login) != null)
                System.out.println("Este login já está sendo usado, tente novamente!");
        } while (usuarios.get(login) != null);
        do {
            System.out.print("Senha: ");
            senha = input.nextLine();
            System.out.print("Confirme sua senha: ");
            confirSenha = input.nextLine();
            if (!senha.equals(confirSenha))
                System.out.println("As senhas digitadas não são iguais! Tente novamente");
        } while (!senha.equals(confirSenha));
        novoVendedor.setLogin(login);
        novoVendedor.setSenha(senha);
        usuarios.put(novoVendedor.getLogin(), novoVendedor);
    }

    // Função substituida por usuariosWriteFile();
    // public void escreverVendedoresNoArquivo(){
    // try{
    //
    // FileWriter escritor = new FileWriter("registroVendedores", true);
    // for(int i = 0; i < listaVendedores.size(); i++){
    // escritor.write(listaVendedores.get(i).getNome() + "\n");
    // escritor.write(listaVendedores.get(i).getRG() + "\n");
    // escritor.write(listaVendedores.get(i).getDataNasc() + "\n");
    // escritor.write(listaVendedores.get(i).getDataAdmissao() + "\n");
    // escritor.write(listaVendedores.get(i).getSalario() + "\n");
    // escritor.write(listaVendedores.get(i).getTempoRestante() + "\n");
    // escritor.write(listaVendedores.get(i).getGerente().getNome() + "\n");
    // escritor.write("\n");
    // }
    // escritor.close();
    // }
    // catch(IOException e)
    // {
    // System.out.println("Erro" + e);
    // }
    // }

    public static void listarNomeVendedores() {
        Vendedor v;
        for (Funcionario f : usuarios.values())
            if (f instanceof Vendedor) {
                v = (Vendedor) f;
                System.out.println("Nome: " + v.getNome() + "\nLogin: " + v.getLogin() + "\n");
            }
    }

    public static void listarVendedores() {
        Vendedor v;
        for (Funcionario f : usuarios.values())
            if (f instanceof Vendedor) {
                v = (Vendedor) f;
                v.imprimirDados();
            }
    }

    // VAI SER SUBSTITUIDA POR UMA OPÇÃO NO MENU VENDEDOR USANDO O MÉTODO DA CLASSE
    // NAO VAI NAO. PRECISA EXISTIR PRO GERENTE PODER ALTERAR OS DADOS DO VENDEDOR
    // TBM
    // public static void alterarVendedor(){
    // int op;
    // int dia, mes, ano;
    // Data novaData;
    // String senha,confirSenha;
    // listarVendedores();
    // System.out.println("Qual vendedor deseja alterar?");
    // vendedor = (input.nextInt() - 1);
    // if (listaMotocicletas.size() == 0)
    // System.out.println("\nNão há motocicletas cadastradas.");
    // else{
    // do{
    // System.out.println("\nQual dado deseja alterar?");
    // System.out.println("1 - Alterar Nome");
    // System.out.println("2 - Alterar RG");
    // System.out.println("3 - Alterar Data de Nascimento");
    // System.out.println("4 - Alterar Data de Admissão");
    // System.out.println("5 - Alterar Salário");
    // System.out.println("6 - Alterar Tempo restante de experiência");
    // System.out.println("7 - Alterar Gerente Responsável");
    // System.out.println("8 - Alterar login");
    // System.out.println("9 - Alterar senha");
    // System.out.println("10 - Sair");
    // System.out.println("\nDigite a opção desejada: ");
    // op = input.nextInt();
    // input.nextLine();
    //
    // switch(op){
    // case 1:
    // System.out.print("\nDigite o novo nome: ");
    // listaVendedores.get(vendedor).setNome(input.nextLine());
    // input.nextLine();
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // break;
    // case 2:
    // System.out.print("\nDigite o novo RG: ");
    // listaVendedores.get(vendedor).setRG(input.nextLong());
    // input.nextLine();
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // break;
    // case 3:
    // System.out.println("\nDigite a nova data de nascimento: ");
    // do{
    // System.out.print("Dia: ");
    // dia = input.nextInt();
    // }while(!Data.validarDia(dia));
    //
    // do{
    // System.out.print("Mês: ");
    // mes = input.nextInt();
    // }while(!Data.validarMes(mes));
    //
    // do{
    // System.out.print("Ano: ");
    // ano = input.nextInt();
    // }while(!Data.validarAno(ano));
    // novaData = new Data(dia, mes, ano);
    // listaVendedores.get(vendedor).setDataNasc(novaData);
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // break;
    // case 4:
    // System.out.println("\nDigite a nova data de admissão: ");
    // do{
    // System.out.print("Dia: ");
    // dia = input.nextInt();
    // }while(!Data.validarDia(dia));
    //
    // do{
    // System.out.print("Mês: ");
    // mes = input.nextInt();
    // }while(!Data.validarMes(mes));
    //
    // do{
    // System.out.print("Ano: ");
    // ano = input.nextInt();
    // }while(!Data.validarAno(ano));
    // novaData = new Data(dia, mes, ano);
    // listaVendedores.get(vendedor).setDataAdmissao(novaData);
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // break;
    // case 5:
    // System.out.print("\nDigite o novo Salário: R$ ");
    // listaVendedores.get(vendedor).setSalario(input.nextLong());
    // input.nextLine();
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // break;
    // case 6:
    // System.out.print("\nDigite o novo tempo restante: ");
    // listaVendedores.get(vendedor).setSalario(input.nextInt());
    // input.nextLine();
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // break;
    // case 7:
    // System.out.print("\nDigite o login do novo gerente responsável: ");
    // input.nextLine();
    // String login_adm = input.nextLine();
    // Gerente pesquisa = Sistema.getMapGerentes().get(login_adm);
    // if(pesquisa != null){
    // listaVendedores.get(vendedor).setGerente(pesquisa);
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // }
    // else{
    // System.out.print("Digite um login válido!");
    // }
    // break;
    // case 8:
    // System.out.print("\nDigite o novo login: ");
    // listaVendedores.get(vendedor).setLogin(input.nextLine());
    // input.nextLine();
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // break;
    // case 9:
    // do{
    // System.out.print("Digite a nova senha: ");
    // senha = input.nextLine();
    // System.out.print("Confirme a senha: ");
    // confirSenha = input.nextLine();
    // if(!senha.equals(confirSenha))
    // System.out.println("As senhas digitadas não são iguais! Tente novamente");
    // }while(!senha.equals(confirSenha));
    // listaVendedores.get(vendedor).setSenha(senha);
    // System.out.println("\n\n==> Dados atualizados com sucesso!");
    // break;
    // default:
    // System.out.println("Digite uma opção válida!");
    // break;
    //
    // }
    // }while(op != 10);
    // }
    // arqVendedor.delete();
    // escreverVendedoresNoArquivo();
    // }

    public static void alterarVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o login do vendedor que deseja remover: ");
        System.out.print("Login: ");
        Funcionario pesquisa = usuarios.get(sc.nextLine());
        if (pesquisa != null && pesquisa instanceof Vendedor) {
            Vendedor vend = (Vendedor) pesquisa;
            String auxLogin = vend.getLogin();
            vend.alterar();
            if (!auxLogin.equals(vend.getLogin())) // Chave do hashmap (login) foi alterada
            {
                // atualiza a chave no hashmap (remove e reinsere com a chave nova)
                usuarios.remove(auxLogin);
                usuarios.put(vend.getLogin(), vend);
            }
            System.out.println("Vendedor alterado com sucesso!");
        } else if (pesquisa != null && !(pesquisa instanceof Vendedor)) {
            System.out.println("O usuário especificado não é um vendedor!");
        } else
            System.out.println("Usuário não encontrado");

    }

    public static void removerVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o login do vendedor que deseja remover: ");
        System.out.print("Login: ");
        Funcionario pesquisa = usuarios.get(sc.nextLine());
        if (pesquisa != null && pesquisa instanceof Vendedor) {
            usuarios.remove(pesquisa.getLogin());
            System.out.println("Vendedor excluído com sucesso!");
        } else if (pesquisa != null && !(pesquisa instanceof Vendedor)) {
            System.out.println("O usuário especificado não é um vendedor!");
        } else
            System.out.println("Usuário não encontrado");

        // listarVendedores();
        // System.out.println("Qual vendedor deseja excluir?");
        // vendedor = (input.nextInt() - 1);
        // input.nextLine();
        //
        // if (listaVendedores.size() == 0) {
        // System.out.println("\nNão há vendedores cadastrados.");
        // }
        // else{
        // listaVendedores.remove(vendedor);
        // System.out.println("\n\nVendedor excluído com sucesso!");
    }

    // CLIENTE
    // Parte de arquivos
    // METODOS DA CLASSE
    // CLIENTE
    public static void cadastrarCliente() {
        Scanner input = new Scanner(System.in);
        int dia, mes, ano;
        Data novaData = new Data();
        Cliente novoCliente = new Cliente();

        System.out.println("Digite o CPF: ");
        novoCliente.setCPF(input.nextInt());
        input.nextLine();

        System.out.println("Digite o nome: ");
        novoCliente.setNome(input.nextLine());

        System.out.println("Digite a data de nascimento: ");
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

        novoCliente.setDataNasc(new Data(dia,mes,ano));
        input.nextLine();

        System.out.println("Digite o endereço: ");
        System.out.println("Rua: ");
        novoCliente.setRua(input.nextLine());
        System.out.println("Número: ");
        novoCliente.setNumeroCasa(input.nextInt());
        input.nextLine();
        System.out.println("Bairro: ");
        novoCliente.setBairro(input.nextLine());
        System.out.println("Cidade: ");
        novoCliente.setCidade(input.nextLine());

        System.out.println("Digite a renda: ");
        novoCliente.setRenda(input.nextFloat());
        input.nextLine();

        System.out.println("Digite o número de dependentes: ");
        novoCliente.setDependentes(input.nextInt());
        input.nextLine();

        clientes.add(novoCliente);

    }

    public static void clientesWriteFile() {
        File arq = new File("registroClientes");
        try {
            FileWriter escritor = new FileWriter(arq, false);
            for (Cliente cli : clientes)
                escritor.write(cli.getCPF() + ";" + cli.getNome() + ";" + cli.getDataNasc().criarData() + ";" + cli.getRua() +
                        ";" + cli.getNumeroCasa() + ";" + cli.getBairro() + ";" + cli.getCidade() + ";" + cli.getRenda()
                        +
                        ";" + cli.getDependentes() + ";" + "\n");

            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

    }

    public static void visualizarCliente() {
        int i = 1;

        for (Cliente cli : clientes) {
//            System.out.printf("Cliente %d:\n", i);
//            System.out.println(cli.getCPF() + ";" + cli.getNome() + ";" + cli.getDataNasc() + ";" + cli.getRua() +
//                    ";" + cli.getNumeroCasa() + ";" + cli.getBairro() + ";" + cli.getCidade() + ";" + cli.getRenda() +
//                    ";" + cli.getDependentes() + ";" + "\n");
            cli.imprimirDados();
            i++;
            System.out.printf("\n");
        }
    }

    public static void alterarCliente() {
        Scanner input = new Scanner(System.in);
        int opMenu;
        int dia, mes, ano;
        Data novaData = new Data();
        visualizarCliente();
        System.out.println("Qual cliente deseja alterar?");
        int cliente = (input.nextInt() - 1);

        if (clientes.size() == 0)
            System.out.println("\nNão há clientes cadastrados.");
        else {
            do {
                System.out.println("\nQual dado deseja alterar?");
                System.out.println("1 - Alterar CPF");
                System.out.println("2 - Alterar nome");
                System.out.println("3 - Alterar data de nascimento");
                System.out.println("4 - Alterar rua");
                System.out.println("5 - Alterar número da casa");
                System.out.println("6 - Alterar bairro");
                System.out.println("7 - Alterar cidade");
                System.out.println("8 - Alterar renda");
                System.out.println("9 - Alterar número de dependentes");
                System.out.println("10 - Sair");
                System.out.println("\nDigite a opção desejada: ");
                opMenu = input.nextInt();
                input.nextLine();

                switch (opMenu) {
                    case 1:
                        System.out.print("\nDigite o novo CPF: ");
                        clientes.get(cliente).setCPF(input.nextInt());
                        input.nextLine();
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 2:
                        System.out.print("\nDigite o novo nome: ");
                        clientes.get(cliente).setNome(input.nextLine());
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 3:
                        System.out.print("\nDigite a nova data de nascimento: ");
                        do {
                            System.out.print("Dia: ");
                            dia = input.nextInt();
                            input.nextLine();
                        } while (Data.validarDia(dia));

                        novaData.setDia(dia);

                        do {
                            System.out.print("Mês: ");
                            mes = input.nextInt();
                            input.nextLine();
                        } while (Data.validarMes(mes));

                        novaData.setMes(mes);

                        do {
                            System.out.print("Ano: ");
                            ano = input.nextInt();
                            input.nextLine();
                        } while (Data.validarAno(ano));

                        novaData.setAno(ano);
                        clientes.get(cliente).setDataNasc(novaData);
                        input.nextLine();
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 4:
                        System.out.print("\nDigite a nova rua: ");
                        clientes.get(cliente).setRua(input.nextLine());
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 5:
                        System.out.print("\nDigite o novo número da casa: ");
                        clientes.get(cliente).setNumeroCasa(input.nextInt());
                        input.nextLine();
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 6:
                        System.out.print("\nDigite o novo bairro: ");
                        clientes.get(cliente).setBairro(input.nextLine());
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 7:
                        System.out.print("\nDigite a nova cidade: ");
                        clientes.get(cliente).setCidade(input.nextLine());
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 8:
                        System.out.print("\nDigite a nova renda: ");
                        clientes.get(cliente).setRenda(input.nextFloat());
                        input.nextLine();
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 9:
                        System.out.print("\nDigite o novo número de dependentes: ");
                        clientes.get(cliente).setDependentes(input.nextInt());
                        input.nextLine();
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                        break;
                    case 10:
                        break;
                    default:
                        System.out.println("\nDigite uma opção válida!\n");
                        break;
                }
            } while (opMenu != 10);
        }

        clientesWriteFile();

    }

    public static void removerCliente() {
        Scanner input = new Scanner(System.in);
        visualizarCliente();
        System.out.println("Qual cliente deseja remover?");
        int cliente = (input.nextInt() - 1);
        input.nextLine();

        if (clientes.size() == 0) {
            System.out.println("\nNão há clientes cadastradas.");
        } else {
            clientes.remove(cliente);
            System.out.println("\n\nCliente removido com sucesso!");
        }

        clientesWriteFile();

    }

    public static Map<String, Funcionario> getMapUsuarios() {
        return usuarios;
    }

    public static void gerentesWriteFile() {

        try {
            File arquivo = new File("registroGerentes");
            FileWriter gWriter = new FileWriter(arquivo, false);
            for (Funcionario f : usuarios.values()) {
                if (f instanceof Gerente) {

                    Gerente g = (Gerente) f;
                    gWriter.write(g.getRG() + ";" + g.getNome() + ";" + g.getDataNasc().criarData() + ";"
                            + g.getDataAdmissao().criarData() + ";" + g.getSalario() + ";" + g.getAnosExp() + ";"
                            + g.getLogin() + ";" + g.getSenha() + "\n");
                }
            }
           gWriter.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void vendedoresWriteFile()
    {
        try{
            FileWriter vWriter = new FileWriter(new File("registroVendedores"), false);
            for (Funcionario f : usuarios.values()) {
                if (f instanceof Vendedor) {
                    Vendedor v = (Vendedor) f;
                    // Pra parte do gerente, ele vai salvar o login do gerente no arquivo.
                    if(v.getLogin() != null)
                    vWriter.write(v.getRG() + ";" + v.getNome() + ";" + v.getDataNasc().criarData() + ";"
                            + v.getDataAdmissao().criarData() + ";" + v.getSalario() + ";" + v.getTempoRestante() + ";"
                            + v.getGerente().getLogin() + ";" + v.getLogin() + ";" + v.getSenha() + "\n");
                    else
                    vWriter.write(v.getRG() + ";" + v.getNome() + ";" + v.getDataNasc().criarData() + ";"
                            + v.getDataAdmissao().criarData() + ";" + v.getSalario() + ";" + v.getTempoRestante() + ";"
                            + "null" + ";" + v.getLogin() + ";" + v.getSenha() + "\n");
//                if(v.getLogin() == null)
//                    System.out.println("PROBLEMA NO LOGIN");
//                if(v.getDataAdmissao() == null)
//                    System.out.println("PROBLEMA NA DATA DE ADMISSAO");
//                if(v.getDataNasc() == null)
//                    System.out.println("PROBLEMA NA DATA DE NASCIMENTO");
                }
            }
            vWriter.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro: " + e);
        }
 
    }

    public static void loadFiles() {
        // Fazer os negocio de ler arquivo e botar tudo nas Coleções aqui

        // Ler gerentes
        try {
            FileReader arquivo = new FileReader("registroGerentes");
            BufferedReader reader = new BufferedReader(arquivo);
            while (reader.ready()) {
                String dados[] = reader.readLine().split(";");
                String DMA[] = dados[2].split("/");
                Data dataNasc = new Data(Integer.parseInt(DMA[0]), Integer.parseInt(DMA[1]), Integer.parseInt(DMA[2]));
                String DMA2[] = dados[3].split("/");
                Data dataAdmissao = new Data(Integer.parseInt(DMA2[0]), Integer.parseInt(DMA2[1]),
                        Integer.parseInt(DMA2[2]));
                long RG = Long.parseLong(dados[0]);
                float salario = Float.parseFloat(dados[4]);
                int anosExp = Integer.parseInt(dados[5]);
                Gerente gerente = new Gerente(RG, dados[1], dataNasc, dataAdmissao, salario, anosExp, dados[6],
                        dados[7]);
                usuarios.put(gerente.getLogin(), gerente);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

        // Ler vendedores
        try {
            FileReader arquivo = new FileReader("registroVendedores");
            BufferedReader reader = new BufferedReader(arquivo);
            while (reader.ready()) {
                String dados[] = reader.readLine().split(";");
                for (int i = 0; i < dados.length; i++)
                    System.out.println("dados[" + i + "] : " + dados[i]);

                String DMA[] = dados[2].split("/");
                Data dataNasc = new Data(Integer.parseInt(DMA[0]), Integer.parseInt(DMA[1]), Integer.parseInt(DMA[2]));
                String DMA2[] = dados[3].split("/");
                Data dataAdmissao = new Data(Integer.parseInt(DMA2[0]), Integer.parseInt(DMA2[1]),
                        Integer.parseInt(DMA2[2]));
                long RG = Long.parseLong(dados[0]);
                float salario = Float.parseFloat(dados[4]);
                float TempoRestante = Float.parseFloat(dados[5]);
                Gerente gResponsavel = (Gerente) usuarios.get(dados[6]);

                Vendedor vendedor = new Vendedor(RG, dados[1], dataNasc, dataAdmissao, salario, TempoRestante,
                        gResponsavel, dados[7], dados[8]);
                vendedor.setLogin(dados[7]);
                vendedor.setSenha(dados[8]);
                usuarios.put(vendedor.getLogin(), vendedor);

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

        // Ler carros
        try {

            FileReader arquivo = new FileReader("registroCarros");
            BufferedReader reader = new BufferedReader(arquivo);
            while (reader.ready()) {
                String dados[] = reader.readLine().split(";");
                long numChassi = Long.parseLong(dados[0]);
                String marca = dados[1];
                String modelo = dados[2];
                int ano = Integer.parseInt(dados[3]);
                float kilometragem = Float.parseFloat(dados[4]);
                String tipoCombustivel = dados[5];
                float peso = Float.parseFloat(dados[6]);
                boolean status = Boolean.parseBoolean(dados[7]);
                int potencia = Integer.parseInt(dados[8]);
                int numCilindros = Integer.parseInt(dados[9]);
                int numeroOcupantes = Integer.parseInt(dados[10]);
                int tipo = Integer.parseInt(dados[11]);
                String dims[] = dados[12].split("x");
                int dimensoes[] = new int[3];
                dimensoes[0] = Integer.parseInt(dims[0]);
                dimensoes[1] = Integer.parseInt(dims[1]);
                dimensoes[2] = Integer.parseInt(dims[2]);
                Carro carro = new Carro(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel, peso, status,
                        potencia, numCilindros, numeroOcupantes, tipo, dimensoes);
                carros.add(carro);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

        // Ler motos
        try {
            FileReader arquivo = new FileReader("registroMotocicletas");
            BufferedReader reader = new BufferedReader(arquivo);
            while (reader.ready()) {
                String dados[] = reader.readLine().split(";");
                int cilindradas = Integer.parseInt(dados[0]);
                int tipo = Integer.parseInt(dados[1]);
                long numChassi = Long.parseLong(dados[2]);
                String marca = dados[3];
                String modelo = dados[4];
                int ano = Integer.parseInt(dados[5]);
                float kilometragem = Float.parseFloat(dados[6]);
                String tipoCombustivel = dados[7];
                float peso = Float.parseFloat(dados[8]);
                boolean status = Boolean.parseBoolean(dados[9]);

                Motocicleta moto = new Motocicleta(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel,
                        peso, status, cilindradas, tipo);
                motocicletas.add(moto);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

        //Ler clientes
        try {
            
            FileReader arquivo = new FileReader("registroClientes");
            BufferedReader reader = new BufferedReader(arquivo);
            while (reader.ready()) {
                String dados[] = reader.readLine().split(";");
                for (int i = 0; i < dados.length; i++)
                    System.out.println("dados[" + i + "] : " + dados[i]);
                long CPF = Long.parseLong(dados[0]);
                String nome = dados[1];
                String DMA[] = dados[2].split("/");
                Data dataNasc = new Data(Integer.parseInt(DMA[0]), Integer.parseInt(DMA[1]), Integer.parseInt(DMA[2]));
                String rua = dados[3];
                int numCasa = Integer.parseInt(dados[4]);
                String bairro = dados[5];
                String cidade = dados[6];
                float renda = Float.parseFloat(dados[7]);
                int dependentes = Integer.parseInt(dados[8]);
                Cliente cli = new Cliente(CPF, nome, dataNasc, rua, numCasa, bairro, cidade, renda,dependentes);
                clientes.add(cli);
                //User writer.close() tava dando um IOException
            }
        } catch (Exception e) {
            System.out.println("Erro clientes: " + e);
        }

    }
    /*
     * escritor.write(motocicletas.get(i).getCilindradas() + ";");
     * escritor.write(motocicletas.get(i).getTipo() + ";");
     */

    /*
     * VENDA
     * sugestao: id da venda ser o indice + 1
     * public static void cadastroVenda(Vendedor vendedor)
     * {
     * int op, dia, mes, ano, hora, minutos;
     * Venda novaVenda;
     * Scanner input = new Scanner(System.in);
     * 
     * System.out.println("Menu Venda: ");
     * 
     * 
     * visualizarCliente();
     * System.out.println("Digite o cliente: ");
     * novaVenda.setCliente(clientes.get(input.nextInt() - 1);
     * System.out.println("Qual é o veículo?");
     * System.out.println("1 - Carro");
     * System.out.println("2 - Motocicleta");
     * do{
     * switch(input.nextInt()){
     * case 1:
     * visualizarMotos();
     * System.out.println("Digite a motocicleta vendida:");
     * novaVenda.setVeiculo(motocicletas(input.nextInt() - 1));
     * input.nextLine();
     * break;
     * case2:
     * mostraArrayCarros();
     * System.out.println("Digite o carro vendido:");
     * novaVenda.setVeiculo(carros(input.nextInt() - 1));
     * input.nextLine();
     * break;
     * default:
     * System.out.println("Digite uma opção válida!");
     * break;
     * }
     * }while(input.nextInt() != 1 || input.nextInt() != 2);
     * input.nextLine();
     * 
     * System.out.println("Digite o valor da venda");
     * novaVenda.setValor(input.nextFloat());
     * input.nextLine();
     * System.out.println("Digite a data da venda:");
     * do {
     * System.out.println("Digite o dia: ");
     * dia = input.nextInt();
     * input.nextLine();
     * } while(!Data.validarDia(dia));
     * novaVenda.setDia(dia);
     * do {
     * System.out.println("Digite o mês: ");
     * mes = input.nextInt();
     * input.nextLine();
     * } while(!Data.validarMes(mes));
     * novaVenda.setMes(mes);
     * do {
     * System.out.println("Digite o ano: ");
     * ano = input.nextInt();
     * input.nextLine();
     * } while(!Data.validarAno(ano));
     * novaVenda.setAno(ano); //talvez precise fazer esses setters
     * 
     * System.out.println("Digite o horário da venda:");
     * do {
     * System.out.println("Digite a hora: ");
     * hora = input.nextInt();
     * input.nextLine();
     * } while(!Horario.validarHora(hora));
     * novaVenda.setHora(hora);
     * do {
     * System.out.println("Digite os minutos: ");
     * minutos = input.nextInt();
     * input.nextLine();
     * } while(!Horario.validarMinutos(minutos));
     * novaVenda.setMinutos(minutos);
     * 
     * indiceId++;
     * novaVenda.setID(indiceId);
     * 
     * venda.add(novaVenda);
     * }
     * 
     * public static void mostraVendas() {
     * int i=1;
     * 
     * for (Venda v : vendas) {
     * System.out.printf("Venda %d:\n", i);
     * System.out.println("ID: " + v.getID() + "\nCliente: " +
     * v.getCliente() + "\nVendedor: " + v.getVendedor() + "\nVeículo: " +
     * v.getVeiculo() +
     * "\nValor: " + v.getValor() + "\nData: " +
     * v.getData() + "\nHorário: " + v.getHorario() + "\n");
     * i++;
     * System.out.printf("\n");
     * }
     * }
     * 
     * public static void alterarVenda() {
     * int indice = 0;
     * Scanner sc = new Scanner(System.in);
     * 
     * mostraVendas();
     * 
     * if (vendas.size() == 0)
     * System.out.println("\nNão há vendas cadastradas.");
     * 
     * else {
     * do {
     * System.out.print("Digite o índice da venda que deseja alterar: ");
     * indice = sc.nextInt();
     * sc.nextLine();
     * indice--;
     * if (indice < 0 || indice > vendas.size() - 1)
     * System.out.println("\tÍndice inválido!");
     * 
     * } while (indice < 0 || indice > vendas.size() - 1);
     * 
     * Venda v = vendas.get(indice);
     * System.out.println("\nQual dado deseja alterar?");
     * System.out.println("1 - Alterar cliente");
     * System.out.println("2 - Alterar vendedor");
     * System.out.println("3 - Alterar veículo");
     * System.out.println("4 - Alterar valor");
     * System.out.println("5 - Alterar data");
     * System.out.println("6 - Alterar horário");
     * System.out.println("\nDigite a opção desejada: ");
     * int opMenu = input.nextInt();
     * input.nextLine();
     * switch (opMenu) {
     * case 1:
     * listarNomeVendedores();
     * System.out.print("\nDigite o login do novo vendedor: ");
     * v.setVendedor(usuarios.get(input.nextLine());
     * input.nextLine();
     * System.out.println("\n\n==> Dados atualizados com sucesso!");
     * break;
     * case 2:
     * visualizarClientes();
     * System.out.print("\nDigite o novo cliente: ");
     * v.setCliente(clientes(input.nextInt() - 1);
     * input.nextLine();
     * System.out.println("\n\n==> Dados atualizados com sucesso!");
     * break;
     * case 3:
     * System.out.print("\nQual o novo veículo?");
     * System.out.print("\n1 - Motocicleta");
     * System.out.print("\n2 - Carro");
     * switch(input.nextInt()){
     * case 1:
     * visualizarMotos();
     * System.out.print("\nDigite a nova moto: ");
     * v.setVeiculo(motocicletas(input.nextInt() - 1);
     * input.nextLine();
     * break;
     * case 2:
     * mostraArrayCarros();
     * System.out.print("\nDigite o novo carro: ");
     * v.setVeiculo(carros(input.nextInt() - 1);
     * input.nextLine();
     * break;
     * }
     * 
     * default:
     * System.out.println("\nDigite uma opção válida!\n");
     * break;
     * }
     * }
     * vendasWriteFile(); // repassa pro File os dados alterados, n tem essa funcao
     * ainda
     * }
     * }
     * 
     */

}