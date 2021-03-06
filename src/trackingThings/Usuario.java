package trackingThings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cada Usuario tera um nome, telefone, email e um conjunto de itens
 *	
 */
/**
 * @author Jose Vinicius
 *
 */
public class Usuario {
	
	private String nome;
	private String telefone;
 	private String email;
 	private double reputacao;
 	private String cartao;
 	private HashMap <String,Item> itensPossuidos;
	private ArrayList <Item> itensEmprestados;
	private ArrayList <Emprestimo> emprestimosPego;
	private ArrayList <Emprestimo> emprestando;
	
	public Usuario(String nome,String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.reputacao = 0.0;
		this.cartao = "FreeRyder";
		this.email = email;
		this.emprestimosPego = new ArrayList<>();
		this.emprestando = new ArrayList<>();
		this.itensEmprestados = new ArrayList<>();
		this.itensPossuidos = new HashMap<>();
	}

	/**
	 * @return nome do Usuario
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Mudanca no nome do Usuario
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return telefone do Usuario
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Mudanca no telefone do Usuario
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return email do Usuario
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Mudanca no email do Usuario
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return lista de itens de um Usuario
	 */
	public ArrayList<Item> getItensEmprestados() {
		return this.itensEmprestados;
	}

	/**
	 * Mudanca na lista de itens de um Usuario
	 * @param itens
	 */
	public void setItensEmprestrados(ArrayList<Item> itens) {
		this.itensEmprestados = itens;
	}

	/**
	 * @return lista de itens pegos
	 */
	public HashMap<String, Item> getItensPossuidos() {
		return itensPossuidos;
	}
	
	
	public Item getItem(String nomeItem){
		return itensPossuidos.get(nomeItem);
	}


	public ArrayList<Emprestimo> getEmprestimosPego() {
		return emprestimosPego;
	}

	public ArrayList<Emprestimo> getEmprestando() {
		return emprestando;
	}

	/* 
	 * toString do Usuario
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nome + "," + this.email + "," + this.telefone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	/**
	 * Cadastra um jogo eletronico
	 * @param nomeItem
	 * @param preco
	 * @param plataforma
	 */
	public void cadastrarEletronico(String nomeItem, Double preco, String plataforma) {
		JogoEletronico jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		this.addReputacao(preco * 0.05);
		this.itensPossuidos.put(nomeItem, jogoEletronico);
	}

	/**
	 * Cadastra jogo de tabuleiro
	 * @param nomeItem
	 * @param preco
	 */
	public void cadastrarJogoTabuleiro(String nomeItem, Double preco) {
		JogoTabuleiro jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		this.addReputacao(preco * 0.05);
		itensPossuidos.put(nomeItem, jogoTabuleiro);
	}

