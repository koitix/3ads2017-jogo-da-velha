package jogodavelha;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class AnalisadorJogoDaVelhaTest {

	@Test
	public void analisarJogoIncompletoParte1() {
		String resultado = AnalisadorJogoDaVelha.analisar(
			"   | O |   \n" +
			"---+---+---\n" +
			"   |   |   \n" +
			"---+---+---\n" +
			"   |   |   \n");
		
		assertThat(resultado).isEqualTo(
			"   | O |   \n" +
			"---+---+---\n" +
			"   |   |   \n" +
			"---+---+---\n" +
			"   |   |   \n" +
			"===========\n" +
			" ? | O | ? \n" +
			"---+---+---\n" +
			" ? | ? | ? \n" +
			"---+---+---\n" +
			" ? | ? | ? \n" +
			"===========\n" +
			"Impossível dar resposta porque o jogo está incompleto.");
	}
	
	@Test
	public void analisarJogoIncompletoParte2() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				"   | O |   \n" +
				"---+---+---\n" +
				"   | X |   \n" +
				"---+---+---\n" +
				"   |   |   \n");
		
		assertThat(resultado).isEqualTo(
				"   | O |   \n" +
				"---+---+---\n" +
				"   | X |   \n" +
				"---+---+---\n" +
				"   |   |   \n" +
				"===========\n" +
				" ? | O | ? \n" +
				"---+---+---\n" +
				" ? | X | ? \n" +
				"---+---+---\n" +
				" ? | ? | ? \n" +
				"===========\n" +
				"Impossível dar resposta porque o jogo está incompleto.");
	}
	
	@Test
	public void analisarJogoIncompletoParte3() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				"   | O |   \n" +
				"---+---+---\n" +
				"   | X | O \n" +
				"---+---+---\n" +
				"   |   |   \n");
		
		assertThat(resultado).isEqualTo(
				"   | O |   \n" +
				"---+---+---\n" +
				"   | X | O \n" +
				"---+---+---\n" +
				"   |   |   \n" +
				"===========\n" +
				" ? | O | ? \n" +
				"---+---+---\n" +
				" ? | X | O \n" +
				"---+---+---\n" +
				" ? | ? | ? \n" +
				"===========\n" +
				"Impossível dar resposta porque o jogo está incompleto.");
	}
	
	@Test
	public void analisarJogoIncompletoParte4() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				"   | O |   \n" +
				"---+---+---\n" +
				"   | X | O \n" +
				"---+---+---\n" +
				" X |   |   \n");
		
		assertThat(resultado).isEqualTo(
				"   | O |   \n" +
				"---+---+---\n" +
				"   | X | O \n" +
				"---+---+---\n" +
				" X |   |   \n" +
				"===========\n" +
				" ? | O | ? \n" +
				"---+---+---\n" +
				" ? | X | O \n" +
				"---+---+---\n" +
				" X | ? | ? \n" +
				"===========\n" +
				"Impossível dar resposta porque o jogo está incompleto.");
	}
	
	@Test
	public void analisarJogoIncompletoParte5() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				" O | O |   \n" +
				"---+---+---\n" +
				"   | X | O \n" +
				"---+---+---\n" +
				" X |   |   \n");
		
		assertThat(resultado).isEqualTo(
				" O | O |   \n" +
				"---+---+---\n" +
				"   | X | O \n" +
				"---+---+---\n" +
				" X |   |   \n" +
				"===========\n" +
				" O | O | ? \n" +
				"---+---+---\n" +
				" ? | X | O \n" +
				"---+---+---\n" +
				" X | ? | ? \n" +
				"===========\n" +
				"Impossível dar resposta porque o jogo está incompleto.");
	}
	
	@Test
	public void analisarJogoCompletoEmpatado() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				" O | X | X \n" +
				"---+---+---\n" +
				" X | O | O \n" +
				"---+---+---\n" +
				" O | X | X \n");
		
		assertThat(resultado).isEqualTo(
				" O | X | X \n" +
				"---+---+---\n" +
				" X | O | O \n" +
				"---+---+---\n" +
				" O | X | X \n" +
				"===========\n" +
				" O | X | X \n" +
				"---+---+---\n" +
				" X | O | O \n" +
				"---+---+---\n" +
				" O | X | X \n" +
				"===========\n" +
				"Jogo finalizado. Empate!");
	}
	
	@Test
	public void analisarJogoCompletoGanhoDiagonal1() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				" O | O | X \n" +
				"---+---+---\n" +
				"   | X | O \n" +
				"---+---+---\n" +
				" X |   |   \n");
		
		assertThat(resultado).isEqualTo(
				" O | O | X \n" +
				"---+---+---\n" +
				"   | X | O \n" +
				"---+---+---\n" +
				" X |   |   \n" +
				"===========\n" +
				" O | O | * \n" +
				"---+---+---\n" +
				"   | * | O \n" +
				"---+---+---\n" +
				" * |   |   \n" +
				"===========\n" +
				"Jogo finalizado. Jogador X ganhou!");
	}
	
	@Test
	public void analisarJogoCompletoGanhoDiagonal2() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				" X | O | O \n" +
				"---+---+---\n" +
				" O | X |   \n" +
				"---+---+---\n" +
				"   |   | X \n");
		
		assertThat(resultado).isEqualTo(
				" X | O | O \n" +
				"---+---+---\n" +
				" O | X |   \n" +
				"---+---+---\n" +
				"   |   | X \n" +
				"===========\n" +
				" * | O | O \n" +
				"---+---+---\n" +
				" O | * |   \n" +
				"---+---+---\n" +
				"   |   | * \n" +
				"===========\n" +
				"Jogo finalizado. Jogador X ganhou!");
	}
	
	@Test
	public void analisarJogoCompletoGanhoVertical1() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				" O |   | X \n" +
				"---+---+---\n" +
				" O | X |   \n" +
				"---+---+---\n" +
				" O | X | O \n");
		
		assertThat(resultado).isEqualTo(
				" O |   | X \n" +
				"---+---+---\n" +
				" O | X |   \n" +
				"---+---+---\n" +
				" O | X | O \n" +
				"===========\n" +
				" * |   | X \n" +
				"---+---+---\n" +
				" * | X |   \n" +
				"---+---+---\n" +
				" * | X | O \n" +
				"===========\n" +
				"Jogo finalizado. Jogador O ganhou!");
	}

	@Test
	public void analisarJogoCompletoGanhoVertical2() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				"   | O | X \n" +
				"---+---+---\n" +
				" X | O |   \n" +
				"---+---+---\n" +
				" X | O | O \n");
		
		assertThat(resultado).isEqualTo(
				"   | O | X \n" +
				"---+---+---\n" +
				" X | O |   \n" +
				"---+---+---\n" +
				" X | O | O \n" +
				"===========\n" +
				"   | * | X \n" +
				"---+---+---\n" +
				" X | * |   \n" +
				"---+---+---\n" +
				" X | * | O \n" +
				"===========\n" +
				"Jogo finalizado. Jogador O ganhou!");
	}
	
	@Test
	public void analisarJogoCompletoGanhoVertical3() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				"   | X | O \n" +
				"---+---+---\n" +
				" X |   | O \n" +
				"---+---+---\n" +
				" X |   | O \n");
		
		assertThat(resultado).isEqualTo(
				"   | X | O \n" +
				"---+---+---\n" +
				" X |   | O \n" +
				"---+---+---\n" +
				" X |   | O \n" +
				"===========\n" +
				"   | X | * \n" +
				"---+---+---\n" +
				" X |   | * \n" +
				"---+---+---\n" +
				" X |   | * \n" +
				"===========\n" +
				"Jogo finalizado. Jogador O ganhou!");
	}
	
	@Test
	public void analisarJogoCompletoGanhoHorizontal1() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				" O | O | O \n" +
				"---+---+---\n" +
				"   |   | X \n" +
				"---+---+---\n" +
				" X | X |   \n");
		
		assertThat(resultado).isEqualTo(
				" O | O | O \n" +
				"---+---+---\n" +
				"   |   | X \n" +
				"---+---+---\n" +
				" X | X |   \n" +
				"===========\n" +
				" * | * | * \n" +
				"---+---+---\n" +
				"   |   | X \n" +
				"---+---+---\n" +
				" X | X |   \n" +
				"===========\n" +
				"Jogo finalizado. Jogador O ganhou!");
	}
	
	@Test
	public void analisarJogoCompletoGanhoHorizontal2() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				" O |   | X \n" +
				"---+---+---\n" +
				" O | O | O \n" +
				"---+---+---\n" +
				" X | X |   \n");
		
		assertThat(resultado).isEqualTo(
				" O |   | X \n" +
				"---+---+---\n" +
				" O | O | O \n" +
				"---+---+---\n" +
				" X | X |   \n" +
				"===========\n" +
				" O |   | X \n" +
				"---+---+---\n" +
				" * | * | * \n" +
				"---+---+---\n" +
				" X | X |   \n" +
				"===========\n" +
				"Jogo finalizado. Jogador O ganhou!");
	}
	
	@Test
	public void analisarJogoCompletoGanhoHorizontal3() {
		String resultado = AnalisadorJogoDaVelha.analisar(
				" O |   | X \n" +
				"---+---+---\n" +
				" X | X |   \n" +
				"---+---+---\n" +
				" O | O | O \n");
		
		assertThat(resultado).isEqualTo(
				" O |   | X \n" +
				"---+---+---\n" +
				" X | X |   \n" +
				"---+---+---\n" +
				" O | O | O \n" +
				"===========\n" +
				" O |   | X \n" +
				"---+---+---\n" +
				" X | X |   \n" +
				"---+---+---\n" +
				" * | * | * \n" +
				"===========\n" +
				"Jogo finalizado. Jogador O ganhou!");
	}
	
}
