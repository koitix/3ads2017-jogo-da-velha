package jogodavelha;

public class AnalisadorJogoDaVelha {

	public static String analisar(String jogo) {
		String[][] informacoes = processar(jogo);
		
		CondicaoVitoria condicaoVitoriosa = null;
		for (CondicaoVitoria condicaoCandidata : CondicaoVitoria.values()) {
			if (condicaoCandidata.atende(informacoes)) {
				condicaoVitoriosa = condicaoCandidata;
				break;
			}
		}
		
		boolean alguemGanhouOJogo = condicaoVitoriosa != null;
		if (alguemGanhouOJogo) {
			String mensagemVitoria = condicaoVitoriosa.getMensagemVitoria(informacoes);
			condicaoVitoriosa.adicionarMarcacoesVitoria(informacoes);
			return ImpressaoJogo.imprimir(jogo, informacoes, ' ', mensagemVitoria);
		}
		
		if (temCelulaVazia(informacoes)) {
			return ImpressaoJogo.imprimir(jogo, informacoes, '?', "Impossível dar resposta porque o jogo está incompleto.");
		}
		
		return ImpressaoJogo.imprimir(jogo, informacoes, '+', "Jogo finalizado. Empate!");
	}

	private static boolean temCelulaVazia(String[][] informacoes) {
		for (int linha = 0; linha <= 2; linha++) {
			for (int coluna = 0; coluna <= 2; coluna++) {
				if (informacoes[linha][coluna] == null)
					return true;
			}
		}
		return false;
	}

	private static String[][] processar(String jogo) {
		String[] linhasDoTabuleiro = jogo.split("\n");
		
		String[] linhasQueInteressam = {
				linhasDoTabuleiro[0],
				linhasDoTabuleiro[2],
				linhasDoTabuleiro[4],
		};
		
		String[][] informacoes = new String[3][3];
		
		for (int linha = 0; linha <= 2; linha++) {
			String[] valoresCrus = linhasQueInteressam[linha].split("\\|");
			for (int coluna = 0; coluna <= 2; coluna++) {
				String valorEnxuto = valoresCrus[coluna].trim();
				if (!valorEnxuto.isEmpty())
					informacoes[linha][coluna] = valorEnxuto;
			}
		}
		
		return informacoes;
	}

}
