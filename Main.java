import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Sistema.loadFiles();

		Scanner sc = new Scanner(System.in);

		// int opt;
		// // String senha = "Gerente123";
		System.out.println(
				"           (                                                          (         ( /(      \n           )\\                  (      (               ) (  (     )    )\\ )      )\\()) (   \n         (((_)  (   (     (   ))\\(  ( )\\  (   (    ( /( )( )\\ ( /(   (()/( (   ((_)\\ ))\\  \n         )\\___  )\\  )\\ )  )\\ /((_)\\ )((_) )\\  )\\ ) )(_)|()((_))(_))   ((_)))\\   _((_)((_) \n        ((/ __|((_)_(_/( ((_|_))((_|(_|_)((_)_(_/(((_)_ ((_|_|(_)_    _| |((_) |_  (_))   \n         | (__/ _ \\ ' \\)) _|/ -_|_-<_-< / _ \\ ' \\)) _` | '_| / _` | / _` / _ \\  / // -_)  \n          \\___\\___/_||_|\\__|\\___/__/__/_\\___/_||_|\\__,_|_| |_\\__,_| \\__,_\\___/ /___\\___|  \n\n                                                 _________\n                                          _.--\"\"'-----,   `\"--.._\n                                       .-''   _/_      ; .'\"----,`-,\n                                     .'      :___:     ; :      ;;`.`.\n                                    .      _.- _.-    .' :      ::  `..\n                                 __;..----------------' :: ___  ::   ;;\n                            .--\"\". '           ___.....`:=(___)-' :--'`.\n                          .'   .'         .--''__       :       ==:    ;\n                      .--/    /        .'.''     ``-,   :         :   '`-.\n                   .\"', :    /       .'-`\\\\       .--.\\ :         :  ,   _\\\n                  ;   ; |   ;       /:'  ;;      /__  \\\\:         :  :  /_\\\\\n                  |\\_/  |   |      / \\__//      /\"--\\\\ \\:         :  : ;|`\\|    \n                  : \"  /\\__/\\____//   \"\"\"      /     \\\\ :         :  : :|'||\n                [\"\"\"\"\"\"\"\"\"--------........._  /      || ;      __.:--' :|//|\n                 \"------....______         ].'|      // |--\"\"\"'__...-'`\\ \\//\n                   `| DGC0C04 |__;_...--'\": :  \\    //  |---\"\"\"      \\__\\_/\n                     \"\"\"\"\"\"\"\"\"'            \\ \\  \\_.//  /\n                       ---'                \\ \\_     _'\n                                             `--`---'  \n");
		System.out.println("BEM VINDO 😈");
		//
		// do{
		// System.out.println("\nSelecione o tipo de usuário: ");
		// System.out.println("1- Gerente");
		// System.out.println("2- Usuário");
		// System.out.println("3- Sair");
		// System.out.print("\nSeleção: ");
		// opt = sc.nextInt();
		//
		// switch(opt)
		// {
		// case 1:
		String login;
		do {
			System.out.println("----Menu Principal----\n\n");
			System.out.println("Digite 0 para sair ou");
			System.out.println("Digite seu login: ");
			// sc.nextLine();
			login = sc.nextLine();

			if (login.equals("0")) // opção pra sair
				break;

			Funcionario pesquisa = Sistema.getMapUsuarios().get(login);
			if (pesquisa != null) // Se existe usuario com o login especificado
			{
				if (pesquisa instanceof Gerente) {
					Gerente gerente = (Gerente) pesquisa;
					String auxSenha;
					System.out.print("Digite a senha: ");
					auxSenha = sc.nextLine();
					if (auxSenha.equals(gerente.getSenha()))
						Sistema.menuADM(gerente);
					else
						System.out.println("Senha incorreta!");
				} else if (pesquisa instanceof Vendedor) {
					Vendedor vendedor = (Vendedor) pesquisa;
					String auxSenha;
					System.out.print("Digite a senha: ");
					auxSenha = sc.nextLine();
					if (auxSenha.equals(vendedor.getSenha()))
						Sistema.menuVendedor(vendedor);
					else
						System.out.println("Senha incorreta!");
				} else
					System.out.println("Temos um problema!!");
			} else {
				System.out.println("Login não encontrado!");
				System.out.print("Deseja realizar cadastro? [S/N]: ");
				String sn = sc.nextLine();
				if (sn.equals("S") || sn.equals("s")) {
					int selec;
					do {
						System.out.println("Deseja cadastrar um gerente ou um vendedor?");
						System.out.print("1 - Gerente\n2 - Vendedor\n\nSeleção: ");
						selec = sc.nextInt();
						if (selec != 1 && selec != 2)
							System.out.println("Opção inválida!");
					} while (selec != 0 && selec != 1 && selec != 2);
					sc.nextLine();

					if (selec == 1) {
						Gerente novoGerente = new Gerente();
						novoGerente.cadastrar(login); // usa o login previamente digitado e cria uma nova "conta"
						// System.out.println(novoGerente.getDataAdmissao().criarData());
						Sistema.addGerente(novoGerente);
						// Sistema.gerentesWriteFile(); //atualiza o arquivo de gerentes
						if (Sistema.getMapUsuarios().get(novoGerente.getLogin()) != null) // Verifica se o gerente foi
																							// adicionado com sucesso
							System.out.println("Cadastrado com sucesso! Tente fazer login novamente");
						else
							System.out.println("Algo deu errado!!");
					} else if (selec == 2) {
						Vendedor novoVendedor = new Vendedor();
						novoVendedor.cadastrar(login);
						Sistema.addVendedor(novoVendedor);
						// Fazer processo similar mas pra classe de vendedor

					}
				}
			}
		} while (!login.equals("0"));
		// break;
		// case 2:
		// Sistema.menuVendedor();
		// break;
		// default:
		// break;
		// }
		// }while(opt != 3);

		// sc.close();

		// Atualiza os arquivos de registro
		Sistema.usuariosWriteFile();
		Sistema.carrosWriteFile();
		// Sistema.motosWriteFile();

	}
}
