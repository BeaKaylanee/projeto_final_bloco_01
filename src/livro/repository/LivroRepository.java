package livro.repository;

import livro.model.Livros;

public interface LivroRepository {

	void cadastrar(Livros livro);
	void listarTodos();
	void buscarPorTitulo(String titulo);
	void atualizar(String tituloAntigo, Livros livroAtualizado);
	void deletar(String titulo);
	void registrarLivrosEmprestados(String livros, int quantidade);
}