	/**
	 * Informa que uma peca foi perdida
	 * @param nomeItem
	 * @param nomePeca
	 */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		((JogoTabuleiro) itensPossuidos.get(nomeItem)).adicionarPecaPerdida(nomePeca);
	}

	/**
	 * Cadastra um Bluray de filme
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param genero
	 * @param classificacao
	 * @param anoLancamento
	 */
	public void cadastrarBluRayFilme(String nomeItem, Double preco, int duracao, String genero,String classificacao,
			int anoLancamento) {
		BluRayFilme bluRayFilme = new BluRayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		this.addReputacao(preco * 0.05);
		itensPossuidos.put(nomeItem, bluRayFilme);
	}

	/**
	 * Cadastra um Bluray de show
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param numeroFaixas
	 * @param artista
	 * @param classificacao
	 */
	public void cadastrarBluRayShow(String nomeItem, Double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		BluRayShow bluRayShow = new BluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		this.addReputacao(preco * 0.05);
		itensPossuidos.put(nomeItem, bluRayShow);
	}

	/**
	 * Cadastra um Bluray de serie
	 * @param nomeItem
	 * @param preco
	 * @param descricao
	 * @param duracao
	 * @param classificacao
	 * @param genero
	 * @param temporada
	 */
	public void cadastrarBluRaySerie(String nomeItem, Double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		BluRayTemporada bluRaySerie = new BluRayTemporada(nomeItem, preco, duracao, classificacao, genero, temporada);
		this.addReputacao(preco * 0.05);
		itensPossuidos.put(nomeItem, bluRaySerie);
	}

	/**
	 * Adiciona uma episodio a temporada
	 * @param nomeBlurayTemporada
	 * @param duracao
	 */
	public void adicionarBluRay(String nomeBlurayTemporada, int duracao) {
		((BluRayTemporada) itensPossuidos.get(nomeBlurayTemporada)).addEpisodio(duracao);
		((BluRayTemporada) itensPossuidos.get(nomeBlurayTemporada))
		.setDuracaoTotal(((BluRayTemporada) itensPossuidos.get(nomeBlurayTemporada)).getDuracaoTotal());
	}

	/**
	 * Remove item dos itens possuidos
	 * @param nomeItem
	 */
	public void removerItem(String nomeItem) {
		this.itensPossuidos.remove(nomeItem);
		this.addReputacao(itensPossuidos.get(nomeItem).getValor() * (-0.05));//diminui a reputacao ao remover um item dos itens possuidos
	}

	/**
	 * Altera algum atributo de item(nome, preco)
	 * @param nomeItem
	 * @param atributo
	 * @param valor
	 */
	public void atualizarItem(String nomeItem, String atributo, String valor) {
		if (!itensPossuidos.containsKey(nomeItem)){
			throw new NullPointerException("Item invalido");
		}
		
		if (atributo.toLowerCase().equals("nome")){
			itensPossuidos.get(nomeItem).setNome(valor);
			this.itensPossuidos.put(valor,itensPossuidos.get(nomeItem));
			itensPossuidos.remove(nomeItem);
		}	
		else if (atributo.toLowerCase().equals("preco")){
			this.itensPossuidos.get(nomeItem).setValor(Double.parseDouble(valor));
		}
	}

	/**
	 * Pega informacao do item
	 * @param nomeItem
	 * @param atributo
	 * @return
	 */
	public String getInfoItem(String nomeItem, String atributo) {

		if (atributo.equalsIgnoreCase("preco")) {
			return Double.toString(this.itensPossuidos.get(nomeItem).getValor());
		}
		if (atributo.equalsIgnoreCase("nome")) {
			return this.itensPossuidos.get(nomeItem).getNome();

		}
		throw new NullPointerException("Atributo invalido");
	}
	
	/**
	 * Verifica se o item existe no sistema
	 * @param nomeItem
	 * @return
	 */
	public boolean verificaSeItemExiste(String nomeItem) {
		if (this.itensPossuidos.containsKey(nomeItem)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Pega detalhes dos itens
	 * @param nomeItem
	 * @return toString de item
	 */
	public String detalhesItem(String nomeItem){
		return itensPossuidos.get(nomeItem).toString();
	}
	
	/**
	 * Adiciona item emprestado numa lista de emprestimo
	 * @param item
	 */
	public void adicionaEmEmprestados(Item item){
		itensEmprestados.add(item);
	}
	
	/**
	 * Remove item emprestadado da lista de emprestimo
	 * @param item
	 */
	public void removeEmEmprestados(Item item){
		itensEmprestados.remove(item);
	}
	
	/**
	 * Adiciona o item a lista de itens pegos
	 * @param emprestimo
	 */
	public void adicionaEmEmprestimosPego(Emprestimo emprestimo) {
		emprestimosPego.add(emprestimo);
	}
	
	/**
	 * Adiciona o item a lista de itens disponiveis para emprestimo
	 * @param emprestimo
	 */
	public void AdicionaEmEmprestando(Emprestimo emprestimo) {
		emprestando.add(emprestimo);
	}

	/**
	 * Adquire a reputacao do usuario
	 * @return reputacao do usuario
	 */
	public double getReputacao() {
		return this.reputacao;
	}
	
	/**
	 * Institue uma reputacao ao usuario
	 * @param reputacao
	 */
	public void addReputacao(double reputacao) {
		this.reputacao += reputacao;
	}
	
	public void removeReputacao(double reputacao) {
		this.reputacao -= reputacao;
	}

	/**
	 * @return cartao do usuario
	 */
	public String getCartao() {
		calculaCartao();
		return this.cartao;
	}
	
	/**
	 * Institue um cartao ao usuario
	 * @param cartao
	 */
	private void calculaCartao() {
		if (this.reputacao >= 0 && itensPossuidos.size() == 0){
			this.cartao = "FreeRyder";
		}else if (this.reputacao > 100){
			this.cartao = "BomAmigo";
		}else if (this.reputacao > 0 && this.reputacao <= 100){
			this.cartao = "Noob";
		}else{
			this.cartao = "Caloteiro";
		}
	}
	
	
	
	
}
