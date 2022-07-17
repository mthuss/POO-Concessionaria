import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Sistema.loadFiles(); //carrega todos os arquivos

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"           (                                                          (         ( /(      \n           )\\                  (      (               ) (  (     )    )\\ )      )\\()) (   \n         (((_)  (   (     (   ))\\(  ( )\\  (   (    ( /( )( )\\ ( /(   (()/( (   ((_)\\ ))\\  \n         )\\___  )\\  )\\ )  )\\ /((_)\\ )((_) )\\  )\\ ) )(_)|()((_))(_))   ((_)))\\   _((_)((_) \n        ((/ __|((_)_(_/( ((_|_))((_|(_|_)((_)_(_/(((_)_ ((_|_|(_)_    _| |((_) |_  (_))   \n         | (__/ _ \\ ' \\)) _|/ -_|_-<_-< / _ \\ ' \\)) _` | '_| / _` | / _` / _ \\  / // -_)  \n          \\___\\___/_||_|\\__|\\___/__/__/_\\___/_||_|\\__,_|_| |_\\__,_| \\__,_\\___/ /___\\___|  \n\n                                                 _________\n                                          _.--\"\"'-----,   `\"--.._\n                                       .-''   _/_      ; .'\"----,`-,\n                                     .'      :___:     ; :      ;;`.`.\n                                    .      _.- _.-    .' :      ::  `..\n                                 __;..----------------' :: ___  ::   ;;\n                            .--\"\". '           ___.....`:=(___)-' :--'`.\n                          .'   .'         .--''__       :       ==:    ;\n                      .--/    /        .'.''     ``-,   :         :   '`-.\n                   .\"', :    /       .'-`\\\\       .--.\\ :         :  ,   _\\\n                  ;   ; |   ;       /:'  ;;      /__  \\\\:         :  :  /_\\\\\n                  |\\_/  |   |      / \\__//      /\"--\\\\ \\:         :  : ;|`\\|    \n                  : \"  /\\__/\\____//   \"\"\"      /     \\\\ :         :  : :|'||\n                [\"\"\"\"\"\"\"\"\"--------........._  /      || ;      __.:--' :|//|\n                 \"------....______         ].'|      // |--\"\"\"'__...-'`\\ \\//\n                   `| JOSECAR |__;_...--'\": :  \\    //  |---\"\"\"      \\__\\_/\n                     \"\"\"\"\"\"\"\"\"'            \\ \\  \\_.//  /\n                       ---'                \\ \\_     _'\n                                             `--`---'  \n");
		System.out.println("BEM VINDO 😈");

		String login;
		do {
			System.out.println("----Menu Principal----\n\n");
			System.out.println("Digite 0 para sair ou");
			System.out.println("Digite seu login: ");
			login = sc.nextLine();

			if (login.equals("0")) // opção pra sair
				break;

			Funcionario pesquisa = Sistema.getMapUsuarios().get(login);
			if (pesquisa != null) // Se existe usuario com o login especificado
			{
				if (pesquisa instanceof Gerente) { //verifica se é conta de gerente
					Gerente gerente = (Gerente) pesquisa;
					String auxSenha;
					System.out.print("Digite a senha: ");
					auxSenha = sc.nextLine();
					if (auxSenha.equals(gerente.getSenha()))
						Sistema.menuADM(gerente);
					else
						System.out.println("Senha incorreta!");

				} else if (pesquisa instanceof Vendedor) { //verifica se é conta de vendedor
					Vendedor vendedor = (Vendedor) pesquisa;
					String auxSenha;
					System.out.print("Digite a senha: ");
					auxSenha = sc.nextLine();
					if (auxSenha.equals(vendedor.getSenha()))
						Sistema.menuVendedor(vendedor);
					else
						System.out.println("Senha incorreta!");

				} else	//não é suposto entrar aqui
					System.out.println("Temos um problema!!");

			} 
			else { //caso não haja, realiza cadastro
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

					if (selec == 1) { //cadastra gerente
						Gerente novoGerente = new Gerente();
						novoGerente.cadastrar(login); // usa o login previamente digitado e cria uma nova "conta"
						Sistema.addGerente(novoGerente);

						if (Sistema.getMapUsuarios().get(novoGerente.getLogin()) != null) // Verifica se o gerente foi
																							// adicionado com sucesso
							System.out.println("Cadastrado com sucesso! Tente fazer login novamente");
						else
							System.out.println("Algo deu errado!!");

					} else if (selec == 2) { //cadastra o vendedor
						Vendedor novoVendedor = new Vendedor();
						novoVendedor.cadastrar(login);
						Sistema.addVendedor(novoVendedor);
						if(Sistema.getMapUsuarios().get(novoVendedor.getLogin()) != null)
							System.out.println("Cadastrado com sucesso! Tente fazer login novamente");
						else
							System.out.println("Algo deu errado!!");

					}
				}
			}
		} while (!login.equals("0"));

		// Atualiza os arquivos de registro
		Sistema.gerentesWriteFile();
		Sistema.vendedoresWriteFile();
		Sistema.carrosWriteFile();
		Sistema.clientesWriteFile();
		Sistema.motosWriteFile();
		Sistema.vendasWriteFile();

		sc.close();
	}
}
