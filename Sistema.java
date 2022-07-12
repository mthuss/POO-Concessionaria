import java.util.Scanner;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Sistema {

	public static Map<String,Gerente> gerentes = new HashMap<>();  //Idealmente, mover isso para o Sistema.java. 
    public static ArrayList <Carro> carros = new ArrayList<>();
    public static ArrayList<Motocicleta> listaMotocicletas = new ArrayList<>();        
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public static void menuVendedor()
    {
        System.out.println("Menu Vendedor: ");
    }    

    //------------------------------------------
    //Funções do Menu ADM

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

            System.out.print("Potência em cavalos: "); //int
            int auxPotencia = scan.nextInt();

            System.out.print("Número de cilindros: "); //int
            int auxCilindros = scan.nextInt();

            System.out.print("Numero de assentos: "); //int
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

    //
    public static void mostraArrayCarros()  {
        int i=1;

        for (Carro car : carros)    {
            System.out.printf("Carro %d:\n", i);
            System.out.println(car.getNumChassi() + "\n" + car.getMarca() + "\n" + car.getModelo() + "\n" + car.getAno() +
                "\n" + car.getKilometragem() + "\n" + car.getTipoCombustivel() + "\n" + car.getPeso() + "\n" + car.getStatus() + 
                "\n" + car.getPotencia() + "\n" + car.getNumCilindros() + "\n" + car.getNumeroOcupantes() + "\n" + car.getTipo() +
                "\n" + car.getAltura() + "x" + car.getLargura() + "x" + car.getComprimento() + "\n");
        i++;
        System.out.printf("\n");
        }
    }


    //------------------------------------------
    public static void alterarCarro()   {
    mostraArrayCarros();
    Scanner sc = new Scanner(System.in);
    int indice=0;

    do  {
        System.out.print("Digite o indice do carro que deseja alterar: ");
        indice = sc.nextInt();
        
    } while (indice < 1 || indice > carros.size()+1);
    sc.nextLine();
    indice--; //adaptando ao valor que condiz com o visto no println

    //depois termino o resto vo te ensaio agora


    }

    //------------------------------------------
    //Menu ADM    
    public static void menuADM() //Lembrar da senha: Gerente123
    {
        Scanner sc = new Scanner(System.in);
        int op_adm;


        do  {
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

            System.out.println("13 - Testar meu arquivo 👍");

            System.out.println("\n0 - Sair");

            System.out.print("\nComando: ");
            op_adm = sc.nextInt();
            sc.nextLine();

            switch(op_adm)  {
                case 1: 
                    cadastrarCliente();
                break;
                case 2: 
                    
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
                    
                break;
                
                case 7:
                    alterarCarro(); 
                break;
                case 8: 
                    alterarMotocicletas();
                break;
                case 9:
                    removerCliente();
                break;
                case 10:
                break;
                case 11:
                break;
                case 12:
                    removerMotocicleta();
                break;
                case 13:
                    try {
                        FileReader arq = new FileReader("registroCarros"); //Ler o txt dos carros
                        BufferedReader lerArq = new BufferedReader(arq);
                        String line;

                        while(lerArq.ready())   {
                            line = lerArq.readLine();
                            System.out.println(line);
                        }

                        arq.close();
                    }
                    catch (IOException e)   {
                        System.out.println("erro: " + e);
                    }
                    break;

                default: break;
            }


        } while (op_adm != 0);
    
    //sc.close();
    }

    public static void addGerente(Gerente novoGerente)
    {
		gerentes.put(novoGerente.getLogin(),novoGerente);
    }
    public static Map<String,Gerente> getMapGerentes()
    {
        return gerentes;
    }
    public static void gerentesWriteFile()
    {
        {
            try
            {
                File arquivo = new File("registroGerentes");
                FileWriter writer = new FileWriter(arquivo,false);
                for(Gerente g : gerentes.values())
                {
                    writer.write(g.getRG() + ";" + g.getNome() + ";" + g.getDataNasc().criarData() + ";" + g.getDataAdmissao().criarData() + ";" + g.getSalario() + ";" + g.getAnosExp() + ";" + g.getLogin() + ";" + g.getSenha()+"\n");
                }
                writer.close();
            }
            catch(IOException e)
            {
                System.out.println("Erro: " + e);
            }
        }
    }

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
                gerentes.put(gerente.getLogin(),gerente);
            }
            reader.close();
        }
        catch(IOException e)
        {
            System.out.println("Erro: " + e);
        }

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
    }
	 // MOTO
    
    public static void cadastrarMotocicletas(){
        Scanner input = new Scanner(System.in);
        int ano;
        Motocicleta novaMotocicleta = new Motocicleta();
        
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

        listaMotocicletas.add(novaMotocicleta);
        escreverMotosNoArquivo();  
    }

    public static void escreverMotosNoArquivo(){
        try{            
            //Parte de arquivos 
            String arquivoMotocicletas = "motocicletas.txt";
            File arq = new File(arquivoMotocicletas);
            FileWriter escritor = new FileWriter(arq, false);
            //lembrar que a escrita do arquivo prossegue do ponto que parou
            for(int i = 0; i < listaMotocicletas.size(); i++){
                escritor.write(listaMotocicletas.get(i).getCilindradas() + "\n");
                escritor.write(listaMotocicletas.get(i).getTipo() + "\n");
                escritor.write(listaMotocicletas.get(i).getNumChassi() + "\n");
                escritor.write(listaMotocicletas.get(i).getMarca() + "\n");
                escritor.write(listaMotocicletas.get(i).getModelo() + "\n");
                escritor.write(listaMotocicletas.get(i).getAno() + "\n");
                escritor.write(listaMotocicletas.get(i).getKilometragem() + "\n");
                escritor.write(listaMotocicletas.get(i).getTipoCombustivel() + "\n");
                escritor.write(listaMotocicletas.get(i).getPeso() + "\n");
                escritor.write(listaMotocicletas.get(i).getStatus() + "\n");
                escritor.write("\n");
            }                    
            escritor.close();                        
        }
        catch(IOException e)
        {
            System.out.println("Erro" + e);
        }
    }


    public static void visualizarMotocicletas(){
        for(int i = 0; i < listaMotocicletas.size(); i++){
            System.out.printf("\nMotocicleta %d\n", i+1);
            System.out.println("Cilidradas: " + listaMotocicletas.get(i).getCilindradas());
            System.out.println("Tipo: " + listaMotocicletas.get(i).getTipo());
            System.out.println("Número do chassi: " + listaMotocicletas.get(i).getNumChassi());
            System.out.println("Marca: " + listaMotocicletas.get(i).getMarca());
            System.out.println("Modelo: " + listaMotocicletas.get(i).getModelo());
            System.out.println("Ano: " + listaMotocicletas.get(i).getAno());
            System.out.println("Kilometragem: " + listaMotocicletas.get(i).getKilometragem());
            System.out.println("Tipo de Combustível: " + listaMotocicletas.get(i).getTipoCombustivel());
            System.out.println("Peso: " + listaMotocicletas.get(i).getPeso());
            System.out.println("Status: " + listaMotocicletas.get(i).getStatus());
        }
    }
    
    public static void alterarMotocicletas(){                
        int opMenu;
        int ano;
        Scanner input = new Scanner(System.in);
        visualizarMotocicletas();
        System.out.println("Qual motocicleta deseja alterar?");
        int moto = (input.nextInt() - 1);
        
        if (listaMotocicletas.size() == 0) 
            System.out.println("\nNão há motocicletas cadastradas.");
        else{
            do {                                     
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
                System.out.println("11 - Sair");
                System.out.println("\nDigite a opção desejada: ");
                opMenu = input.nextInt();
                input.nextLine();
    
                switch (opMenu) {
                    case 1:
                        System.out.print("\nDigite as novas cilindradas: ");
                        listaMotocicletas.get(moto).setCilindradas(input.nextInt());  
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
                                listaMotocicletas.get(moto).setTipo("Trail");
                            break;       
                            case 2:
                                listaMotocicletas.get(moto).setTipo("Street");
                            break;
                            case 3:
                                listaMotocicletas.get(moto).setTipo("Esportiva");
                            break;
                            case 4:
                                listaMotocicletas.get(moto).setTipo("Custom");
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
                        listaMotocicletas.get(moto).setNumChassi(input.nextLong());    
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 4:
                        System.out.print("\nDigite a nova marca: ");
                        listaMotocicletas.get(moto).setMarca(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 5:
                        System.out.print("\nDigite o novo modelo: ");
                        listaMotocicletas.get(moto).setModelo(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 6:
                        do {
                            System.out.print("\nDigite o novo ano: ");
                            ano = input.nextInt();
                            input.nextLine();
                        } while(!Data.validarAno(ano));                    
                        listaMotocicletas.get(moto).setAno(input.nextInt());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 7:
                        System.out.print("\nDigite a nova kilometragem: ");
                        listaMotocicletas.get(moto).setKilometragem(input.nextFloat());   
                        input.nextLine();   
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 8:
                        System.out.print("\nDigite o novo tipo de combustível: ");
                        listaMotocicletas.get(moto).setTipoCombustivel(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 9:
                        System.out.print("\nDigite o novo peso: ");
                        listaMotocicletas.get(moto).setPeso(input.nextFloat()); 
                        input.nextLine();     
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 10:
                        System.out.print("\nDigite o novo status: ");                        
                        listaMotocicletas.get(moto).setStatus(input.nextBoolean());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 11:
                    break;
                    default:
                        System.out.println("\nDigite uma opção válida!\n");
                    break;
                }
            } while(opMenu != 11);
        }
        
    
        escreverMotosNoArquivo();
       
        //leitura do arquivo
        /* 
        try{
            FileReader arq_leitor = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(arq_leitor);
            //sobrescrever uma linha do arquivo
            
            while(leitor.ready()){
                System.out.println(leitor.readLine());
            }
            leitor.close();
        }
        catch(IOException e){
            System.out.println("Erro" + e);
        }
        */    
    }   

    public static void removerMotocicleta(){
        visualizarMotocicletas();
        Scanner input = new Scanner(System.in);
        int moto = (input.nextInt() - 1);
        System.out.println("Qual motocicleta deseja remover?");
        moto = (input.nextInt() - 1);		
		input.nextLine();		

		if (listaMotocicletas.size() == 0) {
			System.out.println("\nNão há motocicletas cadastradas.");            
		}
        else{
            listaMotocicletas.remove(moto);
		    System.out.println("\n\nMotocicleta removida com sucesso!");
        }

        escreverMotosNoArquivo();

    }

    //CLIENTE
    //Parte de arquivos 
    String arquivoClientes = "clientes.txt";
    File arq = new File(arquivoClientes);
    //METODOS DA CLASSE
    // CLIENTE
    public static void cadastrarCliente(){
        Scanner input = new Scanner(System.in);
        int dia, mes, ano;     
        Data novaData = new Data(); 
        Cliente novoCliente = new Cliente();
        
        System.out.println("Digite o CPF: ");
        novoCliente.setCPF(input.nextInt());
        input.nextLine();

        System.out.println("Digite o nome: ");
        novoCliente.setNome(input.nextLine());
        input.nextLine();

        System.out.println("Digite a data de nascimento: ");
        do{
            System.out.print("Dia: ");
            dia = input.nextInt();
            input.nextLine();
        } while(Data.validarDia(dia));
          
        novaData.setDia(dia);
      
        do {
            System.out.print("Mês: ");
            mes = input.nextInt();
            input.nextLine();
        }while(Data.validarMes(mes));
          
        novaData.setMes(mes);
          
        do {
            System.out.print("Ano: ");
            ano = input.nextInt();
            input.nextLine();
        } while(Data.validarAno(ano));
          
        novaData.setAno(ano);
        novoCliente.setDataNasc(novaData);
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

    }
                

    public static void escreverClientesNoArquivo(){
        String arquivoClientes = "clientes.txt";
        File arq = new File(arquivoClientes);      
        try {            
            FileWriter escritor = new FileWriter(arq, false);
            for(Cliente cli: listaClientes)
            escritor.write(cli.getCPF() + ";" + cli.getNome() + ";" + cli.getDataNasc() + ";" + cli.getRua() +
                ";" + cli.getNumeroCasa() + ";" + cli.getBairro() + ";" + cli.getCidade() + ";" + cli.getRenda() + 
                ";" + cli.getDependentes() + ";" + "\n");

           escritor.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
        
    }


    public static void visualizarCliente(){
        int i=1;

        for (Cliente cli : listaClientes)    {
            System.out.printf("Cliente %d:\n", i);
            System.out.println(cli.getCPF() + ";" + cli.getNome() + ";" + cli.getDataNasc() + ";" + cli.getRua() +
            ";" + cli.getNumeroCasa() + ";" + cli.getBairro() + ";" + cli.getCidade() + ";" + cli.getRenda() + 
            ";" + cli.getDependentes() + ";" + "\n");
        i++;
        System.out.printf("\n");
        }
    }

    public static void alterarCliente(){                
        Scanner input = new Scanner(System.in);
        int opMenu;
        int dia, mes, ano;
        Data novaData = new Data();
        visualizarCliente();
        System.out.println("Qual cliente deseja alterar?");
        int cliente = (input.nextInt() - 1);
        
        if (listaClientes.size() == 0) 
            System.out.println("\nNão há clientes cadastrados.");
        else{
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
                        listaClientes.get(cliente).setCPF(input.nextInt());  
                        input.nextLine();  
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 2:                
                        System.out.print("\nDigite o novo nome: ");                                                
                        listaClientes.get(cliente).setNome(input.nextLine());               
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 3:
                        System.out.print("\nDigite a nova data de nascimento: ");
                        do{
                            System.out.print("Dia: ");
                            dia = input.nextInt();
                            input.nextLine();
                        } while(Data.validarDia(dia));
                          
                        novaData.setDia(dia);
                      
                        do {
                            System.out.print("Mês: ");
                            mes = input.nextInt();
                            input.nextLine();
                        }while(Data.validarMes(mes));
                          
                        novaData.setMes(mes);
                          
                        do {
                            System.out.print("Ano: ");
                            ano = input.nextInt();
                            input.nextLine();
                        } while(Data.validarAno(ano));
                          
                        novaData.setAno(ano);
                        listaClientes.get(cliente).setDataNasc(novaData);
                        input.nextLine();                         
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 4:
                        System.out.print("\nDigite a nova rua: ");
                        listaClientes.get(cliente).setRua(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 5:
                        System.out.print("\nDigite o novo número da casa: ");
                        listaClientes.get(cliente).setNumeroCasa(input.nextInt());
                        input.nextLine();    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 6:
                        System.out.print("\nDigite o novo bairro: ");
                        listaClientes.get(cliente).setBairro(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 7:
                        System.out.print("\nDigite a nova cidade: ");
                        listaClientes.get(cliente).setCidade(input.nextLine());    
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 8:
                        System.out.print("\nDigite a nova renda: ");
                        listaClientes.get(cliente).setRenda(input.nextFloat());    
                        input.nextLine();
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;
                    case 9:
                        System.out.print("\nDigite o novo número de dependentes: ");
                        listaClientes.get(cliente).setDependentes(input.nextInt()); 
                        input.nextLine();     
                        System.out.println("\n\n==> Dados atualizados com sucesso!");
                    break;                
                    case 10:
                    break;
                    default:
                        System.out.println("\nDigite uma opção válida!\n");
                    break;
                }
            } while(opMenu != 10);
        }
            
        escreverClientesNoArquivo();
       

    }   

    public static void removerCliente(){
        Scanner input = new Scanner(System.in);
        visualizarCliente();
        System.out.println("Qual cliente deseja remover?");
        int cliente = (input.nextInt() - 1);		
		input.nextLine();		

		if (listaClientes.size() == 0) {
			System.out.println("\nNão há clientes cadastradas.");            
		}
        else{
            listaClientes.remove(cliente);
		    System.out.println("\n\nCliente removido com sucesso!");
        }

        escreverClientesNoArquivo();

    }
}
    
   

