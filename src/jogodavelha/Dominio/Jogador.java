package jogodavelha.Dominio;

public class Jogador {
	private String nome;
	private Integer pontos;
	
	
	public Jogador(String nome) {
		this.nome = nome;
		this.pontos = 0;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getPontos() {
		return pontos;
	}


	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}


	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontos=" + pontos + "]";
	}
	
	

}
