import java.util.Scanner;
import java.io.*;

public class Sistema {
    public static void menuUsuario()
    {
        System.out.println("Menu Usuario: ");
    }    

    //------------------------------------------
    //Funções do Menu ADM

    static void cadastrarCarro()   {    //Falta eu passar os valores to cansado
        try {
            File arq = new File("registroCarros.txt");
            FileWriter escritor = new FileWriter(arq, false); //False pra não sobrescrever
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite os dados referentes ao carro:");
            System.out.print("Numero do chassi: ");

            System.out.print("Marca: ");

            System.out.print("Modelo: ");

            System.out.print("Ano de fabricação: ");

            System.out.print("Kilometragem: ");

            System.out.print("Tipo de combustivel: ");

            System.out.print("Peso em kilogramas: ");

            //esse seria o status mas será falso por padrão

            System.out.print("Potência em cavalos: "); //em cavalos?

            System.out.print("Número de cilindros: ");

            System.out.print("Numero de assentos: ");

            int auxTipo; //para o tipo de carro
            do {
                System.out.println("1-utilitário\n2-pickup\n3-sedan\n4-hatch\n5-esportivo");
                System.out.print("Tipo de carro: ");
                auxTipo = sc.nextInt();

                if (auxTipo < 1 || auxTipo > 5)
                    System.out.println("\tValor invalido");
            } while(auxTipo < 1 || auxTipo > 5);

            System.out.println("Dimensões:");
            System.out.print("Altura: ");

            System.out.print("Largura ");

            System.out.print("Comprimento: ");


            escritor.close();
            sc.close();
        }
        catch(IOException e)  {
            System.out.println("Erro: " + e);
        }
    }


    //------------------------------------------
    //Menu ADM    
    public static void menuADM() //Lembrar da senha: Gerente123
    {
        Scanner sc = new Scanner(System.in);
        int op_adm = 0;


        do  {
            System.out.println("Menu Gerente: ");
            System.out.println("\n\t--Cadastros:--");
            System.out.println("1 - Cadastrar Vendedor");
            System.out.println("2 - Cadastrar Carro");
            System.out.println("3 - Cadastrar Motocicleta");

            System.out.println("\n\t--Alteração:--");
            System.out.println("4 - Alterar dados do Vendedor");
            System.out.println("5 - Alterar dados do Carro");
            System.out.println("6 - Alterar dados do Motocicleta");
        
            System.out.println("\n\t--Exclusão:--");
            System.out.println("7 - Alterar dados do Vendedor");
            System.out.println("8 - Alterar dados do Carro");
            System.out.println("9 - Alterar dados do Motocicleta");

            System.out.println("10 - Testar meu arquivo 👍");

            System.out.println("\n0 - Sair");

            System.out.print("\nComando: ");
            op_adm = sc.nextInt();

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
                        FileReader arq = new FileReader("registroCarros.txt"); //Ler o txt dos carros
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
    
    sc.close();
    }
}
