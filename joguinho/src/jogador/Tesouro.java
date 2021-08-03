package jogador;

public class Tesouro extends Caixa
{
	
	public void abertura(Jogador jogador)
	{
		jogador.setPontuacao(jogador.getPontuacao() + 10);
	}

}
