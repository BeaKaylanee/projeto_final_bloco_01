package livro;

import livro.controller.LivroController;
import livro.model.CadastrarLivro;
import livro.model.Livros;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import livro.util.Cores;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		LivroController controller = new LivroController();

		int opcao, estoque, tipoOperacao, livrosEmprestados;
		String titulo, autorLivro, categoriaLivro;

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

				System.out.println("Digite o título:");
				titulo = leia.next();
				System.out.println("Digite o autor:");
				autorLivro = leia.next();
				System.out.println("Informe a categoria/genêro livro: ");
				categoriaLivro = leia.next();
				System.out.println("Informe a quantidade: ");
				estoque = leia.nextInt();
				System.out.println("Informe a quantidade de livros emprestados");
				livrosEmprestados = leia.nextInt();

				do {
					System.out.println("Digite o tipo (1 - Digital, e 2 - Físico) ");
					tipoOperacao = leia.nextInt();
				} while (tipoOperacao < 1 || tipoOperacao > 2);

				Livros novoLivro = new CadastrarLivro(titulo, autorLivro, estoque, categoriaLivro, categoriaLivro, livrosEmprestados);
				controller.cadastrar(novoLivro);

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas os livros cadastrados.");
				controller.listarTodos();
				keyPress();
				break;
			case 3:
				System.out.println("Buscar um livro por título.");
				leia.nextLine();

				System.out.println("Digite o Titulo do Livro: ");
				String livrosLista = leia.nextLine();

				controller.buscarPorTitulo(livrosLista);
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar informações do livro.");
				leia.nextLine(); 

			    System.out.print("Digite o título do livro a ser atualizado: ");
			    titulo = leia.nextLine();

			    Livros livroAtualizar = controller.buscarNaCollection(titulo);

			    if (livroAtualizar != null) {
			        System.out.print("Novo título: ");
			        String novoTitulo = leia.nextLine();

			        System.out.print("Novo autor: ");
			        String novoAutor = leia.nextLine();

			        livroAtualizar.setTitulo(novoTitulo);
			        livroAtualizar.setAutorLivro(novoAutor);

			        System.out.println("Informações atualizadas com sucesso!");
			    } else {
			        System.out.println("Livro não encontrado.");
			    }
				keyPress();
				break;
			case 5:
				System.out.println("Apagar Livros do Sistema.");
				leia.nextLine();
				
				System.out.println("digite o nome do livro: ");
				titulo = leia.nextLine();

				controller.deletar(titulo);
				keyPress();
				break;
			case 6:
				System.out.println("Registrar empréstimos.");
				leia.nextLine();

				System.out.print("Informe o título do livro: ");
				livrosLista = leia.nextLine();

				System.out.print("Informe a quantidade a ser emprestada: ");
				int quantidadeEmprestada = leia.nextInt();

				Livros livroEmprestimo = controller.buscarNaCollection(livrosLista);

				if (livroEmprestimo != null) {
					controller.registrarLivrosEmprestados(livrosLista, quantidadeEmprestada);
				} else {
				    System.out.println("Livro não encontrado.");
				}
				keyPress();
				break;
			case 7:
				System.out.println("Registrar devoluções   : ");
				leia.nextLine();

				System.out.println("informe o Titulo do livro: ");
				titulo = leia.nextLine();

				Livros livro = controller.buscarNaCollection(titulo);

				if (livro != null) {
				    System.out.print("Quantidade a devolver: ");
				    
				    while (!leia.hasNextInt()) {
				        System.out.println("Digite um número válido!");
				        leia.next(); 
				    }

				    int quantidade = leia.nextInt();

				    if (quantidade > 0 && quantidade <= livro.getLivrosEmprestados()) {
				        livro.setEstoque(livro.getEstoque() + quantidade);
				        livro.setLivrosEmprestados(livro.getLivrosEmprestados() - quantidade);
				        System.out.println("Devolução registrada com sucesso.");
				    } else {
				        System.out.println("Quantidade inválida. Verifique os livros emprestados.");
				    }
				} else {
				    System.out.println("Livro não encontrado.");
				}
				keyPress();
				break;
			case 8:
				System.out.println("Transferir livro entre categoria ou seções. ");

				System.out.print("Digite o título do livro: ");
				leia.nextLine();
				String tituloTransferencia = leia.nextLine();

				Livros livroTransferencia = controller.buscarNaCollection(tituloTransferencia);

				if (livroTransferencia != null) {
					System.out.print("Digite a nova categoria: ");
					String novaCategoria = leia.nextLine();
					livroTransferencia.setCategoriaLivro(novaCategoria);
					System.out.println("Categoria atualizada com sucesso!");
				} else {
					System.out.println("Livro não encontrado.");
				}

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
