package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trackingThings.*;

public class TestFacade {
	
	Facade facade;

	@Before
	public void setUp() throws Exception {
		
		facade = new Facade();
		facade.cadastrarUsuario("Arizinho", "9900-6660","arizinho100%lindo@bol.com.br");
		facade.cadastrarUsuario("Ramones", "9955-2222","ramon100%cancer@gmail.com");
		facade.cadastrarUsuario("zezinho", "9988-8889", "zevinicin@yahoo.com.br");
		facade.cadastrarUsuario("katiau", "9912-3456","katiau@gmail.com");
		// Adicionando para Arizinho 9900-6660
		facade.cadastrarBluRayFilme("Arizinho", "9900-6660", "X-men", 29.99, 120, "Acao", "DEZESSEIS_ANOS", 2002);
		facade.cadastrarBluRaySerie("Arizinho", "9900-6660", "The Walking Dead", 25.50, "zumbis", 160, "DOZE_ANOS", "Suspense", 2);
		facade.cadastrarBluRayShow("Arizinho", "9900-6660", "RBD", 45.99, 90, 15, "REBELDES", "DOZE_ANOS");
		facade.cadastrarJogoTabuleiro("Arizinho", "9900-6660", "damas", 0.99);
		facade.cadastrarEletronico("Arizinho", "9900-6660", "Mario bros", 1.25, "NINTENDO");
		// Adicionando para Ramones 9955-2222
		facade.cadastrarBluRayFilme("Ramones", "9955-2222", "Pirata dos caribes", 50.00, 120, "Acao", "DEZESSEIS_ANOS", 2015);
		facade.cadastrarBluRaySerie("Ramones", "9955-2222", "Game of Thrones", 35.00, "lutas epicas", 180, "DEZESSEIS_ANOS", "Suspense", 6);
		facade.cadastrarBluRayShow("Ramones", "9955-2222", "LS", 99.00, 90, 15, "Luan Santana", "DEZ_ANOS");
		facade.cadastrarJogoTabuleiro("Ramones", "9955-2222", "xadrez", 100.00);
		facade.cadastrarEletronico("Ramones", "9955-2222", "mario world", 1.00, "NINTENDO");
		// Adicionando para zezinho 9988-8889
		facade.cadastrarBluRayFilme("zezinho", "9988-8889", "Brasileirinhas", 69.00, 60, "EROTICO", "DEZOITO_ANOS", 2013);
		facade.cadastrarBluRaySerie("zezinho", "9988-8889", "Vikings", 99.00, "mitologia nordica", 120, "DOZE_ANOS", "Suspense", 3);
		facade.cadastrarBluRayShow("zezinho", "9988-8889", "Los Hermanos", 99.00, 90, 15, "Losers manos", "LIVRE");
		facade.cadastrarJogoTabuleiro("zezinho", "9988-8889", "Django", 24.00);
		facade.cadastrarEletronico("zezinho", "9988-8889", "sonic", 1.00, "MEGA DRIVE");
		// Adicionando para katiau 9912-3456
		facade.cadastrarBluRayFilme("katiau", "9912-3456", "Simpsons XXX", 50.00, 120, "EROTICO", "DEZOITO_ANOS", 2000);
		facade.cadastrarBluRaySerie("katiau", "9912-3456", "Mr Robot", 86.00, "hacker", 160, "DEZESSEIS_ANOS", "Drama", 2);
		facade.cadastrarBluRayShow("katiau", "9912-3456", "Ramones", 10.00, 60, 5, "Ramonetmal", "DEZ_ANOS");
		facade.cadastrarJogoTabuleiro("katiau", "9912-3456", "War", 120.00);
		facade.cadastrarEletronico("katiau", "9912-3456", "Bomba Patch", 1.00, "PS2");
						
				
	}
	
