package livro;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import livro.util.Cores;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void  main(String[] args) {

		int opcao;

		while (true) {
			System.out.println("_____________________________________________________________");
			System.out.println("                                                             ");
			System.out.println("                  BIBLIOTECA 123                  		     ");
			System.out.println("                                                     		 ");
			System.out.println("_____________________________________________________________");
			System.out.println("                                                     		 ");
			System.out.println("            1 - Criar um catálogo de livros.        		 ");
			System.out.println("            2 - Listar todas os livros cadastrados   		 ");
			System.out.println("            3 - Buscar um livro por código ou título.	   	 ");
			System.out.println("            4 - Atualizar informações do livro       		 ");
			System.out.println("            5 - Apagar Livros do Sistema                     ");
			System.out.println("            6 - Registrar empréstimos                        ");
			System.out.println("            7 - Registrar devoluções                         ");
			System.out.println("            8 -  Transferir livro entre categoria ou seções. ");
			System.out.println("            9 - Sair.                                        ");
			System.out.println("                                                   		     ");
			System.out.println("_____________________________________________________________");
			System.out.println("Entre com a opção desejada:                          ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;

			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nObrigado pela sua preferÊncia!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar um catálogo de livros. ");
				
				keyPress();
				break;
			case 2:
				System.out.println("Listar todas os livros cadastrados.");
				
				keyPress();
				break;
			case 3:
				System.out.println("Buscar um livro por código ou título.");
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar informações do livro.");
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar Livros do Sistema.");
				
				keyPress();
				break;
			case 6:
				System.out.println("Registrar empréstimos.");
				
				keyPress();
				break;
			case 7:
				System.out.println("Digite seu nome: ");
				
				keyPress();
				break;
			case 8:
				System.out.println("Transferir livro entre categoria ou seções. ");
				
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}

		}
	}

	public static void keyPress() {

		try {

			System.out.println("\\nPressione Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
