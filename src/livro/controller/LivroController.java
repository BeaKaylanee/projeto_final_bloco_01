package livro.controller;

import java.util.ArrayList;
import livro.model.Livros;
import livro.repository.LivroRepository;

public class LivroController implements LivroRepository {

	private ArrayList<Livros> listaLivros = new ArrayList<Livros>();

	@Override
	public void cadastrar(Livros Novolivro) {
		listaLivros.add(Novolivro);
		System.out.println("]\nO livro: " + Novolivro.getTitulo() + " foi adicionado com sucesso!");

	}

	@Override
	public void listarTodos() {
		for (var livro : listaLivros) {
			livro.visualizar();
			;
		}

	}

	@Override
	public void buscarPorTitulo(String titulo) {
		var livro = buscarNaCollection(titulo);

		if (livro != null) {
			livro.visualizar();
		} else
			System.out.println("\nO livro com título '" + titulo + "' não foi encontrado!");

	}

	@Override
	public void atualizar(String tituloAntigo, Livros livroAtualizado) {
		var livro = buscarNaCollection(tituloAntigo);

		if (livro != null) {
			livro.setTitulo(livroAtualizado.getTitulo());
			livro.setAutorLivro(livroAtualizado.getAutorLivro());
			livro.setEstoque(livroAtualizado.getEstoque());
			livro.setCategoriaLivro(livroAtualizado.getCategoriaLivro());
			livro.setNomeCliente(livroAtualizado.getNomeCliente());
			livro.setTipo(livroAtualizado.getTipo());

			System.out.println("\nO livro foi atualizado com sucesso!");
		} else {
			System.out.println("\nO livro com título '" + tituloAntigo + "' não foi encontrado!");
		}

	}

	@Override
	public void registrarLivrosEmprestados(String livros, int quantidade) {
		Livros livro = buscarNaCollection(livros);

		if (livro != null) {

			if (quantidade > 0 && quantidade <= livro.getEstoque()) {
				livro.setEstoque(livro.getEstoque() - quantidade);
				livro.setLivrosEmprestados(livro.getLivrosEmprestados() + quantidade);
				System.out.println("Empréstimo registrado com sucesso!");
			} else {
				System.out.println("Quantidade inválida! Verifique o estoque disponível.");
			}
		} else {
			System.out.println("Livro não encontrado.");
		}

	}

	@Override
	public void deletar(String titulo) {
		var livro = buscarNaCollection(titulo);

		if (livro != null && listaLivros.remove(livro)) {
			System.out.println("\nO livro: " + titulo + " foi deletado com sucesso!");
		} else {
			System.out.println("\nO livro : " + titulo + " não foi encontrada!");
		}

	}

	public Livros buscarNaCollection(String titulo) {
		for (var livro : listaLivros) {
			if (livro.getTitulo().equalsIgnoreCase(titulo)) {
				return livro;
			}
		}
		return null;
	}

}
