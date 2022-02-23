package jogodavelha.responsabilidade;

import jogodavelha.Dominio.JogoDaVelha;

public class GanharDiagonalDispenser extends VerificarGanhadorDispenser {

	@Override
	public void dispense(JogoDaVelha jogoDaVelha) {		
		
		for (int posicao = 0; posicao < jogoDaVelha.getTabuleiro().length; posicao++)
		{
			if(posicao+1 == jogoDaVelha.getTabuleiro().length)
			{
				break;
			}
			if(jogoDaVelha.getTabuleiro()[posicao][posicao] 
					!= jogoDaVelha.getTabuleiro()[posicao+1][posicao+1]
					|| jogoDaVelha.getTabuleiro()[posicao][posicao] == null)
			{
				jogoDaVelha.setGanhouJogo(false);
				break;
			}	
		}
		jogoDaVelha.setGanhouJogo(true);
		for (int linha = jogoDaVelha.getTabuleiro().length -1; 
				linha >= 0; linha--)
		{
			for (int coluna = jogoDaVelha.getTabuleiro().length -1; 
					coluna >= 0; coluna--)
			{
				if(coluna + linha == jogoDaVelha.getTabuleiro().length -1)
				{
					if(linha+1 == jogoDaVelha.getTabuleiro().length) break;
					if (coluna-1 == -1) break;
					if(jogoDaVelha.getTabuleiro()[linha][coluna] 
							!= jogoDaVelha.getTabuleiro()[linha+1][coluna-1]
							|| jogoDaVelha.getTabuleiro()[linha][coluna] == null)
					{
						jogoDaVelha.setGanhouJogo(false);
						break;
					}
				}
			}
		}
		if(!jogoDaVelha.isGanhouJogo() && this.nextDispenser != null) this.nextDispenser.dispense(jogoDaVelha);
	}

}
