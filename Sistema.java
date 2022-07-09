import java.util.Scanner;

public class Sistema {
    public static void menuUsuario()
    {
        System.out.println("Menu Usuario: ");
    }    

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

            System.out.println("\n0 - Sair");

            System.out.print("\nComando: ");
            op_adm = sc.nextInt();

            switch(op_adm)  {
                case 1: break;
                case 2: break;
                case 3: break;

                case 4: break;
                case 5: break;
                case 6: break;
                
                case 7: break;
                case 8: break;
                case 9: break;
            
            }


        } while (op_adm != 0);
    
    sc.close();
    }
}
