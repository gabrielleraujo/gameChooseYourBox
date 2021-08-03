package main;

import jogador.*;
import jogo.*;

public class Main 
{

	public static void main(String[] args) 
	{
		Jogador jogador1 = new Jogador("Gabi");
		Jogador jogador2 = new Jogador("Felipe");
		Jogo jogo = new Jogo();
		
		jogo.start(jogador1, jogador2);
	}

}
