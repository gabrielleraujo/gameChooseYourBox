/*
	Detalhes da implementação:
	
	O jogo possui uma array com 100 posições para ocupar 100 caixas,
	Possímos 70 caixas (algumas posições do array de caixas ficarão vazias.),
	As caixas são alocadas em posições aleatórias,
	O tipo de cada caixa também é escolhido de forma aleatória.
	Ao escolher e abir uma caixa ela fica vazia para as proximas rodadas.
*/

package jogo;
import java.util.Random;
import java.util.Scanner;

import jogador.*;

public class Jogo 
{
	private Caixa [] caixas;
	private int rodadas;
	private Scanner scn;
	
	public Jogo()
	{
		this.rodadas = 1;
	}
	
	private Caixa[] gerarArrayCaixas()
	{
		Caixa [] arrayCaixas = new Caixa[100];
		Random random = new Random();
		
		int maxCaixas = 70;
		int iCaixa;
		
		for(iCaixa = 0; iCaixa < maxCaixas; iCaixa++)
		{
			//gerar um número aleatorio para selecionar a posição para gardar a caixa
			int posicao = random.nextInt(99);
			//para selecionar um tipo de caixa
			int tipoDeCaixa = random.nextInt(2);
		
			switch(tipoDeCaixa)
			{
				case 0: 
				{
					arrayCaixas[posicao] = new Vida();
				}					
				break;
				
				case 1:
				{
					arrayCaixas[posicao] = new Dano();
				}	
				break;	
					
				case 2:
				{
					arrayCaixas[posicao] = new Tesouro();
				}			
				break;
			}
		}
		return arrayCaixas;
	}
	
	public void start(Jogador jogador1, Jogador jogador2)
	{
		this.caixas = this.gerarArrayCaixas();
		
		scn = new Scanner(System.in);
		int escolha;
		
		while(this.rodadas <= 20 && jogador1.getVida() > 0 && jogador2.getVida() > 0)
		{			
			System.out.println("_______________________________________________________");
			System.out.println("Escolha uma caixa entre 0 e 99:\n");
			System.out.print("Caixa escolhida: ");
			escolha = scn.nextInt();
			
			if(this.caixas[escolha] != null)
			{
				if(this.rodadas % 2 == 0)
				{
					this.caixas[escolha].abertura(jogador1);
					System.out.println(this.caixas[escolha]);
					
					System.out.println("Nome: " + jogador1.getNome());
					System.out.println("Rodada: " + this.rodadas);
					System.out.println("Vidas: " + jogador1.getVida());
					System.out.println("Força: " + jogador1.getForca());
					System.out.println("Pontuacao: " + jogador1.getPontuacao());
				}
				else
				{
					this.caixas[escolha].abertura(jogador2);
					System.out.println(this.caixas[escolha]);
					
					System.out.println("Nome: " + jogador2.getNome());
					System.out.println("Rodada: " + this.rodadas);
					System.out.println("Vidas: " + jogador2.getVida());
					System.out.println("Força: " + jogador2.getForca());
					System.out.println("Pontuacao: " + jogador2.getPontuacao());
				}
			}
			else
			{
				System.out.println("Caixa Vazia :p");
			}
			this.caixas[escolha] = null;
			this.rodadas += 1;
		
		}
		
		System.out.println("_________________________final_________________________");
		System.out.println(jogador1.getNome() + ":");
		System.out.println("Pontuação: " + jogador1.getPontuacao());
		System.out.println("Vidas: " + jogador1.getVida());
		System.out.println();
		System.out.println(jogador2.getNome() + ":");
		System.out.println("Pontuacao: " + jogador2.getPontuacao());
		System.out.println("Vidas: " + jogador2.getVida());
		System.out.println();
		
		if(jogador1.getPontuacao() < jogador2.getPontuacao())
		{
			System.out.println("Jogador: " + jogador1.getNome() + " é o perdedor.");
			System.out.println("Jogador: " + jogador2.getNome() + " é o vencedor, terminou a faculdade.");
		}
		else if(jogador1.getPontuacao() > jogador2.getPontuacao())
		{
			System.out.println("Jogador: " + jogador2.getNome() + " é o perdedor.");
			System.out.println("Jogador: " + jogador1.getNome() + " é o vencedor, terminou a faculdade.");
		}
		else if(jogador1.getVida() < jogador2.getVida())
		{
			System.out.println("Jogador: " + jogador1.getNome() + " é o perdedor.");
			System.out.println("Jogador: " + jogador2.getNome() + " é o vencedor, terminou a faculdade.");
		}
		else if(jogador1.getVida() > jogador2.getVida())
		{
			System.out.println("Jogador: " + jogador2.getNome() + " é o perdedor.");
			System.out.println("Jogador: " + jogador1.getNome() + " é o vencedor, terminou a faculdade.");
		}
		else if(jogador1.getForca() < jogador2.getForca())
		{
			System.out.println("Jogador: " + jogador1.getNome() + " é o perdedor.");
			System.out.println("Jogador: " + jogador2.getNome() + " é o vencedor, terminou a faculdade.");
		}
		else if(jogador1.getForca() > jogador2.getForca())
		{
			System.out.println("Jogador: " + jogador2.getNome() + " é o perdedor..");
			System.out.println("Jogador: " + jogador1.getNome() + " é o vencedor, terminou a faculdade.");
		}
		else
		{
			System.out.println("Empate.");
		}
		System.out.println("_______________________________________________________");
	}
}
