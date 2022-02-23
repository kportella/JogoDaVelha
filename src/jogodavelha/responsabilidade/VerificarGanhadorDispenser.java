package jogodavelha.responsabilidade;

import jogodavelha.Dominio.JogoDaVelha;

public abstract class VerificarGanhadorDispenser {
	
	protected VerificarGanhadorDispenser nextDispenser;
	
	public void setNextDispenser(VerificarGanhadorDispenser nextDispenser)
	{
		this.nextDispenser = nextDispenser;
	}

	public abstract void dispense(JogoDaVelha jogoDaVelha);
}
