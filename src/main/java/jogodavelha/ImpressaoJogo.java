package jogodavelha;

public class ImpressaoJogo {

	public static String imprimir(String jogo, String[][] informacoes, char valorCelulaVazia, String mensagem) {
		return jogo + 
				"===========\n" + 
				gerarRepresentacao(informacoes, valorCelulaVazia) +
				"===========\n" +
				mensagem;
	}

	private static String gerarRepresentacao(String[][] informacoes, char valorCelulaVazia) {
		String[][] informacoesImpressao = new String[3][3];
		for (int linha = 0; linha <= 2; linha++) {
			for (int coluna = 0; coluna <= 2; coluna++) {
				String valor = informacoes[linha][coluna];
				String valorProcessado = valor != null ? valor : String.valueOf(valorCelulaVazia);
				String valorParaImpressao = String.format(" %s ", valorProcessado);
				
				informacoesImpressao[linha][coluna] = valorParaImpressao;
			}
		}
		
		String jogoIncompleto = "";
		for (int linha = 0; linha <= 2; linha++) {
			jogoIncompleto += informacoesImpressao[linha][0] + "|" + informacoesImpressao[linha][1] + "|" + informacoesImpressao[linha][2] + "\n";
			if (linha < 2) {
				jogoIncompleto += "---+---+---\n";
			}
		}
		
		return jogoIncompleto;
	}

}
