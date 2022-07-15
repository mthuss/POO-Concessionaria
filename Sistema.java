import java.util.Scanner;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Sistema {

	  public static Map<String,Funcionario> usuarios = new HashMap<>();  //Idealmente, mover isso para o Sistema.java. 
    public static ArrayList <Carro> carros = new ArrayList<>();
    public static ArrayList<Motocicleta> motocicletas = new ArrayList<>();
    
    public static void menuVendedor(Vendedor vendedor)
    {
        int op;

        do{
        System.out.println("Menu Vendedor: ");
        System.out.println("1 - Visualizar Veículos");
        System.out.println("2 - Visualizar Clientes");
        System.out.println("3 - Visualizar Vendas");
        System.out.println("4 - Realizar uma Venda");
        System.out.println("5 - Sair");
        
        op = input.nextInt();
        input.nextLine();
        switch(op){
            case 1:
                System.out.println("Visualizar Veículos");
                System.out.println("1 - Visualizar Carros");
                System.out.println("2 - Visualizar Motos");
                int subop = input.nextInt();
                input.nextLine();
                switch(subop){
                    case 1:
                        //Método de exibir carros
                    break;
                    case 2:
                        visualizarMotocicletas();
                    break;
                }
            break;
            case 2:
                //método listar clientes
            break;
            case 3:
                //método listar vendas
            break;
            case 4:
                //???
            break;
            case 5:
            break;
            default:
                System.out.println("Digite uma opção válida!");
            break;
        }


        }while(op != 5);
        
    }    

    //------------------------------------------
    //Funções do Menu ADM

    //------------------------------------------
    //Carros
    //------------------------------------------
    
    static void cadastrarCarro()   {
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Digite os dados referentes ao carro:");
            System.out.print("Numero do chassi: "); //Long
            long auxChassi = scan.nextLong();

            System.out.print("Marca: "); //String
            scan.nextLine();
            String auxMarca = scan.nextLine();

            System.out.print("Modelo: "); //String
            String auxModelo = scan.nextLine();
            
            System.out.print("Ano de fabricação: "); //int
            int auxAno = scan.nextInt();
            scan.nextLine();

            System.out.print("Kilometragem: "); //float
            float auxKilo = scan.nextFloat();
            scan.nextLine();

            System.out.print("Tipo de combustivel: "); //String
            String auxCombustivel = scan.nextLine();

            System.out.print("Peso em kilogramas: "); //float
            float auxPeso = scan.nextFloat();

            //aqui seria o status mas será falso por padrão

            System.out.print("Potência em cavalos: "); //em cavalos?
            int auxPotencia = scan.nextInt();

            System.out.print("Número de cilindros: ");
            int auxCilindros = scan.nextInt();

            System.out.print("Numero de assentos: ");
            int auxAssentos = scan.nextInt();

            int auxTipo; //para o tipo de carro
            do {
                System.out.println("\tTipo de carro: ");
                System.out.println("1-utilitário\n2-pickup\n3-sedan\n4-hatch\n5-esportivo");
                System.out.print("Comando: ");
                auxTipo = scan.nextInt();

                if (auxTipo < 1 || auxTipo > 5)
                    System.out.println("\tValor invalido");
            } while(auxTipo < 1 || auxTipo > 5);

            int auxDimensoes [] = new int[3];
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

    //------------------------------------------

    public static void alterarCarros() {
        int indice=0;
        Scanner sc = new Scanner(System.in);

        mostraArrayCarros();
        
        if (carros.size() == 0) 
            System.out.println("\nNão há carros cadastradas.");
        
        else{
            do  {
                System.out.print("Digite o indice do carro que deseja alterar: ");
                indice = sc.nextInt();
                sc.nextLine();
                indice--;

                if (indice<0 || indice>carros.size()-1)
                    System.out.println("\tIndice inválido!");

            } while (indice<0 || indice>carros.size()-1);        
    
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
                    }   while (auxTipo < 1 || auxTipo > 5);
                        
                    System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;

                    case 12:
                    int [] auxMedidas = new int[3];
                    System.out.print("\nDigite a Altura: ");
                    auxMedidas[0] = sc.nextInt();
                    System.out.print("\nDigite a Largura: ");
                    auxMedidas[1] = sc.nextInt();                    
                    System.out.print("\nDigite o Comprimento: ");
                    auxMedidas[2] = sc.nextInt();

                    carros.get(indice).setDimensoes(auxMedidas);;

                    System.out.println("\n==> Dados atualizados com sucesso!");
                    break;

                    default:
                        System.out.println("\nDigite uma opção válida!\n");
                    break;
                }
            } while(opMenu < 1 || opMenu > 12);
        
            carrosWriteFile(); //repassa pro File os dados alterados    
        }
    }
    
    //------------------------------------------

    public static void removerCarro()   {
        mostraArrayCarros();
        Scanner sc = new Scanner(System.in);

        int indice=0;

        if (carros.size() == 0) 
            System.out.println("\nNão há carros cadastradas.");
    
        else{        

            do  {
                System.out.print("Digite o indice do carro que deseja remover: ");
                indice = sc.nextInt();
                indice--; //diminui em 1 pra adequar ao valor do arrayList pois o "mostraArrayCarros"
                          //Mostra os valores começando no indice 1 👍

                if (indice<0 || indice>carros.size()-1)
                    System.out.println("\tValor Inválido");
            } while(indice<0 || indice>carros.size()-1);
    
            carros.remove(indice);

            System.out.println("\n==> Carro removido com sucesso!");

            carrosWriteFile();
        }
    }

    //------------------------------------------

    public static void mostraArrayCarros()  {
        int i=1;

        for (Carro car : carros)    {
            System.out.printf("Carro %d:\n", i);
            System.out.println("Numero do chassi: " + car.getNumChassi() + "\nMarca: " + car.getMarca() + "\nModelo: " + car.getModelo() + "\nAno: " + car.getAno() +
                "\nKilometragem: " + car.getKilometragem() + "\nTipo de Combustivel: " + car.getTipoCombustivel() + "\nPeso: " + car.getPeso() + "\nStatus de venda: " + car.getStatus() + 
                "\nPotencia: " + car.getPotencia() + "\nNumero de Cilindros: " + car.getNumCilindros() + "\nNumero de assentos: " + car.getNumeroOcupantes() + "\nTipo de carro: " + car.getTipo() +
                "\nDimensões (altura x largura x comprimento): " + car.getAltura() + "x" + car.getLargura() + "x" + car.getComprimento() + "\n");
        i++;
        System.out.printf("\n");
        }
     }

    //------------------------------------------

    public static void carrosWriteFile()
    {
        try {
            File arq = new File("registroCarros");
            FileWriter escritor = new FileWriter(arq);

            for(Carro car : carros)
            escritor.write(car.getNumChassi() + ";" + car.getMarca() + ";" + car.getModelo() + ";" + car.getAno() +
                ";" + car.getKilometragem() + ";" + car.getTipoCombustivel() + ";" + car.getPeso() + ";" + car.getStatus() + 
                ";" + car.getPotencia() + ";" + car.getNumCilindros() + ";" + car.getNumeroOcupantes() + ";" + car.getTipo() +
                ";" + car.getAltura() + "x" + car.getLargura() + "x" + car.getComprimento() + "\n");

           escritor.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }


	 
    //------------------------------------------
    //Motos
    //------------------------------------------
    public void menuMotocicletaGerente(){
        //o Gerente pode alterar
        int op;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Menu Motocicleta");
            System.out.println("1 - Cadastrar motocicleta");
            System.out.println("2 - Visualizar motocicletas");
            System.out.println("3 - Alterar informações de motocicletas");
            System.out.println("4 - Excluir motocicleta");
            System.out.println("5 - Sair");

            op = input.nextInt();
            input.nextLine();
        
        
            switch(op){
                case 1: 
                    cadastrarMotocicletas();
                break;
                case 2:
                    visualizarMotocicletas();
                break;
                case 3:
                    alterarMotocicletas();
                break;
                case 4:
                    removerMotocicleta();
                break;
                case 5:
                break;               
                default: 
                    System.out.println("Digite uma opção válida!");
                break;
            }
        }while(op != 5);      
    }

    
    public static void cadastrarMotocicletas(){        
        Motocicleta novaMotocicleta = new Motocicleta();
        Scanner input = new Scanner(System.in);
        int ano;
        System.out.println("Digite as cilidradas: ");
        novaMotocicleta.setCilindradas(input.nextInt());
        input.nextLine();
        
        do{
            System.out.println("Qual o tipo da motocicleta?");
            System.out.println("1 - Trail");
            System.out.println("2 - Street");
            System.out.println("3 - Esportiva");
            System.out.println("4 - Custom");        
            switch(input.nextInt()){
                case 1:
                    novaMotocicleta.setTipo("Trail");
                break;       
                case 2:
                    novaMotocicleta.setTipo("Street");
                break;
                case 3:
                    novaMotocicleta.setTipo("Esportiva");
                break;
                case 4:
                    novaMotocicleta.setTipo("Custom");
                break;
                default:
                    System.out.println("Digite uma opção válida!");
                break;
            }
        } while(input.nextInt() < 1 || input.nextInt() > 4);
        
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
        } while(!Data.validarAno(ano));
        
        novaMotocicleta.setAno(ano);
       
        
        System.out.println("Digite a kilometragem: ");
        novaMotocicleta.setKilometragem(input.nextInt());
        input.nextLine();
        
        System.out.println("Digite o tipo de combustível: ");
        novaMotocicleta.setTipoCombustivel(input.nextLine());
        
        System.out.println("Digite o peso: ");
        novaMotocicleta.setPeso(input.nextFloat());
        input.nextLine();
        
        System.out.println("Digite o status: ");
        novaMotocicleta.setStatus(input.nextBoolean());

        motocicletas.add(novaMotocicleta);
        escreverMotosNoArquivo();  
    }


    //------------------------------------------


    public static void alterarMotocicletas(){                
        int opMenu;
        int ano;
        Scanner input = new Scanner(System.in);
        int moto;


        visualizarMotocicletas();
        
        if (motocicletas.size() == 0) 
        System.out.println("\nNão há motocicletas cadastradas.");
        else{
            
            do {
                System.out.println("Qual motocicleta deseja alterar?");
                moto = (input.nextInt() - 1);

                if (moto < 0 || moto > motocicletas.size()-1)
                    System.out.println("\tValor Invalido");

            } while (moto < 0 || moto > motocicletas.size()-1);

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
    
                switch (opMenu) {
                    case 1:
                        System.out.print("\nDigite as novas cilindradas: ");
                        motocicletas.get(moto).setCilindradas(input.nextInt());  
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 2:
                    do{
                        System.out.print("\nDigite o novo tipo: ");                        
                        System.out.println("1 - Trail");
                        System.out.println("2 - Street");
                        System.out.println("3 - Esportiva");
                        System.out.println("4 - Custom");   
                        switch(input.nextInt()){
                            case 1:
                                motocicletas.get(moto).setTipo("Trail");
                            break;       
                            case 2:
                                motocicletas.get(moto).setTipo("Street");
                            break;
                            case 3:
                                motocicletas.get(moto).setTipo("Esportiva");
                            break;
                            case 4:
                                motocicletas.get(moto).setTipo("Custom");
                            break;
                            default:
                                System.out.println("Digite uma opção válida!");
                            break;
                        }
                            
                    } while(input.nextInt() < 1 || input.nextInt() > 4);   
                        
                           
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
                        } while(!Data.validarAno(ano));                    
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

    //------------------------------------------

    public static void removerMotocicleta(){
        Scanner input = new Scanner(System.in);
        int moto=0;

        visualizarMotocicletas();
        if (motocicletas.size() == 0) {
            System.out.println("\nNão há motocicletas cadastradas.");            
        }
        
        else{
            do {
                System.out.println("Qual motocicleta deseja remover?");
                moto = (input.nextInt() - 1);
                input.nextLine();

                if (moto < 0 || moto > motocicletas.size()-1)
                    System.out.println("\tValor Invalido");

            } while (moto < 0 || moto > motocicletas.size()-1);

                motocicletas.remove(moto);
                System.out.println("\n\nMotocicleta removida com sucesso!");
        }

    escreverMotosNoArquivo();
    }

    //------------------------------------------

    public static void escreverMotosNoArquivo(){
        try{            
            File arq = new File("registroMotocicletas");
            FileWriter escritor = new FileWriter(arq, true);
            //lembrar que a escrita do arquivo prossegue do ponto que parou
            for(int i = 0; i < motocicletas.size(); i++){
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
        }
        catch(IOException e)
        {
            System.out.println("Erro" + e);
        }
    }

    //------------------------------------------

    public static void visualizarMotocicletas(){
        for(int i = 0; i < motocicletas.size(); i++){
            System.out.printf("\nMotocicleta %d\n", i+1);
            System.out.println("Cilidradas: " + motocicletas.get(i).getCilindradas());
            System.out.println("Tipo: " + motocicletas.get(i).getTipo());
            System.out.println("Número do chassi: " + motocicletas.get(i).getNumChassi());
            System.out.println("Marca: " + motocicletas.get(i).getMarca());
            System.out.println("Modelo: " + motocicletas.get(i).getModelo());
            System.out.println("Ano: " + motocicletas.get(i).getAno());
            System.out.println("Kilometragem: " + motocicletas.get(i).getKilometragem());
            System.out.println("Tipo de Combustível: " + motocicletas.get(i).getTipoCombustivel());
            System.out.println("Peso: " + motocicletas.get(i).getPeso());
            System.out.println("Status: " + motocicletas.get(i).getStatus());
        }
    }
    
    //------------------------------------------
    //Menu ADM
    //------------------------------------------
    public static void menuADM(Gerente adm)
    {
        Scanner sc = new Scanner(System.in);
        int op_adm;


        do  {
            System.out.println("\nMenu Gerente: ");
            System.out.println("\n\t--Cadastros:--");
            System.out.println("1 - Cadastrar Vendedor");
            System.out.println("2 - Cadastrar Carro");
            System.out.println("3 - Cadastrar Motocicleta");

            System.out.println("\n\t--Alteração:--");
            System.out.println("4 - Alterar dados do Vendedor");
            System.out.println("5 - Alterar dados do Carro");
            System.out.println("6 - Alterar dados do Motocicleta");
            System.out.println("99 - Alterar meu cadastro");
        
            System.out.println("\n\t--Exclusão:--");
            System.out.println("7 - Remover dados do Vendedor");
            System.out.println("8 - Remover dados do Carro");
            System.out.println("9 - Remover dados do Motocicleta");

            System.out.println("\n0 - Sair");

            System.out.print("\nComando: ");
            op_adm = sc.nextInt();
            sc.nextLine();

            switch(op_adm)  {
                case 1: break;
                case 2: 
                    cadastrarCarro();
                    break;
                case 3: 
                    cadastrarMotocicletas();
                    break;

                case 4: break;
                case 5: 
                    alterarCarros();
                    break;
                case 6: 
                    alterarMotocicletas();
                    break;
                
                case 7: break;
                case 8: 
                    removerCarro();
                    break;
                case 9: 
                    removerMotocicleta();
                    break;
            
                case 99:
                    String auxLogin = adm.getLogin();
                    adm.alterar();
                    if(!auxLogin.equals(adm.getLogin())) //Chave do hashmap (login) foi alterada
                    {
                        //atualiza a chave no hashmap (remove e reinsere com a chave nova)
                        usuarios.remove(auxLogin);
                        usuarios.put(adm.getLogin(),adm);
                    }
                default: break;
            }


        } while (op_adm != 0);
    }

   public static void addGerente(Gerente novoGerente)
    {
		usuarios.put(novoGerente.getLogin(),novoGerente);
    }

    //Vendedor -------------------------------------------------
    public void menuVendedoresGerente(){
        int op;

        do{
            System.out.println("Menu Vendedores");
            System.out.println("1 - Cadastrar um novo vendedor");
            System.out.println("2 - Visualizar vendedores");
            System.out.println("3 - Alterar informações de um vendedor");
            System.out.println("4 - Excluir um vendedor");
            System.out.println("5 - Sair");

            op = input.nextInt();
            input.nextLine();

            switch(op){
                case 1:
                    cadastrarVendedor();
                break;
                case 2:
                    listarVendedores();
                break;
                case 3:
                    alterarVendedor();
                break;
                case 4:
                    removerVendedor();
                break;
                case 5:
                break;
                default:
                    System.out.println("Digite uma opção válida!");
                break;
            }
        }while(op != 5);  
    }

    public void cadastrarVendedor(){
        String senha,confirSenha;
        Vendedor novoVendedor = new Vendedor();
        System.out.print("Digite o nome do vendedor: ");
        novoVendedor.setNome(input.nextLine());
        System.out.print("Digite o RG do vendedor: ");
        novoVendedor.setRG(input.nextLong());
        System.out.println("Digite a data de nascimento do vendedor: ");
        int dia, mes, ano;
        do{
            System.out.print("Dia: ");
            dia = input.nextInt();
        }while(!Data.validarDia(dia));

        do{
            System.out.print("Mês: ");
            mes = input.nextInt();
        }while(!Data.validarMes(mes));

        do{
            System.out.print("Ano: ");
            ano = input.nextInt();
        }while(!Data.validarAno(ano));

        Data dataNasc = new Data(dia, mes, ano);
        novoVendedor.setDataNasc(dataNasc);

        System.out.println("Digite a data de admissão o vendedor: ");
        do{
            System.out.print("Dia: ");
            dia = input.nextInt();
        }while(!Data.validarDia(dia));

        do{
            System.out.print("Mês: ");
            mes = input.nextInt();
        }while(!Data.validarMes(mes));

        do{
            System.out.print("Ano: ");
            ano = input.nextInt();
        }while(!Data.validarAno(ano));

        Data dataAdmissao = new Data(dia, mes, ano);
        novoVendedor.setDataAdmissao(dataAdmissao);

        System.out.print("Digite o salário do vendedor:\nR$");
        novoVendedor.setSalario(input.nextFloat());

        System.out.print("Digite o tempo de experiência restante:");
        novoVendedor.setTempoRestante(input.nextFloat());

        System.out.print("Digite o login do gerente responsável: ");
        input.nextLine();
		String login_adm = input.nextLine();
		Gerente pesquisa = Sistema.getMapGerentes().get(login_adm);
        if(pesquisa != null){
            novoVendedor.setGerente(pesquisa);
        }
        else{
            System.out.print("Digite um login válido!");
        }

        listaVendedores.add(novoVendedor);

        System.out.println("Crie um login e senha para o vendedor:");
        input.nextLine();
        System.out.print("Login: ");
        String login = input.nextLine();
        do{
            System.out.print("Senha: ");
            senha = input.nextLine();
            System.out.print("Confirme sua senha: ");
            confirSenha = input.nextLine();
            if(!senha.equals(confirSenha))
                System.out.println("As senhas digitadas não são iguais! Tente novamente");
        }while(!senha.equals(confirSenha));
        novoVendedor.setLogin(login);
        novoVendedor.setSenha(senha);

        escreverVendedoresNoArquivo();
    }

    public void escreverVendedoresNoArquivo(){
        try{            
            
            FileWriter escritor = new FileWriter(arqVendedor, true);
            for(int i = 0; i < listaVendedores.size(); i++){
                escritor.write(listaVendedores.get(i).getNome() + "\n");
                escritor.write(listaVendedores.get(i).getRG() + "\n");
                escritor.write(listaVendedores.get(i).getDataNasc() + "\n");
                escritor.write(listaVendedores.get(i).getDataAdmissao() + "\n");
                escritor.write(listaVendedores.get(i).getSalario() + "\n");
                escritor.write(listaVendedores.get(i).getTempoRestante() + "\n");
                escritor.write(listaVendedores.get(i).getGerente().getNome() + "\n");
                escritor.write("\n");
            }                    
            escritor.close();                        
        }
        catch(IOException e)
        {
            System.out.println("Erro" + e);
        }
    }

    public void listarVendedores(){
        for(int i = 0; i < listaVendedores.size(); i++){
            System.out.println("Nome: " + listaVendedores.get(i).getNome());
            System.out.println("RG: " + listaVendedores.get(i).getRG());
            System.out.println("Data de Nascimento: " + listaVendedores.get(i).getDataNasc());
            System.out.println("Data de Admissão: " + listaVendedores.get(i).getDataAdmissao());
            System.out.println("Salário: " + listaVendedores.get(i).getSalario());
            System.out.println("Tempo de Experiência Restante: " + listaVendedores.get(i).getTempoRestante() + "h");
            System.out.println("Gerente Responsável: " + listaVendedores.get(i).getGerente().getNome());
        }
    }

    public void alterarVendedor(){
        int op;
        int dia, mes, ano;
        Data novaData;
        String senha,confirSenha;
        listarVendedores();
        System.out.println("Qual vendedor deseja alterar?");
        vendedor = (input.nextInt() - 1);
        if (listaMotocicletas.size() == 0) 
            System.out.println("\nNão há motocicletas cadastradas.");
        else{
            do{
                System.out.println("\nQual dado deseja alterar?");
                System.out.println("1 - Alterar Nome");
                System.out.println("2 - Alterar RG");
                System.out.println("3 - Alterar Data de Nascimento");
                System.out.println("4 - Alterar Data de Admissão");
                System.out.println("5 - Alterar Salário");
                System.out.println("6 - Alterar Tempo restante de experiência");
                System.out.println("7 - Alterar Gerente Responsável");
                System.out.println("8 - Alterar login");
                System.out.println("9 - Alterar senha");
                System.out.println("10 - Sair");
                System.out.println("\nDigite a opção desejada: ");
                op = input.nextInt();
                input.nextLine();
                
                switch(op){
                    case 1:
                        System.out.print("\nDigite o novo nome: ");
                        listaVendedores.get(vendedor).setNome(input.nextLine());  
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 2:
                        System.out.print("\nDigite o novo RG: ");
                        listaVendedores.get(vendedor).setRG(input.nextLong());  
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 3:
                        System.out.println("\nDigite a nova data de nascimento: ");
                        do{
                            System.out.print("Dia: ");
                            dia = input.nextInt();
                        }while(!Data.validarDia(dia));

                        do{
                            System.out.print("Mês: ");
                            mes = input.nextInt();
                        }while(!Data.validarMes(mes));

                        do{
                            System.out.print("Ano: ");
                            ano = input.nextInt();
                        }while(!Data.validarAno(ano));
                        novaData = new Data(dia, mes, ano);
                        listaVendedores.get(vendedor).setDataNasc(novaData);
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 4:
                        System.out.println("\nDigite a nova data de admissão: ");
                        do{
                            System.out.print("Dia: ");
                            dia = input.nextInt();
                        }while(!Data.validarDia(dia));

                        do{
                            System.out.print("Mês: ");
                            mes = input.nextInt();
                        }while(!Data.validarMes(mes));

                        do{
                            System.out.print("Ano: ");
                            ano = input.nextInt();
                        }while(!Data.validarAno(ano));
                        novaData = new Data(dia, mes, ano);
                        listaVendedores.get(vendedor).setDataAdmissao(novaData);
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 5:
                        System.out.print("\nDigite o novo Salário: R$ ");
                        listaVendedores.get(vendedor).setSalario(input.nextLong());  
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 6:
                        System.out.print("\nDigite o novo tempo restante: ");
                        listaVendedores.get(vendedor).setSalario(input.nextInt());  
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 7:
                        System.out.print("\nDigite o login do novo gerente responsável: ");
                        input.nextLine();
                        String login_adm = input.nextLine();
                        Gerente pesquisa = Sistema.getMapGerentes().get(login_adm);
                        if(pesquisa != null){
                            listaVendedores.get(vendedor).setGerente(pesquisa);
                            System.out.println("\n\n==> Dados atualizados com sucesso!");
                        }
                        else{
                            System.out.print("Digite um login válido!");
                        }
                    break;
                    case 8:
                        System.out.print("\nDigite o novo login: ");
                        listaVendedores.get(vendedor).setLogin(input.nextLine());  
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 9:
                        do{
                            System.out.print("Digite a nova senha: ");
                            senha = input.nextLine();
                            System.out.print("Confirme a senha: ");
                            confirSenha = input.nextLine();
                            if(!senha.equals(confirSenha))
                                System.out.println("As senhas digitadas não são iguais! Tente novamente");
                        }while(!senha.equals(confirSenha));
                        listaVendedores.get(vendedor).setSenha(senha);
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    default:
                        System.out.println("Digite uma opção válida!");
                    break;

                }
            }while(op != 10);
    }
    arqVendedor.delete();
    escreverVendedoresNoArquivo();
    }

    public void removerVendedor(){
        listarVendedores();
        System.out.println("Qual vendedor deseja excluir?");
        vendedor = (input.nextInt() - 1);		
		input.nextLine();		

		if (listaVendedores.size() == 0) {
			System.out.println("\nNão há vendedores cadastrados.");            
		}
        else{
            listaVendedores.remove(vendedor);
		    System.out.println("\n\nVendedor excluído com sucesso!");
        }

        arqVendedor.delete();
        escreverVendedoresNoArquivo();

    }

}

    public static Map<String,Funcionario> getMapUsuarios()
    {
        return usuarios;
    }

    public static void usuariosWriteFile()
    {
            try
            {
                File arquivo = new File("registroGerentes");
                FileWriter gWriter = new FileWriter(arquivo,false);
                FileWriter vWriter = new FileWriter(new File("registroVendedores"),false);
                for(Funcionario f : usuarios.values())
                {
                    if(f instanceof Gerente)
                    {
                        Gerente g = (Gerente) f;
                        gWriter.write(g.getRG() + ";" + g.getNome() + ";" + g.getDataNasc().criarData() + ";" + g.getDataAdmissao().criarData() + ";" + g.getSalario() + ";" + g.getAnosExp() + ";" + g.getLogin() + ";" + g.getSenha()+"\n");
                    }
                    else if(f instanceof Vendedor)
                    {
                        Vendedor v = (Vendedor) f;
                        //Pra parte do gerente, ele vai salvar o login do gerente no arquivo.
                        vWriter.write(v.getRG() + ";" + v.getNome() + ";" + v.getDataNasc().criarData() + ";" + v.getDataAdmissao().criarData() + ";" + v.getSalario() + ";" + v.getTempoRestante() + ";" + v.getGerente().getLogin() + ";" + v.getLogin() + ";" + v.getSenha()+"\n");
                    }
                }
                gWriter.close();
                vWriter.close();
            }
            catch(IOException e)
            {
                System.out.println("Erro: " + e);
            }
    }
    
    public static void loadFiles()
    {
        //Fazer os negocio de ler arquivo e botar tudo nas Coleções aqui

        //Ler gerentes
        try
        {
            FileReader arquivo = new FileReader("registroGerentes");
            BufferedReader reader = new BufferedReader(arquivo);
            while(reader.ready())
            {
                String dados[] = reader.readLine().split(";");
                String DMA[] = dados[2].split("/");
                Data dataNasc = new Data(Integer.parseInt(DMA[0]),Integer.parseInt(DMA[1]),Integer.parseInt(DMA[2]));
                String DMA2[] = dados[3].split("/");
                Data dataAdmissao = new Data(Integer.parseInt(DMA2[0]),Integer.parseInt(DMA2[1]),Integer.parseInt(DMA2[2]));
                long RG = Long.parseLong(dados[0]);
                float salario = Float.parseFloat(dados[4]);
                int anosExp = Integer.parseInt(dados[5]);
                Gerente gerente = new Gerente(RG,dados[1],dataNasc,dataAdmissao,salario,anosExp,dados[6],dados[7]);
                usuarios.put(gerente.getLogin(),gerente);
            }
            reader.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro: " + e);
        }

        //Ler vendedores
        try
        {
            FileReader arquivo = new FileReader("registroVendedores");
            BufferedReader reader = new BufferedReader(arquivo);
            while(reader.ready())
            {
                String dados[] = reader.readLine().split(";");

                String DMA[] = dados[2].split("/");
                Data dataNasc = new Data(Integer.parseInt(DMA[0]),Integer.parseInt(DMA[1]),Integer.parseInt(DMA[2]));
                String DMA2[] = dados[3].split("/");
                Data dataAdmissao = new Data(Integer.parseInt(DMA2[0]),Integer.parseInt(DMA2[1]),Integer.parseInt(DMA2[2]));
                long RG = Long.parseLong(dados[0]);
                float salario = Float.parseFloat(dados[4]);
                float TempoRestante = Float.parseFloat(dados[5]);
                Gerente gResponsavel = (Gerente) usuarios.get(dados[6]);
                Vendedor vendedor = new Vendedor(RG,dados[1],dataNasc,dataAdmissao,salario,TempoRestante,gResponsavel,dados[7],dados[8]);
                usuarios.put(vendedor.getLogin(),vendedor);
            }
            reader.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro: " + e);
        }
        
        
        //Ler carros
        try {

            FileReader arquivo = new FileReader("registroCarros");
            BufferedReader reader = new BufferedReader(arquivo);
            while(reader.ready())
            {
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
                Carro carro = new Carro(numChassi, marca, modelo, ano, kilometragem, tipoCombustivel, peso, status, potencia, numCilindros, numeroOcupantes, tipo, dimensoes);
                carros.add(carro);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    
        //Ler motos
        try {
            FileReader arquivo = new FileReader("registroMotocicletas");
            BufferedReader reader = new BufferedReader(arquivo);
            while(reader.ready())
            {
                String dados[] = reader.readLine().split(";");
                int cilindradas = Integer.parseInt(dados[0]);
                String tipo = dados[1];
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
        }
        catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    
    }   
    /*
    escritor.write(motocicletas.get(i).getCilindradas() + ";");
    escritor.write(motocicletas.get(i).getTipo() + ";");
     */
    

    

}