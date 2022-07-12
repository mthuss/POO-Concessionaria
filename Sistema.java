import java.util.Scanner;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Sistema {

	public static Map<String,Gerente> gerentes = new HashMap<>();  //Idealmente, mover isso para o Sistema.java. 
    public static ArrayList <Carro> carros = new ArrayList<>();

    public static void menuUsuario()
    {
        System.out.println("Menu Usuario: ");
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
/*
            escritor.write(car.getNumChassi() + " " + car.getMarca() + " " + car.getModelo() + " " + car.getAno() +
            " " + car.getKilometragem() + " " + car.getTipoCombustivel() + " " + car.getPeso() + " " + car.getStatus() + 
            " " + car.getPotencia() + " " + car.getNumCilindros() + " " + car.getNumeroOcupantes() + " " + car.getTipo() +
            " " + car.getAltura() + "x" + car.getLargura() + "x" + car.getComprimento() + "\n");
*/
     //       scan.close();
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
            System.out.println("1 - Cadastrar Vendedor");
            System.out.println("2 - Cadastrar Carro");
            System.out.println("3 - Cadastrar Motocicleta");

            System.out.println("\n\t--Alteração:--");
            System.out.println("4 - Alterar dados do Vendedor");
            System.out.println("5 - Alterar dados do Carro");
            System.out.println("6 - Alterar dados do Motocicleta");
        
            System.out.println("\n\t--Exclusão:--");
            System.out.println("7 - Remover dados do Vendedor");
            System.out.println("8 - Remover dados do Carro");
            System.out.println("9 - Remover dados do Motocicleta");

            System.out.println("10 - Testar meu arquivo 👍");

            System.out.println("\n0 - Sair");

            System.out.print("\nComando: ");
            op_adm = sc.nextInt();
            sc.nextLine();

            switch(op_adm)  {
                case 1: break;
                case 2: 
                    cadastrarCarro();
                    break;
                case 3: break;

                case 4: break;
                case 5: break;
                case 6: break;
                
                case 7: break;
                case 8: break;
                case 9: break;
            
                case 10:
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
}
