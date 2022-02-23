package jogodavelha.Dominio;

import java.util.Arrays;

import jogodavelha.responsabilidade.GanharDiagonalDispenser;
import jogodavelha.responsabilidade.GanharHorizontalDispenser;
import jogodavelha.responsabilidade.GanharVerticalDispenser;
import jogodavelha.responsabilidade.VerificarGanhadorDispenser;

public class JogoDaVelha {
	
	private String[][] tabuleiro;
	private boolean ganhouJogo = true;
	
	public JogoDaVelha(Integer tamanhoTabuleiro)
	{
		this.tabuleiro = new String[tamanhoTabuleiro][tamanhoTabuleiro]; 
	}
	
	public boolean realizaJogada(int linhaUsuario, int colunaUsuario, String caracter)
	{
		if (this.tabuleiro[linhaUsuario-1][colunaUsuario-1] == null)
		{
			this.tabuleiro[linhaUsuario-1][colunaUsuario-1] = caracter;
			return true;
		}
		return false;
	}
	
	public boolean verificaGanhador()
	{
		VerificarGanhadorDispenser dispenserChain;
		VerificarGanhadorDispenser ganharDiagonalDispenser = new GanharDiagonalDispenser();
		VerificarGanhadorDispenser ganharHorizontalDispenser = new GanharHorizontalDispenser();
		VerificarGanhadorDispenser ganharVerticalDispenser = new GanharVerticalDispenser();
		
		ganharDiagonalDispenser.setNextDispenser(ganharVerticalDispenser);
		ganharVerticalDispenser.setNextDispenser(ganharHorizontalDispenser);
		dispenserChain = ganharDiagonalDispenser;
		
		dispenserChain.dispense(this);
		
		return this.isGanhouJogo();
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public boolean isGanhouJogo() {
		return ganhouJogo;
	}

	public void setGanhouJogo(boolean ganhouJogo) {
		this.ganhouJogo = ganhouJogo;
	}
	
	private String criarLinha(String[] conteudo) {
		StringBuilder str = new StringBuilder();
		
		for (int j = 0; j < conteudo.length; j++) {
			str.append("+-");
			str.append(conteudo[j] == null ? " " : conteudo[j]);
			str.append("--");
		}
		
		str.append("\n");
		return str.toString();
	}
	
	private String criarLinhaEmBranco() {
		String[] linhaConteudo = new String[this.tabuleiro.length];

		for (int i = 0; i < this.tabuleiro.length; i++) {
			linhaConteudo[i] = "-";
		}
		
		return this.criarLinha(linhaConteudo);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.criarLinhaEmBranco());
		
		for (int i = 0; i < this.tabuleiro.length; i++) {
			str.append(this.criarLinha(this.tabuleiro[i]));
			// str.append("Adicionar algo entre as linhas");
		}
		
		str.append(this.criarLinhaEmBranco());
		return str.toString();
	}
	
	
	
	
	
	
}
