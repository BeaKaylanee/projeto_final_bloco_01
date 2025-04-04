package livro.model;

public class CadastrarLivro extends Livros {

	private int estoque;

	public CadastrarLivro(String titulo, String autorLivro, int estoque, String categoriaLivro, String tipoOperacao, int livrosEmprestados) {
		super(titulo, autorLivro, estoque, categoriaLivro, tipoOperacao, estoque, livrosEmprestados);
		this.estoque = estoque;
		System.out.println("Livro cadastrado com sucesso!");
	}

	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Visualizar livros cadastrados: " + this.getEstoque());

	}
}
