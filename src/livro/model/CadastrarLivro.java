package livro.model;

import livro.util.Cores;

public class CadastrarLivro extends Livros {

	private int estoque;

	public CadastrarLivro(String titulo, String autorLivro, int estoque, String categoriaLivro, String nomeCliente, String tipoOperacao, int tipo) {
        super(titulo, autorLivro, estoque, categoriaLivro, nomeCliente, tipo);
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
