import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main
{
	public static void main(String args[])
	{
		Map<String,Gerente> gerentes = new HashMap<>();  //Idealmente, mover isso para o Sistema.java. 
														//Aí fazer uma função lá que adiciona um objeto a esse HashMap
													   //e chamar nessa classe com Sistema.adicionarGerente(gerente); ou algo do tipo.
		Scanner sc = new Scanner(System.in);

		int opt;
		String senha = "Gerente123";
		System.out.println("           (                                                          (         ( /(      \n           )\\                  (      (               ) (  (     )    )\\ )      )\\()) (   \n         (((_)  (   (     (   ))\\(  ( )\\  (   (    ( /( )( )\\ ( /(   (()/( (   ((_)\\ ))\\  \n         )\\___  )\\  )\\ )  )\\ /((_)\\ )((_) )\\  )\\ ) )(_)|()((_))(_))   ((_)))\\   _((_)((_) \n        ((/ __|((_)_(_/( ((_|_))((_|(_|_)((_)_(_/(((_)_ ((_|_|(_)_    _| |((_) |_  (_))   \n         | (__/ _ \\ ' \\)) _|/ -_|_-<_-< / _ \\ ' \\)) _` | '_| / _` | / _` / _ \\  / // -_)  \n          \\___\\___/_||_|\\__|\\___/__/__/_\\___/_||_|\\__,_|_| |_\\__,_| \\__,_\\___/ /___\\___|  \n\n                                                 _________\n                                          _.--\"\"'-----,   `\"--.._\n                                       .-''   _/_      ; .'\"----,`-,\n                                     .'      :___:     ; :      ;;`.`.\n                                    .      _.- _.-    .' :      ::  `..\n                                 __;..----------------' :: ___  ::   ;;\n                            .--\"\". '           ___.....`:=(___)-' :--'`.\n                          .'   .'         .--''__       :       ==:    ;\n                      .--/    /        .'.''     ``-,   :         :   '`-.\n                   .\"', :    /       .'-`\\\\       .--.\\ :         :  ,   _\\\n                  ;   ; |   ;       /:'  ;;      /__  \\\\:         :  :  /_\\\\\n                  |\\_/  |   |      / \\__//      /\"--\\\\ \\:         :  : ;|`\\|    \n                  : \"  /\\__/\\____//   \"\"\"      /     \\\\ :         :  : :|'||\n                [\"\"\"\"\"\"\"\"\"--------........._  /      || ;      __.:--' :|//|\n                 \"------....______         ].'|      // |--\"\"\"'__...-'`\\ \\//\n                   `| DGC0C04 |__;_...--'\": :  \\    //  |---\"\"\"      \\__\\_/\n                     \"\"\"\"\"\"\"\"\"'            \\ \\  \\_.//  /\n                       ---'                \\ \\_     _'\n                                             `--`---'  \n");
		System.out.println("BEM VINDO 😈");
		
		do{
			System.out.println("\nSelecione o tipo de usuário: ");
			System.out.println("1- Gerente");
			System.out.println("2- Usuário");
			System.out.println("3- Sair");
			System.out.print("\nSeleção: ");
			opt = sc.nextInt();
			
			switch(opt)
			{
				case 1:
					System.out.println("Digite seu login: ");
					sc.nextLine();
					String login = sc.nextLine();
					Gerente pesquisa = gerentes.get(login);
					if(pesquisa != null)
					{
						String auxSenha;
						System.out.print("Digite a senha: ");
						auxSenha = sc.nextLine();
						if(auxSenha.equals(pesquisa.getSenha()))
							Sistema.menuADM();
						else System.out.println("Senha incorreta!");
					}
					else 
					{
						System.out.println("Login não encontrado!");
						System.out.print("Deseja realizar cadastro? [S/N]: ");
						String sn = sc.nextLine();
						if(sn.equals("S") || sn.equals("s"))
						{
							Gerente novoGerente = new Gerente();
							novoGerente.cadastrar(login);
							gerentes.put(novoGerente.getLogin(),novoGerente);
							if(gerentes.get(novoGerente.getLogin()) != null) //Verifica se o gerente foi adicionado com sucesso
								System.out.println("Cadastrado com sucesso! Tente fazer login novamente");
							else System.out.println("Algo deu errado!!");
						}
					}
					break;
				case 2:
					Sistema.menuUsuario();
					break;
				default: 
					break;
			}
		}while(opt != 3);

//		sc.close();
	}
}