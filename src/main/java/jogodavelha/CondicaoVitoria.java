package jogodavelha;

public enum CondicaoVitoria {
	
	DIAGONAL_1(new Posicao(0,0), new Posicao(1,1), new Posicao(2,2)),
	DIAGONAL_2(new Posicao(0,2), new Posicao(1,1), new Posicao(2,0)),
	HORIZONTAL_1(new Posicao(0,0), new Posicao(0,1), new Posicao(0,2)),
	HORIZONTAL_2(new Posicao(1,0), new Posicao(1,1), new Posicao(1,2)),
	HORIZONTAL_3(new Posicao(2,0), new Posicao(2,1), new Posicao(2,2)),
	VERTICAL_1(new Posicao(0,0), new Posicao(1,0), new Posicao(2,0)),
	VERTICAL_2(new Posicao(0,1), new Posicao(1,1), new Posicao(2,1)),
	VERTICAL_3(new Posicao(0,2), new Posicao(1,2), new Posicao(2,2));
	
	private static final String MARCACAO_VITORIA = " * ";
	private Posicao celula1;
	private Posicao celula2;
	private Posicao celula3;
	
	private CondicaoVitoria(Posicao celula1, Posicao celula2, Posicao celula3) {
		this.celula1 = celula1;
		this.celula2 = celula2;
		this.celula3 = celula3;
	}

	public boolean atende(String[][] informacoes) {
		String simboloPrimeiraCelula = informacoes[celula1.linha][celula1.coluna];
		
		if (simboloPrimeiraCelula == null)
			return false;
		
		String simboloSegundaCelula = informacoes[celula2.linha][celula2.coluna];
		boolean atende = simboloSegundaCelula != null && simboloPrimeiraCelula.equals(simboloSegundaCelula);
		
		String simboloTerceiraCelula = informacoes[celula3.linha][celula3.coluna];
		atende = atende && simboloTerceiraCelula != null && simboloPrimeiraCelula.equals(simboloTerceiraCelula);
		
		return atende;
	}

	public String gerarJogo(String[][] informacoes) {
		String[][] jogoProcessado = new String[3][3];
		for (int linha = 0; linha <= 2; linha++) {
			for (int coluna = 0; coluna <= 2; coluna++) {
				String valor = informacoes[linha][coluna];
				String valorProcessado = valor != null ? valor : " ";
				String valorParaCelula = " " + valorProcessado + " ";
				
				jogoProcessado[linha][coluna] = valorParaCelula;
			}
		}
		
		adicionarMarcacoesVitoria(jogoProcessado);
		
		String resposta = "";
		for (int linha = 0; linha <= 2; linha++) {
			resposta += jogoProcessado[linha][0] + "|" + jogoProcessado[linha][1] + "|" + jogoProcessado[linha][2] + "\n";
			if (linha < 2) {
				resposta += "---+---+---\n";
			}
		}
		
		return resposta;
	}

	private void adicionarMarcacoesVitoria(String[][] jogoProcessado) {
		jogoProcessado[celula1.linha][celula1.coluna] = MARCACAO_VITORIA;
		jogoProcessado[celula2.linha][celula2.coluna] = MARCACAO_VITORIA;
		jogoProcessado[celula3.linha][celula3.coluna] = MARCACAO_VITORIA;
	}

	public String getMensagemVitoria(String[][] informacoes) {
		String simboloPrimeiraCelula = informacoes[celula1.linha][celula1.coluna];
		return String.format("Jogo finalizado. Jogador %s ganhou!", simboloPrimeiraCelula);
	}

}