	@Test
	public void testGetInfoUsuario() {
		assertEquals(facade.getInfoUsuario("Arizinho", "9900-6660", "nome"), "Arizinho");
		assertEquals(facade.getInfoUsuario("Arizinho", "9900-6660", "telefone"),"9900-6660");
		assertEquals(facade.getInfoUsuario("Arizinho", "9900-6660", "email"), "arizinho100%lindo@bol.com.br");
		assertEquals(facade.getInfoUsuario("Ramones", "9955-2222", "nome"), "Ramones");
		assertEquals(facade.getInfoUsuario("Ramones", "9955-2222", "telefone"),"9955-2222");
		assertEquals(facade.getInfoUsuario("Ramones", "9955-2222", "email"), "ramon100%cancer@gmail.com");
		assertEquals(facade.getInfoUsuario("zezinho", "9988-8889", "nome"), "zezinho");
		assertEquals(facade.getInfoUsuario("zezinho", "9988-8889", "telefone"),"9988-8889");
		assertEquals(facade.getInfoUsuario("zezinho", "9988-8889", "email"), "zevinicin@yahoo.com.br");
		assertEquals(facade.getInfoUsuario("katiau", "9912-3456", "nome"), "katiau");
		assertEquals(facade.getInfoUsuario("katiau", "9912-3456", "telefone"),"9912-3456");
		assertEquals(facade.getInfoUsuario("katiau", "9912-3456", "email"), "katiau@gmail.com");
		
	}
	
	@Test
	public void testGetInfoItem() {
		assertEquals(facade.getInfoItem("Arizinho", "9900-6660", "damas", "nome"), "damas");
		assertEquals(facade.getInfoItem("Arizinho", "9900-6660", "damas", "preco"), "0.99");		
		assertEquals(facade.getInfoItem("Ramones", "9955-2222", "mario world", "nome"), "mario world");
		assertEquals(facade.getInfoItem("Ramones", "9955-2222", "mario world", "preco"), "1.0");		
		assertEquals(facade.getInfoItem("zezinho", "9988-8889", "Los Hermanos", "nome"), "Los Hermanos");
		assertEquals(facade.getInfoItem("zezinho", "9988-8889", "Los Hermanos", "preco"), "99.0");		
		assertEquals(facade.getInfoItem("katiau", "9912-3456", "War", "nome"), "War");
		assertEquals(facade.getInfoItem("katiau", "9912-3456", "War", "preco"), "120.0");		

	}
	
	@Test
	public void testPesquisarDetalhesItens() {
		assertEquals(facade.pesquisarDetalhesItem("Arizinho", "9900-6660", "X-men"), "FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2002");
		assertEquals(facade.pesquisarDetalhesItem("Arizinho", "9900-6660", "The Walking Dead"), "SERIE: The Walking Dead, R$ 25.5, Nao emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2");
		assertEquals(facade.pesquisarDetalhesItem("Arizinho", "9900-6660", "RBD"), "SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas");
		assertEquals(facade.pesquisarDetalhesItem("Arizinho", "9900-6660", "damas"), "JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO");
		assertEquals(facade.pesquisarDetalhesItem("Arizinho", "9900-6660", "Mario bros"), "JOGO ELETRONICO: Mario bros, R$ 1.25, Nao emprestado, NINTENDO");
		
		assertEquals(facade.pesquisarDetalhesItem("zezinho", "9988-8889", "Brasileirinhas"), "FILME: Brasileirinhas, R$ 69.0, Nao emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013");
		assertEquals(facade.pesquisarDetalhesItem("zezinho", "9988-8889", "Vikings"), "SERIE: Vikings, R$ 99.0, Nao emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3");
		assertEquals(facade.pesquisarDetalhesItem("zezinho", "9988-8889", "Los Hermanos"), "SHOW: Los Hermanos, R$ 99.0, Nao emprestado, 90 min, LIVRE, Losers manos, 15 faixas");
		assertEquals(facade.pesquisarDetalhesItem("zezinho", "9988-8889", "Django"), "JOGO DE TABULEIRO: Django, R$ 24.0, Nao emprestado, COMPLETO");
		assertEquals(facade.pesquisarDetalhesItem("zezinho", "9988-8889", "sonic"), "JOGO ELETRONICO: sonic, R$ 1.0, Nao emprestado, MEGA DRIVE");
		
	}
	
