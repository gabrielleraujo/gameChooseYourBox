package jogador;

public class Jogador 
{
	private int vida;
	private int pontuacao;
	private int forca;
	private String nome;
	
	public Jogador(String nome)
	{
		this.nome = nome;
		this.vida = 3;
		this.forca = 10;
		this.pontuacao = 0;
	}

	public int getVida()
	{
		return vida;
	}

	protected void setVida(int vida)
	{
		this.vida = vida;
	}

	public int getPontuacao() 
	{
		return pontuacao;
	}

	protected void setPontuacao(int pontuacao) 
	{
		this.pontuacao = pontuacao;
	}

	public int getForca() 
	{
		return forca;
	}

	protected void setForca(int forca) 
	{
		this.forca = forca;
	}

	public String getNome()
	{
		return nome;
	}
}
