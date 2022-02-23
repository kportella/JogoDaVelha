package jogodavelha.responsabilidade;

import jogodavelha.Dominio.JogoDaVelha;

public class GanharVerticalDispenser extends VerificarGanhadorDispenser {

	@Override
	public void dispense(JogoDaVelha jogoDaVelha) {
		for (int coluna = 0; coluna < jogoDaVelha.getTabuleiro().length; coluna++) {
			jogoDaVelha.setGanhouJogo(true);
			for (int linha = 0; linha < jogoDaVelha.getTabuleiro().length; linha++) {
				if (linha + 1 == jogoDaVelha.getTabuleiro().length)
					break;
				if (jogoDaVelha.getTabuleiro()[linha][coluna] == null) {
					jogoDaVelha.setGanhouJogo(false);
					break;
				} else {
					if (jogoDaVelha.getTabuleiro()[linha][coluna] != jogoDaVelha.getTabuleiro()[linha + 1][coluna]) {
						jogoDaVelha.setGanhouJogo(false);
						break;
					}
				}
			}
			if (jogoDaVelha.isGanhouJogo())
				break;
		}
		if (!jogoDaVelha.isGanhouJogo() && this.nextDispenser != null)
			this.nextDispenser.dispense(jogoDaVelha);

	}

}
