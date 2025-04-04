package livro.model;

import  livro.util.Cores;
public abstract class Livros {

	private String titulo;
	private String autorLivro;
	private int estoque;
	private String categoriaLivro;
	String nomeCliente;
	private int tipo;
	
	public Livros(String titulo, String autorLivro, int estoque, String categoriaLivro, String nomeCliente, int tipo) {
		this.titulo = titulo;
		this.autorLivro = autorLivro;
		this.estoque = estoque;
		this.categoriaLivro = categoriaLivro;
		this.nomeCliente = nomeCliente;
		this.tipo = tipo;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getCategoriaLivro() {
		return categoriaLivro;
	}

	public void setCategoriaLivro(String categoriaLivro) {
		this.categoriaLivro = categoriaLivro;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public boolean emprestar(int quantidade) {

		if (this.getEstoque() < quantidade) {
			System.out.println("\nNão há livros no estoque!");
			return false;
		}

		this.setEstoque(this.getEstoque() - quantidade);
		return true;
	}

	public void devolucao(int quantidade) {
		this.setEstoque(this.getEstoque() + quantidade);
	}
	
	public void visualizar() {

		String operacao = "";

		switch (this.tipo) {
			case 1:
				operacao = "Registrar Empréstimo";
				break;
			case 2:
				operacao = "Registrar Devolução";
				break;
			default:
				operacao = "Operação Desconhecida";
		}

		System.out.println(Cores.TEXT_BLUE_BRIGHT + "\n\n***********************************************************"
				+ Cores.TEXT_RESET);
		System.out.println("Dados do livro: ");
		System.out.println(Cores.TEXT_BLUE_BRIGHT + "\n\n***********************************************************"
				+ Cores.TEXT_RESET);
		System.out.println("Nome do livro: " + this.titulo);
		System.out.println("Nome do autor do Livro: " + this.autorLivro);
		System.out.println("Tipo da operação: " + operacao);
		System.out.println("Quantidade em estoque: " + this.estoque);
		System.out.println("Genero do livro: " + this.categoriaLivro);
		System.out.println("Nome do Cliente: " + this.nomeCliente);

	}

}
