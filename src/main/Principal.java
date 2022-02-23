package main;

import java.util.Scanner;

import jogodavelha.Dominio.Jogador;
import jogodavelha.Dominio.JogoDaVelha;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean partidaFinalizada = false;
		
		System.out.println("Digite o nome do primeiro jogador");
		String nome = sc.next();
		Jogador jogador1 = new Jogador(nome);
		System.out.println("Digite o nome do segundo jogador");
		nome = sc.next();
		Jogador jogador2 = new Jogador(nome);
		
		System.out.println("Digite o tamanho do jogo");
		int tamanhoTabuleiro = sc.nextInt();
		
		JogoDaVelha jogoCriado = new JogoDaVelha(tamanhoTabuleiro);
		System.out.println("Primeiro jogador joga com X e segundo jogador, com O");
		while(!partidaFinalizada)
		{
			int linha;
			int coluna;
			String posicao;
			boolean jogoGanho = false;
			jogoCriado = new JogoDaVelha(tamanhoTabuleiro);
			while(true)
			{
				System.out.println(jogoCriado.toString());
				System.out.println("Jogador 1: Digite qual posicao voce quer jogar(linha,coluna)");
				posicao = sc.next();
				linha = Integer.parseInt(posicao.split(",")[0]);
				coluna = Integer.parseInt(posicao.split(",")[1]);
				jogoCriado.realizaJogada(linha, coluna, "X");
				if(jogoCriado.verificaGanhador())
				{
					jogador1.setPontos(jogador1.getPontos() + 1);
					break;
				}
				
				System.out.println("Jogador 2: Digite qual posicao voce quer jogar(linha,coluna)");
				posicao = sc.next();
				linha = Integer.parseInt(posicao.split(",")[0]);
				coluna = Integer.parseInt(posicao.split(",")[1]);
				jogoCriado.realizaJogada(linha, coluna, "O");
				if(jogoCriado.verificaGanhador())
				{
					jogador2.setPontos(jogador2.getPontos() + 1);
					break;
				}
				
			}
			System.out.println("Quer jogar outra partida? S/n");
			String escolhaContinuar = sc.next();
			if(escolhaContinuar.toLowerCase().compareTo("n") == 0) partidaFinalizada = true;
		}
		
		

	}

}
