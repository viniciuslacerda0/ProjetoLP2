package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trackingThings.*;

public class UsuarioTest {
	
	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;
	
	Usuario usuarioIgual1;
	Usuario usuarioIgual2;
	
	@Before
	public void setUp() throws Exception {
		
		usuario1 = new Usuario("Johnny Mitchell", "96644966", "ramonetmaluco@hotmail.com");
		usuario2 = new Usuario("Magic Mike", "4002 8922", "matheusgr@computacao.ufcg.edu.br");
		usuario3 = new Usuario("Antonio Banderas", "+8000", "xX_Dark_Pykachu_Xx@bol.com");
		
		usuario1.getItensEmprestados().add(new BluRayFilme("Piratas", 3.50, 120, "DEZOITO_ANOS", "EROTICO", 2004));
		usuario1.getItensEmprestados().add(new BluRayFilme("H4cK3rS M4lUc0s", 10, 118, "QUATORZE_ANOS", "DOCUMENTARIO", 2010));
		usuario1.getItensEmprestados().add(new JogoEletronico("LOL", 2, "PC"));
		
		usuario1.getItensPossuidos().put("uma noite na opera", new BluRayShow("uma noite na opera", 500, 180, 15, "Queen", "LIVRE"));
	}

	@Test
	public void testGetNome() {
		
		assertEquals("Johnny Mitchell", usuario1.getNome());
		assertEquals("Magic Mike", usuario2.getNome());
		assertEquals("Antonio Banderas", usuario3.getNome());

		assertNotEquals("Michael Schummacher", usuario2.getNome());
	}

	@Test
	public void testSetNome() {
		
		assertEquals("Johnny Mitchell", usuario1.getNome());
		usuario1.setNome("Capitao Nascimento");
		assertEquals("Capitao Nascimento", usuario1.getNome());
	}

	@Test
	public void testGetTelefone() {
		
		assertEquals("96644966", usuario1.getTelefone());
		assertEquals("4002 8922", usuario2.getTelefone());
		assertEquals("+8000", usuario3.getTelefone());
		
		assertNotEquals("123456789", usuario1.getTelefone());
	}

	@Test
	public void testSetTelefone() {

		assertEquals("96644966", usuario1.getTelefone());
		usuario1.setTelefone("987654");
		assertEquals("987654", usuario1.getTelefone());		
	}

	@Test
	public void testGetEmail() {
		
		assertEquals("ramonetmaluco@hotmail.com", usuario1.getEmail());
		assertEquals("matheusgr@computacao.ufcg.edu.br", usuario2.getEmail());
		assertEquals("xX_Dark_Pykachu_Xx@bol.com", usuario3.getEmail());
		
		assertNotEquals("ramonetmaluco@hotmail.com", usuario3.getTelefone());
	}

	@Test
	public void testSetEmail() {
		
		assertEquals("ramonetmaluco@hotmail.com", usuario1.getEmail());
		usuario1.setEmail("aldairPlayboy@gmail.com");
		assertEquals("aldairPlayboy@gmail.com", usuario1.getEmail());
	}

	@Test
	public void testGetItensEmprestados() {

		assertEquals("[Nome: Piratas Ano: 2004 Genero : EROTICO Classificacao: DEZOITO_ANOS, "
				+ "Nome: H4cK3rS M4lUc0s Ano: 2010 Genero : DOCUMENTARIO Classificacao: QUATORZE_ANOS, "
				+ "Jogo Eletronico:LOL Plataforma:PC Preco: 2.0]", usuario1.getItensEmprestados().toString());
		
		usuario1.getItensEmprestados().add(new JogoEletronico("AGE OF EMPIRES", 19.99, "PLAYSTATION 1"));
		
		assertEquals("[Nome: Piratas Ano: 2004 Genero : EROTICO Classificacao: DEZOITO_ANOS, "
				+ "Nome: H4cK3rS M4lUc0s Ano: 2010 Genero : DOCUMENTARIO Classificacao: QUATORZE_ANOS, "
				+ "Jogo Eletronico:LOL Plataforma:PC Preco: 2.0, Jogo Eletronico:AGE OF EMPIRES Plataforma:PLAYSTATION 1 Preco: 19.99]", usuario1.getItensEmprestados().toString());
	}

	@Test
	public void testGetItensPossuidos() {
		
		assertEquals("{uma noite na opera=Titulo: uma noite na opera Artista: Queen Nº de faixas: 15}", usuario1.getItensPossuidos().toString());
	}

	@Test
	public void testEqualsObject() {
		
		
	}

	@Test
	public void testVerificaSeItemExiste() {
		
		assertEquals(true, usuario1.verificaSeItemExiste("uma noite na opera"));
		assertEquals(false, usuario1.verificaSeItemExiste("Jogo da vida"));
	}
}
