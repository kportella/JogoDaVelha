package jogodavelha.responsabilidade;

import jogodavelha.Dominio.JogoDaVelha;

public class GanharHorizontalDispenser extends VerificarGanhadorDispenser {

	@Override
	public void dispense(JogoDaVelha jogoDaVelha) {
		for (int linha = 0; linha < jogoDaVelha.getTabuleiro().length; linha++)
		{
			jogoDaVelha.setGanhouJogo(true);
			for (int coluna = 0; coluna < jogoDaVelha.getTabuleiro().length; coluna++)
			{
				if(coluna+1 == jogoDaVelha.getTabuleiro().length) break;

				if(jogoDaVelha.getTabuleiro()[linha][coluna]
						!= jogoDaVelha.getTabuleiro()[linha][coluna+1]);
				{
					jogoDaVelha.setGanhouJogo(false);
					break;
				}
			}
		}
		if(!jogoDaVelha.isGanhouJogo() && this.nextDispenser != null) this.nextDispenser.dispense(jogoDaVelha);
		
	}

	
}