	@Test
	public void testListarItensOrdenadosPorNome() {
		assertEquals(facade.listarItensOrdenadosPorNome(), "JOGO ELETRONICO: Bomba Patch, R$ 1.0, Nao emprestado, PS2|FILME: Brasileirinhas, R$ 69.0, Nao emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013|JOGO DE TABULEIRO: Django, R$ 24.0, Nao emprestado, COMPLETO|SERIE: Game of Thrones, R$ 35.0, Nao emprestado, 180 min, DEZESSEIS_ANOS, Suspense, Temporada 6|SHOW: LS, R$ 99.0, Nao emprestado, 90 min, DEZ_ANOS, Luan Santana, 15 faixas|SHOW: Los Hermanos, R$ 99.0, Nao emprestado, 90 min, LIVRE, Losers manos, 15 faixas|JOGO ELETRONICO: Mario bros, R$ 1.25, Nao emprestado, NINTENDO|SERIE: Mr Robot, R$ 86.0, Nao emprestado, 160 min, DEZESSEIS_ANOS, Drama, Temporada 2|FILME: Pirata dos caribes, R$ 50.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2015|SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas|SHOW: Ramones, R$ 10.0, Nao emprestado, 60 min, DEZ_ANOS, Ramonetmal, 5 faixas|FILME: Simpsons XXX, R$ 50.0, Nao emprestado, 120 min, DEZOITO_ANOS, EROTICO, 2000|SERIE: The Walking Dead, R$ 25.5, Nao emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2|SERIE: Vikings, R$ 99.0, Nao emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3|JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2002|JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|JOGO ELETRONICO: mario world, R$ 1.0, Nao emprestado, NINTENDO|JOGO ELETRONICO: sonic, R$ 1.0, Nao emprestado, MEGA DRIVE|JOGO DE TABULEIRO: xadrez, R$ 100.0, Nao emprestado, COMPLETO|");
	}


	@Test
	public void testListarItensOrdenadosPorValor() {
		assertEquals(facade.listarItensOrdenadosPorValor(),"JOGO DE TABULEIRO: damas, R$ 0.99, Nao emprestado, COMPLETO|JOGO ELETRONICO: mario world, R$ 1.0, Nao emprestado, NINTENDO|JOGO ELETRONICO: Bomba Patch, R$ 1.0, Nao emprestado, PS2|JOGO ELETRONICO: sonic, R$ 1.0, Nao emprestado, MEGA DRIVE|JOGO ELETRONICO: Mario bros, R$ 1.25, Nao emprestado, NINTENDO|SHOW: Ramones, R$ 10.0, Nao emprestado, 60 min, DEZ_ANOS, Ramonetmal, 5 faixas|JOGO DE TABULEIRO: Django, R$ 24.0, Nao emprestado, COMPLETO|SERIE: The Walking Dead, R$ 25.5, Nao emprestado, 160 min, DOZE_ANOS, Suspense, Temporada 2|FILME: X-men, R$ 29.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2002|SERIE: Game of Thrones, R$ 35.0, Nao emprestado, 180 min, DEZESSEIS_ANOS, Suspense, Temporada 6|SHOW: RBD, R$ 45.99, Nao emprestado, 90 min, DOZE_ANOS, REBELDES, 15 faixas|FILME: Pirata dos caribes, R$ 50.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, Acao, 2015|FILME: Simpsons XXX, R$ 50.0, Nao emprestado, 120 min, DEZOITO_ANOS, EROTICO, 2000|FILME: Brasileirinhas, R$ 69.0, Nao emprestado, 60 min, DEZOITO_ANOS, EROTICO, 2013|SERIE: Mr Robot, R$ 86.0, Nao emprestado, 160 min, DEZESSEIS_ANOS, Drama, Temporada 2|SHOW: LS, R$ 99.0, Nao emprestado, 90 min, DEZ_ANOS, Luan Santana, 15 faixas|SERIE: Vikings, R$ 99.0, Nao emprestado, 120 min, DOZE_ANOS, Suspense, Temporada 3|SHOW: Los Hermanos, R$ 99.0, Nao emprestado, 90 min, LIVRE, Losers manos, 15 faixas|JOGO DE TABULEIRO: xadrez, R$ 100.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: War, R$ 120.0, Nao emprestado, COMPLETO|");
	}
	

}
