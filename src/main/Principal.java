package main;

import java.util.ArrayList;
import java.util.Scanner;

import jogodavelha.Dominio.Jogador;
import jogodavelha.Dominio.JogoDaVelha;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int NUMEROS_JOGADORES = 2;
		int linha;
		int coluna;
		int quantidadeDeJogadas = 0;
		int tamanhoTabuleiroInt = 0;
		boolean partidaFinalizada = false;
		boolean partidaEmAndamento = true;
		boolean jogadaRealizada = false;
		boolean valorValidoTamanhoTabuleiro = false;
		String tamanhoTabuleiroString = null;
		String posicao;
		String[] simbolos = {"X","O"};
		JogoDaVelha jogoCriado;
		ArrayList<Jogador> jogadores = new ArrayList<>();

		for(int x = 0; x < NUMEROS_JOGADORES; x++)
		{
			System.out.println("Digite o nome do jogador " + (x+1));
			jogadores.add(criarJogador(sc));
		}

		while(!valorValidoTamanhoTabuleiro) {
			System.out.println("Digite o tamanho do tabuleiro(Valor inteiro maior que 1):");
			tamanhoTabuleiroString = sc.next();
			boolean valorParsed = verificarInt(tamanhoTabuleiroString);
			if (valorParsed)
			{
				tamanhoTabuleiroInt = retornarValor(tamanhoTabuleiroString);
				if(tamanhoTabuleiroInt > 0) valorValidoTamanhoTabuleiro = true;
			}
		}
		System.out.println("Primeiro jogador joga com X e segundo jogador, com O");
		while(!partidaFinalizada)
		{
			jogoCriado = new JogoDaVelha(tamanhoTabuleiroInt);
			while(true)
			{
				partidaEmAndamento = true;
				while(partidaEmAndamento) {
					for (int x = 0; x < NUMEROS_JOGADORES; x++) {
						System.out.println(jogoCriado.toString());

						while(!jogadaRealizada) {
							while (true) {
								System.out.println("Jogador " + (x + 1) + ": Digite qual posicao voce quer jogar(linha,coluna)");
								posicao = sc.next();
								if (isInteger(posicao.split(",")[0])
										&& isInteger(posicao.split(",")[1])) break;
								else System.out.println("Digite posição valida!");
							}
							linha = Integer.parseInt(posicao.split(",")[0]);
							coluna = Integer.parseInt(posicao.split(",")[1]);

							jogadaRealizada = jogoCriado.realizaJogada(linha, coluna, simbolos[x]);
							if (!jogadaRealizada) System.out.println("Posicao ja ocupada! Escolha outra");
							else jogadaRealizada = true;
						}
						jogadaRealizada = false;
						if (jogoCriado.verificaGanhador()) {
							System.out.println(jogoCriado.toString());
							jogadores.get(x).setPontos(jogadores.get(x).getPontos() + 1);
							partidaEmAndamento = false;
							break;
						}
						quantidadeDeJogadas++;
						if(quantidadeDeJogadas == tamanhoTabuleiroInt*tamanhoTabuleiroInt)
						{
							System.out.println("Partida empatada!");
							partidaEmAndamento = false;
							break;
						}
					}
				}
				quantidadeDeJogadas = 0;
				break;
			}
			while(true) {
				System.out.println("Quer jogar outra partida? S/n");
				String escolhaContinuar = sc.next();
				if (escolhaContinuar.toLowerCase().compareTo("n") == 0) {
					partidaFinalizada = true;
					break;
				}
				else if (escolhaContinuar.toLowerCase().compareTo("s") == 0) break;
				System.out.println("Escolha S para sim ou N para nao");
			}
		}
		System.out.println("INFORMAÇÃO DO GANHADOR: ");
		if (jogadores.get(0).getPontos() > jogadores.get(1).getPontos())
			System.out.println(jogadores.get(0).toString());
		else if(jogadores.get(0).getPontos() < jogadores.get(1).getPontos())
			System.out.println(jogadores.get(1).toString());
		else
		{
			System.out.println("Jogadores empatadas!");
			for (Jogador jogador : jogadores)
				System.out.println(jogador.toString());

		}
		sc.close();
	}

	private static int retornarValor(String tamanhoTabuleiroString) {
		int tamanhoTabuleiro = Integer.parseInt(tamanhoTabuleiroString);
		if (tamanhoTabuleiro <= 1) {
			System.out.println("Digite um valor inteiro válido!");
			return 0;
		} else return tamanhoTabuleiro;
	}

	private static boolean verificarInt(String tamanhoTabuleiroString) {
		if (!isInteger(tamanhoTabuleiroString)) {
			System.out.println("Digite um valor inteiro válido!");
			return false;
		}
		return true;
	}

	private static Jogador criarJogador(Scanner sc) {
		String nome;
		nome = sc.next();
		return (new Jogador(nome));
	}


	private static boolean isInteger(String str) {
		return str != null && str.matches("[0-9]*");
	}

}
