import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Scanner mainSc = new Scanner(System.in);
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
			opt = mainSc.nextInt();
			
			switch(opt)
			{
				case 1:
				String auxSenha;
				System.out.print("Digite a senha: ");
					mainSc.nextLine();
					auxSenha = mainSc.nextLine();
					if(auxSenha.equals(senha))
						Sistema.menuADM();
					else System.out.println("Senha incorreta!");
					break;
				case 2:
					Sistema.menuUsuario();
					break;
				default: 
					break;
			}
		}while(opt != 3);
		mainSc.close();
	}
}