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
			String resposta = jogo + 
					"===========\n" + 
					condicaoVitoriosa.gerarJogo(informacoes) +
					"===========\n" +
					condicaoVitoriosa.getMensagemVitoria(informacoes);
			
			return resposta;
		}
		
		if (temCelulaVazia(informacoes)) {
			String resposta = jogo + 
					"===========\n" + 
					gerarJogoIncompleto(informacoes) +
					"===========\n" +
					"Impossível dar resposta porque o jogo está incompleto.";
			
			return resposta;
		}
		
		String resposta = jogo + 
				"===========\n" + 
				jogo +
				"===========\n" +
				"Jogo finalizado. Empate!";
		
		return resposta;
	}

	private static String gerarJogoIncompleto(String[][] informacoes) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean temCelulaVazia(String[][] informacoes) {
		// TODO Auto-generated method stub
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
